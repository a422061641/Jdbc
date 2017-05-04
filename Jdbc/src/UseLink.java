import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UseLink {
	static String sql=null;
	static ResultSet rs=null;
	static MysqLlinkJdbc ml=null;
	public static void main(String arg[]){
		ml=new MysqLlinkJdbc();
		System.out.println("Please input yuor searching sentences");
		sql=input();
		try{
			rs=ml.MysqLlinkJdbc(sql);
			System.out.println(rs);
			while(rs.next()){
				System.out.println("print start");
				String id= rs.getString(1);
				String name= rs.getString(2);
				String price= rs.getString(3);
				System.out.println(id+name+price);
			}
			ml.DbClose();
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	public static String input(){
		Scanner sca=new Scanner(System.in);
		String pr_sql=sca.nextLine();
		return pr_sql;
	}
}
