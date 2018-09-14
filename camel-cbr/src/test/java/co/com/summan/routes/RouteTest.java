package co.com.summan.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RouteTest extends CamelTestSupport{
	@Override
	public RouteBuilder createRouteBuilder () {
		return new Route();
	}
	
	@Test
	public void testWhen1 () throws InterruptedException {
		String textXml = "<?xml version='1.0' encoding='UTF-8'?><estudiante><nombres>Fredis David</nombres><apellidos>Vergara Giraldo</apellidos><curso>Desarrollo web</curso><calificacion1>3.0</calificacion1><calificacion2>2.4</calificacion2><calificacion3>3.9</calificacion3></estudiante>";
		Thread.sleep(2000);
		template.sendBody("direct:filexml", textXml);
		
		MockEndpoint mockVelocity  = getMockEndpoint("mock:velocity");
		mockVelocity.expectedMessageCount(1);
	
		
		Exchange exchange = mockVelocity.assertExchangeReceived(0);
		assertEquals("<?xml version='1.0' encoding='UTF-8'?><estudiante><nombres>Fredis David</nombres><apellidos>Vergara Giraldo</apellidos><mensaje>Desarrollo web</mensaje><curso>Aprobado</curso><comentario>Felicidades</comentario></estudiante>", exchange.getIn().getBody());
	}
	
	@Test
	public void testWhen2 () throws InterruptedException {
		String textXml = "<?xml version='1.0' encoding='UTF-8'?><estudiante><nombres>Fredis David</nombres><apellidos>Vergara Giraldo</apellidos><curso>Desarrollo web</curso><calificacion1>5.0</calificacion1><calificacion2>4.8</calificacion2><calificacion3>4.5</calificacion3></estudiante>";
		Thread.sleep(2000);
		template.sendBody("direct:filexml", textXml);
		
		MockEndpoint mockVelocity  = getMockEndpoint("mock:velocity");
		mockVelocity.expectedMessageCount(1);
	
		
		Exchange exchange = mockVelocity.assertExchangeReceived(0);
		assertEquals("<?xml version='1.0' encoding='UTF-8'?><estudiante><nombres>Fredis David</nombres><apellidos>Vergara Giraldo</apellidos><mensaje>Desarrollo web</mensaje><curso>Aprobado</curso><comentario>Felicidades, eres uno de los mejores</comentario></estudiante>", exchange.getIn().getBody());
	}	
	
	@Test
	public void testWhen3 () throws InterruptedException {
		String textXml = "<?xml version='1.0' encoding='UTF-8'?><estudiante><nombres>Fredis David</nombres><apellidos>Vergara Giraldo</apellidos><curso>Desarrollo web</curso><calificacion1>2.0</calificacion1><calificacion2>2.8</calificacion2><calificacion3>2.5</calificacion3></estudiante>";
		Thread.sleep(2000);
		template.sendBody("direct:filexml", textXml);
		
		MockEndpoint mockVelocity  = getMockEndpoint("mock:velocity");
		mockVelocity.expectedMessageCount(1);
	
		
		Exchange exchange = mockVelocity.assertExchangeReceived(0);
		assertEquals("<?xml version='1.0' encoding='UTF-8'?><estudiante><nombres>Fredis David</nombres><apellidos>Vergara Giraldo</apellidos><mensaje>Desarrollo web</mensaje><curso>Reprobado</curso><comentario>Tienes que hacer mas esfuerzo</comentario></estudiante>", exchange.getIn().getBody());
	}		
	
}
