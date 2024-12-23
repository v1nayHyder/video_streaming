package com.tech.videostreaming;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;


@SpringBootApplication
public class VideostreamingApplication {
	private static final Logger log = LoggerFactory.getLogger(VideostreamingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VideostreamingApplication.class, args);
		log.info("Video Streaming application started successfully at [{}]", LocalDateTime.now());
	}

}
