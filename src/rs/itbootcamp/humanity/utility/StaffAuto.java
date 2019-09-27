package rs.itbootcamp.humanity.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rs.itbootcamp.humanity.page.objects.HumanityStaff;;

public class StaffAuto {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to www.humanity.com!");
		System.out.println("For Chrome choose 1");
		System.out.println("For Firefox choose 2");
		System.out.println("To exit choose 0");

		int x;
		do {
			System.out.print("Chrome or Firefox? ");
			x = sc.nextInt();
			switch (x) {

			case 1:
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get(HumanityStaff.URL);

				HumanityStaff.enterMail(driver, "alex@temp-link.net");
				HumanityStaff.enterPass(driver, "flower");
				HumanityStaff.logIn(driver);
				Thread.sleep(3000);
				HumanityStaff.addButton(driver);
				Thread.sleep(3000);
				
				
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
				
				
				
				
				
				/*HumanityStaff.inputFirstName(driver, "firstName", 1);
				HumanityStaff.inputLastName(driver, "lastName", 1);
				HumanityStaff.inputEmail(driver, "email@kecek.ikcne", 1);

				HumanityStaff.enterName(driver, 3, "miurko");
				Thread.sleep(7000);
				HumanityStaff.enterLastName(driver, 3, "perjic");
				Thread.sleep(7000);
				HumanityStaff.enterMail(driver, 3, "jm@r.re");
				Thread.sleep(7000);
				HumanityStaff.clickSave(driver);*/

				Thread.sleep(7000);
				driver.quit();

				break;
			case 2:
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				WebDriver gdriver = new ChromeDriver();
				gdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				gdriver.manage().window().maximize();
				gdriver.get(HumanityStaff.URL);

				HumanityStaff.enterMail(gdriver, "alex@temp-link.net");
				HumanityStaff.enterPass(gdriver, "flower");
				HumanityStaff.logIn(gdriver);
				Thread.sleep(3000);
				HumanityStaff.addButton(gdriver);
				Thread.sleep(3000);
				
				
				File srcF = new File("Data.xls");
				FileInputStream fisF = new FileInputStream(srcF);
				HSSFWorkbook wbeF = new HSSFWorkbook(fisF);
				HSSFSheet sheet1F = wbeF.getSheetAt(1);
				int rowcountF = sheet1F.getLastRowNum();

				try {
					for (int i = 1; i <=rowcountF; i++) {
						HSSFRow r = sheet1F.getRow(i);
						if (r != null) {
							String name = r.getCell(0).getStringCellValue();
							String surname = r.getCell(1).getStringCellValue();
							String mail = r.getCell(2).getStringCellValue();
							HumanityStaff.inputFirstName(gdriver, name, i);
							HumanityStaff.inputLastName(gdriver, surname, i);
							HumanityStaff.inputEmail(gdriver, mail, i);
						} else {
							System.out.println("EMPTY ROW [" + i + "]");
						}
					}

				} catch (Exception e) {
					System.out.println(e.toString());
				} finally {
					System.out.println("Gotovo");}
					wbeF.close();
				Thread.sleep(5000);
				gdriver.quit();
				break;
			default:
				System.out.println("Error! Choose again 0, 1 or 2");
				break;
			case 0:
				System.out.println("exit!");
				break;
			}
		} while (x != 0);
		sc.close();

	}

}
