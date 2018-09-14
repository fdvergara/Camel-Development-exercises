Camel Project for Blueprint 
=============================

Consider the folow code to make a class:
```java

public class RouteTest extends CamelTestSupport{

	@Override
	public RouteBuilder createRouteBuilder () {
		return new Route();
	}
	
	@Test
	public void prueba () throws InterruptedException, InvalidPayloadException {
		template.sendBodyAndHeader("file:in", "CSGM02;RUTA CAMEL;Asíncrona;Pepito Pepe;Activa;prueba;CSGM02;perfil;nota", Exchange.FILE_NAME, "archivo.csv");
		
		Thread.sleep(2000);
		
		MockEndpoint mock = getMockEndpoint("mock:content");

		Exchange exchange = mock.assertExchangeReceived(0);
		assertEquals("CSGM02;Pepito Pepe;Activa",exchange.getIn().getBody());
	}
	
	
}
