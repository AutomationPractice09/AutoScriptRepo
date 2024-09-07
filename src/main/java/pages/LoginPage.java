package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By login = By.id("login-button");
	private By warning = By.xpath("//div[@class='error-message-container error']//h3");
	
	
	
	public String getTitle()
	{
		String Title = driver.getTitle();
		return Title;
	}
	
	
	public void enterUsername(String un)
	{
		driver.findElement(username).sendKeys(un);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void enterLogin()
	{
		driver.findElement(login).click();
	}
	
	public String getURL()
	{
		String URL = driver.getCurrentUrl();
		return URL;
	}
	
	public String getWarning()
	{
		String warn = driver.findElement(warning).getText();
		return warn;
	}
	
	public InventoryPage doLogin(String un, String pwd)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login).click();
		System.out.println(driver.getTitle());
		return new InventoryPage(driver);
	}
	
}
