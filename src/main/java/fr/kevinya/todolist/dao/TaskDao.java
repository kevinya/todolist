package fr.kevinya.todolist.dao;

import java.util.List;

import fr.kevinya.todolist.model.Task;

public interface TaskDao {
	public void create(Task task);
	public void update(Task task);
	public void delete(Task task);
	public Task find(Integer id);
	public List<Task> findAll();
	public List<Task> findNotDeleted();
}
