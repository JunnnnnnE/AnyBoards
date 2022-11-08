package com.ez.any;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ez.any.member.service.MemberService;

@Controller
public class MainPageController {

	@Autowired
	MemberService memberservice;
	
	private static final Logger log = LoggerFactory.getLogger(MainPageController.class);
	
	@GetMapping("/")
	public String mainPage(Model model, HttpSession session) throws Exception {
		log.info("메인페이지 실행");

	    model.addAttribute("allMemberCount", memberservice.getUserCount());
		            
    	
    	return "main";
	}
	
}
