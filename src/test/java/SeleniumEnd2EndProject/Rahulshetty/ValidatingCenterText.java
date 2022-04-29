package SeleniumEnd2EndProject.Rahulshetty;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import reqResource.BaseClass;

public class ValidatingCenterText extends BaseClass{
	public WebDriver driver;
	@BeforeTest
	public void initializeDriver() throws IOException
	{
		driver = initiatingDriver();
		driver.get(prop.getProperty("url"));
	}
	

	@Test
	
	  public void validatingHomeText() throws IOException
	  {
		 
		  driver.findElement(By.xpath("(//div[@class='sumome-react-wysiwyg-move-handle']/div/button)[2]")).click();
		  HomePageObjects homeObj=new HomePageObjects(driver);
		  Assert.assertEquals(homeObj.centerText().getText(), "FEATURED COURSES");
		 
	  }
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
