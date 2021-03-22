package com.project.ExpenseManager;

import com.fasterxml.jackson.core.JsonParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Currency;
import java.util.Scanner;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class ExpenseManagerApplication {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:mem:testdb";

	//  Database credentials
	static final String USER = "sa";
	static final String PASS = "";

	public static void main(String[] args) {

		SpringApplication.run(ExpenseManagerApplication.class, args);
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
				= "https://api.exchangerate.host/latest";
		ResponseEntity<String> response
				= restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
		System.out.println("\n\nThis is the web page where all rates was acquired from");
		System.out.println(response);


//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			// STEP 1: Register JDBC driver
//			Class.forName(JDBC_DRIVER);
//
//			//STEP 2: Open a connection
//			System.out.println("Connecting to database...");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//			stmt = conn.createStatement();
//
//			String sql = "INSERT INTO expenses " + "VALUES (0,'2000','USD', '19.03.2021' , 'Salmon')";
//			stmt.executeUpdate(sql);
//
//			sql = "INSERT INTO expenses " + "VALUES (1,'55555','UAH', '17.09.2021' , 'Beer')";
//			stmt.executeUpdate(sql);
//
//			sql = "INSERT INTO expenses " + "VALUES (2,'1253123', 'AUD', '05.02.2020' , 'Sweets')";
//			stmt.executeUpdate(sql);
//
//			System.out.println("Inserted records into the table...");
//			stmt.close();
//			conn.close();
//		} catch (SQLException se) {
//			//Handle errors for JDBC
//			se.printStackTrace();
//		} catch (Exception e) {
//			//Handle errors for Class.forName
//			e.printStackTrace();
//		} finally {
//			//finally block used to close resources
//			try {
//				if (stmt != null) stmt.close();
//			} catch (SQLException se2) {
//			} // nothing we can do
//			try {
//				if (conn != null) conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			} //end finally try
//		} //end try

		System.out.println("\nNote:If you wish to add 3 insert to db while runtime just uncomment content above");
	}
}


