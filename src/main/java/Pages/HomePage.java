package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import base.Base;

public class HomePage extends Base {

	
	
    static By title=By.xpath("//yt-formatted-string[@id=\"video-title\"]");
    static By textbox=By.name("q");
    static By result=By.id("result-stats");
    String data;
  
	
//	public void fetch() {
//    	List<WebElement> header= driver.findElements(title);
//    	for(int i=0;i<header.size();i++) {
//    	  data[i] = header.get(i).getText();
//    	}
//    }
    public void getData() throws IOException, InterruptedException {
    String str;
	driver.get("http://www.google.com");  
	
	
	FileInputStream fin=new FileInputStream("F:\\Cognizant\\Internship\\Book1.xlsx");	
	XSSFWorkbook wb=new XSSFWorkbook(fin);			
	XSSFSheet ws=wb.getSheet("Sheet1");			
	
	Row row;
	for(int r=0;r<=ws.getLastRowNum();r++) //for all rows in the sheet
	{
		row=ws.getRow(r);
		driver.findElement(By.name("q")).sendKeys(row.getCell(0).getStringCellValue());	
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		str=driver.findElement(By.id("result-stats")).getText();
		row.createCell(1).setCellValue(str);
		driver.navigate().back();
		Thread.sleep(1000);
	}
	FileOutputStream fout=new FileOutputStream("F:\\Cognizant\\Internship\\Book1.xlsx"); //file to write data
	wb.write(fout);		
	
		}
	}
