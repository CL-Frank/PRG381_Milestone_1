# BCWellness Web
PRG381 Project Milestone 1
## Project Members

- **Caydan Frank 578131**  
- **Vunene Khoza 600676**   
- **Yanga Mazibuko 600459**

## Setup Instructions

### 1. Prerequisites
- **NetBeans (recommended version 15+)**
- **Apache Tomcat 9 or 10**
- **PostgreSQL installed locally**
- **Git**

### 2. 🗃️ Clone the Repository
```bash
git clone https://github.com/your-username/BCWellnessWeb.git
```

### 3. 🧱 PostgreSQL Setup

Ensure PostgreSQL is installed and running on your system.

#### 📌 Step 1: Create the Database

Connect to PostgreSQL using a tool like `pgAdmin` or `psql`, and run:

```sql
CREATE TABLE students (
    student_number VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    password VARCHAR(255) NOT NULL
);
```
### 4. Db Config
In the DBConfig file, change the following to mathc your databse credentials:
```java
private static final String URL = "jdbc:postgresql://localhost:5432/"db_name";
private static final String USER = "your_postgres_username";
private static final String PASSWORD = "your_password";
```
### 📦5. Required Libraries

Ensure the following `.jar` files are present in the `lib/` directory of the project:

- [`servlet-api.jar`](https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api)
- [`postgresql-42.x.x.jar`](https://jdbc.postgresql.org/download/)

#### 🔧 Add JARs in NetBeans
1. Right-click your project → **Properties**
2. Go to **Libraries** → **Compile**
3. Click **Add JAR/Folder** → Select the above JARs from the `lib/` directory

#### 📚 Add CopyLibs Library
1. Right-click your project → **Properties**
2. Go to **Libraries** → **Compile**
3. Click **Add Library**
4. Select **CopyLibs Library** from the list
5. Click **Add Library** and then **OK**

> This ensures NetBeans can correctly build and include external libraries in the output.




