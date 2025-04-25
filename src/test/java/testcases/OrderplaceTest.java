package testcases;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestData.Testhelper;
import baseclass.BaseClass;
import pages.CheckoutPage;
import pages.HomePage;

public class OrderplaceTest extends BaseClass {
	
	@Test
	public void test1() throws InterruptedException {
		HomePage hp= new HomePage(getDriver());
		CheckoutPage checkout=new CheckoutPage(getDriver());
		Testhelper helper= new Testhelper();
		helper.commonordersteps(hp);
		
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
