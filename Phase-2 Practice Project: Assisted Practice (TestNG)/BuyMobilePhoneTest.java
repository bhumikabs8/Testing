package in.amazon.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import in.amazon.pages.AllMobileBrands;
import in.amazon.pages.ApplePhones;
import in.amazon.pages.BuyPhone;
import in.amazon.pages.LandingPage;
import in.amazon.pages.SignIn;

public class BuyMobilePhoneTest extends BaseTest 
{
	
	@Test
	public void buyMobile()
	{
		// 4) Click on 'Mobiles' in the navigation bar
		LandingPage landingPage = new LandingPage(driver); //class object = new class();
		landingPage.clickMobiles(); //object.method()
		
		// 5) Hover the pointer over 'Mobiles and Accessories'
		AllMobileBrands allMobilesBrands = new AllMobileBrands(driver);
		allMobilesBrands.hoverOverMobilesAndAccessories();
		
		// 6) Click on 'Apple' in the Sub-menu
		allMobilesBrands.clickApple();
		
		// 7) Click on first available phone.
		ApplePhones applePhones = new ApplePhones(driver);
		applePhones.clickFirstMobile();
		
		// 8) Switch focus on new tab
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		// 9) Click on 'Buy now' Button
		BuyPhone buyPhone = new BuyPhone(driver);
		buyPhone.clickBuyNowBtn();
		
		// 10) Verify user sees the text 'sign in' on the last page.
		SignIn signIn = new SignIn(driver);
		String expectedText = "Sign in";
		String actualText = signIn.getSignInText();
		Assert.assertEquals(actualText, expectedText);
	}
	

	
}
