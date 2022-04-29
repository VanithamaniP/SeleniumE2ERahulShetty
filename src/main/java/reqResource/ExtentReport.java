package reqResource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
 public static ExtentReports extent;
	
	public static ExtentReports getReport()
	{
		String path=System.getProperty("user.dir")+"/Reports/reportResult.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setDocumentTitle("End2End Testing");
		report.config().setReportName("Automation");
		 extent=new ExtentReports();
		extent.attachReporter(report);
		return extent;
        	
	}
}
