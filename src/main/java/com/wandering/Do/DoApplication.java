package com.wandering.Do;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.TimeZone;

@SpringBootApplication
public class DoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoApplication.class, args);

		LocalDateTime now = LocalDateTime.now();
		System.out.println("현재시간 " + now);
	}
	@PostConstruct
	public void init() {
		// timezone 설정
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

}
