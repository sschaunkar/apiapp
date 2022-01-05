package com.wheebox.ils.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.wheebox.ils.model.AbstractUser;

@Entity
@Table(name="users")
public class User extends AbstractUser {

}
