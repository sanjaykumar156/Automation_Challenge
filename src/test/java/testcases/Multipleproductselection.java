package testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestData.Testhelper;
import baseclass.BaseClass;
import pages.CheckoutPage;
import pages.HomePage;
public class Multipleproductselection extends BaseClass {
	@Test(description="selecting multipleproducts",groups= {"sanity"})
	public void multipleproducts() {
		HomePage hp= new HomePage(getDriver());
		CheckoutPage checkout=new CheckoutPage(getDriver());
		Testhelper helper= new Testhelper();
		helper.commonordersteps(hp);
		
		//selecting multiple products
		logger.info("--Multipleproductselection testcase has started--");
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
		List<String> priceList = checkout.getAllCheckoutPrice();  // store the prices(799) in a variable
		int totalProductPrice = 0;
	    for (String price:priceList) {
	        totalProductPrice+= Integer.parseInt(price);// iterate the two prices and adding the both prices(799+799)
	    }
	    int shippingfee=Integer.parseInt(checkout.shippingfee().replaceAll("[^0-9]", "")); // storing the shipping fee(20)in a variable in integer
	    int total= totalProductPrice+shippingfee; // adding the totalproductprice(1598) and shipping fee(20)=1618 in total variable
	    int actualtext=Integer.parseInt(checkout.finalprice().replaceAll("[^0-9]", ""));//getting the expected value by gettext and convert into integer format
	    Assert.assertEquals(actualtext, total);// validate actual and expected prices
	    System.out.println("the total price was -----> "+total+ " successfully validated.!"); //printing the success message
		checkout.clickPlaceOrder(); /// placing the order
		System.out.println("order placed successfully.....");
	}
}
