package com.ez.any.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ez.any.board.model.BoardModel;
import com.ez.any.board.model.BoardParam;
import com.ez.any.board.service.BoardService;
import com.ez.any.common.file.FileUtil;
import com.ez.any.member.model.MemberModel;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	
	
	// 로그 설정
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	
	@GetMapping("/")
	public String mainPage(BoardModel boardModel, MemberModel memberModel, Model model, BoardParam boardParam, HttpSession session) throws Exception {
		log.info("메인페이지 실행");

	    boardParam.setMember_no(0);
	    model.addAttribute("allMemberCount", boardService.getUserCount());
	    model.addAttribute("allBoardCount", boardService.getBoardCount(boardParam));
    	
    	return "main";
	}
	
	// 게시판
	@GetMapping("/board")
	public String goBoard(Model model, BoardParam boardParam,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword,
	        @RequestParam(value="board_group_no", required = false) String board_group_no) {


        if(board_group_no == null) {
           boardParam.setBoard_group_no("1");
           board_group_no = "1";
        }

        
        int total = boardService.getBoardCount(boardParam);
        
        if (nowPage == null && cntPerPage == null) {
           nowPage = "1";
           cntPerPage = "10";
        } else if (nowPage == null) {
           nowPage = "1";
        } else if (cntPerPage == null) {
           cntPerPage = "10";
        } 
        boardParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
        if(total == 0) {
           boardParam.setEndPage(1);
        }
		
		
		model.addAttribute("paging", boardParam);
		model.addAttribute("sort", sort);
        model.addAttribute("board", boardService.boardList(boardParam));
        model.addAttribute("board_group_no",board_group_no);

		return "board/mainBoard";
	}

	// 게시글 작성 폼
	@GetMapping(value = "board/boardWrite")
	public String insertBoardForm() {
		return "board/boardWrite";
	}

	// 게시글 작성 완료
	@PostMapping(value = "board/boardWrite")
	public String insertBoard(BoardModel boardModel, HttpSession session, MultipartHttpServletRequest mpRequest)
			throws Exception {

		int member_no = (Integer) session.getAttribute("member_no");

		boardModel.setMember_no(member_no);

		boardService.insertBoard(boardModel, mpRequest);

		return "redirect:/board/";
	}

	// 게시글 내용 디테일
	@RequestMapping("board/detail")
	public String selectBoardDetail(BoardModel boardModel, HttpSession session, HttpServletResponse response,
			HttpServletRequest rq, BoardParam boardParam, Model model, @RequestParam(value = "board_no") int board_no)
			throws Exception {

        List<BoardModel> boardDetail = boardService.selectBoardDetail(boardParam);
        List<Map<String, Object>> fileList = boardService.selectFile(board_no);
        session.setAttribute("boardDetail", boardDetail);
        session.setAttribute("board_no", board_no);

        model.addAttribute("file", fileList);
        System.out.println(boardDetail);

		return "board/boardDetail";
	}

	// 첨부파일 다운로드
	@RequestMapping(value = "board/downFile")
	public void downFile(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception {
		Map<String, Object> resultMap = boardService.downFile(map);

		String storedFileName = (String) resultMap.get("STORED_FILE_NAME");
		String originalFileName = (String) resultMap.get("ORG_FILE_NAME");

		FileUtil fileUtils = new FileUtil();
		byte fileByte[] = org.apache.commons.io.FileUtils
				.readFileToByteArray(new File(fileUtils.getFilePath() + storedFileName));

		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",
				"attachment; fileName=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();

	}
	// 게시글 삭제
	@RequestMapping("board/delete")
	public String deleteBoard(@RequestParam("board_no") int board_no, RedirectAttributes redirect,
			HttpServletRequest request) {
		String referer = (String) request.getHeader("REFERER");
		System.out.println("nowUrl =" + referer);

		if (referer.contains("/board/detail")) {
			boardService.deleteBoard(board_no);
			return "redirect:/board/";
		} 
		else {
			boardService.deleteBoard(board_no);
			return "redirect:/board/";
		}
	}

	// 게시글 수정 폼
	@GetMapping(value = "board/modify")
	   public String updateBoardForm(@RequestParam(value = "board_no") int board_no, 
		         Model model, BoardParam boardParam)throws Exception{

	      boardParam.setBoard_no(board_no);
	      List<BoardModel> boardDetail = boardService.selectBoardDetail(boardParam);
	      model.addAttribute("updateBoard", boardDetail);
	      return "board/boardModify";
	}
}
