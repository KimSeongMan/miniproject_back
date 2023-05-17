package com.mysite.springhomework.member;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	MemberMapper mapper;
	
	public MemberServiceImpl (MemberMapper mapper) {  // 생성자
		this.mapper = mapper;
	}
	
	@Override
	public int login(MemberVO member) {
		int res = mapper.login(member);
		return res;
	}
	

	@Override
	public int insertMember(MemberVO member) {
		int res = mapper.insertMember(member);
		return res;
	}
	
	@Override
	public int userCheck(MemberVO memberVO) {
		int res = mapper.userCheck(memberVO);
		return res;
	}
	
	@Override
	public ArrayList<MemberVO> getMemberlist() {
		ArrayList<MemberVO> memberlist = mapper.getMemberlist();
		return memberlist;
	}
	
	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		MemberVO vo = mapper.selectMember(memberVO);
		return vo;
	}
	
	
	@Override
	public int updateMember(MemberVO memberVO) {
		int res = mapper.updateMember(memberVO);
		return res;
	}
	
	@Override
	public int deleteMember(MemberVO memberVO) {
		int res = mapper.deleteMember(memberVO);
		return res;
	}


	
}
