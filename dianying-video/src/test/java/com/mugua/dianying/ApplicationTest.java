package com.mugua.dianying;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mugua.dianying.common.utils.ObjectId;
import com.mugua.dianying.controller.BoardController;
import com.mugua.dianying.entity.Board;
import com.mugua.dianying.mapper.BoardMapper;
import com.mugua.dianying.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类  
public class ApplicationTest {

	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardController boardController;
	@Test
	public void test(){
		
		
		
//		Board board =new Board();
//		board.setSysId("3");
//		boardController.insert();
//		boardService.insert(board);
//		boardMapper.insert(board);
		System.out.println(ObjectId.getObjectId());
		System.out.println(ObjectId.getObjectId());
		System.out.println(ObjectId.getObjectId());
		System.out.println(ObjectId.getObjectId());
		System.out.println(ObjectId.getObjectId());
		System.out.println(ObjectId.getObjectId());
		System.out.println(ObjectId.getObjectId());
	}
}
