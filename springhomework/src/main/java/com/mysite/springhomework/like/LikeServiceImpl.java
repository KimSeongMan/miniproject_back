package com.mysite.springhomework.like;

import org.springframework.stereotype.Service;

@Service("likeService")
public class LikeServiceImpl implements LikeService {
	
	private LikeMapper mapper;
	
	public LikeServiceImpl(LikeMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int selectLike(LikeVO like) {
		int res = mapper.selectLike(like);
		return res;
	}

	@Override
	public int getCount(LikeVO like) {
		int res = mapper.getCount(like);
		return res;
	}

	@Override
	public int insertLike(LikeVO like) {
		int res = mapper.insertLike(like);
		return res;
	}

	@Override
	public int deleteLike(LikeVO like) {
		int res = mapper.deleteLike(like);
		return res;
	}

}
