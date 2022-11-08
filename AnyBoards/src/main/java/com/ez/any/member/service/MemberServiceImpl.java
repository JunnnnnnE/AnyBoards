package com.ez.any.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.any.member.mapper.MemberMapper;
import com.ez.any.member.model.MemberModel;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;
		

	// 전체 이용자 수
	public int getUserCount () {
		return memberMapper.getUserCount();
	}
	
	// 마이페이지
	@Override
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception {
		return memberMapper.myPageList(memberModel);
	}

	// 회원가입
	@Override
	public void insertMember(MemberModel memberModel) {
		memberMapper.insertMember(memberModel);
	
	}
	
	// 아이디 중복체크
	@Override
	public int checkId(String member_id) {
		
		int result = memberMapper.checkId(member_id);
		
		return result; 
	}
	
	// 닉네임 중복체크
	@Override
	public int checkNick(String member_nick) {

		int result = memberMapper.checkNick(member_nick);
		
		return result;
	}

	// 회원정보 삭제
	@Override
	public void deleteMember(MemberModel memberModel) {
		memberMapper.deleteMember(memberModel);
	}

	// 회원정보수정
	@Override
	public void mypageModify(MemberModel memberModel){
		
		memberMapper.mypageModify(memberModel);
	}

	@Override public int passChk(MemberModel memberModel){
	 
		int result = memberMapper.passChk(memberModel); 
	    return result; 
	}

	@Override
	public int emailCheck(String member_email) {
		return memberMapper.emailCheck(member_email);
	}	 
}
