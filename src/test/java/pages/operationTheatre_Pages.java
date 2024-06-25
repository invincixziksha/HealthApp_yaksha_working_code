package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
			WebElement usernametextFieldWebElement = userActions.findElement(usernameTextbox);
			userActions.highlightElement(usernametextFieldWebElement);
			userActions.sendKeys(usernameTextbox,expectedData.get("username"));

			WebElement passwordtextFieldWebElement = userActions.findElement(passwordTextbox);
			userActions.highlightElement(passwordtextFieldWebElement);
			userActions.sendKeys(passwordTextbox,expectedData.get("password"));

			WebElement signinButtonWebElement = userActions.findElement(signInButton);
			userActions.highlightElement(signinButtonWebElement);
			userActions.click(signInButton);

			if(userActions.isDisplayed(registeredPatientTextElement))
			{   
				WebElement registeredPatientTextWebElement = userActions.findElement(registeredPatientTextElement);
				userActions.highlightElement(registeredPatientTextWebElement);
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
			pageTitle = userActions.getTitle();
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
			urlofThepage = userActions.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage );
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}


	/**@Test2
	 * about this method verifyOperationTheatreModuleIsPresentAndGoToOperationTheatreTab() 
	 * @param : null
	 * @description : Verify that OperationTheatre module is present and Go to OperationTheatre Tab.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyOperationTheatreModuleIsPresentAndGoToOperationTheatreTab() throws Exception {
		boolean isDisplayed = false;
		try {
			if(userActions.isDisplayed(operationTheatreTab)){
				userActions.click(operationTheatreTab);
				Thread.sleep(3000);
				isDisplayed=true;
			}

		}catch(Exception e) {
			throw e;
		}	
		return isDisplayed;
	}

	/**@Test3
	 * about this method verifyURLOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyNewOTButtonIsPresent() throws Exception {
		String newOtButtonTextValue = "";
		try {
			newOtButtonTextValue = userActions.getText(newOTButtonElement);
			System.out.println("text value of :" + "New OT Button" + newOtButtonTextValue );
		}catch(Exception e) {
			throw e;
		}	
		return newOtButtonTextValue;
	}

	/**@Test4
	 * about this method verifySearchTextboxIsPresent() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifySearchTextboxIsPresent(Map<String, String> expectedData) throws Exception {
		String searchTextboxAttributeValue = "";
		try {
			if(userActions.isDisplayed(searchTextBoxElement)) {
				userActions.sendKeys(searchTextBoxElement, expectedData.get("searchBarData"));
				searchTextboxAttributeValue = userActions.getAttribute(searchTextBoxElement, "value");
				System.out.println("attribute value of search textbox : " + searchTextboxAttributeValue );
			}
		}catch(Exception e) {
			throw e;
		}	
		return searchTextboxAttributeValue;
	}
	
	/**@Test5
	 * about this method verifyBookingOTSchedulePopupPageIsPresent() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyBookingOTSchedulePopupPageIsPresent() throws Exception {
		String bookingOTSchedulePopupPageValue = "";
		try {
			userActions.click(newOTButtonLink);
			Thread.sleep(2000);
			bookingOTSchedulePopupPageValue = userActions.getText(bookingOTSchedulePageElement);
			System.out.println("booking OT Schedule Popup Page Value" + bookingOTSchedulePopupPageValue );
		}catch(Exception e) {
			throw e;
		}	
		return bookingOTSchedulePopupPageValue;
	}
	
	/**@Test6
	 * about this method verifyEnteredDataIsPresentInTextbox() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyEnteredDataIsPresentInTextbox(Map<String, String> expectedData) throws Exception {
		String surgeryTypeTextboxAttributeValue = "";
		try {
			if(userActions.isDisplayed(bookingOTSchedulePageElement)) {
				userActions.sendKeys(selectpatientTextboxElement, expectedData.get("patientName"));
				userActions.sendKeys(diagnosisTextboxElement, expectedData.get("diagnosisValue"));
				userActions.sendKeys(surgeryTypeTextboxElement, expectedData.get("surgeryTypeValue"));
				surgeryTypeTextboxAttributeValue = userActions.getAttribute(surgeryTypeTextboxElement, "value");
				System.out.println("attribute value of surgery Type Textbox : " + surgeryTypeTextboxAttributeValue );
			}
		}catch(Exception e) {
			throw e;
		}	
		return surgeryTypeTextboxAttributeValue;
	}
	
	/**@Test7
	 * about this method verifyEnteredDataIsPresentInTextbox() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyTextboxIsEnableAndValidatePlaceholderName() throws Exception {
		String placeHolderValue = "";
		try {
			if(userActions.isDisplayed(remarkTextboxElement)) {
				userActions.isEnabled(remarkTextboxElement);
				placeHolderValue = userActions.getAttribute(remarkTextboxElement, "placeholder");
				System.out.println("attribute value of surgery Type Textbox : " + placeHolderValue );
			}
		}catch(Exception e) {
			throw e;
		}	
		return placeHolderValue;
	}
	
	/**@Test8
	 * about this method verifyEnteredDataIsPresentInTextbox() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyButtonIsPresentAfterSendValueToSurgenNameTextfield(Map<String, String> expectedData) throws Exception {
		String surgenNameButtonAttributeValue = "";
		try {
			if(userActions.isDisplayed(surgenNameTextFieldElement)) {
				userActions.sendKeys(surgenNameTextFieldElement, expectedData.get("surgenNameValue1"));
				userActions.sendKeys(surgenNameTextFieldElement, Keys.ENTER);
				Thread.sleep(2000);
//				userActions.click(anesthetistDoctorTextboxElement);
				userActions.click(remarkTextboxElement);
				Thread.sleep(2000);
				userActions.isDisplayed(surgenNameFirstButtonElement);
				surgenNameButtonAttributeValue = userActions.getText(surgenNameFirstButtonElement);
				System.out.println("attribute value of surgen Name Value : " + surgenNameButtonAttributeValue );
			}
		}catch(Exception e) {
			throw e;
		}	
		return surgenNameButtonAttributeValue;
	}
	
	/**@Test9
	 * about this method verifyPlusButtonIsPresentAfterClickOnExternalCheckbox() 
	 * @param : null
	 * @description : Verify that OperationTheatre module is present and Go to OperationTheatre Tab.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyPlusButtonIsPresentAfterClickOnExternalCheckbox() throws Exception {
		boolean plusIconIsDisplayed = false;
		try {
			if(userActions.isDisplayed(externalCheckBoxElement)){
				userActions.click(externalCheckBoxElement);
				Thread.sleep(3000);
				userActions.isDisplayed(plusIconButtonElement);
				
				plusIconIsDisplayed = true;
			}

		}catch(Exception e) {
			throw e;
		}	
		return plusIconIsDisplayed;
	}
}
