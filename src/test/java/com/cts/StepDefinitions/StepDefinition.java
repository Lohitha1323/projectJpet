package com.cts.StepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.cts.Base.LaunchWebDriver;
import com.cts.Pages.AddToCartPage;
import com.cts.Pages.BirdsPage;
import com.cts.Pages.CatsPage;
import com.cts.Pages.CheckOutPage;
import com.cts.Pages.ContinueAndConfirmPage;
import com.cts.Pages.HomePage;
import com.cts.Pages.LoginPage;
import com.cts.Pages.RegisterPage;
import com.cts.Pages.ReptilesPage;
import com.cts.Pages.ThankYouPage;
import com.cts.Pages.WelcomePage;
import com.cts.Pages.navigateFront;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	public WebDriver driver;

	// launching web browser
	@Given("User Launch browser with JpetStorePage")
	public void user_Launch_browser_with_JpetStorePage() {
		
		driver = LaunchWebDriver.setUp();
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	}

	//Register and login
	@When("User click on Sign In botton and click on Register Now!")
	public void user_click_on_Sign_In_botton_and_click_on_Register_Now() {
		
		HomePage.clickOnSignIn(driver);
		LoginPage.clickOnRegisterNow(driver);
	}

	@When("User enters User Id as {string} and  New password as {string} and Repeat password as {string}")
	public void user_enters_User_Id_as_and_New_password_as_and_Repeat_password_as(String userId, String newPassword,
			String RepeatPassword) {
		RegisterPage.fillUserInformation(driver, userId, newPassword, RepeatPassword);
	}

	@When("User enters First name as {string} and Last name as {string} and Email as {string} and Phone as {string} and AddressOne as {string} and AddressTwo as {string} and City as {string} and State as {string} and Zip as {string} and Country as {string}")
	public void user_enters_First_name_as_and_Last_name_as_and_Email_as_and_Phone_as_and_Address_as_and_Address_as_and_City_as_and_State_as_and_Zip_as_and_Country_as(
			String firstName, String lastName, String email, String phone, String addressOne, String addressTwo,
			String City, String state, String zip, String country) {
		RegisterPage.fillAccountInformation(driver, firstName, lastName, email, phone, addressOne, addressTwo, City,
				state, zip, country);
	}

	@When("User selects Language Preference as English and Favourite Category as DOGS and Enable MyList and Enable MyBanner")
	public void user_selects_Language_Preference_as_English_and_Favourite_Category_as_DOGS_and_Enable_MyList_and_Enable_MyBanner() {
		RegisterPage.fillPersonalInformation(driver);
	}

	@When("User click on Save Account Information")
	public void user_click_on_Save_Account_Information() {
		RegisterPage.clickOnSaveAccountInformation(driver);
	}

	
	//valid login and signout
	@When("User click on Sign In botton and enters User Id as {string} and password as {string} and click on Login")
	public void user_click_on_Sign_In_botton_and_enters_User_Id_as_and_password_as_and_click_on_Login(String userId,
			String passowrd) {

		HomePage.clickOnSignIn(driver);
		LoginPage.successfulLogin(driver, userId, passowrd);
	}

	@Then("Assert for presence of Sign Out")
	public void assert_for_presence_of_Sign_Out() {

		String actualText = WelcomePage.gettingTextOfSignOut(driver);
		String expectedText = "Sign Out";
		Assert.assertEquals(expectedText, actualText);
		LaunchWebDriver.tearDown(driver);
	}

	//Checking for Invalid login details
	@When("clickon signin and enter username {string} and password as {string}")
	public void clickon_signin_and_enter_username_and_password_as(String username, String password) {

		HomePage.clickOnSignIn(driver);

		LoginPage.successfulLogin(driver, username, password);

	}

	@Then("assert error message")
	public void assert_error_message() {
		String pageSource = driver.getPageSource();
		boolean check = pageSource.contains("Invalid username or password.  Signon failed.");
		Assert.assertTrue("Not Passed", check);
		LaunchWebDriver.tearDown(driver);
	}

	@When("User fill login details User Id as {string} and password as {string}")
	public void user_fill_login_details_User_Id_as_and_password_as(String userId, String password) {

		HomePage.clickOnSignIn(driver);
		LoginPage.successfulLogin(driver, userId, password);

	}

	//Searching for a pet
	@When("User Search for {string} and click on search")
	public void user_Search_for_and_click_on_search(String search) {
		
		HomePage.Searching(driver, search);
	}

	@Then("Assert for presence of GoldFish and close browser")
	public void assert_for_presence_of_GoldFish_and_close_browser() {
		String pageSource = driver.getPageSource();
		boolean check = pageSource.contains("Goldfish");
		Assert.assertTrue("Not Passed", check);
		LaunchWebDriver.tearDown(driver);
	}

	//Buying a cat and checking for adding to cart,checkout
	@When("buy Cat")
	public void buy_Cat() {
		// Write code here that turns the phrase above into concrete actions
		HomePage.clickOnCats(driver);
		CatsPage.clickOnPersian(driver);
		AddToCartPage.clickOnAddToCart(driver);
		CheckOutPage.clickOnProceedtoCheckout(driver);
		ContinueAndConfirmPage.clickOnContinue(driver);
		ContinueAndConfirmPage.clickOnConfirm(driver);
	}
	
	@Then("Assert for Suucessful CheckOut and close browser")
	public void assert_for_Suucessful_CheckOut_and_close_browser() {
	   
		String actualMsg = ThankYouPage.gettingThankYouMsg(driver);
		String expectedMsg = "Thank you, your order has been submitted.";
		Assert.assertEquals(expectedMsg, actualMsg);
		System.out.println(actualMsg);
		LaunchWebDriver.tearDown(driver);
	}

	//Checking for navigating to front 
	@When("navigate front")
	public void navigate_front() {
		HomePage.clickOnReptiles(driver);
		ReptilesPage.ClickOnRattle(driver);
		navigateFront.front(driver);
	}

	//checking for selecting two products and checkout
	@When("selecting two products and checkout")
	public void selecting_two_products_and_checkout() {
		HomePage.clickOnReptiles(driver);
		ReptilesPage.ClickOnRattle(driver);
		AddToCartPage.clickOnAddToCart(driver);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		HomePage.clickOnBirds(driver);
		BirdsPage.clickOnSelectedBird2(driver);
		AddToCartPage.clickOnAddToCart(driver);
		CheckOutPage.clickOnProceedtoCheckout(driver);
		ContinueAndConfirmPage.clickOnContinue(driver);
		ContinueAndConfirmPage.clickOnConfirm(driver);
	}

	//checking for signout
	@When("check signout happens or not")
	public void check_signout_happens_or_not() {
		HomePage.clickOnSignout(driver);
	}
	
	@Then("close the browser")
	public void close_the_browser() {
		LaunchWebDriver.tearDown(driver);
	}

}
