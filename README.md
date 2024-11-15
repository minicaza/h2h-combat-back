# H2H Combat

## Introduction
The Rock, Paper, Scissors game application built using Spring Boot.

## Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
3. [Prerequisites](#prerequisites)
4. [Installation](#installation)
5. [Running the Application](#running-the-application)
6. [Configuration](#configuration)
7. [Usage](#usage)
8. [Testing](#testing)
9. [Contributing](#contributing)
10. [License](#license)
11. [Contact](#contact)

## Features
- Play a game of Rock, Paper, Scissors
- View game history
- Actuator endpoints for monitoring _Not implemented 100%_
- Elasticsearch integration for game storage
- PostgreSQL for relational data storage

## Prerequisites
- Java 17
- Maven 3.6.0+
- PostgreSQL
- Elasticsearch

## Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/h2h-combat-back.git
    ```
2. Navigate to the project directory:
    ```bash
    cd h2h-combat-back
    ```

## Running the Application
1. Build the project using Maven:
    ```bash
    mvn clean install
    ```
2. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

## Configuration
### Application Properties
Modify the `application.properties` file to configure the database and other settings.

### Example:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/yourdb
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

spring.elasticsearch.uris=http://localhost:9200
spring.elasticsearch.username=yourusername
spring.elasticsearch.password=yourpassword

# Flyway settings
spring.flyway.url=jdbc:postgresql://localhost:5432/yourdb
spring.flyway.user=yourusername
spring.flyway.password=yourpassword
```

## Usage
### API Endpoints
List and describe the available API endpoints.

#### Example:
- `POST /h2h-combat/play`: Play a game of Rock, Paper, Scissors.
    - **Request Body**: `"ROCK"`, `"PAPER"`, or `"SCISSORS"`
    - **Response**:
    ```json
    {
        "id": 1,
        "title": "Game 1",
        "playerMove": "ROCK",
        "computerMove": "PAPER",
        "result": {
            "message": "CPU wins!",
            "winner": "cpu"
        }
    }
    ```
- `GET /h2h-combat/history`: Retrieve all games played.
- **Response**:
  ```json
  [
    {
        "id": 302,
        "title": "Game 302",
        "playerMove": "ROCK",
        "computerMove": "PAPER",
        "result": {
            "message": "CPU wins!",
            "winner": "cpu"
        }
    },
    {
        "id": 303,
        "title": "Game 303",
        "playerMove": "ROCK",
        "computerMove": "ROCK",
        "result": {
            "message": "It's a tie!",
            "winner": null
        }
    }
  ]
  ´´´

## Testing
1. **Unit Tests**:
    Run unit tests using Maven.
    ```bash
    mvn test
    ```

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Create a new Pull Request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact
- **Javier Cazalilla Costa**: [javiercazalillacosta@gmail.com](mailto:javiercazalillacosta@gmail.com)
- **Project Link**: [https://github.com/minicaza/h2h-combat-back](https://github.com/minicaza/h2h-combat-back)
