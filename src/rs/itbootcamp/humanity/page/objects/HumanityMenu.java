package rs.itbootcamp.humanity.page.objects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityMenu {

	public static final String URL = "https://fpn1.humanity.com/app/dashboard/";

	private static final String USERNAME_XPATH = "//input[@id='email']";
	private static final String PASSWORD_XPATH = "//input[@id='password']";
	private static final String BUTTON_XPATH = "//button[contains(text(),'Log in')]";

	private static final String DIALOG_BOX = "//span[@class='intercom-anchor intercom-1tdusvr e12dv51w1']";

	private static final String DASH_XPATH = "//div[@id='_nav']//li[1]";
	private static final String SHIFT_XPATH = "//div[@id='_nav']//li[2]";
	private static final String TIME_XPATH = "//div[@id='_nav']//li[3]";
	private static final String LEAVE_XPATH = "//div[@id='_nav']//li[4]";
	private static final String TRAIN_XPATH = "//div[@id='_nav']//li[5]";
	private static final String STUFF_XPATH = "//div[@id='_nav']//li[6]";
	private static final String PAY_XPATH = "//div[@id='_nav']//li[7]";
	private static final String REPORT_XPATH = "//div[@id='_nav']//li[8]";
	private static final String SETINGS_XPATH = "//a[@id='sn_admin']";

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

	public static void closeDialog(WebDriver driver) throws AWTException, InterruptedException {
		we = driver.findElement(By.xpath(DIALOG_BOX));
		if (we.isDisplayed() || we.isEnabled()) {
			Alert alert = driver.switchTo().alert();
			Robot robot = new Robot();
			robot.mouseMove(1250, 1);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(2000);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		}

	}

	public static void clickDash(WebDriver driver) {
		we = driver.findElement(By.xpath(DASH_XPATH));
		we.click();
	}

	public static void clickShift(WebDriver driver) {
		we = driver.findElement(By.xpath(SHIFT_XPATH));
		we.click();
	}

	public static void clickTime(WebDriver driver) {
		we = driver.findElement(By.xpath(TIME_XPATH));
		we.click();
	}

	public static void clickLeave(WebDriver driver) {
		we = driver.findElement(By.xpath(LEAVE_XPATH));
		we.click();
	}

	public static void clickTraining(WebDriver driver) {
		we = driver.findElement(By.xpath(TRAIN_XPATH));
		we.click();
	}

	public static void clickStuff(WebDriver driver) {
		we = driver.findElement(By.xpath(STUFF_XPATH));
		we.click();
	}

	public static void clickPay(WebDriver driver) {
		we = driver.findElement(By.xpath(PAY_XPATH));
		we.click();
	}

	public static void clickReport(WebDriver driver) {
		we = driver.findElement(By.xpath(REPORT_XPATH));
		we.click();
	}

	public static void clickSettings(WebDriver driver) {
		we = driver.findElement(By.xpath(SETINGS_XPATH));
		we.click();
	}

}
