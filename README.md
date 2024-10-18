

# Employee Management System

This Employee Management System is a web application built using Java Servlets and JDBC to perform CRUD (Create, Read, Update, Delete) operations on employee records. It allows administrators to manage employee details efficiently.

## Features

- **Register Employee**: Register new employee details into the system.
- **View Employee**: Display all employees along with their details.
- **Update Employee**: Modify the information of existing employees.
- **Delete Employee**: Remove an employee from the system.

## Technologies Used

- **Java Servlets**: For handling HTTP requests and responses.
- **JDBC**: For database connectivity and CRUD operations.
- **MySQL**: As the database for storing employee records.
- **HTML/CSS**: For the front-end design.
- **Apache Tomcat**: For deploying and running the application.

## Setup and Installation

### Prerequisites

- JDK (Java Development Kit) 8 or higher.
- MySQL database.
- Apache Tomcat server (version 9.0 or higher).
- IDE (such as Eclipse or IntelliJ IDEA).`

### Steps

1. Clone the repository:
   git clone https://github.com/Guptarag/EmployeeManagementSystem.git
   
2. Set up the MySQL database:
  Create a database called ems. In that database create a table employees. 
   
3. Update all the servlet classes with your database credentails :
   getConnection( "jdbc:mysql://localhost:3306/ems","your_username","your_password")
   
4. Import the project into your IDE and configure the Tomcat server.

5. Run the project on Tomcat and access the application.

## Screen Shots

### Login Page
![image](https://github.com/user-attachments/assets/fae9e527-d345-43b2-91b9-891bcb245521)

### View all Employees Page
![image](https://github.com/user-attachments/assets/3ccf56c2-32a3-432f-a716-2293b7ca042e)

### Updation Page
![image](https://github.com/user-attachments/assets/ea0fb5fd-faba-48d3-aaa8-d2ab994649ab)

### Employees Table Attributes
![image](https://github.com/user-attachments/assets/7b2e861b-d54e-4603-9839-be061b2e0293)



