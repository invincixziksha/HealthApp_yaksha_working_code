package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class yakshaHealthApp_L1_Pages extends StartupPage {
	//please write all the locators for Money Control page only 

	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");
	By billingNavigationMenuElement = By.xpath("(//span[contains(text(), 'Billing')])[1]");
	By selectCounterPopupElement = By.xpath("//h3//span[contains(text(), 'Select Counter')]");
	By new1TextElement = By.xpath("//h5[contains(text(), 'New-1')]");
	By new2TextElement = By.xpath("//h5[contains(text(), 'New-2')]");
	By new3TextElement = By.xpath("//h5[contains(text(), 'New-3')]");
	By old1TextElement = By.xpath("//h5[contains(text(), 'Old-1')]");
	By opdCounterTextElement = By.xpath("//h5[contains(text(), 'OPD-Counter')]");
	By addNewButtonElement = By.xpath("//button[contains(text(), 'Add New Patient')]");
	By addNewPatientTextElement = By.xpath("//span[contains(text(), 'Add New Patient')]");

	By firstNameTextFieldElement = By.xpath("//input[@id='newPatFirstName']");
	By middleNameTextFieldElement = By.xpath("//input[@id='newPatMiddleName']");
	By lastNameTextfieldElement = By.xpath("//input[@id='newPatLastName']");
	By ageTextfieldElement = By.xpath("//input[@id='age']");
	By contactNumberTextfieldElement = By.xpath("//input[@id='phoneNo']");

	By countryDropdownByElement = By.xpath("//select[@id='ddlCountry']");
	By registerAndBillingButtonElement = By.xpath("//button[contains(text(), 'Register & Billing')]");
	By errorMessageOfRegisterBillingByElement = By.xpath("//p[contains(text(), 'Some of the inputs are invalid. Please check and try again. !')]");
	By closeButtonOfAddNewpatientpage = By.xpath("//button[contains(text(), 'Close')]");

	By dispensaryToggle = By.xpath("//span[@data-target='#Dispensary']");
	By prescriptionSubMenu = By.xpath("//ul[@id='Dispensary']//li//a//span[contains(text(),'Prescription')]");
	By saleSubMenu = By.xpath("//ul[@id='Dispensary']//li//a//span[contains(text(),'Sale')]");
	By stockSubMenu = By.xpath("//ul[@id='Dispensary']//li//a//span[contains(text(),'Stock')]");
	By counterSubMenu = By.xpath("//ul[@id='Dispensary']//li//a//span[contains(text(),'Counter')]");
	By reportsSubMenu = By.xpath("//ul[@id='Dispensary']//li//a//span[contains(text(),'Reports')]");
	By patientConsumptionSubMenu = By.xpath("//ul[@id='Dispensary']//li//a//span[contains(text(),'Patient Consumption')]");

	//	By dispensaryLeftNavigationMenu = By.xpath("//a[@class='left-nav-active']//span[contains(text(), 'Dispensary')]");
	By dispensaryLeftNavigationMenu = By.xpath("//a[@href='#/Dispensary']//span[contains(text(), 'Dispensary')]");
	By settingLeftNavigationMenu = By.xpath("//a[@href='#/Settings']//span[contains(text(), 'Settings')]");
	



	String pageName = this.getClass().getSimpleName();
	public yakshaHealthApp_L1_Pages(WebDriver driver) 
	{
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

	/**@test2
	 * about this method verifySelectCounterPopupIsPresentAndNavigateToNextpage() 
	 * @param : null
	 * @description : it is verify all fields is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifySelectCounterPopupIsPresentAndNavigateToNextpage() throws Exception {
		Boolean selectCounterPopUpIsPresent = false;

		WebElement billingNavigationMenuWebElement = userActions.findElement(billingNavigationMenuElement);
		userActions.highlightElement(billingNavigationMenuWebElement);
		userActions.click(billingNavigationMenuElement);
		try {
			if(userActions.isDisplayed(selectCounterPopupElement)&&
					userActions.isDisplayed(new1TextElement)&&
					userActions.isDisplayed(new2TextElement)&&
					userActions.isDisplayed(new3TextElement)&&
					userActions.isDisplayed(old1TextElement)&&
					userActions.isDisplayed(opdCounterTextElement)) {

				WebElement selectCounterPopupWebElement = userActions.findElement(selectCounterPopupElement);
				userActions.highlightElement(selectCounterPopupWebElement);

				WebElement new1TextWebElement = userActions.findElement(new1TextElement);
				userActions.highlightElement(new1TextWebElement);

				WebElement new2TextWebElement = userActions.findElement(new2TextElement);
				userActions.highlightElement(new2TextWebElement);

				WebElement new3TextWebElement = userActions.findElement(new3TextElement);
				userActions.highlightElement(new3TextWebElement);

				WebElement old1TextWebElement = userActions.findElement(old1TextElement);
				userActions.highlightElement(old1TextWebElement);

				WebElement opdCounterTextWebElement = userActions.findElement(opdCounterTextElement);
				userActions.highlightElement(opdCounterTextWebElement);

				selectCounterPopUpIsPresent = true;
			}
			userActions.click(new1TextElement);
			Thread.sleep(2000);
		}catch(Exception e) {
			throw e;	
		}
		return selectCounterPopUpIsPresent;
	}

	/**@test3
	 * about this method performKeyBoardOperationToOpenAddNewPatientPopup() 
	 * @param : null
	 * @description : it will perfor Key board operation (Alt +N) to open the Add new patient page
	 * @return : String
	 * @author : Yaksha
	 */
	public String performKeyBoardOperationToOpenAddNewPatientPopup() throws Exception {
		String  addNewpatientPopUpTextValue = "";

		try {
			userActions.performAltN();
			WebElement addNewPatientTextWebElement = userActions.findElement(addNewPatientTextElement);
			userActions.highlightElement(addNewPatientTextWebElement);
			userActions.isDisplayed(addNewPatientTextElement);
			addNewpatientPopUpTextValue = userActions.getText(addNewPatientTextElement);
			System.out.println("text of the popup is : " + addNewpatientPopUpTextValue);	
			Thread.sleep(2000);
		}catch(Exception e) {
			throw e;	
		}
		return addNewpatientPopUpTextValue;
	}

	/**@Test4
	 * about this method fillTheTextFieldInAddNewPatientPopup() 
	 * @param : get the data from json file as type Map<String, String> expectedData
	 * @description : enter value in text field of Add New Patient as per json expected data and fetch the value of that text field ,
	 * @return : fetch the value text field as string type
	 * @author : Yaksha
	 */
	public String fillTheTextFieldInAddNewPatientPopup(Map<String, String> expectedData) throws Exception {
		String firstNameTextfieldValue = "";
		try {
			if(userActions.isDisplayed(firstNameTextFieldElement) && 
					userActions.isDisplayed(middleNameTextFieldElement) &&
					userActions.isDisplayed(lastNameTextfieldElement) &&
					userActions.isDisplayed(ageTextfieldElement) &&
					userActions.isDisplayed(contactNumberTextfieldElement))
			{
				userActions.sendKeys(firstNameTextFieldElement,expectedData.get("firstName"));
				userActions.sendKeys(middleNameTextFieldElement,expectedData.get("middleName"));
				userActions.sendKeys(lastNameTextfieldElement,expectedData.get("lastName"));
				userActions.sendKeys(ageTextfieldElement,expectedData.get("age"));
				userActions.sendKeys(contactNumberTextfieldElement,expectedData.get("contact"));

				firstNameTextfieldValue = userActions.getAttribute(firstNameTextFieldElement, "value");
				System.out.println("FirstName : " + firstNameTextfieldValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return firstNameTextfieldValue;
	}

	/**@Test5.1
	 * about this method verifyFirstNameIsPresent() 
	 * @param : null
	 * @description : it will fetch the data from the FirstName textfield
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyFirstNameIsPresent() throws Exception {
		String firstNameTextfieldValue = "";

		try {
			firstNameTextfieldValue = userActions.getAttribute(firstNameTextFieldElement, "value");
			System.out.println("FirstName : " + firstNameTextfieldValue);

		}catch(Exception e) {
			throw e;
		}
		return firstNameTextfieldValue;
	}

	/**@Test5.2
	 * about this method verifyMiddleNameIsPresent() 
	 * @param : null
	 * @description : it will fetch the data from the MiddleName Text field
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyMiddleNameIsPresent() throws Exception {

		String middleNameTextfieldValue = "";

		try {
			middleNameTextfieldValue = userActions.getAttribute(middleNameTextFieldElement, "value");
			System.out.println("middleName : " + middleNameTextfieldValue);

		}catch(Exception e) {
			throw e;
		}
		return middleNameTextfieldValue;
	}

	/**@Test5.3
	 * about this method verifyLastNameIsPresent() 
	 * @param : null
	 * @description : it will fetch the data from the LastName Text field
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyLastNameIsPresent() throws Exception {

		String lastNameTextfieldValue = "";

		try {

			lastNameTextfieldValue = userActions.getAttribute(lastNameTextfieldElement, "value");
			System.out.println("lastName : " + lastNameTextfieldValue);

		}catch(Exception e) {
			throw e;
		}
		return lastNameTextfieldValue;
	}

	/**@Test5.4
	 * about this method verifyAgeValueIsPresent() 
	 * @param : null
	 * @description : it will fetch the data from the age Text field
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyAgeValueIsPresent() throws Exception {

		String ageTextfieldValue = "";

		try {

			ageTextfieldValue = userActions.getAttribute(ageTextfieldElement, "value");
			System.out.println("age : " + ageTextfieldValue);

		}catch(Exception e) {
			throw e;
		}
		return ageTextfieldValue;
	}

	/**@Test5.5
	 * about this method verifyContactNumberIsPresent() 
	 * @param : null
	 * @description : it will fetch the data from the contact Text field
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyContactNumberIsPresent() throws Exception {

		String contactTextfieldValue = "";

		try {

			contactTextfieldValue = userActions.getAttribute(contactNumberTextfieldElement, "value");
			System.out.println("contact No. : " + contactTextfieldValue);

		}catch(Exception e) {
			throw e;
		}
		return contactTextfieldValue;
	}

	/**@Test6
	 * about this method verifyIndiaIsSelectedFromCountryDropdown() 
	 * @param : get the data from json file as type Map<String, String> expectedData
	 * @description : it will select the country as per json expected data
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyIndiaIsSelectedFromCountryDropdown(Map<String, String> expectedData) throws Exception {

		String selectedCountryName = "";

		try {
			userActions.selectByVisibleText(countryDropdownByElement, expectedData.get("selectedCountryName"));
			selectedCountryName = userActions.getFirstSelectedOptionFromDropdown(countryDropdownByElement, "elementName", "pageName");
			System.out.println("first selected option from country dropdown : " + selectedCountryName );

		}catch(Exception e) {
			throw e;
		}
		return selectedCountryName;
	}

	/**@test7
	 * about this method validateErrorMessageWhenClickOnRegisterBillingButton() 
	 * @param : null
	 * @description : it is getting the error message and validate the error message ,
	 * @return : errorMessage as string type
	 * @author : Yaksha
	 */
	public String validateErrorMessageWhenClickOnRegisterBillingButton() throws Exception {
		String errorMessageOfRegisterBilling="";

		try {
			userActions.click(registerAndBillingButtonElement);

			if(userActions.isDisplayed(errorMessageOfRegisterBillingByElement))
			{
				errorMessageOfRegisterBilling =  userActions.getText(errorMessageOfRegisterBillingByElement);
				System.out.println("Error Message when click on Register & Billing Button: " + errorMessageOfRegisterBilling);
			}
		}catch(Exception e) { 
			throw e;
		}
		return errorMessageOfRegisterBilling;
	}

	/**@test8
	 * about this method verifyDispensaryArrowIsExpanding() 
	 * @param : null
	 * @description : it is verify all fields is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyDispensaryArrowIsExpanding() throws Exception {
		Boolean dispensaryNavigationMenuIsExapanding=false;
		try {
			userActions.jsClick(dispensaryToggle);
			if(userActions.isDisplayed(prescriptionSubMenu)&&
					userActions.isDisplayed(saleSubMenu)&&
					userActions.isDisplayed(stockSubMenu)&&
					userActions.isDisplayed(counterSubMenu)&&
					userActions.isDisplayed(reportsSubMenu)&&
					userActions.isDisplayed(patientConsumptionSubMenu)) {

				dispensaryNavigationMenuIsExapanding = true;
			}	

		}catch(Exception e) {
			throw e;	
		}
		return dispensaryNavigationMenuIsExapanding;
	}

	/**@test9
	 * about this method verifyDispensaryArrowIsMinimizing() 
	 * @param : null
	 * @description : it is verify all fields is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyDispensaryArrowIsMinimizing() throws Exception {
		Boolean dispensaryNavigationMenuIsMinimizing = false;

		try {
			userActions.jsClick(dispensaryToggle);
			if(!(userActions.isDisplayed(prescriptionSubMenu)&& userActions.isDisplayed(saleSubMenu))) {

				dispensaryNavigationMenuIsMinimizing = true;
			}	

		}catch(Exception e) {
			throw e;	
		}
		return dispensaryNavigationMenuIsMinimizing;
	}

	/**@test10
	 * about this method verifyControlScrollingFromDispensaryToSettingModule() 
	 * @param : null
	 * @description : it is verify all fields is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyControlIsScrollingFromDispensaryToSettingModule() throws Exception {
		Boolean isScrolling = false;

		try {
			if(userActions.isDisplayed(dispensaryLeftNavigationMenu)) {

				WebElement dispensaryNavigationMenuWebElement = driver.findElement(dispensaryLeftNavigationMenu);
				userActions.highlightElementAfterAction(dispensaryNavigationMenuWebElement);
				userActions.jsScrollPageTillElementVisible(settingLeftNavigationMenu, "pageName", "pageName");

				isScrolling = true;
			}	

		}catch(Exception e) {
			throw e;	
		}
		return isScrolling;
	}
}
