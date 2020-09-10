package com.library.demo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author abul.kalam
 * @since 2020-07-19
 *
 */
public class JdbcTesr {

	public static void main(String[] args) throws ClassNotFoundException {

		// Create a variable for the connection string.

//		
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://vNTDACWSSQLD002:1433/DOCUTECH_DEV", "docutech_dev_dbo",
					"docutech_dev_dbo123");

			if (con != null) {
				System.out.println("soucess");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
