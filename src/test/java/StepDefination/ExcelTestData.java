package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTestData {
	
	@Test(dataProvider="CredentialSupplier")
	public void LoginTest(String username, String password)
	{
		System.out.println(username+"-----"+password);
	}
	
	@DataProvider(name="CredentialSupplier")
	public Object[][] dataSupplier() throws IOException {
		File excelFile = new File(System.getProperty("user.dir")+"\\TestData.xlsx");
		FileInputStream fileInp = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInp);
		
		//access sheet
		XSSFSheet sheet = workbook.getSheet("login");
		
		//returning no of rows 
		
		int rowCount = sheet.getLastRowNum();
		
		
		//returning no of columns
		int colCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount][colCount];
		
		for (int r=0;r<rowCount;r++) {
			XSSFRow row = sheet.getRow(r+1);
			for(int c=0;c<colCount;c++) {
				XSSFCell cell = row.getCell(c);
				 CellType cellType = cell.getCellType();
				 
				 switch(cellType) {
				 case STRING:
					 data[r][c] = cell.getStringCellValue();
					 break;
				 case NUMERIC:
					 data[r][c] = Integer.toString((int)cell.getNumericCellValue());
					 break;
				 case BOOLEAN:
					 data[r][c] = cell.getBooleanCellValue();
					 break;
				 }
				 
			}
			//System.out.println(data);
		}
		
	return data;
	}

}
