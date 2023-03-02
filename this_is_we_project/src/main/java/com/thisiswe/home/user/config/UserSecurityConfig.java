package com.thisiswe.home.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration // 설정파일을 만들기 위한 애노테이션 or Bean을 등록하기 위한 애노테이션
@RequiredArgsConstructor // final이나 @NonNull인 필드 값만 파라미터로 받는 생성자 만듦
@EnableWebSecurity // 스프링 Security 지원을 가능하게 한다.
@EnableGlobalMethodSecurity(securedEnabled = true) // @Secured 어노테이션 활성화
public class UserSecurityConfig {

    @Bean
    // 비밀번호를 그대로 저장하지 않고 BCryptPasswordEncoder의 해시 함수를 이용하여 암호화처리
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.csrf().disable(); // 테스트중으로 공부가 필요한 부분
//		http.csrf().ignoringAntMatchers("/user/**"); // 회원 관리 처리 API (POST /user/**) 에 대해 CSRF 무시

        http.authorizeRequests() // 권한에 대해
//		 image 폴더를 login 없이 허용
                .antMatchers("/image/**").permitAll()
//		 css 폴더를 login 없이 허용
                .antMatchers("/css/**").permitAll()
//		 회원 관리 처리 API 전부를 login 없이 허용
                .antMatchers("/login/user/**").permitAll()
                .antMatchers("/club/**").permitAll()
                .antMatchers("/chatroom/**").permitAll()
                .antMatchers("/basic/**").permitAll()
                .antMatchers("/reservation/**").permitAll()
                .antMatchers("/place/**").permitAll()
                .antMatchers("/notice/**").permitAll()
                .antMatchers("/thisiswe/**").permitAll()
                .antMatchers("/display/**").permitAll()
//		.antMatchers("/**").permitAll()


                // 그 외 어떤 요청이든 '인증'
                .anyRequest().authenticated()
                .and()

                // 로그인 기능 허용
                .formLogin()

                // 로그인 View 제공 (GET /user/login)
                .loginPage("/thisiswe/login")
//		.loginPage("/user/login")

                // 로그인 즉 인증 처리를 하는 URL을 설정합니다.
                .loginProcessingUrl("/thisiswe/login")
//		.loginProcessingUrl("/user/login")

                // 정상적으로 인증성공 했을 경우 이동하고자 하는 페이지를 설정합니다. (default는 /)
                .defaultSuccessUrl("/thisiswe/home")

                // 로그인 실패 후 이동 페이지
                .failureUrl("/thisiswe/user/login?error")
                .permitAll()
                .and()
                // [로그아웃 기능]
                .logout()
                // 로그아웃 요청 처리 URL
                .logoutUrl("/logout")
                .permitAll()
                .and()
                .exceptionHandling()
                // "접근 불가" 페이지 URL 설정
                .accessDeniedPage("/forbidden.html");
        return http.build();
    }
}