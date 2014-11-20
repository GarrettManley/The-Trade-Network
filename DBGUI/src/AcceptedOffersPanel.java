import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AcceptedOffersPanel extends JPanel implements StringConstants {
	private JTable table;
	private ProjectTableModel model;
	private Object[][] data;
	private JTabbedPane tabbedPane;

	/**
	 * Create the panel.
	 */
	public AcceptedOffersPanel(TheMainPanel mainpanel, DBConnection db) {
		setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 521, 438);
		add(tabbedPane);
		
		crateTables();
		
		/*
		 * JScrollPane scrollPane = new JScrollPane();
		 * tabbedPane.addTab("New tab", null, scrollPane, null);
		 */

		//table = new JTable();
		/* scrollPane.setViewportView(table); */

	}

	private void crateTables() {
		try {
			model = new ProjectTableModel(offerInformationColumns);
			table = new JTable(model);
			tabbedPane.addTab("TEST", null, new JScrollPane(table), null);
		} catch (Exception e) {

		}
	}
}
