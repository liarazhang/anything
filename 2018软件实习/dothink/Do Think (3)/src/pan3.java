import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

//panel3 �������
public class pan3 extends JFrame{
	public static String[] n2 = { "", "", "", "", "", "", "" };
	public static JTable table= null;
    private DefaultTableModel defaultTableModel;
    private TableColumn column;
	 public static JScrollPane scro2=null ;
	public pan3() {
		//��ȡ�������
		String[] n2 = { "", "", "", "", "", "", "" };
        Object[][] p = { n2 };
        String[] n = {"����", "��Ʒ", "�ͻ�", "������", "����","��λ", "����" };

        defaultTableModel = new DefaultTableModel(p, n); // ��˫���鴴��DefaultTableModel����
        table = new JTable(defaultTableModel);// ����������
        JTableHeader head = table.getTableHeader(); // �������������
        head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
        head.setFont(new Font("����", Font.PLAIN, 18));// ���ñ������
        table.setRowHeight(18);// ���ñ���п�

        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// �������ñ���п�
        for (int i = 0; i < 7; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(50);
            }

	}
         scro2 = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
}
}
