package pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import library.SeleniumWrapper;

public class RegistrationPage extends BaseClass {
	
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
	private WebDriver driver;
	private ExtentTest node;
	private SeleniumWrapper wrap;

	public RegistrationPage(WebDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
		wrap = new SeleniumWrapper(driver, node);
	}

	public LoginPage clickOnLogo() {
		driver.findElement(logo).click();
		return new LoginPage(driver,node);
	}

	public Boolean validateAllElementsInRegisterPage() {
		if (wrap.verifyDisplayedWithReturn(driver.findElement(userName)) && wrap.verifyDisplayedWithReturn(driver.findElement(email))
				&& wrap.verifyDisplayedWithReturn(driver.findElement(password))) {
			return true;
		} else {
			return false;
		}
	}

	public RegistrationPage enterFirstName(String Fname) {
		wrap.type(driver.findElement(firstName), Fname);
		return this;
	}

	public RegistrationPage selectTitle(String titleName) {
		wrap.selectDropDownByVisibleText(driver.findElement(title), titleName);
		return this;
	}

	public RegistrationPage enterMiddleName(String Mname) {
		wrap.type(driver.findElement(middleName), Mname);
		return this;
	}

	public RegistrationPage enterLastName(String Lname) {
		wrap.type(driver.findElement(lastName), Lname);
		return this;
	}

	public RegistrationPage selectSex(String sexName) {
		wrap.selectDropDownByVisibleText(driver.findElement(sex), sexName);
		return this;
	}

	public RegistrationPage selectEmploymentStatus(String empStsName) {
		wrap.selectDropDownByVisibleText(driver.findElement(employmentSts), empStsName);
		return this;
	}

	public RegistrationPage enterAge(int birthMonth, int birthDate, int birthYear) {
		String Age = birthMonth + "/" + birthDate + "/" + birthYear;
		wrap.type(driver.findElement(age), Age);
		return this;
	}

	public RegistrationPage selectMaritalStatus(String MaritalSts) {
		wrap.selectDropDownByVisibleText(driver.findElement(maritalSts), MaritalSts);
		return this;
	}

	public RegistrationPage enterNumOfDepedents(int noOfDep) {
		String dep = String.valueOf(noOfDep);
		wrap.type(driver.findElement(numOfDependents), dep);
		return this;
	}

	public RegistrationPage enterUserName(String name) {
		wrap.type(driver.findElement(userName), name);;
		return this;
	}

	public RegistrationPage enterEmailAddress(String emailId) {
		wrap.type(driver.findElement(email), emailId);
		return this;
	}

	public RegistrationPage enterPassword(String pass) {
		wrap.type(driver.findElement(password), pass);;
		return this;
	}

	public EmailVerificationPage clickOnRegister() {
		wrap.click(driver.findElement(registerBtn));
		return new EmailVerificationPage(driver,node);
	}

}
