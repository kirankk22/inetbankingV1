package com.inetBanking.testCases;

import java.io.IOException;


import org.apache.commons.text.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username provided");
		
		lp.setPassword(password);
		logger.info("Password provided");
		
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		logger.info("Providing customer details ...");
		
		addcust.custName("kiran");
		addcust.custGender("male");
		addcust.custdob("10", "15", "1985");
		addcust.custaddr("INDIA");
		addcust.custCity("BLR");
		addcust.custState("KA");
		addcust.custPinno("560098");
		addcust.custTelephone("9945508652");
		String email = randomString()+"@gmail.com";
		addcust.custEmailid(email);
		addcust.clickSubmit();
		
		Thread.sleep(3000);
		logger.info("validation started ...");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully");
		
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else {
			Assert.assertTrue(false);
			captureScreen(driver, "add new customer");
			logger.info("test case failed");
		}
		
		
	}
	
	public String randomString() {
		 RandomStringGenerator generator = new RandomStringGenerator.Builder()
			        .withinRange('a', 'z')
			        .build();

			    return generator.generate(8);
	}
	
	
	
}
