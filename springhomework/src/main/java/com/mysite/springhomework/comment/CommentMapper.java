package com.mysite.springhomework.comment;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CommentMapper {
	
	@Select("select count(*) from table_comment where ctg=#{ctg} and bno=#{bno}")
    public int commentCount(int bno) throws Exception; // 댓글 개수
	
	@Select("select * from table_comment where ctg=#{ctg} and bno=#{bno} order by re_ref desc, re_seq asc")
    public List<CommentVO> commentList(CommentVO comment) throws Exception; // 댓글 목록
	
	@Select("select IFNULL(max(cno), 0) from table_comment ")
	public int getMaxCno();
	
	@Insert("insert into table_comment values(null,#{ctg},#{bno},#{content},#{writer},now(),#{re_ref},#{re_lev},#{re_seq})")
    public int commentInsert(CommentVO comment) throws Exception; // 댓글 저장
	
	@Update("update table_comment set content=#{content} where cno=#{cno} and writer=#{writer} ")
    public int commentUpdate(CommentVO comment) throws Exception; // 댓글 수정
	
	@Update("update table_comment set u_check=1 where cno=#{cno} and writer=#{writer}")
    public int commentUpdateCheck(CommentVO comment) throws Exception; // 댓글 수정폼 체크
	
	@Delete("delete from table_comment where cno = #{cno} and writer=#{writer}")
    public int commentDelete(CommentVO comment) throws Exception; // 댓글 삭제
	
	@Update("update table_comment set re_seq=re_seq+1 where ctg=#{ctg} and bno=#{bno} and re_ref=#{re_ref} and re_seq > #{re_seq}")
	public int commentReplyUpdate_reseq(CommentVO comment);
	
	@Insert("insert into table_comment values(null,#{ctg},#{bno},#{content},#{writer},now(),#{re_ref},#{re_lev},#{re_seq})")
	public int commentReply(CommentVO comment);

}
