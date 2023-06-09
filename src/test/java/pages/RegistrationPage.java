package pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import base.BaseClass;

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

	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
	}

	public LoginPage clickOnLogo() {
		driver.findElement(logo).click();
		return new LoginPage(driver);
	}

	public Boolean validateAllElementsInRegisterPage() {
		if (driver.findElement(userName).isDisplayed() && driver.findElement(email).isDisplayed()
				&& driver.findElement(password).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public RegistrationPage enterFirstName(String Fname) {
		driver.findElement(firstName).sendKeys(Fname);
		return this;
	}

	public RegistrationPage selectTitle(String titleName) {
		WebElement Title = driver.findElement(title);
		Select select = new Select(Title);
		select.selectByVisibleText(titleName);
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
		WebElement Sex = driver.findElement(sex);
		Select select = new Select(Sex);
		select.selectByVisibleText(sexName);
		return this;
	}

	public RegistrationPage selectEmploymentStatus(String empStsName) {
		WebElement EmpSts = driver.findElement(employmentSts);
		Select select = new Select(EmpSts);
		select.selectByVisibleText(empStsName);
		return this;
	}

	public RegistrationPage enterAge(int birthMonth, int birthDate, int birthYear) {
		String Age = birthMonth + "/" + birthDate + "/" + birthYear;
		driver.findElement(age).sendKeys(Age);
		return this;
	}

	public RegistrationPage selectMaritalStatus(String MaritalSts) {
		WebElement MarSts = driver.findElement(maritalSts);
		Select select = new Select(MarSts);
		select.selectByVisibleText(MaritalSts);
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
		return new EmailVerificationPage(driver);
	}

}
