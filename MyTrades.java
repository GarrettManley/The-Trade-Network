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
	private JTable trades_table;
	private JTable history_table;
	private JButton btn_addItem;
	private JButton btn_refresh;
	private TheMainPanel mainpanel;
	private ProjectTableModel model1;
	private JTabbedPane tabbedPane;
	private JButton btn_search;
	private JButton btn_removeItem;
	private JButton btn_myOffers;

	/**
	 * Main Page for application, user can navigate to different forms
	 */
	public MyTrades(TheMainPanel mainpanel, DBConnection db) {
		setLayout(null);

		this.mainpanel = mainpanel;
		
		
		//make a tabbedPane and add tables to it
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(197, 80, 545, 668);
		add(tabbedPane);
		
		//when creating new table args need to be a tableModel
		//can have no args(default data) or you add your own data
		//new ProjectTableModel(String[] columnNames, Object[][] data)
		history_table = new JTable(new ProjectTableModel());
		tabbedPane.addTab("History", null, new JScrollPane(history_table), null);
		
		trades_table = new JTable(new ProjectTableModel());
		tabbedPane.addTab("Current", null, new JScrollPane(trades_table), null);
		
		//add buttons and attach listeners
		btn_addItem = new JButton("Add Item");
		btn_addItem.setBounds(32, 90, 127, 47);
		add(btn_addItem);
		btn_addItem.addActionListener(new ButtonListener());
		
		btn_removeItem = new JButton("Remove Item");
		btn_removeItem.setBounds(32, 169, 127, 47);
		add(btn_removeItem);
		btn_removeItem.addActionListener(new ButtonListener());
		
		btn_search = new JButton("Search");
		btn_search.setBounds(32, 257, 127, 47);
		add(btn_search);
		btn_search.addActionListener(new ButtonListener());
		
		btn_myOffers = new JButton("Look at Offers");
		btn_myOffers.setBounds(32, 341, 127, 47);
		add(btn_myOffers);
		btn_myOffers.addActionListener(new ButtonListener());
		
		btn_refresh = new JButton("Refresh Page");
		btn_refresh.setBounds(32, 421, 127, 47);
		add(btn_refresh);
		btn_refresh.addActionListener(new ButtonListener());
		
		
		JLabel lblMyTrades = new JLabel("My Trades");
		lblMyTrades.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblMyTrades.setBounds(297, 36, 203, 33);
		add(lblMyTrades);
		
		

	}
	
	class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			//if user presses additem button
			if(e.getSource() == btn_addItem){
				CardLayout cl = (CardLayout)(mainpanel.getLayout());
				cl.show(mainpanel, ADDITEM);
				mainpanel.changeSize(450,300);
			}
			//if user presses removeitem button
			else if(e.getSource() == btn_removeItem){
				
			}
			//if user presses search button
			else if(e.getSource() == btn_search){
				CardLayout cl = (CardLayout)(mainpanel.getLayout());
				cl.show(mainpanel, SEARCH);
			}
			//if user presses myoffers button
			else if(e.getSource() == btn_myOffers){
				
			}
			//if user presses refresh button
			else if(e.getSource() == btn_refresh){
				String[] cNames = {"UserName", "Item", "ItemDescription", "OffersYN"};
				Object[][] data = {
						{"Charles","violin","its a violin","Y"},
						{"steve","knife","a KNOIF","Y"}
				};
				for(int i = 0; i < data.length; i++){
					for(int j = 0; j < cNames.length; j++){
						trades_table.setValueAt(data[i][j], i, j);
					}
				}
			}
			
		}
		
	}
}
