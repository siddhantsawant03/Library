import java.sql.*;
public class IssueBookDB {
	
public static boolean checkBook(String callno){
	boolean status=false;
	try{
		String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
		String user = "root";
		String password = "";
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("Connected to the MySQL database");
		PreparedStatement ps=conn.prepareStatement("select * from books where callno=?");
		ps.setString(1,callno);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		conn.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int save(String callno,int studentid,String studentname,String studentcontact){
	int status=0;
	try{
		String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
		String user = "root";
		String password = "";
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("Connected to the MySQL database");
		
		status=updatebook(callno);
		
		if(status>0){
		PreparedStatement ps=conn.prepareStatement("insert into issuebooks(bookcallno,studentid,studentname,studentcontact) values(?,?,?,?)");
		ps.setString(1,callno);
		ps.setInt(2,studentid);
		ps.setString(3,studentname);
		ps.setString(4,studentcontact);
		status=ps.executeUpdate();
		}
		
		conn.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int updatebook(String callno){
	int status=0;
	int quantity=0,issued=0;
	try{
		String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
		String user = "root";
		String password = "";
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("Connected to the MySQL database");
		
		PreparedStatement ps=conn.prepareStatement("select quantity,issued from books where callno=?");
		ps.setString(1,callno);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			quantity=rs.getInt("quantity");
			issued=rs.getInt("issued");
		}
		
		if(quantity>0){
		PreparedStatement ps2=conn.prepareStatement("update books set quantity=?,issued=? where callno=?");
		ps2.setInt(1,quantity-1);
		ps2.setInt(2,issued+1);
		ps2.setString(3,callno);
		
		status=ps2.executeUpdate();
		}
		conn.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
