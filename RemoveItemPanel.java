import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;


public class RemoveItemPanel extends JPanel implements StringConstants{
	private JPanel mainpanel;
	private DBConnection db;
	/**
	 * Create the panel.
	 */
	public RemoveItemPanel(JPanel mainpanel, DBConnection db) {
		
		setLayout(null);
		this.mainpanel = mainpanel;
		this.db = db;
		
		JLabel lblRemoveAnItem = new JLabel("Remove An Item");
		lblRemoveAnItem.setFont(new Font("Sylfaen", Font.PLAIN, 45));

		
		JList list = new JList();
		
		JButton btnOk = new JButton("Remove");
 		
		JButton btnCancel = new JButton("Cancel");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblRemoveAnItem)
							.addContainerGap(89, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnCancel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOk)
							.addGap(146))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRemoveAnItem)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnOk)))
		);
		setLayout(groupLayout);
		

	}
}
