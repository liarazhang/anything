import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

//panel2 �ͻ�����

public class pan2 {
	public static JTable tab=null ;
	private DefaultTableModel defaultTableModel;
    private TableColumn column;
	 public static JScrollPane scro3=null ;
	public pan2() {
		//��ʾ���пͻ���Ϣ
		String[] n1 = { "", "", "", "",""};
        Object[][] p = { n1 };
        
        String[] n = {"����","��˾����","��ϵ��","��ϵ��ʽ","������" };

        defaultTableModel = new DefaultTableModel(p, n); // ��˫���鴴��DefaultTableModel����
        tab = new JTable(defaultTableModel);// ����������
        JTableHeader head = tab.getTableHeader(); // �������������
        head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
        head.setFont(new Font("����", Font.PLAIN, 18));// ���ñ������
        tab.setRowHeight(18);// ���ñ���п�

        tab.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// �������ñ���п�
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
