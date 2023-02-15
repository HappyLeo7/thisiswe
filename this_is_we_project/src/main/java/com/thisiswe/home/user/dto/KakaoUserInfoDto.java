package com.thisiswe.home.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KakaoUserInfoDto {
	private Long id;
	private String nickname;
	private String email;
}
