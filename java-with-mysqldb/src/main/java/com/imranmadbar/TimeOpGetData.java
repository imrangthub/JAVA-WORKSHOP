package com.imranmadbar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TimeOpGetData {
	public static void main(String[] args) {

		String jdbcUrl1 = "jdbc:mysql://localhost:3306/simpledb";
		String jdbcUrl2 = "jdbc:mysql://localhost:3306/simpledb?serverTimezone=UTC";
		String username = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl1, username, password);

            String sql = "SELECT id, date_data, datetime_date, timestramp_date, year_date, date_str FROM time_operation";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
            	String id = resultSet.getString("id");
                String dateData = resultSet.getString("date_data");
                String dateTimeDate = resultSet.getString("datetime_date");
                String timestampDate = resultSet.getString("timestramp_date");
                String yearDate = resultSet.getString("year_date");
                String dateStr = resultSet.getString("date_str");
                
                String allDatesInSingleRow = "ID: "+id+" "+"DATE: " + dateData + ", "
                        + "DATETIME: " + dateTimeDate + ", "
                        + "TIMESTRAMP: " + timestampDate + ", "
                        + "YEAR: " + yearDate;
                
              //  System.out.println(allDatesInSingleRow);
                
                System.out.println("ID: " + id);
                System.out.println("YEAR: " + yearDate);
                System.out.println("DATE: " + dateData);
                System.out.println("DATETIME: " + dateTimeDate);
                System.out.println("TIMESTRAMP: " + timestampDate);
                System.out.println("DATE_STR: " + dateStr);
                System.out.println();
                
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}