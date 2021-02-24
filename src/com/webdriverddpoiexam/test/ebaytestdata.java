package com.webdriverddpoiexam.test;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ebaytestdata {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		XSSFWorkbook wb =new XSSFWorkbook("C:\\Users\\CHINNU\\Desktop\\ebayInput.xlsx");
		XSSFSheet ws =wb.getSheet("Sheet1");
		int rows=ws.getPhysicalNumberOfRows();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\CHINNU\\eclipse-workspace\\webdriverddpoiexam\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ebay.com");
		String ddValue=null;
		String txtValue=null;
		for(int i=1;i<rows;i++)
		{
			ddValue=ws.getRow(i).getCell(0).getStringCellValue();
			txtValue=ws.getRow(i).getCell(1).getStringCellValue();
			
			WebElement ddCat=driver.findElement(By.id("gh-cat"));
			
			Select s=new Select(ddCat);
			
			s.selectByVisibleText(ddValue);
			
			WebElement txt=driver.findElement(By.id("gh-ac"));
			txt.clear();
			txt.sendKeys(txtValue);
			
			driver.findElement(By.id("gh-btn")).click();
		
		}
	}

}
