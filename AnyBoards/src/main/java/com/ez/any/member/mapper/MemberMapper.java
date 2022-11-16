package com.ez.any.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.any.member.model.MemberModel;


@Mapper
public interface MemberMapper {

	// 전체 이용자 수
	public int getUserCount();
	
	// 로그인
	public MemberModel login(MemberModel memberModel) throws Exception;

	// 로그인 체크
	public MemberModel loginCheck(MemberModel memberModel) throws Exception;

	// 로그아웃
	public MemberModel logout(MemberModel memberModel) throws Exception;

	// 아이디 찾기
	public MemberModel findId(MemberModel memberModel) throws Exception;

	// 비밀번호 찾기
	public int findPw(MemberModel memberModel) throws Exception;

	// 마이페이지
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception;

	// 회원가입
	void insertMember(MemberModel memberModel);

	// 아이디 중복체크
	int checkId(String member_id);

	// 닉네임 중복체크
	int checkNick(String member_nick);

	// 회원 탈퇴
	public void deleteMember(MemberModel memberModel);

	// 내정보 수정
	void mypageModify(MemberModel memberModel);

	public int passChk(MemberModel memberModel);
	
	//임시 비밀번호 발급
	public void temPwUpdate(MemberModel memberModel);

	// 비밀번호 변경
	public void pwUpdate (MemberModel memberModel);
	
	// 이메일 변경
	public void emailUpdate (MemberModel memberModel);
	
	// 이메일 인증
	public int emailCheck(String member_email);
}
