package co.com.summan.models;

import javax.xml.bind.annotation.XmlElement;

public class estudiante {
	private String nombres;
	private String apellidos;
	private String curso;
	private String nota1;
	private String nota2;
	private String nota3;
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
	public String getNota1() {
		return nota1;
	}
	public void setNota1(String nota1) {
		this.nota1 = nota1;
	}
	public String getNota2() {
		return nota2;
	}
	public void setNota2(String nota2) {
		this.nota2 = nota2;
	}
	public String getNota3() {
		return nota3;
	}
	public void setNota3(String nota3) {
		this.nota3 = nota3;
	}
	
}
