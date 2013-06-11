package fr.kevinya.todolist.service;

import java.util.List;

import fr.kevinya.todolist.model.Task;

public interface TaskService {
	public void create(String name);
	public void update(Integer id, String name, Integer status);
	public void delete(Integer id);
	public Task find(Integer id);
	public List<Task> findAll();
	public void create(Task task);
	public void update(Integer id, Task task);
	public List<Task> findNotDeleted();
}
