package com.library.demo.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
/**
 * 
 * @author abul.kalam
 * @since 2020-07-19
 *
 */
public class ViewLibrarian extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLibrarian frame = new ViewLibrarian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewLibrarian() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String data[][] = null;
		String column[] = null;
		try {
			String con1 = DB.getConnection();
			Connection con = DriverManager.getConnection(con1);
			Statement stmt = con.createStatement();
			String ps = "select * from librarian";
			ResultSet rs = stmt.executeQuery(ps);

			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			column = new String[cols];
			for (int i = 1; i <= cols; i++) {
				column[i - 1] = rsmd.getColumnName(i);
			}

			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();

			data = new String[rows][cols];
			int count = 0;
			while (rs.next()) {
				for (int i = 1; i <= cols; i++) {
					data[count][i - 1] = rs.getString(i);
				}
				count++;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		table = new JTable(data, column);
		JScrollPane sp = new JScrollPane(table);

		contentPane.add(sp, BorderLayout.CENTER);
	}

}