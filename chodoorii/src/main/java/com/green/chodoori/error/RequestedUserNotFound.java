package com.green.chodoori.error;

public class RequestedUserNotFound extends RuntimeException {
	public RequestedUserNotFound(String msg) {
		super(msg);
	}
}
