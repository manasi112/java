import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateStaffTable {
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
String createTableSQL="CREATE TABLE staff("+"id_number INT NOT NULL,"
                                             +"name VARCHAR(100)NOT NULL,"
                                             +"dept VARCHAR(50)NOT NULL,"
                                             +"email VARCHAR(100),"
                                             +"phone VARCHAR(15),"
                                             +"PRIMARY KEY(roll_number)");
statement.executeUpdate(createTableSQL);
System.out.println("Table 'staff' created successfully");
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
