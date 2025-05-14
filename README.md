# 🧵 spring-thread-lab

A mini Spring Boot project to explore and demonstrate threading concepts including `@Async`, `@Scheduled`, `CompletableFuture`, executor configuration, and more.

---


## 🚀 Features Covered

This project helps understand and compare:
- High-level async programming in Spring Boot
- Manual thread creation using native Java (`Thread`, `Runnable`, `Executor`)
- Task tracking, scheduling, and thread pool configuration
- Graceful shutdown of async executors
---

## 📦 Endpoints

| Method | Endpoint             | Description                                |
| ------ | -------------------- | ------------------------------------------ |
| POST   | `/tasks/start`       | Start async task and return task ID        |
| GET    | `/tasks/status/{id}` | Check status of a running task             |
| GET    | `/tasks/async`       | Trigger a basic async task (no tracking)   |
| GET    | `/threads/raw`       | Run examples using Java’s native threading |

---

## 🧰 Tech Stack

- Java 21
- Spring Boot 3.x
- Maven
- Spring Web / Scheduling / Async
-  Lombok

---

## 🛠️ Running the App

```bash
# clone the repo
git clone https://github.com/GowthertG/spring-thread-lab.git
cd spring-thread-lab

# run with Maven
./mvnw spring-boot:run
```
