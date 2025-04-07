package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseclass.BaseClass;

public class TestUtility extends BaseClass {
	public String capturescreenshot(String testname) throws IOException {
		try {
	String TimeStamp=new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
	File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destination= new File(".//screenshots//" + testname + "_" + TimeStamp + ".png");
	FileUtils.copyFile(source, destination);
	System.out.println("screenshot saved: " + destination.getAbsolutePath());
    return destination.getAbsolutePath();
		} catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
            return null;
        }
	}
}
