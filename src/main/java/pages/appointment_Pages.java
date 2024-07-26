package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class appointment_Pages extends StartupPage {

	//Locators of L1 Scenarios
	//login locators
	By usernameTextfield = By.id("username_id");
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");

	//Appoint Module's locators 
	By appointmentModuleByElement = By.xpath("//a[@href='#/Appointment']");
	By appointmentModuleToggleByElement = By.xpath("//span[@data-target='#Appointment']");
	By selectCounterTitleNameByElement = By.xpath("//span[contains(text(), 'Select Counter')]");

	By selectCounterNewOneLinkByElement = By.xpath("//div[@class='counter-item']//h5[contains(text(), 'New-1')]");
	By newPatientButtonLinkByElement = By.xpath("//button[@id='btnNewPatient']");
	By patientInformationTextByElement = By.xpath("//h4[contains(text(), 'Patient Information')]");
	By careOfPersonContactTextboxByElement = By.xpath("//input[@id='id_CareTaker_CareTakerContact']");
	By careOfPersonTextboxByElement = By.xpath("//input[@id='id_CareTaker_CareTakerName']");
	By printInvoiceButtonByElement = By.xpath("//input[@id='btnPrintInvoice']");
	By confirmButtonByElement = By.xpath("//button[@id='id_btn_confirm_confirmation']");
	By errorMessageOfLastNameTextboxByElement = By.xpath("//span[contains(text(), ' Last Name is required.')]");

	By firstNameTextboxByElement = By.xpath("//input[@id='aptPatFirstName']");
	By middleNameTextboxByElement = By.xpath("//input[@formcontrolname='MiddleName']");
	By lastNameTextboxByElement = By.xpath("//input[@formcontrolname='LastName']");
	By ageTextboxByElement = By.xpath("//input[@id='txtAgeInput']");
	By phoneTextboxByElement = By.xpath("//input[@id='txtPhone']");

	By havDOBCheckboxByElement = By.xpath("//input[@name='IsDobAvailable']/..//span");
	By dobDatePickerByElement = By.xpath("//input[@id='date']");

	By externalCheckBoxByElement = By.xpath("//input[@id='id_checkbox_includeExternalReferral']/..//span");
	By plusIconClickToAddExternalReffererByElement = By.xpath("//a[@title='Click to add new external refferer']");
	By addExternalReferralTitleByElement = By.xpath("//span[contains(text(), 'Add External Referral')]");
	By referrerNameTexboxByElement = By.xpath("//input[@id='referrerName']");
	By extRefferAddressTextFieldElement = By.xpath("//input[@id='ExtRefferaddress']");
	By contactNumberTextFieldElement = By.xpath("//input[@id='contactNum']");
	By emailTextFieldElement = By.xpath("//div[@class='col-md-7']//input[@id='email']");
	By isIncentiveApplicableCheckboxElement = By.xpath("(//div[@class='icheck-inline']//span)[2]");
	By addreferrerButtonByElement = By.xpath("//button[@id='add']");
	By successNotificationPopupMessageElement = By.xpath("//div[@class='msg-text padding-8-all']");
	By successNotificationPopupMessageOneElement = By.xpath("//p[@class='msg-status']");
	By successNotificationPopupMessageTwoElement = By.xpath("//p[@class='main-message']");

	By relationWithPatientDropdownByElement = By.xpath("//select[@id='id_CareTaker_RelationWithPatient']");

	By bookAppointmentSubModuleByElement = By.xpath("//a[@href='#/Appointment/CreateAppointment']//span[contains(text(), 'Book Appointment')]");
	By newPatientButtonByElement = By.xpath("//a[contains(text(), 'New Patient')]");

	By monthRadioButtonByElement = By.xpath("//input[@value='M']/..//span");
	By daysRadioButtonByElement = By.xpath("//input[@value='D']/..//span");

	By firstNameTexboxOfBookAppointmentByElement = By.xpath("//input[@formcontrolname='FirstName']");
	By middleNameTexboxOfBookAppointmentByElement = By.xpath("//input[@formcontrolname='MiddleName']");
	By lastNameTexboxOfBookAppointmentByElement = By.xpath("//input[@formcontrolname='LastName']");
	By genderMaleOptionOfBookAppointmentByElement = By.xpath("//input[@value='Male']/..//span");
	By addAppointmentButtonByElement = By.xpath("//input[@name='addappointment']");

	By errorNotificationPopupMessageElement = By.xpath("//div[@class='msg-text padding-8-all']");
	By statusErrorNotificationMessageByElement = By.xpath("//p[contains(text(), 'failed')]");
	By mainErrorNotificationMessageByElement = By.xpath("//p[contains(text(), 'Failed!! Cannot create appointment. Check the Details Correctly.')]");

	By procurementModule = By.xpath("//span[.='Procurement']");
	By settingsTab = By.xpath("//a[.=' Settings ']");
	By subCategoryTabByElement = By.xpath("//a[contains(text(), 'Sub Category')]");
	By cuttonSubCategoryNameByElement = By.xpath("//div[contains(text(), 'cotton')]");

	By vaccinationModuleByElement = By.xpath("//a[@href='#/Vaccination']");
	By vaccinationModulesToggleIconByElement = By.xpath("//span[@data-target='#Vaccination']");
	By patientListSubModuleByElement = By.xpath("//a[@href='#/Vaccination/PatientList']//span[contains(text(), 'Patient List')]");
	By titleNameOfVaccinationPatientRegisterFormByElement = By.xpath("//span[contains(text(), 'Vaccination Patient Register')]");
	By newVaccinationPatientButtonByElement = By.xpath("//button[contains(text(), 'New Vaccination Patient')]");

	By keyboardButtonElement = By.xpath("//div[@title='Shortcut Keys']");
	By altPlusNtooltipMessageElement = By.xpath("//li[contains(text(),'+')]");

	By membershipDropdownByElement = By.xpath("//select[@id='Scheme']");

	By reportsSubButton = By.xpath("//a[.=' Reports ']");
	By currentStockLevelButton = By.xpath("//i[.='Current Stock Level']");
	By selectedItemDropdown = By.xpath("//div[@class='selected-list']");
	By selectItemSearchBar = By.xpath("//input[@placeholder='Search']");
	By accountsItemCheckBox = By.xpath("//label[.='Accounts']");
	By generalInventoryOption = By.xpath("//span[@class='fa fa-remove']");
	By accountOption = By.xpath("//span[.='Accounts']");

	By invoiceHeadersSubTab = By.xpath("//a[.='Invoice Headers']");
	By addNewInvoiceHeaderButton = By.xpath("//input[@value='Add New Invoice Header']");
	By chooseFileButton = By.id("img");

	By closeAddNewPatientForm = By.xpath("//button[.='X']");
	By xButton = By.xpath("//a[.='X']");


	//Locators of L2 Scenarios


	String pageName = this.getClass().getSimpleName();
	public appointment_Pages(WebDriver driver) {
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

			if(commonEvents.isDisplayed(appointmentModuleByElement))
			{   
				WebElement operationTheatreModuleWebElement = commonEvents.findElement(appointmentModuleByElement);
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
	 * about this method verifyAppointmentModuleIsPresent() 
	 * @param : null
	 * @description : 
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyAppointmentModuleIsPresent() throws Exception {
		String selectCounterTitleIsDisplayed = "";
		try {
			if(commonEvents.isDisplayed(appointmentModuleByElement)){
				commonEvents.jsClick(appointmentModuleToggleByElement);
			}

			if(commonEvents.isDisplayed(selectCounterTitleNameByElement)) {
				selectCounterTitleIsDisplayed = commonEvents.getText(selectCounterTitleNameByElement);
				System.out.println("select counter title name is : " + selectCounterTitleIsDisplayed);
				return selectCounterTitleIsDisplayed;
			}
		}catch(Exception e) {
			throw e;
		}	
		return selectCounterTitleIsDisplayed;
	}

	/**@Test3
	 * about this method verifyButtonAndTextIsPresent() 
	 * @param : null
	 * @description : 
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyButtonAndTextIsPresent() throws Exception {
		String buttonAndTextIsDisplayed = "";
		try {
			if(commonEvents.isDisplayed(selectCounterNewOneLinkByElement)){
				commonEvents.jsClick(selectCounterNewOneLinkByElement);
			}

			commonEvents.waitTillElementLocated(newPatientButtonLinkByElement, 10);			
			if(commonEvents.isDisplayed(newPatientButtonLinkByElement)) {
				commonEvents.click(newPatientButtonLinkByElement);
				commonEvents.waitTillElementLocated(patientInformationTextByElement, 10);	
				buttonAndTextIsDisplayed = commonEvents.getText(patientInformationTextByElement);
				System.out.println("select counter title name is : " + buttonAndTextIsDisplayed);
				return buttonAndTextIsDisplayed;
			}
		}catch(Exception e) {
			throw e;
		}	
		return buttonAndTextIsDisplayed;
	}

	/**@Test4
	 * about this method scrollToBottomVerifyFieldAndHighlight() 
	 * @param : null
	 * @description : 
	 * @return : String
	 * @author : YAKSHA
	 */
	public Boolean scrollToBottomVerifyFieldAndHighlight() throws Exception {
		Boolean textboxIsDisplayed = false;
		try {
			commonEvents.waitTillElementLocated(patientInformationTextByElement, 10);
			commonEvents.jsScrollToBottomOfThePage();

			commonEvents.waitTillElementLocated(careOfPersonContactTextboxByElement, 10);
			if(commonEvents.isDisplayed(careOfPersonContactTextboxByElement)){
				commonEvents.click(careOfPersonContactTextboxByElement);
				WebElement careOfPersonContactTextboxWebElement = commonEvents.findElement(careOfPersonContactTextboxByElement);
				commonEvents.highlight(careOfPersonContactTextboxWebElement);
				textboxIsDisplayed = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return textboxIsDisplayed;
	}

	/**@Test5
	 * about this method verifyPlaceholderNameOfTexbox() 
	 * @param : null
	 * @description : verify the placeholder name of text box 
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyPlaceholderNameOfTexbox() throws Exception {
		String placeholderNameOfTextbox = "";
		try {
			commonEvents.waitTillElementLocated(careOfPersonTextboxByElement, 10);
			if(commonEvents.isDisplayed(careOfPersonTextboxByElement)) {
				commonEvents.click(careOfPersonTextboxByElement);
				placeholderNameOfTextbox = commonEvents.getAttribute(careOfPersonTextboxByElement, "placeholder");
				System.out.println("place holder name of care Of Person Textbox : " + placeholderNameOfTextbox );
				return placeholderNameOfTextbox;
			}
		}catch(Exception e) {
			throw e;
		}	
		return placeholderNameOfTextbox;
	}

	/**@Test6
	 * about this method verifyErrorMessage() 
	 * @param : null
	 * @description : verify the error message
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyErrorMessage() throws Exception {
		String errorMessage = "";
		try {
			commonEvents.waitTillElementLocated(printInvoiceButtonByElement, 10);
			if(commonEvents.isDisplayed(printInvoiceButtonByElement)) {
				commonEvents.click(printInvoiceButtonByElement);

				commonEvents.waitTillElementLocated(confirmButtonByElement, 10);
				commonEvents.click(confirmButtonByElement);

				commonEvents.waitTillElementLocated(errorMessageOfLastNameTextboxByElement, 10);
				commonEvents.isDisplayed(errorMessageOfLastNameTextboxByElement);
				errorMessage = commonEvents.getText(errorMessageOfLastNameTextboxByElement);
				System.out.println("error Message of Last Name textbox : " + errorMessage );
				return errorMessage;
			}
		}catch(Exception e) {
			throw e;
		}
		return errorMessage;
	}

	/**@Test7
	 * about this method verifyTexboxIsPresentAndValidateEnteredValue() 
	 * @param : null
	 * @description : verify text box , then send value to that text box and validate the entered value
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTexboxIsPresentAndValidateEnteredValue(Map<String, String> expectedData) throws Exception {

		String phoneNumberTextboxValue = "";
		try {
			commonEvents.jsScrollToTopOfThePage();
			commonEvents.waitTillElementLocated(patientInformationTextByElement, 10);
			if(commonEvents.isDisplayed(patientInformationTextByElement)) {

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

				phoneNumberTextboxValue = commonEvents.getAttribute(phoneTextboxByElement, "value");
				System.out.println("attribute value of phone number Textbox : " + phoneNumberTextboxValue );
				return phoneNumberTextboxValue;
			}
		}catch(Exception e) {
			throw e;
		}	
		return phoneNumberTextboxValue;
	}

	/**@Test8
	 * about this method verifyCheckboxIsSelectedAndDatePickerIsPresent() 
	 * @param : null
	 * @description : click on check box and verify that the check box is selected  or not
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyCheckboxIsSelectedAndDatePickerIsPresent() throws Exception {
		boolean datePickerIsDisplayed = false;
		try {
			commonEvents.waitTillElementLocated(havDOBCheckboxByElement, 10);
			if(commonEvents.isDisplayed(havDOBCheckboxByElement)) { 
				commonEvents.click(havDOBCheckboxByElement);
				commonEvents.isSelected(havDOBCheckboxByElement);
				System.out.println("Have DOB Checkbox is selected");
				commonEvents.waitTillElementLocated(dobDatePickerByElement, 10);
				commonEvents.isDisplayed(dobDatePickerByElement);
				WebElement dobDatePickerWebElement = commonEvents.findElement(dobDatePickerByElement);
				commonEvents.highlight(dobDatePickerWebElement);
				datePickerIsDisplayed = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return datePickerIsDisplayed;
	}

	/**@Test9
	 * about this method verifySuccessNotificationPopupMessage() 
	 * @param : null
	 * @description : handle the notification pop up
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifySuccessNotificationPopupMessage(Map<String, String> expectedData) throws Exception {
		String successNotificationPopupMessageValue = "";
		try {
			Thread.sleep(10000);
			commonEvents.waitTillElementLocated(externalCheckBoxByElement, 10);
			if(commonEvents.isDisplayed(externalCheckBoxByElement)) {
				commonEvents.isSelected(externalCheckBoxByElement);

				commonEvents.waitTillElementLocated(plusIconClickToAddExternalReffererByElement, 10);
				commonEvents.isDisplayed(plusIconClickToAddExternalReffererByElement);
				commonEvents.jsClick(plusIconClickToAddExternalReffererByElement);

				commonEvents.waitTillElementLocated(addExternalReferralTitleByElement, 10);
				String titleNameOfaddExternalReferralForm = commonEvents.getText(addExternalReferralTitleByElement);
				System.out.println("title Name Of add External Referral Form" + titleNameOfaddExternalReferralForm);

				WebElement titleOfaddExternalReferralFormsWebElement = commonEvents.findElement(addExternalReferralTitleByElement);
				commonEvents.highlightElementAfterAction(titleOfaddExternalReferralFormsWebElement);

				commonEvents.waitTillElementLocated(referrerNameTexboxByElement, 10);
				commonEvents.sendKeys(referrerNameTexboxByElement, expectedData.get("referrerName"));

				commonEvents.waitTillElementLocated(extRefferAddressTextFieldElement, 10);
				commonEvents.sendKeys(extRefferAddressTextFieldElement, expectedData.get("ExtRefferaddress"));

				commonEvents.waitTillElementLocated(contactNumberTextFieldElement, 10);
				commonEvents.sendKeys(contactNumberTextFieldElement, expectedData.get("contactNum"));

				commonEvents.waitTillElementLocated(emailTextFieldElement, 10);
				commonEvents.sendKeys(emailTextFieldElement, expectedData.get("email"));

				commonEvents.waitTillElementLocated(isIncentiveApplicableCheckboxElement, 10);
				commonEvents.click(isIncentiveApplicableCheckboxElement);

				commonEvents.waitTillElementLocated(addreferrerButtonByElement, 10);
				commonEvents.click(addreferrerButtonByElement);

				commonEvents.waitTillElementLocated(successNotificationPopupMessageElement, 10);
				commonEvents.isDisplayed(successNotificationPopupMessageElement);

				String actualNotificationValue = commonEvents.getText(successNotificationPopupMessageElement);
				System.out.println("success notification popup message text Value : " + actualNotificationValue );

				String notificationMessageOne = commonEvents.getText(successNotificationPopupMessageOneElement);
				System.out.println("notification Message One " + notificationMessageOne);

				String notificationMessageTwo = commonEvents.getText(successNotificationPopupMessageTwoElement);
				System.out.println("notification Message two " + notificationMessageTwo);

				successNotificationPopupMessageValue = notificationMessageOne + " " +notificationMessageTwo ;
				System.out.println("success notification popup message text Value : " + successNotificationPopupMessageValue );
			}
		}catch(Exception e) {
			throw e;
		}	
		return successNotificationPopupMessageValue;
	}

	/**@Test10
	 * about this method verifyOptionIsSelectedFromDropdown() 
	 * @param : get the data from JSON file as type Map<String, String> expectedData
	 * @description : it will select the option as per JSON expected data
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyOptionIsSelectedFromDropdown(Map<String, String> expectedData) throws Exception {

		String selectedOption = "" ;

		try {
			commonEvents.jsScrollToBottomOfThePage();
			commonEvents.waitTillElementLocated(relationWithPatientDropdownByElement, 10);
			commonEvents.selectByVisibleText(relationWithPatientDropdownByElement, expectedData.get("relationWithPatientDropdownOption"));
			selectedOption = commonEvents.getFirstSelectedOptionFromDropdown(relationWithPatientDropdownByElement, "elementName", "pageName");
			System.out.println("first selected option from country dropdown : " + selectedOption );
			return selectedOption;
		}catch(Exception e) {
			throw e;
		}	
	}

	/**@Test11
	 * about this method verifyRadioButton() 
	 * @param : null
	 * @description :
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyRadioButton() throws Exception {
		Boolean verifyRadioButton = false;
		try {
			//			commonEvents.setBrowserZoomLevelTo80Percent();
			commonEvents.jsScrollToTopOfThePage();
			commonEvents.waitTillElementLocated(bookAppointmentSubModuleByElement, 10);
			if(commonEvents.isDisplayed(bookAppointmentSubModuleByElement)) {
				commonEvents.jsClick(bookAppointmentSubModuleByElement);

				commonEvents.waitTillElementLocated(newPatientButtonByElement, 10);
				commonEvents.jsClick(newPatientButtonByElement);

				//verify radio button is selected
				commonEvents.waitTillElementLocated(monthRadioButtonByElement, 10);

				if(commonEvents.isDisplayed(monthRadioButtonByElement)) {
					commonEvents.jsClick(monthRadioButtonByElement);
					commonEvents.isSelected(monthRadioButtonByElement);
					System.out.println("Month Radio button is selected");

					if(commonEvents.isDisplayed(daysRadioButtonByElement)) {
						commonEvents.jsClick(daysRadioButtonByElement);
						if(!commonEvents.isSelected(monthRadioButtonByElement)) {
							System.out.println("Month Radio button is De-Selected");
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
			commonEvents.waitTillElementLocated(addAppointmentButtonByElement, 10);
			if(commonEvents.isDisplayed(addAppointmentButtonByElement)) {

				commonEvents.waitTillElementLocated(firstNameTexboxOfBookAppointmentByElement, 10);
				commonEvents.jsSendKeys(firstNameTexboxOfBookAppointmentByElement, expectedData.get("firstNameValue"));

				commonEvents.waitTillElementLocated(middleNameTexboxOfBookAppointmentByElement, 10);
				commonEvents.jsSendKeys(middleNameTexboxOfBookAppointmentByElement, expectedData.get("middleNameValue"));

				commonEvents.waitTillElementLocated(lastNameTexboxOfBookAppointmentByElement, 10);
				commonEvents.jsSendKeys(lastNameTexboxOfBookAppointmentByElement, expectedData.get("lastNameValue"));

				if(commonEvents.isDisplayed(lastNameTexboxOfBookAppointmentByElement) &&
						commonEvents.isDisplayed(genderMaleOptionOfBookAppointmentByElement)) {

					javaScriptExecutorValue = commonEvents.getAttribute(lastNameTexboxOfBookAppointmentByElement, "value");
					System.out.println("value of Last Name Textbox : " + javaScriptExecutorValue);

					commonEvents.waitTillElementLocated(genderMaleOptionOfBookAppointmentByElement, 10);
					commonEvents.jsClick(genderMaleOptionOfBookAppointmentByElement);

					if(commonEvents.isSelected(genderMaleOptionOfBookAppointmentByElement)) {
						System.out.println("successfully executed by javaScriptExecutor");
						Thread.sleep(3000);
						return javaScriptExecutorValue;
					}
				}
			}
		}catch(Exception e) {
			throw e;
		}	
		return javaScriptExecutorValue;
	}

	/**@Test13
	 * about this method verifyLocatorsValueOfELement() 
	 * @param : Map<String, String>
	 * @description : verify locators value of text box and send value to the text box and highlight that text box
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyLocatorsValueOfELementAndHighLight() throws Exception {
		String locatorsValue = "";
		try {
			Thread.sleep(3000);
			commonEvents.waitTillElementLocated(addAppointmentButtonByElement, 10);
			if(commonEvents.isDisplayed(addAppointmentButtonByElement)) {

				locatorsValue = commonEvents.getAttribute(addAppointmentButtonByElement,"name");
				System.out.println("ID locators value of Add Appointment Button : " + locatorsValue);
				WebElement  addappointmentButtonWebElement = commonEvents.findElement(addAppointmentButtonByElement);
				commonEvents.highlightElement(addappointmentButtonWebElement);
			}
		}catch(Exception e) {
			throw e;
		}
		return locatorsValue;
	}

	/**@Test14
	 * about this method verifyErrorNotificationPopupMessage() 
	 * @param : null
	 * @description : verify the error message using hard assert
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyErrorNotificationPopupMessage(Map<String, String> expectedData) throws Exception {
		String actualErrorNotificationPopupMessageValue = "";
		try {
			Thread.sleep(10000);
			if(commonEvents.isDisplayed(addAppointmentButtonByElement)) {

				WebElement addAppointmentButtonWebElement = commonEvents.findElement(addAppointmentButtonByElement);
				commonEvents.highlightElementAfterAction(addAppointmentButtonWebElement);

				Thread.sleep(2000);

				commonEvents.click(addAppointmentButtonByElement);

				commonEvents.isDisplayed(errorNotificationPopupMessageElement);

				String actualNotificationErrorMessage = commonEvents.getText(errorNotificationPopupMessageElement);
				System.out.println("Error notification popup message text Value : " + actualNotificationErrorMessage );

				String statusOfErrorMessage = commonEvents.getText(statusErrorNotificationMessageByElement);
				System.out.println("status error notification Message :  " + statusOfErrorMessage);

				String mainNotificationErrorMessage = commonEvents.getText(mainErrorNotificationMessageByElement);
				System.out.println("main notification Error Message :  " + mainNotificationErrorMessage);

				actualErrorNotificationPopupMessageValue = statusOfErrorMessage + " " + mainNotificationErrorMessage ;
				System.out.println("main error notification popup message text Value : " + actualErrorNotificationPopupMessageValue );

				return actualErrorNotificationPopupMessageValue;

			}
		}catch(Exception e) {
			throw e;
		}	
		return actualErrorNotificationPopupMessageValue;
	}

	/**@Test15
	 * about this method getDataFromTable() 
	 * @param : null
	 * @description : it will fetch the data from the table
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public String getDataFromTable() throws Exception {
		String cuttonSubCategoryName = "";

		Thread.sleep(5000);
		try {
			if(commonEvents.isDisplayed(procurementModule)) {
				commonEvents.jsClick(procurementModule);
				commonEvents.waitTillElementLocated(settingsTab, 10);
				commonEvents.jsClick(settingsTab);
				commonEvents.click(subCategoryTabByElement);
				commonEvents.waitTillElementLocated(cuttonSubCategoryNameByElement, 10);
				cuttonSubCategoryName = commonEvents.getText(cuttonSubCategoryNameByElement);
				System.out.println("sub category name of given code 003: " + cuttonSubCategoryName);
				return cuttonSubCategoryName;
			}
		}catch(Exception e) {
			throw e;
		}	
		return cuttonSubCategoryName;
	}
	
	/**@Test16
	 * about this method performKeyboardOperation() 
	 * @param : Map<String, String>
	 * @description : perform the keyboard operation
	 * @return : String
	 * @author : YAKSHA
	 */
	public String performKeyboardOperation() throws Exception {
		String titleNameOfVaccinationPatientRegisterForm = "";
		try {
			Thread.sleep(5000);
			commonEvents.jsScrollPageTillElementVisible(vaccinationModuleByElement, "vaccinationModule", "vaccinationModule");

			commonEvents.waitTillElementLocated(vaccinationModuleByElement, 10);
			if (commonEvents.isDisplayed(vaccinationModuleByElement)) {

				commonEvents.waitTillElementLocated(vaccinationModulesToggleIconByElement, 10);
				commonEvents.jsClick(vaccinationModulesToggleIconByElement);

				commonEvents.waitTillElementLocated(patientListSubModuleByElement, 10);
				commonEvents.jsClick(patientListSubModuleByElement);

				commonEvents.waitTillElementLocated(newVaccinationPatientButtonByElement, 10);
				commonEvents.performAltN();

				commonEvents.waitTillElementLocated(titleNameOfVaccinationPatientRegisterFormByElement, 10);
				titleNameOfVaccinationPatientRegisterForm = commonEvents.getText(titleNameOfVaccinationPatientRegisterFormByElement);
				System.out.println("title Name Of Vaccination Patient Register form : " + titleNameOfVaccinationPatientRegisterForm);

				return titleNameOfVaccinationPatientRegisterForm;
			}
		}catch(Exception e) {
			throw e;
		}
		return titleNameOfVaccinationPatientRegisterForm;
	}

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
			commonEvents.waitTillElementLocated(appointmentModuleByElement, 10);
			commonEvents.jsClick(appointmentModuleByElement);

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
	 * about this method handleAlertPopup()
	 * @param : null
	 * @description : 
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public String handleAlertPopup(Map<String, String> expectedData) throws Exception {

		String selectedOption = "";

		try {
			commonEvents.waitTillElementLocated(newPatientButtonLinkByElement, 10);
			commonEvents.jsClick(newPatientButtonLinkByElement);

			commonEvents.waitTillElementLocated(patientInformationTextByElement, 10);
			WebElement patientInformationText = commonEvents.findElement(patientInformationTextByElement);
			commonEvents.highlight(patientInformationText);

			commonEvents.waitTillElementLocated(membershipDropdownByElement, 10);
			commonEvents.selectByVisibleText(membershipDropdownByElement, expectedData.get("membershipDropdownOption"));

			// commonEvents.validateAlertMessage();
			commonEvents.acceptAlert();

			selectedOption = commonEvents.getFirstSelectedOptionFromDropdown(membershipDropdownByElement, "elementName", "pageName");
			System.out.println("first selected option from dropdown : " + selectedOption );

			return selectedOption;

		}catch(Exception e) {
			throw e;
		}
	}

	/**@Test19
	 * about this method handleAutoSuggesstion() 
	 * @param : Map<String, String>
	 * @description : Search for a Select Item as Accounts and select Accounts  and validate Accounts is selected.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean handleAutoSuggesstion(Map<String, String> expectedData) throws Exception {
		boolean accountOptionisDisplayed = false;
		try {
			Thread.sleep(5000);
			commonEvents.waitTillElementLocated(procurementModule, 10);
			commonEvents.click(procurementModule);

			commonEvents.waitTillElementLocated(reportsSubButton, 10);
			commonEvents.click(reportsSubButton);

			commonEvents.waitTillElementLocated(currentStockLevelButton, 10);
			commonEvents.click(currentStockLevelButton);

			commonEvents.waitTillElementLocated(selectedItemDropdown, 10);
			commonEvents.click(selectedItemDropdown);

			commonEvents.waitTillElementLocated(generalInventoryOption, 10);
			commonEvents.click(generalInventoryOption);

			commonEvents.waitTillElementLocated(selectedItemDropdown, 10);
			commonEvents.click(selectedItemDropdown);

			commonEvents.waitTillElementLocated(selectItemSearchBar, 10);
			commonEvents.sendKeys(selectItemSearchBar,expectedData.get("searchBarData"));

			commonEvents.waitTillElementLocated(accountsItemCheckBox, 10);
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
			commonEvents.waitTillElementLocated(procurementModule, 10);
			commonEvents.click(procurementModule);

			commonEvents.waitTillElementLocated(settingsTab, 10);
			commonEvents.click(settingsTab);

			commonEvents.waitTillElementLocated(invoiceHeadersSubTab, 10);
			commonEvents.click(invoiceHeadersSubTab);

			commonEvents.waitTillElementLocated(addNewInvoiceHeaderButton, 10);
			commonEvents.click(addNewInvoiceHeaderButton);

			Thread.sleep(3000);
			commonEvents.waitTillElementLocated(chooseFileButton, 10);
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

	/**@Test21
	 * about this method takingScreenshotOfTheCurrentPage() 
	 * @param : null
	 * @description : Taking screenshot of the current page.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean takingScreenshotOfTheCurrentPage() throws Exception {
		boolean isDisplayed = false;
		commonEvents.click(xButton);
		try {
			commonEvents.takeScreenshot("Sale page of DIspensary Module");
			isDisplayed = true;

		}catch(Exception e) {
			throw e;
		}
		return isDisplayed;
	}
}
