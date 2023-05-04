import java.sql.*;
public class LibrarianDB {

	
	public static int save(int id,String name,String pwd,String email,String address,String city,String contact){
		int status=0;
		try{
			String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
			String user = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the MySQL database");
			PreparedStatement ps=conn.prepareStatement("insert into librarian(id,name,password,email,address,city,contact) values(?,?,?,?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,password);
			ps.setString(4,email);
			ps.setString(5,address);
			ps.setString(6,city);
			ps.setString(7,contact);
			status=ps.executeUpdate();
			conn.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
			String user = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the MySQL database");
			PreparedStatement ps=conn.prepareStatement("delete from librarian where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			conn.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String pwd){
		boolean status=false;
		try{
			String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
			String user = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the MySQL database");
			PreparedStatement ps=conn.prepareStatement("select * from librarian where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			conn.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}