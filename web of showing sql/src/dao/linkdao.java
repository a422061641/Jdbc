package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
public class linkdao {
		String dcurl="jdbc:mysql://localhost:3306/how2java?useUnicode=true&characterEncoding=utf-8";
		String user="root";
		String password="admin";
		Connection con =null;
		Statement sta=null;
		ResultSet rs=null;
		public ResultSet MysqLlinkJdbc(String sql){
			try{
				System.out.println("link start");
				Class.forName("com.mysql.jdbc.Driver");
				con = java.sql.DriverManager.getConnection(dcurl,user,password);
				sta=con.createStatement();
				rs = sta.executeQuery(sql);
				} 
			catch (Exception e){
				e.printStackTrace(); 
				}
			return rs;
		}
		public void close(){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}