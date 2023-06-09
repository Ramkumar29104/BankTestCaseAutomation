package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC01_LoginTestCase extends BaseClass {
	
	@BeforeTest
	public void testSetup() {
		excelName = "TC0001";
	}
	
	@Test(priority = 1)
	public void validateAllTheElements() {
		Boolean result = new LoginPage()
				.validateAlltheWebElementsInLoginPage();
		Assert.assertEquals(result,true);
	}
	
	@Test(priority = 2, dataProvider = "ExcelData")
	public void loginWithValidCredentials(String userName, String password) {
		Boolean result = new LoginPage()
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
		Boolean result = new LoginPage()
		.enterUsername("ram2910")
		.enterPassword("Praviram2910")
		.clickOnSignInWithInvalidCredentials()
		.validateFailureMessage();
		Assert.assertEquals(result, true);
	}

}
