package rs.itbootcamp.humanity.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rs.itbootcamp.humanity.page.objects.HumanityEditStaff;
import rs.itbootcamp.humanity.page.objects.HumanityLogIn;
import rs.itbootcamp.humanity.page.objects.HumanityStaff;;

public class LogInMan {
	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to www.humanity.com!");
		System.out.println("Enter mail, you can use mine'alex@temp-link.net'");
		String mail = sc.nextLine();
		System.out.println("Enter pass, you can use mine 'flower'");
		String pass = sc.nextLine();
		System.out.println("For Chrome choose 1");
		System.out.println("For Firefox choose 2");
		System.out.println("To exit choose 0");

		int s;
		do {
			System.out.print("Chrome or Firefox? ");
			s = sc.nextInt();
			switch (s) {

			case 1:
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get(HumanityLogIn.URl);
				Thread.sleep(3000);
				HumanityLogIn.cookieAlert(driver);
				HumanityLogIn.logIn(driver);
				HumanityLogIn.enterUser(driver, mail);
				HumanityLogIn.enterPassword(driver, pass);
				HumanityLogIn.clickLogIn(driver);
				Thread.sleep(3000);
				driver.quit();

				break;

			case 2:
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				WebDriver gdriver = new FirefoxDriver();
				gdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				gdriver.manage().window().maximize();
				gdriver.get(HumanityLogIn.URl);
				Thread.sleep(3000);
				HumanityLogIn.cookieAlert(gdriver);
				HumanityLogIn.logIn(gdriver);
				HumanityLogIn.enterUser(gdriver, mail);
				HumanityLogIn.enterPassword(gdriver, pass);
				HumanityLogIn.clickLogIn(gdriver);
				Thread.sleep(3000);
				gdriver.quit();
				break;
			default:
				System.out.println("Error! Choose again 0, 1 or 2");
				break;
			case 0:
				System.out.println("exit!");
				break;
			}
		} while (s != 0);
		sc.close();

	}

}
