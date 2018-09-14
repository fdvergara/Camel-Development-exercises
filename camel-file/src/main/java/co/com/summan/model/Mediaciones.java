package co.com.summan.model;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator=";", crlf="UNIX",  quote = ";")
public class Mediaciones {

	@DataField(pos=1, position=9)
	private String id;
	
	@DataField(pos=2, position=8)
	private String nombre;
	
	@DataField(pos=3, position=7)
	private String tipo;
	
	@DataField(pos=4, position=6)
	private String analista;
	
	@DataField(pos=5, position=5)
	private String estado;
	
	@DataField(pos=6, position=4)
	private String artifacctory;
	
	@DataField(pos=7, position=3)
	private String rutasPor;
	
	@DataField(pos=8, position=2)
	private String perfil;
	
	@DataField(pos=9, position=1)
	private String notas;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String resultado () {
		return this.id + "; " + this.analista + "; " + this.estado;
		
	}
}