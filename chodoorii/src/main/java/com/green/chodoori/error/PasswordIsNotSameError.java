package com.green.chodoori.error;

public class PasswordIsNotSameError extends RuntimeException  {
	public PasswordIsNotSameError(String msg) {
		super(msg);
	}
}
