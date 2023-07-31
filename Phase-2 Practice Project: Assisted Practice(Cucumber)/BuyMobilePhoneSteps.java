package in.amazon.teststeps;

import java.util.ArrayList;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//import in.amazon.pages.AllMobileBrands;
//import in.amazon.pages.ApplePhones;
//import in.amazon.pages.BuyPhone;
//import in.amazon.pages.LandingPage;
//import in.amazon.pages.SignIn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyMobilePhoneSteps extends Driver
{
   //WebDriver driver;
  //AllMobileBrands allMobileBrands;
	
	@Given("a user is on the landing page of Amazon")
	public void a_user_is_on_the_landing_page_of_amazon() 
	{
     //driver = new ChromeDriver();
    //driver.manage().window().maximize();
   //driver.get("https://amazon.in");
	}

	@When("he clicks on Mobiles in the navigation bar")
	public void he_clicks_on_mobiles_in_the_navigation_bar() 
	{
    //LandingPage landingPage = new LandingPage(driver);
	    landingPage.clickMobiles();
	}

	@When("he hovers the pointer over Mobiles & Accessories")
	public void he_hovers_the_pointer_over_mobiles_accessories() 
	{
    //allMobileBrands = new AllMobileBrands(driver);
		allMobileBrands.hoverOverMobilesAndAccessories();
	}

	@When("he clicks on Apple in the Sub-menu")
	public void he_clicks_on_apple_in_the_sub_menu() 
	{
		allMobileBrands.clickApple();
	}

	@When("he clicks in the second available phone")
	public void he_clicks_in_the_second_available_phone() throws InterruptedException 
	{
	    //ApplePhones applePhones = new ApplePhones(driver);
	    applePhones.clickSecondMobile();
	}

	@When("he switches focus on the new tab")
	public void he_switches_focus_on_the_new_tab() 
	{
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	@When("he clicks on Buy Now button")
	public void he_clicks_on_buy_now_button() 
	{
		//BuyPhone buyPhone = new BuyPhone(driver);
		buyPhone.clickBuyNowBtn();
	}

	@Then("he must be able to purchase the mobile phone successfully.")
	public void he_must_be_able_to_purchase_the_mobile_phone_successfully() 
	{
		//SignIn signIn = new SignIn(driver);
		String expectedText = "Sign in";
		String actualText = signIn.getSignInText();
		Assert.assertEquals(actualText, expectedText);
		driver.quit();
	}
}
