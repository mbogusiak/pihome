package com.marcin.pihome.dao;

import org.springframework.stereotype.Repository;

import com.marcin.pihome.user.User;

@Repository
public class UseDaoImpl implements UserDao {

	public User getUserById(String id) {
		System.out.println("ID " +id);
		User user = new User("Marcin", "Bogusiak", "mbogusiak@gmail.com", 30);
		return user;
	}
}
