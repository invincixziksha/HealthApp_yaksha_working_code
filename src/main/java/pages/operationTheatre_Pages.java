package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class operationTheatre_Pages extends StartupPage {

	// Locators of L1 Scenarios
	By usernameTextfield = By.id("username_id");
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");	
	By operationTheatreModule = By.xpath("//span[.='OperationTheatre']");
	By operationTheatreTab = By.xpath("//span[.='OperationTheatre']");

	By newOTButtonElement = By.xpath("//button[contains(text(), 'New OT Booking')]");
	By newOTButtonLink = By.xpath("//button[@class='btn btn-link']");
	By searchTextBoxElement = By.xpath("//input[@id='quickFilterInput']");
	By bookingOTSchedulePageElement = By.xpath("//span[contains(text(), 'Booking OT Schedule  | New Patient')]");

	By selectpatientTextboxElement = By.xpath("//input[@id='srch_PatientList']");
	By diagnosisTextboxElement = By.xpath("//input[@id='Diagnosis']");
	By surgeryTypeTextboxElement = By.xpath("//textarea[@id='surgeryType']");
	By remarkTextboxElement = By.xpath("//textarea[@placeholder='Remarks']");


	By surgenNameTextFieldElement = By.xpath("//input[@id='id_input_currentRequestedByDoctor_selectReferral']");
	By anesthetistDoctorTextboxElement = By.xpath("//input[@id='AnesthetistDoctor']");
	By surgenNameFirstButtonElement = By.xpath("//ul[@class='select-list']//li[1]");

	By externalCheckBoxElement = By.xpath("//label[@class='is-ref mt-checkbox mt-checkbox-outline']//span");
	By plusIconButtonElement = By.xpath("//a[@class='btn blue btn-xs btn-ext']");

	By referrerNameTextFieldElement = By.xpath("//input[@id='referrerName']");
	By extRefferAddressTextFieldElement = By.xpath("//input[@id='ExtRefferaddress']");
	By contactNumberTextFieldElement = By.xpath("//input[@id='contactNum']");
	By emailTextFieldElement = By.xpath("//input[@id='email']");
	By isIncentiveApplicableCheckboxElement = By.xpath("(//div[@class='icheck-inline']//span)[2]");
	By addButtonElement = By.xpath("//button[@id='add']");
	By successNotificationPopupMessageElement = By.xpath("//div[@class='msg-text padding-8-all']");

	By successNotificationPopupMessageOneElement = By.xpath("//p[@class='msg-status']");
	By successNotificationPopupMessageTwoElement = By.xpath("//p[@class='main-message']");

	By hospitalNumberByElement = By.xpath("//span[contains(text(), 'Hospital Number')]");
	By newOtButtonByElement = By.xpath("//button[contains(text(), 'New OT Booking')]");
	By bookingOTScheduleFormsTitleNameByElement = By.xpath("//span[contains(text(), 'Booking OT Schedule  | New Patient')]");
	By remarksTextAreaByElement = By.xpath("//textarea[@id='remarks']");
	By addButtonOfAddExternalReferralByElement = By.xpath("//button[contains(text(), 'Add')]");
	By errorMessageOfAddExternalReferralFormsByElement = By.xpath("//span[contains(text(), 'Referrer Name is required')]");
	By titleOfaddExternalReferralFormsByElement = By.xpath("//span[contains(text(), 'Add External Referral')]");
	By closeLinkOfBookingOTScheduleNewPatientFormsByElement = By.xpath("//a[.='X']");

	By billingModuleExpandIconByElement = By.xpath("//span[@data-target='#Billing']");
	By newOneCounterLinkByElement = By.xpath("//h5[contains(text(), 'New-1')]//span");

	By handOverSubModuleLinkByElement = By.xpath("//span[contains(text(), 'Handover')]");
	By remarksTextFieldOfBillingSubModulesByElement = By.xpath("//input[@id='HandoverRemarks_User']");
	By handOverToUserButtonOfBillingSubModuleByElement = By.xpath("//input[@value='HandOver To User']");

	By vaccinationModuleByElement = By.xpath("//a[@href='#/Vaccination']");
	By vaccinationModulesToggleIconByElement = By.xpath("//span[@data-target='#Vaccination']");
	By patientListSubModuleByElement = By.xpath("//a[@href='#/Vaccination/PatientList']//span[contains(text(), 'Patient List')]");
	By titleNameOfVaccinationPatientRegisterFormByElement = By.xpath("//span[contains(text(), 'Vaccination Patient Register')]");

	By appointmentModuleByElement = By.xpath("//a[@href='#/Appointment']");
	By appointmentModulesToggleIconByElement = By.xpath("//span[@data-target='#Appointment']");
	By bookingAppointmentSubModuleByElement = By.xpath("//a[@href='#/Appointment/CreateAppointment']//span[contains(text(), 'Book Appointment')]");

	By newPatientButtonByElement = By.xpath("//a[contains(text(), 'New Patient')]");

	By monthRadioButtonByElement = By.xpath("//input[@value='M']");
	By daysRadioButtonByElement = By.xpath("//input[@value='D']");

	By selectVisitTypeDropdownByElement = By.xpath("//select[@name='VistType']");

	By addAppointmentButtonByElement = By.xpath("//input[@value='Add Appointment']");

	By errorNotificationPopupMessageElement = By.xpath("//div[@class='msg-text padding-8-all']");
	By statusErrorNotificationMessageByElement = By.xpath("//p[@class='msg-status']");
	By mainErrorNotificationMessageByElement = By.xpath("//p[@class='main-message']");
	By closeLinkOfVaccinationPatientRegisterForm = By.xpath("//a[.='X']");
	By newOTBookingButtonByElement = By.xpath("//button[contains(text(), 'New OT Booking')]");

	By selectOTAssistantNameFieldByElement = By.xpath("//span[contains(text(), '---Select Ot Assistant Name---')]");
	By searchTexboxOfSelectOTAssistantNameFieldByElement = By.xpath("//input[@placeholder='Search']");
	By drPoojaMishraCheckBoxByElement = By.xpath("//label[contains(text(), 'Dr. pooja Mishra')]/..//input");
	By selectOTAssistantNameDropdownByElement = By.xpath("//div[@class='cuppa-dropdown']");

	By closeLinkByElement = By.xpath("//a[.='X']");

	//tootipsElements
	By xButton = By.xpath("//a[.='X']");
	By appointmentModule = By.xpath("(//span[.='Appointment'])[1]");
	By newOneSelectCounterElement = By.xpath("//div[@class='counter-item']//h5[contains(text(), 'New-1 ')]");
	By keyboardButtonElement = By.xpath("//div[@title='Shortcut Keys']");
	By altPlusNtooltipMessageElement = By.xpath("//li[contains(text(),'+')]");

	By addNewOtButtonElement = By.xpath("//input[@value='Add New OT']");

	//file upload elements
	By procurementModule = By.xpath("//span[.='Procurement']");
	By settingsTab = By.xpath("//a[.=' Settings ']");
	By invoiceHeadersSubTab = By.xpath("//a[.='Invoice Headers']");
	By addNewInvoiceHeaderButton = By.xpath("//input[@value='Add New Invoice Header']");
	By chooseFileButton = By.id("img");


	//i frame elements
	By procurementModuleByElement = By.xpath("//span[@data-target='#Procurement']");
	By purchaseOrderSubmoduleByElement = By.xpath("//span[contains(text(), 'Purchase Order')]");
	By createPurchaseOrderButtonByElement = By.xpath("//input[@value='Create Purchase Order']");

	By addPurchaseOrderTitleByElement = By.xpath("//span[contains(text(), 'Add Purchase Order')]");
	By iFrameTextEditorByElement = By.xpath("//body[@contenteditable='true']");




	String pageName = this.getClass().getSimpleName();
	public operationTheatre_Pages(WebDriver driver) {
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

			if(commonEvents.isDisplayed(operationTheatreModule))
			{   
				WebElement operationTheatreModuleWebElement = commonEvents.findElement(operationTheatreModule);
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
			urlofThepage = commonEvents.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage );
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}

	/**@Test2
	 * about this method verifyOperationTheatreModuleIsPresentAndGoToOperationTheatreTab() 
	 * @param : null
	 * @description : Verify that OperationTheatre module is present and Go to OperationTheatre Tab.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String goToOperationTheatreModuleVerifyTableHeaderName() throws Exception {
		String tableHeaderNameIsDisplayed = "";
		try {
			if(commonEvents.isDisplayed(operationTheatreModule)){
				commonEvents.click(operationTheatreModule);
				Thread.sleep(3000);
			}

			if(commonEvents.isDisplayed(hospitalNumberByElement)) {
				tableHeaderNameIsDisplayed = commonEvents.getText(hospitalNumberByElement);

				System.out.println("table header name is : " + tableHeaderNameIsDisplayed);
				return tableHeaderNameIsDisplayed;
			}

		}catch(Exception e) {
			throw e;
		}	
		return tableHeaderNameIsDisplayed;
	}


	/**@Test3
	 * about this method verifyBookingOTScheduleFormByClickingOnNewOTBookingButton() 
	 * @param : null
	 * @description : verify the button & text 
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyBookingOTScheduleFormByClickingOnNewOTBookingButton() throws Exception {
		String bookingOTScheduleFormsName = "";
		try {
			commonEvents.click(newOtButtonByElement);
			Thread.sleep(2000);
			bookingOTScheduleFormsName = commonEvents.getText(bookingOTScheduleFormsTitleNameByElement);
			System.out.println("booking OT Schedule Form's Title Name" + bookingOTScheduleFormsName );
		}catch(Exception e) {
			throw e;
		}	
		return bookingOTScheduleFormsName;
	}

	/**@Test6
	 * about this method verifyTexboxIsPresentAndValidateEnteredValue() 
	 * @param : null
	 * @description : verify text box , then send value to that text box and validate the entered value
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTexboxIsPresentAndValidateEnteredValue(Map<String, String> expectedData) throws Exception {

		String selectPatientTextboxValue = "";
		try {
			if(commonEvents.isDisplayed(bookingOTScheduleFormsTitleNameByElement)) {
				commonEvents.sendKeys(selectpatientTextboxElement, expectedData.get("patientName"));
				commonEvents.sendKeys(diagnosisTextboxElement, expectedData.get("diagnosisValue"));
				commonEvents.sendKeys(surgeryTypeTextboxElement, expectedData.get("surgeryTypeValue"));

				selectPatientTextboxValue = commonEvents.getAttribute(selectpatientTextboxElement, "value");
				System.out.println("attribute value of select patient Textbox : " + selectPatientTextboxValue );
			}
		}catch(Exception e) {
			throw e;
		}	
		return selectPatientTextboxValue;
	}

	/**@Test5
	 * about this method verifyPlaceholderNameOfTexboxIfTextboxIsEnabled() 
	 * @param : null
	 * @description : verify the placeholder name of text box if text box is enabled
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyPlaceholderNameOfTexboxIfTextboxIsEnabled() throws Exception {
		String placeholderNameOfRemarkasTextarea = "";
		try {
			if(commonEvents.isDisplayed(remarksTextAreaByElement) &&
					commonEvents.isEnabled(remarksTextAreaByElement)) {
				commonEvents.click(remarksTextAreaByElement);
				Thread.sleep(2000);
				placeholderNameOfRemarkasTextarea = commonEvents.getAttribute(remarksTextAreaByElement, "placeholder");
				System.out.println("booking OT Schedule Form's Title Name" + placeholderNameOfRemarkasTextarea );
				return placeholderNameOfRemarkasTextarea;
			}
		}catch(Exception e) {
			throw e;
		}	
		return placeholderNameOfRemarkasTextarea;
	}

	/**@Test6
	 * about this method verifyButtonIsPresentAfterSendValueToSurgenNameTextfield() 
	 * @param : null
	 * @description : verify the button is present after send the value to the text box
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyButtonIsPresentAfterSendValueToSurgenNameTextfield(Map<String, String> expectedData) throws Exception {
		String surgenNameButtonAttributeValue = "";
		try {
			if(commonEvents.isDisplayed(surgenNameTextFieldElement)) {
				commonEvents.sendKeys(surgenNameTextFieldElement, expectedData.get("surgenNameValue1"));
				commonEvents.sendKeys(surgenNameTextFieldElement, Keys.ENTER);
				Thread.sleep(2000);
				commonEvents.click(remarkTextboxElement);
				Thread.sleep(2000);
				commonEvents.isDisplayed(surgenNameFirstButtonElement);
				surgenNameButtonAttributeValue = commonEvents.getText(surgenNameFirstButtonElement);
				System.out.println("attribute value of surgen Name : " + surgenNameButtonAttributeValue );
			}
		}catch(Exception e) {
			throw e;
		}	
		return surgenNameButtonAttributeValue;
	}

	/**@Test7
	 * about this method verifyPlusButtonIsPresentAfterClickOnExternalCheckbox() 
	 * @param : null
	 * @description : click on check box and verify check box is selected or not and verify the + (plus) icon after click on check box
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyPlusButtonIsPresentAfterClickOnExternalCheckbox() throws Exception {
		boolean plusIconIsDisplayed = false;
		try {
			commonEvents.isDisplayed(externalCheckBoxElement);
			commonEvents.click(externalCheckBoxElement);
			Thread.sleep(3000);

			commonEvents.isSelected(externalCheckBoxElement);
			commonEvents.isDisplayed(plusIconButtonElement);
			plusIconIsDisplayed = true;

		}catch(Exception e) {
			throw e;
		}	
		return plusIconIsDisplayed;
	}

	/**@Test8
	 * about this method verifyErrorMessageInAddExternalReferralForms() 
	 * @param : null
	 * @description : verify the error message
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyErrorMessageInAddExternalReferralForms() throws Exception {
		String errorMessageOfAddExternalReferralForms = "";
		try {
			if(commonEvents.isDisplayed(plusIconButtonElement)) {
				commonEvents.click(plusIconButtonElement);
				Thread.sleep(2000);
				commonEvents.click(addButtonOfAddExternalReferralByElement);
				Thread.sleep(2000);
				commonEvents.isDisplayed(errorMessageOfAddExternalReferralFormsByElement);
				errorMessageOfAddExternalReferralForms = commonEvents.getText(errorMessageOfAddExternalReferralFormsByElement);
				System.out.println("error Message Of Add External Referral Forms : " + errorMessageOfAddExternalReferralForms );
				return errorMessageOfAddExternalReferralForms;
			}
		}catch(Exception e) {
			throw e;
		}
		return errorMessageOfAddExternalReferralForms;
	}

	/**@Test9
	 * about this method verifySuccessNotificationPopupMessage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifySuccessNotificationPopupMessage(Map<String, String> expectedData) throws Exception {
		String successNotificationPopupMessageValue = "";
		try {
			Thread.sleep(10000);
			if(commonEvents.isDisplayed(titleOfaddExternalReferralFormsByElement)) {

				WebElement titleOfaddExternalReferralFormsWebElement = commonEvents.findElement(titleOfaddExternalReferralFormsByElement);
				commonEvents.highlightElementAfterAction(titleOfaddExternalReferralFormsWebElement);

				commonEvents.sendKeys(referrerNameTextFieldElement, expectedData.get("referrerName"));
				commonEvents.sendKeys(extRefferAddressTextFieldElement, expectedData.get("ExtRefferaddress"));
				commonEvents.sendKeys(contactNumberTextFieldElement, expectedData.get("contactNum"));
				commonEvents.sendKeys(emailTextFieldElement, expectedData.get("email"));
				Thread.sleep(1000);
				commonEvents.click(isIncentiveApplicableCheckboxElement);
				commonEvents.click(addButtonElement);

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
	 * about this method closeBookingOTScheduleNewPatientFormsByUsingJsExecutor() 
	 * @param : null
	 * @description : On the "Booking OT Schedule New Patient" Forms, Close this ""Booking OT Schedule New Patient" Forms by using javaScript.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean closeBookingOTScheduleNewPatientFormsByUsingJsExecutor() throws Exception {
		boolean IsDisplayed = false;
		try {
			if (commonEvents.isDisplayed(closeLinkOfBookingOTScheduleNewPatientFormsByElement)) {
				commonEvents.jsClick(closeLinkOfBookingOTScheduleNewPatientFormsByElement);
				Thread.sleep(3000);
				IsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return IsDisplayed;
	}

	/**@Test11
	 * about this method performScrollOperation() 
	 * @param : null
	 * @description : scroll to the bottom of the page and validate the button and text field is present
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean performScrollOperation(Map<String, String> expectedData) throws Exception {
		boolean performScrollOperation = false;
		try {
			commonEvents.jsClick(billingModuleExpandIconByElement);
			Thread.sleep(2000);

			commonEvents.click(newOneCounterLinkByElement);
			Thread.sleep(2000);

			commonEvents.jsScrollPageTillElementVisible(handOverSubModuleLinkByElement, "billing", "handOverElement");
			Thread.sleep(2000);

			commonEvents.click(handOverSubModuleLinkByElement);
			Thread.sleep(3000);

			commonEvents.jsScrollToBottomOfThePage();
			Thread.sleep(2000);

			if(commonEvents.isDisplayed(remarksTextFieldOfBillingSubModulesByElement)&& 
					commonEvents.isDisplayed(handOverToUserButtonOfBillingSubModuleByElement)) {
				commonEvents.sendKeys(remarksTextFieldOfBillingSubModulesByElement, expectedData.get("remarksValue"));
				Thread.sleep(2000);
				commonEvents.click(handOverToUserButtonOfBillingSubModuleByElement);
				System.out.println("Remarks textbox & HandOverToUser button are present");
				performScrollOperation = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return performScrollOperation;
	}

	/**@Test12
	 * about this method verifyLocatorsValueOfELement() 
	 * @param : Map<String, String>
	 * @description : verify locators value of text box and send value to the text box and highlight that text box
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyLocatorsValueOfELement(Map<String, String> expectedData) throws Exception {
		String locatorsValue = "";
		try {
			Thread.sleep(3000);
			if(commonEvents.isDisplayed(remarksTextFieldOfBillingSubModulesByElement)) {
				Thread.sleep(3000);
				commonEvents.click(remarksTextFieldOfBillingSubModulesByElement);
				commonEvents.clear(remarksTextFieldOfBillingSubModulesByElement);
				Thread.sleep(2000);
				commonEvents.sendKeys(remarksTextFieldOfBillingSubModulesByElement, expectedData.get("remarksValue"));
				locatorsValue = commonEvents.getAttribute(remarksTextFieldOfBillingSubModulesByElement,"id");
				System.out.println("ID locators value of Remarks Texbox : " + locatorsValue);

				WebElement  remarksTextFieldWebElement = commonEvents.findElement(remarksTextFieldOfBillingSubModulesByElement);
				commonEvents.highlightElement(remarksTextFieldWebElement);

			}
		}catch(Exception e) {
			throw e;
		}
		return locatorsValue;
	}

	/**@Test13
	 * about this method performKeyboardOperation() 
	 * @param : Map<String, String>
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

	/**@Test14.1
	 * about this method verifyRadioButton() 
	 * @param : null
	 * @description :
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyRadioButton() throws Exception {
		Boolean verifyRadioButton = false;
		try {
			commonEvents.click(closeLinkOfVaccinationPatientRegisterForm);
			Thread.sleep(3000);

			commonEvents.jsScrollPageTillElementVisible(appointmentModuleByElement, "appointmentModule", "appointmentModule");

			if(commonEvents.isDisplayed(appointmentModuleByElement)) {
				commonEvents.jsClick(appointmentModulesToggleIconByElement);
				Thread.sleep(3000);
				commonEvents.jsClick(bookingAppointmentSubModuleByElement);
				Thread.sleep(3000);
				commonEvents.click(newPatientButtonByElement);
				Thread.sleep(3000);

				commonEvents.jsClick(monthRadioButtonByElement);

				if(commonEvents.isSelected(monthRadioButtonByElement)) {
					System.out.println("Month Radio button is selected");
				}

				commonEvents.jsClick(daysRadioButtonByElement);

				if(!commonEvents.isSelected(monthRadioButtonByElement)) {
					System.out.println("Month Radio button is De-Selected");
				}

				verifyRadioButton = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return verifyRadioButton;
	}

	/**@Test14.2
	 * about this method verifyOptionIsSelectedFromDropdown() 
	 * @param : get the data from json file as type Map<String, String> expectedData
	 * @description : it will select the option as per JSON expected data
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyOptionIsSelectedFromDropdown(Map<String, String> expectedData) throws Exception {

		String selectedOption = "" ;

		try {
			commonEvents.selectByVisibleText(selectVisitTypeDropdownByElement, expectedData.get("visitTypeOptionValue"));
			selectedOption = commonEvents.getFirstSelectedOptionFromDropdown(selectVisitTypeDropdownByElement, "elementName", "pageName");
			System.out.println("first selected option from country dropdown : " + selectedOption );
			return selectedOption;
		}catch(Exception e) {
			throw e;
		}	
	}

	/**@Test15
	 * about this method verifyErrorNotificationPopupMessage() 
	 * @param : null
	 * @description : verify the error message using hard assert
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyErrorNotificationPopupMessage() throws Exception {
		String mainErrorNotificationPopupMessageValue = "";
		try {
			Thread.sleep(2000);
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

				mainErrorNotificationPopupMessageValue = statusOfErrorMessage + " " + mainNotificationErrorMessage ;
				System.out.println("main error notification popup message text Value : " + mainErrorNotificationPopupMessageValue );

				return mainErrorNotificationPopupMessageValue;

			}
		}catch(Exception e) {
			throw e;
		}	
		return mainErrorNotificationPopupMessageValue;
	}

	/**@Test16
	 * about this method handleAutoSuggesstion() 
	 * @param : Map<String, String>
	 * @description : Search for a Select Item as Accounts and select Accounts  and validate Accounts is selected.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public String handleAutoSuggesstion(Map<String, String> expectedData) throws Exception {
		String selectedSuggestionValue = "";
		try {
			commonEvents.click(operationTheatreModule);
			Thread.sleep(2000);
			commonEvents.click(newOTBookingButtonByElement);
			Thread.sleep(3000);
			commonEvents.click(selectOTAssistantNameFieldByElement);
			Thread.sleep(3000);
			commonEvents.click(searchTexboxOfSelectOTAssistantNameFieldByElement);
			Thread.sleep(3000);
			commonEvents.sendKeys(searchTexboxOfSelectOTAssistantNameFieldByElement, expectedData.get("otAssistantName"));		
			Thread.sleep(3000);
			commonEvents.jsClick(drPoojaMishraCheckBoxByElement);
			Thread.sleep(3000);
			commonEvents.click(selectOTAssistantNameDropdownByElement);
			Thread.sleep(3000);

			if(commonEvents.isDisplayed(selectOTAssistantNameDropdownByElement)) {
				selectedSuggestionValue = commonEvents.getText(selectOTAssistantNameDropdownByElement);
				System.out.println("selected suggestion value is : " + selectedSuggestionValue);
				return selectedSuggestionValue;
			}
		}catch(Exception e) {
			throw e;
		}
		return selectedSuggestionValue;
	}

	/**@Test17
	 * about this method takingScreenshotOfTheCurrentPage() 
	 * @param : null
	 * @description : Taking screenshot of the current page.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean takingScreenshotOfTheCurrentPage() throws Exception {
		boolean isDisplayed = false;
		commonEvents.click(closeLinkByElement);
		try {
			commonEvents.takeScreenshot("Operation Theatre Module");
			isDisplayed = true;

		}catch(Exception e) {
			throw e;
		}
		return isDisplayed;
	}

	/**@Test18
	 * about this method verifyToolTipOfAnElement()
	 * @param : null
	 * @description :go to appointmentTab and verify the TOOLTIP value/text
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyToolTipOfAnElement() throws Exception {
		String tooltipText = "";
		try {
			commonEvents.click(appointmentModule);
			Thread.sleep(2000);
//						commonEvents.click(newOneCounterLinkByElement);
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

	/**@Test19
	 * about this method handleAlertPopup()
	 * @param : null
	 * @description : 
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public boolean handleAlertPopup() throws Exception {

		boolean isPopupHandled = false;

		try {
			Thread.sleep(2000);
			commonEvents.click(operationTheatreModule);
			Thread.sleep(2000);
			commonEvents.click(newOTBookingButtonByElement);
			Thread.sleep(2000);
			if(commonEvents.isDisplayed(addNewOtButtonElement)){
				Thread.sleep(2000);
				commonEvents.click(addNewOtButtonElement);
				Thread.sleep(2000);
				// commonEvents.validateAlertMessage();
				commonEvents.acceptAlert();
				isPopupHandled = true;
			}
		}catch(Exception e) {
			throw e;
		}
		return isPopupHandled;
	}

	/**@Test20
	 * about this method handleFileUpload() 
	 * @param : Map<String, String>
	 * @description : Upload a image in Scanned Images section.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean handleFileUpload(String pathOfTheFile) throws Exception {
		boolean isUploaded = false;
		try {
			commonEvents.click(closeLinkByElement);
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

	/**@Test21
	 * about this method handleIframe()
	 * @param : null
	 * @description : 
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public String handleIframe(Map<String, String> expectedData) throws Exception {
		String textValueOfFrameEditor = "";	
		try {
			commonEvents.click(closeLinkByElement);
			Thread.sleep(3000);
			commonEvents.jsClick(procurementModuleByElement);
			Thread.sleep(3000);
			commonEvents.jsClick(purchaseOrderSubmoduleByElement);	
			Thread.sleep(3000);
			commonEvents.jsClick(createPurchaseOrderButtonByElement);			
			WebElement addPurchaseOrderTitleWebElement = commonEvents.findElement(addPurchaseOrderTitleByElement);
			commonEvents.highlight(addPurchaseOrderTitleWebElement);		    
			String addPurchaseOrderTitleTextValue = commonEvents.getText(addPurchaseOrderTitleByElement);
			System.out.println("title name of the : " + addPurchaseOrderTitleTextValue);				
			commonEvents.jsScrollToBottomOfThePage();	
			Thread.sleep(2000);			
			commonEvents.switchToFrameByIndex(0, "add Purchase Order Page");            
			commonEvents.sendKeys(iFrameTextEditorByElement, expectedData.get("iframeTextValue"));           
			textValueOfFrameEditor = commonEvents.getText(iFrameTextEditorByElement);
			System.out.println("text value of frame editor : " + textValueOfFrameEditor);           
			commonEvents.switchToDefaultContent();
		}catch(Exception e) {
			throw e;
		}
		return textValueOfFrameEditor;
	}	
}
