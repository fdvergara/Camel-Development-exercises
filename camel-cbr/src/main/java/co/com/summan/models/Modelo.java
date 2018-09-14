package co.com.summan.models;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="estudiante")
@XmlAccessorType(XmlAccessType.FIELD)
public class Modelo implements Serializable{
	@XmlElement(name="nombres")
	private String nombres;
	@XmlElement(name="apellidos")
	private String apellidos;
	@XmlElement(name="curso")
	private String curso;
	@XmlElement(name="calificacion1")
	private Double nota1;
	@XmlElement(name="calificacion2")
	private Double nota2;
	@XmlElement(name="calificacion3")
	private Double nota3;
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Double getNota1() {
		return nota1;
	}
	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}
	public Double getNota2() {
		return nota2;
	}
	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}
	public Double getNota3() {
		return nota3;
	}
	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}
	
	
}
