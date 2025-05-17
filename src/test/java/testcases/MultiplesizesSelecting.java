package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestData.Testhelper;
import baseclass.BaseClass;
import pages.CheckoutPage;
import pages.HomePage;

public class MultiplesizesSelecting extends BaseClass {
	@Test(description="selecting MultiplesizesSelecting ",groups= {"sanity"})
	public void selectmultiplesize() {
		HomePage hp= new HomePage(getDriver());
		CheckoutPage checkout=new CheckoutPage(getDriver());
		Testhelper helper= new Testhelper();
		helper.commonordersteps(hp);
		
		//selecting multiple sizes
		String brandname=checkout.getBrandName();
		checkout.selectSize();
		Assert.assertTrue(checkout.isSizeVisible());
		checkout.addToCart();
		checkout.mselectsize();
		Assert.assertTrue(checkout.ismsizevisibile());
		checkout.addToCart();
		checkout.goToCart();
		String checkbrandname = checkout.getCheckoutBrandName();
		Assert.assertEquals(brandname, checkbrandname);
		Assert.assertTrue(checkout.verifysmallsize());
		Assert.assertTrue(checkout.verifymediumsize());
		Assert.assertEquals(checkout.verifymrp(),"₹1,618");
		checkout.clickPlaceOrder();
		
	}

}
