import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ReadProductRecords {
public static void main(String[] args) {
String url="jdbc:mysql://localhost:3306/nippani";
String username="root";
String password="";
Connection connection=null;
Statement statement=null;
ResultSet resultSet=null;
try {
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection(url,username,password);
statement=connection.createStatement();
String query="SELECT * FROM product";
resultSet=statement.executeQuery(query);
while(resultSet.next()) {
int productNumber=resultSet.getInt("product_number");
String name=resultSet.getString("name");
String value=resultSet.getString("value");
String phone=resultSet.getString("phone");
System.out.println("Product Number:"+productNumber);
System.out.println("Name:"+name);
System.out.println("Value:"+value);
System.out.println("Phone:"+phone);
System.out.println();
}
} catch(ClassNotFoundException e) {
  e.printStackTrace();
} catch(SQLException e) {
  e.printStackTrace();
} finally {
 try {
  if(resultSet!=null)resultSet.close();
  if(statement!=null)statement.close();
  if(connection!=null)connection.close();
} catch(SQLException e) {
 e.printStackTrace();
}
}
}
}