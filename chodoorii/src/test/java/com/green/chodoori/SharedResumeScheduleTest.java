package com.green.chodoori;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SharedResumeScheduleTest {
	
	@Test
	@Scheduled(cron = "*/20 * * * * *")
	public void Schedule(){
		log.info("20초마다 작동중임 : {}", Calendar.getInstance().getTime());
		
	}
}
