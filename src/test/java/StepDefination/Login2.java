package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login2 {
	
	WebDriver driver = new ChromeDriver();
	
//	@Test(dataProvider="CredentialSupplier")
//	public void LoginTest(String username, String password)
//	{
//		System.out.println(username+"-----"+password);
//	}
//	
	@Before("@test2")
//	@DataProvider(name="CredentialSupplier")
	public void before() throws IOException {
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
					// System.out.println(data[r][c]);
					 break;
				 case NUMERIC:
					 data[r][c] = Integer.toString((int)cell.getNumericCellValue());
					// System.out.println(data[r][c]);
					 break;
				 case BOOLEAN:
					 data[r][c] = cell.getBooleanCellValue();
					 break;
				 }
				 
			}
			//System.out.println(data);
		}
		for (int r=0;r<rowCount;r++)
		{
			for(int c=0;c<colCount;c++) {
				{
					System.out.println(data[r][c]);
				}
			}
		}
	//return data;
	}

	public void takeScreenshot(String name) throws IOException
	{
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileHandler.copy(file, new File("C:/Users/saran/eclipse-workspace/SeleniumProject/target/ScreenShots/"+name+".jpg"));
	}
	
	
	
	@Given("the username and password to login")
	public void the_username_and_password_to_login() throws IOException {
		driver.navigate().to("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		takeScreenshot("login Page 2");
	    	}
		

	@And("processed with submit button")
	public void processed_with_submit_button() {
	    
	}

	@When("able to login")
	public void able_to_login() {
	   
	}

	@Then("verify the UI")
	public void verify_the_ui() {
	    
	}

}
