package com.ez.any.member.service;

import com.ez.any.member.model.MemberModel;

public interface LoginService {

	// 로그인
	public MemberModel login(MemberModel memberModel) throws Exception;

	// 로그인 체크
	public MemberModel loginCheck(MemberModel memberModel) throws Exception;

	// 로그아웃
	public MemberModel logout(MemberModel memberModel) throws Exception;
	
	// 아이디 찾기
	public MemberModel findId(MemberModel memberModel)throws Exception;
	
	// 비밀번호 찾기
	public int findPw(MemberModel memberModel)throws Exception;
	

}