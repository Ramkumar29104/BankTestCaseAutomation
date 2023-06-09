package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass {

	private By userName = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By signInBtn = By.xpath("//button[@type='submit']");
	private By loginFailedInnerText = By.xpath("//div[contains(text(),'login failed')]");
	private By registerLink = By.xpath("//a[@href='/register-account']");

	public Boolean validateAlltheWebElementsInLoginPage() {
		if (driver.findElement(userName).isDisplayed() && driver.findElement(password).isDisplayed()
				&& driver.findElement(signInBtn).isDisplayed() && driver.findElement(registerLink).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public LoginPage enterUsername(String name) {
		driver.findElement(userName).sendKeys(name);
		return this;
	}

	public LoginPage enterPassword(String Password) {
		driver.findElement(password).sendKeys(Password);
		return this;
	}

	public HomePage clickOnSignIn() {
		driver.findElement(signInBtn).click();
		return new HomePage();
	}
	
	public LoginPage clickOnSignInWithInvalidCredentials() {
		driver.findElement(signInBtn).click();
		return this;
	}
	
	public Boolean validateFailureMessage() {
		if(driver.findElement(loginFailedInnerText).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public RegistrationPage registerNewAccount() {
		driver.findElement(registerLink).click();
		return new RegistrationPage();
	}
}
