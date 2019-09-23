package rs.itbootcamp.humanity.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityStuff {

	public static final String URLSTUFF = "https://fpn1.humanity.com/app/staff/list/load/true/";

	private static final String ADD_BUTTON_XPATH = "//button[@id='act_primary']"; // dodavanje zaposlenih
	private static final String NAME_1 = "//input[@id='_asf"; // prvi deo xpatha polja NAME
	private static final String LASTNAME_1 = "//input[@id='_asl"; // prvi deo xpatha polja LAST NAME
	private static final String MAIL_1 = "//input[@id='_ase";// prvi deo xpatha polja MAIL
	private static final String PICTURE_1="//img[@id='_asi";//prvi deo xpatha za sliku
	private static final String PART_2 = "']";// drugi deo xpatha
	private static final String SAVE_XPATH = "//button[@id='_as_save_multiple']";// cuva unete zaposlene
	private static final String EMPLOYEE = "//a[@class='staff-employee']"; // pristupa unetom zaposlenom

	static WebElement we = null;

	public static void addButton(WebDriver driver) {
		we = driver.findElement(By.xpath(ADD_BUTTON_XPATH));
		we.click();
	}

	public static WebElement enterName(WebDriver driver, int brojZaposlenih, String data) {
		for (int i = 1; i <= brojZaposlenih; i++) {
			we = driver.findElement(By.xpath(NAME_1 + i + PART_2));
			we.sendKeys(data + i);
		}
		return we;

	}

	public static WebElement enterLastName(WebDriver driver, int brojZaposlenih, String data) {
		for (int i = 1; i <= brojZaposlenih; i++) {
			we = driver.findElement(By.xpath(LASTNAME_1 + i + PART_2));
			we.sendKeys(data + i);
		}
		return we;

	}

	public static WebElement enterMail(WebDriver driver, int brojZaposlenih, String data) {
		for (int i = 1; i <= brojZaposlenih; i++) {
			we = driver.findElement(By.xpath(MAIL_1 + i + PART_2));
			we.sendKeys(i+data);
		}
		return we;

	}

	
	
	
	public static void clickSave(WebDriver driver) {
		we = driver.findElement(By.xpath(SAVE_XPATH));
		we.click();
	}

	public static void getEmployee (WebDriver driver, int brojZaposlenih, String path) {
		for (int i = 1; i <= brojZaposlenih; i++) {
			we = driver.findElement(By.xpath(EMPLOYEE));
			we.getAttribute("value");
		}
		
		
	}
	
	
}
