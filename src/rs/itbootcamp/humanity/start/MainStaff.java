package rs.itbootcamp.humanity.start;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rs.itbootcamp.humanity.page.objects.HumanityStaff;;

public class MainStaff {

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
				driver.get(HumanityStaff.URL);

				HumanityStaff.enterMail(driver, "alex@temp-link.net");
				HumanityStaff.enterPass(driver, "flower");
				HumanityStaff.logIn(driver);
				Thread.sleep(3000);
				HumanityStaff.addButton(driver);
				Thread.sleep(5000);
				HumanityStaff.enterName(driver, 3, "mirko");
				Thread.sleep(7000);
				HumanityStaff.enterLastName(driver, 3, "peric");
				Thread.sleep(7000);
				HumanityStaff.enterMail(driver, 3, "m@r.re");
				Thread.sleep(7000);
				HumanityStaff.clickSave(driver);
				Thread.sleep(7000);
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

				Thread.sleep(3000);
				HumanityStaff.addButton(gdriver);
				Thread.sleep(3000);
				HumanityStaff.enterName(gdriver, 3, "mirko");
				Thread.sleep(3000);
				HumanityStaff.enterLastName(gdriver, 3, "peric");
				Thread.sleep(3000);
				HumanityStaff.enterMail(gdriver, 3, "m@r.re");
				Thread.sleep(3000);
				HumanityStaff.clickSave(gdriver);
				Thread.sleep(5000);
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
