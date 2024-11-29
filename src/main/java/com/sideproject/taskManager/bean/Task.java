package com.sideproject.taskManager.bean;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus status = TaskStatus.TODO;
	
	private LocalDateTime dueDate;
	
	private LocalDateTime createdAt = LocalDateTime.now();
	
	private LocalDateTime updatedAt = LocalDateTime.now();
}
