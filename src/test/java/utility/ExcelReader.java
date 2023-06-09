package utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static Object[][] getValueFromExcel(String dataExcelName) {
		
		Object[][] data = null;
		
		try {
			
			String file = "./data/"+dataExcelName+".xlsx";
			FileInputStream read = new FileInputStream(file);
			XSSFWorkbook work = new XSSFWorkbook(read);
			XSSFSheet sheet = work.getSheetAt(0);
			
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			data = new Object[rowCount][colCount];
			for(int i=1;i<=rowCount;i++) {
				try {
					XSSFRow row = sheet.getRow(i);
					
					for(int j=0;j<colCount;j++) {
						try {
							
							Object cellValue = "";
							try {
								XSSFCell cell = row.getCell(j);
								CellType cellType = cell.getCellType();
								switch (cellType) {
								case NUMERIC:
									cellValue = (int) cell.getNumericCellValue();
									break;
									
								case STRING:
									cellValue = cell.getStringCellValue();
									break;
									
								default:
									System.out.print(cell.getErrorCellValue() + "\t");
									break;
								}
								
							}catch(NullPointerException e) {
								
							}
						data[i-1][j] = cellValue;
						}catch(Exception e){
							e.printStackTrace();
						}
						
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			work.close();
			read.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
