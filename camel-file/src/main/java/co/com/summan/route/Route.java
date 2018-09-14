package co.com.summan.route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import co.com.summan.model.Mediaciones;

public class Route extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		DataFormat bindy = new BindyCsvDataFormat(co.com.summan.model.Mediaciones.class);

		from("file:in?noop=true")
		.unmarshal(bindy)
		.log("${body}")
		.process(new Processor() {
			
			@Override
			public void process(Exchange arg0) throws Exception {
				// TODO Auto-generated method stub
				//Map<String, Object> mediaciones = (Map<String, Object>) arg0.getIn().getBody();
				ArrayList<Mediaciones> mediaciones = (ArrayList<Mediaciones>) arg0.getIn().getBody();
				List<Map<String, Object>> list = new ArrayList<>();
				
				for (int i = 0; i < mediaciones.size(); i++) {
					Map<String, Object> objeto = new HashMap<>();
					objeto.put("resultado", mediaciones.get(i).resultado());
					list.add(i, objeto);
					System.out.println(mediaciones.get(i).resultado());
				}
				arg0.getIn().setBody(list);
			}
		})
		.marshal().csv()
		.to("file:out");
		
	}
}