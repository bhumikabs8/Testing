package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWaitDemo 
{
ChromeDriver driver;
	
	@BeforeTest
	public void launchApplication()
	{
		//1) Open the browser
		driver = new ChromeDriver();
		
		//2) Maximize it
		driver.manage().window().maximize();
				
		//2) navigate to application
		//object.method()
		driver.get("https://whitecircleschool.com/explicit-wait-demo1/");
	}
	
	@Test
	public void titleVerification() 
	{
		//4) Click on 'Start' button
		driver.findElement(By.id("start")).click();
				
		//5) Verify the text 'Hello World!' appears on the Web-page
		String expectedText = "Hello World!";
				
		//Wait for the text to appear
		WebDriverWait Wait= new WebDriverWait(driver, Duration.ofSeconds(60));//Wait for a max time of 60 seconds.
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4")));
				
		String actualText = driver.findElement(By.cssSelector("#finish > h4")).getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}
