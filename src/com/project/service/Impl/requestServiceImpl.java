package com.project.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.requestDao;
import com.project.entity.ReqSol;
import com.project.entity.Request;
import com.project.entity.User;
import com.project.service.requestService;

@Service("rService")
public class requestServiceImpl implements requestService {

	@Autowired
	private requestDao rDao;
	
	@Override
	@Transactional
	public List<Request> getRequests() {
		return rDao.getRequests();
	}

	@Override
	@Transactional
	public List<Request> getRequests(int user_id) {
		return rDao.getRequests(user_id);
	}

	@Override
	@Transactional
	public List<Request> getNewRequests() {
		return rDao.getNewRequests();
	}

	@Override
	@Transactional
	public List<Request> getNewHighPriortyRequests() {
		return rDao.getNewHighPriortyRequests();
	}

	@Override
	@Transactional
	public List<Request> getHighPriortyRequests() {
		return rDao.getHighPriortyRequests();
	}

	@Override
	@Transactional
	public List<Request> getAssignedRequests() {
		return rDao.getAssignedRequests();
	}

	@Override
	@Transactional
	public Request getRequest(int req_id) {
		return rDao.getRequest(req_id);
	}

	@Override
	@Transactional
	public void assignRequest(int req_id, int tech_id) {
		rDao.assignRequest(req_id, tech_id);
	}

	@Override
	public Request findRequest(int req_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteRequest(int req_id) {
		 rDao.deleteRequest(req_id);
	}

	@Override
	@Transactional
	public List<Request> getClosedRequests() {
		return rDao.getClosedRequests();
	}

	@Override
	@Transactional
	public User findUser(int user_id) {
		return rDao.findUser(user_id);
	}

	@Override
	@Transactional
	public void createRequest(Request request) {
		rDao.createRequest(request);
	}

	@Override
	@Transactional
	public ReqSol getRequestReport(int req_id) {
		return rDao.getRequestReport(req_id);
	}

	@Override
	@Transactional
	public void closeRequest(ReqSol reqSol) {
		rDao.closeRequest(reqSol);
	}

	@Override
	@Transactional
	public ReqSol CheckRequestSoltion(int req_id) {
		return rDao.CheckRequestSoltion(req_id);
	}

	@Override
	@Transactional
	public void deleteRequests(int user_id) {
		rDao.deleteRequests(user_id);
	}

	
}
