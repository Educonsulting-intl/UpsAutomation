package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	private int timeOutInSeconds = 15;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	protected void waitForElementToBeVisible(WebElement el) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(el));
	}
	protected String getText(WebElement el) {
		return el.getText();
	}
	protected void waitForTextToBePresentOnElement(final WebElement el, final String txt) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return el.getText().equals(txt);
			}
		});

	}
}
