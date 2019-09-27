package rs.itbootcamp.humanity.utility;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rs.itbootcamp.humanity.page.objects.HumanityEditStaff;

public class EditStaffAuto {

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to www.humanity.com!");
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
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get(HumanityEditStaff.URL);

				try {
					HumanityEditStaff.enterMail(driver, "alex@temp-link.net");
					HumanityEditStaff.enterPass(driver, "flower");
					HumanityEditStaff.logIn(driver);
					Thread.sleep(3000);
				} catch (Exception e) {
					System.out.println("Error in " + e);
				}

				try {
					System.out.println(HumanityEditStaff.employeeExistance(driver, "Alex"));
				} catch (Exception e) {
					System.out.println("Error in " + e);
				}

				try {
					System.out.println(HumanityEditStaff.getList(driver));
				} catch (Exception e) {
					System.out.println("Error in " + e);
				}
				try {
					HumanityEditStaff.editThisEmployee(driver, "Alex");
					HumanityEditStaff.clickEdit(driver);
					HumanityEditStaff.setNickname(driver, "Aki");
					Thread.sleep(3000);

					HumanityEditStaff.uploadPicture(driver);
					Thread.sleep(9000);

					HumanityEditStaff.clickSave(driver);
					Thread.sleep(5000);
				} catch (Exception e) {
					System.out.println("Error in " + e);
				}

				driver.quit();

				break;
			case 2:
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				WebDriver gdriver = new FirefoxDriver();
				gdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				gdriver.manage().window().maximize();
				gdriver.get(HumanityEditStaff.URL);

				HumanityEditStaff.enterMail(gdriver, "alex@temp-link.net");
				HumanityEditStaff.enterPass(gdriver, "flower");
				HumanityEditStaff.logIn(gdriver);
				System.out.println(HumanityEditStaff.employeeExistance(gdriver, "Alex"));
				System.out.println(HumanityEditStaff.getList(gdriver));
				HumanityEditStaff.editThisEmployee(gdriver, "Alex");
				HumanityEditStaff.clickEdit(gdriver);
				HumanityEditStaff.setNickname(gdriver, "Aki");
				Thread.sleep(3000);
				HumanityEditStaff.uploadPicture(gdriver);
				Thread.sleep(9000);
				HumanityEditStaff.clickSave(gdriver);
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
		} while (s != 0);
		sc.close();

	}

}
