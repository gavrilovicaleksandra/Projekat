package rs.itbootcamp.humanity.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityProfile {
	public static final String URL = "https://fpn1.humanity.com/app/admin/settings/";

	private static final String USERNAME_XPATH = "//input[@id='email']";
	private static final String PASSWORD_XPATH = "//input[@id='password']";
	private static final String BUTTON_XPATH = "//button[contains(text(),'Log in')]";

	private static final String DROPDOWN_XPATH = "//i[@class='icon icon-arrowFullDn j-arrowIconToAvatar navBottom__userArrow']";
	private static final String VERSION_XPATH = "//div[@id='humanityAppVersion']";

	private static final String PROFILE_PROFILE_XPATH = "//a[contains(text(),'Profile')]";
	private static final String PROFILE_SETTINGS_XPATH = "//div[@class='userm userm-mainPage']//a[contains(text(),'Settings')]";
	private static final String PROFILE_AVAILABILITY_XPATH = "//div[@class='userm userm-mainPage']//a[contains(text(),'Availability')]";
	private static final String SIGNOUT_XPATH ="//a[contains(text(),'Sign Out')]";
	
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

	public static void dropDownButton(WebDriver driver) {
		we = driver.findElement(By.xpath(DROPDOWN_XPATH));
		we.click();
	}

	public static String printVersion(WebDriver driver) {
		we = driver.findElement(By.xpath(VERSION_XPATH)).findElement(By.tagName("b"));
		return we.getAttribute("innerHTML"); // dohvatimo deo gde se nalazi ispis verzije
	}

	public static void clickProffile(WebDriver driver) {
		we = driver.findElement(By.xpath(PROFILE_PROFILE_XPATH));
		we.click();
	}

	public static void clickSettings(WebDriver driver) {
		we = driver.findElement(By.xpath(PROFILE_SETTINGS_XPATH));
		we.click();
	}

	public static void clickAvailability(WebDriver driver) {
		we = driver.findElement(By.xpath(PROFILE_AVAILABILITY_XPATH));
		we.click();
	}

	public static void clickSignOut(WebDriver driver) {
		we = driver.findElement(By.xpath(SIGNOUT_XPATH));
		we.click();
	}

	
	
}
