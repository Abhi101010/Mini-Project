package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;

public class RegressionTest {

	public Base base;
	public HomePage home;
	
	@Test
	public void test() throws IOException, InterruptedException {
		base = new Base();
		home=new HomePage();
		//home.fetch();
		home.getData();
	}
}
