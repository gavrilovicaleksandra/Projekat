package rs.itbootcamp.humanity.start;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rs.itbootcamp.humanity.page.objects.HumanityProfile;

public class MainProfile {
	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {


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
				driver.get(HumanityProfile.URL);
				Thread.sleep(3000);
				HumanityProfile.enterMail(driver, "alex@temp-link.net");
				HumanityProfile.enterPass(driver, "flower");
				HumanityProfile.logIn(driver);
				Thread.sleep(3000);
				System.out.println(HumanityProfile.getVersion(driver));

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
				HumanityProfile.getVersion(gdriver);

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
