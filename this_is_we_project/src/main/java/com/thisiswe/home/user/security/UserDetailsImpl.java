package com.thisiswe.home.user.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.thisiswe.home.user.entity.UserEntity;
import com.thisiswe.home.user.entity.UserRoleEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {

	// UserRepository로 부터 받아온 정보
	private final UserEntity userEntity;
	
	public UserEntity getUserEntity() {
		return userEntity;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
//		Collection<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(adminAuthority);
//		return authorities;
	
		
		UserRoleEnum userRole = userEntity.getRole();
		String authority = userRole.getAuthority();
		SimpleGrantedAuthority simpleAuthority = new SimpleGrantedAuthority(authority);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(simpleAuthority);
		return authorities;
	}

	@Override
	public String getPassword() {
		return userEntity.getUserPassword();
	}

	@Override
	public String getUsername() {
		return userEntity.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
