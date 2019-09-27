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

public class StaffMan {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to www.humanity.com!");
		System.out.println("Enter name to input in list ");
		String name=sc.nextLine();
		System.out.println("Enter last name ");
		String lname=sc.nextLine();
		System.out.println("Enter a mail");
		String mail=sc.nextLine();
		
		
		
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
				HumanityStaff.inputFirstName(driver, name, 1);
				HumanityStaff.inputLastName(driver, lname, 1);
				HumanityStaff.inputEmail(driver, mail, 1);
				Thread.sleep(4000);
				driver.quit();
				break;
			case 2:
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				WebDriver gdriver = new FirefoxDriver();
				gdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				gdriver.manage().window().maximize();
				gdriver.get(HumanityStaff.URL);
				HumanityStaff.enterMail(gdriver, "alex@temp-link.net");
				HumanityStaff.enterPass(gdriver, "flower");
				HumanityStaff.logIn(gdriver);
				Thread.sleep(5000);
			
				try {
				
				HumanityStaff.addButton(gdriver);
				
				}catch (Exception e) {
					System.out.println("Error is in "+e);
				}
				
				
				Thread.sleep(3000);
				HumanityStaff.inputFirstName(gdriver, name, 1);
				HumanityStaff.inputLastName(gdriver, lname, 1);
				HumanityStaff.inputEmail(gdriver, mail, 1);
				Thread.sleep(4000);
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
