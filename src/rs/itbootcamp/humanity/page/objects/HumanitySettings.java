package rs.itbootcamp.humanity.page.objects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HumanitySettings {

	public static final String URL = "https://fpn1.humanity.com/app/admin/settings/";

	private static final String USERNAME_XPATH = "//input[@id='email']";
	private static final String PASSWORD_XPATH = "//input[@id='password']";
	private static final String BUTTON_XPATH = "//button[contains(text(),'Log in')]";
	
	public static final String COUNTRY_XPATH="//select[@id='country']";
	public static final String LANGUAGE_XPATH="//select[@name='language']";
	public static final String TIME_FORMAT_XPATH="//select[@name='pref_24hr']";

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

	public static Select getCountry(WebDriver driver) {
		return new Select(driver.findElement(By.xpath(COUNTRY_XPATH)));
	}

	public static void setCountry(WebDriver driver, String data) {
		getCountry(driver).selectByVisibleText(data);
	}
	public static Select getLanguage(WebDriver driver) {
		return new Select(driver.findElement(By.xpath(LANGUAGE_XPATH)));
	}

	public static void setLanguage(WebDriver driver) throws AWTException, InterruptedException {
		we=driver.findElement(By.xpath(LANGUAGE_XPATH));
		we.click();
		Robot robot=new Robot ();
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		
	}
	
	public static void setTime (WebDriver driver) throws AWTException {
		we=driver.findElement(By.xpath(TIME_FORMAT_XPATH));
		we.click();
		Robot robot=new Robot ();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	
	
}
