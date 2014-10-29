import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Font;

/*How to create a new user for a database in sql
 * Example:
-- Creates the login AbolrousHazem with password '340$Uuxwp7Mcxo7Khy'.
CREATE LOGIN AbolrousHazem 
    WITH PASSWORD = '340$Uuxwp7Mcxo7Khy';
GO

-- Creates a database user for the login created above.
CREATE USER AbolrousHazem FOR LOGIN AbolrousHazem;
GO
***********************************************/

public class NewUserPanel extends JPanel implements StringConstants{
	private JPanel mainpanel;
	private JButton goBack;
	private DBConnection db;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public NewUserPanel(JPanel mainpanel, DBConnection db) {
		setLayout(null);
		this.mainpanel = mainpanel;
		this.db = db;
		
		goBack = new JButton("GO BACK");
		goBack.setBounds(234, 266, 89, 23);
		add(goBack);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(234, 63, 146, 20);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblCreateNewUser = new JLabel("Create New User");
		lblCreateNewUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreateNewUser.setBounds(10, 11, 243, 23);
		add(lblCreateNewUser);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(234, 111, 146, 20);
		add(pwdPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(234, 94, 146, 14);
		add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(234, 142, 146, 14);
		add(lblConfirmPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(234, 160, 146, 20);
		add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(234, 45, 146, 14);
		add(lblUsername);
		
		JLabel lblStreetAddress = new JLabel("Street Address");
		lblStreetAddress.setBounds(10, 69, 146, 14);
		add(lblStreetAddress);
		
		textField = new JTextField();
		textField.setBounds(10, 83, 146, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(10, 163, 146, 14);
		add(lblState);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 129, 146, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 114, 146, 14);
		add(lblCity);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 232, 146, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox(StatesList);
		comboBox.setBounds(10, 178, 146, 20);
		add(comboBox);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setBounds(10, 217, 146, 14);
		add(lblZipCode);
		
		textField_3 = new JTextField();
		textField_3.setBounds(234, 232, 146, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(234, 217, 146, 14);
		add(lblPhoneNumber);
		goBack.addActionListener(new NewUserPanelListener());

	}
	
	class NewUserPanelListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == goBack){
				CardLayout cl = (CardLayout)(mainpanel.getLayout());
				cl.show(mainpanel, LOGIN);
			}
			
		}
		
	}
}
