package com.rest.controllers;

public class NoEmpFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String id;

	NoEmpFoundException(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
