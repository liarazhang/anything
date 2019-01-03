package Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Addsp extends JFrame
{
	public Addsp()
	{
		setTitle("添加销售员");
    	setSize(550, 350);
    	setResizable(false);
		setLayout(null); 
		//姓名
		JLabel sp_name = new JLabel("姓名:"); 
        add(sp_name);
        sp_name.setFont(new Font("宋体", Font.BOLD, 12));
        sp_name.setBounds(40, 28, 100, 20);
        JTextField jTextField1 = new JTextField();
        add(jTextField1); 
        jTextField1.setBounds(100, 30, 120, 20);
        //员工编号
        JLabel sp_id = new JLabel("员工编号:"); 
        add(sp_id);
        sp_id.setFont(new Font("宋体", Font.BOLD, 12));
        sp_id.setBounds(40, 60, 100, 20);
        JTextField jTextField2 = new JTextField();
        add(jTextField2); 
        jTextField2.setBounds(100, 62, 120, 20);
        //性别
        JLabel sex = new JLabel("性别:"); 
        add(sex);
        sex.setFont(new Font("宋体", Font.BOLD, 12));
        sex.setBounds(40, 92, 100, 20);
        JTextField jTextField3 = new JTextField();
        add(jTextField3); 
        jTextField3.setBounds(100, 94, 120, 20);
        //年龄
        JLabel age = new JLabel("年龄:"); 
        add(age);
        age.setFont(new Font("宋体", Font.BOLD, 12));
        age.setBounds(40, 124, 100, 20);
        JTextField jTextField4 = new JTextField();
        add(jTextField4); 
        jTextField4.setBounds(100, 126, 120, 20);
        //员工电话
        JLabel sp_tel = new JLabel("员工电话:"); 
        add(sp_tel);
        sp_tel.setFont(new Font("宋体", Font.BOLD, 12));
        sp_tel.setBounds(40, 156, 100, 20);
        JTextField jTextField5 = new JTextField();
        add(jTextField5); 
        jTextField5.setBounds(100, 158, 120, 20);
        //负责地区
        JLabel area = new JLabel("负责地区:"); 
        add(area);
        area.setFont(new Font("宋体", Font.BOLD, 12));
        area.setBounds(300, 28, 100, 20);
        JTextField jTextField6 = new JTextField();
        add(jTextField6); 
        jTextField6.setBounds(360, 30, 120, 20);
        //业绩指标
        JLabel zhibiao = new JLabel("业绩指标:"); 
        add(zhibiao);
        zhibiao.setFont(new Font("宋体", Font.BOLD, 12));
        zhibiao.setBounds(300, 70, 100, 20);
        JTextField jTextField7 = new JTextField();
        add(jTextField7); 
        jTextField7.setBounds(360, 72, 120, 20);
        //销售额
        JLabel money = new JLabel("销售额:"); 
        add(money);
        money.setFont(new Font("宋体", Font.BOLD, 12));
        money.setBounds(300, 112, 100, 20);
        JTextField jTextField8 = new JTextField();
        add(jTextField8); 
        jTextField8.setBounds(360, 114, 120, 20);
        //添加销售员按钮
        JButton jb1 = new JButton("添加销售员");
        add(jb1);
        jb1.setBounds(130, 220, 100, 30);
        //返回按钮
        JButton jb2 = new JButton("返回");
        add(jb2);
        jb2.setBounds(300, 220, 100, 30);
        //
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//添加销售员按钮功能
		jb1.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
    			JOptionPane.showMessageDialog(null, "添加销售员成功！", " ",2 );
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
        new Addsp().background();
    }
}