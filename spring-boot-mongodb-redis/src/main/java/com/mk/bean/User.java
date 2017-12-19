package com.mk.bean;


import java.util.Date;

import lombok.Data;

@Data
public class User {

	private Integer id;
	private String username;
	private String password;
	private Date date;
}
