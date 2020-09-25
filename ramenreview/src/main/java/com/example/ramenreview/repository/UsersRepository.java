package com.example.ramenreview.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ramenreview.model.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{
	
	
	String value_updateUserByEmail="UPDATE users SET user_email = :user_email, "
			+ "user_name = :user_name, "
			+ "user_password = :user_password, "
			+ "user_role = :user_role "
			+ "WHERE users.user_email = :user_email";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_updateUserByEmail, nativeQuery = true)
	public void updateUserByEmail(@Param("user_email") String user_email,
			@Param("user_name") String user_name,
			@Param("user_password")String user_password,
			@Param("user_role") String user_role);
	
	String value_deleteUserByEmail = "DELETE FROM users WHERE user_email = :user_email";
	@Transactional
	@Modifying
	@Query(value = value_deleteUserByEmail, nativeQuery=true)
	public void deleteUserByEmail(@Param("user_email") String user_email);
	
}
