package com.thisiswe.home.user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
	private final EmailService emailService;

	private final Map<String, String> verificationCodes = new HashMap<>();
	private static final String ADMIN_TOKEN = "WFizAS/xREgejDFIVCsEsfjSDBgfbDasqWE";

	
	// 회원 삭제
	public void removeUser(String userId) {
		userRepository.deleteById(userId);
	}
	
    // 회원가입 시 이메일로 전송할 인증코드 생성 메서드
    /**
     * 이메일 인증코드를 생성하는 메서드
     * @return 4자리 숫자로 이루어진 인증코드
     */
    public String generateCode() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }
	

    /**
     * 사용자 이메일과 인증코드를 매핑해서 Map에 저장하는 메서드
     * @param userEmail 사용자 이메일
     * @param code 인증코드
     */
    public void saveCode(String userEmail, String code) {
    	verificationCodes.put(userEmail, code);
    }
    
    /**
     * 사용자 이메일과 입력한 인증코드가 일치하는지 확인하는 메서드
     * @param userEmail 사용자 이메일
     * @param code 입력한 인증코드
     * @return 인증코드 일치여부
     */
    public boolean verifyCode(String userEmail, String code) {
        String savedCode = verificationCodes.get(userEmail);
        if (savedCode == null) {
            // 저장된 인증코드가 없는 경우
            return false;
        } else if (savedCode.equals(code)) {
            // 저장된 인증코드와 입력한 인증코드가 일치하는 경우
            return true;
        } else {
            // 저장된 인증코드와 입력한 인증코드가 일치하지 않는 경우
            return false;
        }
    }
    
    /**
     * 사용자 이메일로 인증코드 전송하는 메서드
     * @param userEmail 사용자 이메일
     */
    public void sendVerificationCode(String userEmail) {
    	  // 인증코드 생성
        String code = generateCode();

        // 이메일 전송
        emailService.sendVerificationCode(userEmail, code);

        // 사용자 이메일과 인증코드 매핑해서 Map에 저장
        saveCode(userEmail, code);
    }
	

	// view단 회원 ID 중복 확인
	public boolean checkUserId(String userId) {
		System.out.println("Service단에서의 userId" + userId);
		return userRepository.existsByUserId(userId);
	}
	
	// view단 회원 닉네임 중복 확인
	public boolean checkUserNickname(String userNickname) {
		System.out.println("Service단에서의 userNickname" + userNickname);
		return userRepository.existsByUserNickname(userNickname);
	}
	
	// view단 회원 이메일 중복 확인
	public boolean checkUserEmail(String userEmail) {
		System.out.println("Service단에서의 userEmail" + userEmail);
		return userRepository.existsByUserEmail(userEmail);
	}
	
	
	public void registerUser(SignupRequestDto requestDto) {
		// 회원 ID 중복 확인
		String userId = requestDto.getUserId();
		Optional<UserEntity> foundUserId = userRepository.findByUserId(userId);

		if (foundUserId.isPresent()) {
			throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
		}

		String userPassword = passwordEncoder.encode(requestDto.getUserPassword());

		// 회원 닉네임 중복 확인
		String userNickname = requestDto.getUserNickname();
		Optional<UserEntity> foundUserNickname = userRepository.findByUserNickname(userNickname);

		if (foundUserNickname.isPresent()) {
			throw new IllegalArgumentException("중복된 사용자 닉네임이 존재합니다.");
		}
		
		// 회원 이름 중복 확인
		String userName = requestDto.getUserName();
		Optional<UserEntity> foundUserName = userRepository.findByUserName(userName);

		if (foundUserName.isPresent()) {
			throw new IllegalArgumentException("중복된 사용자 닉네임이 존재합니다.");
		}
		
		// 성별
		String userGender = requestDto.getUserGender();

		// 이메일
		String userEmail = requestDto.getUserEmail();
		Optional<UserEntity> foundUserEmail = userRepository.findByUserEmail(userEmail);
		if (foundUserEmail.isPresent()) {
			throw new IllegalArgumentException("이미 가입된 이메일 주소입니다.");
		}
		
		
		// 핸드폰번호
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
		UserEntity userEntity = new UserEntity(userId, userPassword, userNickname, userName, userGender, userEmail,
				userPhoneNumber, userImageUrl, role);
		System.out.println("성공");
		userRepository.save(userEntity);

	}
}