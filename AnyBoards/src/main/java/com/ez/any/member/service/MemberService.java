package com.ez.any.member.service;

import java.util.List;

import com.ez.any.member.model.MemberModel;


public interface MemberService {
	
	// 마이페이지
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception;

	// 회원탈퇴
	public void deleteMember(MemberModel memberModel);

	// 회원가입
	public void insertMember(MemberModel memberModel);

	// 아이디중복체크
	public int checkId(String member_id);
	
	// 닉네임 중복체크
	public int checkNick(String member_nick);
	
	// 회원정보 수정
	public void mypageModify(MemberModel memberModel);

	// 회원정보 수정 비밀번호 확인
	public int passChk(MemberModel memberModel);

	// 임시비밀번호 발급
	public void temPwUpdate(MemberModel memberModel);
	
	// 비밀번호 변경
	public void pwUpdate(MemberModel memberModel);
	
	// 이메일 변경
	public void emailUpdate(MemberModel memberModel);
	
	// 이메일 인증
	public int emailCheck(String member_email);
}
