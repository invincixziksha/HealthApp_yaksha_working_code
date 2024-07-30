package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class patient_Pages extends StartupPage {

	//Locators of L1 Scenarios
	//login locators
	By usernameTextfield = By.id("username_id");
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");

	By patientModuleByElement = By.xpath("//a[@href='#/Patient']");

	By patientModuleToggleIconByElement = By.xpath("//a[@href='#/Patient']//span[@data-target='#Patient']");
	By searchPatientSubModuleByElement = By.xpath("//a[@href='#/Patient/SearchPatient']//span[contains(text(), 'Search Patient')]");
	By registerPatientSubModuleByElement = By.xpath("//a[@href='#/Patient/RegisterPatient']//span[contains(text(), 'Register Patient')]");

	By searchPatientTextboxByElement = By.xpath("//input[@id='quickFilterInput']");

	By cameraIconByElement = By.xpath("//a[@title='Profile Picture']");
	By newPhotoButtonByElement = By.xpath("//button[@class='btn blue btn-sm']");
	By takeASnapShotButtonByElement = By.xpath("//button[@class='btn blue btn-sm']");
	By cancelButtonByElement = By.xpath("//button[contains(text(), 'Cancel')]");

	By basicInformationLinkByElement = By.xpath("//a[contains(text(), 'Basic Information')]");
	By regPatientSubmitButtonByElement = By.xpath("//input[@id='regPatientSubmitBtn']");
	By errorMessageOfPhoneNumberTextboxByElement = By.xpath("//span[contains(text(), 'Primary Phone is required')]");

	By firstNameTextboxByElement = By.xpath("//input[@id='regPatFirstName']");
	By middleNameTextboxByElement = By.xpath("//input[@placeholder='Middle Name']");
	By lastNameTextboxByElement = By.xpath("//input[@id='LastName']");
	By ageTextboxByElement = By.xpath("//input[@id='Age']");
	By phoneTextboxByElement = By.xpath("//input[@id='PhoneNumber']");

	// By bloodGroupDropdownByElement = By.xpath("//label[contains(text(), 'Blood group')]/..//select[@class='form-control ng-untouched ng-pristine ng-valid']");
	//	By bloodGroupDropdownByElement = By.xpath("//div[@class='col-md-8']//select[@class='form-control ng-valid ng-dirty ng-touched']");
	By bloodGroupDropdownByElement = By.xpath("//label[contains(text(), 'Blood group')]/..//select");

	By guarantorLinkByElement = By.xpath("//a[@href='#/Patient/RegisterPatient/Guarantor']");
	By maleRadioButtonByElement = By.xpath("//input[@value='Male']/..//span");
	By feMaleRadioButtonByElement = By.xpath("//input[@value='Female']/..//span");

	By selfCheckboxByElement = By.xpath("//input[@value='Self']/..//span");
	By notificationPopupMessageElement = By.xpath("//div[@class='msg-text padding-8-all']");
	By statusNotificationMessageByElement = By.xpath("//p[@class='msg-status']");
	By mainNotificationMessageByElement = By.xpath("//p[@class='main-message']");

	By kinEmergencyContactLinkByElement = By.xpath("//a[@href='#/Patient/RegisterPatient/KinEmergencyContact']");
	By commentsTextboxByElement = By.xpath("//input[@placeholder='comments']");

	By alexAlexaTextNameByElement = By.xpath("//div[contains(text(), '2311000001')]/..//div[contains(text(), 'Alexa Alexa')]");
	By printButtonByElement = By.xpath("//button[contains(text(), 'Print')]");
	By lastButtonByElement = By.xpath("//button[contains(text(), 'Last')]");

	By vaccinationModuleByElement = By.xpath("//a[@href='#/Vaccination']");
	By vaccinationModulesToggleIconByElement = By.xpath("//span[@data-target='#Vaccination']");
	By patientListSubModuleByElement = By.xpath("//a[@href='#/Vaccination/PatientList']//span[contains(text(), 'Patient List')]");
	By titleNameOfVaccinationPatientRegisterFormByElement = By.xpath("//span[contains(text(), 'Vaccination Patient Register')]");






	String pageName = this.getClass().getSimpleName();
	public patient_Pages(WebDriver driver) {
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
			//			commonEvents.setBrowserZoomLevelTo80Percent();
			commonEvents.waitTillElementLocated(usernameTextbox, 10);
			WebElement usernametextFieldWebElement = commonEvents.findElement(usernameTextbox);
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(usernameTextbox,expectedData.get("username"));

			commonEvents.waitTillElementLocated(passwordTextbox, 10);
			WebElement passwordtextFieldWebElement = commonEvents.findElement(passwordTextbox);
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));

			commonEvents.waitTillElementLocated(signInButton, 20);
			WebElement signinButtonWebElement = commonEvents.findElement(signInButton);
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.jsClick(signInButton);

			if(commonEvents.isDisplayed(patientModuleByElement))
			{   
				WebElement operationTheatreModuleWebElement = commonEvents.findElement(patientModuleByElement);
				commonEvents.highlightElement(operationTheatreModuleWebElement);
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
			Thread.sleep(5000);
			urlofThepage = commonEvents.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage );
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}

	/**@Test2
	 * about this method verifyAllPresenceOfFieldIfPatientModuleIsPresent() 
	 * @param : null
	 * @description : 
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyAllPresenceOfFieldIfPatientModuleIsPresent() throws Exception {
		Boolean allFieldsAreDisplayed = false;
		try {
			commonEvents.waitTillElementLocated(patientModuleByElement, 10);
			if(commonEvents.isDisplayed(patientModuleByElement)) {

				commonEvents.jsClick(patientModuleToggleIconByElement);

				if(commonEvents.isDisplayed(searchPatientSubModuleByElement) && 
						commonEvents.isDisplayed(registerPatientSubModuleByElement)) {

					System.out.println("all sub modules are present in patient module ");

					allFieldsAreDisplayed = true;
				}
			}
		}catch(Exception e) {
			throw e;
		}	
		return allFieldsAreDisplayed;
	}

	/**@Test3
	 * about this method verifyPlaceholderNameOfTexbox() 
	 * @param : null
	 * @description : verify the placeholder name of text box 
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyPlaceholderNameOfTexbox() throws Exception {
		String placeholderNameOfTextbox = "";
		try {
			commonEvents.jsClick(searchPatientSubModuleByElement);

			commonEvents.waitTillElementLocated(searchPatientTextboxByElement, 10);
			if(commonEvents.isDisplayed(searchPatientTextboxByElement)) {

				commonEvents.click(searchPatientTextboxByElement);
				placeholderNameOfTextbox = commonEvents.getAttribute(searchPatientTextboxByElement, "placeholder");
				System.out.println("place holder name of search patient Textbox : " + placeholderNameOfTextbox );

				return placeholderNameOfTextbox;
			}
		}catch(Exception e) {
			throw e;
		}	
		return placeholderNameOfTextbox;
	}

	/**@Test4
	 * about this method verifyButtonIsPresent() 
	 * @param : null
	 * @description : 
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyButtonIsPresent() throws Exception {
		Boolean buttonIsDisplayed = false;
		try {

			commonEvents.waitTillElementLocated(registerPatientSubModuleByElement, 10);

			if(commonEvents.isDisplayed(registerPatientSubModuleByElement)) {

				commonEvents.jsClick(registerPatientSubModuleByElement);

				commonEvents.waitTillElementLocated(cameraIconByElement, 10);
				commonEvents.jsClick(cameraIconByElement);

				if(commonEvents.isDisplayed(newPhotoButtonByElement)) {

					commonEvents.jsClick(newPhotoButtonByElement);
					Thread.sleep(3000);

					commonEvents.waitTillElementLocated(takeASnapShotButtonByElement, 10);
					WebElement highLighttakeASnapShotButtonWebelement = commonEvents.findElement(takeASnapShotButtonByElement);
					commonEvents.highlight(highLighttakeASnapShotButtonWebelement);

					commonEvents.waitTillElementLocated(cancelButtonByElement, 10);
					commonEvents.click(cancelButtonByElement);

					buttonIsDisplayed = true;
				}
			}
		}catch(Exception e) {
			throw e;
		}	
		return buttonIsDisplayed;
	}

	/**@Test5
	 * about this method verifyErrorMessage() 
	 * @param : null
	 * @description : verify the error message
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyErrorMessage() throws Exception {
		String errorMessage = "";
		try {
			Thread.sleep(5000);
			commonEvents.waitTillElementLocated(basicInformationLinkByElement, 10);
			if(commonEvents.isDisplayed(basicInformationLinkByElement)) {
				commonEvents.click(basicInformationLinkByElement);

				commonEvents.waitTillElementLocated(regPatientSubmitButtonByElement, 10);
				commonEvents.click(regPatientSubmitButtonByElement);

				commonEvents.waitTillElementLocated(errorMessageOfPhoneNumberTextboxByElement, 10);
				commonEvents.isDisplayed(errorMessageOfPhoneNumberTextboxByElement);
				errorMessage = commonEvents.getText(errorMessageOfPhoneNumberTextboxByElement);
				System.out.println("error Message of Phone Number textbox : " + errorMessage );

				return errorMessage;
			}
		}catch(Exception e) {
			throw e;
		}
		return errorMessage;
	}


	/**@Test6
	 * about this method verifyTexboxIsPresentAndValidateEnteredValue() 
	 * @param : null
	 * @description : verify text box , then send value to that text box and validate the entered value
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTexboxIsPresentAndValidateEnteredValue(Map<String, String> expectedData) throws Exception {

		String firstNameTextboxValue = "";
		try {

			commonEvents.waitTillElementLocated(basicInformationLinkByElement, 10);
			if(commonEvents.isDisplayed(basicInformationLinkByElement)) {

				commonEvents.waitTillElementLocated(firstNameTextboxByElement, 10);
				commonEvents.sendKeys(firstNameTextboxByElement, expectedData.get("firstNameValue"));

				commonEvents.waitTillElementLocated(middleNameTextboxByElement, 10);
				commonEvents.sendKeys(middleNameTextboxByElement, expectedData.get("middleNameValue"));

				commonEvents.waitTillElementLocated(lastNameTextboxByElement, 10);
				commonEvents.sendKeys(lastNameTextboxByElement, expectedData.get("lastNameValue"));

				commonEvents.waitTillElementLocated(ageTextboxByElement, 10);
				commonEvents.sendKeys(ageTextboxByElement, expectedData.get("AgeValue"));

				commonEvents.waitTillElementLocated(phoneTextboxByElement, 10);
				commonEvents.sendKeys(phoneTextboxByElement, expectedData.get("phoneNumberValue"));

				firstNameTextboxValue = commonEvents.getAttribute(firstNameTextboxByElement, "value");
				System.out.println("attribute value of first Name Textbox : " + firstNameTextboxValue );
				return firstNameTextboxValue;
			}
		}catch(Exception e) {
			throw e;
		}	
		return firstNameTextboxValue;
	}

	/**@Test7
	 * about this method scrollToBottomAndVerifyFieldIsPresent() 
	 * @param : null
	 * @description : 
	 * @return : String
	 * @author : YAKSHA
	 */
	public Boolean scrollToBottomAndVerifyFieldIsPresent() throws Exception {
		Boolean bloodGroupDropdownIsDisplayed = false;
		try {
			commonEvents.waitTillElementLocated(basicInformationLinkByElement, 10);
			commonEvents.jsScrollToBottomOfThePage();

			commonEvents.waitTillElementLocated(bloodGroupDropdownByElement, 10);
			if(commonEvents.isDisplayed(bloodGroupDropdownByElement)){

				System.out.println("blood group dropdown is present");

				bloodGroupDropdownIsDisplayed = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return bloodGroupDropdownIsDisplayed;
	}

	/**@Test8
	 * about this method scrollToBottomVerifyFieldAndHighlight() 
	 * @param : null
	 * @description : 
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean highlightTheElement() throws Exception {
		Boolean textboxIsDisplayed = false;
		try {

			commonEvents.waitTillElementLocated(bloodGroupDropdownByElement, 10);
			if(commonEvents.isDisplayed(bloodGroupDropdownByElement)){

				WebElement bloodGroupDropdownWebElement = commonEvents.findElement(bloodGroupDropdownByElement);
				commonEvents.highlight(bloodGroupDropdownWebElement);

				textboxIsDisplayed = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return textboxIsDisplayed;
	}

	/**@Test9
	 * about this method verifyOptionIsSelectedFromDropdown() 
	 * @param : get the data from JSON file as type Map<String, String> expectedData
	 * @description : it will select the option as per JSON expected data
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyOptionIsSelectedFromDropdown(Map<String, String> expectedData) throws Exception {

		String selectedOption = "" ;

		try {
			commonEvents.waitTillElementLocated(bloodGroupDropdownByElement, 10);
			commonEvents.selectByVisibleText(bloodGroupDropdownByElement, expectedData.get("bloodGroup"));
			selectedOption = commonEvents.getFirstSelectedOptionFromDropdown(bloodGroupDropdownByElement, "", "");
			System.out.println("first selected option from bloodGroup drop down : " + selectedOption );
			
			// selectedOption = commonEvents.getText(bloodGroupDropdownByElement);
			// System.out.println("first selected option from bloodGroup drop down : " + selectedOption );
			// selectedOption = commonEvents.getAttribute(bloodGroupDropdownByElement, "value");
			// System.out.println("first selected option from bloodGroup drop down : " + selectedOption );
			
			return selectedOption;
		}catch(Exception e) {
			throw e;
		}

	}

	/**@Test10
	 * about this method verifyRadioButton() 
	 * @param : null
	 * @description :
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyRadioButton() throws Exception {
		Boolean verifyRadioButton = false;
		try {

			commonEvents.waitTillElementLocated(guarantorLinkByElement, 10);
			if(commonEvents.isDisplayed(guarantorLinkByElement)) {
				commonEvents.jsClick(guarantorLinkByElement);

				//verify radio button is selected
				commonEvents.waitTillElementLocated(maleRadioButtonByElement, 10);

				if(commonEvents.isDisplayed(maleRadioButtonByElement)) {
					commonEvents.jsClick(maleRadioButtonByElement);
					commonEvents.isSelected(maleRadioButtonByElement);
					System.out.println("Male Radio button is selected");

					if(commonEvents.isDisplayed(feMaleRadioButtonByElement)) {
						commonEvents.jsClick(feMaleRadioButtonByElement);
						if(!commonEvents.isSelected(maleRadioButtonByElement)) {
							System.out.println("Male Radio button is De-Selected");
							verifyRadioButton = true;
						}
					}
				}
			}
		}catch(Exception e) {
			throw e;
		}	
		return verifyRadioButton;
	}

	/**@Test11
	 * about this method verifyNotificationPopupMessageIfCheckboxIsSelected() 
	 * @param : null
	 * @description : verify the error message using hard assert
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyNotificationPopupMessageIfCheckboxIsSelected() throws Exception {
		String actualNotificationPopupMessageValue = "";
		int maxRetries = 3; // Number of retries
		int attempts = 0; // Attempt counter

		while (attempts < maxRetries) {
			try {
				Thread.sleep(8000);
				commonEvents.waitTillElementLocated(selfCheckboxByElement, 10);
				commonEvents.isDisplayed(selfCheckboxByElement);
				commonEvents.click(selfCheckboxByElement);
				commonEvents.isSelected(selfCheckboxByElement);
				System.out.println("Self Checkbox is selected");

				commonEvents.waitTillElementLocated(notificationPopupMessageElement, 10);
				commonEvents.isDisplayed(notificationPopupMessageElement);

				String actualNotificationMessage = commonEvents.getText(notificationPopupMessageElement);
				System.out.println("notification popup message text Value : " + actualNotificationMessage );

				String statusNotificationMessage = commonEvents.getText(statusNotificationMessageByElement);
				System.out.println("status notification Message :  " + statusNotificationMessage);

				String mainNotificationMessage = commonEvents.getText(mainNotificationMessageByElement);
				System.out.println("main notification Message :  " + mainNotificationMessage);

				actualNotificationPopupMessageValue = statusNotificationMessage + " " + mainNotificationMessage;
				System.out.println("main notification popup message text Value : " + actualNotificationPopupMessageValue);

				return actualNotificationPopupMessageValue;
			} catch (org.openqa.selenium.StaleElementReferenceException e) {
				attempts++;
				if (attempts == maxRetries) {
					throw e; // Rethrow the exception after maximum retries
				}
				System.out.println("StaleElementReferenceException encountered. Retrying... Attempt: " + attempts);
			} catch (Exception e) {
				throw e; // Rethrow any other exceptions
			}
		}
		throw new Exception("Failed to verify notification popup message after " + maxRetries + " attempts.");
	}

	/**@Test12
	 * about this method performJavaScriptOperation() 
	 * @param : null
	 * @description : 
	 * @return : String
	 * @author : YAKSHA
	 */
	public String performJavaScriptOperation(Map<String, String> expectedData) throws Exception {

		String javaScriptExecutorValue = "";
		try {
			Thread.sleep(5000);
			commonEvents.waitTillElementLocated(kinEmergencyContactLinkByElement, 10);
			if(commonEvents.isDisplayed(kinEmergencyContactLinkByElement)) {

				commonEvents.jsClick(kinEmergencyContactLinkByElement);

				commonEvents.waitTillElementLocated(commentsTextboxByElement, 10);
				commonEvents.jsClick(commentsTextboxByElement);
				commonEvents.jsSendKeys(commentsTextboxByElement, expectedData.get("comments"));

				if(commonEvents.isDisplayed(commentsTextboxByElement)) {

					javaScriptExecutorValue = commonEvents.getAttribute(commentsTextboxByElement, "value");
					System.out.println("value of comments Textbox : " + javaScriptExecutorValue);
					System.out.println("successfully executed by javaScriptExecutor");
					Thread.sleep(3000);
					return javaScriptExecutorValue;
				}
			}
		}catch(Exception e) {
			throw e;
		}	
		return javaScriptExecutorValue;
	}

	/**@Test13
	 * about this method verifyTextIsPresentUsingHardAssert() 
	 * @param : null
	 * @description : 
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTextIsPresentUsingHardAssert(Map<String, String> expectedData) throws Exception {

		String linkTextValue = "";
		try {
			commonEvents.waitTillElementLocated(kinEmergencyContactLinkByElement, 10);
			commonEvents.click(kinEmergencyContactLinkByElement);
			linkTextValue = commonEvents.getText(kinEmergencyContactLinkByElement);
			System.out.println("Link text value of kin Emergency Contact Link : " + linkTextValue);

			return linkTextValue;
		}catch(Exception e) {
			throw e;
		}	
	}

	/**@Test14
	 * about this method getDataFromTable() 
	 * @param : null
	 * @description : it will fetch the data from the table
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public String getDataFromTable() throws Exception {
		String firstPatientNameTextValue = "";

		Thread.sleep(5000);
		try {
			commonEvents.waitTillElementLocated(searchPatientSubModuleByElement, 10);
			if(commonEvents.isDisplayed(searchPatientSubModuleByElement)) {
				commonEvents.jsClick(searchPatientSubModuleByElement);

				//				commonEvents.refreshPage();
				commonEvents.waitTillElementLocated(printButtonByElement, 10);
				if(commonEvents.isDisplayed(printButtonByElement)) {
					commonEvents.jsScrollPageTillElementVisible(lastButtonByElement, "searchPatientPage", "lastButton");
					commonEvents.click(lastButtonByElement);

					WebElement alexaAlexText = commonEvents.findElement(alexAlexaTextNameByElement);
					commonEvents.highlight(alexaAlexText);

					commonEvents.waitTillElementLocated(alexAlexaTextNameByElement, 10);
					firstPatientNameTextValue = commonEvents.getText(alexAlexaTextNameByElement);
					System.out.println("first patient name of given code 2311000001: " + firstPatientNameTextValue);
					return firstPatientNameTextValue;
				}
			}
		}catch(Exception e) {
			throw e;
		}	
		return firstPatientNameTextValue;
	}

	/**@Test15
	 * about this method performKeyboardOperation() 
	 * @param : 
	 * @description : perform the keyboard operation
	 * @return : String
	 * @author : YAKSHA
	 */
	public String performKeyboardOperation() throws Exception {
		String titleNameOfVaccinationPatientRegisterForm = "";
		try {
			Thread.sleep(2000);
			commonEvents.jsScrollPageTillElementVisible(vaccinationModuleByElement, "vaccinationModule", "vaccinationModule");
			if (commonEvents.isDisplayed(vaccinationModuleByElement)) {
				Thread.sleep(2000);
				commonEvents.jsClick(vaccinationModulesToggleIconByElement);
				Thread.sleep(2000);
				commonEvents.jsClick(patientListSubModuleByElement);
				Thread.sleep(5000);
				commonEvents.performAltN();
				Thread.sleep(2000);

				titleNameOfVaccinationPatientRegisterForm = commonEvents.getText(titleNameOfVaccinationPatientRegisterFormByElement);
				System.out.println("title Name Of Vaccination Patient Register form : " + titleNameOfVaccinationPatientRegisterForm);
				return titleNameOfVaccinationPatientRegisterForm;
			}
		}catch(Exception e) {
			throw e;
		}
		return titleNameOfVaccinationPatientRegisterForm;
	}
}
