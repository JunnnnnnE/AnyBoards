package com.ez.any.member.service;

import java.util.List;

import com.ez.any.member.model.MemberModel;


public interface MemberService {
	
	// ����������
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception;

	// ȸ��Ż��
	public void deleteMember(MemberModel memberModel);

	// ȸ������
	public void insertMember(MemberModel memberModel);

	// ���̵��ߺ�üũ
	public int checkId(String member_id);
	
	// �г��� �ߺ�üũ
	public int checkNick(String member_nick);
	
	// ȸ������ ����
	public void mypageModify(MemberModel memberModel);

	public int passChk(MemberModel memberModel);

}
