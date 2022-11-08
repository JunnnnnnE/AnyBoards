package com.ez.any.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ez.any.member.model.MemberModel;
import com.ez.any.member.service.LoginService;
import com.ez.any.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private MemberService memberService;

	// 로그 설정
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	// 로그인
	@GetMapping("/login")
	public String login() throws Exception {
		return "member/loginForm";
	}

	@RequestMapping("/login")
	public ModelAndView loginCheck(MemberModel memberModel, HttpSession session, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		ModelAndView mv = new ModelAndView();
				
		MemberModel member = loginService.login(memberModel);
		
		System.out.println("==========================================");
		System.out.println("MEMBER :" + member);
		System.out.println("==========================================");
		PrintWriter out = response.getWriter();
				
    	if(member != null) {
            session.setAttribute("member", member);
    		mv.setViewName("redirect:/");
    	} else {
    		session.setAttribute("member", null);
    		out.println("<script type='text/javascript'>alert('로그인 정보를 확인할 수 없습니다. 다시 로그인 해주세요.')</script>");
    		out.flush();
	    	mv.setViewName("member/loginForm");
    	}    			
    	return mv;
	}

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) throws Exception {
		session.invalidate();
        return "redirect:/";
    }

	
}
