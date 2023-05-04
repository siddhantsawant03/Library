import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReturnBookDB {
	public static int delete(String bookcallno,int studentid){
		int status=0;
		try{
			String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
			String user = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the MySQL database");
			
			
			status=updatebook(bookcallno);//updating quantity and issue
			
			if(status>0){
			PreparedStatement ps=conn.prepareStatement("delete from issuebooks where bookcallno=? and studentid=?");
			ps.setString(1,bookcallno);
			ps.setInt(2,studentid);
			status=ps.executeUpdate();
			}
			
			conn.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int updatebook(String bookcallno){
		int status=0;
		int quantity=0,issued=0;
		try{
			String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
			String user = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the MySQL database");
			
			PreparedStatement ps=conn.prepareStatement("select quantity,issued from books where callno=?");
			ps.setString(1,bookcallno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getInt("quantity");
				issued=rs.getInt("issued");
			}
			
			if(issued>0){
			PreparedStatement ps2=conn.prepareStatement("update books set quantity=?,issued=? where callno=?");
			ps2.setInt(1,quantity+1);
			ps2.setInt(2,issued-1);
			ps2.setString(3,bookcallno);
			
			status=ps2.executeUpdate();
			}
			conn.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}