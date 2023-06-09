package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class HomePage extends BaseClass {

	public By welcomeMsg = By.xpath("//h3[contains(text(),'Welcome')]");
	public By apply = By.xpath("//div[contains(text(),'Apply For New Account')]");
	public By logout = By.xpath("//a[contains(text(),'Logout')]");
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	public HomePage validateWelcomeMessage() {
		if (driver.findElement(welcomeMsg).isDisplayed() && driver.findElement(apply).isDisplayed()
				&& driver.findElement(logout).isDisplayed()) {
			System.out.println("User is in Home Page");
		} else {
			System.out.println("User is not in Home Page");
		}
		return this;
	}
	
	public LoginPage clickOnLogout() {
		driver.findElement(logout).click();
		return new LoginPage(driver);
	}
	
	

}
