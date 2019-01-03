import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import javafx.beans.value.ChangeListener;


//panel1 设置
public class pan1 {
	public static JTabbedPane jtp;
	public JScrollPane jn=null ;
	public static String rid = null;
	JTable table2 = new JTable();
	public int focusedRowIndex ;
	public pan1() throws ClassNotFoundException, SQLException {
		jtp = new JTabbedPane();
		JPanel pann1 = new JPanel();
		JPanel pann2 = new JPanel();
		jtp.add("读取信息", pann1);
		jtp.add("员工信息", pann2);
		jtp.setFont(new Font("微软雅黑", Font.ITALIC, 18));
		jtp.setSelectedIndex(0);

		rid = Login.name_in.getText();
		System.out.println(rid);
		String sql1 = "select * from user where id = " + rid;	
		
		SqlOperation con1 = new SqlOperation();
		con1.operation(sql1, 1);
		JLabel lab1 = new JLabel("姓名：" );
		//读取本人姓名
		JTextField name = null;
		while(con1.result2.next()){
			name = new JTextField(con1.result2.getString("name"));
		}
		name.setEditable(false); 
		con1.statement.close();
		con1.connection.close();
		
		SqlOperation con2 = new SqlOperation();
		con2.operation(sql1, 1);
		JLabel lab4 = new JLabel("英文名：");
		//读取英文名
		JTextField name2 = null;
		while(con2.result2.next()){
			name2 = new JTextField(con2.result2.getString("ename"));
		}
		name2.setEditable(false) ;
		con2.statement.close();
		con2.connection.close();
		
		SqlOperation con3 = new SqlOperation();
		con3.operation(sql1, 1);
		JLabel lab2 = new JLabel("性别：");
		//读取性别
		JTextField name3 = null;
		while(con3.result2.next()){
			name3 = new JTextField(con3.result2.getString("sexual"));
		}
		name3.setEditable(false) ;
		con3.statement.close();
		con3.connection.close();
		
		SqlOperation con4 = new SqlOperation();
		con4.operation(sql1, 1);
		JLabel lab3 = new JLabel("证件号码：" );
		//读取证件号码
		JTextField name4 = null;
		while(con4.result2.next()){
			name4 = new JTextField(con4.result2.getString("id"));
		}
		name4.setEditable(false) ;
		con4.statement.close();
		con4.connection.close();
		
		SqlOperation con5 = new SqlOperation();
		con5.operation(sql1, 1);
		JLabel lab5 = new JLabel("职务：" );
		//读取职务
		JTextField name5 = null;
		while(con5.result2.next()){
			name5 = new JTextField(con5.result2.getString("job"));
		}
		name5.setEditable(false) ;
		con5.statement.close();
		con5.connection.close();
		
		SqlOperation con6 = new SqlOperation();
		con6.operation(sql1, 1);
		JLabel lab6 = new JLabel("联系方式：" );
		//读取联系方式
		JTextField name6 = null;
		while(con6.result2.next()){
			name6 = new JTextField(con6.result2.getString("telenum"));
		}
		name6.setEditable(false) ;
		con6.statement.close();
		con6.connection.close();
		
		SqlOperation con7 = new SqlOperation();
		con7.operation(sql1, 1);
		JLabel lab7 = new JLabel();
		//读取照片
		URL ur = null;
		while(con7.result2.next()){
			ur = Thread.currentThread().getContextClassLoader().getResource(con7.result2.getString("foto"));
			System.out.println(con7.result2.getString("foto"));
		}
		Icon icon = new ImageIcon(ur);
		lab7.setIcon(icon);
		con7.statement.close();
		con7.connection.close();
		
		lab1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		name.setFont(new Font("微软雅黑", Font.BOLD, 20));
		name2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		name3.setFont(new Font("微软雅黑", Font.BOLD, 20));
		name4.setFont(new Font("微软雅黑", Font.BOLD, 20));
		name5.setFont(new Font("微软雅黑", Font.BOLD, 20));
		name6.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lab1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lab2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lab3.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lab4.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lab5.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lab6.setFont(new Font("微软雅黑", Font.BOLD, 20));
		pann1.setLayout(null);
		lab1.setBounds(50, 50, 100, 20);
		name.setBounds(150, 45, 200, 30);
		lab2.setBounds(50, 100, 500, 20);
		name3.setBounds(150, 95, 200, 30);
		lab3.setBounds(50, 150, 500, 20);
		name4.setBounds(150,145, 200, 30);
		lab4.setBounds(50, 200, 500, 20);
		name2.setBounds(150, 195,200, 30);
		lab5.setBounds(50, 250, 500, 20);
		name5.setBounds(150, 245,200, 30);
		lab6.setBounds(50, 300, 500, 20);
		name6.setBounds(150, 295,200, 30);
		lab7.setBounds(500, 0, 300,300);//调
	    pann1.add(lab1);
	    pann1.add(lab4);
	    pann1.add(lab2);
	    pann1.add(lab3);
	    pann1.add(lab5);
	    pann1.add(lab6);
	    pann1.add(lab7);
	    pann1.add(name);
		pann1.add(name2);
		pann1.add(name3);
		pann1.add(name4);
		pann1.add(name5);
		pann1.add(name6);
	    
	    JToolBar2();
	    pann2.setLayout(new BorderLayout());
	    pann2.add(jn);   
	    
	   

	}
	
