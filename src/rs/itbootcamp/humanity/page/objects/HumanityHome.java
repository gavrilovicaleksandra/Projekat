package rs.itbootcamp.humanity.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityHome {

	// HumanityHome -
	// predstavlja POM Object klasu za stranicu www.humanity.com
	// Realizovati pristup sledecim elementima na toj stranici:

	public static final String URLHOME = "https://www.humanity.com";

	private static final String COOKIE_ID = "cookieconsent:desc";

	private static final String NAME_XPATH = "//div[@class='input-wrapper']//input[@placeholder='Full Name']";
	private static final String MAIL_XPATH = "//div[@class='input-wrapper']//input[@placeholder='Work Email']";
	private static final String START_DOWN_XPATH = "//input[@id='free-trial-link-01']";
	private static final String START_UP_XPATH = "//a[@class='button pale']";
	private static final String LOGIN_XPATH = "//p[contains(text(),'LOGIN')]";
	private static final String ABOUT_XPATH = "//a[@class='nav-link no-before'][contains(text(),'About us')]";

	static WebElement we = null;

	public static WebElement kuki(WebDriver driver) {
		we = driver.findElement(By.id(COOKIE_ID));
		we.click();
		return we;
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
		we = driver.findElement(By.xpath(START_DOWN_XPATH));
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
