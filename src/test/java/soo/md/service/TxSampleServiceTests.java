package soo.md.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TxSampleServiceTests {
	@Autowired
	private TxSampleService service;
	
	@Test
	public void testDoDmlN() {
		//String data = "스프링";
		String data = "오늘은 왜 이렇게 오래하나요. 징글징글 하다하면 안되겠지요?";
		long len = data.getBytes().length;
		log.info("바이트수: " + len + "bytes");
		
		service.doDmlN(data);
	}
}
