package com.ez.any.member.model;

import java.util.Date;

public class MemberModel {
	private int member_no; // ȸ�� ���� ��ȣ
	private String member_id; // ȸ�� ���̵�
	private String member_pw; // ��й�ȣ


	private String member_name; // ȸ�� �̸�
	private String member_email; // ȸ�� �̸���
	private String member_email_check; // ȸ�� �̸��� üũ
	private String member_nick; // ȸ�� �г���
	private String member_admin; // ������ Ȯ��
	private Date member_date; // ȸ������ ��¥
	private Integer member_point; // ��� ����Ʈ
	
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_email_check() {
		return member_email_check;
	}
	public void setMember_email_check(String member_email_check) {
		this.member_email_check = member_email_check;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public String getMember_admin() {
		return member_admin;
	}
	public void setMember_admin(String member_admin) {
		this.member_admin = member_admin;
	}
	public Date getMember_date() {
		return member_date;
	}
	public void setMember_date(Date member_date) {
		this.member_date = member_date;
	}
	public Integer getMember_point() {
		return member_point;
	}
	public void setMember_point(Integer member_point) {
		this.member_point = member_point;
	}
	
	
}
