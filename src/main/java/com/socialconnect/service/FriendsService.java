package com.socialconnect.service;
import java.util.List;
import com.socialconnect.model.Friends;
import com.socialconnect.model.UserDetails;

public interface FriendsService 
{
	List<UserDetails> getSuggestedFriends(String username);
	void addOrUpdateFriend(Friends friend);
	public List<UserDetails> getFriendRequests(String username);
	public List<UserDetails> getFriendsList(String username);
	public Friends getFriend(String toId,String fromId);
	public List<UserDetails> getSentRequests(String username);

}
