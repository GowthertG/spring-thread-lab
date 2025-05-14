package com.example.demo.controller;

import com.example.demo.service.AsyncTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final AsyncTaskService asyncTaskService;

    @GetMapping("/tasks/async")
    public String triggerAsyncTask() {
        asyncTaskService.runHeavyTask();
        return "Async task triggered!";
    }
}

