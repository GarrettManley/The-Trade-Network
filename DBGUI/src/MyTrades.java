import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.SQLException;

public class MyTrades extends JPanel implements StringConstants {
	private JTable trades_table;
	private JTable history_table;
	private JTable offers_table;
	private JButton btn_addItem;
	private JButton btn_refresh;
	private JButton btnAcceptOffer;
	private TheMainPanel mainpanel;
	private ProjectTableModel model1;
	private ProjectTableModel model2;
	private ProjectTableModel model3;
	private JTabbedPane tabbedPane;
	private JButton btn_search;
	private JButton btn_removeItem;
	private JButton btn_acceptedOffers;
	private DBConnection db;

	/**
	 * Main Page for application, user can navigate to different forms
	 */
	public MyTrades(TheMainPanel mainpanel, DBConnection db) {
		setLayout(null);

		this.mainpanel = mainpanel;
		this.db = db;

		// make a tabbedPane and add tables to it
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(197, 80, 545, 668);
		add(tabbedPane);

		// create tables and add to tabbedPane
		createTables();

		// add buttons and attach listeners
		btn_addItem = new JButton("Add Item");
		btn_addItem.setBounds(32, 90, 127, 47);
		add(btn_addItem);
		btn_addItem.addActionListener(new ButtonListener());

		btn_removeItem = new JButton("Remove Item");
		btn_removeItem.setBounds(32, 169, 127, 47);
		add(btn_removeItem);
		btn_removeItem.addActionListener(new ButtonListener());

		btn_search = new JButton("Search");
		btn_search.setBounds(32, 251, 127, 47);
		
		add(btn_search);
		btn_search.addActionListener(new ButtonListener());

		btn_acceptedOffers = new JButton("AcceptedOffers");
		btn_acceptedOffers.setBounds(32, 331, 127, 47);
		add(btn_acceptedOffers);
		btn_acceptedOffers.addActionListener(new ButtonListener());

		btn_refresh = new JButton("Refresh Page");
		btn_refresh.setBounds(32, 495, 127, 47);
		add(btn_refresh);
		btn_refresh.addActionListener(new ButtonListener());

		JLabel lblMyTrades = new JLabel("My Trades");
		lblMyTrades.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblMyTrades.setBounds(297, 36, 203, 33);
		add(lblMyTrades);
		
		btnAcceptOffer = new JButton("Accept Offer");
		btnAcceptOffer.setBounds(32, 413, 127, 47);
		add(btnAcceptOffer);
		btnAcceptOffer.addActionListener(new ButtonListener());

	}

	// makes two table models which contain data for the actual table
	// model takes two arguments, column names and the data
	// data recieved by querying the database for information
	private void createTables() {
		try {
			model1 = new ProjectTableModel(tradetableColumns,
					db.getTradeTableData());
			model2 = new ProjectTableModel(tradeHistoryColumns,
					db.getTradeHistoryData());
			model3 = new ProjectTableModel(offerTableColumns, db.getOfferTableData());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trades_table = new JTable(model1);
		tabbedPane.addTab("Current", null, new JScrollPane(trades_table), null);

		history_table = new JTable(model2);
		tabbedPane
				.addTab("History", null, new JScrollPane(history_table), null);
		
		offers_table = new JTable(model3);
		tabbedPane.addTab("Offers", null, new JScrollPane(offers_table), null);

	}
	
	public void refresh_page() throws SQLException{
		model1.refresh(tradetableColumns, db.getTradeTableData());
		model2.refresh(tradeHistoryColumns, db.getTradeHistoryData());
		model3.refresh(offerTableColumns, db.getOfferTableData());
	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// if user presses additem button
			if (e.getSource() == btn_addItem) {
				CardLayout cl = (CardLayout) (mainpanel.getLayout());
				cl.show(mainpanel, ADDITEM);
				mainpanel.changeSize(450, 300);
			}
			// if user presses removeitem button
			else if (e.getSource() == btn_removeItem) {
				//if in tradetable tab
				if (tabbedPane.getSelectedIndex() == 0) {
					//get data to be removed
					String[] rowData = model1.getValuesAt(trades_table.getSelectedRow());
					
					if(JOptionPane.showConfirmDialog(mainpanel, "Are you sure you want to\nDelete this Item?: " + rowData[0]) == JOptionPane.YES_OPTION){
						try {
							//remove and refresh page
							db.removeItem(rowData);
							refresh_page();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
				else{
					JOptionPane.showMessageDialog(mainpanel, "You have to be in current trade tab to remove an item!");
				}
			}
			// if user presses search button
			else if (e.getSource() == btn_search) {
				CardLayout cl = (CardLayout) (mainpanel.getLayout());
				cl.show(mainpanel, SEARCH);
			}
			// if user presses myoffers button
			else if (e.getSource() == btn_acceptedOffers) {
				CardLayout cl = (CardLayout) (mainpanel.getLayout());
				cl.show(mainpanel, ACCEPTEDOFFERS);
			}
			//if user presses accept offer button
			else if(e.getSource() == btnAcceptOffer){
				//if in tradetable tab
				if (tabbedPane.getSelectedIndex() == 2) {
					//get data to be removed
					String[] rowData = model3.getValuesAt(offers_table.getSelectedRow());
					
					if(JOptionPane.showConfirmDialog(mainpanel, "Are you sure you want to\nAccept this Offer?: " + rowData[2] + " for " + rowData[0]) == JOptionPane.YES_OPTION){
						try {
							//remove and refresh page
							//db.removeItem(rowData);
							refresh_page();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
				else{
					JOptionPane.showMessageDialog(mainpanel, "You have to select an item from offers tab to accept offer!");
				}
			}
			// if user presses refresh button
			else if (e.getSource() == btn_refresh) {
				try {
					refresh_page();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

	}
}
