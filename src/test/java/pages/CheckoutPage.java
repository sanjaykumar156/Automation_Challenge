package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseclass.BasePage;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
		}
	
	private By itemtext = By.xpath("//div[@class='pdp-price-info']//h1[text()='Dennis Lingo']");
    private By pricecheck = By.xpath("//span[@class='pdp-price']");
    private By sizebtn = By.xpath("//p[text()='S']");
    private By addtobagbtn = By.xpath("//div[normalize-space()='ADD TO BAG']");
    private By bagbtn = By.xpath("//span[normalize-space()='Bag']");
    private By checkouttextcheck = By.xpath("//div[text()='Dennis Lingo']");
    private By checkoutpricheck = By.xpath("//div[@class='itemComponents-base-price itemComponents-base-bold ']");
    private By placeorderbtn = By.xpath("//div[text()='PLACE ORDER']");
	
    public String getBrandName() {
        return gettext(itemtext);
    }
    public String getPriceTag() {
        return gettext(pricecheck);
    }
    public void selectSize() {
        click(sizebtn);
    }
    public boolean isSizeVisible() {
        return validdation(sizebtn); // Optional check
    }
    public void addToCart() {
        click(addtobagbtn);
    }
    public void goToCart() {
        click(bagbtn);
    }
    public String getCheckoutBrandName() {
        return gettext(checkouttextcheck);
    }
    public String getCheckoutPrice() {
        return gettext(checkoutpricheck);
    }
    public void clickPlaceOrder() {
        click(placeorderbtn);
    }
}
