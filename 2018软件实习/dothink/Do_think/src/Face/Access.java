package Face;
import java.sql.*;

public class Access {
	ResultSet rs;
	Statement st;
	
	//驱动连接
	public void init(String sql){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:Database","","");
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//执行查询
	public void query(String sql){
		try{
			rs=st.executeQuery(sql);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//刷新
	public void update(String sql) throws Exception {
		int n = st.executeUpdate(sql);
	}
	
	//关闭
	public void close(){
		try{
			rs.close();
			st.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
