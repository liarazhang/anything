package Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * ע�����
 * 
 * @author ������
 */
public class Register extends JFrame
{
	public Register()
	 {
	    	setTitle("ע��ҳ��");
	    	setSize(500, 300);
	    	setResizable(false);
			setLayout(null);
			//����
			JLabel jl = new JLabel("��ӭע�᱾ϵͳ��");
	        add(jl);
	        jl.setFont(new Font("����", Font.BOLD, 17));
	        jl.setBounds(180, 20, 200, 50);
	        //�û�������
	        JLabel id = new JLabel("�� �� ��:"); 
	        add(id);
	        id.setFont(new Font("����", Font.BOLD, 12));
	        id.setBounds(150, 88, 100, 20);
	        final JTextField jTextField = new JTextField();
	        add(jTextField); 
	        jTextField.setBounds(210, 90, 120, 20);
	        JLabel hint = new JLabel("(������4λ����)"); 
	        add(hint);
	        hint.setFont(new Font("����", Font.BOLD, 10));
	        hint.setBounds(330, 88, 100, 20);
	        //��������
	        JLabel password1 = new JLabel("��    ��:");
	        add(password1);
	        password1.setFont(new Font("����", Font.BOLD, 12));
	        password1.setBounds(150, 120, 100, 20);
	        final JTextField jPasswordField1 = new JPasswordField();
	        add(jPasswordField1);
	        jPasswordField1.setBounds(210, 122, 120, 20);
	        //ȷ������
	        JLabel password2 = new JLabel("ȷ������:");
	        add(password2);
	        password2.setFont(new Font("����", Font.BOLD, 12));
	        password2.setBounds(150, 150, 100, 20);
	        final JTextField jPasswordField2 = new JPasswordField();
	        add(jPasswordField2);
	        jPasswordField2.setBounds(210, 152, 120, 20);
	        //����ע�ᰴť
	        final JButton jb1 = new JButton("����ע��");
	        add(jb1);
	        jb1.setBounds(145, 190, 90, 20);
	        //ȡ����ť
	        JButton jb2 = new JButton("����");
	        add(jb2);
	        jb2.setBounds(245, 190, 90, 20);
			setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//
			
			//����ע�ᰴť�¼�
			jb1.addActionListener(new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		if(!jPasswordField1.getText().trim().equals(jPasswordField2.getText().trim()))
	        			JOptionPane.showMessageDialog(null, "��������������������룡");
	        		if(jTextField.getText().trim().length()!=4)
	        			JOptionPane.showMessageDialog(null, "�û�����Ч�����������룡");
	        			
	        	}
	        }
			);
			//���ذ�ť����
			jb2.addActionListener(new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		setVisible(false);
	        		new Login().background();
	        	}
	        }
	        );
			//ȷ�������ENTER��ͬ������ע�ᰴťЧ��
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
	//����ͼƬ����
	public void background()
	 {
	        	ImageIcon img = new ImageIcon("background.jpg");
	        	JLabel bg = new JLabel(img);
	        	bg.setBounds(0,0,500,300);
	        	this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
	        	((JPanel)this.getContentPane()).setOpaque(false);
	 } 
}
