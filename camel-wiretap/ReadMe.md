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
	public void testFtpComponent () throws InterruptedException {
		MockEndpoint ftp_mock = getMockEndpoint("mock:info_ftp");
		
		Thread.sleep(2000);
		
		ftp_mock.expectedMessageCount(1);
		
		Exchange ftp_ex = ftp_mock.assertExchangeReceived(0);
		
		assertEquals("nomina.xml", ftp_ex.getIn().getHeader("CamelFileName"));
	}
	
	@Test
	public void testWireTap() throws InterruptedException {
		
		//Validate that mock: copy received the copy of messages
		
		MockEndpoint copy = getMockEndpoint("mock:copy");
		
		Thread.sleep(2000);
		
		copy.expectedMessageCount(1);
		
		Exchange copy_ex = copy.assertExchangeReceived(0);
		
		assertEquals("nomina.xml", copy_ex.getIn().getHeader("CamelFileName"));
				
		copy.message(0).body().isEqualTo("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<nomina>\r\n" + 
				"	<empleados>\r\n" + 
				"		<empleado>\r\n" + 
				"			<nombres>Fredis David</nombres>\r\n" + 
				"			<apellidos>Vergara Giraldo</apellidos>\r\n" + 
				"			<correo>correo1@correo.com</correo>\r\n" + 
				"			<documento>123456</documento>\r\n" + 
				"			<aportes>\r\n" + 
				"				<salud>50000</salud>\r\n" + 
				"				<pension>50000</pension>\r\n" + 
				"			</aportes>\r\n" + 
				"			<subtotal>800000</subtotal>\r\n" + 
				"			<total>700000</total>\r\n" + 
				"		</empleado>\r\n" + 
				"		<empleado>\r\n" + 
				"			<nombres>Pepito</nombres>\r\n" + 
				"			<apellidos>Garcia</apellidos>\r\n" + 
				"			<correo>correo2@correo.com</correo>\r\n" + 
				"			<documento>246810</documento>\r\n" + 
				"			<aportes>\r\n" + 
				"				<salud>50000</salud>\r\n" + 
				"				<pension>50000</pension>\r\n" + 
				"			</aportes>\r\n" + 
				"			<subtotal>800000</subtotal>\r\n" + 
				"			<total>700000</total>\r\n" + 
				"		</empleado>\r\n" + 
				"	</empleados>\r\n" + 
				"</nomina>");
		
		// Validate transform from the message
		
		MockEndpoint copy_result = getMockEndpoint("mock:copy_result");
		
		copy_result.expectedMessageCount(1);
		
		Exchange copy_result_ex = copy_result.assertExchangeReceived(0);
				
		assertEquals("Fredis David,Vergara Giraldo,123456,700000\r\n" + 
				"Pepito,Garcia,246810,700000\r\n", copy_result_ex.getIn().getBody());
	}
	
	@Test
	public void testOriginalMessage () throws InterruptedException {
		MockEndpoint original = getMockEndpoint("mock:original");
		
		Thread.sleep(2000);
								
		original.assertIsSatisfied();
		
		Exchange original_ex = original.assertExchangeReceived(0);
		
		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<nomina>\r\n" + 
				"	<empleados>\r\n" + 
				"		<empleado>\r\n" + 
				"			<nombres>Fredis David</nombres>\r\n" + 
				"			<apellidos>Vergara Giraldo</apellidos>\r\n" + 
				"			<correo>correo1@correo.com</correo>\r\n" + 
				"			<documento>123456</documento>\r\n" + 
				"			<aportes>\r\n" + 
				"				<salud>50000</salud>\r\n" + 
				"				<pension>50000</pension>\r\n" + 
				"			</aportes>\r\n" + 
				"			<subtotal>800000</subtotal>\r\n" + 
				"			<total>700000</total>\r\n" + 
				"		</empleado>\r\n" + 
				"		<empleado>\r\n" + 
				"			<nombres>Pepito</nombres>\r\n" + 
				"			<apellidos>Garcia</apellidos>\r\n" + 
				"			<correo>correo2@correo.com</correo>\r\n" + 
				"			<documento>246810</documento>\r\n" + 
				"			<aportes>\r\n" + 
				"				<salud>50000</salud>\r\n" + 
				"				<pension>50000</pension>\r\n" + 
				"			</aportes>\r\n" + 
				"			<subtotal>800000</subtotal>\r\n" + 
				"			<total>700000</total>\r\n" + 
				"		</empleado>\r\n" + 
				"	</empleados>\r\n" + 
				"</nomina>", original_ex.getIn().getBody());
	}
}
