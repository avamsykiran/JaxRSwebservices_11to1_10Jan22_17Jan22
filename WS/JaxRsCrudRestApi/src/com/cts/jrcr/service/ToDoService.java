package com.cts.jrcr.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cts.jrcr.model.ToDo;
import com.cts.jrcr.repo.ToDoRepo;
import com.cts.jrcr.repo.ToDoRepoImpl;

@Path("/todos")
public class ToDoService {

	private ToDoRepo todoRepo;
	
	public ToDoService() {
		this.todoRepo=new ToDoRepoImpl();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<ToDo> getAllTodos(){
		return this.todoRepo.getAll();
	}
	
	@GET
	@Path("/{todoId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ToDo getTodoById(@PathParam("todoId") Long id){
		return this.todoRepo.getById(id);
	}
}
