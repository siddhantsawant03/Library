import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class BookDB {
public static int save(String callno,String name,String author,String publisher,int quantity){
	int status=0;
	try{
		String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
		String user = "root";
		String password = "";
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("Connected to the MySQL database");
		PreparedStatement ps=conn.prepareStatement("insert into books(callno,name,author,publisher,quantity) values(?,?,?,?,?)");
		ps.setString(1,callno);
		ps.setString(2,name);
		ps.setString(3,author);
		ps.setString(4,publisher);
		ps.setInt(5,quantity);
		status=ps.executeUpdate();
		conn.close();
	}catch(Exception e){System.out.println(e);}

	return status;
}
}
