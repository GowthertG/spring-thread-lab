package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncTaskService {

    @Async
    public void runHeavyTask() {
        log.info("Started async task on thread: {}", Thread.currentThread().getName());
        try {
            Thread.sleep(5000); // simulate long processing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Task was interrupted", e);
        }
        log.info("Finished async task on thread: {}", Thread.currentThread().getName());
    }
}

