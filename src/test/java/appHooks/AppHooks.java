package appHooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.*;
import utility.DriverFactory;

public class AppHooks 
{
	public WebDriver driver;
		
	@Before
	public void launch_browser()
	{
		driver = DriverFactory.init_driver("chrome");
	}
	
	@After (order=0)
	public void quitBrow()
	{
		driver.quit();
	}
	
	@After (order=1)
	public void ssShot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String ssName = scenario.getName().replaceAll(" ","_");
			byte [] ssPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(ssPath,"image/png",ssName);
		}
	}
}
