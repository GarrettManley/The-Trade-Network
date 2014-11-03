import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {
	
	Connection con;
	//PreparedStatement pstmt;
	
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
		
		String db_connect_string = "jdbc:sqlserver://;servername=localhost;"
				+ "username=garrettmanley;password=111223;database=TheTradeNetwork;";	
		this.con = DriverManager.getConnection(db_connect_string);

	}
	
	public boolean logIn(String username, String pass) throws SQLException{
		String u = username;
		String p = pass;
		
		String SQL = "Select * from PERSON where username = ? and password = ?";
		PreparedStatement pstmt = this.con.prepareStatement(SQL);
		pstmt.setString(1, u);
		pstmt.setString(2, p);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			return true;
		}
		
		return false;
	}
	
	public void createUser(String uname, String pass, int zip, String state, String phone, String city, String street) throws SQLException{
		if(con==null){
			System.err.println("CON IS NULL!!!!!!ONE!!!11!!");
		}
		
		String SQL = "INSERT INTO PERSON VALUES(?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = this.con.prepareStatement(SQL);
		
		pstmt.setString(1, uname);
		pstmt.setString(2, pass);
		pstmt.setInt(3, zip);
		pstmt.setString(4, state);
		pstmt.setString(5, phone);
		pstmt.setString(6, city);
		pstmt.setString(7, street);
		
		pstmt.executeUpdate();
	}
}
