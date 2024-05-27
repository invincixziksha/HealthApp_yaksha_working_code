package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class yakshaHealthApp_L2_Pages extends StartupPage {

	By usernameTextfield=By.id("username_id");
	By passwordTextfield=By.id("password");
	By signInButton=By.id("login");
	By billingTab=By.xpath("(//span[.='Billing'])[1]");
	By new1Counter=By.xpath("(//span[contains(text(),'Click to Activate')])[1]");
	By ipBillingTab=By.xpath("//li[.='IPBilling ']");
	By searchBar=By.id("quickFilterInput");
	By viewDetailsButton=By.xpath("//a[@class='grid-action']");
	By calendarField=By.id("date");
	By editItemsButton=By.xpath("//button[contains(text(),' Edit Items ')]");
	By checkBox=By.xpath("(//label[@class='mt-checkbox mt-checkbox-outline'])[1]//span");
	By doctorTab=By.xpath("//span[.='Doctor']");
	
	
	String pageName = this.getClass().getSimpleName();
	public yakshaHealthApp_L2_Pages(WebDriver driver) 
	{
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
		boolean isFilled=false;
		try {
			commonEvents.sendKeys(usernameTextfield,loginData.get("username"));	
			commonEvents.sendKeys(passwordTextfield,loginData.get("password"));	
			commonEvents.click(signInButton);
			if(commonEvents.isDisplayed(doctorTab))
			{
				isFilled=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return isFilled;
	}

	/**@Test2
	 * about this method searchForPatientAndViewDetailsOfSelectedPatient() 
	 * @param : Map<String, String>
	 * @description : Search for a patient name and view the details of the selected patient
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean searchForPatientAndViewDetailsOfSelectedPatient(Map<String, String> expectedData) throws Exception {
		boolean isFilled=false;
		try {
			commonEvents.click(billingTab);
			commonEvents.waitTillElementVisible(new1Counter, 10);
			commonEvents.jsClick(new1Counter);
			commonEvents.click(ipBillingTab);
			commonEvents.sendKeys(searchBar,expectedData.get("SearchBarName"));	
			commonEvents.click(viewDetailsButton);
			isFilled = true;			
		}catch(Exception e) {
			throw e;
		}
		return isFilled;
	}
	/**@Test3
	 * about this method tickallCheckBoxesThenUntickthemThenCloseThatPopup() 
	 * @param : null
	 * @description : tick all CheckBoxes Then Untick them Then Close That Popup
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean tickallCheckBoxesThenUntickthemThenCloseThatPopup() throws Exception {
		boolean isFilled=false;
		try {
			commonEvents.click(editItemsButton);
			commonEvents.jsClick(checkBox);
			Thread.sleep(3000);
			commonEvents.jsClick(checkBox);
			if(commonEvents.isDisplayed(checkBox))
			{
				isFilled=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return isFilled;
	}
}
