package com.thisiswe.home.user.security;

import com.thisiswe.home.user.entity.UserEntity;
import com.thisiswe.home.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class UserSecurityTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void insertDumies() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			
			//TODO [테스트]임의 ID 생성
			UserEntity userEntity = UserEntity.builder()
					.userId("user" + i)
					.userPassword("1111")
					.userNickname("CuteDragon" + i)
					.userGender("남")
					.userEmail("user" + i + "@abc.com")
					.userPhoneNumber("012-345-6789")
					.fromSocial(false)
					.build();
			
			
//			userEntity.addUserRole(UserRole.USER);
//			
//			if(i>99) {
//				userEntity.addUserRole(UserRole.ADMIN);
//			}
			
			userRepository.save(userEntity);
		});
	}
}
