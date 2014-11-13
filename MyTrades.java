import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class MyTrades extends JPanel implements StringConstants {
	private JTable table;
	private JTable table2;
	private JButton btnNewButton;
	private JButton btnNewButton_4;
	private TheMainPanel mainpanel;
	private ProjectTableModel model1;
	private JTabbedPane tabbedPane;
	private JButton btnNewButton_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;

	/**
	 * Create the panel.
	 */
	public MyTrades(TheMainPanel mainpanel, DBConnection db) {
		setLayout(null);

		this.mainpanel = mainpanel;
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(197, 80, 545, 668);
		add(tabbedPane);
		table2 = new JTable(new ProjectTableModel());
		
		tabbedPane.addTab("History", null, new JScrollPane(table2), null);
		
		table = new JTable(new ProjectTableModel());
		tabbedPane.addTab("Current", null, new JScrollPane(table), null);
		
		
		btnNewButton = new JButton("Add Item");
		btnNewButton.setBounds(32, 90, 127, 47);
		add(btnNewButton);
		btnNewButton.addActionListener(new ButtonListener());
		
		btnNewButton_1 = new JButton("Remove Item");
		btnNewButton_1.setBounds(32, 169, 127, 47);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ButtonListener());
		
		btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setBounds(32, 257, 127, 47);
		add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ButtonListener());
		
		btnNewButton_3 = new JButton("Look at Offers");
		btnNewButton_3.setBounds(32, 341, 127, 47);
		add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ButtonListener());
		
		btnNewButton_4 = new JButton("Refresh Page");
		btnNewButton_4.setBounds(32, 421, 127, 47);
		add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ButtonListener());
		
		JLabel lblMyTrades = new JLabel("My Trades");
		lblMyTrades.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblMyTrades.setBounds(297, 36, 203, 33);
		add(lblMyTrades);
		
		

	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnNewButton){
				CardLayout cl = (CardLayout)(mainpanel.getLayout());
				cl.show(mainpanel, ADDITEM);
				mainpanel.changeSize(450,300);
			}
			else if(e.getSource() == btnNewButton_1){
				
			}
			else if(e.getSource() == btnNewButton_2){
				CardLayout cl = (CardLayout)(mainpanel.getLayout());
				cl.show(mainpanel, SEARCH);
			}
			else if(e.getSource() == btnNewButton_3){
				
			}
			else if(e.getSource() == btnNewButton_4){
				String[] cNames = {"UserName", "Item", "ItemDescription", "OffersYN"};
				Object[][] data = {
						{"Charles","violin","its a violin","Y"},
						{"steve","knife","a KNOIF","Y"}
				};
				for(int i = 0; i < data.length; i++){
					for(int j = 0; j < cNames.length; j++){
						table.setValueAt(data[i][j], i, j);
					}
				}
			}
			
		}
		
	}
}
