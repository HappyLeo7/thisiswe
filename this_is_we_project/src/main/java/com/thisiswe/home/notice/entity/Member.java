package com.thisiswe.home.notice.entity;

import com.thisiswe.home.enetity.DateEntity;

//TODO [Entity]Notice 회원 컬럼(이메일, 비밀번호, 이름)
public class Member extends DateEntity{
	
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private UserEntity userId;					//회원 유저ID
		
	@Column(unique = true, length=100, name="user_email")
	private String userEmail;					//회원 이메일
	
	@Column(length=100, name="user_password")
	private String userPassword;  				//회원 비밀번호
	*/
}
