import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.CardLayout;
import java.awt.ScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;

public class application {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					application window = new application();
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
	public application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][][][][][][][][][grow][][][][][grow]", "[][][][][][][][][][][grow]"));
		frame.setTitle("Problem Set 10 - E-Dictionary");
		
		
		JButton btnNewButton_2 = new JButton("Add Word");
		frame.getContentPane().add(btnNewButton_2, "flowx,cell 0 0");
		
		JButton btnNewButton_1 = new JButton("<");
		frame.getContentPane().add(btnNewButton_1, "cell 25 0");
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 26 0");
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter Word to Search");
		frame.getContentPane().add(textField_1, "cell 27 0,alignx center,aligny center");
		textField_1.setColumns(10);
		
		JLabel lblSort = new JLabel("Sort:");
		frame.getContentPane().add(lblSort, "flowx,cell 0 1");
		
		JRadioButton rdbtnAz = new JRadioButton("A-Z", true);
		frame.getContentPane().add(rdbtnAz, "cell 0 1");
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		frame.getContentPane().add(textPane, "cell 2 2 26 9,grow");
		textPane.setText("Welcome to the dictionary!");
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, "flowx,cell 0 2 1 9,grow");
		
		
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setListData(getWords());
		scrollPane.setViewportView(list);
		
		JButton btnNewButton_3 = new JButton("Delete Word");
		frame.getContentPane().add(btnNewButton_3, "cell 0 0");
		
		JRadioButton rdbtnZa = new JRadioButton("Z-A");
		frame.getContentPane().add(rdbtnZa, "cell 0 1");
		
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(rdbtnAz);
		radioButtons.add(rdbtnZa);
		
		MouseListener mouseListener = new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) {
		         if (e.getClickCount() == 1) {
		             int index = list.locationToIndex(e.getPoint());
		             
		             String displayWord = Dictionary.getNames().get(index);
		             String temp = displayWord.substring(0,1).toUpperCase();
		             displayWord = temp + displayWord.substring(1);
		             
		             String displayDefs = Dictionary.getFormattedWordDefinitions(index);
		             
		             String displayedText = displayWord + "\n" + displayDefs;
		             
		             textPane.setText(displayedText);
		             
		          }
		     }
		 };
		 list.addMouseListener(mouseListener);
		
	}
	
	public Vector getWords() {
		Vector nameVector = new Vector();
		ArrayList<String> names = Dictionary.getNames();
		
		for(int i = 0; i < names.size(); i++) {
			nameVector.add(names.get(i));
		}
		
		return nameVector;
	}
	
}

