import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStaffRecords {
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
  "INSERT INTO staff(id_number,name,dept,email,phone) VALUES(1150048,'Madhura Joshi','Manager','madhura.joshi@gmail.com','1234567890')",
  "INSERT INTO staff(id_number,name,dept,email,phone) VALUES(1260022,'Joyti Mahajan','Ceo','joyti.mahajan@gmail.com','0987654321')",
  "INSERT INTO staff(id_number,name,dept,email,phone) VALUES(1343045,'Anuratha Patil','Employee','anuratha.patil@gmail.com','1122334455')",
  "INSERT INTO staff(id_number,name,dept,email,phone) VALUES(1460021,'Sanika Shintre','Acistant','sanika.shintre@gmail.com','2233445566')",
  "INSERT INTO staff(id_number,name,dept,email,phone) VALUES(1572100,'Nikita Kumatole','Leader','nikita kumatole@gmail.com','3344556677')",
};
for(String query:insertQueries) {
statement.executeUpdate(query);
}
System.out.println("Inserted 5 record into the 'staff' table");
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
