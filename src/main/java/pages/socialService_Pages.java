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
	By totalDoctorsTextElement = By.xpath("//p[contains(text(), 'Total Doctors')]");	
	By todaysAppointmentTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");	
	By socialServiceModule = By.xpath("//span[.='SocialService']");	
	By registerNewSSUPatientButton = By.xpath("//a[.=' Register New SSU Patient']");	
	By searchBar = By.id("quickFilterInput");
	By newSSUpatientRegistrationPopup= By.xpath("//div[@class='modelbox-div']");
	By firstNameTextField = By.id("regPatFirstName");
	By middelNameTextField = By.id("MiddleName");
	By lastNameTextField = By.id("LastName");
	By ageTextField = By.id("Age");
	By phoneNumberTextField = By.id("PhoneNo");
	By phoneNumberTextFieldErrorMessage = By.xpath("//span[.='Primary Phone is not proper']");
	By countryDropdown = By.id("ddlCountry");
	By countryDropdownMenuElement = By.xpath("//select[@id='ddlCountry']");
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
	By newSSUPatientRegistrationFormNameElement = By.xpath("//strong[contains(text(), 'New SSU Patient Registration')]");
	By registrationButtonOfNewSSUPatientRegistrationForms = By.xpath("//button[contains(text(), 'Register')]");
	By errorMeesageInLastNameTextFieldElement = By.xpath("//span[contains(text(), 'Last Name is required')]");
	By registerButtonOfNewSSUPatientRegistrationForms = By.xpath(" //button[contains(text(), 'Register')]");
	By targetGroupCertificateTypeTextbox = By.xpath("//input[@id='TG_CertificateType']");
	By certificateNoTextbox = By.xpath("//input[@id='TG_CertificateNo']");

	By ssuPatientListButtonByElement = By.xpath("//a[contains(text(), 'SSU Patient List')]");
	By subCategoryTabByElement = By.xpath("//a[contains(text(), 'Sub Category')]");
	By cuttonSubCategoryNameByElement = By.xpath("//div[contains(text(), 'cotton')]");
	By itemSubmenuByElement = By.xpath("//a[contains(text(), 'Items')]");
	By addItemButtonByElement = By.xpath("//input[@value='Add Item']");
	By generalInventoryRadioButtonByElement = By.xpath("(//input[@type='radio'])[2]");
	By commonRadioButtonByElement = By.xpath("//input[@id='Common']");

	By inactiveRadioButton = By.xpath("(//label//span)[3]");
	By activeRadioButton = By.xpath("(//label//span)[2]");

	By addItemPageNameByElement = By.xpath("//span[contains(text(), 'Add Item')]");

	By isCssdApplicableCheckBoxByElement = By.xpath("//input[@id='IsCssdApplicable']/..//span");
	By isColdStorageApplicableCheckBoxByElement = By.xpath("//input[@id='IsColdStorageApplicable']/..//span");
	By isPatConsumptionApplicableCheckBoxByElement = By.xpath("//input[@id='IsPatConsumptionApplicable']/..//span");


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
	By closeAddNewPatientForm = By.xpath("//button[.='X']");
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
	By closeButtonOfNewSsuPatientRegistrationByElement = By.xpath("//button[.=' Close ']");
	By dispensaryModule = By.xpath("//span[.='Dispensary']");
	By closeButtonPresentInsideTheAddNewPatient = By.xpath("//button[.=' Close ']");
	By appointmentTab=By.xpath("(//span[.='Appointment'])[1]");
	By keyboardButton=By.xpath("//div[@title='Shortcut Keys']");
	By tooltip=By.xpath("//li[contains(text(),'+')]");
	By crossButtonElement = By.xpath("//button[contains(text(), 'X')]");

	By appointmentModule = By.xpath("(//span[.='Appointment'])[1]");
	By newOneSelectCounterElement = By.xpath("//div[@class='counter-item']//h5[contains(text(), 'New-1 ')]");
	By keyboardButtonElement = By.xpath("//div[@title='Shortcut Keys']");
	By altPlusNtooltipMessageElement = By.xpath("//li[contains(text(),'+')]");
	By addNewPatientPageTitle = By.xpath("//span[.='Add New Patient']");

	By operationTheatreNavMenuElement = By.xpath("//a[@href='#/OperationTheatre']");
	By newOtBookingButtonElement = By.xpath("//button[contains(text(), 'New OT Booking')]");
	By addNewOtButtonElement = By.xpath("//input[@value='Add New OT']");

	By editInformationOfExistingPatientNameByElement = By.id("allPatWithOutIns");


	String pageName = this.getClass().getSimpleName();
	public socialService_Pages(WebDriver driver) {
		super(driver);
	}

	/**@Test1
	 * about this method loginTohealthAppByGivenValidCredetial() 
	 * @param : Map<String, String>
	 * @description : fill usernameTextbox & passwordTextbox and click on sign in button
	 * @return : Boolean
	 * @author : YAKSHA
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
	 * @author : YAKSHA
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
	 * @author : YAKSHA
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
	 * @author : YAKSHA
	 */
	public Boolean verifySocialServiceModuleisPresentAndGoToSocialServiceTab() throws Exception {
		boolean isDisplayed = false;
		try {
			if(commonEvents.isDisplayed(socialServiceModule)){
				commonEvents.click(socialServiceModule);
				Thread.sleep(2000);
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
	 * @author : YAKSHA
	 */
	public String verifyRegisterNewSSUPatientButtonisPresentAndValidateFormName() throws Exception {
		String newSSUPatientRegistrationFormName = "";
		try {
			commonEvents.isDisplayed(registerNewSSUPatientButton);
			commonEvents.click(registerNewSSUPatientButton);
			Thread.sleep(2000);
			newSSUPatientRegistrationFormName = commonEvents.getText(newSSUPatientRegistrationFormNameElement);
			System.out.println("form Name after click on " + " " + "registerNewSSUPatient" + " " +  "Button : " + newSSUPatientRegistrationFormName);
			//				return newSSUPatientRegistrationFormName;
		}catch(Exception e) {
			throw e;
		}
		return newSSUPatientRegistrationFormName;
	}

	/**@Test4
	 * about this method validateErrorMessageInLastNameTextfield() 
	 * @param : null
	 * @description : Validate the error message in Last Name text field without filling any data and clicking on "Register" Button
	 * @author : YAKSHA
	 */
	public String validateErrorMessageInLastNameTextfield() throws Exception {
		String errorMessageText = "";
		try {
			if(commonEvents.isDisplayed(registrationButtonOfNewSSUPatientRegistrationForms)) {
				commonEvents.click(registrationButtonOfNewSSUPatientRegistrationForms);
				Thread.sleep(3000);
				errorMessageText = commonEvents.getText(errorMeesageInLastNameTextFieldElement);
				System.out.println("Error Meesage of Last Name Text Field is : " + errorMessageText );
				return errorMessageText;	
			}
		}catch(Exception e) {
			throw e;
		}	
		return errorMessageText;
	}

	/**@Test5
	 * about this method fillAllTheTextfieldsinsideTheNewSSUPatientRegistrationForm() 
	 * @param : Map<String, String>
	 * @description : Fill all the text fields which are present inside the New SSU Patient Registration popup  and Check the data which we are entered are present in First Name Field. 
	 * @return : String
	 * @author : YAKSHA
	 */
	public String fillDataInTextfieldsAndVerifyEnteredData(Map<String, String> expectedData) throws Exception {
		String firstNameTextfieldValue = "";
		try {
			if(commonEvents.isDisplayed(firstNameTextField) && 
					commonEvents.isDisplayed(middelNameTextField) &&
					commonEvents.isDisplayed(lastNameTextField))
			{
				commonEvents.sendKeys(firstNameTextField,expectedData.get("firstName"));	
				commonEvents.sendKeys(middelNameTextField,expectedData.get("middleName"));
				commonEvents.sendKeys(lastNameTextField,expectedData.get("lastName"));

				firstNameTextfieldValue = commonEvents.getAttribute(firstNameTextField, "value");
				System.out.println("value inside the FirstName textbox is : " + firstNameTextfieldValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return firstNameTextfieldValue;
	}

	/**@Test6
	 * about this method selectIndiaFromCountryDropdownAndVerifySelection() 
	 * @param : get the data from JSON file as type Map<String, String> expectedData
	 * @description : it will select the country as per JSON expected data
	 * @return : String
	 * @author : YAKSHA
	 */
	public String selectIndiaFromCountryDropdownAndVerifySelection(Map<String, String> expectedData) throws Exception {

		String selectedCountryName = "" ;

		//		commonEvents.click(countryDropdownMenuElement);

		try {
			commonEvents.selectByVisibleText(countryDropdownMenuElement, expectedData.get("selectedCountryName"));
			selectedCountryName = commonEvents.getFirstSelectedOptionFromDropdown(countryDropdownMenuElement, "elementName", "pageName");
			System.out.println("first selected option from country dropdown : " + selectedCountryName );
			return selectedCountryName;
		}catch(Exception e) {
			throw e;
		}	
	}

	/**@Test7
	 * about this method scrollToButtomOfThePageAndVerifyCloseButtonIsPresent() 
	 * @param : null
	 * @description : scroll to the bottom of the page and verify that "Close" button is present or not.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean scrollToButtomOfThePageAndVerifyCloseButtonIsPresent() throws Exception {
		boolean closeButtoIsDisplayed = false;
		try {
			Thread.sleep(5000);
			//			commonEvents.jsScrollTillPageFooter();
			commonEvents.jsScrollPageTillElementVisible(registerButtonOfNewSSUPatientRegistrationForms, "pageName", "pageName");
			if(commonEvents.isDisplayed(closeButtonOfNewSsuPatientRegistrationByElement) && 
					commonEvents.isDisplayed(registerButtonOfNewSSUPatientRegistrationForms)) {

				WebElement closeButtonOfNewSsuPatientRegistrationWebElement = commonEvents.findElement(closeButtonOfNewSsuPatientRegistrationByElement);
				commonEvents.highlightElementAfterAction(closeButtonOfNewSsuPatientRegistrationWebElement);

				WebElement registerButtonOfNewSSUPatientRegistrationFormsWebElement = commonEvents.findElement(registerButtonOfNewSSUPatientRegistrationForms);
				commonEvents.highlightElementAfterAction(registerButtonOfNewSSUPatientRegistrationFormsWebElement);

				closeButtoIsDisplayed = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return closeButtoIsDisplayed;
	}

	/**@Test8
	 * about this method validateWarnningMessageOfNewSSUPatientRegistrationForms() 
	 * @param : Map<String, String>
	 * @description : Validate the warnning message for the membership dropdown.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String validateWarnningMessageOfNewSSUPatientRegistrationForms(Map<String, String> expectedData) throws Exception {
		String warningMessageValue = "";
		try {
			if(commonEvents.isDisplayed(warningMessage)) {
				warningMessageValue = commonEvents.getText(warningMessage);
				System.out.println("Warnning Message is : " + warningMessageValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return warningMessageValue;
	}

	/**@Test9
	 * about this method verifyTextboxIsPresentBySelectingYesFromHasTargetGroupCertificateDropdown() 
	 * @param : get the data from JSON file as type Map<String, String> expectedData
	 * @description : it will select the country as per JSON expected data
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTextboxIsPresentBySelectingYesFromHasTargetGroupCertificateDropdown(Map<String, String> expectedData) throws Exception {

		String HasTargetGroupCertificateDropdownValue = "" ;

		//		commonEvents.click(countryDropdownMenuElement);

		try {
			if(commonEvents.isDisplayed(hasTG_certificateDropdown)) {
				commonEvents.selectByVisibleText(hasTG_certificateDropdown, expectedData.get("HasTargetGroupCertificate?Yes"));

				HasTargetGroupCertificateDropdownValue = commonEvents.getFirstSelectedOptionFromDropdown(hasTG_certificateDropdown, "elementName", "pageName");
				System.out.println("first selected option from Has Target Group Certificate dropdown : " + HasTargetGroupCertificateDropdownValue );

				commonEvents.sendKeys(targetGroupCertificateTypeTextbox,expectedData.get("targetGroupCertificateType"));	
				commonEvents.sendKeys(certificateNoTextbox,expectedData.get("certificateNo"));
			}
		}catch(Exception e) {
			throw e;
		}
		return HasTargetGroupCertificateDropdownValue;
	}

	/**@Test10
	 * about this method getPlaceHolderNameVerifyPlaceHolderNameOfAddress() 
	 * @param : Map<String, String>
	 * @description : get the place holder name of address textfiled and verify  the place holder name.
	 * @return : String
	 * @author : Yaksha
	 */
	public String getPlaceHolderNameVerifyPlaceHolderNameOfAddress(Map<String, String> expectedData) throws Exception {
		String placeHolderValue = "";
		try {
			if(commonEvents.isDisplayed(addressTextField)) {
				Thread.sleep(3000);
				commonEvents.click(addressTextField);
				placeHolderValue = commonEvents.getAttribute(addressTextField,"placeholder");
				System.out.println("Place holder value of Address field : " + placeHolderValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return placeHolderValue;
	}

	/**@Test11
	 * about this method closeNewSSUPatientRegistrationPopupByUsingJsExecutor() 
	 * @param : null
	 * @description : Close this "New SSU Patient Registration" popup by using javaScript.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean closeNewSSUPatientRegistrationPopupByUsingJsExecutor() throws Exception {
		boolean IsDisplayed = false;
		try {
			if(commonEvents.isDisplayed(closeButton)) {
				commonEvents.jsClick(closeButton);
				Thread.sleep(3000);
				IsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return IsDisplayed;
	}

	/**@Test12
	 * about this method closeNewSSUPatientRegistrationPopupByUsingJsExecutor() 
	 * @param : null
	 * @description : Close this "New SSU Patient Registration" popup by using javaScript.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean performNavigateBackNavigateRefreshNavigateForwordAction() throws Exception {
		boolean successfullyNavigation = false;
		try {
			if(commonEvents.isDisplayed(ssuPatientListButtonByElement)) {
				commonEvents.navigateBack();
				System.out.println("successfully navigate back to the Home page");

				commonEvents.refreshPage();

				Thread.sleep(3000);

				if(commonEvents.isDisplayed(registeredPatientTextElement)&&
						commonEvents.isDisplayed(totalDoctorsTextElement)) {
					System.out.println("Register Patient & Total Doctors field are present inside the home page");
					commonEvents.navigateForward();
					System.out.println("successfully navigate to the social service module's SSU PatientList page");

					if(commonEvents.isDisplayed(ssuPatientListButtonByElement)&&
							commonEvents.isDisplayed(registerNewSSUPatientButton)) {
						System.out.println("ssu Patient List Button & register New SSU Patient Button are present inside the SSU PatientList page");
					}
				}
				successfullyNavigation = true;
			}

		}catch(Exception e) {
			throw e;
		}	
		return successfullyNavigation;
	}

	/**@Test13
	 * about this method verifyLocatorsName() 
	 * @param : Map<String, String>
	 * @description : get the place holder name of address text filed and verify  the place holder name.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyLocatorsName(Map<String, String> expectedData) throws Exception {
		String locatorsName = "";
		try {
			Thread.sleep(3000);
			if(commonEvents.isDisplayed(editInformationOfExistingPatientNameByElement)) {
				Thread.sleep(3000);
				commonEvents.click(editInformationOfExistingPatientNameByElement);
				commonEvents.sendKeys(editInformationOfExistingPatientNameByElement, expectedData.get("editInformationOfExistingPatientName"));
				locatorsName = commonEvents.getAttribute(editInformationOfExistingPatientNameByElement,"id");
				System.out.println("locators value of Edit Information of Texbox : " + locatorsName);
			}
		}catch(Exception e) {
			throw e;
		}
		return locatorsName;
	}

	/**@Test14
	 * about this method getDataFromTable() 
	 * @param : null
	 * @description : it will fetch the data from the table
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public String getDataFromTable() throws Exception {
		String cuttonSubCategoryName = "";
		try {
			if(commonEvents.isDisplayed(procurementModule)) {
				commonEvents.click(procurementModule);
				commonEvents.click(settingsTab);
				commonEvents.click(subCategoryTabByElement);
				Thread.sleep(3000);
				
				cuttonSubCategoryName = commonEvents.getText(cuttonSubCategoryNameByElement);
				System.out.println("sub category name of given code 003: " + cuttonSubCategoryName);
				return cuttonSubCategoryName;
			}
		}catch(Exception e) {
			throw e;
		}	
		return cuttonSubCategoryName;
	}

	/**@Test15
	 * about this method verifyRadioButton() 
	 * @param : null
	 * @description :
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyRadioButton() throws Exception {
		Boolean verifyRadioButton = false;
		try {
			Thread.sleep(3000);
			if(commonEvents.isDisplayed(itemSubmenuByElement)) {
				commonEvents.click(itemSubmenuByElement);
				Thread.sleep(5000);
				commonEvents.click(addItemButtonByElement);
				Thread.sleep(3000);

				commonEvents.jsClick(generalInventoryRadioButtonByElement);
				Thread.sleep(3000);

				if(commonEvents.isSelected(generalInventoryRadioButtonByElement)) {
					System.out.println("General Inventory Radio button is selected");
				}

				commonEvents.jsClick(commonRadioButtonByElement);

				if(!commonEvents.isSelected(generalInventoryRadioButtonByElement)) {
					System.out.println("General Inventory Radio button is De-Selected");
				}

				verifyRadioButton = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return verifyRadioButton;
	}

	/**@Test16
	 * about this method verifyCheckbox() 
	 * @param : null
	 * @description :
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyCheckbox() throws Exception {
		Boolean verifyCheckbox = false;
		try {
			if(commonEvents.isDisplayed(addItemPageNameByElement)) {

				commonEvents.click(isCssdApplicableCheckBoxByElement);
				commonEvents.click(isColdStorageApplicableCheckBoxByElement);
				commonEvents.click(isPatConsumptionApplicableCheckBoxByElement);

				Thread.sleep(2000);
				commonEvents.isSelected(isCssdApplicableCheckBoxByElement);
				Thread.sleep(2000);
				commonEvents.isSelected(isCssdApplicableCheckBoxByElement);
				Thread.sleep(2000);
				commonEvents.isSelected(isCssdApplicableCheckBoxByElement);

				Thread.sleep(2000);
				commonEvents.click(isCssdApplicableCheckBoxByElement);
				Thread.sleep(2000);
				commonEvents.click(isColdStorageApplicableCheckBoxByElement);
				Thread.sleep(2000);
				commonEvents.click(isPatConsumptionApplicableCheckBoxByElement);
			}
			verifyCheckbox = true;
		}catch(Exception e) {
			throw e;
		}	
		return verifyCheckbox;
	}

	//L2 Scenarios
	/**@Test17
	 * about this method verifyToolTipOfAnElement()
	 * @param : null
	 * @description :go to appointmentTab and verify the TOOLTIP value/text
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyToolTipOfAnElement() throws Exception {
		String tooltipText = "";
		try {
			commonEvents.click(xButton);
			commonEvents.click(appointmentModule);
			Thread.sleep(3000);
			commonEvents.click(newOneSelectCounterElement);
			Thread.sleep(3000);
			commonEvents.waitTillElementVisible(keyboardButtonElement,50);
			commonEvents.mouseHoverClick(keyboardButtonElement);
			commonEvents.waitTillElementVisible(altPlusNtooltipMessageElement,50);
			tooltipText = commonEvents.getText(altPlusNtooltipMessageElement);
			System.out.println("New Patient Tooltip text value is:" + tooltipText );
		}catch(Exception e) {
			throw e;
		}
		return tooltipText;
	}

	/**@Test18
	 * about this method uploadImageInScannedImagesSection() 
	 * @param : Map<String, String>
	 * @description : Upload a image in Scanned Images section.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean uploadImageInScannedImagesSection(String pathOfTheFile) throws Exception {
		boolean isUploaded = false;
		try {
			commonEvents.click(procurementModule);
			Thread.sleep(3000);
			commonEvents.click(settingsTab);
			Thread.sleep(3000);
			commonEvents.click(invoiceHeadersSubTab);
			Thread.sleep(3000);
			commonEvents.click(addNewInvoiceHeaderButton);
			Thread.sleep(3000);
			commonEvents.jsClick(chooseFileButton);
			Thread.sleep(3000);
			System.out.println("path of the file" + pathOfTheFile );
			Thread.sleep(5000);
			commonEvents.fileUpload(pathOfTheFile);
			Thread.sleep(3000);
			isUploaded = true;
		}catch(Exception e) {
			throw e;
		}
		return isUploaded;
	}

	/**@Test19
	 * about this method performTheKeyboardOperationToOpenthePopup() 
	 * @param : null
	 * @description :Perform the keyboard operation to open the "Add New Patient" popup Page  and verify that the popup is displayed or not.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public String performTheKeyboardOperationToOpenthePopup() throws Exception {
		String pageName = "";
		try {
			commonEvents.click(xButton);
			commonEvents.click(dispensaryModule);
			commonEvents.click(morningCounter);
			Thread.sleep(5000);
			commonEvents.performAltN();
			Thread.sleep(5000);
			commonEvents.isDisplayed(addNewPatientPopup);
			pageName=commonEvents.getText(addNewPatientPageTitle);
			System.out.println("Add New Patient page title is :" + pageName);
		}catch(Exception e) {
			throw e;
		}	
		return pageName;
	}

	/**@Test20
	 * about this method takingScreenshotOfTheCurrentPage() 
	 * @param : null
	 * @description : Taking screenshot of the current page.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean takingScreenshotOfTheCurrentPage() throws Exception {
		boolean isDisplayed = false;
		commonEvents.click(closeAddNewPatientForm);
		try {
			commonEvents.takeScreenshot("Sale page of DIspensary Module");
			isDisplayed = true;

		}catch(Exception e) {
			throw e;
		}
		return isDisplayed;
	}

	/**@Test21
	 * about this method handleAutoSuggesstion() 
	 * @param : Map<String, String>
	 * @description : Search for a Select Item as Accounts and select Accounts  and validate Accounts is selected.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean handleAutoSuggesstion(Map<String, String> expectedData) throws Exception {
		boolean accountOptionisDisplayed = false;
		try {
			commonEvents.click(procurementModule);
			Thread.sleep(3000);
			commonEvents.click(reportsSubButton);
			Thread.sleep(3000);
			commonEvents.click(currentStockLevelButton);
			Thread.sleep(3000);
			commonEvents.click(selectedItemDropdown);
			Thread.sleep(3000);
			commonEvents.click(generalInventoryOption);
			Thread.sleep(3000);
			commonEvents.click(selectedItemDropdown);
			Thread.sleep(3000);
			commonEvents.sendKeys(selectItemSearchBar,expectedData.get("searchBarData"));
			Thread.sleep(3000);
			commonEvents.click(accountsItemCheckBox);
			Thread.sleep(3000);

			if(commonEvents.isDisplayed(accountOption)) {
				accountOptionisDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return accountOptionisDisplayed;
	}

	/**@Test22
	 * about this method handleAlertPopup()
	 * @param : null
	 * @description : 
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public boolean handleAlertPopup() throws Exception {

		boolean isPopupHandled = false;

		try {
			commonEvents.click(operationTheatreNavMenuElement);
			Thread.sleep(2000);
			commonEvents.click(newOtBookingButtonElement);
			Thread.sleep(2000);
			if(commonEvents.isDisplayed(addNewOtButtonElement)){
				Thread.sleep(2000);
				commonEvents.click(addNewOtButtonElement);
				Thread.sleep(2000);
				//				commonEvents.validateAlertMessage();
				commonEvents.acceptAlert();
				isPopupHandled = true;
			}
		}catch(Exception e) {
			throw e;
		}
		return isPopupHandled;
	}
}