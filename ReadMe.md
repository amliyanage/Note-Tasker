# Note Tasker - Backend

**Note Tasker** is a backend service for managing tasks and notes. Built using the Spring Framework, it provides RESTful APIs for handling tasks such as creating, updating, and deleting notes. The backend uses MySQL for persistent storage, with transaction management and JPA for data handling.

## Features

- **Create Notes & User**: API to create new User or notes.
- **Edit Notes & User**: API to update existing User or notes.
- **Delete & User**: API to remove User or notes.
- **List All Tasks & User**: API to fetch all User or notes.

## Technologies Used

- **Backend Framework**: Spring
- **Database**: MySQL
- **Server**: Tomcat
- **Build Tool**: Maven
- **Version Control**: Git

The backend configuration is done using Java-based Spring configuration. Here's a summary of the key configuration elements:

1. **ModelMapper**: A utility to map DTOs and entities.
2. **DataSource**: Configured to connect to a MySQL database:
    - **URL**: `jdbc:mysql://localhost:3306/notetraker?createDatabaseIfNotExist=true`
    - **Username**: `username`
    - **Password**: `password`
3. **EntityManagerFactory**: Uses Hibernate JPA to manage the persistence layer.
4. **Transaction Management**: Configured with `JpaTransactionManager` for handling database transactions.
