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
	By calendarField=By.xpath("//danphe-date-picker[@class='ng-untouched ng-pristine ng-valid']");
	By editItemsButton=By.xpath("//button[contains(text(),' Edit Items ')]");
	By checkBox=By.xpath("(//label[@class='mt-checkbox mt-checkbox-outline'])[1]//span");
	By doctorTab=By.xpath("//span[.='Doctor']");
	By cancelButton=By.xpath("//a[.='X']");
	By settingsButton=By.xpath("(//span[.='Settings'])[5]");
	By securityButton=By.xpath("//a[.=' Security ']");
	By deactivateButton=By.xpath("(//a[contains(text(),'Deactivate')])[1]");
	By appointmentTab=By.xpath("(//span[.='Appointment'])[1]");
	By keyboardButton=By.xpath("//div[@title='Shortcut Keys']");
	By tooltip=By.xpath("//li[contains(text(),'+')]");

	String pageName = this.getClass().getSimpleName();
	public yakshaHealthApp_L2_Pages(WebDriver driver) {
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
			commonEvents.sendKeys(usernameTextfield,loginData.get("username"));	
			commonEvents.sendKeys(passwordTextfield,loginData.get("password"));	
			commonEvents.click(signInButton);
			if(commonEvents.isDisplayed(doctorTab)){
				isDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return isDisplayed;
	}

	/**@Test2
	 * about this method searchForPatientAndViewDetailsOfSelectedPatient() 
	 * @param : Map<String, String>
	 * @description : Search for a patient name and view the details of the selected patient
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean searchForPatientAndViewDetailsOfSelectedPatient(Map<String, String> expectedData) throws Exception {
		boolean isClickable=false;
		try {
			commonEvents.click(billingTab);
			commonEvents.waitTillElementVisible(new1Counter, 10);
			commonEvents.jsClick(new1Counter);
			commonEvents.click(ipBillingTab);
			commonEvents.sendKeys(searchBar,expectedData.get("SearchBarName"));	
			if(commonEvents.isDisplayed(viewDetailsButton)){
				commonEvents.click(viewDetailsButton);
				isClickable = true;		
			}
		}catch(Exception e) {
			throw e;
		}
		return isClickable;
	}
	/**@Test3
	 * about this method tickallCheckBoxesThenUntickthemThenCloseThatPopup() 
	 * @param : null
	 * @description : tick all CheckBoxes Then Untick them Then Close That Popup
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean tickallCheckBoxesThenUntickthemThenCloseThatPopup() throws Exception {
		boolean isClickable=false;
		try {
			commonEvents.click(editItemsButton);
			commonEvents.waitTillElementVisible(checkBox,50);
			commonEvents.jsClick(checkBox);
			commonEvents.waitTillElementVisible(checkBox,50);
			commonEvents.jsClick(checkBox);
			if(commonEvents.isDisplayed(cancelButton)){
				commonEvents.click(cancelButton);
				isClickable=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return isClickable;
	}
	

	/**@Test4
	 * about this method takeScreenshotOfTheDoctorPage() 
	 * @param : null
	 * @description : go to the doctor tab and take a screenshot
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean takeScreenshotOfTheDoctorPage() throws Exception {
		boolean isDisplayed=false;
		try {
			if(commonEvents.isDisplayed(doctorTab)){
				commonEvents.click(doctorTab);
				Thread.sleep(5000);
				commonEvents.takeScreenshot("DoctorsPage");
				isDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return isDisplayed;
	}

}
