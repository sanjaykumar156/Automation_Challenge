package testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestData.Testhelper;
import baseclass.BaseClass;
import pages.CheckoutPage;
import pages.HomePage;
public class Multipleproductselection extends BaseClass {
	@Test
	public void multipleproducts() {
		HomePage hp= new HomePage(getDriver());
		CheckoutPage checkout=new CheckoutPage(getDriver());
		Testhelper helper= new Testhelper();
		helper.commonordersteps(checkout, hp);
		
		//selecting multiple products
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
		
		//adding the amount and validating with actual and expected
		List<String> priceList = checkout.getAllCheckoutPrice();
		int totalProductPrice = 0;
	    for (String price:priceList) {
	        totalProductPrice+= Integer.parseInt(price);
	    }
	    int shippingfee=Integer.parseInt(checkout.shippingfee().replaceAll("[^0-9]", ""));
	    int total= totalProductPrice+shippingfee;
	    int actualtext=Integer.parseInt(checkout.finalprice().replaceAll("[^0-9]", ""));
	    Assert.assertEquals(actualtext, total);
	    System.out.println("the total price was -----> "+total+ " successfully validated.!");
		checkout.clickPlaceOrder();
		System.out.println("order placed successfully.....");
	}
}
