package com.ez.any.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ez.any.member.service.MemberService;


@Controller
@RequestMapping("/member")
public class MemberJoinController {

	@Autowired
	private MemberService memberService;

	private static final Logger log = LoggerFactory.getLogger(MemberJoinController.class);

	// 회원가입 화면
	@GetMapping(value = "/join")
	public String insertMemberForm() throws Exception {
		return "/member/joinForm";
	}

	// 아이디 중복확인
	@PostMapping(value = "/checkId")
	@ResponseBody
	public int checkId(String member_id) throws Exception {
		System.out.println("ddd?");
		int result = memberService.checkId(member_id);
		return result;
	}
}
