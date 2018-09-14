package co.com.summan.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;

import co.com.summan.beans.myBean;
import co.com.summan.models.Modelo;
import co.com.summan.models.estudiante;

public class Route extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		JaxbDataFormat dataformat = new JaxbDataFormat();
		dataformat.setContextPath("co.com.summan.models");
		//from("file:xml?noop=true")
		from("direct:filexml")
		.unmarshal(dataformat)
		.bean(myBean.class, "processBean")
		.choice()
		.when(simple("${headers.promedio} > 3.0 and ${headers.promedio} < 4.5"))
			.setHeader("nota", simple("Felicidades"))
			.setHeader("calificacion", simple("Aprobado"))
			.bean(myBean.class, "respuesta")
		.when(simple("${headers.promedio} >= 4.5"))
			.setHeader("nota", simple("Felicidades, eres uno de los mejores"))
			.setHeader("calificacion", simple("Aprobado"))
			.bean(myBean.class, "respuesta")			
		.otherwise()
			.setHeader("nota", simple("Tienes que hacer mas esfuerzo"))
			.setHeader("calificacion", simple("Reprobado"))
			.bean(myBean.class, "respuesta")
		.end()
		.to("velocity://plantilla/plantilla.vm")
		.to("mock:velocity");
		//.log("${body}");
	}

}
