import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateBookTable {
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
String createTableSQL="CREATE TABLE book("+"book_number INT NOT NULL,"
                                          +"name VARCHAR(100)NOT NULL,"
                                          +"author VARCHAR(50),"
                                          +"page VARCHAR(100),"
                                          +"PRIMARY KEY(city_number))";
statement.executeUpdate(createTableSQL);
System.out.println("Table 'book' created successfully");
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
