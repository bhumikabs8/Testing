package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatedCSSandXpath {
	
	public static void main(String[] args) {
		// 1. Open the browser
		ChromeDriver driver = new ChromeDriver();
		
		// 2. Navigate to application
		driver.get("https://facebook.com");
		
		// 3.Enter invalid username 'batman554466@gmail.com' in the Email address or phone number ' textbox
		driver.findElement(By.id("email")).sendKeys("batman554466@gmail.com");
		
		// 4.Enter invalid password ' password@123' in the 'Password' textbox
		driver.findElement(By.id("pass")).sendKeys("password@123");                 
		
		//5. Click Login button
		driver.findElement(By.name("login")).click();
		
		// 6. Verify user sees the error message - "The email address you entered isn't connected to an account .Find your account and log in
		String expectedErrMsg = "The email address you entered isn't connected to an account. Find your account and log in.";
		
		//String acutalErrMsg = driver.findElement(By.cssSelector("#email_container > div._9ay7")).getText();
		String acutalErrMsg = driver.findElement(By.xpath("(//div[contains(@class,'ay')])[3]")).getText();
		
		
		if(expectedErrMsg.equals(acutalErrMsg)) {
			System.out.println("Test case Passed");
		}
		else {
			System.out.println("Test Case Failed");
		}
		
		//7) Close the Browser
		driver.quit();
	}
}
