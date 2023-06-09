package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import utility.ExcelReader;
import utility.PropertyReader;

public class BaseClass {

	public WebDriver driver;
	public int browser = 1;
	public String excelName = "";
	// User name = ram29104
	// Password = Praviram2910

	@BeforeClass
	public void invokeBrowser() throws Exception {

		System.out.println("Choose the Browser");
		System.out.println("1.Chrome");
		System.out.println("2.Firefox");

		switch (browser) {
		case 1:
			System.out.println("User Input is " + 1 + ". So invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new ChromeDriver();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			break;

		case 2:
			System.out.println("User Input is " + 2 + ". So invoking Firefox Browser");
			driver = new FirefoxDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(PropertyReader.getValuesFromProperty("sitURL"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@DataProvider(name="ExcelData")
	public Object[][] excelReader() {
		Object[][] value = ExcelReader.getValueFromExcel(excelName);
		return value;
	}
}