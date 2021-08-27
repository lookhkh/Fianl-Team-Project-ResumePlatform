package com.green.chodoori.util.mail;

public enum MailServiceType {
 인증정보("인증정보"), 아이디찾기("아이디"), 비밀번호찾기("비밀번호"), 이력서공유하기("이력서");

	MailServiceType(String subname) {
		this.subname = subname;
}

	private String subname;
	
	
	public String subname() {
		return subname;
	}



}


