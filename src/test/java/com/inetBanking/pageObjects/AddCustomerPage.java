package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	// constructor
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// locators
	
	@FindBy (how=How.XPATH, using="//a[normalize-space()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy (how=How.XPATH, using="//input[@name='name']")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy (how=How.NAME, using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how=How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how=How.NAME, using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	
	
	// action methods
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender) {
		rdGender.click();
	}
	
	public void custdob(String dd, String mm, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}
	
	public void custaddr(String caddr) {
		txtaddress.sendKeys(caddr);
	}
	
	public void custCity(String ccity) {
		txtcity.sendKeys(ccity);
	}
	
	public void custState(String cstate) {
		txtstate.sendKeys(cstate);
	}
	
	public void custPinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custTelephone(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}
	
	public void custEmailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
}
