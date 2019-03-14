package com.socialconnect.DAO.impl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.socialconnect.DAO.FriendsDAO;
import com.socialconnect.model.Friends;
import com.socialconnect.model.UserDetails;

@Repository(value="friendsDAO")
@Transactional
public class FriendsDAOImpl implements FriendsDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public List<UserDetails> getSuggestedFriends(String username) {
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
			cr.add(Restrictions.eq("userName", username));
			List suggestedFriends = cr.list();
			return suggestedFriends;
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		return null;
		}
	}

	public void addOrUpdateFriend(Friends friend) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public List<UserDetails> getFriendRequests(String username) {
		Session session=sessionFactory.getCurrentSession();
		String queryString="select * from UserDetails where username in (select fromId from Friends where toId=? and status='P')";
		SQLQuery<UserDetails> query=session.createSQLQuery(queryString);
		query.addEntity(UserDetails.class);
		query.setString(0, username);
		return query.list();
	}

	public List<UserDetails> getSentRequests(String username) {
		Session session=sessionFactory.getCurrentSession();
		String queryString="select * from UserDetails where username in (select toId from Friends where fromId=? and status='P')";
		SQLQuery<UserDetails> query=session.createSQLQuery(queryString);
		query.addEntity(UserDetails.class);
		query.setString(0, username);
		return query.list();
	}

	public List<UserDetails> getFriendsList(String username) {
		Session session=sessionFactory.getCurrentSession();
		String queryString="select * from UserDetails where username in (select fromId from Friends where toId=? and status='A' union select toId from Friends where fromId=? and status='A')";
		SQLQuery<UserDetails> query=session.createSQLQuery(queryString);
		query.addEntity(UserDetails.class);
		query.setString(0, username);
		query.setString(1, username);
		return query.list();
	}

	public Friends getFriend(String toId,String fromId){
		Session session=sessionFactory.getCurrentSession();
		Query<Friends> query=session.createQuery("from Friends where toId=:toId and fromId=:fromId");
		query.setParameter("toId",toId);
		query.setParameter("fromId",fromId);
		return query.uniqueResult();
	}
}

