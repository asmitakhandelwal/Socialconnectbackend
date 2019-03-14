package com.socialconnect.DAO.impl;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.socialconnect.DAO.UserDetailsDAO;
import com.socialconnect.model.UserDetails;
@Repository(value="userDetailsDAO")
@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public UserDetailsDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public void insertOrUpdateUserDetails(UserDetails userDetails)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public UserDetails getUserDetails(String username)
	{
		UserDetails userDetails;
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
			cr.add(Restrictions.eq("userName", username));
			userDetails=(UserDetails) cr.uniqueResult();
			return userDetails;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
}
	}

	public UserDetails getUserDetailsByEmail(String email) {
		UserDetails userDetails;
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
			cr.add(Restrictions.eq("email", email));
			userDetails=(UserDetails) cr.uniqueResult();
			return userDetails;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
}
	}
	
	public UserDetails login(UserDetails userDetails) {
		UserDetails getUserDetails;
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
			Criterion checkUserName=Restrictions.eq("userName", userDetails.getUsername());
			Criterion checkPassword=Restrictions.eq("password", userDetails.getPassword());
			LogicalExpression andExpression=Restrictions.and(checkUserName, checkPassword);
			cr.add(andExpression);
			getUserDetails=(UserDetails) cr.uniqueResult();
			return getUserDetails;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		}
	}

