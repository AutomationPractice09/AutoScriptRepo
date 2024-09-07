package stepDef;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.InventoryPage;
import pages.LoginPage;
import utility.DriverFactory;

public class InventoryStepDef 
{
	LoginPage lp = new LoginPage(DriverFactory.getDriver());
	InventoryPage ip;
	String ipTitle;
	
	@Given("User login with valid user")
	public void user_login_with_valid_user() 
	{
		DriverFactory.getDriver().get("https://www.saucedemo.com/");
		ip = lp.doLogin("standard_user","secret_sauce");
	}

	@When("User capture the Title of Inventory Page")
	public void user_capture_the_title_of_inventory_page() 
	{
		ipTitle = ip.getTitle();
	}

	@Then("Inventory page title should contains {string}")
	public void inventory_page_title_should_contains(String string) 
	{
		Assert.assertTrue(ipTitle.contains(string),"TC is Failed as Title does not consist "+string);
	}

	@When("User Click on product name as {string}")
	public void user_click_on_product_name_as(String string) 
	{
		ip.selectProduct(string);
	}

	@When("Click on Add to cart button")
	public void click_on_add_to_cart_button() 
	{
		ip.addToCart();
	}

	@Then("Product should be added to Cart is {string}")
	public void product_should_be_added_to_cart_is(String string) 
	{
		String prodName = ip.getProdName();
		Assert.assertTrue(prodName.equalsIgnoreCase(string));
	}
}
