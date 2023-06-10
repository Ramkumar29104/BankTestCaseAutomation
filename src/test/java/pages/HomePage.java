package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import library.SeleniumWrapper;

public class HomePage extends BaseClass {

	public By welcomeMsg = By.xpath("//h3[contains(text(),'Welcome')]");
	public By apply = By.xpath("//div[contains(text(),'Apply For New Account')]");
	public By logout = By.xpath("//a[contains(text(),'Logout')]");
	private WebDriver driver;
	private ExtentTest node;
	private SeleniumWrapper wrap;

	public HomePage(WebDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
		wrap = new SeleniumWrapper(driver, node);
	}

	public HomePage validateWelcomeMessage() {
		if (wrap.verifyDisplayedWithReturn(driver.findElement(welcomeMsg)) && wrap.verifyDisplayedWithReturn(driver.findElement(apply))
				&& wrap.verifyDisplayedWithReturn(driver.findElement(logout))) {
			System.out.println("User is in Home Page");
		} else {
			System.out.println("User is not in Home Page");
		}
		return this;
	}
	
	public LoginPage clickOnLogout() {
		wrap.click(driver.findElement(logout));;
		return new LoginPage(driver,node);
	}
	
	

}
