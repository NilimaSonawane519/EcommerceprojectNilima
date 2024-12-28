package com.EcommercepageFactorys.tests;

import org.apache.commons.compress.harmony.pack200.CpBands;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class cartPageTestPF extends BasetestEcommece {
	
		@BeforeClass
	public void pageSetup()
	{
		hp.verifyLogin("samira1","sachi222");
	}
	
	@Test (priority=1)
	public void verifyplaceoder()
	{
		ip.verifycartLink();
		cp.verifyplaceorder();
	}
	@Test (priority=2)
	public void verifypurchasedetailsandCheckout()
	{
		cp.verifyPurchaseDetailsandCheckout();
	}
	
	@Test(priority=3)
	public void verifyPurchaseOrder()
	{
		cp.verifyPurchaseOrder();
	}
	
}
