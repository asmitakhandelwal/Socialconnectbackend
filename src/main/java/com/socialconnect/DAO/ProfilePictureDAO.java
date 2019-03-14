package com.socialconnect.DAO;
import com.socialconnect.model.ProfilePicture;
public interface ProfilePictureDAO 
{
	public void insertOrUpdateProfilePicture(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
