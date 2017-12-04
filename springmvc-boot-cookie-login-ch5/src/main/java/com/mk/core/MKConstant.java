package com.mk.core;

public class MKConstant {

	public static final String SESSSION_USER = "session_user";
	
	// cookie的有效期默认为30天
    public final static int COOKIE_MAX_AGE = 60 * 60 * 24 * 7; 
    //cookie加密时的额外的salt
    public final static String salt = "www.itbooking.net";
    //自动登录的Cookie名
    public final static String RememberMe = "remember";
}
