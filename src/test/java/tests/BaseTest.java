package tests;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
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
	private DesiredCapabilities capabilities;
	
	@BeforeSuite
	public void setup()
			throws MalformedURLException {

		capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setVersion("85.0");
		capabilities.setCapability("enableVNC", true);
		capabilities.setCapability("enableVideo", false);

		driver = new RemoteWebDriver(
		    URI.create("http://192.168.18.22:4444/wd/hub").toURL(), 
		    capabilities
		);
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
