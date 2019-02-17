package com.example.saein.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class schedulerTask {

	@Scheduled(fixedDelay =  1000)
	public void reportPerMinute() {
		System.out.println("스케줄러 솰라솰라~~");
	}
	
}
