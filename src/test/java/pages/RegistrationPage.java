package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import library.WrapperClass;

public class RegistrationPage extends BaseClass {
	
	WrapperClass wrap = new WrapperClass();
	
	By logo = By.xpath("//a[@class='navbar-brand']");
	By firstName = By.xpath("//input[@id='firstName']");
	By middleName = By.xpath("//input[@id='middleName']");
	By lastName = By.xpath("//input[@id='lastName']");
	By title = By.xpath("//select[@id='title']");
	By sex = By.xpath("//select[@id='sex']");
	By employmentSts = By.xpath("//select[@id='employmentStatus']");
	By age = By.xpath("//input[@id='age']");
	By maritalSts = By.xpath("//select[@id='maritalStatus']");
	By numOfDependents = By.xpath("//input[@id='numberOfDependents']");
	By userName = By.xpath("//input[@id='username']");
	By email = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='password']");
	By registerBtn = By.xpath("//button[@type='submit']");
	
	public LoginPage clickOnLogo() {
		driver.findElement(logo).click();
		return new LoginPage();
	}
	
	public Boolean validateAllElementsInRegisterPage() {
		if(driver.findElement(userName).isDisplayed() && driver.findElement(email).isDisplayed() && driver.findElement(password).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public RegistrationPage enterFirstName(String Fname) {
		driver.findElement(firstName).sendKeys(Fname);
		return this;
	}
	
	public RegistrationPage selectTitle(String titleName) {
		wrap.selectWrapper(title,titleName);
		return this;
	}

	
	public RegistrationPage enterMiddleName(String Mname) {
		driver.findElement(middleName).sendKeys(Mname);
		return this;
	}
	
	public RegistrationPage enterLastName(String Lname) {
		driver.findElement(lastName).sendKeys(Lname);
		return this;
	}
	
	public RegistrationPage selectSex(String sexName) {
		wrap.selectWrapper(sex, sexName);
		return this;
	}
	
	public RegistrationPage selectEmploymentStatus(String empStsName) {
		wrap.selectWrapper(employmentSts, empStsName);
		return this;
	}
	
	public RegistrationPage enterAge(int birthMonth,int birthDate, int birthYear) {
		String Age = birthMonth + "/" + birthDate + "/" + birthYear;
		driver.findElement(age).sendKeys(Age);
		return this;
	}
	
	public RegistrationPage selectMaritalStatus(String MaritalSts) {
		wrap.selectWrapper(maritalSts, MaritalSts);
		return this;
	}
	
	public RegistrationPage enterNumOfDepedents(int noOfDep) {
		String dep = String.valueOf(noOfDep);
		driver.findElement(numOfDependents).sendKeys(dep);
		return this;
	}
	
	public RegistrationPage enterUserName(String name) {
		driver.findElement(userName).sendKeys(name);
		return this;
	}
	
	public RegistrationPage enterEmailAddress(String emailId) {
		driver.findElement(email).sendKeys(emailId);
		return this;
	}
	
	public RegistrationPage enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
		return this;
	}
	
	public EmailVerificationPage clickOnRegister() {
		driver.findElement(registerBtn).click();
		return new EmailVerificationPage();
	}
	
	
	
	
	
	
	
}
