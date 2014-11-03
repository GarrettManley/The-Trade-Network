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
		
		//192.168.254.35 (laptop ip)
		
		String db_connect_string = "jdbc:sqlserver://192.168.254.35\\SQLEXPRESS;user=sa;password=password0987654321;databaseName=TheTradeNetwork;";	
		con = DriverManager.getConnection(db_connect_string);

	}
	
public boolean logIn(String username, String pass) throws SQLException{
		String u = username;
		String p = pass;
		//create sql query string(the ?s are variables)
		String SQL = "Select * from PERSON where username = ? and password = ?";
		
		//create a prepared statement to be executed
		PreparedStatement pstmt = this.con.prepareStatement(SQL);
		
		//set the ?s to be variables, 1 = first ? etc.
		pstmt.setString(1, u);
		pstmt.setString(2, p);
		
		
		//execute query and get a result set(either a 1d or 2d array)
		ResultSet rs = pstmt.executeQuery();
		
		//if username exists with same pass then log in
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
