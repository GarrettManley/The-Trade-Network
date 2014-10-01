import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

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
	private JTextField textField;
	private JPanel mainpanel;
	private JButton goBack;
	private DBConnection db;

	/**
	 * Create the panel.
	 */
	public NewUserPanel(JPanel mainpanel, DBConnection db) {
		setLayout(null);
		this.mainpanel = mainpanel;
		this.db = db;
		
		goBack = new JButton("GO BACK");
		goBack.setBounds(181, 221, 89, 23);
		add(goBack);
		goBack.addActionListener(new NewUserPanelListener());
		
		textField = new JTextField();
		textField.setBounds(25, 26, 389, 189);
		add(textField);
		textField.setColumns(10);

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
