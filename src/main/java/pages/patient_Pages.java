package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class patient_Pages extends StartupPage {

	By usernameTextfield=By.id("username_id");
	
	String pageName = this.getClass().getSimpleName();
	public patient_Pages(WebDriver driver) {
		super(driver);
	}
	
	/**@Test1
	 * about this method loginToTheYakshahealthApp()
	 * @param : Map<String, String>
	 * @description : login to the yakshaHealth app by providing valid user name and password
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean loginToTheYakshahealthApp(Map<String, String> loginData) throws Exception {
		boolean isDisplayed=false;
		try {
			
				isDisplayed=true;
			
		}catch(Exception e) {
			throw e;
		}
		return isDisplayed;
	}
}
