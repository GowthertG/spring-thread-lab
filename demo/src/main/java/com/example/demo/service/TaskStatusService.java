package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

@Service
public class TaskStatusService {

    public enum Status { RUNNING, COMPLETED, CANCELLED }

    private final Map<String, Status> taskStatusMap = new ConcurrentHashMap<>();
    private final Map<String, Future<?>> futureMap = new ConcurrentHashMap<>();

    public String createTask() {
        String id = UUID.randomUUID().toString();
        taskStatusMap.put(id, Status.RUNNING);
        return id;
    }

    public void setFuture(String id, Future<?> future) {
        futureMap.put(id, future);
    }

    public void markCompleted(String id) {
        taskStatusMap.put(id, Status.COMPLETED);
        futureMap.remove(id);
    }

    public void markCancelled(String id) {
        taskStatusMap.put(id, Status.CANCELLED);
        futureMap.remove(id);
    }

    public Status getStatus(String id) {
        return taskStatusMap.getOrDefault(id, null);
    }

    public boolean cancelTask(String id) {
        Future<?> future = futureMap.get(id);
        if (future != null) {
            boolean cancelled = future.cancel(true);
            if (cancelled) {
                markCancelled(id);
            }
            return cancelled;
        }
        return false;
    }
}
