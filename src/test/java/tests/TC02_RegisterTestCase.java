package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import library.WrapperClass;
import pages.LoginPage;
import pages.RegistrationPage;
 

public class TC02_RegisterTestCase extends BaseClass {
	
	WrapperClass wrap = new WrapperClass();
	
	@BeforeTest
	public void testSetup() {
		excelName = "TC0002";
	}
	
	@Test(priority = 1)
	public void validateAllTheElements() {
		Boolean result = new LoginPage()
		.registerNewAccount()
		.validateAllElementsInRegisterPage();
		Assert.assertEquals(result, true);
		new RegistrationPage().clickOnLogo();
	}
	
	@Test(priority = 2, dataProvider = "ExcelData")
	public void newUserRegistration(String firstName, String title, String middleName, String lastName, String sex, 
			String employmentStatus,int birthMonth,int birthDate, int birthYear, String maritalStatus, int noOfDep, String userName, String email, String password) throws Exception {
		Boolean result = new LoginPage()
		.registerNewAccount()
		.enterFirstName(firstName)
		.selectTitle(title)
		.enterMiddleName(middleName)
		.enterLastName(lastName)
		.selectSex(sex)
		.selectEmploymentStatus(employmentStatus)
		.enterAge(birthMonth, birthDate, birthYear)
		.selectMaritalStatus(maritalStatus)
		.enterNumOfDepedents(noOfDep)
		.enterUserName(userName+wrap.generateRandomNumber(10,1000))
		.enterEmailAddress(email +wrap.generateRandomNumber(10, 1000) + "@gmail.com")
		.enterPassword(password)
		.clickOnRegister()
		.validateElementsInEmailVerificationPage()
		.clickOnLogin()
		.validateAlltheWebElementsInLoginPage();
		Assert.assertEquals(result, true);
		
	}

}
