package Login;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * ϵͳ��¼����
 * 
 * @author ������
 */
public class Login extends JFrame
{
	public Login()
	 {
	    	setTitle("ϵͳ��¼");
	    	setSize(500, 300);
	    	setResizable(false);
			setLayout(null);
	        //����
			JLabel jl = new JLabel("��ӭ�������۹���ϵͳ��");
	        add(jl);
	        jl.setFont(new Font("����", Font.BOLD, 17));
	        jl.setBounds(150, 20, 200, 50);
	        //�û�������
	        JLabel id = new JLabel("�û�:"); 
	        add(id);
	        id.setFont(new Font("����", Font.BOLD, 12));
	        id.setBounds(160, 88, 100, 20);
	        JTextField jTextField = new JTextField();
	        add(jTextField); 
	        jTextField.setBounds(200, 90, 120, 20);
	        //��������
	        JLabel password = new JLabel("����:");
	        add(password);
	        password.setFont(new Font("����", Font.BOLD, 12));
	        password.setBounds(160, 120, 100, 20);
	        JPasswordField jPasswordField = new JPasswordField();
	        add(jPasswordField);
	        jPasswordField.setBounds(200, 122, 120, 20);
	        //����Աѡ��ť
	        JRadioButton jr1 = new JRadioButton("����Ա");
	        add(jr1);
	        jr1.setBounds(160, 155, 65, 20);
	        //����Աѡ��ť
	        JRadioButton jr2 = new JRadioButton("����Ա");
	        add(jr2);
	        jr2.setBounds(250, 155, 65, 20);
	        //��ѡ��ť�������ʼ
	        ButtonGroup bg = new ButtonGroup();
	        bg.add(jr1);
	        bg.add(jr2);
	        jr1.setSelected(true);
	        jr2.setSelected(false);
	        //��¼��ť
	        final JButton jb1 = new JButton("��¼");
	        add(jb1);
	        jb1.setBounds(110, 190, 70, 20);
	        //ע�ᰴť
	        JButton jb2 = new JButton("ע��");
	        add(jb2);
	        jb2.setBounds(210, 190, 70, 20);
	        //ȡ����ť
	        JButton jb3 = new JButton("ȡ��");
	        add(jb3);
	        jb3.setBounds(310, 190, 70, 20);
	        //������ӻ�
	        setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //ȡ����ť����
	        jb3.addActionListener(new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		System.exit(0);
	        	}
	        }
	        );
	        //���������ENTER��ͬ�ڵ�¼��ťЧ��
	        jPasswordField.addKeyListener(new KeyAdapter()
	        {
	        	public void keyPressed(KeyEvent e)
	        	{
	        		if(e.getKeyCode() == KeyEvent.VK_ENTER)
	        			jb1.doClick();
	        	}
	        }
	        );
	        //�رյ�¼ҳ�沢��ע��ҳ��
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
	   //����ͼƬ����
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