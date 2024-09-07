package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage 
{
	
	private WebDriver driver;
	
	public InventoryPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	private By product = By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']//div[@class='inventory_item_description']//a");
	private By addCart = By.id("add-to-cart");
	private By cart = By.xpath("//a[@class='shopping_cart_link']");
	private By addProdName = By.xpath("//div[@class='cart_item_label']//a//div[@class='inventory_item_name']");
	
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void selectProduct(String prod)
	{
		List<WebElement> prods = driver.findElements(product);	
		
		for(WebElement i : prods)
		{
			System.out.println(i.getText());
			
			if(i.getText().equalsIgnoreCase(prod))
			{
				i.click();
				break;
			}		
		}
	}
	
	public void addToCart()
	{
		driver.findElement(addCart).click();
	}
	
	public String getProdName()
	{
		driver.findElement(cart).click();
		return driver.findElement(addProdName).getText();
	}
}
