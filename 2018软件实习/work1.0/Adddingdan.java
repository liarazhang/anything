package Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Adddingdan extends JFrame
{
	public Adddingdan() 
	{
		setTitle("������۵�");
    	setSize(550, 350);
    	setResizable(false);
		setLayout(null); 
		//�������
		JLabel dingdan_id = new JLabel("�������:"); 
        add(dingdan_id);
        dingdan_id.setFont(new Font("����", Font.BOLD, 12));
        dingdan_id.setBounds(40, 28, 100, 20);
        JTextField jTextField1 = new JTextField();
        add(jTextField1); 
        jTextField1.setBounds(100, 30, 120, 20);
        //��������
        JLabel dingdan_date = new JLabel("��������:"); 
        add(dingdan_date);
        dingdan_date.setFont(new Font("����", Font.BOLD, 12));
        dingdan_date.setBounds(40, 60, 100, 20);
        JTextField jTextField2 = new JTextField();
        add(jTextField2); 
        jTextField2.setBounds(100, 62, 120, 20);
        //�ͻ�����
        JLabel customer = new JLabel("�ͻ�����:"); 
        add(customer);
        customer.setFont(new Font("����", Font.BOLD, 12));
        customer.setBounds(40, 92, 100, 20);
        JTextField jTextField3 = new JTextField();
        add(jTextField3); 
        jTextField3.setBounds(100, 94, 120, 20);
        //�ͻ��绰
        JLabel customer_tel = new JLabel("�ͻ��绰:"); 
        add(customer_tel);
        customer_tel.setFont(new Font("����", Font.BOLD, 12));
        customer_tel.setBounds(40, 124, 100, 20);
        JTextField jTextField4 = new JTextField();
        add(jTextField4); 
        jTextField4.setBounds(100, 126, 120, 20);
        //��    Ʒ
        JLabel product = new JLabel("������Ʒ:"); 
        add(product);
        product.setFont(new Font("����", Font.BOLD, 12));
        product.setBounds(40, 156, 100, 20);
        JTextField jTextField5 = new JTextField();
        add(jTextField5); 
        jTextField5.setBounds(100, 158, 120, 20);
        //��Ʒ����
        JLabel amount = new JLabel("��������:"); 
        add(amount);
        amount.setFont(new Font("����", Font.BOLD, 12));
        amount.setBounds(300, 28, 100, 20);
        JTextField jTextField6 = new JTextField();
        add(jTextField6); 
        jTextField6.setBounds(360, 30, 120, 20);
        //Ա������
        JLabel sp_name = new JLabel("Ա������:"); 
        add(sp_name);
        sp_name.setFont(new Font("����", Font.BOLD, 12));
        sp_name.setBounds(300, 70, 100, 20);
        JTextField jTextField7 = new JTextField();
        add(jTextField7); 
        jTextField7.setBounds(360, 72, 120, 20);
        //Ա�����
        JLabel sp_id = new JLabel("Ա�����:"); 
        add(sp_id);
        sp_id.setFont(new Font("����", Font.BOLD, 12));
        sp_id.setBounds(300, 112, 100, 20);
        JTextField jTextField8 = new JTextField();
        add(jTextField8); 
        jTextField8.setBounds(360, 114, 120, 20);
        //����״̬
        JLabel statr = new JLabel("����״̬:"); 
        add(statr);
        statr.setFont(new Font("����", Font.BOLD, 12));
        statr.setBounds(300, 154, 100, 20);
        JTextField jTextField9 = new JTextField();
        add(jTextField9); 
        jTextField9.setBounds(360, 156, 120, 20);
        //������۵���ť
        JButton jb1 = new JButton("������۵�");
        add(jb1);
        jb1.setBounds(130, 220, 100, 30);
        //���ذ�ť
        JButton jb2 = new JButton("����");
        add(jb2);
        jb2.setBounds(300, 220, 100, 30);
        //
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//������۵���ť����
		jb1.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
    			JOptionPane.showMessageDialog(null, "������۵��ɹ���", " ",2 );
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
        new Adddingdan().background();
    }
}
