package Face;

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
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class pan1 {
	public static JTabbedPane jtp;
	public JScrollPane jn = null ;
	public pan1() {
		jtp = new JTabbedPane();
		JPanel pann1 = new JPanel();
		JPanel pann2 = new JPanel();
		jtp.add("��ȡ��Ϣ", pann1);
		jtp.add("Ա����Ϣ", pann2);
		jtp.setFont(new Font("΢���ź�", Font.ITALIC, 18));
		jtp.setSelectedIndex(0);
		
		JLabel lab1 = new JLabel("������" + "����");
		JLabel lab4 = new JLabel("Ӣ������" + "zhangna");
		JLabel lab2 = new JLabel("�Ա�" + "Ů");
		JLabel lab3 = new JLabel("֤�����룺" + 123456789);
		JLabel lab5 = new JLabel("ְ��" + "CEO");
		JLabel lab6 = new JLabel("���˼�飺" );//
		JLabel lab7 = new JLabel();//
		URL ur = Thread.currentThread().getContextClassLoader().getResource("6.png");
		Icon icon = new ImageIcon(ur);
		lab7.setIcon(icon);
		
		lab1.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lab2.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lab3.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lab4.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lab5.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lab6.setFont(new Font("΢���ź�", Font.BOLD, 20));
		pann1.setLayout(null);
		lab1.setBounds(50, 50, 100, 20);
		lab2.setBounds(50, 100, 500, 20);
		lab3.setBounds(50, 150, 500, 20);
		lab4.setBounds(50, 200, 500, 20);
		lab5.setBounds(50, 250, 500, 20);
		lab6.setBounds(50, 300, 500, 20);
		lab7.setBounds(200, 50, 500,500);//��
	    pann1.add(lab1);
	    pann1.add(lab4);
	    pann1.add(lab2);
	    pann1.add(lab3);
	    pann1.add(lab5);
	    pann1.add(lab6);
	    pann1.add(lab7);
	    
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
	    	
	    	public Object getCellEditorValue() {
	    		return null;
	    	}
	 
	    	public Component getTableCellRendererComponent(JTable table, Object value,
	            boolean isSelected, boolean hasFocus, int row, int column) {
	    		return button;
	    	}
	 
	    	public Component getTableCellEditorComponent(JTable table, Object value,
	            boolean isSelected, int row, int column) {
	    		return button;
	    	}
	    	public void actionPerformed(ActionEvent e) {
	    		JFrame frame = new JFrame();
		
	    		JLabel lab1 = new JLabel("������" + "����");
	    		JLabel lab4 = new JLabel("Ӣ������" + "zhangna");
	    		JLabel lab2 = new JLabel("�Ա�" + "Ů");
	    		JLabel lab3 = new JLabel("֤�����룺" + 123456789);
	    		JLabel lab5 = new JLabel("ְ��" + "CEO");
	    		JLabel lab6 = new JLabel("���˼�飺" );//
	    		JLabel lab7 = new JLabel();//
	    		URL ur = Thread.currentThread().getContextClassLoader().getResource("6.png");
	    		Icon icon = new ImageIcon(ur);
	    		lab7.setIcon(icon);
		
	    		frame.setLayout(null);
	    		lab1.setBounds(50, 50, 100, 20);
	    		lab2.setBounds(50, 100, 500, 20);
	    		lab3.setBounds(50, 150, 500, 20);
	    		lab4.setBounds(50, 200, 500, 20);
	    		lab5.setBounds(50, 250, 500, 20);
	    		lab6.setBounds(50, 300, 500, 20);
	    		lab7.setBounds(200, 50, 500,500);//��
	    		frame.add(lab1);
	    		frame.add(lab2);
	    		frame.add(lab3);
	    		frame.add(lab4);
	    		frame.add(lab5);
	    		frame.add(lab6);
	    		frame.add(lab7);
	    		frame.setTitle("Ա����Ϣ");
	    		frame.setSize(400, 400);
	    		frame.setLocation(500, 200);
	    		frame.setVisible(true);
		
	    	}
	     
	    }

}

