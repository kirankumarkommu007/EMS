
# Employee Management System (EMS)

EMS is a Spring Boot application designed for managing employees. It utilizes Thymeleaf and Bootstrap 4 for the frontend and connects to a MySQL database.

## Prerequisites

Before you begin, ensure you have the following installed:

- JDK 17
- Maven
- MySQL
- Git
- Lombok (installed in your IDE)

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/ngeducation6/samplesbapp.git
   cd samplesbapp
   ```

2. **Checkout the Branch**
   ```bash
   git checkout EMS_kiran
   ```
   This branch contains the latest updates for the application.

3. **Set MySQL Properties**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ems_liquibase
   spring.datasource.username=${MYSQL_USERNAME}
   spring.datasource.password=${MYSQL_PWD}
   ```
   - Create a database in MySQL with the name **ems_liquibase**.
   - Set the environment variables for MySQL credentials.

4. **Set MySQL Environment Variables (Windows)**
   - Open Command Prompt and run the following commands:
     ```cmd
     set MYSQL_USERNAME=your_mysql_username
     set MYSQL_PWD=your_mysql_password
     ```

5. **Set MySQL Environment Variables (Linux)**
   - Open a terminal and run the following commands:
     ```bash
     export MYSQL_USERNAME=your_mysql_username
     export MYSQL_PWD=your_mysql_password
     ```

6. **Build and Run the Application**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   - If using an IDE, you can run the application directly from there.

7. **Access the Application**
   - Once the application is running, you can access it at `http://localhost:3002`.
```
