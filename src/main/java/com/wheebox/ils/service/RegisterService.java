package com.wheebox.ils.service;

import com.wheebox.ils.dto.RegisterRequestDto;
import com.wheebox.ils.dto.RegisterResponseDto;

public interface RegisterService {

	public RegisterResponseDto registerUser(RegisterRequestDto data);
	
	public RegisterResponseDto registerFail(RegisterRequestDto data);
}
