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
		ImageIcon ic = new ImageIcon("ͷ��.jpg");
		JLabel jl = new JLabel(ic);
		add(jl);
		jl.setBounds(325, 20, 150, 180);
		//
		JLabel input = new JLabel("��ӭ������"); 
        add(input);
        input.setFont(new Font("����", Font.BOLD, 12));
        input.setBounds(40, 5, 180, 20);
		//����
		JLabel sp_name = new JLabel("��    ��:"); 
        add(sp_name);
        sp_name.setFont(new Font("����", Font.BOLD, 12));
        sp_name.setBounds(40, 28, 100, 20);
        JTextField jTextField1 = new JTextField();
        add(jTextField1); 
        jTextField1.setBounds(100, 30, 120, 20);
        jTextField1.setEditable(false);
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        //Ա�����
        JLabel sp_id = new JLabel("Ա�����:"); 
        add(sp_id);
        sp_id.setFont(new Font("����", Font.BOLD, 12));
        sp_id.setBounds(40, 60, 100, 20);
        JTextField jTextField2 = new JTextField();
        add(jTextField2); 
        jTextField2.setBounds(100, 62, 120, 20);
        jTextField2.setEditable(false);
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        //�Ա�
        JLabel sex = new JLabel("��    ��:"); 
        add(sex);
        sex.setFont(new Font("����", Font.BOLD, 12));
        sex.setBounds(40, 92, 100, 20);
        JTextField jTextField3 = new JTextField();
        add(jTextField3); 
        jTextField3.setBounds(100, 94, 120, 20);
        jTextField3.setEditable(false);
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        //����
        JLabel age = new JLabel("��    ��:"); 
        add(age);
        age.setFont(new Font("����", Font.BOLD, 12));
        age.setBounds(40, 124, 100, 20);
        JTextField jTextField4 = new JTextField();
        add(jTextField4); 
        jTextField4.setBounds(100, 126, 120, 20);
        jTextField4.setEditable(false);
        jTextField4.setBorder(null);
        jTextField4.setOpaque(false);
        //Ա���绰
        JLabel sp_tel = new JLabel("Ա���绰:"); 
        add(sp_tel);
        sp_tel.setFont(new Font("����", Font.BOLD, 12));
        sp_tel.setBounds(40, 156, 100, 20);
        JTextField jTextField5 = new JTextField();
        add(jTextField5); 
        jTextField5.setBounds(100, 158, 120, 20);
        jTextField5.setEditable(false);
        jTextField5.setBorder(null);
        jTextField5.setOpaque(false);
        //�������
        JLabel area = new JLabel("�������:"); 
        add(area);
        area.setFont(new Font("����", Font.BOLD, 12));
        area.setBounds(40, 188, 100, 20);
        JTextField jTextField6 = new JTextField();
        add(jTextField6); 
        jTextField6.setBounds(100, 190, 120, 20);
        jTextField6.setEditable(false);
        jTextField6.setBorder(null);
        jTextField6.setOpaque(false);
        //ҵ��ָ��
        JLabel zhibiao = new JLabel("ҵ��ָ��:"); 
        add(zhibiao);
        zhibiao.setFont(new Font("����", Font.BOLD, 12));
        zhibiao.setBounds(40, 220, 100, 20);
        JTextField jTextField7 = new JTextField();
        add(jTextField7); 
        jTextField7.setBounds(100, 222, 120, 20);
        jTextField7.setEditable(false);
        jTextField7.setBorder(null);
        jTextField7.setOpaque(false);
        //���۶�
        JLabel money = new JLabel("�� �� ��:"); 
        add(money);
        money.setFont(new Font("����", Font.BOLD, 12));
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
        JButton jb1 = new JButton("�ҵ����۵�");
        add(jb1);
        jb1.setBounds(350, 210, 100, 30);
        //ע����ť
        JButton jb2 = new JButton("ע��");
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
		//ע����ť����
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
        new Salesman().background();
    }
}