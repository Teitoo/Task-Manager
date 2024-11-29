package com.sideproject.taskManager.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sideproject.taskManager.repository.TaskRepository;

@SpringBootTest
public class BeanTests {
	@Autowired
	TaskRepository tRepo;
}
