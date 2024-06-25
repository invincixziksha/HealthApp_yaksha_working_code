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
	 * about this method verifySocialServiceModuleisPresentAndGoToSocialServiceTab() 
	 * @param : null
	 * @description : Verify that SocialService module is present and Go to SocialService Tab.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifySocialServiceModuleisPresentAndGoToSocialServiceTab() throws Exception {
		boolean isDisplayed = false;
		try {
			if(userActions.isDisplayed(socialServiceModule)){
				userActions.click(socialServiceModule);
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
			if(userActions.isDisplayed(registerNewSSUPatientButton)) {
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
			if(userActions.isDisplayed(searchBar)){
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
			userActions.click(registerNewSSUPatientButton);
			if(userActions.isDisplayed(NewSSUpatientRegistrationPopup))
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
			if(userActions.isDisplayed(firstNameTextField) && 
					userActions.isDisplayed(middelNameTextField) &&
					userActions.isDisplayed(lastNameTextField) &&
					userActions.isDisplayed(ageTextField) &&
					userActions.isDisplayed(phoneNumberTextField))
			{
				userActions.sendKeys(firstNameTextField,expectedData.get("firstName"));	
				userActions.sendKeys(middelNameTextField,expectedData.get("middleName"));
				userActions.sendKeys(lastNameTextField,expectedData.get("lastName"));
				userActions.sendKeys(ageTextField,expectedData.get("age"));
				userActions.sendKeys(phoneNumberTextField,expectedData.get("phoneNo."));
				firstNameTextfieldValue = userActions.getAttribute(firstNameTextField, "value");
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
			if(userActions.isDisplayed(phoneNumberTextField))
			{
				userActions.clear(phoneNumberTextField);
				userActions.sendKeys(phoneNumberTextField,expectedData.get("invalidPhoneNo."));
				Thread.sleep(3000);
				phoneNumberTextFieldErrorMessageValue = userActions.getText(phoneNumberTextFieldErrorMessage);
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
	 * @description : Simply select India from the Country DROPDOWN menu and validate India is selected or not.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean selectIndiaFromCountryDropdownMenuAndValidate() throws Exception {
		boolean isSelected = false;
		try {
			if(userActions.isDisplayed(countryDropdown))
			{
				userActions.click(selectIndiaIncountryDropdown);
				userActions.isSelected(selectIndiaIncountryDropdown);
				isSelected=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return isSelected;
	}
	
	/**@Test9
	 * about this method validateWarnningMessageForMembershipDropDown() 
	 * @param : Map<String, String>
	 * @description : Validate the warnning message for the membership dropdown.
	 * @return : String
	 * @author : Yaksha
	 */
	public String validateWarnningMessageForMembershipDropDown(Map<String, String> expectedData) throws Exception {
		String warningMessageValue = "";
		try {
			if(userActions.isDisplayed(phoneNumberTextField))
			{
				if(userActions.isDisplayed(warningMessage)) {
				warningMessageValue = userActions.getText(warningMessage);
				System.out.println("Warnning Message is : " + warningMessageValue);
				}
			}
		}catch(Exception e) {
			throw e;
		}
		return warningMessageValue;
	}
	
	
	/**@Test10
	 * about this method selectYesFromHasTargetGroupCertificateandValidate() 
	 * @param : null
	 * @description : select "Yes" from the "Has target group certificate?" dropdown and validate Yes is selected or not.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean selectYesFromHasTargetGroupCertificateandValidate() throws Exception {
		boolean isSelected = false;
		try {
			 if(userActions.isDisplayed(hasTG_certificateDropdown))
			 {
				 userActions.click(selectYesFromhasTG_certificateDropdown);
				 userActions.isSelected(selectYesFromhasTG_certificateDropdown);
				 isSelected=true;
			 }
		}catch(Exception e) {
			throw e;
		}	
		return isSelected;
	}
	
	
	/**@Test11
	 * about this method getPlaceHolderNameVerifyPlaceHolderNameOfAddress() 
	 * @param : Map<String, String>
	 * @description : get the place holder name of address textfiled and verify  the place holder name.
	 * @return : String
	 * @author : Yaksha
	 */
	public String getPlaceHolderNameVerifyPlaceHolderNameOfAddress(Map<String, String> expectedData) throws Exception {
		String placeHolderValue = "";
		try {
				if(userActions.isDisplayed(addressTextField)) {
				Thread.sleep(3000);
				placeHolderValue = userActions.getAttribute(addressTextField,"placeholder");
				System.out.println("Place holder value of Address field : " + placeHolderValue);
				}
		}catch(Exception e) {
			throw e;
		}
		return placeHolderValue;
	}
	
	
	/**@Test12
	 * about this method verifypresencefieldInNewSSUPatientRegistrationPage() 
	 * @param : null
	 * @description : verify the presence of field in "New SSU Patient Registration" page and verify "Patient Information" text is present
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifypresencefieldInNewSSUPatientRegistrationPage() throws Exception {
		boolean patientInformationTextIsDisplayed = false;
		try {
				 userActions.click(patientInformationBar);
				 Thread.sleep(3000);
				 userActions.click(patientInformationBar);
				  if(userActions.isDisplayed(patientInformationText)) {
					  patientInformationTextIsDisplayed=true;
			  }
		}catch(Exception e) {
			throw e;
		}	
		return patientInformationTextIsDisplayed;
	}
	
	
	/**@Test13
	 * about this method closeNewSSUPatientRegistrationPopupByUsingJsExecutor() 
	 * @param : null
	 * @description : Close this "New SSU Patient Registration" popup by using javaScript.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean closeNewSSUPatientRegistrationPopupByUsingJsExecutor() throws Exception {
		boolean IsDisplayed = false;
		try {
			if(userActions.isDisplayed(closeButton)) {
			  userActions.jsClick(closeButton);
			  Thread.sleep(3000);
			  IsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return IsDisplayed;
	}
	
	/**@Test14
	 * about this method scrollToButtomAndVerifytheFields() 
	 * @param : null
	 * @description : scroll to the bottom of the "Sale" page and verify that "Print Invoice" button  , "Discard" button  ,"Invoice History" and  "Credit Limitis and Balance" text are peresent or not.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean scrollToButtomAndVerifytheFields() throws Exception {
		boolean creditLimitsAndBalancesTextElementIsDisplayed = false;
		try {
			userActions.click(dispensaryModule);
			userActions.click(morningCounter);
			if(userActions.isDisplayed(printInvoiceButtonElement) &&
					userActions.isDisplayed(discardButtonElement) &&
					userActions.isDisplayed(invoiceHistoryTextElement) &&
					userActions.isDisplayed(creditLimitsAndBalancesTextElement) ) {
				    creditLimitsAndBalancesTextElementIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return creditLimitsAndBalancesTextElementIsDisplayed;
	}
	
	
	/**@Test15
	 * about this method performTheKeyboardOperationToOpenthePopup() 
	 * @param : null
	 * @description : Perform the keyboard operation to open the  popup and verify that the popup is displayed or not.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean performTheKeyboardOperationToOpenthePopup() throws Exception {
		boolean createRequisitionButtonIsDisplayedIsDisplayed = false;
		try {
			userActions.performAltN();
			if(userActions.isDisplayed(addNewPatientPopup)){
				createRequisitionButtonIsDisplayedIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return createRequisitionButtonIsDisplayedIsDisplayed;
	}
}
