package com.wheebox.ils.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wheebox.ils.dto.LoginRequestDto;
import com.wheebox.ils.dto.RegisterRequestDto;
import com.wheebox.ils.entity.User;

@Mapper
public interface MapStrutsMapper {
	MapStrutsMapper INSTANCE = Mappers.getMapper(MapStrutsMapper.class);
	
	User dtoToEntity(RegisterRequestDto dto);
	
	User dtoToEntity(LoginRequestDto dto);
	
	RegisterRequestDto EntitytoDto(User user);
}
