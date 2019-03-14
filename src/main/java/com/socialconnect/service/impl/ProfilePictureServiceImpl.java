package com.socialconnect.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialconnect.DAO.ProfilePictureDAO;
import com.socialconnect.model.ProfilePicture;
import com.socialconnect.service.ProfilePictureService;

@Service(value="profilePictureService")
public class ProfilePictureServiceImpl implements ProfilePictureService {
@Autowired
ProfilePictureDAO profilePictureDAO;

	@Override
	public void insertOrUpdateProfilePicture(ProfilePicture profilePicture) {
		profilePictureDAO.insertOrUpdateProfilePicture(profilePicture);
	}

	@Override
	public ProfilePicture getProfilePicture(String username) {
		ProfilePicture profilePicture= profilePictureDAO.getProfilePicture(username);
		if(profilePicture!=null)
		{
			return profilePicture;
		}
		else
		{
		
		return null;
	}
	}
}
