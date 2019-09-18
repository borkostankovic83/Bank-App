package com.revature.repository;

import com.revature.model.User;

public class UserDaoMock {
	public User getUser(int id) {
		if(id == 1) {
			return  getUser(1);
		}
		return null;
	}
}
