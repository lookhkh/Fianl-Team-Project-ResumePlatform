package com.example.websocket.domain;

import java.util.Date;

public class SocketInfo {

	private String fromWhom;
	private String toWhom;
	private Date timestamp;
	
	
	public String getFromWhom() {
		return fromWhom;
	}
	public void setFromWhom(String fromWhom) {
		this.fromWhom = fromWhom;
	}
	public String getToWhom() {
		return toWhom;
	}
	public void setToWhom(String toWhom) {
		this.toWhom = toWhom;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "SocketInfo [fromWhom=" + fromWhom + ", toWhom=" + toWhom + ", timestamp=" + timestamp + "]";
	}
	
	
	
	
}
