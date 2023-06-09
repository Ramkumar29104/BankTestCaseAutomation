package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC01LoginTestCase extends BaseClass {
	
	@BeforeTest
	public void testSetup() {
		excelName = "TC01";
	}
	
	@Test(priority = 1)
	public void validateAllTheElements() {
		Boolean result = new LoginPage(driver)
				.validateAlltheWebElementsInLoginPage();
		Assert.assertEquals(result,true);
	}
	
	@Test(priority = 2, dataProvider = "ExcelData")
	public void loginWithValidCredentials(String userName, String password) {
		Boolean result = new LoginPage(driver)  //Anonymous Object
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnSignIn()
		.validateWelcomeMessage()
		.clickOnLogout()
		.validateAlltheWebElementsInLoginPage();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 3)
	public void loginWithInvalidCredentials() {
		Boolean result = new LoginPage(driver)
		.enterUsername("ram2910")
		.enterPassword("Praviram2910")
		.clickOnSignInWithInvalidCredentials()
		.validateFailureMessage();
		Assert.assertEquals(result, true);
	}

}
