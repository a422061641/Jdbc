package control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import dao.linkdao;
import net.sf.json.JSONArray;
public class Commit extends HttpServlet{
	public ResultSet rs=null;
	
	public void initP(){
		System.out.println("start");
	}
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ArrayList<String> ColumnNames=new ArrayList<String>();
		ArrayList<String> Columnvalues=new ArrayList<String>();
		ArrayList<String> nameandvalue=new ArrayList<String>();
		System.out.println("service");
		String input_sql=request.getParameter("input_sql");
		System.out.println(input_sql);
		linkdao dao=new linkdao();
		try {
			rs=dao.MysqLlinkJdbc(input_sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			ResultSetMetaData metaData = rs.getMetaData();//获取此 ResultSet 对象的列的编号、类型和属性。会System.out.println("link start").
			while(rs.next()){
				for (int i = 0; i < metaData.getColumnCount(); i++){
					Columnvalues.add(rs.getString(i+1));//read and add Columnvalues
					}
						}
			for (int i = 0; i < metaData.getColumnCount(); i++){
				ColumnNames.add(metaData.getColumnName(i+1));//read and add ColumnNames
				}
			String x=Integer.toString(metaData.getColumnCount());
			nameandvalue.add(x);
			nameandvalue.addAll(ColumnNames);
			nameandvalue.addAll(Columnvalues);
			response.getWriter().write(JSONArray.fromObject(nameandvalue).toString());
			System.out.println(JSONArray.fromObject(nameandvalue).toString());
			dao.close();
			System.out.println("service end");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	 public void doGet(){
		 System.out.println("doget");
	 }    
	 public void doPost(){
		 System.out.println("Post");
	 }
	 public ResultSet getRs(){
		 return rs;
	 }
	 public void setRs(ResultSet r){
		 this.rs=r;
	 }
}

