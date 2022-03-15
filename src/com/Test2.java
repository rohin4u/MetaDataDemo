package com;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Test2 {

	public static void main(String[] args) throws SQLException {
		
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
		
		PreparedStatement statement = con.prepareStatement("select * from employee");
		
		ResultSet rSet = statement.executeQuery();
		
		ResultSetMetaData rsetMeta = rSet.getMetaData();
		
		int count = rsetMeta.getColumnCount();
		
		for(int i=1; i<=count; i++) {
			
			System.out.println("Column Number:"+i);
			System.out.println("Column Name:"+rsetMeta.getColumnName(i));
			System.out.println("Column Type:"+rsetMeta.getColumnType(i));
			System.out.println("Column Size:"+rsetMeta.getColumnDisplaySize(i));
			System.out.println("---------------");
			
		}
		con.close();

	}

}
