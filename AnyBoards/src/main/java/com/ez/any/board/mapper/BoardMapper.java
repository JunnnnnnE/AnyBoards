package com.ez.any.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ez.any.board.model.BoardModel;
import com.ez.any.board.model.BoardParam;


@Mapper
public interface BoardMapper {
	
	// 전체 회원 수
	public int getUserCount();
	
	// 전체 게시글 수
	public int getBoardCount(BoardParam boardParam);

	// 게시글 리스트
	public List<BoardModel> boardList(BoardParam boardParam);

	// 게시글 디테일
	public List<BoardModel> selectBoardDetail(BoardParam boardParam);

	// 게시글 작성
	public void insertBoard(BoardModel boardModel) throws Exception;

	// 첨부파일 업로드
	public void insertFile(Map<String, Object> map) throws Exception;

	// 첨부파일 조회
	public List<Map<String, Object>> selectFile(int board_no) throws Exception;
	
	// 첨부파일 다운로드
	public Map<String, Object> downFile(Map<String, Object> map) throws Exception;

	// 추천수 증가
	public void recommendBoard(BoardModel boardModel);

	public void fileCk(BoardModel boardModel);
	
	public void deleteBoard(int board_no);
	
	// 조회수 증가
	public void hitCount(int board_no);
}
