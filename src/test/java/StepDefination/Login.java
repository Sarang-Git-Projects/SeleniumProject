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
import org.testng.Assert;

import com.google.common.graph.Network;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver = null;
	@Given("the username and password to login into gmail")
	public void the_username_and_password_to_login_into_gmail() throws InterruptedException {
		
		driver = new ChromeDriver();
		
//		driver.get("https://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		//List<WebElement> text = driver.findElements(By.id("identifierId"));
		//Assert.assertEquals(driver.findElements(By.id("identifierId")), null);
		//driver.manage().wait();
//		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Email or phone')]")).getText(),"Email or phone"); //assert are imported from testng
//		driver.findElement(By.id("identifierId")).click();
//		driver.findElement(By.id("identifierId")).sendKeys("sarangsingh425@gmail.com");
//		driver.findElement(By.id("identifierId")).isDisplayed();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
//		String text = driver.findElement(By.xpath("//span[contains(text(),'Next')]")).getText();
//		System.out.println(text);
//		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000));
//		//WebDriver wait = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
//		//driver.findElement(By.className("WpHeLc VfPpkd-mRLv6 VfPpkd-RLmnJb")).click();
//	    System.out.println("1");
//	    //driver.quit();
	    
		
		//log files -----
	    DevTools devTools = ((HasDevTools) driver).getDevTools();
	    devTools.createSession();
	   devTools.send(org.openqa.selenium.devtools.v121.network.Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	    //devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	    
	    
	    devTools.addListener(org.openqa.selenium.devtools.v121.network.Network.requestWillBeSent(), request ->
	    {
	    	Request req = request.getRequest();
	    	System.out.println("**");
	    	System.out.println(req.getUrl());
	    	System.out.println("***");
	    	System.out.println(req.getHeaders());
	    	System.out.println("****");
	    });
	    
	    //event will get fired
	    devTools.addListener(org.openqa.selenium.devtools.v121.network.Network.responseReceived(), response ->
	    		
	    		{
	    			Response res = response.getResponse();
	    			System.out.println("**");
	    			System.out.println(res.getUrl());
	    			System.out.println("***");
	    			System.out.println(res.getStatus());
	    			System.out.println("****");
	    			//response.getResponse().getStatus();
	    		});
	    
	    driver.get("https://google.com");  
	    driver.findElement(By.xpath("(//a[@class='gb_d'])[2]")).click();
	}

	@Given("processed with submit")
	public void processed_with_submit() {
		System.out.println("2");
	}

	@When("able to login into gmail")
	public void able_to_login_into_gmail() {
	    System.out.println("3");
	}

	@Then("verify the screens")
	public void verify_the_screens() {
		System.out.println("4");
		//driver.quit();
	}

}
