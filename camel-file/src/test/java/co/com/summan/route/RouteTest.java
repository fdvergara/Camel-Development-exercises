package co.com.summan.route;

import org.apache.camel.Exchange;
import org.apache.camel.InvalidPayloadException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RouteTest extends CamelTestSupport{

	@Override
	public RouteBuilder createRouteBuilder () {
		return new Route();
	}
	
	@Test
	public void prueba () throws InterruptedException, InvalidPayloadException {
		template.sendBodyAndHeader("file:in", "CSGA01;Sales Force;Asíncrona;Carlos Vallejo;Activa;salesforce-core;CSGA01;sura-seguros-coregrales-async;hola nota", Exchange.FILE_NAME, "archivo.csv");
		
		Thread.sleep(5000);
		
		Exchange ex = consumer.receive("file:out");
	
		System.out.println("Este esto es lo que tiene el body "+ex.getIn().getBody().toString());
		
		assertInMessageBodyEquals(ex, "CSGA01; Carlos Vallejo; Activas");
	}
	
	
}
