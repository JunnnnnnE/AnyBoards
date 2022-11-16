package com.ez.any.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	//비밀번호 암호화,복호화
	@Autowired
    PasswordEncoder passwordEncoder;
	
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
            session.setAttribute("member_no", member.getMember_no());
            session.setAttribute("member_admin", member.getMember_admin());
            session.setAttribute("member_id", member.getMember_id());
            session.setAttribute("member_nick", member.getMember_nick());
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

    // id 찾기
    @GetMapping("/findId")
    public String findIdForm() throws Exception {
    	return "member/findIdForm";
	}
    
    @PostMapping("/findId")
    public String findId(MemberModel memberModel, HttpSession session, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		
		MemberModel findId = loginService.findId(memberModel);
		System.out.println(findId);
		session.setAttribute("findId", findId);
    	return "member/findId";
    }

    // id 찾기
    @GetMapping("/findPw")
    public String findPwForm() throws Exception {
    	return "member/findPwForm";
	}
    
    @PostMapping("/findPw")
    public String findPw(MemberModel memberModel, HttpSession session, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");

    	String randomPw = getRandom(10); //사용자에게 보여줄 임시 비밀번호
    	int memberChk = loginService.findPw(memberModel);
    	if (memberChk != 0) {
        	memberModel.setMember_pw(randomPw);	
        	memberService.temPwUpdate(memberModel);
    	}
    	else {
    		randomPw = null;
    	}

		System.out.println(randomPw);
		session.setAttribute("findPw", randomPw);
    	return "member/findPw";	

    	
    }

	private String getRandom(int i) {
		String theAlphaNumericS;
		StringBuilder builder;

		theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";

		// create the StringBuffer
		builder = new StringBuilder(i);

		for (int m = 0; m < i; m++) {

			// generate numeric
			int myindex = (int) (theAlphaNumericS.length() * Math.random());

			// add the characters
			builder.append(theAlphaNumericS.charAt(myindex));
		}

		return builder.toString();
	}    
	
}
