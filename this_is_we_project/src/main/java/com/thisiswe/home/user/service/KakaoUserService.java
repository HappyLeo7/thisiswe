package com.thisiswe.home.user.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thisiswe.home.user.dto.KakaoUserInfoDto;
import com.thisiswe.home.user.entity.UserEntity;
import com.thisiswe.home.user.entity.UserRoleEnum;
import com.thisiswe.home.user.repository.UserRepository;
import com.thisiswe.home.user.security.UserDetailsImpl;

@Service
public class KakaoUserService {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	@Autowired
	public KakaoUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public void kakaoLogin(String code) throws JsonProcessingException {
		// 1. "인가 코드"로 "액세스 토큰" 요청
		String accessToken = getAccessToken(code);
		// 2. "액세스 토큰"으로 "카카오 사용자 정보" 가져오기
		KakaoUserInfoDto kakaoUserInfo = getKakaoUserInfo(accessToken);
		// 3. "카카오 사용자 정보"로 필요시 회원가입
		UserEntity kakaoUser = registerKakaoUserIfNeeded(kakaoUserInfo);
		// 4. 강제 로그인 처리
		forceLogin(kakaoUser);
		
	}

	//
	private String getAccessToken(String code) throws JsonProcessingException {
		
		// 1. "인가 코드"로 "액세스 토큰" 요청
		// HTTP Header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		// HTTP Body 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", "authorization_code");
		body.add("client_id", "5bd1dab16ee774baea6d62d812f5b773");
		body.add("redirect_uri", "http://localhost:8080/login/oauth2/code/kakao");
		body.add("code", code);

		// HTTP 요청 보내기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(body, headers);

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST,
				kakaoTokenRequest, String.class);

		// HTTP 응답 (JSON) -> 액세스 토큰 파싱
		String responseBody = response.getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(responseBody);
	
		return jsonNode.get("access_token").asText();
	}

	private KakaoUserInfoDto getKakaoUserInfo(String accessToken) throws JsonProcessingException {

		// 2. 토큰으로 카카오 API 호출
		// HTTP Header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken);
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// HTTP 요청 보내기
		HttpEntity<MultiValueMap<String, String>> kakaoUserInfoRequest = new HttpEntity<>(headers);
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> response = rt.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST,
				kakaoUserInfoRequest, String.class);

		String responseBody = response.getBody();

		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode jsonNode = objectMapper.readTree(responseBody);
		Long id = jsonNode.get("id").asLong();

		String nickname = jsonNode.get("properties").get("nickname").asText();

		String email = jsonNode.get("kakao_account").get("email").asText();

		return new KakaoUserInfoDto(id, nickname, email);
	}

	private UserEntity registerKakaoUserIfNeeded(KakaoUserInfoDto kakaoUserInfo) {
		
		// DB 에 중복된 Kakao Id 가 있는지 확인
		Long kakaoId = kakaoUserInfo.getId();
		UserEntity kakaoUser = userRepository.findByKakaoId(kakaoId).orElse(null);
		if (kakaoUser == null) {
			
			// 회원가입
			// username: kakao nickname
			String nickname = kakaoUserInfo.getNickname();
			
			// password: random UUID
			String password = UUID.randomUUID().toString();
			
			String encodedPassword = passwordEncoder.encode(password);
			
			// email: kakao email
			String email = kakaoUserInfo.getEmail();
			
			// role: 일반 사용자
			UserRoleEnum role = UserRoleEnum.USER;
			
			kakaoUser = new UserEntity(nickname, encodedPassword, null, null, null, email, null, null, role, kakaoId);
			
			userRepository.save(kakaoUser);
		}
		return kakaoUser;
	}

	private void forceLogin(UserEntity kakaoUser) {
		
		// 4. 강제 로그인 처리
		UserDetails userDetails = new UserDetailsImpl(kakaoUser);
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);

	}


}
