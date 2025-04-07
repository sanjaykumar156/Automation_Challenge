package testcases;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.CheckoutPage;
import pages.HomePage;

public class OrderplaceTest extends BaseClass {
	
	@Test
	public void test1() throws InterruptedException {
		HomePage hp= new HomePage(driver);
		CheckoutPage checkout=new CheckoutPage(driver);
		hp.hoveronmen();
		hp.clickTshirt();
		hp.searchforitem("Dennis Lingo Tshirts");
		hp.clickonsearch();
		hp.clickonitem();
		Set<String> allwindow=driver.getWindowHandles();
		for(String window:allwindow) {
			driver.switchTo().window(window);
			if(window.contains("regular-fit-cotton-t-shirt/32927172/buy")) {
				break;
			}
		}
		String brandname=checkout.getBrandName();
		String price=checkout.getPriceTag().replaceAll("[^0-9]", "");
		checkout.selectSize();
		Assert.assertTrue(checkout.isSizeVisible());
		checkout.addToCart();
		checkout.goToCart();
		String checkbrandname = checkout.getCheckoutBrandName();
		String checkpricetag=checkout.getCheckoutPrice().replaceAll("[^0-9]", "");
		Assert.assertEquals(brandname, checkbrandname);
		Assert.assertEquals(price, checkpricetag);
		checkout.clickPlaceOrder();
		
	}

}
