//package TestNG_testing;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//public class SampleTestNG_test {
//	
//	    WebDriver driver;  // ⚠️ This must be separate per thread
//
//	    @Parameters("browser")
//	    @Test
//	    public void launchApp(String browser) {
//	        if (browser.equalsIgnoreCase("chrome")) {
//	            driver = new ChromeDriver();
//	        } else if (browser.equalsIgnoreCase("firefox")) {
//	            driver = new FirefoxDriver();
//	        } else if (browser.equalsIgnoreCase("edge")) {
//	            driver = new EdgeDriver();
//	        }
//
//	        driver.get("https://example.com");
//	        System.out.println("Browser: " + browser + " | Title: " + driver.getTitle());
//	        driver.quit();
//	    }
//
//}
