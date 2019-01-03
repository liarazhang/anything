package Login;
//系统主界面类

//导入系统的包
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//创建主界面类
public class Manager extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//创建内容面板

	//创建菜单栏
	JMenuBar jMenuBarSM=new JMenuBar();
	JMenu jMenuStart=new JMenu("开始");
	JMenuItem jMenuStartOutport=new JMenuItem("导出");
	JMenu jMenuStudents=new JMenu("销售员管理");
	JMenuItem jMenuStuName=new JMenuItem("按姓名查询");
	JMenuItem jMenuStuId=new JMenuItem("按编号查询");
	JMenuItem jMenuStust=new JMenuItem("按地区查询");
	JMenuItem jMenuStuAll=new JMenuItem("所有人员");
	JMenu jMenuManage=new JMenu("人员管理");
	JMenuItem jMenuAddStu=new JMenuItem("添加销售员");
	JMenuItem jMenuDelStu=new JMenuItem("删除销售员");
	
	

	JMenu jMenuClass=new JMenu("销售单管理");
	JMenuItem jMenuOnClassId=new JMenuItem("按订单号查询");
	JMenuItem jMenuOnClassSt=new JMenuItem("按日期查询");
	JMenuItem jMenuOnClassAll=new JMenuItem("所有订单");
	JMenu jMenuManage2=new JMenu("订单管理");
	JMenuItem jMenuAddClass=new JMenuItem("添加销售单");
	JMenuItem jMenuDelClass=new JMenuItem("删除销售单");

	/*JMenu jMenuDepartment=new JMenu("业绩信息管理");
	JMenuItem jMenuOnDepId=new JMenuItem("按部门系编号查询");
	JMenuItem jMenuAddDep=new JMenuItem("添加部门系");
	JMenuItem jMenuDelDep=new JMenuItem("删除部门系");*/

	JMenu jMenuSet=new JMenu("设置");
	JMenuItem jMenuHelpAbout=new JMenuItem("关于");
	JMenuItem jMenuSwitch=new JMenuItem("切换账号");
	//创建标签，用于显示信息
	JLabel jLabel1=new JLabel("欢迎使用企业销售管理系统");
	JLabel jLabel2=new JLabel("2017年09月22日");
	
	
	
	//构造方法，创建对象时自动调用
	public Manager()
	{
		try{
			//关闭框架窗口时的默认事件方法
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			//调用初始化方法
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	//界面初始化方法
	private void jbInit() throws Exception
	{
		//创建内容面板和其布局
		setResizable(false);
		setLayout(null);
		//框架的大小和其标题
		setSize(new Dimension(600,420));
		setTitle("企业销售管理系统");
		//添加事件监听
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

		//添加菜单条
		setJMenuBar(jMenuBarSM);
		//添加菜单组件到菜单条
		jMenuBarSM.add(jMenuStart);
		jMenuBarSM.add(jMenuStudents);
		jMenuBarSM.add(jMenuClass);
		//jMenuBarSM.add(jMenuDepartment);
		jMenuBarSM.add(jMenuStartOutport);
		jMenuBarSM.add(jMenuSet);

		//添加菜单项组件到菜单组件
		jMenuStart.add(jMenuStartOutport);
		//销售员信息管理菜单下的选择：按姓名查询，按编号查询，添加销售员，删除销售员
		jMenuStudents.add(jMenuStuName);
		jMenuStudents.add(jMenuStuId);
		jMenuStudents.add(jMenuStuAll);
		jMenuStudents.add(jMenuManage);
		jMenuManage.add(jMenuAddStu);
		jMenuManage.add(jMenuDelStu);
		//销售单信息管理菜单下的选择：按订单号查询，添加销售单，删除销售单
		jMenuClass.add(jMenuOnClassId);
		jMenuClass.add(jMenuOnClassSt);
		jMenuClass.add(jMenuOnClassAll);
		jMenuClass.add(jMenuManage2);
		jMenuManage2.add(jMenuAddClass);
		jMenuManage2.add(jMenuDelClass);
		/*//业绩信息管理菜单下的选择：按系号查询，添加系，删除系
		jMenuDepartment.add(jMenuOnDepId);
		jMenuDepartment.add(jMenuAddDep);
		jMenuDepartment.add(jMenuDelDep);*/
		//帮助菜单下的
		jMenuSet.add(jMenuHelpAbout);
		jMenuSet.add(jMenuSwitch);

		//添加标签到内容面板
		add(jLabel1);
		add(jLabel2);
		//设置标签组件的大小和字体
		jLabel1.setFont(new java.awt.Font("华文楷体",Font.BOLD,35));
		jLabel1.setBounds(new Rectangle(77,120,475,55));
		jLabel1.setForeground(Color.BLACK);

		jLabel2.setFont(new java.awt.Font("华文楷体",Font.BOLD,16));
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
	
	//菜单事件的处理方法
	public void actionPerformed(ActionEvent actionEvent)
	{
		//点击“文件”菜单下的“退出”菜单项
		if(actionEvent.getSource()==jMenuStartOutport)
		{
			System.exit(0);
		}
		//点击“销售员查询”菜单下的“按姓名查询”菜单项
		if(actionEvent.getSource()==jMenuStuName)
		{
			//创建“按姓名查询”面板对象

			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			//令界面可见
			this.setVisible(true);
		}
		//点击“销售员查询”菜单下的“按编号查询”菜单项
		if(actionEvent.getSource()==jMenuStuId)
		{
			//创建“按编号查询”面板对象

			//移除主界面上原有的内容
			this.remove(this.getContentPane());

			//令界面可见
			this.setVisible(true);
		}
		//点击“销售员管理”菜单下的“添加销售员”菜单项
		if(actionEvent.getSource()==jMenuAddStu)
		{
			Addsp as = new Addsp();
	        as.background();
	        as.setVisible(true);
		}
		//点击“销售员管理”菜单下的“删除销售员”菜单项
		if(actionEvent.getSource()==jMenuDelStu)
		{
			Desp ds = new Desp();
	        ds.background();
	        ds.setVisible(true);
		}

		//点击“销售单信息管理”菜单下的“按订单号查询”菜单项
		if(actionEvent.getSource()==jMenuOnClassId)
		{
			//创建“订单号查询”面板对象

			//移除主界面上原有的内容
			this.remove(this.getContentPane());

			//令界面可见
			this.setVisible(true);
		}
		//点击“销售单管理”菜单下的“添加销售单”菜单项
		if(actionEvent.getSource()==jMenuAddClass)
		{
			Adddingdan ad = new Adddingdan();
	        ad.background();
	        ad.setVisible(true);
		}
		//点击“销售单管理”菜单下的“删除销售单”菜单项
		if(actionEvent.getSource()==jMenuDelClass)
		{
			Dedingdan d = new Dedingdan();
 	        d.background();
 	        d.setVisible(true);
		}

		/*//点击“业绩信息管理”菜单下的“按部门系编号查询”菜单项
		if(actionEvent.getSource()==jMenuOnDepId)
		{
			//创建“编号查询”面板对象
			InquireOnDepID onDepId=new InquireOnDepID();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(onDepId);
			//令界面可见
			this.setVisible(true);
		}

		//点击“部门系管理”菜单下的“添加部门系”菜单项
		if(actionEvent.getSource()==jMenuAddDep)
		{
			//创建添加班级面板对象
			AddDepartment addDep=new AddDepartment();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(addDep);
			//令界面可见
			this.setVisible(true);
		}

		//点击“部门系管理”菜单下的“删除部门系”菜单项
		if(actionEvent.getSource()==jMenuDelDep){
			//创建删除班级面板对象
			DelDepartment delDep=new DelDepartment();
			//移除主界面上原有的内容
			this.remove(this.getContentPane());
			this.setContentPane(delDep);
			//令界面可见
			this.setVisible(true);
		}*/

		//点击“帮助”菜单下的“关于”菜单项
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