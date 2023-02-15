package com.thisiswe.home.user.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
}