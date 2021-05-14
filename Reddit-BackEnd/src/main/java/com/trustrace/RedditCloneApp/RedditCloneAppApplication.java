package com.trustrace.RedditCloneApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RedditCloneAppApplication {

	public static void main(String[] args) {
		System.out.println("Hello World..!");
		SpringApplication.run(RedditCloneAppApplication.class, args);
	}

}
