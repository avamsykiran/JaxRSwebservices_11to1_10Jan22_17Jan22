package com.cts.jrcr.client;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cts.jrcr.model.ToDo;

public class RestClient {
	public static void main(String a[]) {
		
		final String API_URL= "http://localhost:9090/JaxRsCrudRestApi/todos";
		
		WebTarget target = ClientBuilder.newClient().target(API_URL);
		
		ToDo todo = new ToDo(111L,"A new meeting schedule","ON_GOING");  
		Response postResp = target.request(MediaType.APPLICATION_JSON)
					.post(Entity.entity(todo, MediaType.APPLICATION_JSON));
		
		System.out.println(postResp.getStatus() +" is the status for post req");
		
		Response getResp = target.request(MediaType.APPLICATION_JSON).get();
		if(getResp.getStatus()==200) {
			getResp.readEntity(List.class).stream().forEach(System.out::println);
		}
		
		System.out.println("-------------------------------------------------------");
		Response getResp2 = target.path("/103").request(MediaType.APPLICATION_JSON).get();
		if(getResp2.getStatus()==200) {
			System.out.println(getResp2.readEntity(ToDo.class));
		}
		
	}
}
