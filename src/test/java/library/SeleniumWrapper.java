package library;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class SeleniumWrapper extends BaseClass{
	
	public SeleniumWrapper(WebDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	
	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data: "+data+" entered successfully in the field :", "PASS");
		} catch (Exception e) {
			reportStep("The data: "+data+" could not be entered successfully in the field :", "FAIL");
		} 
	}
	
	public void click(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportStep("The click button "+text+" is clicked" , "PASS");
		} catch (Exception e) {
			reportStep("The click button "+text+" is not clicked" , "FAIL");
		}
	}
	
	public boolean verifyDisplayedWithReturn (WebElement ele) {
		boolean result = false;
		String text = "";
		try {
			text = ele.getText();
			if(ele.isDisplayed()) {
				reportStep("The element "+text+" is visible", "PASS");
				result = true;
				return result;
			}else {
				reportStep("The element "+text+" is not visible", "FAIL");
				result = false;
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void selectDropDownByVisibleText(WebElement ele,String value) {
		String text = "";
		try {
			text = ele.getText();
			new Select(ele).selectByVisibleText(value);
			reportStep("The element "+text+" is selected from drop down", "PASS");
		} catch (Exception e) {
			reportStep("The element "+text+" is not selected from drop down", "FAIL");
		}
	}
}
