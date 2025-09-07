package StepDefination;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v121.network.model.Request;
//import org.openqa.selenium.devtools.v121.network.model.Request;
import org.openqa.selenium.devtools.v121.network.model.Response;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.graph.Network;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonLogin {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	@Given("the url to open amazon")
	public void the_url_to_open_amazon() throws InterruptedException {
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

	    
	    driver.get("https://amazon.com");  
	}

	@And("click on SignIn")
	public void click_on_SignIn() {

		driver.findElement(By.xpath("//button[@aria-label='Expand Account and Lists']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='nav-action-inner'][contains(text(),'Sign in')]")));
		
		driver.findElement(By.xpath("//span[@class='nav-action-inner'][contains(text(),'Sign in')]")).click();
		
	}



}
