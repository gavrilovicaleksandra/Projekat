package rs.itbootcamp.humanity.start;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import rs.itbootcamp.humanity.page.objects.HumanityHome;
import rs.itbootcamp.humanity.page.objects.HumanityMenu;
import rs.itbootcamp.humanity.page.objects.HumanityStuff;

public class GlavniProgram {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Dobrodosli u test WEBPAGE-a!");
		System.out.println("Za Chrome odaberi 1");
		System.out.println("Za Firefox odaberi 2");
		System.out.println("Za izlaz odaberi 0");

		Scanner sc = new Scanner(System.in);
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
				driver.get(HumanityHome.URLHOME);
				HumanityHome.kuki(driver);
				HumanityHome.setName(driver, "Alex ggg");
				HumanityHome.setMail(driver, "alejhjbkx@gmaill.com");
				HumanityHome.submit(driver);
				driver.quit();
				driver.get(HumanityMenu.URLDASH);
				HumanityMenu.enterMail(driver);
				HumanityMenu.enterPass(driver);
				HumanityMenu.logIn(driver);
				driver.quit();

				break;
			case 2:
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				WebDriver gdriver = new FirefoxDriver();
				gdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				gdriver.manage().window().maximize();
				gdriver.get(HumanityStuff.URLSTUFF);
				HumanityStuff.enterName(gdriver, 2, "Ale");
				HumanityStuff.enterLastName(gdriver, 2, "Ale");
				HumanityStuff.enterMail(gdriver, 2, "@ale.com");
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
