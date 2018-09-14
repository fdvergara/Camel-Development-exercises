package co.com.summan.beans;
import org.apache.camel.RecipientList;

public class BeansRecipienList {
	@RecipientList
	public String[] destinos () {
		String[] endpoint = {"direct:proyectos", "direct:desarrollo", "direct:scrummaster", "direct:producowner", "mock:proyectos", "mock:desarrollo", "mock:scrummaster", "mock:producowner"};
		System.out.println("========================="+endpoint);
		return endpoint;		
	}
}
