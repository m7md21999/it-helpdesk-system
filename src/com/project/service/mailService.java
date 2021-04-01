package com.project.service;

public interface mailService {

	public void sendEmail(String to ,int req_id ,int user_id);
	public void notfiyEmail (String to, String subject, String msg);
}
