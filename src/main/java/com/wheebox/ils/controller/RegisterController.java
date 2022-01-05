package com.wheebox.ils.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wheebox.ils.dto.RegisterRequestDto;
import com.wheebox.ils.service.RegisterService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RegisterController {
	
	
	@Autowired
	private RegisterService rs;
	
	@PostMapping("/register")
	public ResponseEntity<?> SignUp(@Valid @RequestBody RegisterRequestDto data) {
		log.info("register user request receieved {}", data.toString());
		if(data==null || data.getEmail()==null||data.getEmail().equalsIgnoreCase("") || data.getName()==null||data.getName().equalsIgnoreCase("") || data.getPassword()==null||data.getPassword().equalsIgnoreCase("")) {
			return new ResponseEntity<>(rs.registerFail(data),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(rs.registerUser(data),HttpStatus.OK);
		
	}
}
