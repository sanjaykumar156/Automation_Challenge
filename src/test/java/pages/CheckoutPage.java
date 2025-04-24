package pages;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseclass.BasePage;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
		}
	
	private By itemtext = By.xpath("//div[@class='pdp-price-info']//h1[text()='Dennis Lingo']");
    private By pricecheck = By.xpath("//span[@class='pdp-price']");
    private By sizebtn = By.xpath("//p[text()='S']");
    private By msizebutton= By.xpath("//p[text()='M']");
    private By addtobagbtn = By.xpath("//div[normalize-space()='ADD TO BAG']");
    private By bagbtn = By.xpath("//span[normalize-space()='Bag']");
    private By checkouttextcheck = By.xpath("//div[text()='Dennis Lingo']");
    private By checkoutpricheck = By.xpath("//div[@class='itemComponents-base-price itemComponents-base-bold ']");
    private By placeorderbtn = By.xpath("//div[text()='PLACE ORDER']");
	private By verifySsize = By.xpath("//span[text()='S']");
	private By verifyMsize = By.xpath("//span[text()='M']");
	private By verifytotalmrp = By.xpath("//span[text()='1,618']");
	private By qntybtn= By.xpath("//div[@class='itemComponents-base-quantity']");
	private By selectqnty=By.xpath("//div[@id='2']");
	private By donebtn=By.xpath("//div[text()='DONE']");
	private By totalprice=By.xpath("//div[text()='1,598']");
	private By finalprice=By.xpath("//span[text()='1,618']");
	private By shippingfee=By.xpath("//span[text()='20']");
		
	
	public boolean verifysmallsize() {
		return validdation(verifySsize);
	}
	public boolean verifymediumsize() {
		return validdation(verifyMsize);
	}
    public String getBrandName() {
        return gettext(itemtext);
    }
    public String getPriceTag() {
        return gettext(pricecheck);
    }
    public void selectSize() {
        click(sizebtn);
    }
    public void mselectsize() {
    	click(msizebutton);
    }
    public boolean isSizeVisible() {
        return validdation(sizebtn);
    }
    public boolean ismsizevisibile() {
    	return validdation(msizebutton);
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
    public List<String> getAllCheckoutPrice() {
    	List<String> price = new ArrayList<String>();
        List<WebElement> priceElements =driver.findElements(checkoutpricheck);
        for(WebElement prices:priceElements) {
        	String amount=prices.getText().replaceAll("[^0-9]", "");
        	price.add(amount);
        }
        return price;
    }
    public String shippingfee() {
    	return gettext(shippingfee);
    }
    public void clickPlaceOrder() {
        click(placeorderbtn);
    }
    public String verifymrp() {
    	return gettext(verifytotalmrp);
    }
    public void quntbutton() {
    	click(qntybtn);
    }
    public void selectqnty() {
    	click(selectqnty);
    }
    public void donebtn() {
    	click(donebtn);
    }
    public String totalprice() {
    	return gettext(totalprice);
    }
    public String finalprice() {
    	return gettext(finalprice);
    }
    }