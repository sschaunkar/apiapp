package com.wheebox.ils.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractUser {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "id")
private long id;
@Column(name = "name")
private String name;
@Column(name = "email")
private String email;
@Column(name = "password")
private String password;
@Column(name = "token")
private String token;
@Temporal(TemporalType.TIMESTAMP)
@Column(name = "lastlogin")
private Date lastlogin;
@Temporal(TemporalType.TIMESTAMP)
@Column(name = "usercreated")
private Date usercreated;
}
