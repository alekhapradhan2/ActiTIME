package Utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Xlutils {

	
	/**
	 * 
	 * @author Pratik
	 *
	 *This class will perform the operation of excels
	 *
	 *
	 */
	public class ExcelUtility {
		
		/**
		 * This method will fetch the single data from excel
		 * 
		 * @param path-->It is use to provide the path of excel
		 * @param sheet-->sheet name of excel
		 * @param row-->Row of excel
		 * @param cell-->Cell of excel
		 * @return-->String format return
		 * @throws Throwable
		 */
		public String singleDataFetch(String path,String sheet,int row,int cell ) throws Throwable {
			
			DataFormatter df= new DataFormatter();
			
			FileInputStream fis= new FileInputStream(path);
			
			Workbook book=WorkbookFactory.create(fis);
			
			String data= df.formatCellValue(book.getSheet(sheet).getRow(row).getCell(cell));
			
			return data;
		}
		
		/**
		 * This method will fetch the last row of the sheet
		 * @throws Throwable 
		 */
		public int lastRow(String path,String sheet) throws Throwable {
			FileInputStream fis =new FileInputStream(path);
			
			Workbook book= WorkbookFactory.create(fis);
			
			Sheet sh= book.getSheet(sheet);
			
			int lastRow=sh.getLastRowNum();
			return lastRow;
		}
		
		/**
		 * This method will 
		 * @throws Throwable 
		 * 
		 * 
		 */
		public int lastCell(String path, String sheet,int row) throws Throwable {
			FileInputStream fis= new FileInputStream(path);
			
			Workbook book=WorkbookFactory.create(fis);
			
			Sheet sh= book.getSheet(sheet);
			
			Row ro= sh.getRow(row);
			
			int lastCell=ro.getLastCellNum();
			return lastCell;
		}
		
		
	}
}
