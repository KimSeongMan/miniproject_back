package com.mysite.springhomework.member;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {
	
	@Select("select count(*) as 'cnt' from member where id=#{id} and pw=#{pw}")
	public int login(MemberVO member);
	
	@Insert("insert into member values (#{id}, #{pw}, #{name})")
	public int insertMember(MemberVO member);
	
	@Select("select count(*) from member where id=#{id} and password=#{password}")
	public int userCheck(MemberVO memberVO);
	
	@Select("select * from member order by id")
	ArrayList<MemberVO> getMemberlist();
	
	@Select("select * from member where id=#{id}")
	public MemberVO selectMember(MemberVO memberVO);
	
	@Update("update member set pw=#{pw},name=#{name} where id=#{id}")
	public int updateMember(MemberVO memberVO);

	@Delete("delete from member where id=#{id}")
	public int deleteMember(MemberVO memberVO);
}
