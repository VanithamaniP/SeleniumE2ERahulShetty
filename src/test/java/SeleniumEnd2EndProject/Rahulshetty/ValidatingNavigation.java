package SeleniumEnd2EndProject.Rahulshetty;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import reqResource.BaseClass;

public class ValidatingNavigation extends BaseClass {
	public WebDriver driver;
	@BeforeTest
	public void initializeDriver() throws IOException
	{
		driver = initiatingDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validatingNavOptions() throws IOException {
	
		driver.findElement(By.xpath("(//div[@class='sumome-react-wysiwyg-move-handle']/div/button)[2]")).click();
		HomePageObjects homeObj = new HomePageObjects(driver);
			for (WebElement Options : homeObj.navOptions()) {
				System.out.println(Options.getText());
			}
			 
		AssertJUnit.assertEquals(homeObj.navOptions().size(), 8);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}


}
