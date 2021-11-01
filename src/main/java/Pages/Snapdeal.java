package Pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Base;

public class Snapdeal extends Base
{
	List<WebElement> Productname;
	List<WebElement> price;
	public void openUrl()
	{
		 driver.get("https://www.snapdeal.com/");
	}
	public void searchItem()
	{
		driver.findElement(By.name("keyword")).sendKeys("Doll House");
		driver.findElement(By.className("searchTextSpan")).click();
	}
	public void filterPrice()
	{
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("700");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1400");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn')]")).click();
	}
	public void sortItem() throws InterruptedException
	{
		driver.findElement(By.className("sort-selected")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plrty']")).click();	
	    Thread.sleep(2000);
	}
	public void getProductName()
	{
		 Productname=driver.findElements(By.className("product-title"));
	}
	public void getProductPrice()
	{
	price=driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	}
	public void display()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println((i+1)+" "+Productname.get(i).getText());
			System.out.println(price.get(i).getText());
			System.out.println();
		}
	}
}
