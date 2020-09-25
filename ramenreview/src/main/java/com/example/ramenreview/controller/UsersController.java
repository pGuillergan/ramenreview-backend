package com.example.ramenreview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ramenreview.model.Users;
import com.example.ramenreview.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService us;
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}

	
	@GetMapping("/get_users")
	public List<Users> getAllUsers(){
		System.out.println(us.findAll());
		
		return us.findAll();
	}
	
	@PostMapping("/add_user")
	public Users saveUser(@RequestBody Users user){
		us.addUser(user);
		return user;
	}
	
	@PatchMapping("/update_user/{user_email}")
	public void updateUser(@PathVariable("user_email") String user_email,  @RequestBody Users user){
		us.updateUserByEmail(user_email, user.getUser_name(), user.getUser_password(), user.getUser_role());
	}
	
	@DeleteMapping("/delete_user/{user_email}")
	public void deleteUser(@PathVariable("user_email")String user_email) {
		us.deleteUserByEmail(user_email);
	}
}
