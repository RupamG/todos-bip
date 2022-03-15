# todos-bip

Download and import the project in your eclipse IDE.

# technologies used:

  1. Springboot
  2. MySQL
  3. Spring Data Jpa

# precheck:

## Create the below table in your MYSQL database

create table Todo(
task_Id int PRIMARY KEY,
task_desc varchar(30),
task_status varchar(12)
);

## application.properties (src/main/resources)

Put your MySQL database name, username and password in the placeholders.

spring.datasource.url=jdbc:mysql://localhost/{Your Database name}
spring.datasource.username={username}
spring.datasource.password={password}

spring.jpa.database = mysql
spring.jackson.serialization.FAIL_ON_EMPTY_BEANS=false

# For health check up:
  1. Right cick on the project and click on mvn build (set goal as clean install)
  2. Run the project using command = java -jar target/Todos-0.0.1-SNAPSHOT.jar
  3. Hit the below URL from your browser.
      http://localhost:8080/actuator/health
  4. You will see {"status":"UP"} 
      
# For runnig the project:

 1. Go to /Todos/src/main/java/com/bip/todo/main/TodosApplication.java
 2. Right click on the java file and run as java application.

# Endpoints: (For testing in Postman)

  1. Get all todos(GET) : http://localhost:8080/todos/
  2. Get Todo by Id(GET) : http://localhost:8080/todos/getById/{put id here}
  3. Get Todo By task status(GET) : http://localhost:8080/todos/getByTaskStatus/{either put completed or incomplete}
  4. Adding a Todo(POST) :  http://localhost:8080/todos/ 
      sample data in request body: {
        "taskId": 1,
        "taskDesc": "Have to go shopping",
        "taskStatus": "completed"
    }

  5. Updating a Todo(PUT) : http://localhost:8080/todos/
       sample data in request body: {
        "taskId": 1,
        "taskDesc": "Have to go shopping",
        "taskStatus": "completed"
    }
  6. Delete a todo(DELETE) : http://localhost:8080/todos/{put id here}



    
