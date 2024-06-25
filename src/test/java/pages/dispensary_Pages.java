package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dispensary_Pages extends StartupPage {

	By usernameTextfield=By.id("username_id");
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");
	By dispensaryModule = By.xpath("//span[.='Dispensary']");
	By dispensaryToggle = By.xpath("//span[@data-target='#Dispensary']");	
	By PrescriptionSubModule = By.xpath("//span[.='Prescription']");
	By saleSubModule = By.xpath("//span[.='Sale']");
	By stockSubModule = By.xpath("//span[.='Stock']");
	By counterSubModule = By.xpath("//span[.='Counter']");
	By reportsSubModule = By.xpath("//span[.='Reports']");
	By patientConsumptionSubModule = By.xpath("//span[.='Patient Consumption']");
	By morningCounter = By.xpath("(//div[@class='counter-item'])[1]");
	By eveningCounter = By.xpath("(//div[@class='counter-item'])[2]");
	By nightCounter = By.xpath("(//div[@class='counter-item'])[3]");
	By counterSelection = By.xpath("//span[.='Counter Selection']");
	By saleTab = By.xpath("(//a[.='Sale'])[2]");
	By saleListTab = By.xpath("//a[.='Sale List']");
	By returnFromCustomerTab = By.xpath("//a[.='Return From Customer']");
	By returnSaleListTab = By.xpath("//a[.='Return Sale List']");
	By provisionalBillsTab = By.xpath("//a[.='Provisional Bills']");
	By settlementTab = By.xpath("//a[.='Settlement']");
	By ProvisionalReturnTab = By.xpath("//a[.='Provisional Return']");
	By addNewPatientPopup = By.xpath("//div[@class='modelbox-body p2']");
	By okButton = By.xpath("//button[.=' OK']");
	By errorMeesageInFirstNameTextField = By.xpath("//span[.=' First Name is required.']");

	By firstNameTextFieldInAddNewPatient = By.id("newPatFirstName");
	By middelNameTextFieldInAddNewPatient = By.id("newPatMiddleName");
	By lastNameTextFieldInAddNewPatient = By.id("newPatLastName");
	By ageTextFieldInAddNewPatient = By.id("Age");
	By contactNumberTextFieldInAddNewPatient = By.id("Contact");
	By XButton = By.xpath("//button[.='X']");
	By lastButtonInstockSubModule = By.xpath("//button[.='Last']");
	By totalStockValueText = By.xpath("//div[@class='right']");

	By printInvoiceButtonElement = By.xpath("//input[@value='Print Invoice']");
	By discardButtonElement = By.xpath("//button[contains(text() , 'Discard')]");
	By invoiceHistoryTextElement = By.xpath("//b[contains(text() , 'Invoice History')]");
	By creditLimitsAndBalancesTextElement = By.xpath("//b[contains(text() , 'Credit Limits and Balances')]");

	By storeDropdownElement = By.xpath("//select[@id='Store']");
	By totalStockValueOfAllStockElement = By.xpath("//div[@class='right']");

	By requisitionsLinkElement = By.xpath("//a[@routerlink='Requisition']");
	By createRequisitionsButtonElement = By.xpath("//button[@class='btn btn-primary']");	
	By mainDispensaryOption = By.xpath("//option[.='Main Dispensary']");
	By mainStoreOption = By.xpath("//option[.='Main store']");
	By requisitionSubModule = By.xpath("//a[.='Requisition']");
	By createRequisitionButton = By.xpath("//button[@class='btn btn-primary']");
	By itemNameTextfield=By.id("itemName0");
	By cancelButton = By.xpath("//input[@value='Cancel']");
	By viewButton = By.xpath("(//a[contains(text(),'View')])[1]");	
	By medicineNameField = By.xpath("//table//tr[@style='text-align:center']//td");
	By printButton = By.xpath("//a[@class='btn btn-default']");
	By requisitionsListButton = By.xpath("//a[@class='btn btn-primary']");
	By RequisitionPageTitle = By.xpath("//b[.=' REQUISITION DETAILS PRINT']");
	By socialServiceModule = By.xpath("//span[.='SocialService']");	
	By registerNewSSUPatientButton = By.xpath("//a[.=' Register New SSU Patient']");
	By addressTextField = By.id("address");
	By xButton = By.xpath("//button[.='X']");
	By procurementModule = By.xpath("//span[.='Procurement']");
	By settingsTab = By.xpath("//a[.=' Settings ']");
	By invoiceHeadersSubTab = By.xpath("//a[.='Invoice Headers']");
	By addNewInvoiceHeaderButton = By.xpath("//input[@value='Add New Invoice Header']");
	By chooseFileButton = By.id("img");

	By shortCutKeysArrowIconElement = By.xpath("//img[@src='../../../themes/theme-default/images/arrows.svg']");
	By salesPageTooltipsValueElement = By.xpath("//div[@class='keydropdown']//ul");
	By dispensarySalesNavigationMenuElement = By.xpath("//span[.='Sale']");


	By appointmentTab=By.xpath("(//span[.='Appointment'])[1]");
	By keyboardButton=By.xpath("//div[@title='Shortcut Keys']");
	By tooltip=By.xpath("//li[contains(text(),'+')]");
	By countryDropdownByElement = By.xpath("//select[@id='ddlCountry']");
	By dispensarySaleTabElement = By.xpath("//a[.=' Sale ']");

	By patientSearchTextBoxElement = By.xpath("//input[@id='patient-search']");
	By listOfpatientlElement = By.xpath("//input[@id='patient-search']//");

	By operationTheatreNavMenuElement = By.xpath("//a[@href='#/OperationTheatre']");
	By newOtBookingButtonElement = By.xpath("//button[contains(text(), 'New OT Booking')]");
	By addNewOtButtonElement = By.xpath("//input[@value='Add New OT']");
	By addInvoiceHeaderCloseButtonElement = By.xpath("//a[.='X']");

	By othersChargesTab = By.xpath("//a[.='Other Charges']");
	By addOtherChargesButton = By.xpath("//input[@value='Add Other Charges']");
	By isVATApplicableCheckBox = By.xpath("(//label[@class='mt-checkbox mt-checkbox-outline'])[1]//span");
	By isActiveCheckBox = By.xpath("(//label[@class='mt-checkbox mt-checkbox-outline'])[2]//span");
	By isDefaultCheckBox = By.xpath("(//label[@class='mt-checkbox mt-checkbox-outline'])[3]//span");
	By bookingOTSchedulePageCloseButtonElement = By.xpath("//a[.='X']");

	By procurementModuleSettingTabElement = By.xpath("//a[contains(text(), 'Settings')]");
	By addOtherChargesCloseButtonElement = By.xpath("//a[@title='Cancel']");






	String pageName = this.getClass().getSimpleName();
	public dispensary_Pages(WebDriver driver) {
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
	 * about this method verifyDispensaryModuleIsPresentOrNot() 
	 * @param : null
	 * @description : vverify the Dispensary module is present or not
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyDispensaryModuleIsPresentOrNot() throws Exception {
		boolean dispensaryModuleIsDisplayed = false;
		try {
			userActions.isDisplayed(dispensaryModule);
			dispensaryModuleIsDisplayed=true;
		}catch(Exception e) {
			throw e;
		}	
		return dispensaryModuleIsDisplayed;
	}

	/**@Test3
	 * about this method verifyAllSubModulesArePresentAndClickOnDispensary() 
	 * @param : null
	 * @description : verify all sub-modules are displayed correctly after clicking on the "Dispensary" Module.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyAllSubModulesArePresentAndClickOnDispensary() throws Exception {
		boolean patientConsumptionSubModuleisDisplayed = false;
		try {
			if(userActions.isDisplayed(dispensaryModule)){
				userActions.jsClick(dispensaryToggle);
				userActions.isDisplayed(PrescriptionSubModule);				
				userActions.isDisplayed(saleSubModule);
				userActions.isDisplayed(stockSubModule);
				userActions.isDisplayed(counterSubModule);
				userActions.isDisplayed(reportsSubModule);
				userActions.isDisplayed(patientConsumptionSubModule);
				userActions.click(dispensaryModule);
				patientConsumptionSubModuleisDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return patientConsumptionSubModuleisDisplayed;
	}


	/**@Test4
	 * about this method scrollToButtomAndVerifytheFields() 
	 * @param : null
	 * @description : scroll to the bottom of the "Sale" page and verify that "Print Invoice" button  , "Discard" button  ,"Invoice History" and  "Credit Limitis and Balance" text are peresent or not.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean scrollToButtomAndVerifytheFields() throws Exception {
		boolean creditLimitsAndBalancesTextElementIsDisplayed = false;
		try {
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



	/**@Test5
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


	/**@Test6
	 * about this method validateErrorMessageInFirstnameTextfield() 
	 * @param : null
	 * @description : Validate the error message in firstname textfield after click on "Ok" button
	 * @return : String
	 * @author : Yaksha
	 */
	public String validateErrorMessageInFirstnameTextfield() throws Exception {
		String errorMessageText = "";
		try {
			if(userActions.isDisplayed(okButton)) {
				userActions.click(okButton);
				Thread.sleep(5000);
				errorMessageText = userActions.getText(errorMeesageInFirstNameTextField);
				System.out.println("Error Meesage is  :" + errorMessageText );
				return errorMessageText;	
			}
		}catch(Exception e) {
			throw e;
		}	
		return errorMessageText;
	}

	/**@Test7
	 * about this method fillAllTheTextfieldsInsideTheAddNewPatientVerifyTheFirstName() 
	 * @param : Map<String, String>
	 * @description : Fill all the textfields which are present inside the Add New Patient popup. and verify that value is present after enter the values.
	 * @return : String
	 * @author : Yaksha
	 */
	public String fillAllTheTextfieldsInsideTheAddNewPatientVerifyTheFirstName(Map<String, String> expectedData) throws Exception {
		String firstNameTextfieldValue = "";
		try {
			if(userActions.isDisplayed(firstNameTextFieldInAddNewPatient) && 
					userActions.isDisplayed(middelNameTextFieldInAddNewPatient) &&
					userActions.isDisplayed(lastNameTextFieldInAddNewPatient) &&
					userActions.isDisplayed(ageTextFieldInAddNewPatient) &&
					userActions.isDisplayed(contactNumberTextFieldInAddNewPatient))
			{
				userActions.click(firstNameTextFieldInAddNewPatient);
				userActions.sendKeys(firstNameTextFieldInAddNewPatient,expectedData.get("firstName"));

				userActions.click(middelNameTextFieldInAddNewPatient);
				userActions.sendKeys(middelNameTextFieldInAddNewPatient,expectedData.get("middleName"));

				userActions.click(lastNameTextFieldInAddNewPatient);
				userActions.sendKeys(lastNameTextFieldInAddNewPatient,expectedData.get("lastName"));

				userActions.click(ageTextFieldInAddNewPatient);
				userActions.sendKeys(ageTextFieldInAddNewPatient,expectedData.get("age"));

				userActions.click(contactNumberTextFieldInAddNewPatient);
				userActions.sendKeys(contactNumberTextFieldInAddNewPatient,expectedData.get("contact"));

				firstNameTextfieldValue = userActions.getAttribute(firstNameTextFieldInAddNewPatient, "value");
				System.out.println("FirstName : " + firstNameTextfieldValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return firstNameTextfieldValue;
	}



	/**@Test8
	 * about this method navigateToLastPageOfTheStockDetailsAndFetchTotalStockValue() 
	 * @param : null
	 * @description : Navigate to the Last page of the stock details list pagenation and fetch the total stock value
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean navigateToLastPageOfTheStockDetailsAndFetchTotalStockValue() throws Exception {
		boolean isDisplayed = false;
		try {
			userActions.click(XButton);
			userActions.click(stockSubModule);
			Thread.sleep(3000); 
			userActions.click(lastButtonInstockSubModule);
			if(userActions.isDisplayed(totalStockValueText))
			{
				String totalStockValuetext=userActions.getText(totalStockValueText, pageName, pageName);
				System.out.println(totalStockValuetext);
				isDisplayed=true;
			}

		}catch(Exception e) {
			throw e;
		}	
		return isDisplayed;
	}


	/**@Test9
	 * about this method checkMainDispensaryIsSelectedFromFilterStockDropdown() 
	 * @param : null
	 * @description : check "Main Dispensary" is selected from filter stock dropdown and select main store.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean checkMainDispensaryIsSelectedFromFilterStockDropdown() throws Exception {
		boolean isSelected = false;
		try {
			if(userActions.isDisplayed(mainDispensaryOption)) {
				userActions.isSelected(mainDispensaryOption);
				userActions.click(mainStoreOption);
				isSelected = true;
			}

		}catch(Exception e) {
			throw e;
		}	
		return isSelected;
	}


	/**@Test10
	 * about this method validateCreateRequisitionButtonIsPresent() 
	 * @param : null
	 * @description : validate "create requisition" button is present or not
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean validateCreateRequisitionButtonIsPresent() throws Exception {
		boolean createRequisitionButtonIsDisplayed = false;
		try {
			if(userActions.isDisplayed(requisitionSubModule)) {
				userActions.click(requisitionSubModule);
				userActions.isDisplayed(createRequisitionButton);
				createRequisitionButtonIsDisplayed=true;
			}

		}catch(Exception e) {
			throw e;
		}	
		return createRequisitionButtonIsDisplayed;
	}


	/**@Test11
	 * about this method verifyNewItemTextFieldIsPresent() 
	 * @param : null
	 * @description : verify "Item Name" text field is present in "Add Requisition" page
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyNewItemTextFieldIsPresent() throws Exception {
		boolean itemNameTextfieldIsDisplayed = false;
		try {
			userActions.click(createRequisitionButton);
			if(userActions.isDisplayed(itemNameTextfield)){
				itemNameTextfieldIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return itemNameTextfieldIsDisplayed;
	}


	/**@Test12
	 * about this method verifyRequisitionDetailsPrintPageIsDisplayed() 
	 * @param : null
	 * @description : verify Requisition Details Print page
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyRequisitionDetailsPrintPageIsDisplayed() throws Exception {
		boolean RequisitionPageTitleIsDisplayed = false;
		try {
			userActions.click(cancelButton);
			userActions.click(viewButton);
			if(userActions.isDisplayed(medicineNameField) &&
					userActions.isDisplayed(printButton) &&
					userActions.isDisplayed(RequisitionPageTitle)) {
				RequisitionPageTitleIsDisplayed=true;
			}

		}catch(Exception e) {
			throw e;
		}	
		return RequisitionPageTitleIsDisplayed;
	}


	/**@Test13
	 * about this method getTheMedicineNameFromRequisitionDetailsPrintPage() 
	 * @param : null
	 * @description : Get the medicine name from the "Requisition Details Print" page
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean getTheMedicineNameFromRequisitionDetailsPrintPage() throws Exception {
		boolean medicineNameIsDisplayed = false;
		try {
			if(userActions.isDisplayed(medicineNameField)) {
				String medicineNameFieldValue=userActions.getText(medicineNameField);
				System.out.println("Medicine Name is  : " + medicineNameFieldValue);
				medicineNameIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return medicineNameIsDisplayed;
	}


	/**@Test14
	 * about this method getThePlaceHolderNameOfAddressTextfiled() 
	 * @param : null
	 * @description : Get the place holder name of address textfiled and verify  the place holder name.
	 * @return : String
	 * @author : Yaksha
	 */
	public String getThePlaceHolderNameOfAddressTextfiled(Map<String, String> expectedData) throws Exception {
		String placeHolderName = "";
		try {
			userActions.click(socialServiceModule);
			userActions.click(registerNewSSUPatientButton);
			if(userActions.isDisplayed(addressTextField)) {
				Thread.sleep(3000);
				placeHolderName = userActions.getAttribute(addressTextField,"placeholder");
				System.out.println("Place holder value of Address field : " + placeHolderName);
			}
		}catch(Exception e) {
			throw e;
		}	
		return placeHolderName;
	}


	/**@Test15
	 * about this method closeNewSSUPatientRegistrationPopupByUsingJsExecutor() 
	 * @param : null
	 * @description : Close this "New SSU Patient Registration" popup by using javaScript.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean closeNewSSUPatientRegistrationPopupByUsingJsExecutor() throws Exception {
		boolean IsDisplayed = false;
		try {
			if(userActions.isDisplayed(xButton)) {
				userActions.jsClick(xButton);
				Thread.sleep(3000);
				IsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return IsDisplayed;
	}

	/**@Test16
	 * about this method verifyToolTipOfAnElement()
	 * @param : null
	 * @description :go to appointmentTab and verify the TOOLTIP value/text
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyToolTipOfAnElement() throws Exception {
		String tooltipText="";
		try {
			userActions.click(appointmentTab);
			userActions.click(morningCounter);
			userActions.waitTillElementVisible(keyboardButton,50);
			userActions.mouseHoverClick(keyboardButton);
			userActions.waitTillElementVisible(tooltip,50);
			tooltipText=userActions.getText(tooltip);
			System.out.println("Tooltip text value is:" +tooltipText);
		}catch(Exception e) {
			throw e;
		}
		return tooltipText;
	}

	/**@Test17
	 * about this method verifyIndiaIsSelectedFromCountryDropdown() 
	 * @param : get the data from json file as type Map<String, String> expectedData
	 * @description : it will select the country as per json expected data
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyIndiaIsSelectedFromCountryDropdown(Map<String, String> expectedData) throws Exception {

		String selectedCountryName = "" ;

		userActions.click(saleSubModule);
		userActions.performAltN();

		try {
			userActions.selectByVisibleText(countryDropdownByElement, expectedData.get("selectedCountryName"));
			selectedCountryName = userActions.getFirstSelectedOptionFromDropdown(countryDropdownByElement, "elementName", "pageName");
			System.out.println("first selected option from country dropdown : " + selectedCountryName );
			//			userActions.click(xButton);
			return selectedCountryName;
		}catch(Exception e) {
			throw e;
		}	
	}

	/**@Test19
	 * about this method takingScreenshotOfTheCurrentPage() 
	 * @param : null
	 * @description : Taking screenshot of the current page.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean takingScreenshotOfTheCurrentPage() throws Exception {
		boolean isDisplayed = false;
		userActions.click(xButton);
		try {
			userActions.takeScreenshot("AddOtherCharges");
			isDisplayed=true;

		}catch(Exception e) {
			throw e;
		}
		return isDisplayed;
	}

	/**@Test20
	 * about this method uploadImageInScannedImagesSection() 
	 * @param : Map<String, String>
	 * @description : Upload a image in Scanned Images section.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean uploadImageInScannedImagesSection(String pathOfTheFile) throws Exception {
		boolean isUploaded = false;
		try {
			userActions.click(procurementModule);
			Thread.sleep(3000);
			userActions.click(settingsTab);
			Thread.sleep(3000);
			userActions.click(invoiceHeadersSubTab);
			Thread.sleep(3000);
			userActions.click(addNewInvoiceHeaderButton);
			Thread.sleep(3000);
			userActions.jsClick(chooseFileButton);
			Thread.sleep(3000);
			System.out.println("path of the file" + pathOfTheFile );
			Thread.sleep(5000);
			userActions.fileUpload(pathOfTheFile);
			Thread.sleep(3000);

			isUploaded = true;
		}catch(Exception e) {
			throw e;
		}
		return isUploaded;
	}

	/**@Test20
	 * about this method handleAlertPopup()
	 * @param : null
	 * @description : 
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public boolean handleAlertPopup() throws Exception {

		boolean isPopupHandled = false;

		userActions.click(addInvoiceHeaderCloseButtonElement);

		try {
			userActions.click(operationTheatreNavMenuElement);
			Thread.sleep(2000);
			userActions.click(newOtBookingButtonElement);
			Thread.sleep(2000);
			if(userActions.isDisplayed(addNewOtButtonElement)){
				Thread.sleep(2000);
				userActions.click(addNewOtButtonElement);
				Thread.sleep(2000);
				userActions.acceptAlert();

				isPopupHandled = true;
			}
		}catch(Exception e) {
			throw e;
		}
		return isPopupHandled;
	}

	/**@Test18
	 * about this method tickAllCheckboxesThenValidateThenUntick() 
	 * @param : null
	 * @description : First, tick all check boxes and validate that the all selected checkboxes are selected or not then untick them then close Add Other Charges.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean handleCheckBox() throws Exception {

		boolean isCheckBoxSelected = false;

		userActions.click(bookingOTSchedulePageCloseButtonElement);

		try {
			if(userActions.isDisplayed(procurementModule)) {
				userActions.click(procurementModule);

				userActions.click(procurementModuleSettingTabElement);
				Thread.sleep(3000);

				userActions.click(othersChargesTab);	
				Thread.sleep(3000);

				userActions.click(addOtherChargesButton);
				Thread.sleep(3000);

				userActions.click(isVATApplicableCheckBox);
				Thread.sleep(3000);

				userActions.click(isActiveCheckBox);
				Thread.sleep(3000);

				userActions.click(isDefaultCheckBox);

				userActions.isSelected(isVATApplicableCheckBox);
				userActions.isSelected(isActiveCheckBox);
				userActions.isSelected(isActiveCheckBox);

				Thread.sleep(3000);
				userActions.click(isVATApplicableCheckBox);

				Thread.sleep(3000);
				userActions.click(isActiveCheckBox);

				Thread.sleep(3000);
				userActions.click(isDefaultCheckBox);

				Thread.sleep(3000);
				userActions.click(addOtherChargesCloseButtonElement);

				isCheckBoxSelected = true;
			}
		}catch(Exception e) {
			throw e;
		}
		return isCheckBoxSelected;
	}

}
