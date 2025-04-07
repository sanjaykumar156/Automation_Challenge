package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseclass.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	private By menbtn=By.xpath("//div[@class='desktop-navLink']//a[normalize-space()='Men']");
	private By tshirtsbtn = By.xpath("//a[@href='/men-tshirts']");
    private By itemsearchbtn = By.xpath("//input[@class='desktop-searchBar']");
    private By searchbtn = By.xpath("//a[@class='desktop-submit']");
    private By itembtn = By.xpath("//h4[text()='Polo Collar Applique T-shirt']");
	
	
	public void hoveronmen() {
		hoverOn(menbtn);
	}
	public void clickTshirt() {
		click(tshirtsbtn);
	}
	public void searchforitem(String itemsearch) {
		waitForVisibility(itemsearchbtn);
		sendkeys(itemsearchbtn, itemsearch);
	}
	public void clickonsearch() {
		click(searchbtn);
	}
	public void clickonitem() {
		click(itembtn);
	}
}
