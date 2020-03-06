import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import java.awt.ScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class wordEditor {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][]", "[][][][][][][][][][][]"));
		
		JLabel lblWord = new JLabel("Word:");
		frame.getContentPane().add(lblWord, "flowx,cell 1 1");
		
		JLabel lblDefinition = new JLabel("Definition:");
		frame.getContentPane().add(lblDefinition, "flowx,cell 1 3");
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "cell 4 1");
		textField.setColumns(10);
		
		JLabel lblPartOfSpeech = new JLabel("Part of Speech:");
		frame.getContentPane().add(lblPartOfSpeech, "flowy,cell 1 4");
		
		ScrollPane scrollPane = new ScrollPane();
		frame.getContentPane().add(scrollPane, "flowx,cell 0 0 18 11");
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "cell 4 3");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		frame.getContentPane().add(textField_2, "cell 4 4");
		textField_2.setColumns(10);
		
		JLabel lblSynonyms = new JLabel("Synonyms:");
		frame.getContentPane().add(lblSynonyms, "cell 1 6");
		
		JLabel lblAntonyms = new JLabel("Antonyms:");
		frame.getContentPane().add(lblAntonyms, "cell 1 8");
		
		textField_3 = new JTextField();
		frame.getContentPane().add(textField_3, "cell 4 6");
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		frame.getContentPane().add(textField_4, "cell 4 8");
		textField_4.setColumns(10);
	}

}
