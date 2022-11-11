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
	public int getBoardCount();

	// 게시글 리스트
	public List<BoardModel> boardList(BoardParam boardParam);

	// 게시글 디테일
	public List<BoardModel> selectBoardDetail(BoardParam boardParam);

	// 게시글 작성
	public void insertBoard(BoardModel boardModel) throws Exception;

	// 첨부파일 업로드
	public void insertFile(Map<String, Object> map) throws Exception;

	// 추천수 증가
	public void recommendBoard(BoardModel boardModel);

	public void fileCk(BoardModel boardModel);
}
