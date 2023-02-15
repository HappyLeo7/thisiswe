package com.thisiswe.home.club.board.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.thisiswe.home.enetity.DateEntity;
import com.thisiswe.home.user.entity.UserEntity;

//TODO [Entity]Board 회원 컬럼(유저ID, 이메일, 비밀번호)
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
	
