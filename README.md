

# EMS (Employee Management System) - Setup Guide

EMS is a Spring Boot application designed for managing employees. It utilizes Thymeleaf and Bootstrap 4 for the frontend and connects to a MySQL database named `ems_liquibase`.

## Prerequisites

Before you begin, ensure you have the following installed:

- JDK 17
- Maven
- MySQL 
- Git
- Make sure lombok is installed in your IDE if not please install lombok in your IDE
## Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/ngeducation6/samplesbapp.git
cd samplesbapp
```

### 2. Checkout the branch

```bash
git checkout EMS_kiran
```
This branch contains the latest updates for the application.

### 3. Configure MySQL database

- Navigate to `src/main/resources`.
- Locate `application-mysql.properties`.
- Update the datasource properties:

  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/ems_liquibase
  spring.datasource.username=${your-username}
  spring.datasource.password=${your-password}
  ```

  Replace `${your-username}` and `${your-password}` with your MySQL credentials.

### 4. Set Environment Variables

- **Windows:**
  - Open the Start menu and search for "Environment Variables".
  - Click on "Edit the system environment variables".
  - In the System Properties window, click on "Environment Variables...".
  - Under System Variables, click "New..." to add new variables:

    Example for MySQL password:
    - Variable name: `MYSQL_PASSWORD`
    - Variable value: `1234` (your MySQL password)

- Link the variable in `application-mysql.properties`:

  ```properties
  spring.datasource.password=${MYSQL_PASSWORD}
  ```

- Restart your command prompt or IDE for the environment variables to take effect.

### 5. Additional Spring Boot Settings

- **Change Server Port:**

  If you need to change the server port, update `application.properties` or `application.yml`:

  ```properties
  # application.properties
  server.port=3002  # or your desired port
  ```


### 6. Build the JAR file

- Right-click on the project.
- Select "Run As" -> "Maven build".
- Set goals to `clean package`.
- Click "Run".

You will see the build success message, and the `.jar` file will be generated in the `target` folder.

### 7. Access the Application

- Once the application is running, you can access it at `http://localhost:3002` (or your specified port).

---

