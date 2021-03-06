package com.cts.jrcr.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.cts.jrcr.model.ToDo;
import com.cts.jrcr.repo.ToDoRepo;
import com.cts.jrcr.repo.ToDoRepoImpl;

@Path("/todos")
public class ToDoService {

	private ToDoRepo todoRepo;

	public ToDoService() {
		this.todoRepo = new ToDoRepoImpl();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ToDo> getAllTodos() {
		return this.todoRepo.getAll();
	}

	@GET
	@Path("/{todoId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getTodoById(@PathParam("todoId") Long id) {

		Response resp = null;

		ToDo todo = this.todoRepo.getById(id);

		if (todo == null)
			resp = Response.status(Status.NOT_FOUND).build();
		else
			resp = Response.ok(todo).build();

		return resp;
	}

	@DELETE
	@Path("/{todoId}")
	public Response deleteTodoById(@PathParam("todoId") Long id) {

		Response resp = null;

		ToDo todo = this.todoRepo.getById(id);

		if (todo == null)
			resp = Response.status(Status.NOT_FOUND).build();
		else {
			this.todoRepo.deleteById(id);
			resp = Response.noContent().build();
		}

		return resp;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createTodo(ToDo todo) {
		todo = this.todoRepo.add(todo);
		return Response.status(Status.CREATED).entity(todo).build();
	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response modifyTodo(ToDo todo) {
		todo = this.todoRepo.update(todo);
		return Response.status(Status.ACCEPTED).entity(todo).build();
	}
}
