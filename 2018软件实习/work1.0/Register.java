package Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * 注册界面
 * 
 * @author 廖文涛
 */
public class Register extends JFrame
{
	public Register()
	 {
	    	setTitle("注册页面");
	    	setSize(500, 300);
	    	setResizable(false);
			setLayout(null);
			//标题
			JLabel jl = new JLabel("欢迎注册本系统！");
	        add(jl);
	        jl.setFont(new Font("楷体", Font.BOLD, 17));
	        jl.setBounds(180, 20, 200, 50);
	        //用户名输入
	        JLabel id = new JLabel("用 户 名:"); 
	        add(id);
	        id.setFont(new Font("宋体", Font.BOLD, 12));
	        id.setBounds(150, 88, 100, 20);
	        final JTextField jTextField = new JTextField();
	        add(jTextField); 
	        jTextField.setBounds(210, 90, 120, 20);
	        JLabel hint = new JLabel("(请输入4位数字)"); 
	        add(hint);
	        hint.setFont(new Font("宋体", Font.BOLD, 10));
	        hint.setBounds(330, 88, 100, 20);
	        //密码输入
	        JLabel password1 = new JLabel("密    码:");
	        add(password1);
	        password1.setFont(new Font("宋体", Font.BOLD, 12));
	        password1.setBounds(150, 120, 100, 20);
	        final JTextField jPasswordField1 = new JPasswordField();
	        add(jPasswordField1);
	        jPasswordField1.setBounds(210, 122, 120, 20);
	        //确认密码
	        JLabel password2 = new JLabel("确认密码:");
	        add(password2);
	        password2.setFont(new Font("宋体", Font.BOLD, 12));
	        password2.setBounds(150, 150, 100, 20);
	        final JTextField jPasswordField2 = new JPasswordField();
	        add(jPasswordField2);
	        jPasswordField2.setBounds(210, 152, 120, 20);
	        //立即注册按钮
	        final JButton jb1 = new JButton("立即注册");
	        add(jb1);
	        jb1.setBounds(145, 190, 90, 20);
	        //取消按钮
	        JButton jb2 = new JButton("返回");
	        add(jb2);
	        jb2.setBounds(245, 190, 90, 20);
			setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//
			
			//立即注册按钮事件
			jb1.addActionListener(new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		if(!jPasswordField1.getText().trim().equals(jPasswordField2.getText().trim()))
	        			JOptionPane.showMessageDialog(null, "密码输入错误，请重新输入！");
	        		if(jTextField.getText().trim().length()!=4)
	        			JOptionPane.showMessageDialog(null, "用户名无效，请重新输入！");
	        			
	        	}
	        }
			);
			//返回按钮功能
			jb2.addActionListener(new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		setVisible(false);
	        		new Login().background();
	        	}
	        }
	        );
			//确认密码后按ENTER等同于立即注册按钮效果
			jPasswordField2.addKeyListener(new KeyAdapter()
	        {
	        	public void keyPressed(KeyEvent e)
	        	{
	        		if(e.getKeyCode() == KeyEvent.VK_ENTER)
	        			jb1.doClick();
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
}
