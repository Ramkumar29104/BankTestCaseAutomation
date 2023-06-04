package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass {
	
	private By userName = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By signInBtn = By.xpath("//button[@type='submit']");
	private By loginFailedInnerText = By.xpath("//div[contains(text(),'login failed')]");
	private By registerLink = By.xpath("//a[@href='/register-account']");
	

}
