package com.imranmadbar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.Year;


public class TimeOpInsertData2 {
	public static void main(String[] args) {

		String jdbcUrl1 = "jdbc:mysql://172.16.8.132:6681/apihub?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT";

		String username = "apihub";
		String password = "RgEG5TY_992Hfqus_98hFFD";
		
		   LocalDateTime localDateTime = LocalDateTime.now();
			ZonedDateTime zonedDateTime = ZonedDateTime.now();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl1, username, password);

			String sql = "INSERT INTO apihub.otp_service (otp_id, otp_api_status, otp_channel, "
							+ "otp_client, otp_destination_resp_time, "
					+ "otp_destination_status, otp_duration, "
								+ "otp_msisdn, otp_sms, otp_start_time, "
					+ "otp_token, otp_user_input, otp_user_input_time,"
					+ "otp_validation_api_status, otp_validation_channel, otp_validation_client)"
					
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			
	
			preparedStatement.setString(1, "81317666");
			preparedStatement.setString(2, "202");
			preparedStatement.setString(3, "Nagad");
			preparedStatement.setString(4, "NULL");
			preparedStatement.setString(5, localDateTime.toString());
			preparedStatement.setString(6, "202");
			preparedStatement.setString(7, "300");
			preparedStatement.setString(8, "01916894486");
			preparedStatement.setString(9, "আপনার ওটিপি 579255 ");
			preparedStatement.setString(10, localDateTime.toString());
			preparedStatement.setString(11, "579255");
			preparedStatement.setString(12, "121212");
			preparedStatement.setString(13, localDateTime.toString());
			preparedStatement.setString(14, "404");
			preparedStatement.setString(15, "tEST2");
			preparedStatement.setString(16, "NULL");
			
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