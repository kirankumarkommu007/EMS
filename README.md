
# Employee Management System (EMS)

EMS is a Spring Boot application designed for managing employees. It utilizes Thymeleaf and Bootstrap 4 for the frontend and connects to a MySQL database.
## Setup Instructions for Running with Local System

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
   This branch contains the latest updates for the application..
     
3. **Set MySQL Environment Variables**
   - Open Command Prompt
   - Navigate to Your Project Directory
      ```cmd
     cd path\to\your\project
      ```
   
    **WINDOWS**
     ```cmd
     set MYSQL_DATABASE=your_database_name
     set MYSQL_USERNAME=your_mysql_username
     set MYSQL_PASSWORD=your_mysql_password
     ```
    **LINUX**

     ```bash
     export MYSQL_DATABASE=your_database_name
     export MYSQL_USERNAME=your_mysql_username
     export MYSQL_PASSWORD=your_mysql_password
     ```

6. **Build and Run the Application**
      - Open Command Prompt navigate to your project and run the following commands:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

8. **Access the Application**
   - Once the application is running, you can access it at `http://localhost:3002/hello`.
   - this is public api to check whether the project is running you can see message "hi this is ems application"
Certainly! Here’s an updated README template that emphasizes the prerequisites and provides clear instructions for running the application with Docker Compose:

## Setup Instructions for Running with Docker Compose

### Prerequisites

Before you begin, make sure you have the following installed on your system:

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Git](https://git-scm.com/)

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

   This command will build the Docker images (if not already built) and start the containers as defined in your `docker-compose.yml` file.

4. **Access the Application**

   Once the containers are up and running, you can access your application and check the API:

   - **API Endpoint**: `/hello`
   - **URL**: `http://localhost:3002/hello`
   - **Description**: Hi this is EMS Application.

### Stopping the Application

To stop the application and shut down the containers, use the following command in your terminal:

```bash
docker-compose down
```
