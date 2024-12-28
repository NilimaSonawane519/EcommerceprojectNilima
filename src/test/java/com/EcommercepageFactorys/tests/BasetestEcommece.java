package com.EcommercepageFactorys.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.EcommercePageFactory.pages.Homepage;
import com.EcommercePageFactory.pages.cartPage;
import com.EcommercePageFactory.pages.indexpage;

public class BasetestEcommece {
	
	public WebDriver driver;
	public cartPage cp;
	public Homepage hp;
	public indexpage ip;
	

	@BeforeTest
	public void setUp() {
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.demoblaze.com/");
		//cp=new cartPage(driver);
		hp=new Homepage(driver);
		ip=new indexpage(driver);
		cp=new cartPage(driver);
	}
	
	@AfterTest 
	public void tearDown()
	{
			//driver.quit();
	}

}
