package co.com.summan.route;
import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import co.com.summan.route.RouteFileSimple;

public class RouteFileSimpleTest extends CamelTestSupport{
	@Override
	public RouteBuilder createRouteBuilder () {
		return new RouteFileSimple();
	}
	
	@Test
	public void test () throws InterruptedException {
		
		template.sendBodyAndHeader("file:data/in", "Hola a todos", Exchange.FILE_NAME, "hello.txt");
		
		File  file = new File("data/in/hello.txt");
		
		Thread.sleep(5000);
		assertTrue("File is not move", file.exists());
//		assertEquals(2, file.listFiles().length);
	}
	
}
