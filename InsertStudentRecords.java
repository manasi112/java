import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudentRecords {
public static void main(String[] args) {
String url="jdbc:mysql://localhost:3306/nippani";
String username="root";
String password="";
Connection connection=null;
Statement statement=null;
try {
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection(url,username,password);
statement=connection.createStatement();
String[] insertQueries={
  "INSERT INTO student(roll_number,name,dept,email,phone) VALUES(1,'john Doe','Computer Science','john.doe@gmail.com','1234567890')",
  "INSERT INTO student(roll_number,name,dept,email,phone) VALUES(2,'Jane Smith','Electrical Engineering','jane.smith@gmail.com','0987654321')",
  "INSERT INTO student(roll_number,name,dept,email,phone) VALUES(3,'Mike Johnson','Mechanical Engineering','mike.johnson@gmail.com','1122334455')",
  "INSERT INTO student(roll_number,name,dept,email,phone) VALUES(4,'Emily Davis','Civil Engineering','emily.davis@gmail.com','2233445566')",
  "INSERT INTO student(roll_number,name,dept,email,phone) VALUES(5,'William Brown','Information Technology','william.brown@gmail.com','3344556677')",
};
for(String query:insertQueries) {
statement.executeUpdate(query);
}
System.out.println("Inserted 5 record into the 'student' table");
} catch(ClassNotFoundException e) {
 e.printStackTrace();
} catch(SQLException e) {
 e.printStackTrace();
} finally {
try {
 if(statement!=null)statement.close();
 if(connection!=null)connection.close();
} catch(SQLException e) {
 e.printStackTrace();
}
}
}
}
