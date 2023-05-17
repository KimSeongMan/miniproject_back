package com.mysite.springhomework.like;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {
	
	private LikeService likeService;
	
	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}
	
	@RequestMapping("/selectLike") 
	public int selectLike(@RequestBody LikeVO vo) { 
		int res = likeService.selectLike(vo);
		
		return res;
	}
	
	@RequestMapping("/countLike") 
	public int getCount(@RequestBody LikeVO vo) { 
		int res = likeService.getCount(vo);
		return res;
	}
	
	@RequestMapping("/insertLike")  //
	public int insertLike(@RequestBody LikeVO vo) {
		int res = likeService.insertLike(vo);
		return res;
	}
	
	@RequestMapping("/deleteLike") 
	public int deleteLike(@RequestBody LikeVO vo) {
		int res = likeService.deleteLike(vo);
		
		return res;
	}

}
