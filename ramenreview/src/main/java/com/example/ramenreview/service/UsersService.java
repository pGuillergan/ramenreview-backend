package com.example.ramenreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ramenreview.repository.UsersRepository;

import com.example.ramenreview.model.Users;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository ur;
	
	public List<Users> findAll(){
		return ur.findAll();
	}
	
	public void addUser(Users user) {
		ur.save(user);
	}
	
	public void updateUserByEmail(String user_email, String user_name, String user_password, String user_role) {
		ur.updateUserByEmail(user_email, user_name, user_password, user_role);
		System.out.println("updated user: "+user_email + user_name + user_password + user_role);
	}
	
	public void  deleteUserByEmail(String user_email) {
		ur.deleteUserByEmail(user_email);
	}
		
}
