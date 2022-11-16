package com.ez.any.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ez.any.board.model.BoardParam;
import com.ez.any.board.service.BoardService;
import com.ez.any.member.model.MemberModel;
import com.ez.any.member.service.LoginService;
import com.ez.any.member.service.MemberService;


@Controller
@RequestMapping("/member")
public class MyPageController {
	   @Autowired
	   private MemberService memberService;

	   @Autowired
	   private BoardService boardService;
	   
	   @Autowired
	   private LoginService loginService;

	// 로그 설정
	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);

	// 마이페이지
	@GetMapping("/")
	public String myPage(MemberModel memberModel, Model model, HttpServletRequest request, BoardParam boardParam) throws Exception {
	      HttpSession session = request.getSession();
	      int member_no = (Integer) session.getAttribute("member_no");
	      memberModel.setMember_no(member_no);
	      boardParam.setMember_no(member_no);
	      List<MemberModel> myPageList = memberService.myPageList(memberModel);

	      model.addAttribute("list", myPageList);

	      model.addAttribute("allBoardCount", boardService.getBoardCount(boardParam));
	      
	      System.out.println(member_no);
	      
	      return "member/myPage";
	}

	// 회원정보 수정폼
	@GetMapping("/mypageModify")
	public String modifyForm(MemberModel memberModel, Model model, HttpServletRequest request) throws Exception {
	      HttpSession session = request.getSession();
	      int member_no = (Integer) session.getAttribute("member_no");
	      memberModel.setMember_no(member_no);
	      List<MemberModel> list = memberService.myPageList(memberModel);
	      model.addAttribute("list", list);
		
		return "member/modifyForm";
	}

	// 회원정보 수정
	@PostMapping("/mypageModify")
	public String modify(MemberModel memberModel, Model model, HttpServletRequest request, HttpServletResponse response, 
						@RequestParam(value = "member_pw") String member_pw, @RequestParam(value = "member_pw1") String member_pw1) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		MemberModel member  = (MemberModel) session.getAttribute("member");
		String member_id    = member.getMember_id();
		String member_email = member.getMember_email();
		
		if (member_pw.equals(member_pw1)) {
			memberModel.setMember_id(member_id);
			memberModel.setMember_pw(member_pw);
			memberService.pwUpdate(memberModel);
			System.out.println("변경된 비밀번호 : " + memberModel.getMember_pw());
		}
		
		if (!member_email.equals(memberModel.getMember_email())) {
			memberModel.setMember_id(member_id);
			memberService.emailUpdate(memberModel);
		}
		return "redirect:/member/";
		
	}
}
