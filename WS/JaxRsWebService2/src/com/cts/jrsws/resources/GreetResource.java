package com.cts.jrsws.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greet")
public class GreetResource {

	@GET
	@Produces({MediaType.TEXT_PLAIN})
	public String getGreetingText() {
		return "Hello Everybody";
	}	

	@GET
	@Produces({MediaType.TEXT_HTML})
	public String getGreetingHtml() {
		return "<html><body><h1>Hello Everybody</h1></body></html>";
	}

	@GET
	@Produces({MediaType.APPLICATION_XML})
	public String getGreetingXml() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <greeting>Hello Everybody</greeting>";
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String getGreetingJson() {
		return "{\"greeting\":\"Hello Everybody\"}";
	}

	
}
