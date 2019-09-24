package rs.itbootcamp.humanity.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import rs.itbootcamp.humanity.page.objects.HumanityStaff;

public class HumanityAddEmployee {

	public static void main(String[] args) throws IOException {
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

		File src = new File("Data.xls");
		FileInputStream fis = new FileInputStream(src);
		HSSFWorkbook wbe = new HSSFWorkbook(fis);
		HSSFSheet sheet1 = wbe.getSheetAt(0);
		int rowcount = sheet1.getLastRowNum();
		System.out.println("Unosimo" + rowcount + "zaposlenih");

		try {
			for (int i = 0; i <= rowcount; i++) {
				HSSFRow r = sheet1.getRow(i);
				if (r != null) {
					String name = r.getCell(0).getStringCellValue();
					String surname = r.getCell(1).getStringCellValue();
					String mail = r.getCell(2).getStringCellValue();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

					HumanityStaff.inputFirstName(driver, name, i+1);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

					HumanityStaff.inputLastName(driver, surname, i+1);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

					HumanityStaff.inputEmail(driver, mail, i+1);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

					HumanityStaff.clickSave(driver);
					
				} else {
					System.out.println("EMPTY ROW [" + i + "]");
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("Gotovo");}
			wbe.close();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//driver.quit();

		}
	}
