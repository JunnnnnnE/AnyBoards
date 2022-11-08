package com.ez.any.member.controller;

import java.io.PrintWriter;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ez.any.member.model.MemberModel;
import com.ez.any.member.service.MemberService;


@Controller
@RequestMapping("/member")
public class MemberJoinController {

	@Autowired
	private MemberService memberService;

	@Autowired
	JavaMailSender mailSender;

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
	
	// 닉네임 중복확인
	@PostMapping(value = "/checkNick")
	@ResponseBody
	public int checkNick(String member_nick) throws Exception {
		System.out.println("ddd?");
		int result = memberService.checkNick(member_nick);
		return result;
	}

	@GetMapping("/mailCheck")
	@ResponseBody
	public String mailCheck(@RequestParam("member_email") String member_email) throws Exception {
		int serti = (int) ((Math.random() * (99999 - 10000 + 1)) + 10000);
		System.out.println("member_email = " + member_email);
		String from = "anyboard0328@naver.com";
		String to = member_email;
		String title = "회원가입시 필요한 인증번호 입니다.";
		String content = "[인증번호] " + serti + " 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
		String num = "";

		int emailCheck = memberService.emailCheck(member_email);

		// 만약 이메일 중복이 없을 경우
		try {
			if (emailCheck == 0) {
				MimeMessage mail = mailSender.createMimeMessage();
				MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

				mailHelper.setFrom(from);
				mailHelper.setTo(to);
				mailHelper.setSubject(title);
				mailHelper.setText(content, true);

				mailSender.send(mail);
				num = Integer.toString(serti);

			} else  { // 만약 이메일 중복일 경우
				return num = "checkFail";
			}
		} catch (Exception e) {
			num = "error";
		}

		return num;
	}

	// 회원가입 완료
	@PostMapping(value = "/join")
	public String insertMember(MemberModel memberModel, HttpServletResponse response) throws Exception {
		memberModel.setMember_email_check("Y");
		memberService.insertMember(memberModel);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>alert('회원가입이 완료되었습니다. 다시 로그인 해주세요.')</script>");
		out.flush();
		return "/member/loginForm";
	}

}
