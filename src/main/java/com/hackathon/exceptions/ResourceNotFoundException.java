package com.hackathon.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	String rName;
	String fieldName;
	long fieldvalue;
	public ResourceNotFoundException(String rName, String fieldName, long fieldvalue) {
		super(String.format("%s not found with %s:%s", rName,fieldName,fieldvalue));
		this.rName = rName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public long getFieldvalue() {
		return fieldvalue;
	}
	public void setFieldvalue(long fieldvalue) {
		this.fieldvalue = fieldvalue;
	}
	
	
}
