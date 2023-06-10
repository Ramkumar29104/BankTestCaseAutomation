package tests;

import java.util.Random; 


import pages.LoginPage;
import pages.RegistrationPage;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC02RegisterTestCase extends BaseClass {
	
	@BeforeTest
	public void testSetup() {
		excelName = "TC02";
		testCaseName = "Registration";
		testDescription = "Validating Registration Functionality";
		module = "Registration module";
		author = "Praveena";
		category = "Sanity";
	}
	
	@Test(priority = 1)
	public void validateAllTheElements() {
		Boolean result = new LoginPage(driver,node)
		.registerNewAccount()
		.validateAllElementsInRegisterPage();
		Assert.assertEquals(result, true);
		new RegistrationPage(driver,node).clickOnLogo();
	}
	
	@Test(priority = 2, dataProvider = "ExcelData")
	public void newUserRegistration(String firstName, String title, String middleName, String lastName, String sex, 
			String employmentStatus,int birthMonth,int birthDate, int birthYear, String maritalStatus, int noOfDep, String userName, String email, String password) throws Exception {
		Boolean result = new LoginPage(driver,node)
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
		.enterUserName(userName+generateRandomNumber(10,1000))
		.enterEmailAddress(email +generateRandomNumber(10, 1000) + "@gmail.com")
		.enterPassword(password)
		.clickOnRegister()
		.validateElementsInEmailVerificationPage()
		.clickOnLogin()
		.validateAlltheWebElementsInLoginPage();
		Assert.assertEquals(result, true);
		
	}
	
	public int generateRandomNumber(int min,int max) {
		Random ran = new Random();
		int ranInt = ran.nextInt((min+max) + 1)+min;
		return ranInt;
	}

}
