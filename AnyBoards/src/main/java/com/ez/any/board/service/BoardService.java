package com.ez.any.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.any.board.model.BoardModel;
import com.ez.any.member.model.MemberModel;
import com.ez.any.board.model.BoardParam;


public interface BoardService {

	// 전체 이용자 수
	public int getUserCount ();
	// 전체 게시글 수
	public int getBoardCount(BoardParam boardParam);

	// 게시글 리스트
	public List<BoardModel> boardList(BoardParam boardParam);
	
	// 게시글 상세
	public List<BoardModel> selectBoardDetail(BoardParam boardParam);

	// 게시글 작성
	public void insertBoard(BoardModel boardModel, MultipartHttpServletRequest mpRequest) throws Exception;

	// 첨부파일 조회
	public List<Map<String, Object>> selectFile(int board_no) throws Exception;
	
	// 첨부파일 추가
	public void insertFile(Map<String, Object> map) throws Exception;

	// 첨부파일 다운로드
	public Map<String, Object> downFile(Map<String, Object> map) throws Exception;
	
	// 추천수 증가
	public void recommendBoard(BoardModel boardModel);
	
	// 게시글 삭제
	public void deleteBoard(int board_no);
}
