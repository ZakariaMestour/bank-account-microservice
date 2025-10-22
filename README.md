# bank-account-microservice

## 🚀 Overview
The `bank-account-microservice` is a robust Java-based microservice designed to manage bank accounts. This service provides a comprehensive API for creating, updating, deleting, and retrieving bank accounts, along with support for GraphQL queries and mutations. Ideal for developers looking to build scalable and maintainable financial applications.

## ✨ Features
- 🔒 Secure account management
- 📈 Real-time account updates
- 📊 Detailed account reporting
- 🌐 RESTful and GraphQL APIs
- 💸 Support for multiple account types (current and savings)

## 🛠️ Tech Stack
- **Programming Language:** Java
- **Frameworks:** Spring Boot, Spring Data JPA, Spring GraphQL
- **Database:** MySQL
- **Tools:** Lombok, Maven
- **System Requirements:** Java 17, MySQL 8.x

## 📦 Installation

### Prerequisites
- Java 17
- MySQL 8.x
- Maven

### Quick Start
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/bank-account-microservice.git
    cd bank-account-microservice
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

### Alternative Installation Methods
- **Docker:** You can use Docker to run the application. A Dockerfile is included in the repository.
    ```bash
    docker build -t bank-account-microservice .
    docker run -p 8080:8080 bank-account-microservice
    ```

## 🎯 Usage

### Basic Usage
```java
// Example of creating a new bank account
BankAccountRequestDTO newAccount = BankAccountRequestDTO.builder()
    .balance(1000.0)
    .currency("MAD")
    .type(AccountType.CURRENT_ACCOUNT)
    .build();

BankAccountResponseDTO createdAccount = accountService.addAccount(newAccount);
System.out.println("Created Account: " + createdAccount);
```

### Advanced Usage
- **GraphQL Queries:**
    ```graphql
    query {
      accountsList {
        id
        type
        balance
        currency
      }
    }
    ```

- **GraphQL Mutations:**
    ```graphql
    mutation {
      addBankAccount(input: {balance: 2000.0, currency: "MAD", type: CURRENT_ACCOUNT}) {
        id
        type
        balance
        currency
      }
    }
    ```

## 📁 Project Structure
```
bank-account-microservice/
├── .gitignore
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── poo/
│   │   │       └── accountservice/
│   │   │           ├── AccountServiceApplication.java
│   │   │           ├── dtos/
│   │   │           │   ├── BankAccountRequestDTO.java
│   │   │           │   └── BankAccountResponseDTO.java
│   │   │           ├── entities/
│   │   │           │   ├── AccountProjection.java
│   │   │           │   ├── BankAccount.java
│   │   │           │   └── Customer.java
│   │   │           ├── enums/
│   │   │           │   └── AccountType.java
│   │   │           ├── exceptions/
│   │   │           │   └── CustomDataFetcherExceptionResolver.java
│   │   │           ├── mappers/
│   │   │           │   └── AccountMapper.java
│   │   │           ├── repositories/
│   │   │           │   ├── BankAccountRepository.java
│   │   │           │   └── CustomerRepository.java
│   │   │           ├── services/
│   │   │           │   ├── AccountService.java
│   │   │           │   └── AccountServiceImpl.java
│   │   │           └── web/
│   │   │               ├── AccountRestController.java
│   │   │               └── BankAccountGraphQLController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── poo/
│               └── accountservice/
│                   └── AccountServiceApplicationTests.java
└── README.md
```

## 🔧 Configuration
- **application.properties:**
    ```properties
    spring.application.name=account-service
    spring.datasource.url=jdbc:mysql://192.168.52.142:3306/SpringBootApp #(MySql docker container)
    spring.datasource.username=root
    spring.datasource.password=admin
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.hikari.maximum-pool-size=10
    spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
    spring.jpa.hibernate.ddl-auto=create
    spring.graphql.graphiql.enabled=true
    ```

## 🤝 Contributing
We welcome contributions! Please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Write clean, well-documented code.
4. Run tests to ensure your changes do not break existing functionality.
5. Submit a pull request.

## 📝 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors & Contributors
- **Maintainer:** [Your Name]
- **Contributors:** [List of contributors]

## 🐛 Issues & Support
- Report issues on the [GitHub Issues page](https://github.com/yourusername/bank-account-microservice/issues).
- For support, please open an issue or contact the maintainer.

## 🗺️ Roadmap
- **Planned Features:**
  - Add support for more account types
  - Implement user authentication and authorization
  - Improve API documentation
- **Known Issues:**
  - [Issue 1](https://github.com/yourusername/bank-account-microservice/issues/1)
  - [Issue 2](https://github.com/yourusername/bank-account-microservice/issues/2)
- **Future Improvements:**
  - Enhance performance and scalability
  - Add more comprehensive testing

---

**Badges:**
[![Build Status](https://travis-ci.com/yourusername/bank-account-microservice.svg?branch=main)](https://travis-ci.com/yourusername/bank-account-microservice)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.6-green)](https://spring.io/projects/spring-boot)
