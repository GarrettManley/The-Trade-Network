import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;


public class MainFrame extends JFrame implements StringConstants {


	// declare new JPanels here
	private JPanel mainpanel;
	private JPanel loginpage;
	private JPanel newuserpage;
	private JPanel connsuccess;
	private JPanel additempage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("The Trading Network");
		DBConnection db = new DBConnection();
		CardLayout cl = new CardLayout();

		// the main panel where everything gets swapped out
		mainpanel = new JPanel(cl);

		// declare new panels here
		loginpage = new LoginPanel(mainpanel, db);
		newuserpage = new NewUserPanel(mainpanel, db);
		connsuccess = new ConnectionSuccess(mainpanel);
		additempage = new AddItemPanel(mainpanel, db);

		// add the panels to the mainpanel, make sure to create a new string
		// constant for each one
		mainpanel.add(loginpage, LOGIN);
		mainpanel.add(newuserpage, CREATENEW);
		mainpanel.add(connsuccess, CONN);
		mainpanel.add(additempage, ADDITEM);

		add(mainpanel);

	}

	
}
