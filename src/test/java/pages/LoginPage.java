package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import library.SeleniumWrapper;

public class LoginPage extends BaseClass {

	private By userName = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By signInBtn = By.xpath("//button[@type='submit']");
	private By loginFailedInnerText = By.xpath("//div[contains(text(),'login failed')]");
	private By registerLink = By.xpath("//a[@href='/register-account']");
	private WebDriver driver;
	private ExtentTest node;
	SeleniumWrapper wrap;
	
	public LoginPage(WebDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
		wrap = new SeleniumWrapper(driver, node);
	}

	public Boolean validateAlltheWebElementsInLoginPage() {
		if (wrap.verifyDisplayedWithReturn(driver.findElement(userName)) && wrap.verifyDisplayedWithReturn(driver.findElement(password))
				&& wrap.verifyDisplayedWithReturn(driver.findElement(signInBtn)) && wrap.verifyDisplayedWithReturn(driver.findElement(registerLink))) {
			return true;
		} else {
			return false;
		}
	}

	public LoginPage enterUsername(String name) {
		wrap.type(driver.findElement(userName), name);;
		return this;
	}

	public LoginPage enterPassword(String Password) {
		wrap.type(driver.findElement(password), Password);;
		return this;
	}

	public HomePage clickOnSignIn() {
		wrap.click(driver.findElement(signInBtn));
		return new HomePage(driver,node);
	}
	
	public LoginPage clickOnSignInWithInvalidCredentials() {
		wrap.click(driver.findElement(signInBtn));
		return this;
	}
	
	public Boolean validateFailureMessage() {
		if(wrap.verifyDisplayedWithReturn(driver.findElement(loginFailedInnerText))) {
			return true;
		}else {
			return false;
		}
	}
	
	public RegistrationPage registerNewAccount() {
		wrap.click(driver.findElement(registerLink));
		return new RegistrationPage(driver,node);
	}
}
