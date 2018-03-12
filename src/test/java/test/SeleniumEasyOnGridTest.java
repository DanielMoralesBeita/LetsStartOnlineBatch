package test;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
 
import java.io.IOException;
 
import org.apache.commons.io.FileUtils;
 
import org.openqa.selenium.OutputType;
 
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumEasyOnGridTest {

	//WebDriver driver;
	@BeforeMethod
	public void initBrowser() throws MalformedURLException{
	}
//	@AfterMethod
//	public void closeBrowser(){
//		System.out.println("AfterMethod");
//		if(driver!=null){
//			driver.quit();
//		}
//	}
	@Test
	public void testMessage() throws MalformedURLException{
		System.out.println("BeforeMethod");
		//System.setProperty("webdriver.gecko.driver","E:\\drivers\\geckodriver.exe");
		//driver = new FirefoxDriver(); // launch
		
		URL gridHubUrl = new URL("http://192.168.1.120:4444/wd/hub");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("firefox");
		
               //  option.BrowserExecutableLocation = "/usr/bin/firefox";

		WebDriver driver = new RemoteWebDriver(gridHubUrl, caps);
		driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html"); // open url
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
		System.out.println("Test Message test case..");
		driver.findElement(By.cssSelector("input#user-message")).sendKeys("Vikas T"); // type Vikas T
		driver.findElement(By.xpath("//*[text()='Show Message']")).click(); // click on ShowMessage button
		String actualMessage = driver.findElement(By.id("display")).getText(); // reading actual value from page
		Assert.assertEquals(actualMessage, "Vikas T","Incorrect message displayed");
	
	}
	@Test
	public void testCalculation() throws MalformedURLException{
		System.out.println("Calculate test case..");
		System.out.println("BeforeMethod");
		//System.setProperty("webdriver.gecko.driver","E:\\drivers\\geckodriver.exe");
		//driver = new FirefoxDriver(); // launch
		
		URL gridHubUrl = new URL("http://192.168.1.120:4444/wd/hub");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		
		WebDriver driver = new RemoteWebDriver(gridHubUrl, caps);
		driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html"); // open url
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
		driver.findElement(By.id("sum1")).sendKeys("10");
		driver.findElement(By.id("sum2")).sendKeys("20");
		driver.findElement(By.xpath("//*[@id='gettotal']/button")).click();
		//Verify 
		String actualValue = driver.findElement(By.id("displayvalue")).getText();
	
		Assert.assertEquals(actualValue, "30","Calculation failed");
	}
}
