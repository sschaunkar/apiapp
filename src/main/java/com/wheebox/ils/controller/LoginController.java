package com.wheebox.ils.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wheebox.ils.dto.LoginRequestDto;
import com.wheebox.ils.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginController {
	@Autowired
	private LoginService ls;
	@PostMapping("/login")
	public ResponseEntity<?> SignIn(@RequestBody LoginRequestDto data) {
		log.info("login request receieved {}", data);
		if(null==data) {
			return new ResponseEntity<>(ls.loginFail(data),HttpStatus.UNAUTHORIZED);
		} 
			return new ResponseEntity<>(ls.verifyUser(data),HttpStatus.OK);
	}
}
