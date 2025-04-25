package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestData.Testhelper;
import baseclass.BaseClass;
import pages.CheckoutPage;
import pages.HomePage;

public class Multiplequantity extends BaseClass{
	
	@Test
	public void selectmultipleqnty() {
		HomePage hp= new HomePage(getDriver());
		CheckoutPage checkout=new CheckoutPage(getDriver());
		Testhelper helper= new Testhelper();
		helper.commonordersteps(hp);
		
		//selecting multiple sizes
		String brandname=checkout.getBrandName();
		checkout.selectSize();
		Assert.assertTrue(checkout.isSizeVisible());
		checkout.addToCart();
		checkout.goToCart();
		String checkbrandname = checkout.getCheckoutBrandName();
		Assert.assertEquals(brandname, checkbrandname);
		checkout.quntbutton();
		checkout.selectqnty();
		checkout.donebtn();
		String value="1,598";
		Assert.assertEquals(checkout.totalprice(),value);
		checkout.clickPlaceOrder();
	}

}
