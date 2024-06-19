package testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.StartupPage;

public class LocatorsFactory extends StartupPage {

	 

	// element of health application

	By totalDoctortextElement = By.xpath("//p[contains(text(), 'Total Doctors')]");
	By selectCounterPopupElement = By.xpath("//h3//span[contains(text(), 'Select Counter')]");
	By new1TextElement = By.xpath("//h5[contains(text(), 'New-1')]");
	By new2TextElement = By.xpath("//h5[contains(text(), 'New-2')]");
	By new3TextElement = By.xpath("//h5[contains(text(), 'New-3')]");
	By old1TextElement = By.xpath("//h5[contains(text(), 'Old-1')]"); 
	By opdCounterTextElement = By.xpath("//h5[contains(text(), 'OPD-Counter')]");

	By addNewPatientButtonElement = By.xpath("//button[contains(text(), 'Add New Patient')]");
	By registerAndBillingButtonElement = By.xpath("//button[contains(text(), 'Register & Billing')]");
	By registerOnlyButtonElement = By.xpath("//button[contains(text(), 'Register Only')]");
	By registerOnlyButtonToHighlight = By.xpath("(//button[@class=\"btn green btn-success margin-7-hr\"])[2]");
	By firstNameTextFieldElement = By.xpath("//input[@id='newPatFirstName']");
	By countryDropdownByElement = By.xpath("//select[@id='ddlCountry']");
	By errorMessageOfRegisterBillingByElement = By.xpath("//p[contains(text(), 'Some of the inputs are invalid. Please check and try again. !')]");
	By closeButtonOfAddNewpatientpage = By.xpath("//button[contains(text(), 'Close')]");

	By errorMessageCloseButton = By.xpath("//a[@class='close-btn']//i[@class='fa fa-times-circle']");
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
	By printInvoiceButtonElement = By.xpath("//input[@value='Print Invoice']");

	//l2 locators

	By checkBox=By.xpath("(//label[@class='mt-checkbox mt-checkbox-outline'])[1]//span");
	By addNewButtonElement = By.xpath("//button[contains(text(), 'Add New Patient')]");
	By headerNotificationBar = By.id("header_notification_bar");
	By admittingDocField = By.xpath("//b[.='Admitting Doc:']");
	By newItemButton = By.xpath("//button[.=' New Item ']");
	By myFavoritesButton = By.xpath("//a[.=' My Favorites']");
	By manageRoleTab = By.xpath("//a[.='Manage Role']");
	By tooltipText = By.xpath("//li[contains(text(),'+')]");

    //Dispensary module locators
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");
	By morningCounter = By.xpath("(//div[@class='counter-item'])[1]");
	By activeDispensaryField = By.xpath("//label[@class='label label-primary']");
	By searchPatientTextField = By.id("patient-search");
	By firstNameField = By.id("newPatFirstName");
	By errorMeesageInLastNameTextField = By.xpath("//span[.=' Last Name is required.']");
    By totalStockValueText = By.xpath("//div[@class='right']");
	By creditLimitsAndBalancesTextElement = By.xpath("//b[contains(text() , 'Credit Limits and Balances')]");
	By ContactNumberTextFieldInAddNewPatient = By.id("Contact");
	By firstNameTextFieldInAddNewPatient = By.id("newPatFirstName");
	By mainStoreOption = By.xpath("//option[.='Main store']");	
	By createRequisitionsButtonElement = By.xpath("//button[@class='btn btn-primary']");
	By  createRequisitionButton = By.xpath("//button[@class='btn btn-primary']");
	By  addRequisitionText = By.xpath("//span[.='Add Requisition']");
	By remarksTextField = By.id("remark0");	
	By quantityTextField = By.xpath("//table//tr[@style='text-align:center']//td[.='1']");
	By denphehLogo=By.xpath("//div[@class='logo']");
	By dispatchedQtyField=By.xpath("//table//tr//td[.='Dispatched Qty']");
	By raceField = By.id("race");	
	By listByPatientStatusRadioButton = By.xpath("//input[@type='radio']");	

	public LocatorsFactory(WebDriver driver) {
		super(driver);

	}


	public WebElement totalDoctorTextIsPresent(WebDriver driver) {
		WebElement totalDoctorTextWebElement = driver.findElement(totalDoctortextElement);
		commonEvents.highlightElement(totalDoctorTextWebElement);
		return totalDoctorTextWebElement; 
	}

