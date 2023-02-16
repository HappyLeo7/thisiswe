package com.thisiswe.home.user.service;

import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thisiswe.home.user.dto.KakaoUserInfoDto;
import com.thisiswe.home.user.dto.SignupRequestDto;
import com.thisiswe.home.user.entity.UserEntity;
import com.thisiswe.home.user.entity.UserRoleEnum;
import com.thisiswe.home.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	private static final String ADMIN_TOKEN = "WFizAS/xREgejDFIVCsEsfjSDBgfbDasqWE";

//	@RequiredArgsConstructor를 사용하지 않을 경우
//	@Autowired
//	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//		this.userRepository = userRepository;
//		this.passwordEncoder = passwordEncoder;
//	}

	public void registerUser(SignupRequestDto requestDto) {

		// 회원 ID 중복 확인
		String userId = requestDto.getUserId();
		Optional<UserEntity> foundUserId = userRepository.findByUserId(userId);

		if (foundUserId.isPresent()) {
			throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
		}

		String userPassword = passwordEncoder.encode(requestDto.getUserPassword());

		String userNickname = requestDto.getUserNickname();

		// 회원 닉네임 중복 확인
		Optional<UserEntity> foundUserNickname = userRepository.findByUserNickname(userNickname);

		if (foundUserNickname.isPresent()) {
			throw new IllegalArgumentException("중복된 사용자 닉네임이 존재합니다.");
		}

		String userGender = requestDto.getUserGender();

		String userEmail = requestDto.getUserEmail();

		String userPhoneNumber = requestDto.getUserPhoneNumber();

		// 회원 핸드폰번호 중복 확인
		Optional<UserEntity> foundUserPhoneNumber = userRepository.findByUserPhoneNumber(userPhoneNumber);

		if (foundUserPhoneNumber.isPresent()) {
			throw new IllegalArgumentException("중복된 핸드폰번호가 존재합니다.");
		}

		String userImageUrl = requestDto.getUserImageUrl();

		// 사용자 ROLE 확인
		UserRoleEnum role = UserRoleEnum.USER;

		if (requestDto.isAdmin()) {
			if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
				throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
			}
			role = UserRoleEnum.ADMIN;
		}

		System.out.println(userId);
		UserEntity userEntity = new UserEntity(userId, userPassword, userNickname, userGender, userEmail,
				userPhoneNumber, userImageUrl, role);
		System.out.println("성공");
		userRepository.save(userEntity);

	}

	public void kakaoLogin(String code) throws JsonProcessingException {
		// 1. "인가 코드"로 "액세스 토큰" 요청
		String accessToken = getAccessToken(code);
		// 2. "액세스 토큰"으로 "카카오 사용자 정보" 가져오기
		KakaoUserInfoDto kakaoUserInfo = getKakaoUserInfo(accessToken);
	}

	private String getAccessToken(String code) throws JsonProcessingException {

		// HTTP Header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// HTTP Body 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", "authorization_code");
		body.add("client_id", "61db540d862894225a4938d0133cb467");
		body.add("redirect_uri", "http://localhost:8080/user/kakao/callback");
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
		
		// HTTP Header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken);
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// HTTP 요청 보내기
		HttpEntity<MultiValueMap<String, String>> kakaoUserInfoRequest = new HttpEntity<>(headers);
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> response = rt.exchange(
				"https://kapi.kakao.com/v2/user/me", 
				HttpMethod.POST,
				kakaoUserInfoRequest, 
				String.class);
		
		String responseBody = response.getBody();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonNode = objectMapper.readTree(responseBody);
		
		Long id = jsonNode.get("id").asLong();
		
		String nickname = jsonNode.get("properties").get("nickname").asText();
		
		String email = jsonNode.get("kakao_account").get("email").asText();
		
		return new KakaoUserInfoDto(id, nickname, email);
	}
}