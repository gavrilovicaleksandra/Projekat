package rs.itbootcamp.humanity.page.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import rs.itbootcamp.humanity.page.objects.HumanityEditStaff;
import rs.itbootcamp.humanity.page.objects.HumanityStaff;

public class HumanityAddNewEmployeeTests {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(HumanityStaff.URL);

		
	
		try {
		HumanityStaff.enterMail(driver, "alex@temp-link.net");
		HumanityStaff.enterPass(driver, "flower");
		HumanityStaff.logIn(driver);
		Thread.sleep(3000);
		}catch (Exception e) {
			System.out.println("Error is in "+e);
		}
		
		try {
		HumanityStaff.addButton(driver);
		Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println("Error is in "+e);
		}
		
		
		
		File src = new File("Data.xls");
		FileInputStream fis = new FileInputStream(src);
		HSSFWorkbook wbe = new HSSFWorkbook(fis);
		HSSFSheet sheet1 = wbe.getSheetAt(1);
		int rowcount = sheet1.getLastRowNum();

		try {
			for (int i = 1; i <=rowcount; i++) {
				HSSFRow r = sheet1.getRow(i);
				if (r != null) {
					String name = r.getCell(0).getStringCellValue();
					String surname = r.getCell(1).getStringCellValue();
					String mail = r.getCell(2).getStringCellValue();
					HumanityStaff.inputFirstName(driver, name, i);
					HumanityStaff.inputLastName(driver, surname, i);
					HumanityStaff.inputEmail(driver, mail, i);
				} else {
					System.out.println("EMPTY ROW [" + i + "]");
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("Gotovo");}
			wbe.close();
			Thread.sleep(7000);
			driver.quit();

			
			
			
			
		
			
			
			
			
			
			
			
			
	}

}
