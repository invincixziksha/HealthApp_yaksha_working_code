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
	By  createRequisitionButton = By.xpath("//button[@class='btn btn-primary']");
	By itemNameTextfield=By.id("itemName0");
	By  cancelButton = By.xpath("//input[@value='Cancel']");
	By  viewButton = By.xpath("(//a[contains(text(),'View')])[1]");	
	By  medicineNameField = By.xpath("//table//tr[@style='text-align:center']//td");
	By  printButton = By.xpath("//a[@class='btn btn-default']");
	By  requisitionsListButton = By.xpath("//a[@class='btn btn-primary']");
	By  RequisitionPageTitle = By.xpath("//b[.=' REQUISITION DETAILS PRINT']");
	By socialServiceModule = By.xpath("//span[.='SocialService']");	
	By registerNewSSUPatientButton = By.xpath("//a[.=' Register New SSU Patient']");
	By addressTextField = By.id("address");
	By xButton = By.xpath("//button[.='X']");
	
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
	 * about this method verifyDispensaryModuleIsPresentOrNot() 
	 * @param : null
	 * @description : vverify the Dispensary module is present or not
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyDispensaryModuleIsPresentOrNot() throws Exception {
		boolean dispensaryModuleIsDisplayed = false;
		try {
			commonEvents.isDisplayed(dispensaryModule);
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
			if(commonEvents.isDisplayed(dispensaryModule)){
				commonEvents.jsClick(dispensaryToggle);
				commonEvents.isDisplayed(PrescriptionSubModule);				
				commonEvents.isDisplayed(saleSubModule);
				commonEvents.isDisplayed(stockSubModule);
				commonEvents.isDisplayed(counterSubModule);
				commonEvents.isDisplayed(reportsSubModule);
				commonEvents.isDisplayed(patientConsumptionSubModule);
				commonEvents.click(dispensaryModule);
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
			commonEvents.click(morningCounter);
			if(commonEvents.isDisplayed(printInvoiceButtonElement) &&
					commonEvents.isDisplayed(discardButtonElement) &&
					commonEvents.isDisplayed(invoiceHistoryTextElement) &&
					commonEvents.isDisplayed(creditLimitsAndBalancesTextElement) ) {
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
			commonEvents.performAltN();
			if(commonEvents.isDisplayed(addNewPatientPopup)){
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
			if(commonEvents.isDisplayed(okButton)) {
				commonEvents.click(okButton);
				Thread.sleep(5000);
				errorMessageText = commonEvents.getText(errorMeesageInFirstNameTextField);
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
			if(commonEvents.isDisplayed(firstNameTextFieldInAddNewPatient) && 
					commonEvents.isDisplayed(middelNameTextFieldInAddNewPatient) &&
					commonEvents.isDisplayed(lastNameTextFieldInAddNewPatient) &&
					commonEvents.isDisplayed(ageTextFieldInAddNewPatient) &&
					commonEvents.isDisplayed(contactNumberTextFieldInAddNewPatient))
			{
				commonEvents.click(firstNameTextFieldInAddNewPatient);
				commonEvents.sendKeys(firstNameTextFieldInAddNewPatient,expectedData.get("firstName"));

				commonEvents.click(middelNameTextFieldInAddNewPatient);
				commonEvents.sendKeys(middelNameTextFieldInAddNewPatient,expectedData.get("middleName"));

				commonEvents.click(lastNameTextFieldInAddNewPatient);
				commonEvents.sendKeys(lastNameTextFieldInAddNewPatient,expectedData.get("lastName"));

				commonEvents.click(ageTextFieldInAddNewPatient);
				commonEvents.sendKeys(ageTextFieldInAddNewPatient,expectedData.get("age"));

				commonEvents.click(contactNumberTextFieldInAddNewPatient);
				commonEvents.sendKeys(contactNumberTextFieldInAddNewPatient,expectedData.get("contact"));

				firstNameTextfieldValue = commonEvents.getAttribute(firstNameTextFieldInAddNewPatient, "value");
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
			commonEvents.click(XButton);
			commonEvents.click(stockSubModule);
			Thread.sleep(3000); 
			commonEvents.click(lastButtonInstockSubModule);
			if(commonEvents.isDisplayed(totalStockValueText))
			{
				String totalStockValuetext=commonEvents.getText(totalStockValueText, pageName, pageName);
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
			if(commonEvents.isDisplayed(mainDispensaryOption)) {
				commonEvents.isSelected(mainDispensaryOption);
				commonEvents.click(mainStoreOption);
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
			if(commonEvents.isDisplayed(requisitionSubModule)) {
				commonEvents.click(requisitionSubModule);
				commonEvents.isDisplayed(createRequisitionButton);
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
				commonEvents.click(createRequisitionButton);
				if(commonEvents.isDisplayed(itemNameTextfield)){
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
			  commonEvents.click(cancelButton);
			  commonEvents.click(viewButton);
			  if(commonEvents.isDisplayed(medicineNameField) &&
			  commonEvents.isDisplayed(printButton) &&
			  commonEvents.isDisplayed(RequisitionPageTitle)) {
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
			if(commonEvents.isDisplayed(medicineNameField)) {
			String medicineNameFieldValue=commonEvents.getText(medicineNameField);
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
			commonEvents.click(socialServiceModule);
			commonEvents.click(registerNewSSUPatientButton);
			if(commonEvents.isDisplayed(addressTextField)) {
				Thread.sleep(3000);
				placeHolderName = commonEvents.getAttribute(addressTextField,"placeholder");
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
			if(commonEvents.isDisplayed(xButton)) {
			  commonEvents.jsClick(xButton);
			  Thread.sleep(3000);
			  IsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return IsDisplayed;
	}
	
}
