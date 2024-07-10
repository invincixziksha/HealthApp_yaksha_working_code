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
	By addNewPatientPageTitle = By.xpath("//span[.='Add New Patient']");
	By patientConsuptionTab = By.xpath("//a[.=' Patient Consumption ']");
	By newConsuptionButton = By.xpath("//button[@class='btn green btn-success']");
	By saveConsuptionButton = By.id("btn-save");
	By confirmMessage = By.xpath("//p[.='Are you sure you want to Proceed ?']");
	By confirmButton = By.id("id_btn_confirm_confirmation");
	By newConsumptionEntryPageCancelButton = By.xpath("//a[@title='Cancel']");
//	By mainStoreOption = By.xpath("//option[.='Main store']");
	By filterByStoreDropdown = By.id("Store");

	By firstNameTextFieldInAddNewPatient = By.id("newPatFirstName");
	By middleNameTextFieldInAddNewPatient = By.id("newPatMiddleName");
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
	By requisitionTab = By.xpath("//a[.='Requisition']");
	By addRequisitionsPageName = By.xpath("//span[.='Add Requisition']");

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
	 * @description : verify all sub-modules are displayed correctly after clicking on the expand icon of  "Dispensary" Module.
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
	 * @description :scroll to the bottom of the "Sale" page and verify that "Print Invoice" button  , "Discard" button  ,"Invoice History" and  "Credit Limitis and Balance" text are peresent or not?
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean scrollToButtomAndVerifytheFields() throws Exception {
		boolean creditLimitsAndBalancesTextElementIsDisplayed = false;
		try {
			userActions.click(morningCounter);
			Thread.sleep(3000);
			WebElement creditLimitsAndBalancesTextElementWebElement=userActions.findElement(creditLimitsAndBalancesTextElement);
			userActions.scrollIntoView(creditLimitsAndBalancesTextElementWebElement);
			Thread.sleep(3000);
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
	 * @description :Perform the keyboard operation to open the "Add New Patient" popup Page  and verify that the popup is displayed or not.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public String performTheKeyboardOperationToOpenthePopup() throws Exception {
		String pageName = "";
		try {
			userActions.performAltN();
			userActions.isDisplayed(addNewPatientPopup);
			pageName=userActions.getText(addNewPatientPageTitle);
			System.out.println("Add New Patient page title is :" + pageName);
		}catch(Exception e) {
			throw e;
		}	
		return pageName;
	}


	/**@Test6
	 * about this method validateErrorMessageInFirstnameTextfield() 
	 * @param : null
	 * @description : Validate the error message in "Add New Patient" form's  firstname textfield after clicking on "Ok" Button without filling any information in the form
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

	/**@Test7.1
	 * about this method fillfirstNameTextFieldVerifyTheFirstName() 
	 * @param : Map<String, String>
	 * @description : fill First Name TextField and Verify First name
	 * @return : String
	 * @author : Yaksha
	 */
	public String fillfirstNameTextFieldVerifyTheFirstName(Map<String, String> expectedData) throws Exception {
		String firstNameTextfieldValue= "";
		try {
			if(userActions.isDisplayed(firstNameTextFieldInAddNewPatient))
			{
				userActions.click(firstNameTextFieldInAddNewPatient);
				userActions.sendKeys(firstNameTextFieldInAddNewPatient,expectedData.get("firstName"));

				firstNameTextfieldValue = userActions.getAttribute(firstNameTextFieldInAddNewPatient, "value");
				System.out.println("FirstName : " + firstNameTextfieldValue);
								
			}
		}catch(Exception e) {
			throw e;
		}
		return firstNameTextfieldValue;
	}

	/**@Test7.2
	 * about this method fillmiddelNameTextFieldVerifyThemiddleName() 
	 * @param : Map<String, String>
	 * @description : fill Middle Name TextField and Verify middle name
	 * @return : String
	 * @author : Yaksha
	 */
	public String fillmiddelNameTextFieldVerifyThemiddleName(Map<String, String> expectedData) throws Exception {
		String middleNameTextfieldValue= "";
		try {
			if(userActions.isDisplayed(middleNameTextFieldInAddNewPatient))
			{
				
				userActions.click(middleNameTextFieldInAddNewPatient);
				userActions.sendKeys(middleNameTextFieldInAddNewPatient,expectedData.get("middleName"));

				middleNameTextfieldValue = userActions.getAttribute(middleNameTextFieldInAddNewPatient, "value");
				System.out.println("Middle name : " + middleNameTextfieldValue);
								
			}
		}catch(Exception e) {
			throw e;
		}
		return middleNameTextfieldValue;
	}

	/**@Test7.3
	 * about this method filllastNameTextfieldVerifylastName() 
	 * @param : Map<String, String>
	 * @description : fill Last Name TextField and Verify Last name
	 * @return : String
	 * @author : Yaksha
	 */
	public String filllastNameTextfieldVerifylastName(Map<String, String> expectedData) throws Exception {
		String lastNameTextfieldValue= "";
		try {
			if(userActions.isDisplayed(lastNameTextFieldInAddNewPatient))
			{
				
				userActions.click(lastNameTextFieldInAddNewPatient);
				userActions.sendKeys(lastNameTextFieldInAddNewPatient,expectedData.get("lastName"));

				lastNameTextfieldValue = userActions.getAttribute(lastNameTextFieldInAddNewPatient, "value");
				System.out.println("Last name : " + lastNameTextfieldValue);
								
			}
		}catch(Exception e) {
			throw e;
		}
		return lastNameTextfieldValue;
	}
	
	/**@Test7.4
	 * about this method fillAgeTextFieldVerifyTheAge() 
	 * @param : Map<String, String>
	 * @description : fill age and Verify the age.
	 * @return : String
	 * @author : Yaksha
	 */
	public String fillAgeTextFieldVerifyTheAge(Map<String, String> expectedData) throws Exception {
		String ageTextfieldValue= "";
		try {
			if(userActions.isDisplayed(ageTextFieldInAddNewPatient))
			{
				
				userActions.click(ageTextFieldInAddNewPatient);
				userActions.sendKeys(ageTextFieldInAddNewPatient,expectedData.get("age"));

				ageTextfieldValue = userActions.getAttribute(ageTextFieldInAddNewPatient, "value");
				System.out.println("Age is : " + ageTextfieldValue);
								
			}
		}catch(Exception e) {
			throw e;
		}
		return ageTextfieldValue;
	}
	
	
	
	/**@Test7.5
	 * about this method fillContactNumberTextFieldVerifyContactNumber() 
	 * @param : Map<String, String>
	 * @description : fill Contact Number TextField and Verify Contact Number
	 * @return : String
	 * @author : Yaksha
	 */
	public String fillContactNumberTextFieldVerifyContactNumber(Map<String, String> expectedData) throws Exception {
		String contactNumberTextfieldValue= "";
		try {
			if(userActions.isDisplayed(contactNumberTextFieldInAddNewPatient))
			{
				
				userActions.click(contactNumberTextFieldInAddNewPatient);
				userActions.sendKeys(contactNumberTextFieldInAddNewPatient,expectedData.get("contact"));
				
				contactNumberTextfieldValue = userActions.getAttribute(contactNumberTextFieldInAddNewPatient, "value");
				System.out.println("Contact Number is : " + contactNumberTextfieldValue);
								
			}
		}catch(Exception e) {
			throw e;
		}
		return contactNumberTextfieldValue;
	}	
	
	/**@Test8
	 * about this method validateTheConfirmMessageOnTheNewConsumptionEntryPage() 
	 * @param : null
	 * @description : On the "New Consumption Entry's page, validate the confirm! Message that is "Are you sure you want to Proceed ?"
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public String validateTheConfirmMessageOnTheNewConsumptionEntryPage() throws Exception {
		String confirmMessageText = "";
		try {
			userActions.click(xButton);
			userActions.click(patientConsuptionTab);
			userActions.click(newConsuptionButton);
			userActions.click(saveConsuptionButton);
			confirmMessageText=userActions.getText(confirmMessage);
			System.out.println("Confirmation message is :" +confirmMessageText);
		}catch(Exception e) {
			throw e;
		}	
		return confirmMessageText;
	}
	
	
	/**@Test9
	 * about this method selectMainStoreFromFilterSelectMainStoreFromFilter() 
	 * @param : null
	 * @description : on the Stock page,select Main store from Filter by store dropdown and verify that Main store is selected and stock value are filtered by the selected store name 
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean selectMainStoreFromFilterSelectMainStoreFromFilter() throws Exception {
		boolean mainStoreDropDownIsSelected = false;
		try {
			 userActions.click(confirmButton);
			 userActions.click(newConsumptionEntryPageCancelButton);
			 userActions.click(stockSubModule);
			 if(userActions.isDisplayed(filterByStoreDropdown)) {
				 userActions.click(filterByStoreDropdown);
				 userActions.click(mainStoreOption);
//				 userActions.click(filterByStoreDropdown);
				 Thread.sleep(3000);
				 mainStoreDropDownIsSelected=true;
			 }
		}catch(Exception e) {
			throw e;
		}	
		return mainStoreDropDownIsSelected;
	}
	
	
	/**@Test10
	 * about this method validateCreateRequisitionButtonIsPresentGoToThisPageThenValidateThePageName() 
	 * @param : null
	 * @description : on the stock page , please validate clicking "Create Requisition" button navigate to "Add Requisitions" page and validate the page Name.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public String validateCreateRequisitionButtonIsPresentGoToThisPageThenValidateThePageName() throws Exception {
		String addRequisitionsPageNameText = "";
		try {
			userActions.isSelected(stockSubModule);
			userActions.click(requisitionTab);
			userActions.isDisplayed(createRequisitionButton);
			userActions.click(createRequisitionButton);
			addRequisitionsPageNameText=userActions.getText(addRequisitionsPageName);
			System.out.println("Add Requisitions Page Name Text is : " +addRequisitionsPageNameText);
		}catch(Exception e) {
			throw e;
		}	
		return addRequisitionsPageNameText;
	}
	
	
	
	/**@Test11
	 * about this method byClickingOnThatButtonSomeTextFieldsAreDisplyed() 
	 * @param : null
	 * @description : on the Add Requisition page, clicking the + icon button on right hand side of Remarks text box add a  the New set of elements to add a new records and validate New Item text field, Quantity Text field and Remark text box are present or not 2nd rows?
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean byClickingOnThatButtonSomeTextFieldsAreDisplyed() throws Exception {
		boolean mainStoreDropDownIsSelected = false;
		try {
			 
			 
		}catch(Exception e) {
			throw e;
		}	
		return mainStoreDropDownIsSelected;
	}
}
