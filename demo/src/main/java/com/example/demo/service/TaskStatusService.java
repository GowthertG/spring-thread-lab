package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TaskStatusService {

    public enum Status { RUNNING, COMPLETED }

    private final Map<String, Status> taskStatusMap = new ConcurrentHashMap<>();

    public String createTask() {
        String id = UUID.randomUUID().toString();
        taskStatusMap.put(id, Status.RUNNING);
        return id;
    }

    public void markCompleted(String id) {
        taskStatusMap.put(id, Status.COMPLETED);
    }

    public Status getStatus(String id) {
        return taskStatusMap.getOrDefault(id, null);
    }
}
