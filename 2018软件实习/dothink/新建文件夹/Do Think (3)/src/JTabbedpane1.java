import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class JTabbedpane1 extends JFrame implements ActionListener{
	public JTabbedpane1() throws ClassNotFoundException, SQLException {
		JTabbedPane tab = new JTabbedPane();
		JFrame frame = new JFrame();
		
		frame.setSize(1000, 750);
		frame.setLocation(200,20);
		frame.setTitle("��ҵ���۹���ϵͳ");
		frame.setResizable(true);
		frame.setBackground(Color.WHITE);
		//frame.setLayout(null);
		
		JToolBar bar = new JToolBar();
		JLabel label2 = new JLabel();
		URL url = Thread.currentThread().getContextClassLoader().getResource("6.png");
		URL url1 = Thread.currentThread().getContextClassLoader().getResource("7.png");
		label2.setIcon(new ImageIcon(url1));
		
		//ע��
		JButton menu = new JButton(new ImageIcon(url));
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login();
			}
			});
		bar.setBackground(new Color(232, 233, 234));
		bar.add(label2);
		
		JToolBar bar1 = new JToolBar();
		bar1.add(menu);
		
		tab.setTabPlacement(JTabbedPane.LEFT);
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		//ָ��ͼ��
		URL iconURL1 = loader.getResource("1.jpg");
		URL iconURL2 = loader.getResource("2.jpg");
		URL iconURL3 = loader.getResource("3.jpg");
		URL iconURL4 = loader.getResource("4.jpg");
		URL iconURL5 = loader.getResource("5.jpg");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel(new BorderLayout());
		JPanel panel5 = new JPanel();
		panel1.setBackground(new Color(204, 204, 255));
		panel2.setBackground(new Color(204, 204, 255));
		panel3.setBackground(new Color(204, 204, 255));
		panel4.setBackground(new Color(204, 204, 255));
		panel5.setBackground(new Color(204, 204, 255));
		tab.addTab("                    ����", new ImageIcon(iconURL1), panel1);
		tab.addTab("             �ͻ�����",new ImageIcon(iconURL2),panel2);
		tab.addTab("             �������",new ImageIcon(iconURL3), panel3);
		tab.addTab("             ��������", new ImageIcon(iconURL4),panel4);
		tab.addTab("             ���۱���", new ImageIcon(iconURL5),panel5);
		tab.setFont(new Font("΢���ź�", Font.ITALIC, 20));
		tab.setSelectedIndex(0);
		
		
		//report
		//
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JTabbedPane tab1 = new JTabbedPane();
		tab1.setTabPlacement(JTabbedPane.SCROLL_TAB_LAYOUT);
		tab1.addTab("׫д����", panel6);
		tab1.addTab("��ȡ����", panel7);
		tab1.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
            	JTabbedPane tabbedPane = (JTabbedPane)e.getSource();
            	int selectedIndex = tabbedPane.getSelectedIndex();
            	//Ȩ������
            	SqlOperation conn = new SqlOperation();
            	String rid = Login.name_in.getText();
            	String sql = "select * from user where id = " + rid;
            	try {
            		conn.operation(sql, 1);
            		while(conn.result2.next()) {
            			if(selectedIndex==1&&conn.result2.getString("authority").equals("other")) {
            				System.out.println("authority");
            				//����һ���У����ڲ����������ⲿ��Ķ��������final��
            				//���final���ֲ��ܸ�ֵ�ˡ�
            				JFrame fra = new JFrame();
            				JOptionPane.showMessageDialog(fra, "��Ҫ����ԱȨ��", "����", selectedIndex);
            				tab1.setSelectedIndex(0);
            				//fra.setVisible(true);
            				break;
            			}
            		}
            	} catch (ClassNotFoundException | SQLException e1) {
            		// TODO Auto-generated catch block
            		e1.printStackTrace();
            	}
            }
         });
		tab1.setFont(new Font("΢���ź�", Font.ITALIC, 18));
		panel4.add(tab1);
		tab1.setSelectedIndex(0);
		
		
		//д������ 
		panel6.setLayout(null);
		JLabel label3 = new JLabel("����:");
		JLabel label4 = new JLabel("��");
		JLabel label5 = new JLabel("��");
		JLabel label6 = new JLabel("��");
		JLabel label7 = new JLabel("�����������ģ�");
		label3.setFont(new Font("΢���ź�", Font.BOLD, 17));
		label4.setFont(new Font("΢���ź�", Font.BOLD, 17));
		label5.setFont(new Font("΢���ź�", Font.BOLD, 17));
		label6.setFont(new Font("΢���ź�", Font.BOLD, 17));
		label7.setFont(new Font("΢���ź�", Font.BOLD, 17));
		label3.setBounds(200, 50, 60, 25);
		label4.setBounds(320, 50, 60, 25);
		label5.setBounds(390, 50, 60, 25);
		label6.setBounds(460, 50, 60, 25);
		label7.setBounds(20, 90,200, 25);
		JTextField txtn = new JTextField();
		JTextField txty = new JTextField();
		JTextField txtr = new JTextField();
		JTextArea txtb = new JTextArea();
		JScrollPane scro = new JScrollPane(txtb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scro.setBounds(20, 120, 680, 320);
		txtn.setBounds(250, 55, 60, 20);
		txty.setBounds(350, 55, 30, 20);
		txtr.setBounds(420, 55, 30, 20);
		JButton button2 = new JButton("�ύ");
		button2.setBounds(600, 445, 100, 35);
		button2.setFont(new Font("΢���ź�", Font.BOLD, 17));
		panel6.add(label3);
		panel6.add(label4);
		panel6.add(label5);
		panel6.add(label6);
		panel6.add(label7);
		panel6.add(txtn);
		panel6.add(txty);
		panel6.add(txtr);
		panel6.add(scro);
		panel6.add(button2);
		
		//�ϴ��ձ�
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gettext = txtb.getText();
				String year = txtn.getText();
				String month = txty.getText();
				String day = txtr.getText();
				String gname = new String();
				System.out.println(pan1.rid);
				String sql0 = "select * from user where id = " + pan1.rid;
				try {
					System.out.println("report");
					SqlOperation conn0 = new SqlOperation();
					conn0.operation(sql0, 1);
					while(conn0.result2.next()) {
						gname = conn0.result2.getString("name");
						System.out.println(gname);
					}
					conn0.statement.close();
					conn0.connection.close();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
						
					System.out.println(gettext+"  "+year+"  "+month+"  "+day+"  "+pan1.rid+"  "+gname);
					if(gettext.equals("")||year.equals("")||month.equals("")||day.equals("")) {
						JOptionPane.showMessageDialog(panel6, "����д����"); 
					}
					else {
						String sql1 = "insert into report (year,month,day,text,name,id) values (\""+year+"\",\""+month+"\",\""+day+"\",\""+gettext+"\",\""+gname+"\",\""+pan1.rid+"\")";
						try {
							SqlOperation conn = new SqlOperation();
							conn.operation(sql1, 0);
							System.out.print(conn.result1);
							conn.statement.close();
						    conn.connection.close();
						    JOptionPane.showMessageDialog(panel6, "�ϴ��ɹ�"); 
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		
		
		
		
		//�������
		//
		new JToolBar1();
		panel7.setLayout(new BorderLayout());
		panel7.add(JToolBar1.js);
		
		panel5.setLayout(null);
		new pan5();
		pan5.button.setBounds(50, 80, 200, 200);
		pan5.button1.setBounds(260, 80, 200, 200);
		pan5.button2.setBounds(470, 80, 200, 200);
		panel5.add(pan5.button);
		panel5.add(pan5.button1);
		panel5.add(pan5.button2);
		
		panel3.setLayout(null);
		JButton but1 = new JButton("���");
		JButton but2 = new JButton("�ϴ�");
		JButton but3 = new JButton("ˢ��");
		new pan3();
		pan3.scro2.setBounds(0, 0, 730, 500);
		but1.setBounds(80, 520, 60, 30);
		but2.setBounds(600, 520, 60, 30);
		but3.setBounds(160, 520, 60, 30);
		panel3.add(but1);
		panel3.add(but2);
		panel3.add(but3);
		panel3.add(pan3.scro2);
		
		//���n2
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pan3.defaultTableModel3.setRowCount(0);
			}
		});
		
		//��ȡn2,�ϴ�
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame fra = new JFrame();
				TableColumn column;
				String[] n1 = { "", "", "", "", "", "", "", "", ""};
		        Object[][] p = { n1 };
		        String[] n = {"��","��","��","��Ʒ","�ͻ�","������","����","��λ","����"}; 
		        
		        DefaultTableModel defaultTableModel = new DefaultTableModel(p, n); // ��˫���鴴��DefaultTableModel����
		        JTable tab = new JTable(defaultTableModel);// ����������
		        JTableHeader head = tab.getTableHeader(); // �������������
		        head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
		        head.setFont(new Font("����", Font.PLAIN, 18));// ���ñ������
		        tab.setRowHeight(20);// ���ñ���п�
		        
		        tab.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// �������ñ���п�
		        for (int i = 0; i < 5; i++) {
		            column = tab.getColumnModel().getColumn(i);
		            if (i == 0) {
		                column.setPreferredWidth(50);
		            }
		        }
		        JScrollPane scr4 = new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		        
		        JButton ton = new JButton("ȷ��");
		        ton.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		int i =0;
		        		while (i<=8) {
		        			n1[i]=(String) tab.getValueAt(0, i);
		        			i++;
		        		}
		        		String gyear = n1[0];
		        		String gmonth = n1[1];
		        		String gday = n1[2];
		        		String ggoods = n1[3];
		        		String gcus = n1[4];
		        		String gname = n1[5];
		        		String gcount = n1[6];
		        		String gunit = n1[7];
		        		String gprice = n1[8];
		        		System.out.println(gyear);
						String sql1 = "insert into salecondition (year,month,day,goods,customer,id,count,unit,price) "
								+ "values (\""+gyear+"\",\""+gmonth+"\",\""+gday+"\",\""+ggoods+"\",\""+gcus+"\",\""+gname+"\",\""+gcount+"\",\""+gunit+"\",\""+gprice+"\")";
						int j = 0;
						try {
							SqlOperation conn = new SqlOperation();
							conn.operation(sql1, 0);
							j = conn.result1;
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
		        		if (j==1) {
		        		JOptionPane.showMessageDialog(null, "��ӿͻ���Ϣ�ɹ���", " ",2 );
		        		fra.dispose();
		        		}
		        	}
		        });
		        fra.setLayout(null);
		        scr4.setBounds(0, 0, 800, 100);
		        ton.setBounds(360, 60, 60, 30);
		        fra.add(ton);
		        fra.add(scr4);
				fra.setTitle("��ӿͻ�");
				fra.setSize(800, 130);
				fra.setLocation(300, 200);
				fra.setVisible(true);
			}
		});
				
		//ˢ�����
		but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pan3.defaultTableModel3.setRowCount(0);
				//Ȩ������
		    	SqlOperation conn = new SqlOperation();
		    	String sql = "select * from user where id = " + Login.name_in.getText();
		    	try {
		    		conn.operation(sql, 1);
		    		while(conn.result2.next()) {
		    			if(conn.result2.getString("authority").equals("admin")) {
		    				System.out.println("authority");
		    				//����һ���У����ڲ����������ⲿ��Ķ��������final��
		    				//���final���ֲ��ܸ�ֵ�ˡ�
		    				SqlOperation conn1 = new SqlOperation();
		    				String sql1 = "select * from salecondition";
		    				conn1.operation(sql1, 1);
		    				pan3.defaultTableModel3.setColumnIdentifiers(new Object[]{"����", "��Ʒ", "�ͻ�", "������id", "����","��λ", "����" });
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
		    					pan3.defaultTableModel3.addRow(new Object[] {getdate,getgoods,getcus,getname,getcount,getunit,getprice});
		    				}
		    				conn1.statement.close();
		    				conn1.connection.close(); 
		    				//fra.setVisible(true);
		    				break;
		    			}
		    			else {
		    				System.out.println("authority");
		    				//����һ���У����ڲ����������ⲿ��Ķ��������final��
		    				//���final���ֲ��ܸ�ֵ�ˡ�
		    				SqlOperation conn1 = new SqlOperation();
		    				String sql1 = "select * from salecondition where id = " + Login.name_in.getText();
		    				conn1.operation(sql1, 1);
		    				pan3.defaultTableModel3.setColumnIdentifiers(new Object[]{"����", "��Ʒ", "�ͻ�", "������id", "����","��λ", "����" });
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
		    					pan3.defaultTableModel3.addRow(new Object[] {getdate,getgoods,getcus,getname,getcount,getunit,getprice});
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
			}
		});
		
		
		//�ͻ���Ϣ
		//
		new pan2();
		JButton bto1 = new JButton("���");
		JButton bto2 = new JButton("ˢ��");
		JButton bto3 = new JButton("����˾���Ƽ���");
		JTextField txtj = new JTextField();
		panel2.setLayout(null);
		txtj.setBounds(500, 20, 100, 30);
		bto1.setBounds(50, 20, 60, 30);
		bto2.setBounds(200, 20, 60, 30);
		bto3.setBounds(600, 20, 130, 30);
		pan2.scro3.setBounds(0, 70, 730, 500);
		panel2.add(txtj);
		panel2.add(bto1);
		panel2.add(bto2);
		panel2.add(bto3);
		panel2.add(pan2.scro3);

		//���
		bto1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame fra = new JFrame();
				TableColumn column;
				String[] n1 = { "", "", "", "", "", "", "", ""};
		        Object[][] p = { n1 };
		        String[] n = {"��","��","��","��˾����","��ϵ��","��ϵ��ʽ","������","֤����" };
		        fra.setResizable(false);
		     
		        
		        DefaultTableModel defaultTableModel = new DefaultTableModel(p, n); // ��˫���鴴��DefaultTableModel����
		        JTable tab = new JTable(defaultTableModel);// ����������
		        JTableHeader head = tab.getTableHeader(); // �������������
		        head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
		        head.setFont(new Font("����", Font.PLAIN, 18));// ���ñ������
		        tab.setRowHeight(20);// ���ñ���п�

		        tab.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// �������ñ���п�
		        for (int i = 0; i < 5; i++) {
		            column = tab.getColumnModel().getColumn(i);
		            if (i == 0) {
		                column.setPreferredWidth(50);
		            }
		        }
		        JScrollPane scr4 = new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		        
		        
		        JButton ton = new JButton("ȷ��");
		        ton.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		int j =0;
		        		while (j<=7) {
		        			n1[j]=(String) tab.getValueAt(0, j);
		        			j++;
		        		}
		        		String gyear = n1[0];
		        		String gmonth = n1[1];
		        		String gday = n1[2];
		        		String gcusinfo = n1[3];
		        		String gcontact = n1[4];
		        		String gway = n1[5];
		        		String gname = n1[6];
		        		String gid = n1[7];
		        		System.out.println(gyear+gmonth+gid);
		        		String sql = "insert into customer (year,month,day,customerinfo,contact,contactway,name,id) "
		        				+ "values (\""+gyear+"\",\""+gmonth+"\",\""+gday+"\",\""+gcusinfo+"\",\""+gcontact+"\",\""+gway+"\",\""+gname+"\",\""+gid+"\")";
						
		        		int i = 0;
		        		try {
		        			SqlOperation conn = new SqlOperation();
							conn.operation(sql, 0);
							i = conn.result1;
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        		
		        		if (i==1) {
		        			JOptionPane.showMessageDialog(null, "������۵��ɹ���", " ",2 );
		        			fra.dispose();
		        		}
		        	}
			});
		        fra.setLayout(null);
				scr4.setBounds(0, 0, 800, 100);
				ton.setBounds(360, 60, 60, 30);
				fra.add(ton);
				fra.add(scr4);
				fra.setTitle("��ӿͻ�");
				fra.setSize(800, 130);
				fra.setLocation(300, 200);
				fra.setVisible(true);
		        }
			});
		        
		        //ˢ��
		        bto2.addActionListener(new ActionListener() {  
		        	public void actionPerformed(ActionEvent e) {
		        		pan2.defaultTableModel2.setRowCount(0);
		        		SqlOperation conn = new SqlOperation();
		        		String sql = "select * from customer";
		        		try {
		        			conn.operation(sql, 1);
		        			pan2.defaultTableModel2.setColumnIdentifiers(new Object[]{"����","��˾����","��ϵ��","��ϵ��ʽ","������" });
		        			while(conn.result2.next()) {
							String getyear = conn.result2.getString("year");
				        	String getmonth = conn.result2.getString("month");
				        	String getday = conn.result2.getString("day");
				        	String getdate = getyear+"-"+getmonth+"-"+getday;
							String getcus = conn.result2.getString("customerinfo");
							String getcontact = conn.result2.getString("contact");
							String getcontactinfo = conn.result2.getString("contactway");
							String getname = conn.result2.getString("name");
							pan2.defaultTableModel2.addRow(new Object[] {getdate,getcus,getcontact,getcontactinfo,getname});
						}
						conn.statement.close();
						conn.connection.close();  
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}      
				        	}
				        });
			        
			    
			//����˾������
			bto3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("search");
					pan2.defaultTableModel2.setRowCount(0);
					System.out.println(txtj.getText());
					String sql = "select * from customer ";
					SqlOperation conn = new SqlOperation();
					try {
						conn.operation(sql, 1);
						String eee = null;
						while(conn.result2.next()) {
							 eee = conn.result2.getString("customerinfo");
							 System.out.print(eee);
							 if(eee.equals(txtj.getText())) {
								pan2.defaultTableModel2.setColumnIdentifiers(new Object[]{"����","��˾����","��ϵ��","��ϵ��ʽ","������" });
								String getyear = conn.result2.getString("year");
						        String getmonth = conn.result2.getString("month");
						        	String getday = conn.result2.getString("day");
						        	String getdate = getyear+"-"+getmonth+"-"+getday;
									String getcus = conn.result2.getString("customerinfo");
									String getcontact = conn.result2.getString("contact");
									String getcontactinfo = conn.result2.getString("contactway");
									String getname = conn.result2.getString("name");
									pan2.defaultTableModel2.addRow(new Object[] {getdate,getcus,getcontact,getcontactinfo,getname});
						}
					}	
					conn.statement.close();
					conn.connection.close();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}		
				}
			});
		    	
		
		new pan1();
		panel1.setLayout(new BorderLayout());
		pan1.jtp.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e){
	            	JTabbedPane tabbedPane = (JTabbedPane)e.getSource();
	            	int selectedIndex = tabbedPane.getSelectedIndex();
	            	//Ȩ������
	            	SqlOperation conn = new SqlOperation();
	            	String sql = "select * from user where id = " + pan1.rid;
	            	try {
	            		conn.operation(sql, 1);
	            		while(conn.result2.next()) {
	            			if(selectedIndex==1&&conn.result2.getString("authority").equals("other")) {
	            				System.out.println("authority");
	            				//����һ���У����ڲ����������ⲿ��Ķ��������final��
	            				//���final���ֲ��ܸ�ֵ�ˡ�
	            				JFrame fra = new JFrame();
	            				JOptionPane.showMessageDialog(fra, "��Ҫ����ԱȨ��", "����", selectedIndex);
	            				pan1.jtp.setSelectedIndex(0);
	            				//fra.setVisible(true);
	            				break;
	            			}
	            		}
	            	} catch (ClassNotFoundException | SQLException e1) {
	            		// TODO Auto-generated catch block
	            		e1.printStackTrace();
	            	}
	            }

			public void stateChanged1(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel1.add(pan1.jtp);
		frame.add(tab);
		frame.add(bar, BorderLayout.NORTH);
		frame.add(bar1, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

