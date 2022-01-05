package com.wheebox.ils.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wheebox.ils.entity.User;

public interface UserDAO extends JpaRepository<User, Long> {
	
	@Query("from User where email=:email")
	public User findByEmail(@Param("email")String email);
	
	@Modifying
	@Transactional
	@Query("update User u set u.lastlogin=:date where u.email=:email")
	public void updateLastLogin(@Param("date")Date date,@Param("email")String email);

}
