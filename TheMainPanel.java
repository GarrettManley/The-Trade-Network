import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TheMainPanel extends JPanel implements StringConstants, OnChangeSize {
	private LoginPanel loginpage;
	private NewUserPanel newuserpage;
	private AddItemPanel additempage;
	private RemoveItemPanel removeitempage;
	private JFrame frame;
	private MyTrades mytrades;
	private SearchPanel search;
	 
	/**
	 * Create the panel.
	 */
	public TheMainPanel(JFrame mainframe, DBConnection db) {
		CardLayout cl = new CardLayout();
		frame = mainframe;
		setPreferredSize(new Dimension(450,300));
		setLayout(cl);
		
		try {
			db.connectToDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		loginpage = new LoginPanel(this, db);
		newuserpage = new NewUserPanel(this, db);
		additempage = new AddItemPanel(this, db);
		removeitempage = new RemoveItemPanel(this, db);
		mytrades = new MyTrades(this,db);
		search = new SearchPanel(this,db);
		
		
		add(loginpage, LOGIN);
		add(newuserpage, CREATENEW);
		add(additempage, ADDITEM);
		add(removeitempage, REMOVEITEM);
		add(mytrades, MYTRADES);
		add(search, SEARCH);
		
	}

	@Override
	public void changeSize(int x, int y) {
		frame.setSize(x,y);
		
	}

}
