Camel Project for Blueprint 
=============================

Consider the folow code to make a class:
```java

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
		
		proyectos.expectedMessageCount(1);
		desarrollo.expectedMessageCount(1);
		
		
		Exchange pr = proyectos.assertExchangeReceived(0);
		Exchange de = desarrollo.assertExchangeReceived(0);		
		
		assertEquals("proyecto proyecto 1 representado por el codigo proyecto1 tendra como comienzo el día 2018-09-05, el encargado por parte del cliente será julian gomez", pr.getIn().getBody());
		assertEquals("proyecto proyecto 1 representado por el codigo proyecto1 tendra como comienzo el día 2018-09-05, el encargado por parte del cliente será julian gomez", de.getIn().getBody());
	}
	
}
