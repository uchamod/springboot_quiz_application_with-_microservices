# Microservices-Based Quiz Application

A scalable quiz application built using Spring Boot microservices architecture, featuring service discovery with Eureka Server and persistent storage with MySQL.

## Architecture Overview

The application is composed of the following microservices:

- **Quiz Service**: Manages quiz creation, retrieval, and lifecycle
- **Question Service**: Handles question bank operations and quiz question management
- **Eureka Server**: Enables service discovery and registration
- **API Gateway** (Optional): Provides a unified entry point for client applications

```
┌─────────────┐     ┌──────────────┐
│             │     │              │
│ API Gateway │─────┤ Eureka Server│
│             │     │              │
└─────────────┘     └──────────────┘
       │                   │
       │            ┌──────┴───────┐
       │            │              │
       ├────────────┤ Quiz Service │
       │            │              │
       │            └──────────────┘
       │            ┌──────────────┐
       │            │   Question   │
       └────────────┤   Service    │
                    │              │
                    └──────────────┘
```

## Technology Stack

- **Framework**: Spring Boot 3.x
- **Build Tool**: Maven
- **Database**: MySQL 8.x
- **Service Discovery**: Netflix Eureka
- **API Gateway**: Spring Cloud Gateway
- **Java Version**: 17 or higher

## Prerequisites

- JDK 17+
- Maven 3.6+
- MySQL 8.x
- Docker (optional, for containerization)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/uchamod/springboot_quiz_application_with-_microservices.git
cd quiz-application
```

### 2. Database Setup

```sql
CREATE DATABASE quiz_service;
CREATE DATABASE question_service;
```

### 3. Configure Application Properties

Each service has its own `application.properties` file. Update database credentials and other configurations as needed.

Example for Quiz Service:
```properties
spring.application.name=quiz-service
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/quiz_service
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 4. Start Services

Start the services in the following order:

1. Eureka Server
```bash
cd eureka-server
mvn spring-boot:run
```

2. Question Service
```bash
cd question-service
mvn spring-boot:run
```

3. Quiz Service
```bash
cd quiz-service
mvn spring-boot:run
```

4. API Gateway (Optional)
```bash
cd api-gateway
mvn spring-boot:run
```

## API Documentation

### Quiz Service Endpoints

```
GET /api/quizzes - List all quizzes
POST /api/quizzes - Create a new quiz
GET /api/quizzes/{id} - Get quiz by ID
PUT /api/quizzes/{id} - Update quiz
DELETE /api/quizzes/{id} - Delete quiz
```

### Question Service Endpoints

```
GET /api/questions - List all questions
POST /api/questions - Add new question
GET /api/questions/{id} - Get question by ID
PUT /api/questions/{id} - Update question
DELETE /api/questions/{id} - Delete question
```

## Docker Support

Build and run services using Docker:

```bash
# Build Docker images
docker-compose build

# Run services
docker-compose up
```

## Testing

Run unit tests:
```bash
mvn test
```

Run integration tests:
```bash
mvn verify
```

## Monitoring

Access service health and metrics:

- Eureka Dashboard: http://localhost:8761
- Quiz Service Actuator: http://localhost:8081/actuator
- Question Service Actuator: http://localhost:8082/actuator

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit changes
4. Push to the branch
5. Create a Pull Request

## Project Structure

```
quiz-application/
├── eureka-server/
├── quiz-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── question-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── api-gateway/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── docker-compose.yml
└── README.md
```

## Troubleshooting

Common issues and solutions:

1. **Service Registration Failed**
   - Verify Eureka Server is running
   - Check service configuration properties
   - Ensure correct network connectivity

2. **Database Connection Issues**
   - Verify MySQL is running
   - Check database credentials
   - Confirm database exists and is accessible

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Spring Boot and Spring Cloud teams
- Netflix Eureka
- MySQL community

For more information or support, please open an issue in the repository.
