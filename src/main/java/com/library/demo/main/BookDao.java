package com.library.demo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author abul.kalam
 * @since 2020-07-19
 *
 */
public class BookDao {
	public static int save(String callno, String name, String author, String publisher, int quantity) {
		int status = 0;
		try {
			String con1 = DB.getConnection();
//		PreparedStatement ps=con.prepareStatement("insert into books(callno,name,author,publisher,quantity) values(?,?,?,?,?)");
//		ps.setString(1,callno);
//		ps.setString(2,name);
//		ps.setString(3,author);
//		ps.setString(4,publisher);
//		ps.setInt(5,quantity);
//		status=ps.executeUpdate();
//		con.close();

			try (Connection con = DriverManager.getConnection(con1); Statement stmt = con.createStatement();) {
				String SQL = "insert into books values(" + callno + "," + name + "," + author + "," + publisher + ","
						+ quantity + ")";
				stmt.executeUpdate(SQL);
//				ResultSet rs1 = stmt.executeQuery(rs);
			}
			// Handle any errors that may have occurred.
			catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
