package Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Dingdanidselect extends JFrame
{
	public Dingdanidselect() 
	{
		setTitle("��ѯ���۵�");
    	setSize(550, 350);
    	setResizable(false);
		setLayout(null); 
		//
		JLabel input = new JLabel("������Ҫ��ѯ�����۵��ı��:"); 
        add(input);
        input.setFont(new Font("����", Font.BOLD, 12));
        input.setBounds(120, 18, 180, 20);
        JTextField jTextField = new JTextField();
        add(jTextField); 
        jTextField.setBounds(305, 20, 120, 20);
		//�������
		JLabel dingdan_id = new JLabel("�������:"); 
        add(dingdan_id);
        dingdan_id.setFont(new Font("����", Font.BOLD, 12));
        dingdan_id.setBounds(110, 104, 100, 20);
        JTextField jTextField1 = new JTextField();
        add(jTextField1); 
        jTextField1.setBounds(170, 106, 120, 20);
        jTextField1.setEditable(false);
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        //��������
        JLabel dingdan_date = new JLabel("��������:"); 
        add(dingdan_date);
        dingdan_date.setFont(new Font("����", Font.BOLD, 12));
        dingdan_date.setBounds(110, 136, 100, 20);
        JTextField jTextField2 = new JTextField();
        add(jTextField2); 
        jTextField2.setBounds(170, 138, 120, 20);
        jTextField2.setEditable(false);
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        //�ͻ�����
        JLabel customer = new JLabel("�ͻ�����:"); 
        add(customer);
        customer.setFont(new Font("����", Font.BOLD, 12));
        customer.setBounds(110, 168, 100, 20);
        JTextField jTextField3 = new JTextField();
        add(jTextField3); 
        jTextField3.setBounds(170, 170, 120, 20);
        jTextField3.setEditable(false);
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        //�ͻ��绰
        JLabel customer_tel = new JLabel("�ͻ��绰:"); 
        add(customer_tel);
        customer_tel.setFont(new Font("����", Font.BOLD, 12));
        customer_tel.setBounds(110, 200, 100, 20);
        JTextField jTextField4 = new JTextField();
        add(jTextField4); 
        jTextField4.setBounds(170, 202, 120, 20);
        jTextField4.setEditable(false);
        jTextField4.setBorder(null);
        jTextField4.setOpaque(false);
        //��    Ʒ
        JLabel product = new JLabel("������Ʒ:"); 
        add(product);
        product.setFont(new Font("����", Font.BOLD, 12));
        product.setBounds(110, 232, 100, 20);
        JTextField jTextField5 = new JTextField();
        add(jTextField5); 
        jTextField5.setBounds(170, 234, 120, 20);
        jTextField5.setEditable(false);
        jTextField5.setBorder(null);
        jTextField5.setOpaque(false);
        //��Ʒ����
        JLabel amount = new JLabel("��������:"); 
        add(amount);
        amount.setFont(new Font("����", Font.BOLD, 12));
        amount.setBounds(300, 104, 100, 20);
        JTextField jTextField6 = new JTextField();
        add(jTextField6); 
        jTextField6.setBounds(360, 106, 120, 20);
        jTextField6.setEditable(false);
        jTextField6.setBorder(null);
        jTextField6.setOpaque(false);
        //Ա������
        JLabel sp_name = new JLabel("Ա������:"); 
        add(sp_name);
        sp_name.setFont(new Font("����", Font.BOLD, 12));
        sp_name.setBounds(300, 146, 100, 20);
        JTextField jTextField7 = new JTextField();
        add(jTextField7); 
        jTextField7.setBounds(360, 148, 120, 20);
        jTextField7.setEditable(false);
        jTextField7.setBorder(null);
        jTextField7.setOpaque(false);
        //Ա�����
        JLabel sp_id = new JLabel("Ա�����:"); 
        add(sp_id);
        sp_id.setFont(new Font("����", Font.BOLD, 12));
        sp_id.setBounds(300, 188, 100, 20);
        JTextField jTextField8 = new JTextField();
        add(jTextField8); 
        jTextField8.setBounds(360, 190, 120, 20);
        jTextField8.setEditable(false);
        jTextField8.setBorder(null);
        jTextField8.setOpaque(false);
        //����״̬
        JLabel statr = new JLabel("����״̬:"); 
        add(statr);
        statr.setFont(new Font("����", Font.BOLD, 12));
        statr.setBounds(300, 230, 100, 20);
        JTextField jTextField9 = new JTextField();
        add(jTextField9); 
        jTextField9.setBounds(360, 232, 120, 20);
        jTextField9.setEditable(false);
        jTextField9.setBorder(null);
        jTextField9.setOpaque(false);
        setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//
        JButton jb1 = new JButton("���� ");
        add(jb1);
        jb1.setBounds(150, 50, 100, 30);
        //���ذ�ť
        JButton jb2 = new JButton("����");
        add(jb2);
        jb2.setBounds(300, 50, 100, 30);
        //
		
		//
		jb1.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
    			
        	}
        }
        );
		//���ذ�ť����
		jb2.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		setVisible(false);
        	}
        }
        );
	}
	
	//����ͼƬ����
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
        new Dingdanidselect().background();
    }
}
