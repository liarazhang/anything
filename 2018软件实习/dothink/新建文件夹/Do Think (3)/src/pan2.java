import java.awt.Dimension;
import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

//panel2 �ͻ�����
public class pan2 {
	public static JTable tab=null ;
	public static DefaultTableModel defaultTableModel2 = new DefaultTableModel();
	public static JScrollPane scro3=null ;
	public pan2() throws ClassNotFoundException, SQLException {
		//��ʾ���пͻ���Ϣ
		SqlOperation conn = new SqlOperation();
		String sql = "select * from customer";
		conn.operation(sql, 1); 
		defaultTableModel2.setColumnIdentifiers(new Object[]{"����","��˾����","��ϵ��","��ϵ��ʽ","������" });
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
		
        tab = new JTable(defaultTableModel2);// ����������
        JTableHeader head = tab.getTableHeader(); // �������������
        head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
        head.setFont(new Font("����", Font.PLAIN, 18));// ���ñ������
        tab.setRowHeight(18);// ���ñ���п�

        scro3 = new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
}
}
