package co.com.summan.route;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RouteExampleTest extends CamelTestSupport{
	@Override
	public RouteBuilder createRouteBuilder(){
		return new RouteFileExample();
	}
	
	@Test
	public void exampleTest() throws InterruptedException {
		template.sendBody("direct:ejemplo", "Hola fredis dis dis");
		Thread.sleep(5000);
		
		File file = new File("ejemplo");
		
		Exchange exchange = consumer.receive("file:ejemplo");
		
		System.out.println("Este esto es lo que tiene el body "+exchange.getIn().getBody().toString());
		System.out.println("Este esto el nombre del archivo "+exchange.getIn().getHeader("CamelFileName"));
		assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));
	} 
	
}
