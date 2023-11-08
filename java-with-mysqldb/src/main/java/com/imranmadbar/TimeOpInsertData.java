package com.imranmadbar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.Year;


public class TimeOpInsertData {
	public static void main(String[] args) {

		String jdbcUrl1 = "jdbc:mysql://localhost:3306/simpledb";
		String jdbcUrl2 = "jdbc:mysql://localhost:3306/simpledb?serverTimezone=UTC";
		String jdbcUrl3 = "jdbc:mysql://localhost:3306/simpledb?serverTimezone=Europe/Berlin";
		String jdbcUrl4 = "jdbc:mysql://localhost:3306/simpledb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		String username = "root";
		String password = "root";
		
		   LocalDateTime localDateTime = LocalDateTime.now();
			ZonedDateTime zonedDateTime = ZonedDateTime.now();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl4, username, password);

			String sql = "INSERT INTO time_operation (date_data, datetime_date, timestramp_date, year_date, date_str) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
//			preparedStatement.setString(1, "2023-11-08");
//			preparedStatement.setString(2, "2023-11-08 15:30:00");
//			preparedStatement.setString(3, "2023-11-08 15:30:00");
//			preparedStatement.setString(4, "2023");
//			preparedStatement.setString(5, "Some String Value");
			
			
			preparedStatement.setString(1, localDateTime.toString());
			preparedStatement.setString(2, localDateTime.toString());
			preparedStatement.setString(3, localDateTime.toString());
			preparedStatement.setString(4, Year.now().toString());
			preparedStatement.setString(5, localDateTime.toString());
			
//			
//			preparedStatement.setString(1, LocalDate.now().toString());
//			preparedStatement.setString(2, zonedDateTime.toString());
//			preparedStatement.setString(3, zonedDateTime.toString());
//			preparedStatement.setString(4, Year.now().toString());
//			preparedStatement.setString(5, zonedDateTime.toString());
//			
			
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new row has been inserted.");
			}

			conn.close();

		} catch (ClassNotFoundException e) {
			System.err.println("MySQL JDBC driver not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Database connection or query execution error.");
			e.printStackTrace();
		}
	}

}