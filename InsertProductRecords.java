import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProductRecords {
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
  "INSERT INTO product(product_number,name,value,phone) VALUES(1,'john Deo','10000','1234567890')",
  "INSERT INTO product(product_number,name,value,phone) VALUES(2,'Jane Smith','25000','0987654321')",
  "INSERT INTO product(product_number,name,value,phone) VALUES(3,'Mike Johnson','30000','1122334455')",
  "INSERT INTO product(product_number,name,value,phone) VALUES(4,'Emily Davis','45000','2233445566')",
  "INSERT INTO product(product_number,name,value,phone) VALUES(5,'William Brown','60000','3344556677')",
};
for(String query:insertQueries) {
statement.executeUpdate(query);
}
System.out.println("Inserted 5 record into the 'product' table");
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
