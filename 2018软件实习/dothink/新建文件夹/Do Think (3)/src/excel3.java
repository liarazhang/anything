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
	      HSSFSheet sheet=wb.createSheet("考勤记录报表");
	      HSSFRow row2=sheet.createRow(1);//这里表示第一行
	      row2.createCell(0).setCellValue("id");//createCell(0)表示第一列，setCellValue("姓名")往第一行第一列写东西
	      row2.createCell(1).setCellValue("姓名");    
	      row2.createCell(2).setCellValue("年");
	      row2.createCell(3).setCellValue("月");
	      row2.createCell(4).setCellValue("日");
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
	     
	//输出Excel文件
	      try {			
	    	 FileOutputStream fout = new FileOutputStream("D:/考勤记录报表.xls");//生成到D盘，文件名：销售业绩报表		
	    	 wb.write(fout);		
	    	 fout.close();	
	      } catch (Exception e) {			
	    	  e.printStackTrace();		
	    	  }
	}

}
