package rs.itbootcamp.humanity.utility;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rs.itbootcamp.humanity.page.objects.HumanityEditStaff;

public class EditStaffMan {

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter emlpoyee name ");
		String name = sc.nextLine();
		System.out.println("Enter desired nickname for that employee");
		String nickname = sc.nextLine();
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
					System.out.println(HumanityEditStaff.employeeExistance(driver, "name"));
				} catch (Exception e) {
					System.out.println("Error in " + e);
				}
				try {
					System.out.println(HumanityEditStaff.getList(driver));
				} catch (Exception e) {
					System.out.println("Error in " + e);
				}

				try {
					HumanityEditStaff.editThisEmployee(driver, name);
					HumanityEditStaff.clickEdit(driver);
					HumanityEditStaff.setNickname(driver, nickname);
					Thread.sleep(3000);

					HumanityEditStaff.uploadPicture(driver);
					Thread.sleep(9000);

					HumanityEditStaff.clickSave(driver);
				} catch (Exception e) {
					System.out.println("Error in " + e);
				}

				Thread.sleep(5000);
				driver.quit();

				break;
			case 2:
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				WebDriver gdriver = new FirefoxDriver();
				gdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				gdriver.manage().window().maximize();
				gdriver.get(HumanityEditStaff.URL);

				try {
					HumanityEditStaff.enterMail(gdriver, "alex@temp-link.net");
					HumanityEditStaff.enterPass(gdriver, "flower");
					HumanityEditStaff.logIn(gdriver);
				} catch (Exception e) {
					System.out.println("Error in " + e);
				}

				try {
					System.out.println(HumanityEditStaff.employeeExistance(gdriver, name));
				} catch (Exception e) {
					System.out.println("Error in " + e);
				}
				try {
					System.out.println(HumanityEditStaff.getList(gdriver));
				} catch (Exception e) {
					System.out.println("Error in " + e);
				}
				try {
					HumanityEditStaff.editThisEmployee(gdriver, name);
					HumanityEditStaff.clickEdit(gdriver);
					HumanityEditStaff.setNickname(gdriver, nickname);
					Thread.sleep(3000);
					HumanityEditStaff.uploadPicture(gdriver);
					Thread.sleep(9000);
					HumanityEditStaff.clickSave(gdriver);
				} catch (Exception e) {
					System.out.println("Error in " + e);
				}
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
