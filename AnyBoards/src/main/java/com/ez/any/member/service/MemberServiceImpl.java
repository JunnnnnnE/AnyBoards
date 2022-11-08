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
	
	// ����������
	@Override
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception {
		return memberMapper.myPageList(memberModel);
	}

	// ȸ������
	@Override
	public void insertMember(MemberModel memberModel) {
		memberMapper.insertMember(memberModel);
	
	}
	
	// ���̵� �ߺ�üũ
	@Override
	public int checkId(String member_id) {
		
		int result = memberMapper.checkId(member_id);
		
		return result; 
	}
	
	// �г��� �ߺ�üũ
	@Override
	public int checkNick(String member_nick) {

		int result = memberMapper.checkNick(member_nick);
		
		return result;
	}

	// ȸ������ ����
	@Override
	public void deleteMember(MemberModel memberModel) {
		memberMapper.deleteMember(memberModel);
	}

	// ȸ����������
	@Override
	public void mypageModify(MemberModel memberModel){
		
		memberMapper.mypageModify(memberModel);
	}

	@Override 
	public int passChk(MemberModel memberModel){
	 
		int result = memberMapper.passChk(memberModel); 
	    return result; 
	}

	 
}
