import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class newpan1 {
	
	public static JTabbedPane jtp;
	public JScrollPane jn=null ;
	public newpan1() {
		jtp = new JTabbedPane();
		JPanel pann1 = new JPanel();
		JPanel pann2 = new JPanel();
		jtp.add("��ȡ��Ϣ", pann1);
		jtp.add("Ա����Ϣ", pann2);
		jtp.setFont(new Font("΢���ź�", Font.ITALIC, 18));
		jtp.setSelectedIndex(0);
		
		JLabel lab1 = new JLabel("������" );
		JTextField name = new JTextField("����");
		name.setEditable(false); 
		JLabel lab4 = new JLabel("Ӣ������");
		JTextField name2 = new JTextField("zhangna");
		name2.setEditable(false) ;
		JLabel lab2 = new JLabel("�Ա�");
		JTextField name3 = new JTextField("Ů");
		name3.setEditable(false) ;
		JLabel lab3 = new JLabel("֤�����룺" );
		JTextField name4 = new JTextField("123456789");
		name4.setEditable(false) ;
		JLabel lab5 = new JLabel("ְ��" );
		JTextField name5 = new JTextField("CEO");
		name5.setEditable(false) ;
		JLabel lab6 = new JLabel("��ϵ��ʽ��" );//
		JTextField name6 = new JTextField("15847697654");
		name6.setEditable(false) ;
		JLabel lab7 = new JLabel();//
		URL ur = Thread.currentThread().getContextClassLoader().getResource("11.jpg");
		Icon icon = new ImageIcon(ur);
		lab7.setIcon(icon);
		
		lab1.setFont(new Font("΢���ź�", Font.BOLD, 20));
		name.setFont(new Font("΢���ź�", Font.BOLD, 20));
		name2.setFont(new Font("΢���ź�", Font.BOLD, 20));
		name3.setFont(new Font("΢���ź�", Font.BOLD, 20));
		name4.setFont(new Font("΢���ź�", Font.BOLD, 20));
		name5.setFont(new Font("΢���ź�", Font.BOLD, 20));
		name6.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lab1.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lab2.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lab3.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lab4.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lab5.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lab6.setFont(new Font("΢���ź�", Font.BOLD, 20));
		pann1.setLayout(null);
		lab1.setBounds(50, 50, 100, 20);
		name.setBounds(150, 45, 200, 30);
		lab2.setBounds(50, 100, 500, 20);
		name3.setBounds(150, 95, 200, 30);
		lab3.setBounds(50, 150, 500, 20);
		name4.setBounds(150,145, 200, 30);
		lab4.setBounds(50, 200, 500, 20);
		name2.setBounds(150, 195,200, 30);
		lab5.setBounds(50, 250, 500, 20);
		name5.setBounds(150, 245,200, 30);
		lab6.setBounds(50, 300, 500, 20);
		name6.setBounds(150, 295,200, 30);
		lab7.setBounds(500, 0, 300,300);//��
	    pann1.add(lab1);
	    pann1.add(lab4);
	    pann1.add(lab2);
	    pann1.add(lab3);
	    pann1.add(lab5);
	    pann1.add(lab6);
	    pann1.add(lab7);
	    pann1.add(name);
		pann1.add(name2);
		pann1.add(name3);
		pann1.add(name4);
		pann1.add(name5);
		pann1.add(name6);
	    
	    JToolBar2();
	    pann2.setLayout(new BorderLayout());
	    pann2.add(jn);   
	}
	    public void JToolBar2(){
	    	Object[][] str = {
	    			{12345678, "����", ""},
	    	};
	    	String[] title = {"���", "Ա������", "�鿴"};
	        JTable table2 = new JTable(str, title);
	        table2.getColumnModel().getColumn(2).setCellEditor(new MyRender());//���ñ༭��
	        table2.getColumnModel().getColumn(2).setCellRenderer(new MyRender());
	        table2.setRowHeight(35);
	        jn = new JScrollPane(table2);
	    }
	//��Ⱦ ��  �༭��
	   class MyRender extends AbstractCellEditor implements TableCellRenderer,ActionListener, TableCellEditor{
	    private JButton button =null;
	    public MyRender(){
	        button = new JButton("�鿴");
	        button.addActionListener(this);
	    }
	@Override
	    public Object getCellEditorValue() {
	        // TODO Auto-generated method stub
	        return null;
	    }
	 
	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value,
	            boolean isSelected, boolean hasFocus, int row, int column) {
	        // TODO Auto-generated method stub
	        return button;
	    }
	 
	@Override
	    public Component getTableCellEditorComponent(JTable table, Object value,
	            boolean isSelected, int row, int column) {
	        // TODO Auto-generated method stub
	        return button;
	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		
		JLabel lab1 = new JLabel("������" );
		JTextField name = new JTextField("����");
		name.setEditable(false); 
		JLabel lab4 = new JLabel("Ӣ������");
		JTextField name2 = new JTextField("zhangna");
		name2.setEditable(false) ;
		JLabel lab2 = new JLabel("�Ա�");
		JTextField name3 = new JTextField("Ů");
		name3.setEditable(false) ;
		JLabel lab3 = new JLabel("֤�����룺" );
		JTextField name4 = new JTextField("123456789");
		name4.setEditable(false) ;
		JLabel lab5 = new JLabel("ְ��" );
		JTextField name5 = new JTextField("CEO");
		name5.setEditable(false) ;
		JLabel lab6 = new JLabel("��ͥסַ��" );//
		JTextField name6 = new JTextField("�����ʵ��ѧѧʮ��");
		name6.setEditable(false) ;
		JLabel lab7 = new JLabel();//
		JButton xg = new JButton("�޸�");
		JButton xg1 = new JButton("����");
		URL ur = Thread.currentThread().getContextClassLoader().getResource("6.png");
		Icon icon = new ImageIcon(ur);
		lab7.setIcon(icon);
		
		xg.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		name.setEditable(true); 
        		name5.setEditable(true); 
        		name2.setEditable(true); 
        		name3.setEditable(true); 
        		name4.setEditable(true); 
        		name6.setEditable(true); 
        	}
        	});
		xg1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		name.setEditable(false); 
        		name5.setEditable(false); 
        		name2.setEditable(false); 
        		name3.setEditable(false); 
        		name4.setEditable(false); 
        		name6.setEditable(false); 
        	}
        	});
		
		frame.setLayout(null);
		lab1.setBounds(20, 30, 100, 20);
		name.setBounds(60, 30, 100, 20);
		lab2.setBounds(20, 80, 500, 20);
		name3.setBounds(60, 80, 100, 20);
		lab3.setBounds(20, 130, 500, 20);
		name4.setBounds(80, 130, 100, 20);
		lab4.setBounds(20, 180, 500, 20);
		name2.setBounds(70, 180, 100, 20);
		lab5.setBounds(20, 230, 500, 20);
		name5.setBounds(60, 230, 100, 20);
		lab6.setBounds(20, 280, 500, 20);
		name6.setBounds(80, 280, 200, 20);
		lab7.setBounds(200, 50, 500,500);//��
		xg.setBounds(120, 310, 60,30);
		xg1.setBounds(210, 310, 60,30);
		frame.add(lab1);
		frame.add(lab2);
		frame.add(lab3);
		frame.add(lab4);
		frame.add(lab5);
		frame.add(lab6);
		frame.add(lab7);
		frame.add(xg);
		frame.add(xg1);
		frame.add(name);
		frame.add(name2);
		frame.add(name3);
		frame.add(name4);
		frame.add(name5);
		frame.add(name6);
		frame.setTitle("Ա����Ϣ");
		frame.setSize(400, 400);
		frame.setLocation(500, 200);
		frame.setVisible(true);
		
	}
	     
	}


}
