package gunnuuu.dankook;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {
	public static void main(String args[]) {
		JFrame frame = new JFrame("Table practice");
		JPanel panel = new JPanel();
		String [] headings = new String [] {"Id", "Name", "Country"};
		Object [][] data = new Object[][] {
			{"gunnnuuu","�ڰǿ�","Vietnam"},
			{"dddingzong","������","China"},
			{"Hwanwondang","����ȯ","Indonesia"},
			{"Printer","������","United Kingdom"}
		};
		
		JTable table = new JTable(data,headings);
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		table.setFillsViewportHeight(true);
		
		panel.add(new JScrollPane(table));
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setSize(1240,720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
