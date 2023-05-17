package com.mysite.springhomework.comment;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

public interface CommentService {
	public int commentCount(int bno) throws Exception;
	public List<CommentVO> commentListService(CommentVO comment) throws Exception;
    public int commentInsertService(CommentVO comment) throws Exception;
    public int commentUpdateService(CommentVO comment) throws Exception;
    public int commentUpdateCheck(CommentVO comment) throws Exception;
    public int commentDeleteService(CommentVO comment) throws Exception;
	public int commentReply(CommentVO comment);

}
