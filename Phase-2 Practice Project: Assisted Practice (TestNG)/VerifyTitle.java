package demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTitle 
{
	ChromeDriver driver;
	
	@BeforeTest
	public void launchApplication()
	{
		//1) Open the browser
		driver = new ChromeDriver();
				
		//2) navigate to application
		//object.method()
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void titleVerification() 
	{
		//3) Verify the visitor on the page sees the title - 'facebook - log in or sing up'
		String expectedTitle ="Facebook – log in or sign up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}
