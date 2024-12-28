package com.EcommercePageFactory.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class indexpage {
	
	private WebDriver driver;
	public indexpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='list-group']//a")  //all categories
	List <WebElement> categories;
	
	@FindBy(xpath="(//div[@id='tbodyid'])//div[@class='card-block']")
	List<WebElement> totalitems;
	
	@FindBy(xpath="//*[@id=\"tbodyid\"]/h2")
	WebElement Productname;
	
	@FindBy(linkText="Sony vaio i5")
	WebElement itemselect;
	
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div[2]/div/a")
	WebElement addtocart;
	
	@FindBy(id="cartur")
	WebElement cartlink;
	
	
	@FindBy(xpath="//a[normalize-space()='Nokia lumia 1520']")
	WebElement prod;
	
	public void verifyCategories()
	{
		
	for(WebElement ele:categories)
		{
			System.out.println(ele.getText());
		}
	}
	
	public void verifyitemselect(String cname)
	{
		for(WebElement ele:categories)
		{
			
			if(ele.getText().contains(cname))
			{
				ele.click();
				String category=ele.getText();
				
				Assert.assertEquals(category,cname, "category not selected");
				System.out.println("category selected!!:"+ele.getText());
				break;
			}
			
		}
}
	public void verifyitems()
	{
		int count=totalitems.size();
		
		for(WebElement j:totalitems)
		{
			System.out.println(j.getText());
		}
		
		Assert.assertEquals(count,9,"cou nt is not matching");
		System.out.println("Count is matching ..total items are:"+count);
	}
	
	public void verifyitemSelected(String pname)
	{
		
		System.out.println("Total items are: " + totalitems.size());
		boolean productFound = false;

		for (WebElement i : totalitems) {
		    if (i.getText().contains(pname)) {
		    	prod.click();
		        i.click();
		        System.out.println("Product selected: " + i.getText());
		        String selectedProd = i.getText();

		        Assert.assertTrue(selectedProd.contains(pname), 
		            "Product name does not match! Expected to contain: " + pname + ", but found: " + selectedProd);

		        System.out.println("Product matching: " + pname);
		        System.out.println("Product added to cart: " + pname);

		        productFound = true;
		        break;
		    }
		}

		
		Assert.assertTrue(productFound, "No product matching '" + pname + "' was found in the list!");

	}
	
	public void launchAddtocart()
	{
		System.out.println("User has navigated to productpage");
		try {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			addtocart.click();
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("product added to cart");
}
	
	public void verifycartLink()
	{
		
		String Title=driver.getTitle();
		cartlink.click();
		String CartpageTitle=driver.getTitle();
		
		System.out.println("Cart link clicked");

	
	}
	
	

	

}
