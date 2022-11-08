package com.ez.any.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.any.member.model.MemberModel;


@Mapper
public interface MemberMapper {

	// �α���
	public MemberModel login(MemberModel memberModel) throws Exception;

	// �α��� üũ
	public MemberModel loginCheck(MemberModel memberModel) throws Exception;

	// �α׾ƿ�
	public MemberModel logout(MemberModel memberModel) throws Exception;

	// ���̵� ã��
	public MemberModel findId(MemberModel memberModel) throws Exception;

	// ��й�ȣ ã��
	public String findPw(MemberModel memberModel) throws Exception;

	// ����������
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception;

	// ȸ������
	void insertMember(MemberModel memberModel);

	// ���̵� �ߺ�üũ
	int checkId(String member_id);

	// �г��� �ߺ�üũ
	int checkNick(String member_nick);

	// ȸ�� Ż��
	public void deleteMember(MemberModel memberModel);

	// ������ ����
	void mypageModify(MemberModel memberModel);
	
	public int passChk(MemberModel memberModel);
}
