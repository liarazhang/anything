package Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Adddingdan extends JFrame
{
	public Adddingdan() 
	{
		setTitle("添加销售单");
    	setSize(550, 350);
    	setResizable(false);
		setLayout(null); 
		//订单编号
		JLabel dingdan_id = new JLabel("订单编号:"); 
        add(dingdan_id);
        dingdan_id.setFont(new Font("宋体", Font.BOLD, 12));
        dingdan_id.setBounds(40, 28, 100, 20);
        JTextField jTextField1 = new JTextField();
        add(jTextField1); 
        jTextField1.setBounds(100, 30, 120, 20);
        //订单日期
        JLabel dingdan_date = new JLabel("订购日期:"); 
        add(dingdan_date);
        dingdan_date.setFont(new Font("宋体", Font.BOLD, 12));
        dingdan_date.setBounds(40, 60, 100, 20);
        JTextField jTextField2 = new JTextField();
        add(jTextField2); 
        jTextField2.setBounds(100, 62, 120, 20);
        //客户姓名
        JLabel customer = new JLabel("客户姓名:"); 
        add(customer);
        customer.setFont(new Font("宋体", Font.BOLD, 12));
        customer.setBounds(40, 92, 100, 20);
        JTextField jTextField3 = new JTextField();
        add(jTextField3); 
        jTextField3.setBounds(100, 94, 120, 20);
        //客户电话
        JLabel customer_tel = new JLabel("客户电话:"); 
        add(customer_tel);
        customer_tel.setFont(new Font("宋体", Font.BOLD, 12));
        customer_tel.setBounds(40, 124, 100, 20);
        JTextField jTextField4 = new JTextField();
        add(jTextField4); 
        jTextField4.setBounds(100, 126, 120, 20);
        //产    品
        JLabel product = new JLabel("订购产品:"); 
        add(product);
        product.setFont(new Font("宋体", Font.BOLD, 12));
        product.setBounds(40, 156, 100, 20);
        JTextField jTextField5 = new JTextField();
        add(jTextField5); 
        jTextField5.setBounds(100, 158, 120, 20);
        //产品数量
        JLabel amount = new JLabel("订购数量:"); 
        add(amount);
        amount.setFont(new Font("宋体", Font.BOLD, 12));
        amount.setBounds(300, 28, 100, 20);
        JTextField jTextField6 = new JTextField();
        add(jTextField6); 
        jTextField6.setBounds(360, 30, 120, 20);
        //员工姓名
        JLabel sp_name = new JLabel("员工姓名:"); 
        add(sp_name);
        sp_name.setFont(new Font("宋体", Font.BOLD, 12));
        sp_name.setBounds(300, 70, 100, 20);
        JTextField jTextField7 = new JTextField();
        add(jTextField7); 
        jTextField7.setBounds(360, 72, 120, 20);
        //员工编号
        JLabel sp_id = new JLabel("员工编号:"); 
        add(sp_id);
        sp_id.setFont(new Font("宋体", Font.BOLD, 12));
        sp_id.setBounds(300, 112, 100, 20);
        JTextField jTextField8 = new JTextField();
        add(jTextField8); 
        jTextField8.setBounds(360, 114, 120, 20);
        //销售状态
        JLabel statr = new JLabel("销售状态:"); 
        add(statr);
        statr.setFont(new Font("宋体", Font.BOLD, 12));
        statr.setBounds(300, 154, 100, 20);
        JTextField jTextField9 = new JTextField();
        add(jTextField9); 
        jTextField9.setBounds(360, 156, 120, 20);
        //添加销售单按钮
        JButton jb1 = new JButton("添加销售单");
        add(jb1);
        jb1.setBounds(130, 220, 100, 30);
        //返回按钮
        JButton jb2 = new JButton("返回");
        add(jb2);
        jb2.setBounds(300, 220, 100, 30);
        //
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//添加销售单按钮功能
		jb1.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
    			JOptionPane.showMessageDialog(null, "添加销售单成功！", " ",2 );
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
        new Adddingdan().background();
    }
}
