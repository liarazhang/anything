import java.awt.Dimension;
import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

//panel3 销售情况
public class pan3 extends JFrame{
	public static JTable table= null;
    public static DefaultTableModel defaultTableModel3 = new DefaultTableModel();
	public static JScrollPane scro2=null ;
	
	public pan3() throws ClassNotFoundException, SQLException {
		//读取销售情况
		
		//权限设置
    	SqlOperation conn = new SqlOperation();
    	String sql = "select * from user where id = " + Login.name_in.getText();
    	try {
    		conn.operation(sql, 1);
    		while(conn.result2.next()) {
    			if(conn.result2.getString("authority").equals("admin")) {
    				System.out.println("authority");
    				//下面一步中，在内部类中引用外部类的对象必须是final，
    				//设成final后又不能赋值了。
    				SqlOperation conn1 = new SqlOperation();
    				String sql1 = "select * from salecondition";
    				conn1.operation(sql1, 1);
    				defaultTableModel3.setColumnIdentifiers(new Object[]{"日期", "产品", "客户", "负责人id", "销量","单位", "单价" });
    		        while(conn1.result2.next()) {
    		        	String getyear = conn1.result2.getString("year");
    		        	String getmonth = conn1.result2.getString("month");
    		        	String getday = conn1.result2.getString("day");
    		        	String getdate = getyear+"-"+getmonth+"-"+getday;
    					String getgoods = conn1.result2.getString("goods");
    					String getcus = conn1.result2.getString("customer");
    					String getname = conn1.result2.getString("id");
    					String getcount = conn1.result2.getString("count");
    					String getunit = conn1.result2.getString("unit");
    					String getprice = conn1.result2.getString("price");
    					defaultTableModel3.addRow(new Object[] {getdate,getgoods,getcus,getname,getcount,getunit,getprice});
    				}
    				conn1.statement.close();
    				conn1.connection.close(); 
    				//fra.setVisible(true);
    				break;
    			}
    			else {
    				System.out.println("authority");
    				//下面一步中，在内部类中引用外部类的对象必须是final，
    				//设成final后又不能赋值了。
    				SqlOperation conn1 = new SqlOperation();
    				String sql1 = "select * from salecondition where id = " + Login.name_in.getText();
    				conn1.operation(sql1, 1);
    				defaultTableModel3.setColumnIdentifiers(new Object[]{"日期", "产品", "客户", "负责人id", "销量","单位", "单价" });
    		        while(conn1.result2.next()) {
    		        	String getyear = conn1.result2.getString("year");
    		        	String getmonth = conn1.result2.getString("month");
    		        	String getday = conn1.result2.getString("day");
    		        	String getdate = getyear+"-"+getmonth+"-"+getday;
    					String getgoods = conn1.result2.getString("goods");
    					String getcus = conn1.result2.getString("customer");
    					String getname = conn1.result2.getString("id");
    					String getcount = conn1.result2.getString("count");
    					String getunit = conn1.result2.getString("unit");
    					String getprice = conn1.result2.getString("price");
    					defaultTableModel3.addRow(new Object[] {getdate,getgoods,getcus,getname,getcount,getunit,getprice});
    				}
    				conn1.statement.close();
    				conn1.connection.close(); 
    				//fra.setVisible(true);
    				break;
    			}
    		}
    	} catch (ClassNotFoundException | SQLException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
		
		
//		SqlOperation conn1 = new SqlOperation();
//		String sql1 = "select * from salescondition";
//		conn1.operation(sql1, 1);
//		defaultTableModel3.setColumnIdentifiers(new Object[]{"日期", "产品", "客户", "负责人", "销量","单位", "单价" });
//        while(conn1.result2.next()) {
//        	String getyear = conn1.result2.getString("year");
//        	String getmonth = conn1.result2.getString("month");
//        	String getday = conn1.result2.getString("day");
//        	String getdate = getyear+"-"+getmonth+"-"+getday;
//			String getgoods = conn1.result2.getString("goods");
//			String getcus = conn1.result2.getString("customer");
//			String getname = conn1.result2.getString("name");
//			String getcount = conn1.result2.getString("count");
//			String getunit = conn1.result2.getString("unit");
//			String getprice = conn1.result2.getString("price");
//			defaultTableModel3.addRow(new Object[] {getdate,getgoods,getcus,getname,getcount,getunit,getprice});
//		}
//		conn1.statement.close();
//		conn1.connection.close(); 
//        
        table = new JTable(defaultTableModel3);// 创建表格组件
        JTableHeader head = table.getTableHeader(); // 创建表格标题对象
        head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头大小
        head.setFont(new Font("楷体", Font.PLAIN, 18));// 设置表格字体
        table.setRowHeight(18);// 设置表格行宽

         scro2 = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
}
}
