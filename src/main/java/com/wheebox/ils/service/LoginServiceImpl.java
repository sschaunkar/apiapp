package com.wheebox.ils.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wheebox.ils.dao.UserDAO;
import com.wheebox.ils.dto.LoginRequestDto;
import com.wheebox.ils.dto.LoginResponseDto;
import com.wheebox.ils.entity.User;
import com.wheebox.ils.mappers.MapStrutsMapper;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserDAO userrepo;
	@Autowired
	private MapStrutsMapper msp;

	@Override
	public LoginResponseDto verifyUser(LoginRequestDto data) {
		// TODO Auto-generated method stub
		User user = null;
		LoginResponseDto response = new LoginResponseDto();
		user = userrepo.findByEmail(data.getEmail());
		if(user==null) {
			response = LoginResponseDto.builder().message("User does not Exist").statuscode(401).build();
		} else {
			if((user.getEmail().equalsIgnoreCase(data.getEmail()) && (user.getPassword().equals(data.getPassword())))){
				response = LoginResponseDto.builder().message("Login Verified").statuscode(200).build();
				userrepo.updateLastLogin(new Date(), data.getEmail());
			} else {
				response = LoginResponseDto.builder().message("Invalid email or password").statuscode(401).build();
			}
		}
		return response;
	}

	@Override
	public LoginResponseDto loginFail(LoginRequestDto data) {
		// TODO Auto-generated method stub
		LoginResponseDto response = new LoginResponseDto();
		if(data==null || data.getEmail()==null||data.getEmail().equalsIgnoreCase("") || data.getPassword()==null||data.getPassword().equalsIgnoreCase("")) {
			response = LoginResponseDto.builder().message("Provide Valid email or password").statuscode(400).build();
		}
		return response;
	}

}
