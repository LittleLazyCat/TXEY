package com.Alex.dao;

import com.Alex.domain.User;

public interface UserDao {
	public abstract void addUser(User user);
	public abstract User getUser(int userId);
	public abstract void updateUser(User user);
	public abstract void deleteUser(User user);
	public abstract void download();
}
