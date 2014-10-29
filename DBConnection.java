import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	public DBConnection(){
		//register with server(dont change this)
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connectToDB() throws SQLException {
		
		//
		// has to be of form
		// jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
		//
		
		String db_connect_string = "jdbc:sqlserver://;servername=localhost\\CEIT2553214X028;database=tradenetwork;";	
		Connection con = DriverManager.getConnection(db_connect_string);

	}
	
	public boolean logIn(String username, String pass) throws SQLException{
		String u = username;
		String p = pass;
		
		String SQL = "Select * from users where uname = ? and upass = ?";
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setString(1, u);
		pstmt.setString(2, p);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			return true;
		}
		
		return false;
	}
	
	public void connectToDB(String userid, String pass) throws SQLException{
		String u = userid;
		String p = pass;
		
		System.out.println(u +"\t\t" + p);
		
		String db_connect_string = "jdbc:sqlserver://192.168.254.36\\SQLEXPRESS:1433;user=" + u + ";password="+ p;

		Connection con = DriverManager.getConnection(db_connect_string);
	
	
	}
}