	//员工信息
	    public void JToolBar2() throws ClassNotFoundException, SQLException{
	    	
	    	String sql = "select * from user";
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
				info[count][0] = conn1.result2.getString("id");
				info[count][1] = conn1.result2.getString("name");
				info[count][2] = "";
				count++;
			}
			System.out.println(count);
			String[] title = {"编号", "员工姓名", "查看"};
	    	
			JTable table2 = new JTable(info,title);// 创建表格组件
	        JTableHeader head = table2.getTableHeader(); // 创建表格标题对象
	        head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头大小
	        head.setFont(new Font("楷体", Font.PLAIN, 18));// 设置表格字体
	        table2.setRowHeight(18);// 设置表格行宽
	        table2.setRowHeight(35);
	        jn = new JScrollPane(table2);
	        
	    	JTextField pname = new JTextField();
    		JTextField pname2 = new JTextField();
    		JTextField pname3 = new JTextField();
    		JTextField pname4 = new JTextField();
    		JTextField pname5 = new JTextField();
    		JTextField pname6 = new JTextField();
	        table2.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	 
	            	if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
	                    //通过点击位置找到点击为表格中的行
	                    focusedRowIndex = table2.rowAtPoint(evt.getPoint());
	                    if (focusedRowIndex == -1) {
	                        return;
	                    }
	                    //将表格所选项设为当前右键点击的行
	                    table2.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
	                    //弹出菜
	                    JFrame frame = new JFrame();
	            		frame.setResizable(false);
	            		
	            		String this_row_id = (String) table2.getValueAt(focusedRowIndex, 0);
	            		System.out.println(this_row_id);
	            		String sql = "select * from user where id = " + this_row_id;
	            		JLabel lab1 = new JLabel("姓名：" );
	            		JLabel lab2 = new JLabel("性别：" );
	            		JLabel lab3 = new JLabel("证件号码：" );
	            		JLabel lab4 = new JLabel("英文名：" );
	            		JLabel lab5 = new JLabel("职务：" );
	            		JLabel lab6 = new JLabel("联系方式：" );
	            		JLabel lab7 = new JLabel();
	            		try {	
	            			//姓名
	            			SqlOperation conn1 = new SqlOperation();
	            			conn1.operation(sql, 1);
	            			while(conn1.result2.next()) {
	            				pname.setText(conn1.result2.getString("name"));
	            			}
	            			conn1.statement.close();
//	            			conn1.connection.close();
	            			pname.setEditable(false);
	            			
	            			//性别
//	            			SqlOperation conn2 = new SqlOperation();
	            			conn1.operation(sql, 1);
	            			while(conn1.result2.next()) {
	            				pname2.setText(conn1.result2.getString("ename"));
	            			}
	            			conn1.statement.close();
//	            			conn2.connection.close();
	            			pname2.setEditable(false);
	            			
	            			//证件号码
//	            			SqlOperation conn3 = new SqlOperation();
	            			conn1.operation(sql, 1);
	            			while(conn1.result2.next()) {
	            				pname3.setText(conn1.result2.getString("sexual"));
	            			}
	            			conn1.statement.close();
//	            			conn3.connection.close();
	            			pname3.setEditable(false);
	            			
	            			//英文名
//	            			SqlOperation conn4 = new SqlOperation();
	            			conn1.operation(sql, 1);
	            			while(conn1.result2.next()) {
	            				pname4.setText(conn1.result2.getString("id"));
	            			}
	            			conn1.statement.close();
//	            			conn4.connection.close();
	            			pname4.setEditable(false);
	            			
	            			//职务
//	            			SqlOperation conn5 = new SqlOperation();
	            			conn1.operation(sql, 1);
	            			while(conn1.result2.next()) {
	            				pname5.setText(conn1.result2.getString("job"));
	            			}
	            			conn1.statement.close();
//	            			conn5.connection.close();
	            			pname5.setEditable(false);
	            			
	            			//联系方式
//	            			SqlOperation conn6 = new SqlOperation();
	            			conn1.operation(sql, 1);
	            			while(conn1.result2.next()) {
	            				pname6.setText(conn1.result2.getString("telenum"));
	            			}
	            			conn1.statement.close();
//	            			conn6.connection.close();
	            			pname6.setEditable(false);
	            			
	            			//照片
//	            			SqlOperation conn7 = new SqlOperation();
	            			conn1.operation(sql, 1);
	            			Icon icon = null;
	            			while(conn1.result2.next()) {
	            				URL ur = Thread.currentThread().getContextClassLoader().getResource(conn1.result2.getString("foto"));
	            				icon = new ImageIcon(ur);
	            			}
	            			conn1.statement.close();
	            			conn1.connection.close();
	            			lab7.setIcon(icon);			
	            			
	            		}catch (ClassNotFoundException e1) {
	            			// TODO Auto-generated catch block
	            			e1.printStackTrace();
	            		}catch (SQLException e1) {
	            			// TODO Auto-generated catch block
	            			e1.printStackTrace();
	            		}
	            		
