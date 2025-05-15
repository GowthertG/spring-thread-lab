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
    public void runTaskWithId(String taskId) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10000); // simulate long task
                log.info("Task {} completed", taskId);
                taskStatusService.markCompleted(taskId);
            } catch (InterruptedException e) {
                log.warn("Task {} was interrupted", taskId);
                Thread.currentThread().interrupt();
            }
        });

        taskStatusService.setFuture(taskId, future);
    }
    @Async
    public void taskThatFails() {
        throw new RuntimeException("Simulated async failure");
    }
    @Async
    public CompletableFuture<String> taskWithTimeout() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000); // Simulate long task (10s)
                return "Finished successfully";
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Interrupted";
            }
        }).orTimeout(3, java.util.concurrent.TimeUnit.SECONDS);
    }
}
