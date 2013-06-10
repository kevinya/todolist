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
		Task task = new Task(name, "en cours");
		taskDao.create(task);
	}

	@Transactional
	public void update(Integer id, String name) {
		Task task = find(id);
		if (task != null) {
			task.setName(name);
			taskDao.update(task);
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

}
