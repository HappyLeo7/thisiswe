package com.thisiswe.home.user.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thisiswe.home.user.entity.UserEntity;
import com.thisiswe.home.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findByUserId(username).orElseThrow(
				() -> new UsernameNotFoundException("찾을 수 없다 " +username));
		return new UserDetailsImpl(userEntity);
	}
	
	

}
