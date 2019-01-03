import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

//panel2 客户管理

public class pan2 {
	public static JTable tab=null ;
	private DefaultTableModel defaultTableModel;
    private TableColumn column;
	 public static JScrollPane scro3=null ;
	public pan2() {
		//显示所有客户信息
		String[] n1 = { "", "", "", "",""};
        Object[][] p = { n1 };
        
        String[] n = {"日期","公司名称","联系人","联系方式","负责人" };

        defaultTableModel = new DefaultTableModel(p, n); // 用双数组创建DefaultTableModel对象
        tab = new JTable(defaultTableModel);// 创建表格组件
        JTableHeader head = tab.getTableHeader(); // 创建表格标题对象
        head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头大小
        head.setFont(new Font("楷体", Font.PLAIN, 18));// 设置表格字体
        tab.setRowHeight(18);// 设置表格行宽

        tab.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// 以下设置表格列宽
        for (int i = 0; i < 5; i++) {
            column = tab.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(50);
            }

	}
         scro3 = new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
}
}
