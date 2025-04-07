package baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		this.actions=new Actions(driver);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	public void sendkeys(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	public void hoverOn(By locator) {
		WebElement element=driver.findElement(locator);
		actions.moveToElement(element).build().perform();
	}
	public String gettext(By locator) {
		WebElement gettext=driver.findElement(locator);
		return gettext.getText();
	}
	public boolean validdation(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	public void waitForVisibility(By locator) {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}

