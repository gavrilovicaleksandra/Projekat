package rs.itbootcamp.humanity.start;

import java.awt.AWTException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rs.itbootcamp.humanity.page.objects.HumanitySettings;;

public class MainSettings {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, AWTException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Dobrodosli u test WEBPAGE-a!");
		System.out.println("Za Chrome odaberi 1");
		System.out.println("Za Firefox odaberi 2");
		System.out.println("Za izlaz odaberi 0");

		int s;
		do {
			System.out.print("Odaberi pretrazivac: Chrome ili Firefox ");
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
				HumanitySettings.enterPass(driver, "flower");
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
				System.out.println("Los unos!");
				break;
			case 0:
				System.out.println("Izlaz iz testa!");
				break;
			}
		} while (s != 0);
		sc.close();
	}

}
