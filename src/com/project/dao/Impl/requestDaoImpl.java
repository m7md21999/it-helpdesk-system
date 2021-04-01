package com.project.dao.Impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.requestDao;
import com.project.entity.ReqSol;
import com.project.entity.Request;
import com.project.entity.User;

@Repository("rDao")
public class requestDaoImpl implements requestDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Request> getRequests() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Request> theQuery = currentSession.createQuery("from Request" , Request.class);
		List<Request> requests = theQuery.getResultList();
		return requests;
	}


	@Override
	public List<Request> getRequests(int user_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = findUser(user_id);
		
			if(user.getDept_name().equals("Information technology")){
		Query<Request> theQuery = currentSession.createQuery("from Request where tech_id="+user.getId(), Request.class);
		List<Request> requests = theQuery.getResultList();
		return requests;
			}
		
		Query<Request> theQuery = currentSession.createQuery("from Request where emp_id="+user.getId(), Request.class);
		List<Request> requests = theQuery.getResultList();
		return requests;
	}


	@Override
	public List<Request> getNewRequests() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Request> theQuery = currentSession.createQuery("from Request where status='new'" , Request.class);
		List<Request> requests = theQuery.getResultList();
		return requests;
	}


	@Override
	public List<Request> getNewHighPriortyRequests() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Request> theQuery = currentSession.createQuery("from Request where status='new' AND priority='high'" , Request.class);
		List<Request> requests = theQuery.getResultList();
		return requests;
	}


	@Override
	public List<Request> getHighPriortyRequests() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Request> theQuery = currentSession.createQuery("from Request where priority='high'" , Request.class);
		List<Request> requests = theQuery.getResultList();
		return requests;
	}


	@Override
	public List<Request> getAssignedRequests() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Request> theQuery = currentSession.createQuery("from Request where status='assigned'" , Request.class);
		List<Request> requests = theQuery.getResultList();
		return requests;
	}


	@Override
	public Request getRequest(int req_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Request request = currentSession.get(Request.class,req_id);
		return request;
	}


	@Override
	public void assignRequest(int req_id, int tech_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.createQuery("Update Request Set status='Assigned', tech_id="+tech_id+" where req_id="+req_id)
		.executeUpdate();
		Request request = getRequest(req_id);
		request.setAssignedDate(new java.sql.Date(new java.util.Date().getTime()));
		currentSession.saveOrUpdate(request);
	}



	@Override
	public void deleteRequest(int req_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Request request = getRequest(req_id);
		ReqSol reqSol = CheckRequestSoltion(req_id);
		if(reqSol != null) {
			currentSession.delete(reqSol);
		}
		currentSession.delete(request);
	}

	public void deleteRequests (int user_id){
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.createQuery("Delete from req where emp_id="+user_id).executeUpdate();
	}

	@Override
	public List<Request> getClosedRequests() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Request> theQuery = currentSession.createQuery("from Request where status='closed'" , Request.class);
		List<Request> requests = theQuery.getResultList();
		return requests;
	}


	@Override
	public User findUser(int user_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, user_id);
		return user;
	}


	@Override
	public void createRequest(Request request) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(request);		
	}


	@Override
	public ReqSol getRequestReport(int req_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		ReqSol request = currentSession.get(ReqSol.class,req_id);
		return request;
	}


	@Override
	public void closeRequest(ReqSol reqSol) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(reqSol);
		Request request = getRequest(reqSol.getReq_id());
		request.setStatus("Closed");
		currentSession.update(request);
	}


	@Override
	public ReqSol CheckRequestSoltion(int req_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<ReqSol> req = currentSession.createQuery("from ReqSol where req_id="+req_id,ReqSol.class).getResultList();
		ReqSol finalReqSol = null;
		if ((req != null) && (req.size()> 0)){
			for (ReqSol reqsols : req){
				finalReqSol = reqsols;
			}	
			return finalReqSol;
		}
		return null;		
	}





}
