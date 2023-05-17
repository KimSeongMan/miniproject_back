package com.mysite.springhomework.like;

public interface LikeService {
	public int selectLike(LikeVO like);
	public int getCount(LikeVO like);
	public int insertLike(LikeVO like);
	public int deleteLike(LikeVO like);
}
