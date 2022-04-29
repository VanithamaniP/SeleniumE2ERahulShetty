package SeleniumEnd2EndProject.Rahulshetty;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import reqResource.BaseClass;

public class HomePage extends BaseClass {
	public WebDriver driver;
	@BeforeTest
	public void initializeDriver() throws IOException {
		driver = initiatingDriver();

		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("(//div[@class='sumome-react-wysiwyg-move-handle']/div/button)[2]")).click();
		HomePageObjects homeObj = new HomePageObjects(driver);
		homeObj.loginLink().click();	
	}

	
	
	@Test(dataProvider = "LoginDetails")
	public void loginPage(String uname, String pwd) {

	
		
		LoginPageObjects loginObj = new LoginPageObjects(driver);
//        loginObj.unameLogin().sendKeys("test@test.com");
//        loginObj.upwdLogin().sendKeys("12345");

		loginObj.unameLogin().sendKeys(uname);
		loginObj.upwdLogin().sendKeys(pwd);
		loginObj.loginButtonLogin().click();

	}

	@DataProvider(name = "LoginDetails")
	public Object[][] loginDetails() {

		Object[][] obj = new Object[2][2];
		obj[0][0] = "test1@test.com";
		obj[0][1] = "pass1";
		obj[1][0] = "test2@test.com";
		obj[1][1] = "pass2";
		return obj;

	}

	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
