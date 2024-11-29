package com.sideproject.taskManager.exception;

import lombok.Getter;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends Exception {
	@Getter
	String error;

	public ResourceNotFoundException(String error) {
		this.error = error;
	}
}
