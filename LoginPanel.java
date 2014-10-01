import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.SQLException;


public class LoginPanel extends JPanel implements StringConstants {
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton createNew;
	private JButton logIn;
	private JPanel mainpanel;
	private DBConnection db;
	

	/**
	 * Create the panel.
	 * Mainpanel is the only arguement, used to refer to the layout
	 */
	public LoginPanel(JPanel mainpanel, DBConnection db) {
		
		this.mainpanel = mainpanel;
		this.db = db;
		setLayout(null);
		
		createNew = new JButton("Create New");
		createNew.setBounds(87, 228, 123, 23);
		add(createNew);
		createNew.addActionListener(new LoginPanelListener());
		
		logIn = new JButton("Log In");
		logIn.setBounds(220, 228, 136, 23);
		add(logIn);
		logIn.addActionListener(new LoginPanelListener());
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 45));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel.setBounds(151, 11, 268, 61);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(103, 83, 299, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(20, 86, 73, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(20, 149, 63, 14);
		add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(103, 146, 299, 20);
		add(passwordField);

	}
	
	/*event handling for this panel done here*/
	class LoginPanelListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//to switch pages, get the cardlayout from main panel then 
			//call the show method(container, keystring)
			if(e.getSource() == createNew){
				CardLayout cl = (CardLayout)(mainpanel.getLayout());
				cl.show(mainpanel, CREATENEW);
			}
			else if(e.getSource() == logIn)
			{
				String uname = textField.getText();
				String pass = new String(passwordField.getPassword());
				CardLayout cl = (CardLayout)(mainpanel.getLayout());
				cl.show(mainpanel, CONN);
				
				textField.setText("");
				passwordField.setText("");
				}
								
		}
		
	}
}
