package com.library.demo.main;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 
 * @author abul.kalam
 * @since 2020-07-19
 *
 */
public class DB {
	public static String getConnection() {
		String con = null;
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// con=DriverManager.getConnection("jdbc:mysql://vNTDACWSSQLD002:1433/DOCUTECH_DEV","docutech_dev_dbo","docutech_dev_dbo123");
			con = "jdbc:sqlserver://vNTDACWSSQLD002:1433;databaseName=DOCUTECH_DEV;user=docutech_dev_dbo;password=docutech_dev_dbo123";
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
