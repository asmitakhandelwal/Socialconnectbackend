package com.socialconnect.DAO.impl;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.socialconnect.DAO.ProfilePictureDAO;
import com.socialconnect.model.ProfilePicture;
@Repository
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void insertOrUpdateProfilePicture(ProfilePicture profilePicture) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(profilePicture);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public ProfilePicture getProfilePicture(String username) {
		ProfilePicture profilePicture;
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(ProfilePicture.class);
			cr.add(Restrictions.eq("userName", username));
			profilePicture=(ProfilePicture) cr.uniqueResult();
			return profilePicture;
		}
		catch(Exception ex)
		{
			return null;
}
	}
}