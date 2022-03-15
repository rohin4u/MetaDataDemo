package com;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Test3 {

	public static void main(String[] args) throws SQLException {
		
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
		
		PreparedStatement pst = con.prepareStatement("insert into employees values(?,?,?)");
		pst.setString(1, "Mayur");
		pst.setString(2, "101");
		pst.setString(3, "delhi");
		
		pst.execute();
		
		ParameterMetaData pmd = pst.getParameterMetaData();
		
		int count = pmd.getParameterCount();
		
		for(int i=1; i<=count; i++) {
			
			System.out.println("Parameter Number:"+i);
			System.out.println("Parameter Mode:"+pmd.getParameterMode(i));
			System.out.println("Parameter Type:"+pmd.getParameterType(i));
			System.out.println("Parameter Precision:"+pmd.getPrecision(i));
			System.out.println("Parameter Scale:"+pmd.getScale(i));
			System.out.println("Parameter isSigned:"+pmd.isSigned(i));
			System.out.println("Parameter isNullable:"+pmd.isNullable(i));
			System.out.println("---------------");
			
		}
		con.close();
		
	}

}
