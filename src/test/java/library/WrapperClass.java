package library;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class WrapperClass extends BaseClass {

	public void selectWrapper(By element, String name) {
		WebElement webElement = driver.findElement(element);
		Select select = new Select(webElement);
		select.selectByVisibleText(name);
	}
	
	public int generateRandomNumber(int min,int max) {
		Random ran = new Random();
		int ranInt = ran.nextInt((min+max) + 1)+min;
		return ranInt;
	}
}
