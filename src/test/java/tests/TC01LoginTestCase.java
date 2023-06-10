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
		testCaseName = "Login";
		testDescription = "Validating Login Functionality";
		module = "Login module";
		author = "Ram Kumar";
		category = "Smoke";
	}
	
	@Test(priority = 1)
	public void validateAllTheElements() {
		Boolean result = new LoginPage(driver,node)
				.validateAlltheWebElementsInLoginPage();
		Assert.assertEquals(result,true);
	}
	
	@Test(priority = 2, dataProvider = "ExcelData")
	public void loginWithValidCredentials(String userName, String password) {
		Boolean result = new LoginPage(driver,node)  //Anonymous Object
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
		Boolean result = new LoginPage(driver,node)
		.enterUsername("ram2910")
		.enterPassword("Praviram2910")
		.clickOnSignInWithInvalidCredentials()
		.validateFailureMessage();
		Assert.assertEquals(result, true);
	}

}
