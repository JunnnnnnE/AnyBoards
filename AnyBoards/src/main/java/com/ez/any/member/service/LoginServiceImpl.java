package com.ez.any.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.any.member.mapper.MemberMapper;
import com.ez.any.member.model.MemberModel;



@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MemberMapper memberMapper;
	
	// 로그인
	@Override
	public MemberModel login(MemberModel memberModel) throws Exception {
		return memberMapper.login(memberModel);
	}
	
	// 로그인 체크
	@Override
	public MemberModel loginCheck(MemberModel memberModel) throws Exception {
		return memberMapper.loginCheck(memberModel);
	}
	
	// 로그아웃
	@Override
	public MemberModel logout(MemberModel memberModel) throws Exception {
		return memberMapper.logout(memberModel);
	}
	
	// 아이디 찾기
	@Override
	public MemberModel findId(MemberModel memberModel) throws Exception {
		return memberMapper.findId(memberModel);
	}
	
	// 비밀번호 찾기
	@Override
	public int findPw(MemberModel memberModel) throws Exception {
		return memberMapper.findPw(memberModel);
	}
}