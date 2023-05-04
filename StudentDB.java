import java.sql.*;
public class StudentDB {

	
	public static int save(int s_id,String name,String pwd,String email,String address,String city,String contact){
		int status=0;
		try{
			String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
			String user = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the MySQL database");
			PreparedStatement ps=conn.prepareStatement("insert into student(s_id,name,pwd,email,address,city,contact) values(?,?,?,?,?,?,?)");
			ps.setInt(1,s_id);
			ps.setString(2,name);
			ps.setString(3,pwd);
			ps.setString(4,email);
			ps.setString(5,address);
			ps.setString(6,city);
			ps.setString(7,contact);
			status=ps.executeUpdate();
			conn.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int s_id){
		int status=0;
		try{
			String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
			String user = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the MySQL database");
			PreparedStatement ps=conn.prepareStatement("delete from student where s_id=?");
			ps.setInt(1,s_id);
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
			PreparedStatement ps=conn.prepareStatement("select * from student where name=? and pwd=?");
			ps.setString(1,name);
			ps.setString(2,pwd);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			conn.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}