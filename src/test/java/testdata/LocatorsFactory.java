package testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.StartupPage;

public class LocatorsFactory extends StartupPage {
	//please write all the locators for Money Control page only 

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




	//l2 locators
	By headerNotificationBar=By.id("header_notification_bar");
	By admittingDocField=By.xpath("//b[.='Admitting Doc:']");
	By checkBox=By.xpath("(//label[@class='mt-checkbox mt-checkbox-outline'])[1]//span");


	public LocatorsFactory(WebDriver driver) {
		super(driver);

	}



	//Expected data will be fetch from config.json file,path of the json file is:FaceBook_Automation_Dummy/src/main/resources/config.json

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
				Thread.sleep(2000);	
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
				Thread.sleep(3000);	
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
				Thread.sleep(2000);	
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
				commonEvents.jsClick(countryDropdownByElement);
			}
		}catch(Exception e) {
			throw e;
		}
		return errorMessageValue;
		
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
}
