import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import java.awt.ScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import java.awt.TextComponent;
import javax.swing.Box;

public class wordEditor {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton button;
	private JTextField textField_5;
	private JTextField textField_6;
	int i = 5;
	private JTextField textField_7;
	String[] comboOptions = {"Noun","Verb","Adjective","Uncategorized"};
	private JTextField textField_8;
	private JTextField txtWordWordWord;
	private JTextField textField_9;
	
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
		frame.getContentPane().setLayout(new MigLayout("", "[grow][][][][][]", "[][][][][95.00,grow][grow][]"));
		
		JLabel lblWord = new JLabel("Word:");
		frame.getContentPane().add(lblWord, "flowx,cell 0 0");
		
		JButton btnNewButton = new JButton("Create Word");
		frame.getContentPane().add(btnNewButton, "cell 4 0");
		
		JLabel lblSynonyms = new JLabel("Synonyms:");
		frame.getContentPane().add(lblSynonyms, "flowx,cell 0 1");
		
		JLabel lblAntonyms = new JLabel("Antonyms:");
		frame.getContentPane().add(lblAntonyms, "flowx,cell 0 2");
		
		JLabel lblDefinitions = new JLabel("Definitions:");
		frame.getContentPane().add(lblDefinitions, "flowx,cell 0 3");
		
		
		
		textField_8 = new JTextField();
		frame.getContentPane().add(textField_8, "cell 0 0");
		textField_8.setColumns(10);
		
		txtWordWordWord = new JTextField();
		frame.getContentPane().add(txtWordWordWord, "cell 0 1");
		txtWordWordWord.setColumns(10);
		
		textField_9 = new JTextField();
		frame.getContentPane().add(textField_9, "cell 0 2");
		textField_9.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, "cell 0 4,grow");
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[][][][][][]", "[][]"));
		
		textField_7 = new JTextField();
		panel.add(textField_7, "cell 0 0 6 1");
		textField_7.setColumns(10);
		textField_7.setName("textField");
		
		JComboBox comboBox = new JComboBox(comboOptions);
		comboBox.setName("comboBox");
		panel.add(comboBox, "cell 0 1 5 1");
		
		JButton button_1 = new JButton("+");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createDefs(frame, i, panel);
				i += 2;
				frame.validate();
			}
		});
		frame.getContentPane().add(button_1, "cell 0 3");
		
	}
	
	public void createDefs(JFrame frame, int i, JPanel panel) {
//		JPanel panel = new JPanel();
//		scrollPane.add(scrollPane, "cell 0 " + Integer.toString(i) + ",grow");
//		panel.setLayout(new MigLayout("", "[][][][][][]", "[][]"));
		
		textField_7 = new JTextField();
		panel.add(textField_7
				, "cell 0 " + Integer.toString(i)
				);
		textField_7.setColumns(10);
		textField_7.setName("textField");
		
		JComboBox comboBox = new JComboBox(comboOptions);
		comboBox.setName("comboBox");
		panel.add(comboBox
				, "cell 0 " + Integer.toString(i+1) 
				+  " 5 1"
				);
	}
	
	public static List<Component> getAllComponents(final Container c) {
	    Component[] comps = c.getComponents();
	    List<Component> compList = new ArrayList<Component>();
	    for (Component comp : comps) {
	        compList.add(comp);
	        if (comp instanceof Container)
	            compList.addAll(getAllComponents((Container) comp));
	    }
	    return compList;
	}
}
