package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user, String pwd) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(user);
		logger.info("Username provided");
		
		lp.setPassword(pwd);
		logger.info("Password provided");
		
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", LoginPage.lnkLogout);
			
			//lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		
		String path = "/Users/kirankumar/eclipse-workspace/test/inetBankingV1/src/test/java/com/inetBanking/testData/LoginData1.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata [][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum;i++) {
			for(int j=0; j<colcount; j++) {
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
		
	}
	
	// user defined method is created to check alert present or not
	public boolean isAlertPresent() {
		
		try {
			
			driver.switchTo().alert();
			return true;
			
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

}
