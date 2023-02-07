package com.thisiswe.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

//TODO [날짜] 등록일, 수정일, 삭제일
@EnableJpaAuditing
public class Bpro0511Application {

	public static void main(String[] args) {
		SpringApplication.run(Bpro0511Application.class, args);
	}

}
