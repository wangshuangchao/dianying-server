package com.mugua.dianying;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardTest {
	private TestRestTemplate template = new TestRestTemplate();
	@Value("${local.server.port}")// 注入端口号
    private int port;
	
	@Test
    public void testHome(){
		String url = "http://localhost:"+port+"/";
		String result = template.getForObject(url, String.class);
		System.out.println("result:" + result);
		assertNotNull(result);
		assertTrue(result.startsWith("OK"));
	}
	
	@Test
    public void testPerson(){
        String url = "http://localhost:"+port+"/board";
        String result = template.getForObject(url, String.class);
        System.out.println("result:" + result);
        assertNotNull(result);
        assertTrue(result.startsWith("OK"));
    }
	
}
