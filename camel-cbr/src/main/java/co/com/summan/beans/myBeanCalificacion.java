package co.com.summan.beans;

import org.apache.camel.Exchange;

import co.com.summan.models.Modelo;
import co.com.summan.models.Respuesta;

public class myBeanCalificacion {
	public void procesos (Exchange mensaje) {
		Modelo modelo = (Modelo) mensaje.getIn().getBody();
		Respuesta respuesta = new Respuesta();
		respuesta.setNombres(modelo.getNombres());
		respuesta.setApellidos(modelo.getApellidos());
		respuesta.setCalificacion((String) mensaje.getIn().getHeader("promedio"));
		respuesta.setNota(mensaje.getIn().getHeader("mensaje").toString());
	}
}
