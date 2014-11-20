import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;


public class ConnectionSuccess extends JPanel implements StringConstants{
	JButton btnGoBack;
	JPanel mainpanel;
	OnChangeSize callFrame;

	public ConnectionSuccess(TheMainPanel mainpanel) {
		setLayout(null);
		setSize(800,800);
		
		
		
		this.mainpanel = mainpanel;
		JLabel lblNewLabel = new JLabel("CONNECTION SUCCESS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(56, 44, 313, 143);
		add(lblNewLabel);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(177, 231, 89, 23);
		add(btnGoBack);
		btnGoBack.addActionListener(new ConnectionSuccessListener());

	}
	
	class ConnectionSuccessListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnGoBack){
				CardLayout cl = (CardLayout)(mainpanel.getLayout());
				cl.show(mainpanel, LOGIN);
			}
			
		}
		
	}

}
