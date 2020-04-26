package com.mjk.bit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjk.bit.domain.Criteria;
import com.mjk.bit.domain.ReplyVO;
import com.mjk.bit.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_= @Autowired)
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {
		
		log.info("register......"+vo);
				
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(int bno) {
				
		log.info("get......"+bno);
		return mapper.read(bno);
	}

	@Override
	public int remove(int bno) {
	
		log.info("remove......"+bno);
		
		return mapper.delete(bno);
	}

	@Override
	public int modify(ReplyVO reply) {
		
		
		log.info("modify......"+reply);
		
		return mapper.update(reply);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		// TODO Auto-generated method stub
		
		log.info("get Reply List of a Board "+bno);
		
		return mapper.getListWithPaging(cri, bno);
	}

}
