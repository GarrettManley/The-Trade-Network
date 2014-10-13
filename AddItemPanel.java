import javax.swing.JPanel;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class AddItemPanel extends JPanel implements StringConstants{
	private JPanel mainpanel;
	private DBConnection db;
	private JTextField textField;
	
	

	/**
	 * Create the panel.
	 */
	public AddItemPanel(JPanel mainpanel, DBConnection db) {
		setLayout(null);
		this.mainpanel = mainpanel;
		this.db = db;
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 0, 0);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 0, 0);
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 0, 0, 0);
		add(label_2);
		
		JLabel lblAddAnItem = new JLabel("Add An Item");
		lblAddAnItem.setVerticalAlignment(SwingConstants.TOP);
		lblAddAnItem.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		lblAddAnItem.setBounds(6, 6, 426, 54);
		add(lblAddAnItem);
		
		textField = new JTextField();
		textField.setBounds(45, 88, 146, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(6, 124, 83, 16);
		add(lblDescription);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(89, 120, 292, 84);
		add(textArea);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(6, 90, 61, 16);
		add(lblName);
		
		JLabel lblCategory = new JLabel("Category: ");
		lblCategory.setBounds(215, 90, 83, 16);
		add(lblCategory);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(273, 88, 146, 20);
		add(comboBox);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(234, 216, 117, 29);
		add(btnAddItem);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(89, 216, 117, 29);
		add(btnCancel);

	}
}
