import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DeleteCityRecords {
public static void main(String[] args) {
String url="jdbc:mysql://localhost:3306/nippani";
String username="root";
String password="";
int cityNumberToDelete=3;
Connection connection=null;
Statement statement=null;
try {
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection(url,username,password);
statement=connection.createStatement();
String deleteSQL="DELETE FROM city WHERE city number="+cityNumberToDelete;
int rowsAffected=statement.executeUpdate(deleteSQL);
if(rowsAffected>0) {
System.out.println("Record with city number"+cityNumberToDelete+"was delete successfully");
} else{
System.out.println("No record found with city number"+cityNumberToDelete);
}
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
