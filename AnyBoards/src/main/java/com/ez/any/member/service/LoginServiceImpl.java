package com.ez.any.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.any.member.mapper.MemberMapper;
import com.ez.any.member.model.MemberModel;



@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MemberMapper memberMapper;
	
	// �α���
	@Override
	public MemberModel login(MemberModel memberModel) throws Exception {
		return memberMapper.login(memberModel);
	}
	
	// �α��� üũ
	@Override
	public MemberModel loginCheck(MemberModel memberModel) throws Exception {
		return memberMapper.loginCheck(memberModel);
	}
	
	// �α׾ƿ�
	@Override
	public MemberModel logout(MemberModel memberModel) throws Exception {
		return memberMapper.logout(memberModel);
	}
	
	// ���̵� ã��
	@Override
	public MemberModel findId(MemberModel memberModel) throws Exception {
		return memberMapper.findId(memberModel);
	}
	
	// ��й�ȣ ã��
	@Override
	public String findPw(MemberModel memberModel) throws Exception {
		return memberMapper.findPw(memberModel);
	}



	
}