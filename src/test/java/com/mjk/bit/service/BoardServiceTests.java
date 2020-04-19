package com.mjk.bit.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mjk.bit.domain.BoardVO;
import com.mjk.bit.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.mjk.bit.config.RootConfig.class })
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = { @Autowired })
	private BoardService service;

	public void testExist() {

		log.info(service);
		assertNotNull(service);
	}

	public void testRegister() {

		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");

		service.register(board);

		log.info("생성된 게시물의 번호: " + board.getBno());
	}

	/*
	 * public void testGetList() { service.getList().forEach(board ->
	 * log.info(board)); }
	 */

	public void testGet() {

		log.info(service.get(1));
	}

	public void testDelete() {
		log.info("REMOVE RESULT: " + service.remove(2));
	}

	public void testUpdate() {

		BoardVO board = service.get(1);

		if (board == null) {
			return;
		}

		board.setTitle("제목 수정합니다");
		log.info("MODIFY RESULT: " + service.modify(board));
	}

	@Test
	public void testGetList() {
		service.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
	}
}
