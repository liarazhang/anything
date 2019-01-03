import java.io.FileOutputStream;
import java.sql.SQLException;

import javax.swing.JFrame;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excel extends JFrame{
	public excel() throws ClassNotFoundException, SQLException {
	      HSSFWorkbook wb = new HSSFWorkbook();
	      HSSFSheet sheet=wb.createSheet("����ҵ������");
	      HSSFRow row2=sheet.createRow(1);//�����ʾ��һ��
	      row2.createCell(0).setCellValue("����");//createCell(0)��ʾ��һ�У�setCellValue("����")����һ�е�һ��д����
	      row2.createCell(1).setCellValue("������"); 
	      row2.createCell(2).setCellValue("����"); 
	      row2.createCell(3).setCellValue("��λ"); 
	      row2.createCell(4).setCellValue("����"); 
	      String sql = "select * from salescondition";
	      SqlOperation conn = new SqlOperation();
	      conn.operation(sql, 1);
	      while (conn.result2.next()) {
	    	  int row1 = sheet.getLastRowNum();
	    	  HSSFRow row = sheet.createRow(row1+1);
	    	  String year = conn.result2.getString("year");
	    	  String month = conn.result2.getString("month");
	    	  String day = conn.result2.getString("day");
	    	  row.createCell(0).setCellValue(year+"-"+month+"-"+day);
	    	  row.createCell(1).setCellValue(conn.result2.getString("name"));
	    	  row.createCell(2).setCellValue(conn.result2.getString("count"));
	    	  row.createCell(3).setCellValue(conn.result2.getString("unit"));
	    	  row.createCell(4).setCellValue(conn.result2.getString("price"));
	      }
	//���Excel�ļ�
	      try {			
	    	 FileOutputStream fout = new FileOutputStream("D:/����ҵ������.xls");//���ɵ�D�̣��ļ���������ҵ������		
	    	 wb.write(fout);		
	    	 fout.close();	
	      } catch (Exception e) {			
	    	  e.printStackTrace();		
	    	  }
	}

}
