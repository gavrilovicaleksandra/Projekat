package rs.itbootcamp.humanity.utility;

import java.awt.AWTException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rs.itbootcamp.humanity.page.objects.HumanitySettings;;

public class SettingsMan {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, AWTException {
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
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get(HumanitySettings.URL);
				Thread.sleep(3000);
				HumanitySettings.enterMail(driver, "alex@temp-link.net");
				HumanitySettings.enterPass(driver, "flowejjjr");
				HumanitySettings.logIn(driver);
				Thread.sleep(3000);
				HumanitySettings.setCountry(driver, "Serbia");
				Thread.sleep(3000);
				HumanitySettings.setLanguage(driver);
				Thread.sleep(3000);
				HumanitySettings.setTime(driver);
				Thread.sleep(3000);
				driver.quit();

				break;
			case 2:
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				WebDriver gdriver = new FirefoxDriver();
				gdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				gdriver.manage().window().maximize();
				gdriver.get(HumanitySettings.URL);
				Thread.sleep(3000);
				HumanitySettings.enterMail(gdriver, "alex@temp-link.net");
				HumanitySettings.enterPass(gdriver, "flower");
				HumanitySettings.logIn(gdriver);
				Thread.sleep(3000);
				HumanitySettings.setCountry(gdriver, "Serbia");
				Thread.sleep(3000);
				HumanitySettings.setLanguage(gdriver);
				Thread.sleep(3000);
				HumanitySettings.setTime(gdriver);
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
