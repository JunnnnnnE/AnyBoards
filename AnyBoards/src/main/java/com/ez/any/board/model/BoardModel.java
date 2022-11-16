package com.ez.any.board.model;

import java.util.Date;

public class BoardModel {

	private int board_no;	// 게시글 번호
	private int member_no;	// 작성자 멤버번호
	private String board_title;	// 글 제목
	private String board_content;	// 글 내용
	private Date board_date;	// 글 작성일
	private int hit_count;	// 조회수
	private int like_count;	// 좋아요

	private int board_count;
	private String member_nick;
	private int board_hit_count;
	private String board_file_check;
	private String board_group_no;

	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public int getHit_count() {
		return hit_count;
	}
	public void setHit_count(int hit_count) {
		this.hit_count = hit_count;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public int getBoard_count() {
		return board_count;
	}
	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public int getBoard_hit_count() {
		return board_hit_count;
	}
	public void setBoard_hit_count(int board_hit_count) {
		this.board_hit_count = board_hit_count;
	}
	public String getBoard_file_check() {
		return board_file_check;
	}
	public void setBoard_file_check(String board_file_check) {
		this.board_file_check = board_file_check;
	}
	public String getBoard_group_no() {
		return board_group_no;
	}
	public void setBoard_group_no(String board_group_no) {
		this.board_group_no = board_group_no;
	}
	
	
	
	
	
}
