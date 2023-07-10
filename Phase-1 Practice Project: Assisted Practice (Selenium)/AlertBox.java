package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBox 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//1) Open the browser
		ChromeDriver driver = new ChromeDriver();
		
		//2) Maximize it
		driver.manage().window().maximize();
		
		//3) Navigate to application
		driver.get("https://retail.onlinesbi.sbi/retail/login.htm");
		
		//4) Click on 'CONTINUE TO LOGIN' button
		driver.findElement(By.linkText("CONTINUE TO LOGIN")).click();
		
		//5) click on 'Login' button
		driver.findElement(By.id("Button2")).click();
		
		Thread.sleep(300);
		
		//6) Close the Alert Box
		driver.switchTo().alert().accept();

	}

}

