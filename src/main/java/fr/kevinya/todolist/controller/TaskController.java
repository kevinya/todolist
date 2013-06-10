package fr.kevinya.todolist.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.kevinya.todolist.model.Task;
import fr.kevinya.todolist.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("")
	public @ResponseBody List<Task> index(Map<String, Object> map) {
		List<Task> taskList = taskService.findAll();
		return taskList;
	}
	
	@RequestMapping("/add/{taskName}")
	public String add(@PathVariable("taskName") String taskName) {
		taskService.create(taskName);
        return "redirect:/tasks/";
	}

	@RequestMapping("/update/{taskId}/{taskName}/{taskStatus}")
	public String update(@PathVariable("taskId") Integer taskId, @PathVariable("taskName") String taskName, @PathVariable("taskStatus") String taskStatus) {
		taskService.update(taskId, taskName, taskStatus);
        return "redirect:/tasks/";
	}

    @RequestMapping("/delete/{taskId}")
    public String delete(@PathVariable("taskId") Integer taskId) {
    	taskService.delete(taskId);
        return "redirect:/tasks/";
    }
	
}