	public Boolean verifyAllFieldIsPresent() throws Exception {
		Boolean allFieldIsPresent = false;
		try {
			if(commonEvents.isDisplayed(selectCounterPopupElement)&&
					commonEvents.isDisplayed(new1TextElement)&&
					commonEvents.isDisplayed(new2TextElement)&&
					commonEvents.isDisplayed(new3TextElement)&&
					commonEvents.isDisplayed(old1TextElement)&&
					commonEvents.isDisplayed(opdCounterTextElement)) {

				allFieldIsPresent = true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return allFieldIsPresent;
	}

	public WebElement addNewButtonIsPresent(WebDriver driver) {
		WebElement addNewPatientButtonWebElement = driver.findElement(addNewPatientButtonElement);
		commonEvents.highlightElementAfterAction(addNewPatientButtonWebElement);
		return addNewPatientButtonWebElement; 
	}

	public WebElement registerAndBillingButtonIsPresent(WebDriver driver) {
		WebElement registerAndBillingButtonWebElement = driver.findElement(registerAndBillingButtonElement);
		return registerAndBillingButtonWebElement; 
	}

	public String verifyFirstNameTextValueIsPresent() throws Exception {
		String firstNameTextfieldValue = "";
		try {
			if(commonEvents.isDisplayed(firstNameTextFieldElement))
			{
				firstNameTextfieldValue = commonEvents.getAttribute(firstNameTextFieldElement, "value");
				System.out.println("firstName Text value is  : " + firstNameTextfieldValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return firstNameTextfieldValue;
	}

	public String verifyRegisterOnlyButtonIsPresent() throws Exception {
		String registerOnlyButtonIsPresent = "";
		try {
			if(commonEvents.isDisplayed(registerOnlyButtonElement))
			{
				registerOnlyButtonIsPresent = commonEvents.getText(registerOnlyButtonElement);
				System.out.println("text value of register Only Button : " + registerOnlyButtonIsPresent);
				WebElement registerOnlyButtonWebElement = commonEvents.findElement(registerOnlyButtonToHighlight);
				commonEvents.highlightElementAfterAction(registerOnlyButtonWebElement);
			}
		}catch(Exception e) {
			throw e;
		}
		return registerOnlyButtonIsPresent;
	}

	public String verifyIndiaIsPresent() throws Exception {
		String selectedCountryValue = "";
		try {
			if(commonEvents.isDisplayed(countryDropdownByElement))
			{
				selectedCountryValue = commonEvents.getFirstSelectedOptionFromDropdown(countryDropdownByElement, "elementName", "pageName");
				System.out.println("selected dropdown value is  : " + selectedCountryValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return selectedCountryValue;
	}


	public String verifyErrorMessageIsPresent() throws Exception {
		String errorMessageValue = "";
		try {
			if(commonEvents.isDisplayed(errorMessageOfRegisterBillingByElement))
			{
				errorMessageValue =  commonEvents.getText(errorMessageOfRegisterBillingByElement);
				System.out.println("error message validation by Locators factory class : " + errorMessageValue);
				commonEvents.jsClick(errorMessageCloseButton);
				commonEvents.jsClick(closeButtonOfAddNewpatientpage);
			}
		}catch(Exception e) {
			throw e;
		}
		return errorMessageValue;
	}

	public Boolean highLightPresenceOfAllFieldInDispensaryMenu() throws Exception {
		Boolean highlightPresenceOfElement=false;
		try {
			if(commonEvents.isDisplayed(prescriptionSubMenu)&&
					commonEvents.isDisplayed(saleSubMenu)&&
					commonEvents.isDisplayed(stockSubMenu)&&
					commonEvents.isDisplayed(counterSubMenu)&&
					commonEvents.isDisplayed(reportsSubMenu)&&
					commonEvents.isDisplayed(patientConsumptionSubMenu)) {

				WebElement prescriptionSubMenuWebElement = driver.findElement(prescriptionSubMenu);
				commonEvents.highlightElementAfterAction(prescriptionSubMenuWebElement);
				WebElement saleSubMenuWebElement = driver.findElement(saleSubMenu);
				commonEvents.highlightElementAfterAction(saleSubMenuWebElement);
				WebElement stockSubMenuWebElement = driver.findElement(stockSubMenu);
				commonEvents.highlightElementAfterAction(stockSubMenuWebElement);
				WebElement counterSubMenuWebElement = driver.findElement(counterSubMenu);
				commonEvents.highlightElementAfterAction(counterSubMenuWebElement);
				WebElement reportsSubMenuWebElement = driver.findElement(reportsSubMenu);
				commonEvents.highlightElementAfterAction(reportsSubMenuWebElement);
				WebElement patientConsumptionSubMenuWebElement = driver.findElement(patientConsumptionSubMenu);
				commonEvents.highlightElementAfterAction(patientConsumptionSubMenuWebElement);

				highlightPresenceOfElement= true;
			}	

		}catch(Exception e) {
			throw e;	
		}
		return highlightPresenceOfElement;
	}
	
	public Boolean verifyFieldIsNotPresentInDispensaryMenu() throws Exception {
		Boolean highlightDispensaryNavigationMenu=false;
		try {
			if(!(commonEvents.isDisplayed(prescriptionSubMenu)&&
					commonEvents.isDisplayed(saleSubMenu))) {

				WebElement dispensaryNavigationMenuWebElement = driver.findElement(dispensaryLeftNavigationMenu);
				commonEvents.highlightElementAfterAction(dispensaryNavigationMenuWebElement);

				highlightDispensaryNavigationMenu = true;
			}	

		}catch(Exception e) {
			throw e;	
		}
		return highlightDispensaryNavigationMenu;
	}
	
	public Boolean settingModuleIsPresent() throws Exception {
		Boolean settingModuleIsPresent = false;
		try {
			if(commonEvents.isDisplayed(settingLeftNavigationMenu)) {
				
				WebElement settingLeftNavigationMenuWebElement = driver.findElement(settingLeftNavigationMenu);
				commonEvents.highlightElementAfterAction(settingLeftNavigationMenuWebElement);
				
				settingModuleIsPresent = true;
			}	
			
		}catch(Exception e) {
			throw e;	
		}
		return settingModuleIsPresent;
	}

	// l2 scenarios

	public WebElement headerNotificationBarIsPresent(WebDriver driver) {
		WebElement headerNotificationBarWebElement = driver.findElement(headerNotificationBar);
		return headerNotificationBarWebElement; 
	}

	public WebElement admittingDocFieldIsPresent(WebDriver driver) {
		WebElement admittingDocFieldWebElement = driver.findElement(admittingDocField);
		return admittingDocFieldWebElement; 
	}

	public WebElement checkBoxIsPresent(WebDriver driver) {
		WebElement checkBoxWebElement = driver.findElement(checkBox);
		return checkBoxWebElement; 
	}

	public WebElement newItemButtonPresent(WebDriver driver) {
		WebElement newItemButtonWebElement = driver.findElement(newItemButton);
		return newItemButtonWebElement; 
	}

	public WebElement myFavoritesButtonIsPresent(WebDriver driver) {
		WebElement myFavoritesButtonWebElement = driver.findElement(myFavoritesButton);
		return myFavoritesButtonWebElement; 
	}

	public WebElement manageRoleTabIsPresent(WebDriver driver) {
		WebElement manageRoleTabWebElement = driver.findElement(manageRoleTab);
		return manageRoleTabWebElement; 
	}
	
	public WebElement newItemButtonIsPresent(WebDriver driver) {
		WebElement newItemButtonWebElement = driver.findElement(newItemButton);
		return newItemButtonWebElement;
	}
	
	public WebElement tooltipTextIsPresent(WebDriver driver) {
		WebElement tooltipTextWebElement = driver.findElement(tooltipText);
		return tooltipTextWebElement;
	}
	
	//Dispensary module 
	
	public WebElement registeredPatientTextElementIsPresent(WebDriver driver) {
		WebElement registeredPatientTextElementWebElement = driver.findElement(registeredPatientTextElement);
		return registeredPatientTextElementWebElement;
	}
	
	public WebElement morningCounterIsPresent(WebDriver driver) {
		WebElement morningCounterWebElement = driver.findElement(morningCounter);
		return morningCounterWebElement;
	}
	
	public WebElement activeDispensaryFieldIsPresent(WebDriver driver) {
		WebElement activeDispensaryFiledWebElement = driver.findElement(activeDispensaryField);
		return activeDispensaryFiledWebElement;
	}
	
	public WebElement searchPatientTextFieldIsPresent(WebDriver driver) {
		WebElement searchPatientTextFieldWebElement = driver.findElement(searchPatientTextField);
		return searchPatientTextFieldWebElement;
	}
	
	
	public WebElement firstNameFieldIsPresent(WebDriver driver) {
		WebElement firstNameFieldWebElement = driver.findElement(firstNameField);
		return firstNameFieldWebElement;
	}
	
	public WebElement errorMeesageInLastNameTextFieldErrorMessageIsPresent(WebDriver driver) {
		WebElement errorMeesageInLastNameTextFieldWebElement = driver.findElement(errorMeesageInLastNameTextField);
		return errorMeesageInLastNameTextFieldWebElement;
	}
	
	public String ContactNumberTextFieldIsPresent() throws Exception {
		String ContactNumberTextFieldValue = "";
		try {
			if(commonEvents.isDisplayed(firstNameTextFieldElement))
			{
				ContactNumberTextFieldValue = commonEvents.getAttribute(ContactNumberTextFieldInAddNewPatient, "value");
				System.out.println("Contact Number TextField Value  : " + ContactNumberTextFieldValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return ContactNumberTextFieldValue;
	}
	
	
	public String firstNameTextFieldInAddNewPatientIsPresent() throws Exception {
		String firstNameTextFieldValue = "";
		try {
			if(commonEvents.isDisplayed(firstNameTextFieldElement))
			{
				firstNameTextFieldValue = commonEvents.getAttribute(firstNameTextFieldInAddNewPatient, "value");
				System.out.println("firstName TextField Value  : " + firstNameTextFieldValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return firstNameTextFieldValue;
	}
	
	
	public WebElement totalStockValueTextIsPresent(WebDriver driver) {
		WebElement totalStockValueTextWebElement = driver.findElement(totalStockValueText);
		return totalStockValueTextWebElement;
	}
	
	
	public WebElement creditLimitsAndBalancesTextElementIsPresent(WebDriver driver) {
		WebElement creditLimitsAndBalancesTextElementWebElement = driver.findElement(creditLimitsAndBalancesTextElement);
		return creditLimitsAndBalancesTextElementWebElement;
	}
	
	public String createRequisitionsButtonIsPresent() throws Exception {
		String createRequisitionsButtonValue = "";
		try {
			if(commonEvents.isDisplayed(createRequisitionsButtonElement))
			{
				createRequisitionsButtonValue = commonEvents.getText(createRequisitionsButtonElement);
				System.out.println("create Requisitions Button Value  : " + createRequisitionsButtonValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return createRequisitionsButtonValue;
	}
	
	
	public WebElement printInvoiceButtonElementIsPresent(WebDriver driver) {
		WebElement printInvoiceButtonElementWebElement = driver.findElement(printInvoiceButtonElement);
		return printInvoiceButtonElementWebElement;
	}
	
	
	public WebElement mainStoreOptionIsSelected(WebDriver driver) {
		WebElement mainStoreOptionWebElement = driver.findElement(mainStoreOption);
		return mainStoreOptionWebElement;
	}
	
	public WebElement createRequisitionButtonIsPresent(WebDriver driver) {
		WebElement createRequisitionButtonWebElement = driver.findElement(createRequisitionButton);
		return createRequisitionButtonWebElement;
	}
	
	public WebElement addRequisitionTextIsPresent(WebDriver driver) {
		WebElement addRequisitionTextWebElement = driver.findElement(addRequisitionText);
		return addRequisitionTextWebElement;
	}
	
	
	public WebElement remarksTextFieldIsPresent(WebDriver driver) {
		WebElement remarksTextFieldWebElement = driver.findElement(remarksTextField);
		return remarksTextFieldWebElement;
	}
	
	
	public WebElement denphehLogoIsPresent(WebDriver driver) {
		WebElement denphehLogoWebElement = driver.findElement(denphehLogo);
		return denphehLogoWebElement;
	}
	
	public WebElement dispatchedQtyFieldIsPresent(WebDriver driver) {
		WebElement dispatchedQtyFieldWebElement = driver.findElement(dispatchedQtyField);
		return dispatchedQtyFieldWebElement;
	}
	
	public String raceTextFieldPlaceHolderIsPresent() throws Exception {
		String raceTextFieldPlaceHolder = "";
		try {
			if(commonEvents.isDisplayed(raceField))
			{
				Thread.sleep(3000);
				raceTextFieldPlaceHolder = commonEvents.getAttribute(raceField, "placeholder");
				System.out.println("Race TextField place holder Value  : " + raceTextFieldPlaceHolder);
			}
		}catch(Exception e) {
			throw e;
		}
		return raceTextFieldPlaceHolder;
	}
	
	public WebElement listByPatientStatusRadioButtonIsPresent(WebDriver driver) {
		WebElement listByPatientStatusRadioButtonWebElement = driver.findElement(listByPatientStatusRadioButton);
		return listByPatientStatusRadioButtonWebElement;
	}
}
