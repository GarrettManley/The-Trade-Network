import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TheMainPanel extends JPanel implements StringConstants, OnChangeSize {
	private LoginPanel loginpage;
	private NewUserPanel newuserpage;
	private ConnectionSuccess connsuccess;
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
		
		loginpage = new LoginPanel(this, db);
		newuserpage = new NewUserPanel(this, db);
		connsuccess = new ConnectionSuccess(this);
		additempage = new AddItemPanel(this, db);
		removeitempage = new RemoveItemPanel(this, db);
		mytrades = new MyTrades(this,db);
		search = new SearchPanel(this,db);
		
		
		add(loginpage, LOGIN);
		add(newuserpage, CREATENEW);
		add(connsuccess, CONN);
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
