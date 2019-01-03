package Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Desp extends JFrame
{
		public Desp() 
		{
			setTitle("删除销售员");
	    	setSize(550, 350);
	    	setResizable(false);
			setLayout(null); 
			//
			JLabel dingdan_id = new JLabel("请输入要删除的销售员的编号:"); 
	        add(dingdan_id);
	        dingdan_id.setFont(new Font("宋体", Font.BOLD, 12));
	        dingdan_id.setBounds(80, 48, 180, 20);
	        JTextField jTextField1 = new JTextField();
	        add(jTextField1); 
	        jTextField1.setBounds(265, 50, 120, 20);
	        //
	        JTextArea ta = new JTextArea("",5,5);
	        add(ta);
	        JScrollPane sa = new JScrollPane(ta);
	        add(sa);
	        sa.setBounds(100, 150, 300, 150);
	        //
	        JButton jb1 = new JButton("删除销售员");
	        add(jb1);
	        jb1.setBounds(200, 80, 100, 30);
	        //返回按钮
	        JButton jb2 = new JButton("返回");
	        add(jb2);
	        jb2.setBounds(350, 80, 100, 30);
	        //
	        JButton jb3 = new JButton("查找 ");
	        add(jb3);
	        jb3.setBounds(50, 80, 100, 30);
	        //
			setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//
			//删除销售单按钮功能
			jb1.addActionListener(new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent e)
	        	{
	    			JOptionPane.showMessageDialog(null, "删除销售员成功！", " ",2 );
	        	}
	        }
	        );
			//返回按钮功能
			jb2.addActionListener(new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		setVisible(false);
	        	}
	        }
	        );
		}
		//背景图片设置
		public void background()
		 {
		        	ImageIcon img = new ImageIcon("background.jpg");
		        	JLabel bg = new JLabel(img);
		        	bg.setBounds(0,0,550,350);
		        	this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
		        	((JPanel)this.getContentPane()).setOpaque(false);
		 } 
		
		public static void main(String[] args) 
		{
			 new Desp().background();
		}
	}

