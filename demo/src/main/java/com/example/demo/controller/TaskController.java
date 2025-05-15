package com.example.demo.controller;

import com.example.demo.service.AsyncTaskService;
import com.example.demo.service.RawThreadExample;
import com.example.demo.service.TaskStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final AsyncTaskService asyncTaskService;
    private final TaskStatusService taskStatusService;

    @PostMapping("/start")
    public Map<String, String> startTask() {
        String taskId = taskStatusService.createTask();
        asyncTaskService.runTaskWithId(taskId);
        return Map.of("taskId", taskId);
    }

    @GetMapping("/status/{id}")
    public Map<String, String> getTaskStatus(@PathVariable String id) {
        TaskStatusService.Status status = taskStatusService.getStatus(id);
        if (status == null) {
            return Map.of("status", "UNKNOWN");
        }
        return Map.of("status", status.name());
    }
    @GetMapping("/threads/raw")
    public String runRawThreadExamples() {
        RawThreadExample.runAllExamples();
        return "All raw thread examples started";
    }
    @GetMapping("/fail")
    public String triggerFailingTask() {
        asyncTaskService.taskThatFails();
        return "Failing async task triggered.";
    }
    @GetMapping("/timeout")
    public CompletableFuture<String> triggerTimeout() {
        return asyncTaskService.taskWithTimeout()
                .exceptionally(ex -> "Task failed: " + ex.getMessage());
    }
    @DeleteMapping("/cancel/{id}")
    public Map<String, String> cancelTask(@PathVariable String id) {
        boolean result = taskStatusService.cancelTask(id);
        return Map.of("cancelled", String.valueOf(result));
    }

}
