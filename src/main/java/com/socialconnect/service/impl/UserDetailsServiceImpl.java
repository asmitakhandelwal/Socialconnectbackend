package com.socialconnect.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialconnect.DAO.UserDetailsDAO;
import com.socialconnect.model.UserDetails;
import com.socialconnect.service.UserDetailsService;

@Service(value="userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService 
{
	@Autowired
	UserDetailsDAO userDetailsDAO;

	@Override
	public void insertOrUpdateUserDetails(UserDetails userDetails) {
		userDetailsDAO.insertOrUpdateUserDetails(userDetails);
	}

	@Override
	public UserDetails getUserDetails(String username) {
		UserDetails userDetails=userDetailsDAO.getUserDetails(username);
		if(userDetails!=null) {
			return userDetails;
		}
		else
		{
		return null;
		}
	}

	@Override
	public UserDetails getUserDetailsByEmail(String email) {
		UserDetails userDetails=userDetailsDAO.getUserDetailsByEmail(email);
		if(userDetails!=null) {
			return userDetails;
		}
		else
		{
		return null;
		}
	}
	

	@Override
	public UserDetails login(UserDetails userDetails) {
	UserDetails userDetail=userDetailsDAO.login(userDetails);
	if(userDetails!=null) {
		return userDetails;
	}
	else
	{
	return null;
	}
}
}
