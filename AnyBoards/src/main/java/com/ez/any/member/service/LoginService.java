package com.ez.any.member.service;

import com.ez.any.member.model.MemberModel;

public interface LoginService {
	
	// �α���
	public MemberModel login(MemberModel memberModel) throws Exception;
	
	// �α��� üũ
	public MemberModel loginCheck(MemberModel memberModel) throws Exception;
	
	// �α׾ƿ�
	public MemberModel logout(MemberModel memberModel) throws Exception;
	
	// ���̵� ã��
	public MemberModel findId(MemberModel memberModel)throws Exception;
	
	// ��й�ȣ ã��
	public String findPw(MemberModel memberModel)throws Exception;


}