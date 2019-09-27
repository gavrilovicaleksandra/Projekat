package rs.itbootcamp.humanity.start;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rs.itbootcamp.humanity.page.objects.HumanityEditStaff;
import rs.itbootcamp.humanity.page.objects.HumanityHome;
import rs.itbootcamp.humanity.page.objects.HumanityMenu;
import rs.itbootcamp.humanity.page.objects.HumanityProfile;
import rs.itbootcamp.humanity.page.objects.HumanitySettings;
import rs.itbootcamp.humanity.page.objects.HumanityStaff;
import rs.itbootcamp.humanity.utility.EditStaffAuto;
import rs.itbootcamp.humanity.utility.EditStaffMan;
import rs.itbootcamp.humanity.utility.HomeAuto;
import rs.itbootcamp.humanity.utility.HomeMan;
import rs.itbootcamp.humanity.utility.LogInAuto;
import rs.itbootcamp.humanity.utility.LogInMan;
import rs.itbootcamp.humanity.utility.MenuAuto;
import rs.itbootcamp.humanity.utility.MenuMan;
import rs.itbootcamp.humanity.utility.ProfileAuto;
import rs.itbootcamp.humanity.utility.ProfileMan;
import rs.itbootcamp.humanity.utility.SettingsAuto;
import rs.itbootcamp.humanity.utility.SettingsMan;
import rs.itbootcamp.humanity.utility.StaffAuto;
import rs.itbootcamp.humanity.utility.StaffMan;

public class GlavniProgram {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Hello! Today you are testing: (choose a number for a desired action)");
		System.out.println("1 - automation testing (using Excel file data)");
		System.out.println("2 - manual testing (you enter data)");
		System.out.println("0 - you don't feel like testing at all (I get it)");

		int n, m;

			System.out.print("Test? ");
			n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println(
						"Good choice! Automation testing is my favorite! Choose which page you would like to test");
				System.out.println("Choose 1 for: Home page");
				System.out.println("Choose 2 for: Menu page");
				System.out.println("Choose 3 for: Profile page");
				System.out.println("Choose 4 for: Staff page");
				System.out.println("Choose 5 for: Edit Staff page");
				System.out.println("Choose 6 for: Settings page");
				System.out.println("Choose 7 for: LogIn page");

				m = sc.nextInt();
				switch (m) {

				case 1:
					HomeAuto.main(args);
					break;

				case 2:
					MenuAuto.main(args);
					break;
				case 3:
					ProfileAuto.main(args);
					break;
				case 4:
					StaffAuto.main(args);
					break;

				case 5:
					EditStaffAuto.main(args);
					break;
				case 6:
					SettingsAuto.main(args);
					break;
				case 7:
					LogInAuto.main(args);
					break;
				}
				break;
			case 2:
				System.out.println("Great! Be prepared for entering a lot of data :)");
				System.out.println("Choose 1 for: Home page");
				System.out.println("Choose 2 for: Menu page");
				System.out.println("Choose 3 for: Profile page");
				System.out.println("Choose 4 for: Staff page");
				System.out.println("Choose 5 for: Edit Staff page");
				System.out.println("Choose 6 for: Settings page");
				System.out.println("Choose 7 for: LogIn page");

				m = sc.nextInt();
				switch (m) {
				case 1:
					HomeMan.main(args);
					break;
				case 2:
					MenuMan.main(args);
					break;
				case 3:
					ProfileMan.main(args);
					break;
				case 4:
					StaffMan.main(args);
					break;
				case 5:
					EditStaffMan.main(args);
					break;
				case 6:
					SettingsMan.main(args);
					break;
				case 7:
					LogInMan.main(args);
					break;
				}
			default:
				System.out.println("Wrong input! Try again 1 for automation, 2 for manual or 0 for exit!");
				break;
			case 0:
				System.out.println("You are exiting the test. I hope you enjoyed it!");
				break;
			}
		
	while (n != 0);
		sc.close();
	}
}
