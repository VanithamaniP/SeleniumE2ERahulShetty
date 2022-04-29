package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {

	public WebDriver driver;

	public HomePageObjects(WebDriver driver) {

		this.driver = driver;
	}

	By loginLink = By.cssSelector("a[href*='sign_in']");
	By centerText = By.cssSelector("#content .text-center");
	By navOptions = By.cssSelector(".nav.navbar-nav.navbar-right li");

	public WebElement loginLink() {
		return driver.findElement(loginLink);
	}

	public WebElement centerText() {
		return driver.findElement(centerText);
	}

	public List<WebElement> navOptions()

	{
		return driver.findElements(navOptions);
	}
}
