import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Color;


public class SearchPanel extends JPanel implements StringConstants {
	private JButton btnNewButton;
	private JButton btnOfferItem;
	private TheMainPanel mainpanel;
	private DBConnection db;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public SearchPanel(TheMainPanel mainpanel, DBConnection db) {
		setLayout(null);
		setPreferredSize(new Dimension(800,800));
		
		this.mainpanel = mainpanel;
		this.db = db;
		
		btnNewButton = new JButton("GO BACK");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(474, 681, 148, 59);
		add(btnNewButton);
		btnNewButton.addActionListener(new ButtonListener());
		
		JLabel lblSearchBy = new JLabel("Search:");
		lblSearchBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearchBy.setBounds(23, 45, 113, 27);
		add(lblSearchBy);
		
		btnOfferItem = new JButton("OFFER ITEM");
		btnOfferItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnOfferItem.setBounds(154, 681, 148, 59);
		add(btnOfferItem);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(23, 105, 741, 565);
		add(tabbedPane);
		
		table = new JTable(new ProjectTableModel());
		
		JScrollPane scrollPane = new JScrollPane(table);
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		textField = new JTextField();
		textField.setBounds(124, 50, 640, 20);
		add(textField);
		textField.setColumns(10);
		


	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnNewButton){
				CardLayout cl = (CardLayout)(mainpanel.getLayout());
				cl.show(mainpanel, MYTRADES);
			}
			
		}
		
	}
}
