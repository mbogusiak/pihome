package com.marcin.pihome.services;

import com.marcin.pihome.user.User;

public interface UserService {
	public User findUserByID(String userID);
}
