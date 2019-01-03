import java.io.FileOutputStream;
import java.sql.SQLException;

import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excel3 extends JFrame{
	@SuppressWarnings("null")
	public excel3() throws ClassNotFoundException, SQLException {
	      HSSFWorkbook wb = new HSSFWorkbook();
	      HSSFSheet sheet=wb.createSheet("���ڼ�¼����");
	      HSSFRow row2=sheet.createRow(1);//�����ʾ��һ��
	      row2.createCell(0).setCellValue("id");//createCell(0)��ʾ��һ�У�setCellValue("����")����һ�е�һ��д����
	      row2.createCell(1).setCellValue("����");    
	      row2.createCell(2).setCellValue("��");
	      row2.createCell(3).setCellValue("��");
	      row2.createCell(4).setCellValue("��");
	      String sql = "select * from report";
	      SqlOperation conn = new SqlOperation();
	      conn.operation(sql, 1);
	      while (conn.result2.next()) {
	    	  int row1 = sheet.getLastRowNum();
	    	  HSSFRow row = sheet.createRow(row1+1);
	    	  row.createCell(0).setCellValue(conn.result2.getString("id"));
	    	  row.createCell(1).setCellValue(conn.result2.getString("name"));    
	    	  row.createCell(2).setCellValue(conn.result2.getString("year"));
	    	  row.createCell(3).setCellValue(conn.result2.getString("month"));
	    	  row.createCell(4).setCellValue(conn.result2.getString("day"));
	      }
	      
	      conn.statement.close();
	      conn.connection.close();
	     
	//���Excel�ļ�
	      try {			
	    	 FileOutputStream fout = new FileOutputStream("D:/���ڼ�¼����.xls");//���ɵ�D�̣��ļ���������ҵ������		
	    	 wb.write(fout);		
	    	 fout.close();	
	      } catch (Exception e) {			
	    	  e.printStackTrace();		
	    	  }
	}

}
