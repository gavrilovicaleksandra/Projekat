package rs.itbootcamp.humanity.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityDEFAULTLogIn {

	public static final String URl = "https://www.humanity.com";

	private static final String COOKIE_XPATH = "//a[@class='cc-btn cc-dismiss']";
	private static final String LOGIN_XPATH = "//p[contains(text(),'LOGIN')]";
	private static final String USERNAME_XPATH = "//input[@id='email']";
	private static final String PASSWORD_XPATH = "//input[@id='password']";
	private static final String BUTTON_XPATH = "//button[contains(text(),'Log in')]";

	static WebElement we = null;

	public static void cookieAlert(WebDriver driver) {
		we = driver.findElement(By.xpath(COOKIE_XPATH));
		we.click();
	}

	public static void logIn(WebDriver driver) {
		we = driver.findElement(By.xpath(LOGIN_XPATH));
		we.click();
	}

	public static WebElement enterUser(WebDriver driver, String data) {
		we = driver.findElement(By.xpath(USERNAME_XPATH));
		we.click();
		// mail = "alex@temp-link.net";
		we.sendKeys(data);
		return we;
	}

	public static WebElement enterPassword(WebDriver driver, String data) {
		we = driver.findElement(By.xpath(PASSWORD_XPATH));
		we.click();
		// pass = "flower";
		we.sendKeys(data);
		return we;
	}

	public static void clickLogIn(WebDriver driver) {
		we = driver.findElement(By.xpath(BUTTON_XPATH));
		we.click();
	}

}
