package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GridDemoo 
{
	WebDriver driver;
	
	@BeforeTest
	public void launchApplication() throws MalformedURLException 
	{
		//specify the capabilities of the node where the test case is to be executed using DesiredCapabilited class.
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://facebook.com");
	}
	
	@Test
	public void titleVerification()
	{
		//3) verify the visitor on the page sees the title - 'facebook - log in or sign up'
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
