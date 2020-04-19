package com.mjk.bit.mapper;

import java.util.List;

import com.mjk.bit.domain.BoardVO;
import com.mjk.bit.domain.Criteria;

public interface BoardMapper {
	
	//public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(int bno);
	
	public int delete(int bno);
		
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);
}
