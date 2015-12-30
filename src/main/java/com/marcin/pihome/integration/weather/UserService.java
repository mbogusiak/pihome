package com.marcin.pihome.integration.weather;

import com.marcin.pihome.user.User;

public interface UserService {
	public User findUserByID(String userID);
}
