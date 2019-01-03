package Login;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class About extends JFrame
{
	public About()
	{
		setTitle("关于");
    	setSize(500, 350);
    	setResizable(false);
		setLayout(null); 
		//
		JLabel jl = new JLabel("关于我们");
        add(jl);
        jl.setFont(new Font("仿宋", Font.BOLD, 17));
        jl.setBounds(210, 5, 100, 40);
        //
        JTextArea ta = new JTextArea("本系统由北京邮电大学自动化学院团队开发，" +
        "为非商业用途使用的内测版本。\n应用该系统实现如下功能："+"\n（1）销售员信息管理：\n"+
        "      包括销售员的查找、增加、删除等\n（2）销售单信息的管理：\n" +
        "      包括订单的查找、增加、删除等"+"\n（3）实现销售员和管理员的不同权限登陆下，显示不同的信息"+
        "\n如需帮助，请登录www.baidu.com进行相关查询。",5,5);
        add(ta);
        JScrollPane sa = new JScrollPane(ta);
        add(sa);
        sa.setBounds(20, 50, 450, 150);
        //返回按钮
        JButton jb = new JButton("返回");
        add(jb);
        jb.setBounds(360, 230, 100, 30);
        //
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//返回按钮功能
		jb.addActionListener(new ActionListener()
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
	        	bg.setBounds(0,0,500,350);
	        	this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
	        	((JPanel)this.getContentPane()).setOpaque(false);
	 } 
	
	public static void main(String[] args) 
	{
		 new About().background();
	}
}
