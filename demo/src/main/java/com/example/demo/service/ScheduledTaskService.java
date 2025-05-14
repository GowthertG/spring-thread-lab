package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ScheduledTaskService {

    @Scheduled(fixedRate = 10000) // every 10 seconds
    public void reportTaskStatus() {
        log.info("Scheduled task running at {}", System.currentTimeMillis());
    }
}
