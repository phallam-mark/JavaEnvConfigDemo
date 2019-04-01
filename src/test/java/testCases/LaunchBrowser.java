package testCases;

import java.io.IOException;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import envConfigDemo.Environment;

public class LaunchBrowser {

	WebDriver driver;
	Environment testEnv;
	
	@BeforeMethod
	@Parameters({"environment"})
	public void LaunchBrowser(String environment) throws IOException{
     	// System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ConfigFactory.setProperty("env", environment);
		testEnv = ConfigFactory.create(Environment.class);
		String appUrl = testEnv.appurl();
		String chromeDriverLocation = testEnv.chromeDriverLocation();
		System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
     	driver = new ChromeDriver();
     	driver.get(appUrl);
     	driver.manage().window().maximize();
	}
	
	@Test
	public void validateBmiRange(){
		
     	driver.findElement(By.linkText("BMI")).click();
     	WebElement bmiElement = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[5]/div[1]/font[1]/b[1]"));
     	String bmiRange = bmiElement.getText();
     	Assert.assertEquals(bmiRange,"Normal");
	}
	
	@AfterMethod
	public void CloseBrowser(){
		if(driver!=null){
			driver.close(); //the current active browser
		}
	}
}