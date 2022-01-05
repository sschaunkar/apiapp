package com.wheebox.ils.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wheebox.ils.dao.UserDAO;
import com.wheebox.ils.dto.RegisterRequestDto;
import com.wheebox.ils.dto.RegisterResponseDto;
import com.wheebox.ils.entity.User;
import com.wheebox.ils.mappers.MapStrutsMapper;
@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private UserDAO ud;
	@Autowired
	private MapStrutsMapper msp;
	
	@Override
	public RegisterResponseDto registerUser(RegisterRequestDto data) {
		// TODO Auto-generated method stub
		RegisterResponseDto response = new RegisterResponseDto();
			
			try {
					System.out.println("Email======"+data.getEmail());
					System.out.println("Name======"+data.getName());
					System.out.println("Password======"+data.getPassword());
					
					User usr = null;
					usr = ud.findByEmail(data.getEmail());
					if(usr!=null) {
					response = RegisterResponseDto.builder().message("User Already exist").statuscode(409).build();
					}else {
						usr = msp.dtoToEntity(data);
						ud.save(usr);
						response = RegisterResponseDto.builder().message("User Created Successfully").statuscode(200).build();
						
					}
					
					
					
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return response;
	
	}

	@Override
	public RegisterResponseDto registerFail(RegisterRequestDto data) {
		// TODO Auto-generated method stub
		RegisterResponseDto response = new RegisterResponseDto();
		if(data==null || data.getEmail()==null||data.getEmail().equalsIgnoreCase("") || data.getName()==null||data.getName().equalsIgnoreCase("") || data.getPassword()==null||data.getPassword().equalsIgnoreCase("")) {
			if(data==null) {
				response = RegisterResponseDto.builder().message("Provide Required Data").statuscode(400).build();
			} else {
				response = RegisterResponseDto.builder().message("Provide valid name,email or password").statuscode(400).build();
			}
		}
		return response;
	}
}
