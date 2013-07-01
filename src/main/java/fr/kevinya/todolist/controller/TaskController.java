package fr.kevinya.todolist.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.kevinya.todolist.model.Task;
import fr.kevinya.todolist.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody List<Task> index(Map<String, Object> map) {
		List<Task> taskList = taskService.findAll();
		return taskList;
	}
	
	@RequestMapping("/add")
	public @ResponseBody Task add(@RequestParam String name) {
		return taskService.create(name);
	}

	@RequestMapping("/update/{taskId}")
	public @ResponseBody Task update(@PathVariable("taskId") Integer taskId, @RequestParam String name, @RequestParam Integer status, @RequestParam Integer version) {
		return taskService.update(taskId, name, status, version);
	}

    @RequestMapping("/delete/{taskId}")
    public @ResponseBody String delete(@PathVariable("taskId") Integer taskId) {
    	taskService.delete(taskId);
    	return "";
    }

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody Task add(@RequestBody Task task) {
		return taskService.create(task);
	}

	@RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
	public @ResponseBody Task update(@PathVariable("taskId") Integer taskId) {
		return taskService.find(taskId);
	}

	@RequestMapping(value = "/{taskId}", method = RequestMethod.PUT)
	public @ResponseBody Task update(@PathVariable("taskId") Integer taskId, @RequestBody Task task) {
		return taskService.update(taskId, task);
	}

    @RequestMapping(value = "/{taskId}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteHttp(@PathVariable("taskId") Integer taskId) {
    	taskService.delete(taskId);
        return "";
    }

}
