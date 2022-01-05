package com.wheebox.ils.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginRequestDto {
	
    @NotNull
    @JsonProperty("email")
    private String email;
    
    @NotNull
    @JsonProperty("password")
    private String password;
}
