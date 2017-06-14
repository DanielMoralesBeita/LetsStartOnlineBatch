package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumEasyTest {

	WebDriver driver;
	@BeforeMethod
	public void initBrowser(){
		System.out.println("BeforeMethod");
		System.setProperty("webdriver.gecko.driver","E:\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver(); // launch
		driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html"); // open url
	}
	@AfterMethod
	public void closeBrowser(){
		System.out.println("AfterMethod");
		if(driver!=null){
			driver.quit();
		}
	}
	@Test
	public void testMessage(){
		System.out.println("Test Message test case..");
		driver.findElement(By.cssSelector("input#user-message")).sendKeys("Vikas T"); // type Vikas T
		driver.findElement(By.xpath("//*[text()='Show Message']")).click(); // click on ShowMessage button
		String actualMessage = driver.findElement(By.id("display")).getText(); // reading actual value from page
		Assert.assertEquals(actualMessage, "Vikas T","Incorrect message displayed");
	}
	@Test
	public void testCalculation(){
		System.out.println("Calculate test case..");
		
		driver.findElement(By.id("sum1")).sendKeys("10");
		driver.findElement(By.id("sum2")).sendKeys("20");
		driver.findElement(By.xpath("//*[@id='gettotal']/button")).click();
		//Verify 
		String actualValue = driver.findElement(By.id("displayvalue")).getText();
		Assert.assertEquals(actualValue, "30","Calculation failed");
	}
}
