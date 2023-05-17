package com.mysite.springhomework.comment;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
	
	CommentService mCommentService;
    
    public CommentController(CommentService mCommentService) {
    	this.mCommentService = mCommentService;
    }
    
    // produces : Response의 Content-Type을 제어하기 위해 사용
    @RequestMapping("/comment_list") //댓글 리스트
    private List<CommentVO> mCommentServiceList(@RequestBody CommentVO comment) throws Exception{
    	List<CommentVO> comment_list = mCommentService.commentListService(comment);
        return comment_list;
    }
    
    @RequestMapping("/comment_insert") //댓글 작성 
    private int mCommentServiceInsert(@RequestBody CommentVO comment) throws Exception{     
        return mCommentService.commentInsertService(comment);
    }
    
    @RequestMapping("/comment_update") //댓글 수정  
    private int mCommentServiceUpdateProc(@RequestBody CommentVO comment) throws Exception{
        return mCommentService.commentUpdateService(comment);
    }
    
    @RequestMapping("/comment_update_check") //댓글 수정  
    private int mCommentServiceUpdateCheck(@RequestBody CommentVO comment) throws Exception{
        return mCommentService.commentUpdateCheck(comment);
    }
    
    @RequestMapping("/comment_delete") //댓글 삭제  
    private int mCommentServiceDelete(@RequestBody CommentVO comment) throws Exception{
        return mCommentService.commentDeleteService(comment);
    }
    
    @RequestMapping("/commentreply") 
	public int commentReply(@RequestBody CommentVO comment) {
		int res = mCommentService.commentReply(comment);
		return res;
	}
	

}
