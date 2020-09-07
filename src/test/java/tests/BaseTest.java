package tests;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.MainPage;

public class BaseTest {

	protected WebDriver driver;
	
	@BeforeSuite
	public void setup()
			throws MalformedURLException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.20.226/");

		
		
	}
	
	@Test
	public void verifyUpsStatus() {
		MainPage mainPage = new MainPage(driver);
		mainPage.verifyUpsStatus();
	}
	
	@AfterSuite
	public void quit() {
		driver.quit();
	}
}
