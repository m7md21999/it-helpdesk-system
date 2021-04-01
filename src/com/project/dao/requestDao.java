package com.project.dao;

import java.util.Date;
import java.util.List;

import com.project.entity.ReqSol;
import com.project.entity.Request;
import com.project.entity.User;

public interface requestDao {

	public User findUser(int user_id);
	public void createRequest(Request request);
	public void deleteRequest (int req_id);
	public void deleteRequests(int user_id);
	public void closeRequest(ReqSol reqSol);

	public List<Request> getRequests();
	public List<Request> getRequests(int user_id);
	public List<Request> getNewRequests();
	public List<Request> getNewHighPriortyRequests();
	public List<Request> getHighPriortyRequests();
	public List<Request> getAssignedRequests();
	
	public Request getRequest(int req_id);
	public ReqSol getRequestReport(int req_id);
	public ReqSol CheckRequestSoltion(int req_id);

	public void assignRequest(int req_id , int tech_id);
	public List<Request> getClosedRequests();
	
}
