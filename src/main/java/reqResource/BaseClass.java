package reqResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initiatingDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/vanithamanip/Documents/Selenium/Rahulshetty/src/main/java/reqResource/basedata.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/vanithamanip/Documents/UI Automation Utility/chromedriver");
			driver = new ChromeDriver();
		} else {
			System.out.println("Invalid browser");
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public String takingScreenshots(String MethodName, WebDriver driver) throws IOException

	{
		TakesScreenshot ts = (TakesScreenshot) (driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir") + ("/Reports/" + MethodName + ".png");
		FileUtils.copyFile(source,
				new File(path));
		return path;
	
	
	}
}
