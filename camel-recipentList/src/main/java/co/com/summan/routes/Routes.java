package co.com.summan.routes;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import co.com.summan.Model.Proyecto;

public class Routes extends RouteBuilder{

	@SuppressWarnings("deprecation")
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		DataFormat csv = new BindyCsvDataFormat(co.com.summan.Model.Proyecto.class);
		
//		from("file:proyectos?noop=true")
		from("direct:csv")
		.unmarshal(csv)
		.to("velocity://plantilla.vm")
		.recipientList(bean("co.com.summan.beans.BeansRecipienList", "destinos")).ignoreInvalidEndpoints();
//		.recipientList("direct:proyectos, direct:desarrollo");
		
		from("direct:proyectos")
		.log("proyectos")
		.log("${body}");
		
		from("direct:desarrollo")
		.log("desarrollo")
		.log("${body}");
		
		from("direct:scrummaster")
		.log("scrummaster")
		.log("${body}");
		
		from("direct:producowner")
		.log("producowner")
		.log("${body}");		
	}
}
