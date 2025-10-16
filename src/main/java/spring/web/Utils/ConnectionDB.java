package spring.web.Utils;

import java.sql.*;

public class ConnectionDB {
	 private static String URL  = "jdbc:mysql://localhost:3306/estatebasic" ;
	 private static  String USER = "root";
	 private static String PASS = "051005" ; 
	 
	 public static Connection getConnection() {
		 Connection conn = null ; 
		 try {
			 conn = DriverManager.getConnection(URL , USER , PASS )  ; 
 		 }
		 catch (SQLException e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		return conn ; 
	 }
	 
}
