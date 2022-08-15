package gunnuuu.dankook;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Customer_App {

	private JFrame frame;
	private JTextField ID;
	private JTextField txtEnterpassword;
	private JButton btnNewButton;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField note;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
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
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Customer customer = new Customer();
		frame = new JFrame();
		frame.setSize(950,680);
		frame.getContentPane().setLayout(null);
		String [][] data = customer.getCustomers();
		String [] headers = {"Name","Phone","Gender","Age","Note"};
		
		JPanel tablePanel = new ImagePanel(new ImageIcon("C:/gunnuuu/workspace/practice/image/sky.png").getImage());
		tablePanel.setBounds(0, 0, 936, 620);
		tablePanel.setVisible(false);
		
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/gunnuuu/workspace/practice/image/Dankook.png").getImage());
		welcomePanel.setBounds(0, 0, 936, 620);
		welcomePanel.setVisible(true);
		
		
		ImagePanel mainPanel = new ImagePanel(new ImageIcon("C:/gunnuuu/workspace/practice/image/sky.png").getImage());
		mainPanel.setBounds(0, 0, 936, 620);
		mainPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome to DKU");
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 32));
		lblNewLabel_3.setBounds(333, 24, 325, 65);
		mainPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(65, 99, 205, 65);
		mainPanel.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setBounds(232, 111, 198, 43);
		mainPanel.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Age");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1.setBounds(65, 206, 205, 65);
		mainPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Phone");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_2.setBounds(422, 99, 205, 65);
		mainPanel.add(lblNewLabel_2_2);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(232, 218, 198, 43);
		mainPanel.add(age);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(583, 111, 198, 43);
		mainPanel.add(phone);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Gender");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1.setBounds(65, 324, 205, 65);
		mainPanel.add(lblNewLabel_2_1_1);
		
		JComboBox gender = new JComboBox(new String[] {"Male", "Female"});
		gender.setFont(new Font("±¼¸²", Font.ITALIC, 20));
		gender.setBounds(232, 330, 188, 55);
		mainPanel.add(gender);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Note");
		lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1_1.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_2_1_1.setBounds(422, 206, 205, 65);
		mainPanel.add(lblNewLabel_2_2_1_1);
		
		note = new JTextField();
		note.setHorizontalAlignment(SwingConstants.LEFT);
		note.setColumns(10);
		note.setBounds(583, 206, 198, 83);
		mainPanel.add(note);
		
		JButton BtnS = new JButton("Submit");
		BtnS.setFont(new Font("±¼¸²", Font.BOLD, 17));
		BtnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String noteTxt = note.getText();
				
				customer.creatCustomer(nameTxt, phoneTxt, genderTxt, ageTxt, noteTxt);
				JOptionPane.showMessageDialog(null, "Your data has been saved successfully");
			}
		});
		BtnS.setBounds(606, 329, 146, 55);
		mainPanel.add(BtnS);
		
		JButton listBtn = new JButton("List");
		listBtn.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		listBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				tablePanel.setVisible(true);
			}
		});
		listBtn.setBounds(638, 409, 87, 43);
		mainPanel.add(listBtn);
		frame.getContentPane().add(welcomePanel);
		
		ID = new JTextField();
		ID.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		ID.setToolTipText("EnterID");
		ID.setBounds(157, 522, 224, 54);
		welcomePanel.add(ID);
		ID.setColumns(10);
		
		JPasswordField PASSWORD = new JPasswordField();
		PASSWORD.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		PASSWORD.setToolTipText("EnterPASSWORD");
		PASSWORD.setBounds(480, 522, 213, 54);	
		welcomePanel.add(PASSWORD);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID.getText().equals("gunnuuu")&&Arrays.equals(PASSWORD.getPassword(),"qkrrjsdn1!".toCharArray())) {
					System.out.println("Hi gunnuuu Welcome");
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:/gunnuuu/workspace/practice/image/log in.png"));
		btnNewButton.setBounds(732, 522, 113, 54);
		welcomePanel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(105, 523, 52, 46);
		welcomePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PW :");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 28));
		lblNewLabel_1_1.setBounds(407, 523, 71, 46);
		welcomePanel.add(lblNewLabel_1_1);
		tablePanel.setLayout(null);
		JTable table = new JTable(data,headers);
		table.setRowHeight(30);
		table.setSize(800,400);
		table.setPreferredScrollableViewportSize(new Dimension(800,400));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(88, 94, 802, 428);
		tablePanel.add(scrollPane);
		frame.getContentPane().add(tablePanel);
		
		search = new JTextField();
		search.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		search.setBounds(88, 24, 802, 44);
		tablePanel.add(search);
		search.setColumns(10);
		
		JButton regBtn = new JButton("Register");
		regBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				tablePanel.setVisible(false);
			}
		});
		regBtn.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		regBtn.setBounds(743, 542, 147, 43);
		tablePanel.add(regBtn);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String Val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(Val));
			}
		});
		
		TableColumnModel columnmodels = table.getColumnModel();
		columnmodels.getColumn(0).setPreferredWidth(100);
		columnmodels.getColumn(2).setPreferredWidth(50);
		columnmodels.getColumn(3).setPreferredWidth(20);
		
		frame.setJMenuBar(menuBar());	
		frame.setResizable(false); 
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		JMenuItem open = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		
		fileMenu.add(open);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "Exit Dankook?","Close",JOptionPane.INFORMATION_MESSAGE);
				if(res == JOptionPane.OK_OPTION) {
					System.exit(0);
				}else if(res == JOptionPane.NO_OPTION) {
				
				}
			}
		});
		
		return bar;
	}
}

class ImagePanel extends JPanel{
	private Image img;
		
	public ImagePanel(Image img) { 
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
		
	public int getWidth() {
		return img.getWidth(null);
	}
		
	public int getHeight() {
		return img.getHeight(null);
	}
		
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}

