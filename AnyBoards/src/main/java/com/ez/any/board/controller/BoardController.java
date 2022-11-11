package com.ez.any.board.controller;

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

import com.ez.any.board.model.BoardModel;
import com.ez.any.board.model.BoardParam;
import com.ez.any.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	
	
	// 로그 설정
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	
	@GetMapping("/")
	public String mainPage(Model model, HttpSession session) throws Exception {
		log.info("메인페이지 실행");
				
	    model.addAttribute("allMemberCount", boardService.getUserCount());
	    model.addAttribute("allBoardCount", boardService.getBoardCount());
    	
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

        
        int total = boardService.getBoardCount();
        
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

		System.out.println(board_no);
		return "redirect:/board/";
	}

	
}
