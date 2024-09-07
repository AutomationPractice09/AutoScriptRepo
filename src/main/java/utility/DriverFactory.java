package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory 
{
	
	public static WebDriver driver;
	
	static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public static WebDriver init_driver(String bname)
	{
		if(bname.equalsIgnoreCase("chrome"))
		{
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
			driver = new ChromeDriver();
			tdriver.set(driver);
		} 
		else if(bname.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			tdriver.set(driver);
		}
		
		return getDriver();
	}
	
	public static WebDriver getDriver()
	{
		return tdriver.get();
	}	

}
