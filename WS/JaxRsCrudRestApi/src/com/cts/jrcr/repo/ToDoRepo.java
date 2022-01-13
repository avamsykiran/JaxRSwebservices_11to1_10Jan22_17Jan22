package com.cts.jrcr.repo;

import java.util.List;

import com.cts.jrcr.model.ToDo;

public interface ToDoRepo {
	List<ToDo> getAll();
	ToDo getById(Long id);
	ToDo add(ToDo todo);
	ToDo update(ToDo todo);
	void deleteById(Long id);
}
