package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	public static final String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String URL="jdbc:sqlserver://localhost:1433;databaseName=goods";
	private static final String UID="sa";
	private static final String PWD="123456";
	
	public static Connection getcon() throws Exception{
		Class.forName(Driver);
		return DriverManager.getConnection(URL,UID,PWD);
	}
		 public static void closes(ResultSet rst,Connection con,PreparedStatement ps){
			 try {
				 if(rst!=null){
					rst.close();
				 }if (ps!=null){
					 ps.close();
				 }if(con!=null){
					 con.close();
				 }
				 rst=null;
				 ps=null;
				 con=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			 
		 }
		}

