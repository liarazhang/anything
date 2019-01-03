import java.awt.TextArea;
import java.sql.SQLException;

import javax.swing.*;

public class JToolBar1 extends JFrame{
	 
	  //  private static final long serialVersionUID = 1L;
	    private JTable table = null;
	    public static JScrollPane js=null ;
	    public JToolBar1() throws ClassNotFoundException, SQLException{
	    	String sql = "select * from report";
	    	SqlOperation conn = new SqlOperation();
	    	conn.operation(sql, 1);
	    	int count = 0;
	    	while(conn.result2.next()) {
	    		count++;
	    	}
	    	conn.statement.close();
			conn.connection.close();
			Object[][] info = new Object[count][4];
			count = 0;
			
			SqlOperation conn1 = new SqlOperation();
			conn1.operation(sql, 1);
			while(conn1.result2.next()) {
				String year = conn1.result2.getString("year");
				String month = conn1.result2.getString("month");
				String day = conn1.result2.getString("day");
				info[count][0] = year+"-"+month+"-"+day;
				info[count][1] = conn1.result2.getString("name");
				info[count][2] = conn1.result2.getString("id");;
				count++;
			}
			System.out.println(count);
	    	String[] title = {"日期", "员工姓名","id"};
	        table = new JTable(info, title);
	        table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	 int focusedRowIndex = 0;
	            	if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
	                    //通过点击位置找到点击为表格中的行
	                    focusedRowIndex = table.rowAtPoint(evt.getPoint());
	                    if (focusedRowIndex == -1) {
	                        return;
	                    }
	                    //将表格所选项设为当前右键点击的行
	                    table.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
	                    //弹出菜 
	                    JFrame fram = new JFrame();
		        		fram.setResizable(false);
		        		TextArea tx = new TextArea("");
		        		
	                    String this_row_id = (String) table.getValueAt(focusedRowIndex, 2);
	            		System.out.println(this_row_id);
	            		String sql = "select * from report where id = " + this_row_id;
	            		SqlOperation conn2 = new SqlOperation();
	            		try {
							conn2.operation(sql, 1);
							while(conn2.result2.next()) {
								tx.setText(conn2.result2.getString("year")+"-"+conn2.result2.getString("month")+"-"+conn2.result2.getString("day")
								+"\n"+conn2.result2.getString("text")+"\n");
							}
							conn2.statement.close();
							conn2.connection.close();
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
	            		
	            		
	            		
	                   
		        		JScrollPane je  = new JScrollPane(tx, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		        		fram.add(je);
		        		fram.setBounds(0, 0, 400,400);
		        		fram.setBounds(600, 200, 400, 400);
		        		fram.setVisible(true);
		        		fram.setResizable(false);
		        		//弹窗内容为最近日报和日期
		        		
	                    
	            	}
	            }
	        });
	        table.setRowHeight(35);
	        js = new JScrollPane(table);
	    }
	  
	
}
	

