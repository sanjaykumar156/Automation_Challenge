package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportClass extends TestUtility implements ITestListener {

	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	public void onStart(ITestContext context) {
	String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
	String repName = "Test-Report-" + ".html";
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter(".//TestReports//" +timeStamp+ repName);	
	sparkreporter.config().setDocumentTitle("MyntraTest");
	sparkreporter.config().setReportName("FunctionalTesting");
	sparkreporter.config().setTheme(Theme.STANDARD);
	extent = new ExtentReports();
	extent.attachReporter(sparkreporter);
	extent.setSystemInfo("os", "windows11");
	extent.setSystemInfo("environment", "automation");
	extent.setSystemInfo("testername", "sanjaykumar");
	extent.setSystemInfo("browsername","chrome,edge");
	}
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "test case is passed"+result.getName());
		
	}
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "testcase failed"+result.getName());
		String screenshotPath = null;
		try {
			screenshotPath = capturescreenshot(result.getName());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        if (screenshotPath != null) {
            try {
                test.fail("Screenshot of failure:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP,"testcase has been skipped"+result.getName());
	}
	public void onFinish(ITestContext context) {
		System.out.println("Flushing Extent Report...");
		extent.flush();
	}
}
