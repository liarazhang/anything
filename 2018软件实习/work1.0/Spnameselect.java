package Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Spnameselect extends JFrame
{
	public Spnameselect()
	{
		setTitle("查询销售员");
    	setSize(550, 350);
    	setResizable(false);
		setLayout(null); 
		//
		JLabel input = new JLabel("请输入要查询的销售员的姓名:"); 
        add(input);
        input.setFont(new Font("宋体", Font.BOLD, 12));
        input.setBounds(120, 18, 180, 20);
        JTextField jTextField = new JTextField();
        add(jTextField); 
        jTextField.setBounds(305, 20, 120, 20);
		//姓名
		JLabel sp_name = new JLabel("姓    名:"); 
        add(sp_name);
        sp_name.setFont(new Font("宋体", Font.BOLD, 12));
        sp_name.setBounds(110, 104, 100, 20);
        JTextField jTextField1 = new JTextField();;
        add(jTextField1); 
        jTextField1.setBounds(170, 106, 120, 20);
        jTextField1.setEditable(false);
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        //员工编号
        JLabel sp_id = new JLabel("员工编号:"); 
        add(sp_id);
        sp_id.setFont(new Font("宋体", Font.BOLD, 12));
        sp_id.setBounds(110, 146, 100, 20);
        JTextField jTextField2 = new JTextField();
        add(jTextField2); 
        jTextField2.setBounds(170, 148, 120, 20);
        jTextField2.setEditable(false);
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        //性别
        JLabel sex = new JLabel("性    别:"); 
        add(sex);
        sex.setFont(new Font("宋体", Font.BOLD, 12));
        sex.setBounds(110, 188, 100, 20);
        JTextField jTextField3 = new JTextField();
        add(jTextField3); 
        jTextField3.setBounds(170, 190, 120, 20);
        jTextField3.setEditable(false);
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        //年龄
        JLabel age = new JLabel("年    龄:"); 
        add(age);
        age.setFont(new Font("宋体", Font.BOLD, 12));
        age.setBounds(110, 230, 100, 20);
        JTextField jTextField4 = new JTextField();
        add(jTextField4); 
        jTextField4.setBounds(170, 232, 120, 20);
        jTextField4.setEditable(false);
        jTextField4.setBorder(null);
        jTextField4.setOpaque(false);
        //员工电话
        JLabel sp_tel = new JLabel("员工电话:"); 
        add(sp_tel);
        sp_tel.setFont(new Font("宋体", Font.BOLD, 12));
        sp_tel.setBounds(300, 104, 100, 20);
        JTextField jTextField5 = new JTextField();
        add(jTextField5); 
        jTextField5.setBounds(360, 106, 120, 20);
        jTextField5.setEditable(false);
        jTextField5.setBorder(null);
        jTextField5.setOpaque(false);
        //负责地区
        JLabel area = new JLabel("负责地区:"); 
        add(area);
        area.setFont(new Font("宋体", Font.BOLD, 12));
        area.setBounds(300, 146, 100, 20);
        JTextField jTextField6 = new JTextField();
        add(jTextField6); 
        jTextField6.setBounds(360, 148, 120, 20);
        jTextField6.setEditable(false);
        jTextField6.setBorder(null);
        jTextField6.setOpaque(false);
        //业绩指标
        JLabel zhibiao = new JLabel("业绩指标:"); 
        add(zhibiao);
        zhibiao.setFont(new Font("宋体", Font.BOLD, 12));
        zhibiao.setBounds(300, 188, 100, 20);
        JTextField jTextField7 = new JTextField();
        add(jTextField7); 
        jTextField7.setBounds(360, 190, 120, 20);
        jTextField7.setEditable(false);
        jTextField7.setBorder(null);
        jTextField7.setOpaque(false);
        //销售额
        JLabel money = new JLabel("销售额:"); 
        add(money);
        money.setFont(new Font("宋体", Font.BOLD, 12));
        money.setBounds(300, 230, 100, 20);
        JTextField jTextField8 = new JTextField();
        add(jTextField8); 
        jTextField8.setBounds(360, 232, 120, 20);
        jTextField8.setEditable(false);
        jTextField8.setBorder(null);
        jTextField8.setOpaque(false);
        //
        JButton jb1 = new JButton("查找 ");
        add(jb1);
        jb1.setBounds(150, 50, 100, 30);
        //返回按钮
        JButton jb2 = new JButton("返回");
        add(jb2);
        jb2.setBounds(300, 50, 100, 30);
        //
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//按钮功能
		jb1.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
    			
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
        new Spnameselect().background();
    }
}