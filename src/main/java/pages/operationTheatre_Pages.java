package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class operationTheatre_Pages extends StartupPage {

	//	By usernameTextfield=By.id("username_id");
	By usernameTextfield=By.id("username_id");
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");	
	By operationTheatreTab = By.xpath("//span[.='OperationTheatre']");

	By newOTButtonElement = By.xpath("//button[contains(text(), 'New OT Booking')]");
	By newOTButtonLink = By.xpath("//button[@class='btn btn-link']");
	By searchTextBoxElement = By.xpath("//input[@id='quickFilterInput']");
	By bookingOTSchedulePageElement = By.xpath("//span[contains(text(), 'Booking OT Schedule  | New Patient')]");
	
	By selectpatientTextboxElement = By.xpath("//input[@id='srch_PatientList']");
	By diagnosisTextboxElement = By.xpath("//input[@id='Diagnosis']");
	By surgeryTypeTextboxElement = By.xpath("//textarea[@id='surgeryType']");
	By remarkTextboxElement = By.xpath("//textarea[@placeholder='Remarks']");
	
	
	By surgenNameTextFieldElement = By.xpath("//input[@id='id_input_currentRequestedByDoctor_selectReferral']");
	By anesthetistDoctorTextboxElement = By.xpath("//input[@id='AnesthetistDoctor']");
	By surgenNameFirstButtonElement = By.xpath("//ul[@class='select-list']//li[1]");
	
	By externalCheckBoxElement = By.xpath("//label[@class='is-ref mt-checkbox mt-checkbox-outline']//span");
	By plusIconButtonElement = By.xpath("//a[@class='btn blue btn-xs btn-ext']");
	
	By referrerNameTextFieldElement = By.xpath("//input[@id='referrerName']");
	By extRefferAddressTextFieldElement = By.xpath("//input[@id='ExtRefferaddress']");
	By contactNumberTextFieldElement = By.xpath("//input[@id='contactNum']");
	By emailTextFieldElement = By.xpath("//input[@id='email']");
	By isIncentiveApplicableCheckboxElement = By.xpath("(//div[@class='icheck-inline']//span)[2]");
	By addButtonElement = By.xpath("//button[@id='add']");
	By successNotificationPopupMessageElement = By.xpath("//div[@class='msg-text padding-8-all']");
	
	By successNotificationPopupMessageOneElement = By.xpath("//p[@class='msg-status']");
	By successNotificationPopupMessageTwoElement = By.xpath("//p[@class='main-message']");

	String pageName = this.getClass().getSimpleName();
	public operationTheatre_Pages(WebDriver driver) {
		super(driver);
	}
	
	/**@Test1
	 * about this method loginTohealthAppByGivenValidCredetial() 
	 * @param : Map<String, String>
	 * @description : fill usernameTextbox & passwordTextbox and click on sign in button
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			WebElement usernametextFieldWebElement = commonEvents.findElement(usernameTextbox);
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(usernameTextbox,expectedData.get("username"));

			WebElement passwordtextFieldWebElement = commonEvents.findElement(passwordTextbox);
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));

			WebElement signinButtonWebElement = commonEvents.findElement(signInButton);
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.click(signInButton);

			if(commonEvents.isDisplayed(registeredPatientTextElement))
			{   
				WebElement registeredPatientTextWebElement = commonEvents.findElement(registeredPatientTextElement);
				commonEvents.highlightElement(registeredPatientTextWebElement);
				textIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return textIsDisplayed;
	}

	/**@Test1.2
	 * about this method verifyTitleOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the title of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyTitleOfThePage() throws Exception {
		String pageTitle = "";
		try {
			pageTitle = commonEvents.getTitle();
			System.out.println("title of the page is  :" + pageTitle );
		}catch(Exception e) {
			throw e;
		}	
		return pageTitle;
	}

	/**@Test1.3
	 * about this method verifyURLOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyURLOfThePage() throws Exception {
		String urlofThepage = "";
		try {
			urlofThepage = commonEvents.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage );
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}
	

}
