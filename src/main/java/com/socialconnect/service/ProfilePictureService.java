package com.socialconnect.service;

import com.socialconnect.model.ProfilePicture;

public interface ProfilePictureService 
{
	public void insertOrUpdateProfilePicture(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
