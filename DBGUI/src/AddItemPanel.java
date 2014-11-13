import javax.swing.JPanel;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class AddItemPanel extends JPanel implements StringConstants{
	private TheMainPanel mainpanel;
	private DBConnection db;
	private JTextField itemField;
	private JButton btnCancel;
	private JButton btnAddItem;
	private JTextArea item_desc;
	private JComboBox comboBox;
	
	

	/**
	 * Create the panel.
	 */
	public AddItemPanel(TheMainPanel mainpanel, DBConnection db) {
		setLayout(null);
		this.mainpanel = mainpanel;
		this.db = db;
		
		setPreferredSize(new Dimension(450,300));

		//TITLE OF PAGE LABLE
		JLabel lblAddAnItem = new JLabel("Add An Item");
		lblAddAnItem.setVerticalAlignment(SwingConstants.TOP);
		lblAddAnItem.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		lblAddAnItem.setBounds(6, 6, 426, 54);
		add(lblAddAnItem);
		
		
		//ITEM NAME COMPONENTS
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(6, 90, 61, 16);
		add(lblName);
		
		itemField = new JTextField();
		itemField.setBounds(45, 88, 146, 20);
		add(itemField);
		itemField.setColumns(10);
		
		
		//ITEM DESCRIPTION COMPONENTS
		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(6, 124, 83, 16);
		add(lblDescription);
		
		item_desc = new JTextArea();
		item_desc.setBounds(89, 120, 292, 84);
		add(item_desc);
		
		//CATEGORY COMPONENTS
		JLabel lblCategory = new JLabel("Category: ");
		lblCategory.setBounds(215, 90, 83, 16);
		add(lblCategory);
		
		db.getCategories();
		comboBox = new JComboBox(db.getCategories());
		comboBox.setBounds(273, 88, 146, 20);
		add(comboBox);
		
		
		//BUTTONS 
		btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(234, 216, 117, 29);
		add(btnAddItem);
		btnAddItem.addActionListener(new ButtonListener());
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(89, 216, 117, 29);
		add(btnCancel);
		btnCancel.addActionListener(new ButtonListener());

	}
	
	//HANDLES BUTTON CLICKS
	class ButtonListener implements ActionListener{


		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnCancel){
				CardLayout cl = (CardLayout)(mainpanel.getLayout());
				cl.show(mainpanel, MYTRADES);
				mainpanel.changeSize(800,800);
			}
			else if(e.getSource() == btnAddItem){
				String itemName = itemField.getText();
				String itemDescription = item_desc.getText();
				int category = comboBox.getSelectedIndex() + 1;
				
				try {
					db.addItemToDB(itemName, itemDescription, category);
					JOptionPane.showMessageDialog(mainpanel, "ITEM ADDED!");
					itemField.setText("");
					item_desc.setText("");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
}
