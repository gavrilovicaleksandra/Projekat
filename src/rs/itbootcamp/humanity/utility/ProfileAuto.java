package rs.itbootcamp.humanity.utility;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rs.itbootcamp.humanity.page.objects.HumanityProfile;

public class ProfileAuto {
	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to www.humanity.com!");
		System.out.println("For Chrome choose 1");
		System.out.println("For Firefox choose 2");
		System.out.println("To exit choose 0");


		int b;
		do {
			System.out.print("Chrome or Firefox? ");
			b = sc.nextInt();
			switch (b) {

			case 1:
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get(HumanityProfile.URL);
				Thread.sleep(3000);
				HumanityProfile.enterMail(driver, "alex@temp-link.net");
				HumanityProfile.enterPass(driver, "flower");
				HumanityProfile.logIn(driver);
				Thread.sleep(3000);
				System.out.println(HumanityProfile.printVersion(driver));
				Thread.sleep(3000);
				HumanityProfile.dropDownButton(driver);
				HumanityProfile.clickAvailability(driver);
				Thread.sleep(3000);
				HumanityProfile.dropDownButton(driver);
				HumanityProfile.clickProffile(driver);
				;
				Thread.sleep(3000);
				HumanityProfile.dropDownButton(driver);
				HumanityProfile.clickSettings(driver);
				Thread.sleep(3000);
				
				HumanityProfile.dropDownButton(driver);
				HumanityProfile.clickSignOut(driver);
				Thread.sleep(3000);
				
				driver.quit();

				break;
			case 2:
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				WebDriver gdriver = new FirefoxDriver();
				gdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				gdriver.manage().window().maximize();
				gdriver.get(HumanityProfile.URL);
				Thread.sleep(3000);
				HumanityProfile.enterMail(gdriver, "alex@temp-link.net");
				HumanityProfile.enterPass(gdriver, "flower");
				HumanityProfile.logIn(gdriver);
				Thread.sleep(3000);
				System.out.println("This web page version is: "+HumanityProfile.printVersion(gdriver));				Thread.sleep(3000);
				HumanityProfile.dropDownButton(gdriver);
				HumanityProfile.clickAvailability(gdriver);
				Thread.sleep(3000);
				HumanityProfile.dropDownButton(gdriver);
				HumanityProfile.clickProffile(gdriver);
				;
				Thread.sleep(3000);
				HumanityProfile.dropDownButton(gdriver);
				HumanityProfile.clickSettings(gdriver);
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
		} while (b != 0);
		sc.close();
	}

}
