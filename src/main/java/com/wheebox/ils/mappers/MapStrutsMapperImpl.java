package com.wheebox.ils.mappers;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.wheebox.ils.dto.LoginRequestDto;
import com.wheebox.ils.dto.RegisterRequestDto;
import com.wheebox.ils.entity.User;

@Component
public class MapStrutsMapperImpl implements MapStrutsMapper  {

	@Override
	public User dtoToEntity(RegisterRequestDto dto) {
		// TODO Auto-generated method stub
		if(dto==null) {
			return null;
		}
		User usr = new User();
		usr.setName(dto.getName());
		usr.setEmail(dto.getEmail());
		usr.setPassword(dto.getPassword());
		usr.setUsercreated(new Date());
		return usr;
	}

	@Override
	public RegisterRequestDto EntitytoDto(User user) {
		// TODO Auto-generated method stub
		if(user==null) {
			return null;
		}
		RegisterRequestDto dto = new RegisterRequestDto();
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		
		return dto;
	}

	@Override
	public User dtoToEntity(LoginRequestDto dto) {
		// TODO Auto-generated method stub
		if(dto==null) {
			return null;
		}
		User usr = new User();
		usr.setEmail(dto.getEmail());
		usr.setPassword(dto.getPassword());
		return usr;
	}

	
}
