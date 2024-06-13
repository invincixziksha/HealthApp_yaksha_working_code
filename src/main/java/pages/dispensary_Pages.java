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
	 * @description : verify Dispensary Module Is Present
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyDispensaryModuleIsPresentOrNot() throws Exception {
		boolean isDisplayed = false;
		try {
			commonEvents.isDisplayed(dispensaryModule);
			isDisplayed=true;
		}catch(Exception e) {
			throw e;
		}	
		return isDisplayed;
	}
	
	/**@Test3
	 * about this method verifyAllSubModulesArePresent() 
	 * @param : null
	 * @description : verify All Sub Modules Are Present inside the dispensaryModule
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyAllSubModulesArePresent() throws Exception {
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
				patientConsumptionSubModuleisDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return patientConsumptionSubModuleisDisplayed;
	}
	
	
	/**@Test4.1
	 * about this method verifyUrlOfCounterPage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyUrlOfCounterPage() throws Exception {
		String urlofThepage = "";
		try {
			urlofThepage = commonEvents.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage );
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}
	
	/**@Test4.2
	 * about this method verifyAllFieldsInsideTheCounterPage() 
	 * @param : null
	 * @description : verify All Fields Inside The Counter Page 
	 * @return : String
	 * @author : Yaksha
	 */
	public Boolean verifyAllFieldsInsideTheCounterPage() throws Exception {
		boolean isDisplayed = false;
		try {
			if(commonEvents.isDisplayed(dispensaryModule)) {
				commonEvents.isDisplayed(PrescriptionSubModule);				
				commonEvents.isDisplayed(saleSubModule);
				commonEvents.isDisplayed(stockSubModule);
				commonEvents.isDisplayed(counterSubModule);
				commonEvents.isDisplayed(reportsSubModule);
				commonEvents.isDisplayed(patientConsumptionSubModule);
				commonEvents.isDisplayed(counterSelection);
				commonEvents.isDisplayed(morningCounter);
				commonEvents.isDisplayed(eveningCounter);
				commonEvents.isDisplayed(nightCounter);
				isDisplayed=true;
			}
			isDisplayed=true;
		}catch(Exception e) {
			throw e;
		}	
		return isDisplayed;
	}
	/**@Test5.1
	 * about this method verifyUrlOfSalePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyUrlOfSalePage() throws Exception {
		String urlofThepage = "";
		try {
			if(commonEvents.isDisplayed(morningCounter)) {
				commonEvents.click(morningCounter);
				Thread.sleep(5000);
				urlofThepage = commonEvents.getCurrentUrl();
				System.out.println("URL of the page is  :" + urlofThepage );
				return urlofThepage;
			}
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}
	
	/**@Test5.2
	 * about this method verifyAllFieldsInsideTheSalePage() 
	 * @param : null
	 * @description :Verify Presence of all fields should be : Sale , Sale List, Return from customer, Return Sale List, Provisional Bills, Settlement, Provisional Return
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyAllFieldsInsideTheSalePage() throws Exception {
		boolean isDisplayed = false;
		try {
			if(commonEvents.isDisplayed(saleListTab)) {
				commonEvents.isDisplayed(saleListTab);
				commonEvents.isDisplayed(returnFromCustomerTab);
				commonEvents.isDisplayed(returnSaleListTab);
				commonEvents.isDisplayed(provisionalBillsTab);
				commonEvents.isDisplayed(settlementTab);
				commonEvents.isDisplayed(ProvisionalReturnTab);
				isDisplayed=true;
			}
			isDisplayed=true;
		}catch(Exception e) {
			throw e;
		}	
		return isDisplayed;
	}
	
	
	/**@Test6
	 * about this method scrollToButtomOfTheSalePageAndVerifyPresenceOfFields()
	 * @param : get the data from json file as type Map<String, String> expectedData
	 * @description : enter value in text field of Add New Patient as per json expected data and fetch the value of that text field ,
	 * @return : fetch the value text field as string type
	 * @author : Yaksha
	 */
	public Boolean scrollToButtomOfTheSalePageAndVerifyPresenceOfFields() throws Exception {
		Boolean fieldIsPresent = false;
 
		commonEvents.jsScrollPageTillElementVisible(creditLimitsAndBalancesTextElement,"elementName","pageName");
 
		try {
			if(commonEvents.isDisplayed(printInvoiceButtonElement) &&
					commonEvents.isDisplayed(discardButtonElement) &&
					commonEvents.isDisplayed(invoiceHistoryTextElement) &&
					commonEvents.isDisplayed(creditLimitsAndBalancesTextElement) ) {
 
				WebElement printInvoiceButtonWebElement = commonEvents.findElement(printInvoiceButtonElement);
				commonEvents.highlightElement(printInvoiceButtonWebElement);
				
				WebElement discardButtonWebElement = commonEvents.findElement(discardButtonElement);
				commonEvents.highlightElement(discardButtonWebElement);
				
				WebElement invoiceHistoryTextWebElement = commonEvents.findElement(invoiceHistoryTextElement);
				commonEvents.highlightElement(invoiceHistoryTextWebElement);
				
				WebElement creditLimitsAndBalancesTextWebElement = commonEvents.findElement(creditLimitsAndBalancesTextElement);
				commonEvents.highlightElement(creditLimitsAndBalancesTextWebElement);
 
				fieldIsPresent = true;
 
			}
		}catch(Exception e) {
			throw e;
		}
		return fieldIsPresent;
	}
	
	/**@Test7
	 * about this method performTheKeyboardOperationToOpenthePopup() 
	 * @param : null
	 * @description : perform The Keyboard Operation(alt + N) To Open the Popup
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean performTheKeyboardOperationToOpenthePopup() throws Exception {
		boolean isDisplayed = false;
		try {
			commonEvents.performAltN();
			if(commonEvents.isDisplayed(addNewPatientPopup)){
				isDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return isDisplayed;
	}
	
	
	/**@Test8
	 * about this method validateErrorMessageInFirstnameTextfield() 
	 * @param : null
	 * @description : validate Error Message In First name Textfield
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
	
	/**@Test9
	 * about this method fillAllTheTextfieldsInsideTheAddNewPatient() 
	 * @param : Map<String, String>
	 * @description : fill All The Textfields Inside The Add New Patient
	 * @return : String
	 * @author : Yaksha
	 */
	public String fillAllTheTextfieldsInsideTheAddNewPatient(Map<String, String> expectedData) throws Exception {
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
	
	
	
	/**@Test10
	 * about this method checktheDataArePresentInFirstNameField() 
	 * @param : null
	 * @description : check the Data Are Present In First Name Field
	 * @return : String
	 * @author : Yaksha
	 */
	public String checktheDataArePresentInFirstNameField() throws Exception {
		String FirstNameFieldValue = "";

		try {
			if(commonEvents.isDisplayed(firstNameTextFieldInAddNewPatient)) {
			FirstNameFieldValue = commonEvents.getAttribute(firstNameTextFieldInAddNewPatient, "value");
			System.out.println("First Name TextField value is : " + FirstNameFieldValue);
			return FirstNameFieldValue;
			}
		}catch(Exception e) {
			throw e;
		}
		return FirstNameFieldValue;
	}
	
	
	/**@Test11
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
}
