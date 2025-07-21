# 🧑‍💼 Employee Management System (Core Java + JDBC)

This is a **console-based Employee Management System** developed using **Core Java** and **JDBC**. It allows you to perform CRUD (Create, Read, Update, Delete) operations on employee records stored in a MySQL database.

---

## 📋 Features

- ➕ Add a new employee
- 🔍 Retrieve employee by ID
- 📝 Update employee's **name**, **branch**, or **salary** individually
- ❌ Delete employee by ID
- ✅ Input validation (name must be a string, ID must be numeric, etc.)
- 🧩 Layered architecture (Entity → DAO → Service → Main)
- 💾 Data persistence using JDBC + MySQL

---

## 🛠 Technologies Used

- Java 17+
- JDBC
- MySQL Database
- Git & GitHub

---

## ⚙️ How to Run This Project

### 🧰 Prerequisites:
- JDK installed (17 or higher recommended)
- MySQL running locally
- Java IDE (IntelliJ, Eclipse) or terminal

---

### 🏁 Steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Abhishek-Git-01/Employee-Management-System-Using-Core-Java.git
   cd Employee-Management-System-Using-Core-Java

### Database creation
CREATE DATABASE employeedb;
USE employeedb;

CREATE TABLE Employee (
    empId INT PRIMARY KEY,
    name VARCHAR(100),
    branch VARCHAR(100),
    salary DOUBLE
);
# DB credentials
String url = "jdbc:mysql://localhost:3306/employeedb";
String user = "root";
String password = "your_password";
