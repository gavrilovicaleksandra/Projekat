package rs.itbootcamp.humanity.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityHome {

	public static final String URL = "https://www.humanity.com";

	private static final String COOKIE_XPATH = "//a[@class='cc-btn cc-dismiss']";
	private static final String NAME_XPATH = "//div[@class='input-wrapper']//input[@placeholder='Full Name']";
	private static final String MAIL_XPATH = "//div[@class='input-wrapper']//input[@placeholder='Work Email']";
	private static final String SUBMIT_XPATH = "//input[@id='free-trial-link-01']";
	private static final String START_UP_XPATH = "//a[@class='button pale']";
	private static final String LOGIN_XPATH = "//p[contains(text(),'LOGIN')]";
	private static final String ABOUT_XPATH = "//a[@class='nav-link no-before'][contains(text(),'About us')]";

	static WebElement we = null;

	public static void cookieAlert(WebDriver driver) {
		we = driver.findElement(By.xpath(COOKIE_XPATH));
		we.click();
	}

	public static WebElement setName(WebDriver driver, String data) {
		we = driver.findElement(By.xpath(NAME_XPATH));
		we.click();
		we.sendKeys(data);
		return we;
	}

	public static WebElement setMail(WebDriver driver, String data) {
		we = driver.findElement(By.xpath(MAIL_XPATH));
		we.click();
		we.sendKeys(data);
		return we;
	}

	public static void submit(WebDriver driver) {
		we = driver.findElement(By.xpath(SUBMIT_XPATH));
		we.click();
	}

	public static void startFreeTrial(WebDriver driver) {
		we = driver.findElement(By.xpath(START_UP_XPATH));
		we.click();

	}

	public static void aboutUs(WebDriver driver) {
		we = driver.findElement(By.xpath(ABOUT_XPATH));
		we.click();
	}

	public static void logIn(WebDriver driver) {
		we = driver.findElement(By.xpath(LOGIN_XPATH));
		we.click();
	}

}
