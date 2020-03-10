import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class application {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static JList list;
	private static JRadioButton rdbtnAz;

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
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				wordEditor.editorMain();
			}
		});
		frame.getContentPane().add(btnNewButton_2, "flowx,cell 0 0");
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, "flowx,cell 0 2 1 9,grow");
		
		list = new JList();
		DefaultListModel x = new DefaultListModel();
		ArrayList<Word> sortedWords = sortWordsAZ(Dictionary.getWords());
		Dictionary.editJson(sortedWords);
		x.addAll(getWords());
		list.setModel(x);
		scrollPane.setViewportView(list);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ArrayList<Word> searchWords = Dictionary.searchDict(Dictionary.getWords(), textField_1.getText());
				reloadWordsNoCommit(searchWords);
			}
		});
		textField_1.setToolTipText("Enter Word to Search");
		frame.getContentPane().add(textField_1, "cell 23 0 5 1,alignx center,aligny center");
		textField_1.setColumns(10);
		
		
		
		JLabel lblSort = new JLabel("Sort:");
		frame.getContentPane().add(lblSort, "flowx,cell 0 1");
		
		ActionListener azActionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
		        
		        ArrayList<Word> sortedWords = sortWordsAZ(Dictionary.getWords());
				Dictionary.editJson(sortedWords);
				Vector wordVector = getWords();
				DefaultListModel tempModel = new DefaultListModel();
				tempModel.addAll(wordVector);
				list.setModel(tempModel);
				
		      }
		    };
		    
		    ActionListener zaActionListener = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
			        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
			        
			        ArrayList<Word> sortedWords = sortWordsZA(Dictionary.getWords());
					Dictionary.editJson(sortedWords);
					Vector wordVector = getWords();
					DefaultListModel tempModel = new DefaultListModel();
					tempModel.addAll(wordVector);
					list.setModel(tempModel);
					
			      }
			    };
		
		rdbtnAz = new JRadioButton("A-Z", true);
		frame.getContentPane().add(rdbtnAz, "cell 0 1");
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		frame.getContentPane().add(textPane, "cell 2 2 26 9,grow");
		textPane.setText("Welcome to the dictionary!");
		
		JButton btnNewButton_3 = new JButton("Delete Word");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int[] indexArray = list.getSelectedIndices();
				ArrayList<Integer> indexes = new ArrayList<Integer>();
				for(int i = 0; i < indexArray.length; i++) {
					indexes.add(indexArray[i]);
				}
								
				int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected items?", "Select an Option", JOptionPane.YES_NO_OPTION);
				
				if(input == 0) {
					ArrayList<Word> temp = Dictionary.deleteWords(indexes);
					Dictionary.editJson(temp);
					reloadWords(temp);
				}else if(input == 1) {
					reloadWords(Dictionary.getWords());
				}
				
			}
		});
		frame.getContentPane().add(btnNewButton_3, "cell 0 0");
		
		JRadioButton rdbtnZa = new JRadioButton("Z-A");
		frame.getContentPane().add(rdbtnZa, "cell 0 1");
		
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(rdbtnAz);
		radioButtons.add(rdbtnZa);
		
		rdbtnAz.addActionListener(azActionListener);
		rdbtnZa.addActionListener(zaActionListener);
		
		MouseListener mouseListener = new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) {
		         if (e.getClickCount() == 1) {
		             int index = list.locationToIndex(e.getPoint());
		             String displayWord = "";
		             if(Dictionary.getNames().get(index).equals(list.getSelectedValue().toString())) {
		            	 displayWord = Dictionary.getNames().get(index);
		             }else if(!(Dictionary.getNames().get(index).equals(list.getSelectedValue().toString()))) {
		            	 index = Dictionary.getNames().indexOf(list.getSelectedValue());
		            	 displayWord = Dictionary.getNames().get(index);
		             }
		             
		             String temp = displayWord.substring(0,1).toUpperCase();
		             displayWord = temp + displayWord.substring(1);
		             
		             String displayDefs = Dictionary.getFormattedWordDefinitions(index);
		             
		             String displaySyns = Dictionary.getFormattedSyns(index);
		             
		             String displayAnts = Dictionary.getFormattedAnts(index);
		             
		             String displayedText = displayWord + "\n" + displayDefs + "\n" + displaySyns + "\n" + displayAnts;
		             
		             textPane.setText(displayedText);
		             
		          }
		     }
		 };
		 list.addMouseListener(mouseListener);
		
	}
	
	public static Vector getWords() {
		Vector nameVector = new Vector();
		ArrayList<String> names = Dictionary.getNames();
		
		for(int i = 0; i < names.size(); i++) {
			nameVector.add(names.get(i));
		}
		
		return nameVector;
	}
	
	public static Vector getWordsFromArrayList(ArrayList<Word> words) {
		Vector nameVector = new Vector();
			
		ArrayList<String> names = new ArrayList<String>();
		
		for(int i = 0; i < words.size(); i++) {
			names.add(words.get(i).getName());
		}
		
		for(int i = 0; i < names.size(); i++) {
			nameVector.add(names.get(i));
		}
		
		return nameVector;
	}
	
	public static ArrayList<Word> sortWordsZA(ArrayList<Word> words){
		
		List<Word> tempList = words;
		
		Collections.sort(words, new Comparator<Word>() {
	        @Override
	        public int compare(Word word2, Word word1)
	        {

	            return  word1.word.compareTo(word2.word);
	        }
	    });
		
		ArrayList<Word> tempArrayList = new ArrayList<Word>(tempList);
		
		return tempArrayList;
		
	}
	
	public static ArrayList<Word> sortWordsAZ(ArrayList<Word> words){
		
		ArrayList<Word> sortedWords = sortWordsZA(words);
		ArrayList<Word> sortedWordsZA = new ArrayList<Word>();
			
		for(int i = sortedWords.size()-1; i > -1; i--) {

			sortedWordsZA.add(sortedWords.get(i));
			
		}
		
		return sortedWordsZA;
		
	}
	
	public static void reloadWords(ArrayList<Word> words) {
		ArrayList<Word> sortedWords = sortWordsAZ(words);
		Dictionary.editJson(sortedWords);
		Vector wordVector = getWords();
		DefaultListModel tempModel = new DefaultListModel();
		tempModel.addAll(wordVector);
		list.setModel(tempModel);
		
		rdbtnAz.setSelected(true);
		
	}
	
	public static void reloadWordsNoCommit(ArrayList<Word> words) {
		ArrayList<Word> sortedWords = sortWordsAZ(words);
		Vector wordVector = getWordsFromArrayList(sortedWords);
		DefaultListModel tempModel = new DefaultListModel();
		tempModel.addAll(wordVector);
		list.setModel(tempModel);
		
		rdbtnAz.setSelected(true);
		
	}
	
}

