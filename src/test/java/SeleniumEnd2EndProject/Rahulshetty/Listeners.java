package SeleniumEnd2EndProject.Rahulshetty;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reqResource.BaseClass;
import reqResource.ExtentReport;

public class Listeners extends BaseClass implements ITestListener {

	
	
	ExtentReports extenting=ExtentReport.getReport();
	ExtentTest TestReport;
	ThreadLocal<ExtentTest> reporting=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	 TestReport=extenting.createTest(result.getMethod().getMethodName());
      reporting.set(TestReport);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		reporting.get().pass(result.getMethod().getMethodName()+" is passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		reporting.get().fail(result.getThrowable());
		String FailedMethodName = result.getMethod().getMethodName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			takingScreenshots(FailedMethodName, driver);
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try 
		{
			TestReport.addScreenCaptureFromPath(takingScreenshots(FailedMethodName, driver));
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extenting.flush();

	}

}
