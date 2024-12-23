package com.tech.videostreaming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@Slf4j
@SpringBootApplication
public class VideostreamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideostreamingApplication.class, args);
		log.info("Video Streaming application started successfully at [{}]", LocalDateTime.now());
	}

}
