package rs.itbootcamp.humanity.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityProfile {
	public static final String URL = "https://fpn1.humanity.com/app/admin/settings/";

	private static final String USERNAME_XPATH = "//input[@id='email']";
	private static final String PASSWORD_XPATH = "//input[@id='password']";
	private static final String BUTTON_XPATH = "//button[contains(text(),'Log in')]";

	public static final String VERSION_XPATH = "//b[contains(text(),'9.5.5')]";

	static WebElement we = null;

	public static WebElement enterMail(WebDriver driver, String data) {
		we = driver.findElement(By.xpath(USERNAME_XPATH));
		we.sendKeys(data);
		return we;
	}

	public static WebElement enterPass(WebDriver driver, String data) {
		we = driver.findElement(By.xpath(PASSWORD_XPATH));
		we.sendKeys(data);
		return we;
	}

	public static void logIn(WebDriver driver) {
		we = driver.findElement(By.xpath(BUTTON_XPATH));
		we.click();
	}

	public static WebElement getVersion(WebDriver driver) {
		we = driver.findElement(By.xpath(VERSION_XPATH));
		return we;

	}
	public static String printVersion (WebDriver driver) {
		 return getVersion(driver).getText();

	}

}
