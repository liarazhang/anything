import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class pan5 extends JFrame implements ActionListener{
	public static JButton button, button1, button2 = null;
	public pan5() {
		URL url = Thread.currentThread().getContextClassLoader().getResource("8.jpg");
		URL url1 = Thread.currentThread().getContextClassLoader().getResource("9.jpg");
		URL url2 = Thread.currentThread().getContextClassLoader().getResource("10.jpg");
		button = new JButton(new ImageIcon(url));
		button1 = new JButton(new ImageIcon(url1));
		button2 = new JButton(new ImageIcon(url2));
		button.setBackground(Color.WHITE);
		button1.setBackground(Color.WHITE);
		button2.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = 1;
				SqlOperation conn = new SqlOperation();
            	String rid = Login.name_in.getText();
            	String sql = "select * from user where id = " + rid;
            	try {
            		conn.operation(sql, 1);
            		while(conn.result2.next()) {
            			if(conn.result2.getString("authority").equals("other")) {
            				i = 0;
            				System.out.println("authority");
            				JFrame fra = new JFrame();
            				JOptionPane.showMessageDialog(fra, "需要管理员权限");
            				break;
            			}
            		}
            	} catch (ClassNotFoundException | SQLException e1) {
            		e1.printStackTrace();
            	}
            	if(i==1) {
					JFrame fra = new JFrame();
					JOptionPane.showMessageDialog(fra, "下载成功！");
					try {
						excel ex1 = new excel();
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
            	}
			}
		});
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 1;
				SqlOperation conn = new SqlOperation();
            	String rid = Login.name_in.getText();
            	String sql = "select * from user where id = " + rid;
            	try {
            		conn.operation(sql, 1);
            		while(conn.result2.next()) {
            			if(conn.result2.getString("authority").equals("other")) {
            				i = 0;
            				System.out.println("authority");
            				JFrame fra = new JFrame();
            				JOptionPane.showMessageDialog(fra, "需要管理员权限");
            				break;
            			}
            		}
            	} catch (ClassNotFoundException | SQLException e1) {
            		e1.printStackTrace();
            	}
            	if(i==1) {
					JFrame fra = new JFrame();
					JOptionPane.showMessageDialog(fra, "下载成功！");
					try {
						excel2 ex2 = new excel2();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
            	}
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 1;
				SqlOperation conn = new SqlOperation();
            	String rid = Login.name_in.getText();
            	String sql = "select * from user where id = " + rid;
            	try {
            		conn.operation(sql, 1);
            		while(conn.result2.next()) {
            			if(conn.result2.getString("authority").equals("other")) {
            				i = 0;
            				System.out.println("authority");
            				JFrame fra = new JFrame();
            				JOptionPane.showMessageDialog(fra, "需要管理员权限");
            				break;
            			}
            		}
            	} catch (ClassNotFoundException | SQLException e1) {
            		e1.printStackTrace();
            	}
            	if(i==1) {
					JFrame fra = new JFrame();
					JOptionPane.showMessageDialog(fra, "下载成功！");
					try {
						excel3 ex3 = new excel3();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
            	}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFrame fra = new JFrame();
		fra.setTitle("下载进度");
		fra.setSize(400, 400);
		fra.setLocation(500, 200);
		fra.setVisible(true);	
	}
}
