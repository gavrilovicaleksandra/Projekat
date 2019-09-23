package rs.itbootcamp.humanity.page.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

public class HumanityMenu {
	/*
	 * HumanityMenu - predstavlja POM Object klasu za stranicu
	 * vasafirma.humanity.com/app/dashboard/ Realizovati pristup sledecim elementima
	 * na toj stranici:
	 */

	public static final String URLDASH = "https://fpn1.humanity.com/app/dashboard/";
	private static final String INPUTMAIL = "//input[@id='email']";
	private static final String INPUTPASS = "//input[@id='password']";
	private static final String DASH_XPATH = "//div[@id='_nav']//li[1]";
	private static final String SHIFT_XPATH = "//div[@id='_nav']//li[2]";
	private static final String TIME_XPATH = "//div[@id='_nav']//li[3]";
	private static final String LEAVE_XPATH = "//div[@id='_nav']//li[4]";
	private static final String TRAIN_XPATH = "//div[@id='_nav']//li[5]";
	private static final String STUFF_XPATH = "//div[@id='_nav']//li[6]";
	private static final String PAY_XPATH = "//div[@id='_nav']//li[7]";
	private static final String REPORT_XPATH = "//div[@id='_nav']//li[8]";

	static WebElement we = null;

	public static WebElement enterMail(WebDriver driver) {
		we = driver.findElement(By.xpath(INPUTMAIL));
		we.sendKeys("alex@temp-link.net");
		return we;
	}

	public static WebElement enterPass(WebDriver driver) {
		we = driver.findElement(By.xpath(INPUTPASS));
		we.sendKeys("flower");
		return we;
	}

	public static void logIn(WebDriver driver) {
		we = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		we.click();
	}

	public static void ClickDash(WebDriver driver) {
		we = driver.findElement(By.xpath(DASH_XPATH));
		we.click();
	}

	public static void ClickShift(WebDriver driver, String data) {
		we = driver.findElement(By.xpath(SHIFT_XPATH));
		we.click();

	}

	public static void ClickTime(WebDriver driver) {
		we = driver.findElement(By.xpath(TIME_XPATH));
		we.click();
	}

	public static void ClickLeave(WebDriver driver) {
		we = driver.findElement(By.xpath(LEAVE_XPATH));
		we.click();

	}

	public static void ClickTraining(WebDriver driver) {
		we = driver.findElement(By.xpath(TRAIN_XPATH));
		we.click();
	}

	public static void ClickStuff(WebDriver driver) {
		we = driver.findElement(By.xpath(STUFF_XPATH));
		we.click();
	}

	public static void ClickPay(WebDriver driver) {
		we = driver.findElement(By.xpath(PAY_XPATH));
		we.click();
	}

	public static void ClickReport(WebDriver driver) {
		we = driver.findElement(By.xpath(REPORT_XPATH));
		we.click();
	}

}
