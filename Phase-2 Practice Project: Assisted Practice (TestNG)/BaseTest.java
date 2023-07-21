package in.amazon.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest 
{
	WebDriver driver;
	
	@BeforeTest
	public void launchApplication()
	{
		// 1) Open the browser
		driver = new ChromeDriver();
		
		// 2) Maximize it
		driver.manage().window().maximize();
		
		// 3) Navigate to https://www.amazon.in/
		driver.get("https://amazon.in");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}
