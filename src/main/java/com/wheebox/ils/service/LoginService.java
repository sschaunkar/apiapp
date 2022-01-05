package com.wheebox.ils.service;


import com.wheebox.ils.dto.LoginRequestDto;
import com.wheebox.ils.dto.LoginResponseDto;


public interface LoginService {
	
public LoginResponseDto verifyUser(LoginRequestDto dto);
public LoginResponseDto loginFail(LoginRequestDto dto);

}
