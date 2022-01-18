package com.cts.jrcr.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.jrcr.model.ToDo;

public class ToDoRepoImpl implements ToDoRepo {

	private static Map<Long,ToDo> todosMap;
	
	static {
		todosMap = new TreeMap<Long, ToDo>();
		
		todosMap.put(101L,new ToDo(101L, "Create Sprint Plan", "DONE"));
		todosMap.put(102L,new ToDo(102L, "Create Sprint BackLog", "DONE"));
		todosMap.put(103L,new ToDo(103L, "Create StandUp Schedule", "ON_GOING"));
		todosMap.put(104L,new ToDo(104L, "Create Build Schedule", "PENDING"));
		todosMap.put(105L,new ToDo(105L, "Create Review Schedule", "PENDING"));
	}
	
	@Override
	public List<ToDo> getAll() {
		return new ArrayList<ToDo>(todosMap.values());
	}

	@Override
	public ToDo getById(Long id) {
		return todosMap.get(id);
	}

	@Override
	public ToDo add(ToDo todo) {
		todosMap.put(todo.getId(), todo);
		return todo;
	}

	@Override
	public ToDo update(ToDo todo) {
		todosMap.replace(todo.getId(), todo);
		return todo;
	}

	@Override
	public void deleteById(Long id) {
		todosMap.remove(id);
	}

}
