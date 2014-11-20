import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TheMainPanel extends JPanel implements StringConstants, OnChangeSize {
	private LoginPanel loginpage;
	private NewUserPanel newuserpage;
	private AddItemPanel additempage;
	private JFrame frame;
	private MyTrades mytrades;
	private SearchPanel search;
	private DBConnection db;
	private AcceptedOffersPanel acceptedoffers;
	
	//for use with user specific queries
	private String username;
	 
	/**
	 * Create the panel.
	 */
	public TheMainPanel(JFrame mainframe) {
		CardLayout cl = new CardLayout();
		db = new DBConnection(this);
		frame = mainframe;
		setPreferredSize(new Dimension(450,300));
		setLayout(cl);
		
		try {
			db.connectToDB();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Connection to db failed - you wont be able to log in");
			e.printStackTrace();
		} 
		//add pages to gui - the rest get added after login
		//when the username is found so it can refresh tables immediately.
		loginpage = new LoginPanel(this, db);
		newuserpage = new NewUserPanel(this, db);

		add(loginpage, LOGIN);
		add(newuserpage, CREATENEW);

	}
	
	public String getUserName(){
		return this.username;
	}
	
	//used for other pages to refresh the page
	public MyTrades getMyTradesPage(){
		return this.mytrades;
	}
	
	public void setUserName(String uname){
		this.username = uname;
	}
	
	public void onLogIn(){
		additempage = new AddItemPanel(this, db);
		mytrades = new MyTrades(this,db);
		search = new SearchPanel(this,db);
		acceptedoffers = new AcceptedOffersPanel(this,db);
		
		add(additempage, ADDITEM);
		add(mytrades, MYTRADES);
		add(search, SEARCH);
		add(acceptedoffers, ACCEPTEDOFFERS);
	}

	@Override
	public void changeSize(int x, int y) {
		frame.setSize(x,y);
		
	}

}
