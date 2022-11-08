package com.ez.any.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MyPageController {

	// 로그 설정
	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);
	
	// 마이페이지
	@GetMapping("/")
	public String myPage() throws Exception {
		return "member/myPage";
	}
}
