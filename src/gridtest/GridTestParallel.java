package gridtest;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridTestParallel 
{
	RemoteWebDriver driver;
	Platform WIN10;
	String nodeURL;//https://www.hotstar.com/in
	@Parameters({"portNo", "appURL"})
	@BeforeMethod
	public void setUP(String portNo, String appURL ) throws Throwable
	{
		if(portNo.equalsIgnoreCase("4567"))
		{
			nodeURL=" http://192.168.1.9:4567/wd/hub";
			System.out.println("Chrome Test ENV created");
			/*DesiredCapabilities cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			driver= new RemoteWebDriver(new URL(nodeURL), cap);*/
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setBrowserName("chrome");
			caps.setPlatform(Platform.WINDOWS);
			driver= new RemoteWebDriver(new URL(nodeURL), caps);
			driver.manage().window().maximize();
			driver.navigate().to(appURL);
			Thread.sleep(5000);
		}
		else
			if(portNo.equalsIgnoreCase("4568"))
			{
				nodeURL=" http://192.168.1.9:4568/wd/hub";
				System.out.println("IE Test ENV created");
				/*DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
				cap.setBrowserName("IE");
				cap.setPlatform(Platform.WINDOWS);
				driver= new RemoteWebDriver(new URL(nodeURL), cap);*/
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setBrowserName("IE");
				caps.setPlatform(Platform.WINDOWS);
				driver= new RemoteWebDriver(new URL(nodeURL), caps);
				driver.manage().window().maximize();
				driver.navigate().to(appURL);
				Thread.sleep(5000);
			}
}
	@Test
	public void loginHotstar() throws Exception


	{
		driver.findElement(By.xpath("//div[contains(text(),'LOGIN')]")).click();
		System.out.println("Clicked on login");
		Thread.sleep(2000);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
