Camel Project for Blueprint 
=============================

Consider the folow code to make a class:
```java

public class Route extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		JaxbDataFormat objeto = new JaxbDataFormat();
		objeto.setContextPath("co.com.fdvergara.models");
		
		from("ftp://documentos@localhost/prueba_ftp?password=1234&ftpClient.dataTimeout=500&disconnect=true")
		.to("mock:info_ftp")
		.wireTap("direct:copy")
		.convertBodyTo(String.class)
		.to("mock:original");
		
		from("direct:copy")
		.to("mock:copy")
		.unmarshal(objeto)
		.process(new Processor() {
			
			@Override
			public void process(Exchange arg0) throws Exception {
				// TODO Auto-generated method stub
				Nomina nomina = (Nomina) arg0.getIn().getBody();
				String respuesta = "";
				
				ArrayList<Empleado> lista = nomina.getEmpl().getEmpleados();
				
				for (int i = 0; i < lista.size(); i++) {
					respuesta = respuesta + lista.get(i).datos();
				}
				arg0.getIn().setBody(respuesta);			
			}
		})
		.to("mock:copy_result");
	}

}
