package co.com.summan.route;

import org.apache.camel.builder.RouteBuilder;

public class RouteFileSimple extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:data/in?noop=true")
		.to("file:data/out");
	}

}
