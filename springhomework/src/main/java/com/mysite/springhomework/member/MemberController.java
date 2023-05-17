package com.mysite.springhomework.member;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController //기본적으로 뷰를 봔환한다
public class MemberController {
	private MemberService memberService;
	
	public MemberController (MemberService memberService) {// MemberServiceImpl memberService
		this.memberService = memberService;
	}
	
	@RequestMapping("/login") 
	public int login(@RequestBody MemberVO vo) throws Exception {
		int res = memberService.login(vo);
	
		return res;
	} 
	
	@RequestMapping("/insertMember")
	public int insertMember(@RequestBody MemberVO vo) throws Exception {
		int res = memberService.insertMember(vo);
	
		return res;
	} 
	
	@RequestMapping("/memberlist") 
	public ArrayList<MemberVO> member_list() {  
		ArrayList<MemberVO> member_list = memberService.getMemberlist();
		return member_list;
	}
	
	
	
	@RequestMapping("/memberinfo") 
	public MemberVO memberinfo(@RequestBody MemberVO memberVO) {
		MemberVO vo = memberService.selectMember(memberVO);
		return vo;
	}
	
	@RequestMapping("/updatemember") 
	public int updateMember(@RequestBody MemberVO memberVO) throws IOException {
		int res = memberService.updateMember(memberVO);
		return res;
	}

	
	@RequestMapping("/memberdelete")
	public String deleteMember(@RequestBody MemberVO memberVO) {
		memberService.deleteMember(memberVO);
		return "redirect:/memberlist";
	}
	
}
