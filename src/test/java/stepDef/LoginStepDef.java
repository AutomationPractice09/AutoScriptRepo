package stepDef;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utility.DriverFactory;

public class LoginStepDef 
{
	public LoginPage lp = new LoginPage(DriverFactory.getDriver()); 
	private String lpTitle;
	
	@Given("User launch the Url {string}")
	public void user_launch_the_url(String string) 
	{
		DriverFactory.getDriver().get(string);
	}

	@When("User get the title of login page")
	public void user_get_the_title_of_login_page() 
	{
		lpTitle = lp.getTitle();
	}

	@Then("title should be match with {string}")
	public void title_should_be_match_with(String name) 
	{
		Assert.assertTrue(lpTitle.contains(name),"Scenario is Failed");
		System.out.println("Scenario is Passed");
	}

	@When("User Enter {string} and {string}")
	public void user_enter_and(String un1, String pwd1) 
	{
		lp.enterUsername(un1);
		lp.enterPassword(pwd1);
	}

	@When("User Enter Login button")
	public void user_enter_login_button() 
	{
		lp.enterLogin();
	}

	@Then("User land on Inventory page and Inventory Page url contains {string}")
	public void user_land_on_inventory_page_and_inventory_page_url_contains(String string) 
	{
		String ipURL = lp.getURL();
		Assert.assertTrue(ipURL.contains(string),"Scenario is Failed");
		System.out.println("Scenario is Passed");
	}

	@When("User Enter Username {string}")
	public void user_enter_username(String string) 
	{
		lp.enterUsername(string);
	}

	@When("User Enter Password {string}")
	public void user_enter_password(String string) 
	{
		lp.enterPassword(string);
		lp.enterLogin();
	}

	@Then("System show warning message")
	public void system_show_warning_message() 
	{
		String warnTest = lp.getWarning();
		Assert.assertTrue(warnTest.contains("sorry"),"Scenario is Failed");
		System.out.println("Scenario is Passed");
	}
}
