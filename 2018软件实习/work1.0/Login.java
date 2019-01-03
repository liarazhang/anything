package Login;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * 系统登录界面
 * 
 * @author 廖文涛
 */
public class Login extends JFrame
{
	public Login()
	 {
	    	setTitle("系统登录");
	    	setSize(500, 300);
	    	setResizable(false);
			setLayout(null);
	        //标题
			JLabel jl = new JLabel("欢迎来到销售管理系统！");
	        add(jl);
	        jl.setFont(new Font("楷体", Font.BOLD, 17));
	        jl.setBounds(150, 20, 200, 50);
	        //用户名输入
	        JLabel id = new JLabel("用户:"); 
	        add(id);
	        id.setFont(new Font("宋体", Font.BOLD, 12));
	        id.setBounds(160, 88, 100, 20);
	        JTextField jTextField = new JTextField();
	        add(jTextField); 
	        jTextField.setBounds(200, 90, 120, 20);
	        //密码输入
	        JLabel password = new JLabel("密码:");
	        add(password);
	        password.setFont(new Font("宋体", Font.BOLD, 12));
	        password.setBounds(160, 120, 100, 20);
	        JPasswordField jPasswordField = new JPasswordField();
	        add(jPasswordField);
	        jPasswordField.setBounds(200, 122, 120, 20);
	        //销售员选择按钮
	        JRadioButton jr1 = new JRadioButton("销售员");
	        add(jr1);
	        jr1.setBounds(160, 155, 65, 20);
	        //管理员选择按钮
	        JRadioButton jr2 = new JRadioButton("管理员");
	        add(jr2);
	        jr2.setBounds(250, 155, 65, 20);
	        //单选按钮联动与初始
	        ButtonGroup bg = new ButtonGroup();
	        bg.add(jr1);
	        bg.add(jr2);
	        jr1.setSelected(true);
	        jr2.setSelected(false);
	        //登录按钮
	        final JButton jb1 = new JButton("登录");
	        add(jb1);
	        jb1.setBounds(110, 190, 70, 20);
	        //注册按钮
	        JButton jb2 = new JButton("注册");
	        add(jb2);
	        jb2.setBounds(210, 190, 70, 20);
	        //取消按钮
	        JButton jb3 = new JButton("取消");
	        add(jb3);
	        jb3.setBounds(310, 190, 70, 20);
	        //界面可视化
	        setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //取消按钮功能
	        jb3.addActionListener(new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		System.exit(0);
	        	}
	        }
	        );
	        //密码输入后按ENTER等同于登录按钮效果
	        jPasswordField.addKeyListener(new KeyAdapter()
	        {
	        	public void keyPressed(KeyEvent e)
	        	{
	        		if(e.getKeyCode() == KeyEvent.VK_ENTER)
	        			jb1.doClick();
	        	}
	        }
	        );
	        //关闭登录页面并打开注册页面
	        jb2.addActionListener(new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		setVisible(false);
	        		Register rg=new Register();
	        		rg.background();
	        		rg.setVisible(true);
	        	}
	        }
	        );
	  }
	   //背景图片设置
	  public void background()
	   {
	        	ImageIcon img = new ImageIcon("background.jpg");
	        	JLabel bg = new JLabel(img);
	        	bg.setBounds(0,0,500,300);
	        	this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
	        	((JPanel)this.getContentPane()).setOpaque(false);
	   } 
	   public static void main(String[] args)
	    {
	        new Login().background();
	    }
}