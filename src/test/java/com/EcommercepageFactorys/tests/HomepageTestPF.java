package com.EcommercepageFactorys.tests;


import org.testng.annotations.Test;


public class HomepageTestPF extends BasetestEcommece {
  @Test(priority=1)
  public void verifyRegistration() {
	  hp.verifyRegistration("samira1","sachi222");
	 
	 
  }
  @Test(priority=2)
  public void verifylogin()
  {
	  hp.verifyLogin("samira1","sachi222");
  }
  
 
 
  
}
