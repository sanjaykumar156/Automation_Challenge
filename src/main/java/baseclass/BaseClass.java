package baseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	 private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	    @Parameters({"browser"})
	    @BeforeClass
	    public void setup(String browser) throws IOException {
	        if (driver.get() == null) {
	            WebDriver localDriver = null;
	            if (browser.equals("chrome")) {
	                localDriver = new ChromeDriver();
	            } else if (browser.equals("edge")) {
	                localDriver = new EdgeDriver();
	            } else if (browser.equals("firefox")) {
	                localDriver = new FirefoxDriver();
	            } else {
	                throw new IllegalArgumentException("No browser matching: " + browser);
	            }
	            driver.set(localDriver);
	            driver.get().manage().window().maximize();
	            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            driver.get().get(ConfigReader.getproperty("url"));
	        }
	    }

	   
	    public static WebDriver getDriver() {
	        return driver.get();
	    }

	    @AfterClass
	    public void teardown() {
	        
	        if (driver.get() != null) {
	            driver.get().quit();
	        }
	}
	

}
