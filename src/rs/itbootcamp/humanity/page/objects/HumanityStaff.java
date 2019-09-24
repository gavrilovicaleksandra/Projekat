package rs.itbootcamp.humanity.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityStaff {

	public static final String URL = "https://fpn1.humanity.com/app/staff/list/load/true/";

	private static final String USERNAME_XPATH = "//input[@id='email']";
	private static final String PASSWORD_XPATH = "//input[@id='password']";
	private static final String BUTTON_XPATH = "//button[contains(text(),'Log in')]";

	private static final String ADD_BUTTON_XPATH = "//button[@id='act_primary']"; 
	private static final String NAME_1 = "//input[@id='_asf"; // prvi deo xpatha polja NAME
	private static final String LASTNAME_1 = "//input[@id='_asl"; // prvi deo xpatha polja LAST NAME
	private static final String MAIL_1 = "//input[@id='_ase";// prvi deo xpatha polja MAIL
	private static final String PART_2 = "']";// drugi deo xpatha
	private static final String SAVE_XPATH = "//button[@id='_as_save_multiple']";// cuva unete zaposlene
	
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

	public static void addButton(WebDriver driver) {
		we = driver.findElement(By.xpath(ADD_BUTTON_XPATH));
		we.click();
	}

	public static WebElement getFirstName (WebDriver driver, int i) {
		return driver.findElement(By.xpath(NAME_1+i+PART_2));
	}
	
public static void inputFirstName(WebDriver driver, String firstname, int i) {
		getFirstName(driver, i).sendKeys(firstname);
	}
	
	public static WebElement getLastName (WebDriver driver, int i) {
		return driver.findElement(By.xpath(LASTNAME_1+i+PART_2));
	}
		
	public static void inputLastName(WebDriver driver, String Lastname, int i) {
		getLastName(driver, i).sendKeys(Lastname);
	}		
		
	public static WebElement getEmail (WebDriver driver, int i) {
		return driver.findElement(By.xpath(MAIL_1+i+PART_2));
	}
			
	public static void inputEmail(WebDriver driver, String email, int i) {
		getEmail(driver, i).sendKeys(email);
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
			we.sendKeys(i + data);
		}
		return we;
	}

	public static void clickSave(WebDriver driver) {
		we = driver.findElement(By.xpath(SAVE_XPATH));
		we.click();
	}



	}


