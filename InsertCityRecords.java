import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertCityRecords {
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
  "INSERT INTO city(city_number,name,survey,pincode) VALUES(1,'Mumbai','90%','400005')",
  "INSERT INTO city(city_number,name,survey,pincode) VALUES(2,'Pune','85%','410014')",
  "INSERT INTO city(city_number,name,survey,pincode) VALUES(3,'belagum','70%','590001')",
  "INSERT INTO city(city_number,name,survey,pincode) VALUES(4,'bengalur','80%','530068')",
  "INSERT INTO city(city_number,name,survey,pincode) VALUES(5,'Delhi','95%','110001')",
};
for(String query:insertQueries) {
statement.executeUpdate(query);
}
System.out.println("Inserted 5 record into the 'city' table");
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
