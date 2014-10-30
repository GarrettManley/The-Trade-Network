import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;



public class TheMainFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				TheMainFrame x = new TheMainFrame();
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public TheMainFrame() {
		JFrame frame = new JFrame("The Trade Network");
		frame.setBackground(Color.WHITE);
		DBConnection db = new DBConnection();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	
		frame.setBounds(100, 100, 450, 300);
		contentPane = new TheMainPanel(frame, db);
		contentPane.setBackground(Color.WHITE);
		frame.setContentPane(contentPane);
	}

}
