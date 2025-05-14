package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsyncTaskService {

    private final TaskStatusService taskStatusService;

    @Async
    public CompletableFuture<Void> runTaskWithId(String taskId) {
        log.info("Task {} started on thread {}", taskId, Thread.currentThread().getName());
        try {

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Task {} finished", taskId);
        taskStatusService.markCompleted(taskId);
        return CompletableFuture.completedFuture(null);
    }
}
