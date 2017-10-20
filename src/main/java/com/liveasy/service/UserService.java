package com.liveasy.service;

import com.liveasy.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public void updateUserAddress(int userId, String address);
	
}
