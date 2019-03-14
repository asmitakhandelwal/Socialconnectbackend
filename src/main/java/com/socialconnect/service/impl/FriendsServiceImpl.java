package com.socialconnect.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialconnect.DAO.FriendsDAO;
import com.socialconnect.model.Friends;
import com.socialconnect.model.UserDetails;
import com.socialconnect.service.FriendsService;

@Service(value="friendsService")
public class FriendsServiceImpl implements FriendsService{

	@Autowired
	FriendsDAO friendsDAO;
	
	@Override
	public List<UserDetails> getSuggestedFriends(String username) {
	List<UserDetails> suggestedFriends=friendsDAO.getSuggestedFriends(username)	;
	if(suggestedFriends!=null) {
		return suggestedFriends;
	}
	else {
		return null;
	}
	}
	
	@Override
	public void addOrUpdateFriend(Friends friend) {
		friendsDAO.addOrUpdateFriend(friend);
		
	}

	@Override
	public List<UserDetails> getFriendRequests(String username) {
		List<UserDetails> friendRequests=friendsDAO.getFriendRequests(username)	;
		if(friendRequests!=null) {
			return friendRequests;
		}
		else {
			return null;
		}
	}

	@Override
	public List<UserDetails> getFriendsList(String username) {
		List<UserDetails> friendList=friendsDAO.getFriendsList(username)	;
		if(friendList!=null) {
			return friendList;
		}
		else {
			return null;
		}
	}

	@Override
	public Friends getFriend(String toId, String fromId) {
		Friends friends=friendsDAO.getFriend(toId, fromId);
		if(friends!=null)
		{
			return friends;
		}
		else
		{
		return null;
	}
	}
	@Override
	public List<UserDetails> getSentRequests(String username) {
		List<UserDetails> sentRequests=friendsDAO.getSentRequests(username);
		if(sentRequests!=null)
		{
			return sentRequests;
		}
		else
		{
			
		return null;
		}
	}

	
}