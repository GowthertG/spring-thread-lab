package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RawThreadExample {

    public static void runAllExamples() {
        runThreadByExtending();
        runThreadWithRunnable();
        runThreadWithLambda();
        runThreadWithExecutor();
    }

    // 1. Extending Thread class
    public static void runThreadByExtending() {
        class MyThread extends Thread {
            @Override
            public void run() {
                log.info("Thread by extending class: {}", Thread.currentThread().getName());
            }
        }
        new MyThread().start();
    }

    // 2. Implementing Runnable interface
    public static void runThreadWithRunnable() {
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                log.info("Thread with Runnable: {}", Thread.currentThread().getName());
            }
        }
        new Thread(new MyRunnable()).start();
    }

    // 3. Using a lambda expression
    public static void runThreadWithLambda() {
        Runnable task = () -> log.info("Thread with Lambda: {}", Thread.currentThread().getName());
        new Thread(task).start();
    }

    // 4. Using ExecutorService
    public static void runThreadWithExecutor() {
        java.util.concurrent.Executor executor = java.util.concurrent.Executors.newSingleThreadExecutor();
        executor.execute(() -> log.info("Thread with ExecutorService: {}", Thread.currentThread().getName()));
    }
}
