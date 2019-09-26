package rs.itbootcamp.humanity.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GlavniProgram {
	

	public static void main(String[] args) throws InterruptedException {
		MainEditStaff.main(args);	
		
		
		
		// testNG se pokrece iz svoje klase
			
			// regularni testovi
//			HumanityLoginTest.loggingSuccessful();
//			HumanityAddNewEmployeesTest.EmployingSuccessfulTest();
//			HumanityAddPhotoTest.AddingProfilePhotoTest();

			/*ExcelUtils.setExcel("Login.xls");
			ExcelUtils.setWorkSheet(0);	
			String loginEmail = ExcelUtils.getDataAt(0, 0);
			String password = ExcelUtils.getDataAt(0, 1);
			ExcelUtils.closeExcel();

			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			HumanityHome.login(driver, loginEmail, password);
			
			HumanityProfile.clickDropdownBtn(driver);
			
			System.out.println(HumanityProfile.getVersion(driver));
			
			driver.quit();*/
		}
}
