package rs.itbootcamp.humanity.page.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import rs.itbootcamp.humanity.page.objects.HumanityStaff;
import rs.itbootcamp.humanity.utility.ExcelUtils;

/*
 * Login-> Staff -> Add Employees -> Dodavanje novog zaposlenog Takodje je
 * potrebno proveriti da li je dodavanje zaposlenog bilo uspesno. Napomena:
 * Metoda driver.findElement(...) baca gresku/izuzetak/exception ukoliko nije u
 * mogucnosti da pronadje element. Pored toga primetiti da svaki radnik koji se
 * doda poseduje svoj XPath koji izgleda ovako: //a[contains(text(),'IME
 * PREZIME’)] gde su IME i PREZIME podaci koje smo uneli radniku.
 */

public class HumanityLoginTests {
	private static HSSFWorkbook wb = null;
	private static HSSFSheet sheet = null;
	private static String excellPath;

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(HumanityStaff.URL);
		HumanityStaff.enterMail(driver, "alex@temp-link.net");
		HumanityStaff.enterPass(driver, "flower");
		HumanityStaff.logIn(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		HumanityStaff.addButton(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		ExcelUtils.setExcell("Data.xls");
		ExcelUtils.setWorkSheet(0);
		int rowcount = ExcelUtils.getRowNumber();
		Thread.sleep(5000);
		
		
		
			HumanityStaff.clickSave(driver);
			ExcelUtils.closeExcell();
			driver.quit();
		}

	}
