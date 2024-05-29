import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBookRecords {
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
  "INSERT INTO book(book_number,name,author,page) VALUES(112,'Interpreter Of Maladies','Jhumpa Lahiri','455')",
  "INSERT INTO book(book_number,name,author,page) VALUES(202,'The Great Indian Novel','Shashi Tharoor','565')",
  "INSERT INTO book(book_number,name,author,page) VALUES(311,'India After Gandhi','Ramchandra Guha','425')",
  "INSERT INTO book(book_number,name,author,page) VALUES(420,'Revolution','Chetan Bhagat','378')",
  "INSERT INTO book(book_number,name,author,page) VALUES(510,'The Guide','R.K.Narayan','400')",
};
for(String query:insertQueries) {
statement.executeUpdate(query);
}
System.out.println("Inserted 5 record into the 'book' table");
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
