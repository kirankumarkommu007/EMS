# Employee Management System (EMS)

EMS is a Spring Boot application designed for managing employees. It utilizes Thymeleaf and Bootstrap 4 for the frontend and connects to a MySQL database.

## We can run this EMS application in two ways:
- with your local system
- with Docker

## Setup Instructions for Running with Local System

### Prerequisites

Before you begin, ensure you have the following installed:

- [JDK 17](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/)
- [Git](https://git-scm.com/downloads)
- [Lombok](https://projectlombok.org/download) (installed in your IDE)

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

3. **Set MySQL Environment Variables using CLI**

   - Open Command Prompt
   - Navigate to Your Project Directory
     ```cmd
     cd path\to\your\project
     ```
   - Make sure you have a MySQL database set up. If not, create a MySQL database instance.
   - Set your database details using environment variables:

     **For Windows:**
     ```cmd
     set SERVER_PORT=your_port_number
     set SPRING_DATASOURCE_URL=jdbc:mysql://localhost:your_MYSQL_port/your_database
     set SPRING_DATASOURCE_USERNAME=your_mysql_username
     set SPRING_DATASOURCE_PASSWORD=your_mysql_password
     ```

     **For Linux/Mac:**
     ```bash
     export SPRING_DATASOURCE_URL=jdbc:mysql://localhost:your_MYSQL_port/your_database
     export SPRING_DATASOURCE_USERNAME=your_mysql_username
     export SPRING_DATASOURCE_PASSWORD=your_mysql_password
     export SERVER_PORT=your_port_number
     ```

6. **Build and Run the Application**

   - Open Command Prompt navigate to your project and run the following command:
     ```bash
     mvn spring-boot:run
     ```

8. **Access the Application**

   - Once the application is running, you can access it at `http://localhost:(your_port_number)/hello`.
   - This is a public API to check whether the project is running; you will see the message "hi this is ems application".

---

## Setup Instructions for Running with Docker Compose

### Prerequisites

Before you begin, make sure you have the following installed on your system:

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Git](https://git-scm.com/downloads)

### Getting Started

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

3. **Run Docker Compose**

   Ensure Docker and Docker Compose are installed and configured on your system. Use the following command to start the application stack:

   ```bash
   docker-compose up --build
   ```

   - **Customizing Port (Optional)**:
     If you need to run the application on a specific port, set `SERVER_PORT` before running `docker-compose`:
     ```bash
     SERVER_PORT=your_port_number docker-compose up --build
     ```

4. **Access the Application**

   Once the containers are up and running, you can access your application and check the API:

   - **API Endpoint**: `/hello`
   - **URL for your server**: `http://localhost:(your_port_number)/hello`
   - **Default port if not set**: http://localhost:3002/hello
   - **Description**: Hi this is EMS Application.

### Stopping the Application

To stop the application and shut down the containers, use the following command in your terminal:

```bash
docker-compose down
```

---
