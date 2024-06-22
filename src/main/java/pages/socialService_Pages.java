package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class socialService_Pages extends StartupPage {

	By usernameTextfield=By.id("username_id");
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");	
	By socialServiceModule = By.xpath("//span[.='SocialService']");	
	By registerNewSSUPatientButton = By.xpath("//a[.=' Register New SSU Patient']");	
	By searchBar = By.id("quickFilterInput");
	By NewSSUpatientRegistrationPopup= By.xpath("//div[@class='modelbox-div']");
	By firstNameTextField = By.id("regPatFirstName");
	By middelNameTextField = By.id("MiddleName");
	By lastNameTextField = By.id("LastName");
	By ageTextField = By.id("Age");
	By phoneNumberTextField = By.id("PhoneNo");
	By phoneNumberTextFieldErrorMessage = By.xpath("//span[.='Primary Phone is not proper']");
	By countryDropdown = By.id("ddlCountry");
	By selectIndiaIncountryDropdown = By.xpath("//option[.=' India ']");
	By warningMessage = By.xpath("(//span[.='Membership Scheme(s) is Mandatory. '])[2]");
	By hasTG_certificateDropdown = By.id("hasTG_certificate");
	By selectYesFromhasTG_certificateDropdown = By.xpath("(//option[.='Yes'])[2]");
	By addressTextField = By.id("address");
	By patientInformationBar = By.xpath("//h4[@data-target='#patInfoSection']");
	By patientInformationText = By.xpath("//h4[.=' Patient Information ']");	
	By ssuInformationBar = By.xpath("//h4[@data-target='#insuranceInfoSection']");
	By targetGroupDropdown = By.id("TargetGroupId");
	By registerButton = By.id("SaveButton0");

	//L2 locators

	By procurementModule = By.xpath("//span[.='Procurement']");
	By settingsTab = By.xpath("//a[.=' Settings ']");
	By TermsSubTab = By.xpath("//a[.='Terms']");
	By addTermsAnsConditionButton = By.xpath("//input[@value='Add Terms & Conditions']");
	By shortNameTextField = By.id("shortname");
	By iframe = By.xpath("//iframe[@title=\"Rich Text Editor, editor3\"]");
	By invoiceHeadersSubTab = By.xpath("//a[.='Invoice Headers']");
	By addNewInvoiceHeaderButton = By.xpath("//input[@value='Add New Invoice Header']");
	By chooseFileButton = By.id("img");
	By xButton = By.xpath("//a[.='X']");
	By othersChargesTab = By.xpath("//a[.='Other Charges']");
	By addOtherChargesButton = By.xpath("//input[@value='Add Other Charges']");
	By isVATApplicableCheckBox = By.xpath("(//label[@class='mt-checkbox mt-checkbox-outline'])[1]//span");
	By isActiveCheckBox = By.xpath("(//label[@class='mt-checkbox mt-checkbox-outline'])[2]//span");
	By isDefaultCheckBox = By.xpath("(//label[@class='mt-checkbox mt-checkbox-outline'])[3]//span");
	By submitButton = By.id("btn-add");
	By cancelButton = By.xpath("//a[@title='Cancel']");
	By reportsSubButton = By.xpath("//a[.=' Reports ']");
	By currentStockLevelButton = By.xpath("//i[.='Current Stock Level']");
	By selectedItemDropdown = By.xpath("//div[@class='selected-list']");
	By selectItemSearchBar = By.xpath("//input[@placeholder='Search']");
	By accountsItemCheckBox = By.xpath("//label[.='Accounts']");
	By generalInventoryOption = By.xpath("//span[@class='fa fa-remove']");
	By accountOption = By.xpath("//span[.='Accounts']");
	By morningCounter = By.xpath("(//div[@class='counter-item'])[1]");
	By printInvoiceButtonElement = By.xpath("//input[@value='Print Invoice']");
	By discardButtonElement = By.xpath("//button[contains(text() , 'Discard')]");
	By invoiceHistoryTextElement = By.xpath("//b[contains(text() , 'Invoice History')]");
	By creditLimitsAndBalancesTextElement = By.xpath("//b[contains(text() , 'Credit Limits and Balances')]");
	By addNewPatientPopup = By.xpath("//div[@class='modelbox-body p2']");
	By closeButton = By.xpath("//button[.=' Close ']");
	By dispensaryModule = By.xpath("//span[.='Dispensary']");
	By closeButtonPresentInsideTheAddNewPatient = By.xpath("//button[.=' Close ']");


	String pageName = this.getClass().getSimpleName();
	public socialService_Pages(WebDriver driver) {
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

	/**@Test2
	 * about this method verifySocialServiceModuleisPresentAndGoToSocialServiceTab() 
	 * @param : null
	 * @description : Verify that SocialService module is present and Go to SocialService Tab.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifySocialServiceModuleisPresentAndGoToSocialServiceTab() throws Exception {
		boolean isDisplayed = false;
		try {
			if(commonEvents.isDisplayed(socialServiceModule)){
				commonEvents.click(socialServiceModule);
				Thread.sleep(3000);
				isDisplayed=true;
			}

		}catch(Exception e) {
			throw e;
		}	
		return isDisplayed;
	}


	/**@Test3
	 * about this method registerNewSSUPatientButtonisPresent() 
	 * @param : null
	 * @description : Verify that Register New SSU Patient button is present inside the SocialService Tab.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean registerNewSSUPatientButtonisPresent() throws Exception {
		boolean registerNewSSUPatientButtonisDisplayed = false;
		try {
			if(commonEvents.isDisplayed(registerNewSSUPatientButton)) {
				registerNewSSUPatientButtonisDisplayed=true;	
			}
		}catch(Exception e) {
			throw e;
		}	
		return registerNewSSUPatientButtonisDisplayed;
	}

	/**@Test4
	 * about this method searchbarIsPresentInsideTheSocialServiceTab() 
	 * @param : null
	 * @description : Verify that Search Bar is present inside the SocialService Tab.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean searchbarIsPresentInsideTheSocialServiceTab() throws Exception {
		boolean searchBarIsDisplayed = false;
		try {
			if(commonEvents.isDisplayed(searchBar)){
				searchBarIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return searchBarIsDisplayed;
	}


	/**@Test5
	 * about this method verifyNewSSUpatientRegistrationPopupIsDisplayed() 
	 * @param : null
	 * @description : Verify New SSU Patient Registration popup is displayed after clicking on the Register New SSU Patient button.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyNewSSUpatientRegistrationPopupIsDisplayed() throws Exception {
		boolean NewSSUpatientRegistrationPopupisDisplayed = false;
		try {
			commonEvents.click(registerNewSSUPatientButton);
			if(commonEvents.isDisplayed(NewSSUpatientRegistrationPopup))
			{
				NewSSUpatientRegistrationPopupisDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return NewSSUpatientRegistrationPopupisDisplayed;
	}

	/**@Test6
	 * about this method fillAllTheTextfieldsinsideTheNewSSUPatientRegistration() 
	 * @param : Map<String, String>
	 * @description : Fill all the textfields which are present inside the New SSU Patient Registration popup  and Check the data which we are entered are present in First Name Field. 
	 * @return : String
	 * @author : Yaksha
	 */
	public String fillAllTheTextfieldsinsideTheNewSSUPatientRegistration(Map<String, String> expectedData) throws Exception {
		String firstNameTextfieldValue = "";
		try {
			if(commonEvents.isDisplayed(firstNameTextField) && 
					commonEvents.isDisplayed(middelNameTextField) &&
					commonEvents.isDisplayed(lastNameTextField) &&
					commonEvents.isDisplayed(ageTextField) &&
					commonEvents.isDisplayed(phoneNumberTextField))
			{
				commonEvents.sendKeys(firstNameTextField,expectedData.get("firstName"));	
				commonEvents.sendKeys(middelNameTextField,expectedData.get("middleName"));
				commonEvents.sendKeys(lastNameTextField,expectedData.get("lastName"));
				commonEvents.sendKeys(ageTextField,expectedData.get("age"));
				commonEvents.sendKeys(phoneNumberTextField,expectedData.get("phoneNo."));
				firstNameTextfieldValue = commonEvents.getAttribute(firstNameTextField, "value");
				System.out.println("FirstName : " + firstNameTextfieldValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return firstNameTextfieldValue;
	}

	/**@Test7
	 * about this method enterInvalidDataValidateTheErrorMessage() 
	 * @param : Map<String, String>
	 * @description : Enter invalid data in phone number field and validate the error message.
	 * @return : String
	 * @author : Yaksha
	 */
	public String enterInvalidDataValidateTheErrorMessage(Map<String, String> expectedData) throws Exception {
		String phoneNumberTextFieldErrorMessageValue = "";
		try {
			if(commonEvents.isDisplayed(phoneNumberTextField))
			{
				commonEvents.clear(phoneNumberTextField);
				commonEvents.sendKeys(phoneNumberTextField,expectedData.get("invalidPhoneNo."));
				Thread.sleep(3000);
				phoneNumberTextFieldErrorMessageValue = commonEvents.getText(phoneNumberTextFieldErrorMessage);
				System.out.println("Error Message is : " + phoneNumberTextFieldErrorMessageValue);

			}
		}catch(Exception e) {
			throw e;
		}
		return phoneNumberTextFieldErrorMessageValue;
	}


	/**@Test8
	 * about this method selectIndiaFromCountryDropdownMenuAndValidate() 
	 * @param : null
	 * @description : Simply select India  from the Country dropdown menu and validate India is selected or not.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean selectIndiaFromCountryDropdownMenuAndValidate() throws Exception {
		boolean isSelected = false;
		try {
			if(commonEvents.isDisplayed(countryDropdown))
			{
				commonEvents.click(selectIndiaIncountryDropdown);
				commonEvents.isSelected(selectIndiaIncountryDropdown);
				isSelected=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return isSelected;
	}
}
