package com.mysite.springhomework.comment;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("mCommentService")
public class CommentServiceImpl implements CommentService {
	
private CommentMapper mapper;
	
	public CommentServiceImpl(CommentMapper mapper) {
		this.mapper= mapper;		
	}

	@Override
	public int commentCount(int bno) throws Exception {
		return mapper.commentCount(bno);
	}

	@Override
	public List<CommentVO> commentListService(CommentVO comment) throws Exception {
		return mapper.commentList(comment);
	}
	@Override
	public int commentInsertService(CommentVO comment) throws Exception {
		comment.setRe_ref(mapper.getMaxCno() + 1);
		return mapper.commentInsert(comment);
	}

	@Override
	public int commentUpdateService(CommentVO comment) throws Exception {
		return mapper.commentUpdate(comment);
	}
	@Override
	public int commentUpdateCheck(CommentVO comment) throws Exception {
		return mapper.commentUpdateCheck(comment);
	}

	@Override
	public int commentDeleteService(CommentVO comment) throws Exception {
		return mapper.commentDelete(comment);
	}


	@Override
	public int commentReply(CommentVO comment) {
		mapper.commentReplyUpdate_reseq(comment); // 기존 답글의 순서를 조정하는 작업(새로 추가할 답글보다 뒤애 나올 답글의 re_seq값을 1증가시켜 순서를 유지하도록 한다)
		comment.setRe_seq(comment.getRe_seq()+1); // 새로운 답글의 순서 조정(원글의 순서보다 하나 크게 함)
		comment.setRe_lev(comment.getRe_lev()+1); // 새로운 답글의 들여쓰기 조정(원글의 순서보다 한단계 들여쓰기 함)
		int res = mapper.commentReply(comment);
		return res;
	}

	

	

}
