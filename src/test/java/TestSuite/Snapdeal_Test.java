package TestSuite;

import org.testng.annotations.Test;

import Pages.Snapdeal;

public class Snapdeal_Test
{
	@Test
    public void test() throws InterruptedException
    {
    	Snapdeal demo = new Snapdeal();
		demo.openUrl();
		demo.searchItem();
		demo.filterPrice();
		demo.sortItem();
		demo.getProductName();
		demo.getProductPrice();
		demo.display();
		demo.closeBrowser();
	}
}
