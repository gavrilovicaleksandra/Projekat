package rs.itbootcamp.humanity.page.objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityEditStaff {

	public static final String URL = "https://fpn1.humanity.com/app/staff/list/load/true/";

	private static final String USERNAME_XPATH = "//input[@id='email']";
	private static final String PASSWORD_XPATH = "//input[@id='password']";
	private static final String BUTTON_XPATH = "//button[contains(text(),'Log in')]";

	private static final String EDIT_XPATH = "//a[contains(text(),'Edit Details')]";
	private static final String PHOTO_XPATH = "//input[@id='fileupload']";
	private static final String NICKNAME_XPATH = "//input[@id='nick_name']";
	private static final String SAVE_XPATH = "//button[@id='act_primary']";

	private static final String EMPLOYEE_XPATH = "//a[contains(text(),'";
	private static final String EMPLOYEE_XPATH_ENDING = "')]";
	private static final String LIST_OF_EMPL_XPATH = "//table[contains(@class,'employeesList')]//tbody";

	private static WebElement we = null;

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

	
	
	
	public static void editThisEmployee(WebDriver driver, String name) {// dohvatimo po tom imenu koje trazimo
		we = driver.findElement(By.xpath(EMPLOYEE_XPATH + name + EMPLOYEE_XPATH_ENDING));
		we.click();
	}

	public static List<String> getList(WebDriver driver) {// daje nam mogucnost da SYSO psotojece zaposlene da mozemo da
															// pristupimo nekom
		List<WebElement> list = driver.findElement(By.xpath(LIST_OF_EMPL_XPATH))
				.findElements(By.className("staff-employee"));
		List<String> listInner = new ArrayList<String>();
		for (WebElement we : list) {
			listInner.add(we.getAttribute("innerHTML"));
		}
		return listInner;
	}

	public static boolean employeeExistance(WebDriver driver, String name) {// da li u listi imamo to ime koje trazimo
		getList(driver).contains(name + " ");
		return true;
	}
	
	

	public static void clickEdit(WebDriver driver) {
		we = driver.findElement(By.xpath(EDIT_XPATH));
		we.click();
	}

	
	
	public static boolean uploadPicture(WebDriver driver) {
		driver.findElement(By.xpath(PHOTO_XPATH)).sendKeys("C:\\Users\\Dell\\Desktop\\s.gif");
		return true;
	}

	public static WebElement setNickname(WebDriver driver, String nickname) {
		we = driver.findElement(By.xpath(NICKNAME_XPATH));
		we.sendKeys(nickname);
		return we;
	}

	public static void clickSave(WebDriver driver) { // cuva izmene
		we = driver.findElement(By.xpath(SAVE_XPATH));
		we.click();
	}

}