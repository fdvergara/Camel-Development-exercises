package co.com.summan.beans;

import org.apache.camel.Exchange;

import co.com.summan.models.Modelo;
import co.com.summan.models.Respuesta;

public class myBean {
	public void processBean(Exchange mensaje) {
		Modelo modelo = (Modelo) mensaje.getIn().getBody();
		Double promedio = (modelo.getNota1() + modelo.getNota2() + modelo.getNota3()) / 3;
		mensaje.getIn().setHeader("promedio", promedio);
	}
	
	public void respuesta (Exchange mensaje) {
		Modelo modelo = (Modelo) mensaje.getIn().getBody();
		Respuesta respuesta = new Respuesta();
		respuesta.setNombres(modelo.getNombres());
		respuesta.setApellidos(modelo.getApellidos());
		respuesta.setCalificacion((String) mensaje.getIn().getHeader("calificacion"));
		respuesta.setNota((String) mensaje.getIn().getHeader("nota"));
		respuesta.setCurso(modelo.getCurso());
		mensaje.getIn().setBody(respuesta);
	}	
}
