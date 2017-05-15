package javaweb;

import java.io.IOException;
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
import Dao.*;
public class Commit extends HttpServlet{
	public ResultSet rs=null;
	public String Target="/show.jsp";
	public void initP(){
		System.out.println("start");
		
	}
	public void service(HttpServletRequest request,HttpServletResponse response){
		ArrayList<String> ColumnNames=new ArrayList<String>();
		ArrayList<String> Columnvalues=new ArrayList<String>();
		System.out.println("service");
		String input_sql=request.getParameter("input_sql");
		System.out.println(input_sql);
		dao dao=new dao();
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
			request.setAttribute("values",Columnvalues);//add Columnvalues to request
			for (int i = 0; i < metaData.getColumnCount(); i++){
				ColumnNames.add(metaData.getColumnName(i+1));//read and add ColumnNames
				}
			request.setAttribute("names",ColumnNames);//add ColumnNames to request
			ServletContext context=getServletContext();
			RequestDispatcher dispatcher=context.getRequestDispatcher(Target);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dao.close();
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

