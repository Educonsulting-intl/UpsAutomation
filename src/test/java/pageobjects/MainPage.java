package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage extends BasePage{

	@FindBy(css="#batteryCapacity")
	WebElement batteryCapacity;
	@FindBy(css="#backupTime")
	WebElement backupTime;
	@FindBy(css="#upsMode")
	WebElement uspMode;
	@FindBy(css="#showpage")
	WebElement f;
	
	public MainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void verifyUpsStatus() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(f);
		
		String upsModeSrt = getText(uspMode);
		System.out.println("UPS_Mode: "+upsModeSrt);
		
		String backupTimeStr = getText(backupTime);
		int backupTimeInt = Integer.parseInt(backupTimeStr);
		System.out.println("BackupTime: "+backupTimeInt+"Min");
		
		String batteryCapacityStr = getText(batteryCapacity);
		int batteryCapacityInt = Integer.parseInt(batteryCapacityStr);
		System.out.println("Battery: "+batteryCapacityInt+"%");
		Assert.assertTrue(batteryCapacityInt > 95 || batteryCapacityInt == 0);
		

		
	}
}
