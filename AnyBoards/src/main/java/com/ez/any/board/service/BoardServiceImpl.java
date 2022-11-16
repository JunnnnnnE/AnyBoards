package com.ez.any.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.any.board.mapper.BoardMapper;
import com.ez.any.board.model.BoardModel;
import com.ez.any.board.model.BoardParam;
import com.ez.any.common.file.FileUtil;
import com.ez.any.member.mapper.MemberMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	BoardMapper boardMapper;

	@Autowired
	FileUtil fileUtils;

	// 전체 이용자 수
	@Override
	public int getUserCount () {
		return boardMapper.getUserCount();
	}
	
	// 전체 게시글 수
	@Override
	public int getBoardCount(BoardParam boardParam) {
		return boardMapper.getBoardCount(boardParam);
	}

	@Override
	public List<BoardModel> boardList(BoardParam boardParam) {
		return boardMapper.boardList(boardParam);
	}

	// 게시글디테일
	@Override
	public List<BoardModel> selectBoardDetail(BoardParam boardParam) {
		boardMapper.hitCount(boardParam.getBoard_no());
		return boardMapper.selectBoardDetail(boardParam);
	}
	
	// 게시글 작성
	@Override
	public void insertBoard(BoardModel boardModel, MultipartHttpServletRequest mpRequest) throws Exception {

		boardMapper.insertBoard(boardModel);

		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(boardModel, mpRequest);

		int size = list.size();
		if (list != null) {
			for (int i = 0; i < size; i++) {
				boardMapper.insertFile(list.get(i));
				boardMapper.fileCk(boardModel);
			}
		}
	}

	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFile(int board_no) throws Exception {

		return boardMapper.selectFile(board_no);
	}
	
	// 첨부파일 추가
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		boardMapper.insertFile(map);
	}

	// 첨부파일 다운로드
	@Override
	public Map<String, Object> downFile(Map<String, Object> map) throws Exception {

		return boardMapper.downFile(map);
	}


	@Override
	public void recommendBoard(BoardModel boardModel) {
		boardMapper.recommendBoard(boardModel);
	}
	
	@Override
	public void deleteBoard(int board_no) {
		boardMapper.deleteBoard(board_no);
	}



}
