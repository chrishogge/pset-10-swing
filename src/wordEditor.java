import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import java.awt.ScrollPane;
import javax.swing.JLabel;

public class wordEditor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wordEditor window = new wordEditor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public wordEditor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Word Editor");
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][]", "[][][][][][][][][][]"));
		
		JLabel lblWord = new JLabel("Word:");
		frame.getContentPane().add(lblWord, "flowx,cell 1 1");
		
		JLabel lblDefinition = new JLabel("Definition:");
		frame.getContentPane().add(lblDefinition, "flowx,cell 1 3");
		
		ScrollPane scrollPane = new ScrollPane();
		frame.getContentPane().add(scrollPane, "cell 0 0 16 10");
	}

}
