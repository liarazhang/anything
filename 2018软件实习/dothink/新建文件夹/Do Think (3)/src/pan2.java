import java.awt.Dimension;
import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

//panel2 客户管理
public class pan2 {
	public static JTable tab=null ;
	public static DefaultTableModel defaultTableModel2 = new DefaultTableModel();
	public static JScrollPane scro3=null ;
	public pan2() throws ClassNotFoundException, SQLException {
		//显示所有客户信息
		SqlOperation conn = new SqlOperation();
		String sql = "select * from customer";
		conn.operation(sql, 1); 
		defaultTableModel2.setColumnIdentifiers(new Object[]{"日期","公司名称","联系人","联系方式","负责人" });
		while(conn.result2.next()) {
			String getyear = conn.result2.getString("year");
        	String getmonth = conn.result2.getString("month");
        	String getday = conn.result2.getString("day");
        	String getdate = getyear+"-"+getmonth+"-"+getday;
			String getcus = conn.result2.getString("customerinfo");
			String getcontact = conn.result2.getString("contact");
			String getcontactinfo = conn.result2.getString("contactway");
			String getname = conn.result2.getString("name");
			defaultTableModel2.addRow(new Object[] {getdate,getcus,getcontact,getcontactinfo,getname});
		}
		conn.statement.close();
		conn.connection.close();       
		
        tab = new JTable(defaultTableModel2);// 创建表格组件
        JTableHeader head = tab.getTableHeader(); // 创建表格标题对象
        head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头大小
        head.setFont(new Font("楷体", Font.PLAIN, 18));// 设置表格字体
        tab.setRowHeight(18);// 设置表格行宽

        scro3 = new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
}
}
