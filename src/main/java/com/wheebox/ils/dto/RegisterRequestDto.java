package com.wheebox.ils.dto;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterRequestDto {
	@NotNull
	@JsonProperty("name")
	private String name;
	
    @NotNull
    @Email
    @JsonProperty("email")
    private String email;
    
    @NotNull
    @JsonProperty("password")
    private String password;
}
