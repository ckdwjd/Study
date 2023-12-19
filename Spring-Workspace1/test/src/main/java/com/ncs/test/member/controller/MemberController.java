package com.ncs.test.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@Controller
public class MemberController {
	
	private MemberService mService;
	
	@PostMapping("/login")
	public String MemberLogin(
				@ModelAttribute Member m,
				HttpSession session,
				Model model
			) {

		Member loginUser = mService.selectOne(m);
		
		String url = "";
		
		if(loginUser != null) {
			
			model.addAttribute("loginUser", loginUser);
			
			url = "redirect:/";
			
			
		} else {
			
			model.addAttribute("msg", "로그인에 실패하였습니다.");
			
			url = "common/errorPage";
			
		}
		return "redirect:/";
	}
	

}
