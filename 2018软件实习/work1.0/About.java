package Login;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class About extends JFrame
{
	public About()
	{
		setTitle("����");
    	setSize(500, 350);
    	setResizable(false);
		setLayout(null); 
		//
		JLabel jl = new JLabel("��������");
        add(jl);
        jl.setFont(new Font("����", Font.BOLD, 17));
        jl.setBounds(210, 5, 100, 40);
        //
        JTextArea ta = new JTextArea("��ϵͳ�ɱ����ʵ��ѧ�Զ���ѧԺ�Ŷӿ�����" +
        "Ϊ����ҵ��;ʹ�õ��ڲ�汾��\nӦ�ø�ϵͳʵ�����¹��ܣ�"+"\n��1������Ա��Ϣ����\n"+
        "      ��������Ա�Ĳ��ҡ����ӡ�ɾ����\n��2�����۵���Ϣ�Ĺ���\n" +
        "      ���������Ĳ��ҡ����ӡ�ɾ����"+"\n��3��ʵ������Ա�͹���Ա�Ĳ�ͬȨ�޵�½�£���ʾ��ͬ����Ϣ"+
        "\n������������¼www.baidu.com������ز�ѯ��",5,5);
        add(ta);
        JScrollPane sa = new JScrollPane(ta);
        add(sa);
        sa.setBounds(20, 50, 450, 150);
        //���ذ�ť
        JButton jb = new JButton("����");
        add(jb);
        jb.setBounds(360, 230, 100, 30);
        //
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//���ذ�ť����
		jb.addActionListener(new ActionListener()
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
	        	bg.setBounds(0,0,500,350);
	        	this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
	        	((JPanel)this.getContentPane()).setOpaque(false);
	 } 
	
	public static void main(String[] args) 
	{
		 new About().background();
	}
}
