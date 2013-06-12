package fr.kevinya.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.kevinya.todolist.dao.TaskDao;
import fr.kevinya.todolist.model.Task;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskDao taskDao;

	@Transactional
	public void create(String name) {
		Task task = new Task(name, 0);
		taskDao.create(task);
	}

	@Override
	public void create(Task task) {
		Task currentTask = new Task(task.getName(), task.getStatus());
		taskDao.create(currentTask);
	}

	@Transactional
	public void update(Integer id, String name, Integer status) {
		Task task = find(id);
		if (task != null) {
			task.setName(name);
			task.setStatus(status);
			task.setVersion(task.getVersion() + 1);
			taskDao.update(task);
		}
	}

	@Transactional
	public void update(Integer id, Task task) {
		Task currentTask = find(id);
		if (currentTask != null) {
			currentTask.setName(task.getName());
			currentTask.setStatus(task.getStatus());
			currentTask.setVersion(currentTask.getVersion() + 1);
			taskDao.update(currentTask);
		}
	}

	@Transactional
	public void delete(Integer id) {
		Task task = find(id);
		if (task != null) {
			taskDao.delete(task);
		}
	}

	@Transactional
	public Task find(Integer id) {
		return taskDao.find(id);
	}

	@Transactional
	public List<Task> findAll() {
		return taskDao.findAll();
	}

	@Transactional
	public List<Task> findNotDeleted() {
		return taskDao.findNotDeleted();
	}

}
