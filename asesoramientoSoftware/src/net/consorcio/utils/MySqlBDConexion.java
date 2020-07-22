package net.consorcio.utils;
import java.sql.Connection;
import java.sql.DriverManager;
public class MySqlBDConexion {
	public static Connection getConexion(){
		Connection cn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/asesoramiento_ml","root","mysql");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			
		}
		return cn;	
	}
}


