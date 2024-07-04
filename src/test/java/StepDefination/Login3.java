package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

public class Login3 {
	
//	WebDriver driver = null;
	@Given("a {string} and {string} to login")
	public void a_and_to_login(String string, String string2) {
//		driver = new ChromeDriver();
//		
////		driver.get("https://gmail.com");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        
//        // JavaScript to intercept fetch requests
//        String fetchInterceptor = "(() => {" +
//            "const originalFetch = fetch;" +
//            "window.fetch = (...args) => {" +
//            "  return originalFetch(...args).then(response => {" +
//            "    console.log('Fetch request to:', response);" +
//            "    return response;" +
//            "  });" +
//            "};" +
//            "})();";
//        
//        // Navigate to the desired webpage
//        driver.get("https://www.google.com");
//        
//        // Execute the JavaScript to intercept fetch requests
//        js.executeScript(fetchInterceptor);
//        
//        // Perform actions on the page
//        // Example: Click a button to trigger network requests
////        WebElement button = driver.findElement(By.id("button-id"));
////        button.click();
//        
//        // Retrieve logs from the browser console
//        List logs = driver.manage().logs().get("browser").getAll();
//        System.out.println("testing");
//        logs.forEach(System.out::println);
		
		
		
		
		ChromeOptions options = new ChromeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
        //options.setCapability("goog:loggingPrefs", LogType.PERFORMANCE);
		options.setCapability("goog:loggingPrefs", logPrefs);
        // Initialize the Chrome WebDriver with logging capabilities
        WebDriver driver = new ChromeDriver(options);
        driver = new ChromeDriver();
		
//		driver.get("https://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        // JavaScript to intercept fetch and XMLHttpRequest requests
        String networkInterceptor = """
            (function() {
                // Intercept Fetch API
                const originalFetch = fetch;
                window.fetch = function(...args) {
                    return originalFetch.apply(this, args).then(response => {
                        response.clone().text().then(body => {
                            console.log('Fetch request to:', args[0]);
                            console.log('Fetch response from:', args[0], body);
                        });
                        return response;
                    });
                };

                // Intercept XMLHttpRequest
                const originalXhrOpen = XMLHttpRequest.prototype.open;
                XMLHttpRequest.prototype.open = function(method, url) {
                    this.addEventListener('load', function() {
                        console.log('XHR request to:', url);
                        console.log('XHR response from:', url, this.responseText);
                    });
                    originalXhrOpen.apply(this, arguments);
                };
            })();
        """;

        // Navigate to the desired webpage
        driver.get("https://www.google.com");

        // Execute the JavaScript to intercept network requests
        ((JavascriptExecutor) driver).executeScript(networkInterceptor);

        // Perform actions on the page, e.g., click a button to trigger network requests
        // Example:
        // WebElement button = driver.findElement(By.id("button-id"));
        // button.click();

        // Give the page some time to perform network requests
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Retrieve logs from the browser console
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log : logs) {
            System.out.println(log.getMessage());
        }
		
	}

	@And("processed with the submit button")
	public void processed_with_the_submit_button() {
	    System.out.println("1");
	}

	@When("able to login  into gmail")
	public void able_to_login_into_gmail() {
		System.out.println("2");
	}

	@Then("verify the UI screen")
	public void verify_the_ui_screen() {
		System.out.println("3");
	}
}
