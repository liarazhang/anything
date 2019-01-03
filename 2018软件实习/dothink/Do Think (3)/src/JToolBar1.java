import java.awt.Component;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	 
import javax.swing.*;
import javax.swing.table.*;

public class JToolBar1 extends JFrame{
	 
	  //  private static final long serialVersionUID = 1L;
	    private JTable table = null;
	    //private DefaultTableModel model=null;
	    public static JScrollPane js=null ;
	    public JToolBar1(){
	        //model = new DefaultTableModel(3,10);
	    	
	    	//读取员工信息
	    	Object[][] str = {
	    			{20180101, "张娜", ""},
	    	};
	    	String[] title = {"员工编号", "员工姓名", "查看最近日报"};
	        table = new JTable(str, title);
	        table.getColumnModel().getColumn(2).setCellEditor(new MyRender());//设置编辑器
	        table.getColumnModel().getColumn(2).setCellRenderer(new MyRender() );
	        table.setRowHeight(35);
	        js = new JScrollPane(table);
	    }
	//渲染 器  编辑器
	   class MyRender extends AbstractCellEditor implements TableCellRenderer,ActionListener, TableCellEditor{
	 
	    //private static final long serialVersionUID = 1L;
	    private JButton button =null;
	    public MyRender(){
	        button = new JButton("查看");
	        button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		JFrame fram = new JFrame();
	        		fram.setResizable(false);
	        		TextArea tx = new TextArea("");
	        		JScrollPane je  = new JScrollPane(tx, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        		fram.add(je);
	        		fram.setBounds(0, 0, 400,400);
	        		fram.setBounds(600, 200, 400, 400);
	        		fram.setVisible(true);
	        		fram.setResizable(false);
	        		//弹窗内容为最近日报和日期
	        }
	        	
	        });
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
	    public void actionPerformed(ActionEvent e) {
	         
	         
	    }
	 
	@Override
	    public Component getTableCellEditorComponent(JTable table, Object value,
	            boolean isSelected, int row, int column) {
	        // TODO Auto-generated method stub
	        return button;
	    }
	     
	}
	
}
	

