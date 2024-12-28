package com.EcommercePageFactory.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Homepage {
	private WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Sign up")  //signup
	WebElement signuplink;
	
	@FindBy(id="sign-username")  //username textbox
	WebElement usernametxt;
	
	@FindBy(id="sign-password")   //password textbox
	WebElement passwordtxt;
	
	@FindBy(xpath="//button[text()='Sign up']")
	WebElement signupbtn;
	
	@FindBy(id="login2")  //login link
	WebElement loginlink;
	
	@FindBy(id="loginusername")  //login username textbox
	WebElement loginusernmtxt;
	
	@FindBy(id="loginpassword")  //login password textbox
	WebElement loginuserpasstxt;
	
	@FindBy(xpath="//button[text()='Log in']")  //login button
	WebElement loginbtn;
	
	
	@FindBy(xpath="//div[@class='list-group']//a")  //all categories
	List <WebElement> categories;
	
	@FindBy(id="nameofuser")  //welcome user
	WebElement welcomuser;
	
	@FindBy(id="itemc")  //item laptop
	WebElement item;
	
	@FindBy(xpath="(//div[@id='tbodyid'])//div[@class='card-block']")
	List<WebElement> totalitems;
	
	public void verifyRegistration(String un, String pwd) {
	    signuplink.click();
	    usernametxt.sendKeys(un);
	    passwordtxt.sendKeys(pwd);
	    signupbtn.click();

	 
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10-second timeout
	    Alert alt1 = wait.until(ExpectedConditions.alertIsPresent()); // Wait for alert to be present
	    
	 
	    String alttext = alt1.getText();
	    alt1.accept();

	   
	    Assert.assertEquals(alttext, "Sign up successful.", "Signup failed: Expected alert message 'Sign up successful.' but found: " + alttext);

	    System.out.println("Signup successful");
	}

	public void verifyLogin(String un,String pwd)
	{
		
		loginlink.click();
		loginusernmtxt.sendKeys(un);
		loginuserpasstxt.sendKeys(pwd);
		loginbtn.click();

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement welcomeUser = wait.until(ExpectedConditions.visibilityOf(welcomuser)); 

		String text1 = welcomeUser.getText();
		System.out.println("Username: " + text1);

		
		Assert.assertTrue(text1.contains(un), "Login failed: Expected username to be displayed, but found: " + text1);

		System.out.println("Login successfully");

	
	}
	

	
}
