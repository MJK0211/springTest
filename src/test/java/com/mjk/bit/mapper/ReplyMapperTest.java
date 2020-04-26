package com.mjk.bit.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mjk.bit.domain.Criteria;
import com.mjk.bit.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.mjk.bit.config.RootConfig.class })
@Log4j
public class ReplyMapperTest {
	
	private int[] bnoArr = { 300, 299, 298, 297, 296 };
	
	@Setter(onMethod_= @Autowired)
	private ReplyMapper mapper;
	
	
	public void testMapper() {
		log.info(mapper);
	}
		
	public void testCreate() {

		IntStream.rangeClosed(1, 10).forEach(i -> {

			ReplyVO vo = new ReplyVO();

			// 게시물의 번호
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer" + i);

			mapper.insert(vo);
		});

	}
		
	public void testRead() {

		int targetRno = 5;

		ReplyVO vo = mapper.read(targetRno);

		log.info(vo);

	}
		
	public void testDelete() {

		int targetRno = 1;

		mapper.delete(targetRno);
	}
	

	
	public void testUpdate() {

		int targetRno = 10;

		ReplyVO vo = mapper.read(targetRno);

		vo.setReply("Update Reply");

		int count = mapper.update(vo);

		log.info("UPDATE COUNT: " + count);
	}
	
	@Test
	public void testList() {

		Criteria cri = new Criteria();

		// 3145745L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);

		replies.forEach(reply -> log.info(reply));

	}

	
	
	
	


}
