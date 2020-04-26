package com.mjk.bit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mjk.bit.domain.Criteria;
import com.mjk.bit.domain.ReplyVO;

public interface ReplyService {
	public int register(ReplyVO vo);

	public ReplyVO get(int bno);

	public int remove(int bno);

	public int modify(ReplyVO reply);

	public List<ReplyVO> getList(Criteria cri, @Param("bno") int bno);
}
