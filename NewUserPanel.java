import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.TextField;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import java.awt.Font;
import java.sql.SQLException;



public class NewUserPanel extends JPanel implements StringConstants{
	private TheMainPanel mainpanel;
	private JButton goBack;
	private DBConnection db;
	private JTextField textField_Username;
	private JPasswordField pwdPassword;
	private JPasswordField passwordField;
	private JTextField textField_Street;
	private JTextField textField_City;
	private JTextField textField_Zip;
	private JTextField textField_Phone;
	private JComboBox comboBox_State;
	private JButton btnCreate;

	/**
	 * Create the panel.
	 */
	public NewUserPanel(TheMainPanel mainpanel, DBConnection db) {
		setLayout(null);
		this.mainpanel = mainpanel;
		this.db = db;
		
		setPreferredSize(new Dimension(450,500));
		
		goBack = new JButton("GO BACK");
		goBack.setBounds(97, 371, 89, 23);
		add(goBack);
		
		//TextField for Username
		textField_Username = new JTextField();
		textField_Username.setBounds(234, 83, 188, 20);
		add(textField_Username);
		textField_Username.setColumns(10);
		
		//Title Label
		JLabel lblCreateNewUser = new JLabel("Create New User");
		lblCreateNewUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreateNewUser.setBounds(10, 11, 243, 23);
		add(lblCreateNewUser);
		
		//initial password
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(234, 132, 188, 20);
		add(pwdPassword);
		
		//Label for the Password Field
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(234, 114, 146, 14);
		add(lblPassword);
		
		//Label for Confirming password
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(234, 163, 146, 14);
		add(lblConfirmPassword);
		
		//confirm password
		passwordField = new JPasswordField();
		passwordField.setBounds(234, 178, 188, 20);
		add(passwordField);
		
		//label for username
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(234, 69, 146, 14);
		add(lblUsername);
		
		//label for Street Address
		JLabel lblStreetAddress = new JLabel("Street Address");
		lblStreetAddress.setBounds(10, 69, 146, 14);
		add(lblStreetAddress);
		
		//Text field for Address
		textField_Street = new JTextField();
		textField_Street.setBounds(10, 83, 176, 20);
		add(textField_Street);
		textField_Street.setColumns(10);
		
		//Label for State
		JLabel lblState = new JLabel("State");
		lblState.setBounds(10, 163, 146, 14);
		add(lblState);
		
		//Text Field for City
		textField_City = new JTextField();
		textField_City.setBounds(10, 129, 176, 20);
		add(textField_City);
		textField_City.setColumns(10);
		
		//Label for City
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 114, 146, 14);
		add(lblCity);
		
		//Text Field for Zipcode
		textField_Zip = new JTextField();
		textField_Zip.setBounds(10, 232, 176, 20);
		add(textField_Zip);
		textField_Zip.setColumns(10);
		
		//Combo Box for state selection
		comboBox_State = new JComboBox(StatesList);
		comboBox_State.setBounds(10, 178, 176, 20);
		add(comboBox_State);
		
		//Zip Code Label
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setBounds(10, 217, 146, 14);
		add(lblZipCode);
		
		//Text Field for Phone Number
		textField_Phone = new JTextField();
		textField_Phone.setBounds(234, 232, 188, 20);
		add(textField_Phone);
		textField_Phone.setColumns(10);
		
		//Phone Number Label
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(234, 217, 146, 14);
		add(lblPhoneNumber);
		
		//Button to create the new user
		btnCreate = new JButton("CREATE");
		btnCreate.setBounds(234, 371, 89, 23);
		add(btnCreate);
		
		//Adding Action Listeners
		goBack.addActionListener(new NewUserPanelListener());
		btnCreate.addActionListener(new NewUserPanelListener());

	}
	
	class NewUserPanelListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String[] info = new String[7];
			
			if(e.getSource() == goBack){
				CardLayout cl = (CardLayout)(mainpanel.getLayout());
				cl.show(mainpanel, LOGIN);
				mainpanel.changeSize(450,300);
			}
			else if(e.getSource() == btnCreate){
				/*
				 * 0 - Username
				 * 1 - password
				 * 2 - zip
				 * 3 - state
				 * 4 - phone
				 * 5 - city
				 * 6 - street
				 */
				
				info[0] = textField_Username.getText();
				info[1] = new String(passwordField.getPassword());//LOOK INTO THIS ALSO, verify the password Fields
				info[2] = textField_Zip.getText();
				info[3] = (String) comboBox_State.getSelectedItem();
				info[4] = textField_Phone.getText();
				info[5] = textField_City.getText();
				info[6] = textField_Street.getText();
				
				try {
					db.createUser(info[0], info[1], Integer.parseInt(info[2]), info[3], info[4], info[5], info[6]);
				} catch (SQLException e1) {
					System.err.println("SQL EXCEPTION OCCURED");
					e1.printStackTrace();
				}
				
				CardLayout cl = (CardLayout)(mainpanel.getLayout());
				cl.show(mainpanel, LOGIN);
				mainpanel.changeSize(450,300);
				
			}
			
		}
		
	}
}
