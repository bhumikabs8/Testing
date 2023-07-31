package in.amazon.teststeps;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import in.amazon.pages.AllMobileBrands;
import in.amazon.pages.ApplePhones;
import in.amazon.pages.BuyPhone;
import in.amazon.pages.LandingPage;
import in.amazon.pages.SignIn;

public class Driver extends Tools
{
	//protected static WebDriver driver;
	protected static AllMobileBrands allMobileBrands;
	protected static LandingPage landingPage;
	protected static  ApplePhones applePhones;
	protected static  BuyPhone buyPhone;
	protected static SignIn signIn;
	
	public static void init()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://amazon.in");
	    landingPage = new LandingPage(driver);
	    allMobileBrands = new AllMobileBrands(driver);
	    applePhones = new ApplePhones(driver);
	    buyPhone = new BuyPhone(driver);
	    signIn = new SignIn(driver);
	}
}
