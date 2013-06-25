package fr.kevinya.todolist.service;

import java.util.List;

import fr.kevinya.todolist.model.Task;

public interface TaskService {
	public Task create(String name);
	public Task update(Integer id, String name, Integer status);
	public void delete(Integer id);
	public Task find(Integer id);
	public List<Task> findAll();
	public Task create(Task task);
	public Task update(Integer id, Task task);
	public List<Task> findNotDeleted();
}
