
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class selectClass {

	final static String sql = "select * from employee"; 
	
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:orcle:thin@localhost:1521:xe";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,"testdb","testdb123");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("번호 \t 이름\t 직책 \t 부서번호 \t 이메일");
			System.out.println("--------------------------------");
			
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t");
				System.out.println(rs.getString(2)+"\t");
				System.out.println(rs.getString(3)+"\t");
				System.out.println(rs.getInt(4)+"\t");
				System.out.println(rs.getString(5)+"\n");
				
			}

		}catch(Exception e){
			System.out.println(e);
			
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
				
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		
		
	}

}
