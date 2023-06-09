package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class EmailVerificationPage extends BaseClass {
	
	By UILogo = By.xpath("//img[@class='vertical-center']");
	By login = By.xpath("//a[contains(text(),'Login')]");
	By welcomeMsg = By.xpath("//h2[contains(text(),' Welcome To The UiBank Family! ')]");
	private WebDriver driver;

	public EmailVerificationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public EmailVerificationPage validateElementsInEmailVerificationPage() {
		if(driver.findElement(UILogo).isDisplayed() && driver.findElement(login).isDisplayed() 
				&& driver.findElement(welcomeMsg).isDisplayed()) {
			System.out.println("User  Registration is successfull");
		}else {
			System.out.println("User Registration is not successfull");;
		}
		return this;
	}
	
	public LoginPage clickOnLogin() {
		driver.findElement(login).click();
		return new LoginPage(driver);
	}
}
