package com.mysite.springhomework.like;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LikeMapper {
	
	@Select("select count(*) as count from table_like where ctg=#{ctg} and bno=#{bno} and id=#{id}")
	public int selectLike(LikeVO like);
	
	@Select("select count(*) as count from table_like where ctg=#{ctg} and bno=#{bno}")
	public int getCount(LikeVO like);
	
	@Insert("insert into table_like (ctg,bno,id) values (#{ctg}, #{bno}, #{id})")
	public int insertLike(LikeVO like);
	
	@Delete("delete from table_like where ctg=#{ctg} and bno=#{bno} and id=#{id}")
	public int deleteLike(LikeVO like);

}
