package testcases;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestData.Testhelper;
import baseclass.BaseClass;
import pages.CheckoutPage;
import pages.HomePage;
import utilities.RetryAnalyser;

public class PagenationTest extends BaseClass{
	@Test(description="verify Pagination Functionality",groups= {"sanity"},retryAnalyzer = RetryAnalyser.class)
	public void pagenation() {
		HomePage hp= new HomePage(getDriver());
		CheckoutPage checkout=new CheckoutPage(getDriver());
		logger.info("driver is in Homepage");
		Testhelper helper= new Testhelper();
		helper.commonordersteps(hp);
		logger.info("----successfully enter the details of product-----");
		try {
		boolean itemfound=false;
		while(!itemfound) {
			String currentpagenumber=hp.pagetext().split(" ")[1];
			List<WebElement> items=hp.pageitembtn();
			if(!items.isEmpty()) {
				itemfound=true;
				logger.info("product found on page"+"-->"+currentpagenumber);
				items.get(0).click();
				break;
			}
			hp.nextbutton();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		logger.info("--succefully selected the product----");
		Set<String> allwindow=getDriver().getWindowHandles();
		for(String window:allwindow) {
			getDriver().switchTo().window(window);
			if(window.contains("pure-cotton-casual-shirt/32321868/buy")) {
				break;
			}
			logger.info("---driver is successfully navigated to new product tab---");
		}
		checkout.selectsize();
		checkout.addToCart();
		checkout.goToCart();
		checkout.clickPlaceOrder();
		logger.info("---order placed successfully---");
	}
	

}
