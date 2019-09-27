package rs.itbootcamp.humanity.utility;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import rs.itbootcamp.humanity.page.objects.HumanityHome;

public class HomeMan {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to www.humanity.com!");
		System.out.print("Enter name to test (minimum 6 characters): ");
		String ime = sc.nextLine();
		System.out.print("Enter mail to test: ");
		String mail = sc.nextLine();
		System.out.println();
		System.out.println("Welcome to www.humanity.com!");
		System.out.println("For Chrome choose 1");
		System.out.println("For Firefox choose 2");
		System.out.println("To exit choose 0");

		int p;
		do {
			System.out.print("Chrome or Firefox? ");
			p = sc.nextInt();
			switch (p) {

			case 1:
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get(HumanityHome.URL);
				Thread.sleep(1000);
				HumanityHome.cookieAlert(driver);
				HumanityHome.setName(driver, ime);
				HumanityHome.setMail(driver, mail);
				Thread.sleep(1000);
				HumanityHome.submit(driver);
				Thread.sleep(1000);
				driver.quit();

				break;
			case 2:
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				WebDriver gdriver = new FirefoxDriver();
				gdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				gdriver.manage().window().maximize();
				gdriver.get(HumanityHome.URL);
				Thread.sleep(1000);
				HumanityHome.cookieAlert(gdriver);
				HumanityHome.setName(gdriver, ime);
				HumanityHome.setMail(gdriver, mail);
				Thread.sleep(1000);
				HumanityHome.submit(gdriver);
				Thread.sleep(1000);
				gdriver.quit();
				gdriver.quit();
				break;
			default:
				System.out.println("Error! Choose again 0, 1 or 2");
				break;
			case 0:
				System.out.println("exit!");
				break;
			}
		} while (p != 0);
		sc.close();

	}

}
