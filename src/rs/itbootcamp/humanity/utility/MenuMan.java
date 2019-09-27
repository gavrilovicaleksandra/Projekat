package rs.itbootcamp.humanity.utility;

import java.awt.AWTException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rs.itbootcamp.humanity.page.objects.HumanityMenu;;

public class MenuMan {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, AWTException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to www.humanity.com!");
		System.out.println("For Chrome choose 1");
		System.out.println("For Firefox choose 2");
		System.out.println("To exit choose 0");


		int l;
		do {
			System.out.print("Chrome or Firefox? ");
			l = sc.nextInt();
			switch (l) {

			case 1:
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get(HumanityMenu.URL);
				Thread.sleep(3000);
				HumanityMenu.enterMail(driver, "alex@temp-link.net");
				HumanityMenu.enterPass(driver, "flower");
				HumanityMenu.logIn(driver);
				Thread.sleep(3000);
								HumanityMenu.clickShift(driver);
				Thread.sleep(3000);
				HumanityMenu.clickTime(driver);
				Thread.sleep(3000);
				HumanityMenu.clickLeave(driver);
				Thread.sleep(3000);
				HumanityMenu.clickTraining(driver);
				Thread.sleep(3000);
				HumanityMenu.clickStuff(driver);
				Thread.sleep(3000);
				HumanityMenu.clickPay(driver);
				Thread.sleep(3000);
				HumanityMenu.clickReport(driver);
				Thread.sleep(3000);
				HumanityMenu.clickSettings(driver);
				Thread.sleep(3000);
				HumanityMenu.clickDash(driver);
				Thread.sleep(3000);
				
				driver.quit();

				break;
			case 2:
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				WebDriver gdriver = new FirefoxDriver();
				gdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				gdriver.manage().window().maximize();
				gdriver.get(HumanityMenu.URL);
				Thread.sleep(3000);
				HumanityMenu.enterMail(gdriver,"alex@temp-link.net");
				HumanityMenu.enterPass(gdriver, "flower");
				HumanityMenu.logIn(gdriver);
				Thread.sleep(3000);
				HumanityMenu.clickShift(gdriver);
				Thread.sleep(3000);
				HumanityMenu.clickTime(gdriver);
				Thread.sleep(3000);
				HumanityMenu.clickLeave(gdriver);
				Thread.sleep(3000);
				HumanityMenu.clickTraining(gdriver);
				Thread.sleep(3000);
				HumanityMenu.clickStuff(gdriver);
				Thread.sleep(3000);
				HumanityMenu.clickPay(gdriver);
				Thread.sleep(3000);
				HumanityMenu.clickReport(gdriver);
				Thread.sleep(3000);
				HumanityMenu.clickSettings(gdriver);
				Thread.sleep(3000);
				HumanityMenu.clickDash(gdriver);
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
		} while (l != 0);
		sc.close();
	}

}
