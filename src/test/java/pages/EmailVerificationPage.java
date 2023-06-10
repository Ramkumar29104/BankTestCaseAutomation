package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import library.SeleniumWrapper;

public class EmailVerificationPage extends BaseClass {
	
	By UILogo = By.xpath("//img[@class='vertical-center']");
	By login = By.xpath("//a[contains(text(),'Login')]");
	By welcomeMsg = By.xpath("//h2[contains(text(),' Welcome To The UiBank Family! ')]");
	private WebDriver driver;
	private ExtentTest node;
	private SeleniumWrapper wrap;

	public EmailVerificationPage(WebDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
		wrap = new SeleniumWrapper(driver, node);
	}
	
	public EmailVerificationPage validateElementsInEmailVerificationPage() {
		if(wrap.verifyDisplayedWithReturn(driver.findElement(UILogo)) && wrap.verifyDisplayedWithReturn(driver.findElement(login))
				&& wrap.verifyDisplayedWithReturn(driver.findElement(welcomeMsg))) {
			System.out.println("User  Registration is successfull");
		}else {
			System.out.println("User Registration is not successfull");;
		}
		return this;
	}
	
	public LoginPage clickOnLogin() {
		wrap.click(driver.findElement(login));;
		return new LoginPage(driver,node);
	}
}
