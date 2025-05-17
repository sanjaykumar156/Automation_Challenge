package baseclass;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class BaseClass {
	 private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	 protected static Logger logger;
	    @Parameters({"browser","os"})
	    @BeforeClass
	    public void setup(@Optional("chrome") String browser, @Optional("windows") String os) throws IOException {
	    	//remote
	    	 logger= LogManager.getLogger(this.getClass());
	    	if(ConfigReader.getproperty("execution_environment").equals("remote")) {
	    		URL gridUrl = new URL("http://localhost:4444/wd/hub");
	    		switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setPlatformName(os);
                    driver.set(new RemoteWebDriver(gridUrl, chromeOptions));
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setPlatformName(os);
                    driver.set(new RemoteWebDriver(gridUrl, firefoxOptions));
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setPlatformName(os);
                    driver.set(new RemoteWebDriver(gridUrl, edgeOptions));
                    break;

				default:throw new IllegalArgumentException("Unsupported OS: " + os);
				}
			
			}
	    	
	  //local
	    	else if(ConfigReader.getproperty("execution_environment").equals("local")) {
	        if (driver.get() == null) {
	            if (browser.equals("chrome")) {
	            	driver.set(new ChromeDriver());
	            } else if (browser.equals("edge")) {
	            	driver.set(new EdgeDriver());
	            } else if (browser.equals("firefox")) {
	            	driver.set(new FirefoxDriver());
	            } else {
	                throw new IllegalArgumentException("No browser matching: " + browser);
	            }
	        }
	    }
	    	WebDriver currentdriver = getDriver();
			if(driver.get()!=null) {
				currentdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				currentdriver.manage().window().maximize();
				currentdriver.get(ConfigReader.getproperty("url"));
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
