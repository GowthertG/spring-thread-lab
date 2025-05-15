# 🧵 spring-thread-lab

A mini Spring Boot project to explore and demonstrate threading concepts including `@Async`, `@Scheduled`, `CompletableFuture`, executor configuration, and more.

---


## 🚀 Features Covered

This project helps understand and compare:
- High-level async programming in Spring Boot (`@Async`)
- Task tracking with `CompletableFuture` and status endpoints
- Manual task cancellation using `Future.cancel()`
- Task timeouts using `CompletableFuture.orTimeout(...)`
- Exception handling in `@Async` methods
- Periodic execution with `@Scheduled`
- Manual thread creation using native Java (`Thread`, `Runnable`, `Executor`)
- Thread pool configuration and graceful shutdown

---

## 📦 Endpoints

| Method | Endpoint               | Description                                 |
|--------|------------------------|---------------------------------------------|
| POST   | `/tasks/start`         | Start async task and return task ID         |
| GET    | `/tasks/status/{id}`   | Check status of a running task              |
| DELETE | `/tasks/cancel/{id}`   | Cancel a running task                       |
| GET    | `/tasks/timeout`       | Run a task that fails if it takes too long  |
| GET    | `/tasks/fail`          | Trigger a task that throws an exception     |
| GET    | `/threads/raw`         | Run examples using Java’s native threading  |

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
