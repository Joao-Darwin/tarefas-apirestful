package com.apirestful.apirestful.services.execptions;

public class ResourceNotFoundExecption extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExecption(Object id) {
		super("Resource não encontrado! ID: " + id);
	}
}
