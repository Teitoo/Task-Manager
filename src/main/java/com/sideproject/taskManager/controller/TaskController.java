package com.sideproject.taskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sideproject.taskManager.bean.Task;
import com.sideproject.taskManager.exception.ResourceNotFoundException;
import com.sideproject.taskManager.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	@Autowired
	TaskService tService;

	@GetMapping("/all")
	public List<Task> getAll() {
		return tService.getAllTask();
	}

	@PostMapping("/add")
	public Task addTask(@RequestBody Task t) {
		return tService.createTask(t);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTask(@PathVariable Long id) {
		tService.deleteTask(id);
	}
	
	@PutMapping("/update/{id}")
	public Task updateTask(@RequestBody Task t, @PathVariable Long id) throws ResourceNotFoundException {
		return tService.updateTask(id, t);
	}
}
