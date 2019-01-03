package Face;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;





public class JTabbedpane1 extends JFrame implements ActionListener{
	public JTabbedpane1() {
		JTabbedPane tab = new JTabbedPane();
		JFrame frame = new JFrame();
		

		frame.setSize(1000, 750);
		frame.setLocation(200,20);
		frame.setTitle("企业销售管理系统");
		frame.setResizable(true);
		frame.setBackground(Color.WHITE);
		//frame.setLayout(null);
		
		
		JToolBar bar = new JToolBar();
		JLabel label2 = new JLabel();
		URL url = Thread.currentThread().getContextClassLoader().getResource("6.png");
		URL url1 = Thread.currentThread().getContextClassLoader().getResource("7.png");
		label2.setIcon(new ImageIcon(url1));
		JButton menu = new JButton(new ImageIcon(url));
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			});
		bar.setBackground(new Color(232, 233, 234));
		bar.add(label2);
		
		JToolBar bar1 = new JToolBar();
		bar1.add(menu);
		
		

		
		
		tab.setTabPlacement(JTabbedPane.LEFT);
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		//指定图标
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
		tab.addTab("                    设置", new ImageIcon(iconURL1), panel1);
		tab.addTab("             客户管理",new ImageIcon(iconURL2),panel2);
		tab.addTab("             销售情况",new ImageIcon(iconURL3), panel3);
		tab.addTab("             工作报告", new ImageIcon(iconURL4),panel4);
		tab.addTab("             销售报表", new ImageIcon(iconURL5),panel5);
		tab.setFont(new Font("微软雅黑", Font.ITALIC, 20));
		tab.setSelectedIndex(0);
		
		
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		final JTabbedPane tab1 = new JTabbedPane();
		tab1.setTabPlacement(JTabbedPane.SCROLL_TAB_LAYOUT);
		tab1.addTab("撰写报告", panel6);
		tab1.addTab("读取报告", panel7);
		tab1.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
            JTabbedPane tabbedPane = (JTabbedPane)e.getSource();
            int selectedIndex = tabbedPane.getSelectedIndex();
            if(selectedIndex==1) {
              //下面一步中，在内部类中引用外部类的对象必须是final，
                //设成final后又不能赋值了。
            	JFrame fra = new JFrame();
            	JOptionPane.showMessageDialog(fra, "需要管理员权限", "错误", selectedIndex);
            	tab1.setSelectedIndex(0);
			//fra.setVisible(true);
			}
            }
         });
		tab1.setFont(new Font("微软雅黑", Font.ITALIC, 18));
		panel4.add(tab1);
		tab1.setSelectedIndex(0);
		
		
		//写报告区 
		panel6.setLayout(null);
		JLabel label3 = new JLabel("日期:");
		JLabel label4 = new JLabel("年");
		JLabel label5 = new JLabel("月");
		JLabel label6 = new JLabel("日");
		JLabel label7 = new JLabel("工作报告正文：");
		label3.setFont(new Font("微软雅黑", Font.BOLD, 17));
		label4.setFont(new Font("微软雅黑", Font.BOLD, 17));
		label5.setFont(new Font("微软雅黑", Font.BOLD, 17));
		label6.setFont(new Font("微软雅黑", Font.BOLD, 17));
		label7.setFont(new Font("微软雅黑", Font.BOLD, 17));
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
		JButton button2 = new JButton("提交");
		button2.setBounds(600, 445, 100, 35);
		button2.setFont(new Font("微软雅黑", Font.BOLD, 17));
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
		JButton but = new JButton("清空");
		JButton but2 = new JButton("上传");
		new pan3();
		pan3.scro2.setBounds(0, 0, 730, 500);
		but.setBounds(80, 520, 60, 30);
		but2.setBounds(600, 520, 60, 30);
		panel3.add(but);
		panel3.add(but2);
		panel3.add(pan3.scro2);
		
		
		new pan2();
		JButton bto1 = new JButton("添加");
		JButton bto3 = new JButton("按公司名称检索");
		JTextField txtj = new JTextField();
		panel2.setLayout(null);
		txtj.setBounds(500, 20, 100, 30);
		bto1.setBounds(50, 20, 60, 30);
		bto3.setBounds(600, 20, 130, 30);
		pan2.scro3.setBounds(0, 70, 730, 500);
		panel2.add(txtj);
		panel2.add(bto1);
		panel2.add(bto3);
		panel2.add(pan2.scro3);
		bto1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFrame fra = new JFrame();
				TableColumn column;
				String[] n1 = { "", "", "", "",""};
		        Object[][] p = { n1 };
		        String[] n = {"日期","公司名称","联系人","联系方式","负责人" };

		        DefaultTableModel defaultTableModel = new DefaultTableModel(p, n); // 用双数组创建DefaultTableModel对象
		        JTable tab = new JTable(defaultTableModel);// 创建表格组件
		        JTableHeader head = tab.getTableHeader(); // 创建表格标题对象
		        head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头大小
		        head.setFont(new Font("楷体", Font.PLAIN, 18));// 设置表格字体
		        tab.setRowHeight(20);// 设置表格行宽

		        tab.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// 以下设置表格列宽
		        for (int i = 0; i < 5; i++) {
		            column = tab.getColumnModel().getColumn(i);
		            if (i == 0) {
		                column.setPreferredWidth(50);
		            }

			}
		        JScrollPane scr4 = new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		        
		        JButton ton = new JButton("确认");
		        ton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//数据添加到表中
				fra.dispose();
			}
			});
		        
		        fra.setLayout(null);
		        scr4.setBounds(0, 0, 800, 100);
		        ton.setBounds(360, 60, 60, 30);
		        fra.add(ton);
		        fra.add(scr4);
				fra.setTitle("添加客户");
				fra.setSize(800, 130);
				fra.setLocation(300, 200);
				fra.setVisible(true);
			}
		});
		
		
		new pan1();
		panel1.setLayout(new BorderLayout());
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


