import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
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
	private JButton btn_addItem;
	private JButton btn_refresh;
	private TheMainPanel mainpanel;
	private ProjectTableModel model1;
	private ProjectTableModel model2;
	private JTabbedPane tabbedPane;
	private JButton btn_search;
	private JButton btn_removeItem;
	private JButton btn_myOffers;
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

	// makes two table models which contain data for the actual table
	// model takes two arguments, column names and the data
	// data recieved by querying the database for information
	public void createTables() {
		try {
			model1 = new ProjectTableModel(tradetableColumns,
					db.getTradeTableData());
			model2 = new ProjectTableModel(tradeHistoryColumns,
					db.getTradeHistoryData());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trades_table = new JTable(model1);
		tabbedPane.addTab("Current", null, new JScrollPane(trades_table), null);

		history_table = new JTable(model2);
		tabbedPane
				.addTab("History", null, new JScrollPane(history_table), null);

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
				if (tabbedPane.getSelectedIndex() == 0) {
					System.out.println(trades_table.getSelectedRow());
					String[] rowData = model1.getValuesAt(trades_table.getSelectedRow());
					if(JOptionPane.showConfirmDialog(mainpanel, "Are you sure you want to\nDelete this Item?: " + rowData[0]) == JOptionPane.YES_OPTION){
						try {
							db.removeItem(rowData);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
			}
			// if user presses search button
			else if (e.getSource() == btn_search) {
				CardLayout cl = (CardLayout) (mainpanel.getLayout());
				cl.show(mainpanel, SEARCH);
			}
			// if user presses myoffers button
			else if (e.getSource() == btn_myOffers) {

			}
			// if user presses refresh button
			else if (e.getSource() == btn_refresh) {
				Object[][] data_model1;
				try {
					data_model1 = db.getTradeTableData();
					model1.refresh(tradetableColumns, data_model1);
					model2.refresh(tradeHistoryColumns,
							db.getTradeHistoryData());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

	}
}