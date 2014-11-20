import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;
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
import java.sql.SQLException;

public class SearchPanel extends JPanel implements StringConstants {
	private JButton btnGoBack;
	private JButton btnOfferItem;
	private JButton btnSearch;
	private TheMainPanel mainpanel;
	private DBConnection db;
	private JTable table;
	private JTextField searchBar;
	private JComboBox comboBox;
	private ProjectTableModel model;

	/**
	 * Create the panel.
	 */
	public SearchPanel(TheMainPanel mainpanel, DBConnection db) {
		setLayout(null);
		setPreferredSize(new Dimension(800, 800));

		this.mainpanel = mainpanel;
		this.db = db;

		btnGoBack = new JButton("GO BACK");
		btnGoBack.setBounds(616, 681, 148, 59);
		add(btnGoBack);
		btnGoBack.addActionListener(new ButtonListener());

		JLabel lblSearchBy = new JLabel("Search:");
		lblSearchBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearchBy.setBounds(23, 11, 113, 27);
		add(lblSearchBy);

		btnOfferItem = new JButton("OFFER ITEM");
		btnOfferItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnOfferItem.setBounds(318, 681, 148, 59);
		add(btnOfferItem);
		btnOfferItem.addActionListener(new ButtonListener());

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(23, 105, 741, 565);
		add(tabbedPane);

		model = new ProjectTableModel();
		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		tabbedPane.addTab("ITEMS", null, scrollPane, null);

		searchBar = new JTextField();
		searchBar.setBounds(23, 50, 548, 20);
		add(searchBar);
		searchBar.setColumns(10);

		comboBox = new JComboBox(searchBy);
		comboBox.setBounds(627, 50, 124, 20);
		add(comboBox);

		JLabel lblSearchBy_1 = new JLabel("Search By:");
		lblSearchBy_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearchBy_1.setBounds(627, 19, 124, 20);
		add(lblSearchBy_1);

		btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(23, 681, 148, 59);
		add(btnSearch);
		btnSearch.addActionListener(new ButtonListener());

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnGoBack) {
				CardLayout cl = (CardLayout) (mainpanel.getLayout());
				cl.show(mainpanel, MYTRADES);
			} else if (e.getSource() == btnSearch) {
				try {
					if (comboBox.getSelectedItem().toString()
							.equalsIgnoreCase("ItemName")) {
						model.refresh(searchtableColumns,
								db.searchByItem(searchBar.getText()));
					} else if (comboBox.getSelectedItem().toString()
							.equalsIgnoreCase("Category")) {
						model.refresh(searchtableColumns,
								db.searchByCategory(searchBar.getText()));
					} else if (comboBox.getSelectedItem().toString()
							.equalsIgnoreCase("User")) {
						model.refresh(searchtableColumns,
								db.searchByUserName(searchBar.getText()));
					}
				} catch (SQLException s) {

				}
			} else if (e.getSource() == btnOfferItem) {
				// if the user selected a row
				if (table.getSelectedRow() >= 0) {

					/******************************************************
					 * data[0] = itemname data[1] = item_desc data[2] =
					 * categoryName data[3] = username(traderA)
					 ******************************************************/
					// get data from selected row
					Object[] data = model.getValuesAt(table.getSelectedRow());
					for (int x = 0; x < data.length; x++) {
						System.out.println(data[x].toString());
					}
					Object[] items = db.getItems();

					// if users have atleast one item
					if (items.length != 0) {
						// show them items they have, let them select which item
						// they want to trade
						JComboBox jcb = new JComboBox(items);
						JOptionPane.showMessageDialog(
								mainpanel,
								jcb,
								"Trade what for: : "
										+ model.getValueAt(
												table.getSelectedRow(), 0),
								JOptionPane.QUESTION_MESSAGE);

						// make sure they really want to trade it, if so, start
						// the db transaction
						if (JOptionPane.showConfirmDialog(
								mainpanel,
								"Are you sure you want\nto trade: "
										+ jcb.getSelectedItem() + "?",
								"WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							try {
								db.offerItem(data[0].toString(), data[3]
										.toString(), jcb.getSelectedItem()
										.toString());
								JOptionPane.showMessageDialog(mainpanel,
										"Offer made!");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					// if users dont have any items
					else {
						JOptionPane.showMessageDialog(mainpanel,
								"You have to add an item first!");
					}
				}
			}
		}
	}
}
