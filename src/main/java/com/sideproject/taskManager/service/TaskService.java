package com.sideproject.taskManager.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sideproject.taskManager.bean.Task;
import com.sideproject.taskManager.exception.ResourceNotFoundException;
import com.sideproject.taskManager.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	TaskRepository tRepo;

	public List<Task> getAllTask() {
		return tRepo.findAll();
	}

	public Task createTask(Task newTask) {
		return tRepo.save(newTask);
	}

	public void deleteTask(Long id) {
		tRepo.deleteById(id);
	}

	public Task updateTask(Long id, Task t) throws ResourceNotFoundException {
		Task origin = tRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Can't locate the task id" + id));
		origin.setUpdatedAt(LocalDateTime.now());
		origin.setDueDate(t.getDueDate());
		origin.setDescription(t.getDescription());
		origin.setStatus(t.getStatus());
		origin.setTitle(t.getTitle());

		return origin;
	}

	public Task getTheTask(Long id) throws ResourceNotFoundException {
		return tRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Can't locate the task id" + id));
	}
}
