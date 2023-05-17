package com.mysite.springhomework.board;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
	
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/list") 
	public List<BoardVO> getBoardlist(@RequestBody Pageing pg) { 
		List<BoardVO> boardlist = boardService.getBoardList(pg.getPage_num(), pg.getLimit());
		
		return boardlist;
	}
	
	@RequestMapping("/count") 
	public int getCount() { 
		int res = boardService.getCount();
		
		return res;
	}
	
	@RequestMapping("/insert")  // @RequestBody : json기반의 메시지를 사용하는 요청의 경우 사용함
	public int insertBoard(@RequestBody BoardVO vo) {
		int res = boardService.insertBoard(vo);
	
		return res;
	}
	
	@RequestMapping("/detail") 
	public BoardVO getDetail(@RequestBody BoardVO vo) {
		BoardVO boardVo = boardService.getDetail(vo);
	
		return boardVo;
	}
	
	@RequestMapping("/update") 
	public int modifyBoard(@RequestBody BoardVO vo) {
		int res = boardService.modifyBoard(vo);
		
		return res;
	}
	
	@RequestMapping("/delete") 
	public int deleteBoard(@RequestBody BoardVO vo) {
		int res = boardService.deleteBoard(vo);
		
		return res;
	}

}
