package com.bluelight.message;

public class MessageResponse {
	private String message;
	private Boolean flag;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public MessageResponse(String message, Boolean flag) {
		super();
		this.message = message;
		this.flag = flag;
	}

}
