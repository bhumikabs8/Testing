package in.amazon.teststeps;

//import static org.testng.Assert.assertTrue;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//import in.amazon.pages.LandingPage;
//import in.amazon.pages.SignIn;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyErrorMessageSteps extends Driver
{
	//WebDriver driver;
	//SignIn signIn;
	
	@When("he havers the pointer over Hello Sign-in menu")
	public void he_havers_the_pointer_over_hello_sign_in_menu() 
	{
		//driver = new ChromeDriver();
	    //driver.manage().window().maximize();
	    //driver.get("https://amazon.in");
		Assert.assertTrue(driver.getTitle().equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"));
	}

	@When("he clicks on Sign-in button in the sub-menu")
	public void he_clicks_on_sign_in_button_in_the_sub_menu() 
	{
		//LandingPage landingPage = new LandingPage(driver);
		landingPage.hoverOverHelloSignInMenu();
		landingPage.clickSignInBtn();
	}

	@When("he enters invalid email address in the Email text-box")
	public void he_enters_invalid_email_address_in_the_email_text_box() 
	{
		//signIn = new SignIn(driver);
		signIn.enterEmail("batman554466@gmail.com");
	}

	@When("he clicks on Continue button")
	public void he_clicks_on_continue_button() 
	{
		signIn.clickContinueBtn();  
	}

	@Then("he must see the error message - {string}")
	public void he_must_see_the_error_message(String string) 
	{
		String expectedErrMsg = "We cannot find an account with that email address";
		String acutalErrMsg = signIn.getErrMsg();
		Assert.assertEquals(acutalErrMsg, expectedErrMsg );
	}
	
	@When("he enters an invalid email address {string} in the Email text-box")
	public void he_enters_an_invalid_email_address_in_the_email_text_box(String string) {
	    signIn.enterEmail(string);
	}
}
