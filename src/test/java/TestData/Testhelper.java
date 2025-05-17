package TestData;

import java.util.Set;

import baseclass.BaseClass;
import pages.CheckoutPage;
import pages.HomePage;

public class Testhelper extends BaseClass{
	
	public void commonordersteps(HomePage hp ) {
		
		hp.hoveronmen();
		hp.clickTshirt();
		//hp.searchforitem("Dennis Lingo Tshirts");
		hp.searchforitem("levis shirts");
		hp.clickonsearch();
//		hp.selectcolour();
//		hp.clickonitem();
//		Set<String> allwindow=getDriver().getWindowHandles();
//		for(String window:allwindow) {
//			getDriver().switchTo().window(window);
//			if(window.contains("regular-fit-cotton-t-shirt/32927172/buy")) {
//				break;
//			}
//			logger.info("---driver is successfully navigated to new product tab---");
//		}
		
		
	}

}
