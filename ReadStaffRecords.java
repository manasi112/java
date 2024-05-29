import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ReadStaffRecords {
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
String query="SELECT * FROM staff";
resultSet=statement.executeQuery(query);
while(resultSet.next()) {
int idNumber=resultSet.getInt("id_number");
String name=resultSet.getString("name");
String dept=resultSet.getString("dept");
String email=resultSet.getString("email");
String phone=resultSet.getString("phone");
System.out.println("id Number:"idNumber);
System.out.println("Name:"+name);
System.out.println("Dept:"+dept);
System.out.println("Email:"+email);
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