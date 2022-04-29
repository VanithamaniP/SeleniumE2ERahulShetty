package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	
	public WebDriver driver;
	
	
	public LoginPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}

	By uname=By.id("user_email");
	By upwd=By.id("user_password");
	By loginButton = By.name("commit");
	
	public WebElement unameLogin()
	{
		return driver.findElement(uname);
	}
	public WebElement upwdLogin()
	{
		return driver.findElement(upwd);
	}
	public WebElement loginButtonLogin()
	{
		return driver.findElement(loginButton);
	}


}
