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

import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;

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
	int i = 2;
	private JTextField textField_7;
	
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
		frame.getContentPane().setLayout(new MigLayout("", "[grow][][][][]", "[][][][grow]"));
		
		JLabel lblDefinitions = new JLabel("Definitions");
		frame.getContentPane().add(lblDefinitions, "flowx,cell 0 0");
		
		JButton button_1 = new JButton("+");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createDefs(frame, i);
				i++;
				frame.validate();
			}
		});
		frame.getContentPane().add(button_1, "cell 0 0");
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[][][][][][]", "[][]"));
		
		textField_7 = new JTextField();
		panel.add(textField_7, "cell 0 0 6 1");
		textField_7.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 0 1 5 1");
		
		
	
		
	}
	
	public void createDefs(JFrame frame, int i) {
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "cell 0 " + Integer.toString(i) + ",grow");
		panel.setLayout(new MigLayout("", "[][][][][][]", "[][]"));
		
		textField_7 = new JTextField();
		panel.add(textField_7, "cell 0 0 6 1");
		textField_7.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 0 1 5 1");
	}
}
