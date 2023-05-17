package com.mysite.springhomework.member;

import java.util.ArrayList;


public interface MemberService {
	public int login(MemberVO member);
	public int insertMember(MemberVO member);
	public int userCheck(MemberVO memberVO);
	public ArrayList<MemberVO> getMemberlist();
	public MemberVO selectMember(MemberVO memberVO);
	public int updateMember(MemberVO memberVO);
	public int deleteMember(MemberVO memberVO);
}
