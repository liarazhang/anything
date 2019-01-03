package Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Salesman extends JFrame
{
	public Salesman()
	{
		setTitle("");
    	setSize(550, 350);
    	setResizable(false);
		setLayout(null); 
		//
		ImageIcon ic = new ImageIcon("头像.jpg");
		JLabel jl = new JLabel(ic);
		add(jl);
		jl.setBounds(325, 20, 150, 180);
		//
		JLabel input = new JLabel("欢迎回来！"); 
        add(input);
        input.setFont(new Font("宋体", Font.BOLD, 12));
        input.setBounds(40, 5, 180, 20);
		//姓名
		JLabel sp_name = new JLabel("姓    名:"); 
        add(sp_name);
        sp_name.setFont(new Font("宋体", Font.BOLD, 12));
        sp_name.setBounds(40, 28, 100, 20);
        JTextField jTextField1 = new JTextField();
        add(jTextField1); 
        jTextField1.setBounds(100, 30, 120, 20);
        jTextField1.setEditable(false);
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        //员工编号
        JLabel sp_id = new JLabel("员工编号:"); 
        add(sp_id);
        sp_id.setFont(new Font("宋体", Font.BOLD, 12));
        sp_id.setBounds(40, 60, 100, 20);
        JTextField jTextField2 = new JTextField();
        add(jTextField2); 
        jTextField2.setBounds(100, 62, 120, 20);
        jTextField2.setEditable(false);
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        //性别
        JLabel sex = new JLabel("性    别:"); 
        add(sex);
        sex.setFont(new Font("宋体", Font.BOLD, 12));
        sex.setBounds(40, 92, 100, 20);
        JTextField jTextField3 = new JTextField();
        add(jTextField3); 
        jTextField3.setBounds(100, 94, 120, 20);
        jTextField3.setEditable(false);
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        //年龄
        JLabel age = new JLabel("年    龄:"); 
        add(age);
        age.setFont(new Font("宋体", Font.BOLD, 12));
        age.setBounds(40, 124, 100, 20);
        JTextField jTextField4 = new JTextField();
        add(jTextField4); 
        jTextField4.setBounds(100, 126, 120, 20);
        jTextField4.setEditable(false);
        jTextField4.setBorder(null);
        jTextField4.setOpaque(false);
        //员工电话
        JLabel sp_tel = new JLabel("员工电话:"); 
        add(sp_tel);
        sp_tel.setFont(new Font("宋体", Font.BOLD, 12));
        sp_tel.setBounds(40, 156, 100, 20);
        JTextField jTextField5 = new JTextField();
        add(jTextField5); 
        jTextField5.setBounds(100, 158, 120, 20);
        jTextField5.setEditable(false);
        jTextField5.setBorder(null);
        jTextField5.setOpaque(false);
        //负责地区
        JLabel area = new JLabel("负责地区:"); 
        add(area);
        area.setFont(new Font("宋体", Font.BOLD, 12));
        area.setBounds(40, 188, 100, 20);
        JTextField jTextField6 = new JTextField();
        add(jTextField6); 
        jTextField6.setBounds(100, 190, 120, 20);
        jTextField6.setEditable(false);
        jTextField6.setBorder(null);
        jTextField6.setOpaque(false);
        //业绩指标
        JLabel zhibiao = new JLabel("业绩指标:"); 
        add(zhibiao);
        zhibiao.setFont(new Font("宋体", Font.BOLD, 12));
        zhibiao.setBounds(40, 220, 100, 20);
        JTextField jTextField7 = new JTextField();
        add(jTextField7); 
        jTextField7.setBounds(100, 222, 120, 20);
        jTextField7.setEditable(false);
        jTextField7.setBorder(null);
        jTextField7.setOpaque(false);
        //销售额
        JLabel money = new JLabel("销 售 额:"); 
        add(money);
        money.setFont(new Font("宋体", Font.BOLD, 12));
        money.setBounds(40, 252, 100, 20);
        JTextField jTextField8 = new JTextField();
        add(jTextField8); 
        jTextField8.setBounds(100, 254, 120, 20);
        jTextField8.setEditable(false);
        jTextField8.setBorder(null);
        jTextField8.setOpaque(false);
        setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //
        JButton jb1 = new JButton("我的销售单");
        add(jb1);
        jb1.setBounds(350, 210, 100, 30);
        //注销按钮
        JButton jb2 = new JButton("注销");
        add(jb2);
        jb2.setBounds(350, 250, 100, 30);
        //
		
		//
		jb1.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		Mysales ms = new Mysales();
    	        ms.background();
    	        ms.setVisible(true);
        	}
        }
        );
		//注销按钮功能
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
        new Salesman().background();
    }
}