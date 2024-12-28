package com.EcommercepageFactorys.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class indexPageTestPF extends BasetestEcommece{
	
	@BeforeClass
	public void pageSetup()
	{
		hp.verifyLogin("samira1","sachi222");
	}
	
	@Test(priority=1)
	 public void verifycategories()
	  {
		  ip.verifyCategories();
	  }
	
	@Test(priority=2)
	public void verifyitemselect()
	  {
		  ip.verifyitemselect("Phones");
	  }
	
	
	@Test(priority=3)
	public void verifyitems()
	{
		ip.verifyitems();
	}
	
	@Test(priority=4)
	public void verifyitemSelected() {
		
		
		ip.verifyitemSelected("Nokia lumia 1520");
	}
	
	
	@Test(priority=5)
	public void launchAddtocart()
	{
	ip.launchAddtocart();
	}
	
	
	@Test(priority=6)
	public void verifycartLink()
	{
		ip.verifycartLink();
	}
	
	

  
  
}