	            		JButton xg = new JButton("修改");
	            		JButton xg1 = new JButton("保存");
	            		
	            		xg.addActionListener(new ActionListener() {
	                    	public void actionPerformed(ActionEvent e) {
	                    		pname.setEditable(true); 
	                    		pname5.setEditable(true); 
	                    		pname2.setEditable(true); 
	                    		pname3.setEditable(true); 
	                    		pname4.setEditable(false); 
	                    		pname6.setEditable(true); 
	                    	}
	                    	});
	                    	
	            		//保存
	            		xg1.addActionListener(new ActionListener() {
	                    	public void actionPerformed(ActionEvent e) {
	                    		pname.setEditable(false); 
	                    		pname5.setEditable(false); 
	                    		pname2.setEditable(false); 
	                    		pname3.setEditable(false); 
	                    		pname4.setEditable(false); 
	                    		pname6.setEditable(false); 

//	                    		String sql1 = "delete from user where id = " + pname4.getText();
	                    		String sql2 = "update user set name = \"" + pname.getText() + "\" , ename = \"" +pname2.getText()+"\" , sexual = \""+pname3.getText()+"\" ,"
	                    				+ "job = \""+pname5.getText()+"\" , telenum = \""+pname6.getText()+"\" where id = \""  + pname4.getText()+"\"";;
	            				SqlOperation conn2 = new SqlOperation();
	            				try {
//									conn2.operation(sql1, 0);
//									int i = conn2.result1;
//									System.out.println("delete"+i);
//									conn2.statement.close();
									conn2.operation(sql2, 0);
									int j = conn2.result1;
									System.out.println("insert"+j);
									conn2.statement.close();
									conn2.connection.close();
									if(j==1) {
										JOptionPane.showMessageDialog(jtp, "修改成功");
									}else {
										JOptionPane.showMessageDialog(jtp, "fail!");
									}
									
									
								} catch (ClassNotFoundException | SQLException e1) {
									e1.printStackTrace();
								}
	            				
	                    	}
	                    	});
	            		
	            		frame.setLayout(null);
	            		lab1.setBounds(20, 30, 100, 20);
	            		pname.setBounds(60, 30, 100, 20);
	            		lab2.setBounds(20, 80, 500, 20);
	            		pname3.setBounds(60, 80, 100, 20);
	            		lab3.setBounds(20, 130, 500, 20);
	            		pname4.setBounds(80, 130, 100, 20);
	            		lab4.setBounds(20, 180, 500, 20);
	            		pname2.setBounds(70, 180, 100, 20);
	            		lab5.setBounds(20, 230, 500, 20);
	            		pname5.setBounds(60, 230, 100, 20);
	            		lab6.setBounds(20, 280, 500, 20);
	            		pname6.setBounds(80, 280, 200, 20);
	            		lab7.setBounds(250, 10, 300,200);
	            		xg.setBounds(120, 310, 60,30);
	            		xg1.setBounds(210, 310, 60,30);
	            		frame.add(lab1);
	            		frame.add(lab2);
	            		frame.add(lab3);
	            		frame.add(lab4);
	            		frame.add(lab5);
	            		frame.add(lab6);
	            		frame.add(lab7);
	            		frame.add(xg);
	            		frame.add(xg1);
	            		frame.add(pname);
	            		frame.add(pname2);
	            		frame.add(pname3);
	            		frame.add(pname4);
	            		frame.add(pname5);
	            		frame.add(pname6);
	            		frame.setTitle("员工信息");
	            		frame.setSize(400, 400);
	            		frame.setLocation(500, 200);
	            		frame.setVisible(true);
	            		
	                    System.out.println( table2.getModel().getValueAt(focusedRowIndex, 0) );
	            		
	                    
	                }

	            }
	});

	    }

}
