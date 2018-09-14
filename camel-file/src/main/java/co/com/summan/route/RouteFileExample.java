package co.com.summan.route;

import org.apache.camel.builder.RouteBuilder;

public class RouteFileExample extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("direct:ejemplo")
		.log("Este es el cuerpo del mensaje ${body} y este es la cabezera ${headers}")
		.to("file:ejemplo?fileName=output.txt");
	}

}
