package com.EcommercePageFactory.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class cartPage {
	
	private WebDriver driver;
	
	public cartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="/html/body/div[6]/div/div[2]/button")
	WebElement placeorderbtn;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="country")
	WebElement country;
	
	
	@FindBy(id="city")
	WebElement city;
	
	
	@FindBy(id="card")
	WebElement card;
	
	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="year")
	WebElement year;
	
	@FindBy(xpath="//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
	WebElement purchasebtn;
	
	@FindBy(xpath="/html/body/div[10]/h2")
	WebElement ordermsg;
	
	@FindBy(xpath="/html/body/div[10]/p")
	WebElement orderdetails;
	@FindBy(xpath="/html/body/div[10]/p/br")
	WebElement orderdetailsamt;
	
	@FindBy(id="orderModalLabel")
	WebElement orderfromtitle;
	
	public void verifyplaceorder()
	{
		//placeorderbtn.click();
	//	System.out.println("placeorder button clicked");
		
		try {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			placeorderbtn.click();
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
   	}
	public void verifyPurchaseDetailsandCheckout()
	{
		name.sendKeys("sachir");
		country.sendKeys("India");;
		city.sendKeys("Mumbai");
		card.sendKeys("12345");
		month.sendKeys("December");
		year.sendKeys("10/12/2014");
		purchasebtn.click();
	}
	public void verifyPurchaseOrder()
	{
		System.out.println("-------------order details-----------");
		System.out.println(ordermsg.getText());
		System.out.println(orderdetailsamt.getText());

		System.out.println(orderdetails.getText());
		
	}
	
	
	
	


}
