package com.green.chodoori.util.mail;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.mail.MessagingException;

public interface MailServiceInterface {

	public void mailSend(String address) throws MessagingException;
	public void sendMailForIdLookUp(String address, String id) throws MessagingException;
	public void sendMailForPasswordLookUp(String address,String pw) throws MessagingException;
	public void sendMailForSharingMyResume(String to, String what, String userId) throws UnsupportedEncodingException, MessagingException;
	public Map<String, MailAuthInfoDto> getStore();
}
