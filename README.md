# 🧵 spring-thread-lab

A mini Spring Boot project to explore and demonstrate threading concepts including `@Async`, `@Scheduled`, `CompletableFuture`, executor configuration, and more.

---


## 🚀 Features Covered

- `@Async` for executing methods in background threads
- Custom `ThreadPoolTaskExecutor` configuration
- `@Scheduled` for periodic and delayed tasks
- `CompletableFuture` for async return values and chaining
- Manual task submission with `ExecutorService`
- Exception handling in async methods
- Graceful shutdown using `@PreDestroy`
- Integration of **virtual threads** (Java 21+)

---

## 📦 Endpoints

| Method | Endpoint               | Description                              |
|--------|------------------------|------------------------------------------|
| POST   | `/tasks/async`         | Launches a fake long-running async task  |
| GET    | `/tasks/status/{id}`   | Returns the result or status of a task   |
| POST   | `/tasks/error`         | Simulates a failing async task           |
| GET    | `/tasks/manual`        | Submits a manual task via executor       |
| GET    | `/health/ping`         | Simple ping endpoint (can trigger logs)  |

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
