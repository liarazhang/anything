package Login;
//ϵͳ��������

//����ϵͳ�İ�
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//������������
public class Manager extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//�����������

	//�����˵���
	JMenuBar jMenuBarSM=new JMenuBar();
	JMenu jMenuStart=new JMenu("��ʼ");
	JMenuItem jMenuStartOutport=new JMenuItem("����");
	JMenu jMenuStudents=new JMenu("����Ա����");
	JMenuItem jMenuStuName=new JMenuItem("��������ѯ");
	JMenuItem jMenuStuId=new JMenuItem("����Ų�ѯ");
	JMenuItem jMenuStust=new JMenuItem("��������ѯ");
	JMenuItem jMenuStuAll=new JMenuItem("������Ա");
	JMenu jMenuManage=new JMenu("��Ա����");
	JMenuItem jMenuAddStu=new JMenuItem("�������Ա");
	JMenuItem jMenuDelStu=new JMenuItem("ɾ������Ա");
	
	

	JMenu jMenuClass=new JMenu("���۵�����");
	JMenuItem jMenuOnClassId=new JMenuItem("�������Ų�ѯ");
	JMenuItem jMenuOnClassSt=new JMenuItem("�����ڲ�ѯ");
	JMenuItem jMenuOnClassAll=new JMenuItem("���ж���");
	JMenu jMenuManage2=new JMenu("��������");
	JMenuItem jMenuAddClass=new JMenuItem("������۵�");
	JMenuItem jMenuDelClass=new JMenuItem("ɾ�����۵�");

	/*JMenu jMenuDepartment=new JMenu("ҵ����Ϣ����");
	JMenuItem jMenuOnDepId=new JMenuItem("������ϵ��Ų�ѯ");
	JMenuItem jMenuAddDep=new JMenuItem("��Ӳ���ϵ");
	JMenuItem jMenuDelDep=new JMenuItem("ɾ������ϵ");*/

	JMenu jMenuSet=new JMenu("����");
	JMenuItem jMenuHelpAbout=new JMenuItem("����");
	JMenuItem jMenuSwitch=new JMenuItem("�л��˺�");
	//������ǩ��������ʾ��Ϣ
	JLabel jLabel1=new JLabel("��ӭʹ����ҵ���۹���ϵͳ");
	JLabel jLabel2=new JLabel("2017��09��22��");
	
	
	
	//���췽������������ʱ�Զ�����
	public Manager()
	{
		try{
			//�رտ�ܴ���ʱ��Ĭ���¼�����
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			//���ó�ʼ������
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	//�����ʼ������
	private void jbInit() throws Exception
	{
		//�������������䲼��
		setResizable(false);
		setLayout(null);
		//��ܵĴ�С�������
		setSize(new Dimension(600,420));
		setTitle("��ҵ���۹���ϵͳ");
		//����¼�����
		jMenuStartOutport.addActionListener(this);
		
		jMenuHelpAbout.addActionListener(this);
		jMenuSwitch.addActionListener(this);
		
		jMenuAddStu.addActionListener(this);
		jMenuDelStu.addActionListener(this);
		jMenuStuName.addActionListener(this);
		jMenuStuId.addActionListener(this);
		jMenuManage.addActionListener(this);
		
		jMenuOnClassId.addActionListener(this);
		jMenuOnClassSt.addActionListener(this);
		jMenuOnClassAll.addActionListener(this);
		jMenuAddClass.addActionListener(this);
		jMenuDelClass.addActionListener(this);
		jMenuManage2.addActionListener(this);
		
		/*jMenuOnDepId.addActionListener(this);
		jMenuAddDep.addActionListener(this);
		jMenuDelDep.addActionListener(this);*/

		//��Ӳ˵���
		setJMenuBar(jMenuBarSM);
		//��Ӳ˵�������˵���
		jMenuBarSM.add(jMenuStart);
		jMenuBarSM.add(jMenuStudents);
		jMenuBarSM.add(jMenuClass);
		//jMenuBarSM.add(jMenuDepartment);
		jMenuBarSM.add(jMenuStartOutport);
		jMenuBarSM.add(jMenuSet);

		//��Ӳ˵���������˵����
		jMenuStart.add(jMenuStartOutport);
		//����Ա��Ϣ����˵��µ�ѡ�񣺰�������ѯ������Ų�ѯ���������Ա��ɾ������Ա
		jMenuStudents.add(jMenuStuName);
		jMenuStudents.add(jMenuStuId);
		jMenuStudents.add(jMenuStuAll);
		jMenuStudents.add(jMenuManage);
		jMenuManage.add(jMenuAddStu);
		jMenuManage.add(jMenuDelStu);
		//���۵���Ϣ����˵��µ�ѡ�񣺰������Ų�ѯ��������۵���ɾ�����۵�
		jMenuClass.add(jMenuOnClassId);
		jMenuClass.add(jMenuOnClassSt);
		jMenuClass.add(jMenuOnClassAll);
		jMenuClass.add(jMenuManage2);
		jMenuManage2.add(jMenuAddClass);
		jMenuManage2.add(jMenuDelClass);
		/*//ҵ����Ϣ����˵��µ�ѡ�񣺰�ϵ�Ų�ѯ�����ϵ��ɾ��ϵ
		jMenuDepartment.add(jMenuOnDepId);
		jMenuDepartment.add(jMenuAddDep);
		jMenuDepartment.add(jMenuDelDep);*/
		//�����˵��µ�
		jMenuSet.add(jMenuHelpAbout);
		jMenuSet.add(jMenuSwitch);

		//��ӱ�ǩ���������
		add(jLabel1);
		add(jLabel2);
		//���ñ�ǩ����Ĵ�С������
		jLabel1.setFont(new java.awt.Font("���Ŀ���",Font.BOLD,35));
		jLabel1.setBounds(new Rectangle(77,120,475,55));
		jLabel1.setForeground(Color.BLACK);

		jLabel2.setFont(new java.awt.Font("���Ŀ���",Font.BOLD,16));
		jLabel2.setBounds(new Rectangle(220,220,200,35));
		jLabel2.setForeground(Color.BLACK);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void background()
	 {
	        	ImageIcon img = new ImageIcon("background.jpg");
	        	JLabel bg = new JLabel(img);
	        	bg.setBounds(0,0,850,400);
	        	this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
	        	((JPanel)this.getContentPane()).setOpaque(false);
	 } 
	
	//�˵��¼��Ĵ�����
	public void actionPerformed(ActionEvent actionEvent)
	{
		//������ļ����˵��µġ��˳����˵���
		if(actionEvent.getSource()==jMenuStartOutport)
		{
			System.exit(0);
		}
		//���������Ա��ѯ���˵��µġ���������ѯ���˵���
		if(actionEvent.getSource()==jMenuStuName)
		{
			//��������������ѯ��������

			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			//�����ɼ�
			this.setVisible(true);
		}
		//���������Ա��ѯ���˵��µġ�����Ų�ѯ���˵���
		if(actionEvent.getSource()==jMenuStuId)
		{
			//����������Ų�ѯ��������

			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());

			//�����ɼ�
			this.setVisible(true);
		}
		//���������Ա�����˵��µġ��������Ա���˵���
		if(actionEvent.getSource()==jMenuAddStu)
		{
			Addsp as = new Addsp();
	        as.background();
	        as.setVisible(true);
		}
		//���������Ա�����˵��µġ�ɾ������Ա���˵���
		if(actionEvent.getSource()==jMenuDelStu)
		{
			Desp ds = new Desp();
	        ds.background();
	        ds.setVisible(true);
		}

		//��������۵���Ϣ�����˵��µġ��������Ų�ѯ���˵���
		if(actionEvent.getSource()==jMenuOnClassId)
		{
			//�����������Ų�ѯ��������

			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());

			//�����ɼ�
			this.setVisible(true);
		}
		//��������۵������˵��µġ�������۵����˵���
		if(actionEvent.getSource()==jMenuAddClass)
		{
			Adddingdan ad = new Adddingdan();
	        ad.background();
	        ad.setVisible(true);
		}
		//��������۵������˵��µġ�ɾ�����۵����˵���
		if(actionEvent.getSource()==jMenuDelClass)
		{
			Dedingdan d = new Dedingdan();
 	        d.background();
 	        d.setVisible(true);
		}

		/*//�����ҵ����Ϣ�����˵��µġ�������ϵ��Ų�ѯ���˵���
		if(actionEvent.getSource()==jMenuOnDepId)
		{
			//��������Ų�ѯ��������
			InquireOnDepID onDepId=new InquireOnDepID();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(onDepId);
			//�����ɼ�
			this.setVisible(true);
		}

		//���������ϵ�����˵��µġ���Ӳ���ϵ���˵���
		if(actionEvent.getSource()==jMenuAddDep)
		{
			//������Ӱ༶������
			AddDepartment addDep=new AddDepartment();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(addDep);
			//�����ɼ�
			this.setVisible(true);
		}

		//���������ϵ�����˵��µġ�ɾ������ϵ���˵���
		if(actionEvent.getSource()==jMenuDelDep){
			//����ɾ���༶������
			DelDepartment delDep=new DelDepartment();
			//�Ƴ���������ԭ�е�����
			this.remove(this.getContentPane());
			this.setContentPane(delDep);
			//�����ɼ�
			this.setVisible(true);
		}*/

		//������������˵��µġ����ڡ��˵���
		if(actionEvent.getSource()==jMenuHelpAbout)
		{
			About ab = new About();
			ab.background();
			ab.setVisible(true);
		}
		if(actionEvent.getSource()==jMenuSwitch)
		{
			setVisible(false);
			Login lg=new Login();
    		lg.background();
    		lg.setVisible(true);
		}
	}
	public static void main(String[] args) 
	{
		 new Manager().background();
	}
} 