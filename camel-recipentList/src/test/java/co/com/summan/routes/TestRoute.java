package co.com.summan.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class TestRoute extends CamelTestSupport{
	@Override
	public RouteBuilder createRouteBuilder () {
		return new Routes();
	}
	
	@Test
	public void testMockProyectos ( ) throws InterruptedException {
		String mensaje = "proyecto1,proyecto 1,2018-09-05,julian gomez";
		
		Thread.sleep(2000);
		
		template.sendBody("direct:csv", mensaje);
		
		MockEndpoint proyectos = getMockEndpoint("mock:proyectos");
		MockEndpoint desarrollo = getMockEndpoint("mock:desarrollo");
		MockEndpoint scrummaster = getMockEndpoint("mock:scrummaster");
		MockEndpoint producowner = getMockEndpoint("mock:producowner");
		
		
		Exchange pr = proyectos.assertExchangeReceived(0);
		Exchange de = desarrollo.assertExchangeReceived(0);
		Exchange sc = scrummaster.assertExchangeReceived(0);
		Exchange pro = producowner.assertExchangeReceived(0);
		
		
		assertEquals("proyecto proyecto 1 representado por el codigo proyecto1 tendra como comienzo el día 2018-09-05, el encargado por parte del cliente será julian gomez", pr.getIn().getBody());
		assertEquals("proyecto proyecto 1 representado por el codigo proyecto1 tendra como comienzo el día 2018-09-05, el encargado por parte del cliente será julian gomez", de.getIn().getBody());
		assertEquals("proyecto proyecto 1 representado por el codigo proyecto1 tendra como comienzo el día 2018-09-05, el encargado por parte del cliente será julian gomez", sc.getIn().getBody());
		assertEquals("proyecto proyecto 1 representado por el codigo proyecto1 tendra como comienzo el día 2018-09-05, el encargado por parte del cliente será julian gomez", pro.getIn().getBody());
	}
	
}
