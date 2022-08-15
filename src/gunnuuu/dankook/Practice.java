package gunnuuu.dankook;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Practice {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("°øºÎÇÏ±â½È´Ù");
		JButton btn1 = new JButton("¸ØÃç!");
		JButton btn2 = new JButton("²¨Á®");
		JButton btn3 = new JButton("¸øÂü¾Æ");
		JTextArea txtArea = new JTextArea();
		JPanel btnPanel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		btnPanel.add(btn3);
		panel.add(label, BorderLayout.NORTH);
		panel.add(btnPanel, BorderLayout.WEST);
		panel.add(txtArea, BorderLayout.CENTER);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtArea.append("Ä§´ë·Î ´ÙÀÌºù~\n");
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(txtArea.getText());
			}
			
		});
		
		
		
		frame.add(panel);
					
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(1240,720));
		frame.setSize(1240,720);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

