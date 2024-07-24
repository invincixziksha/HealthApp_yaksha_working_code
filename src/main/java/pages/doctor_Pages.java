package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class doctor_Pages extends StartupPage {

	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");
	By doctorTab = By.xpath("//span[.='Doctor']");
	By doctorToggle = By.xpath("//span[@data-target='#Doctor']");	
	By outPatientSubModule = By.xpath("//span[.='Out Patient']");	
	By inPatientDepartmentSubModule = By.xpath("//span[.='In Patient Department']");	
	By patientRecordSubModule = By.xpath("//span[.='Patient Record']");	
	By showDoctorWisePatientListCheckBox = By.id("showDoctorWisePatients");	
	By departmentFilterDropdown = By.id("departmentlist");	
	By neurosurgeryOption = By.xpath("//select//option[.='NEUROSURGERY']");	
	By myFavoritesButton = By.xpath("//a[.=' My Favorites']");	
	By pendingListButton = By.xpath("//a[.=' Pending List']");	
	By showDetailsButton = By.xpath("(//a[contains(text(),'Show Details')])[1]");	
	By freeTextTemplatePageTitle = By.xpath("//div[.=' Free Text Template ']");	
	By XbuttonInFreeTextTemplate = By.xpath("//i[.='X']");
	By doctorNameWhereHospitalNumberIs2312000010 = By.xpath("//div[.='Dr. Amit Shah']");
	By previewIcon = By.xpath("//a[@title='Preview']");
	By problemsModule = By.xpath("//a[.='Problems']");
	By surgicalHistoryTab = By.xpath("//a[.='Surgical History']");
	By addNewButton = By.xpath("//a[.=' Add New ']");
	By addButton = By.xpath("//input[@name='name']");
	By searchProblemFieldErrorMessage = By.xpath("//span[.=' Select ICD-11 Code ']");
	By dischargeSummaryModule = By.xpath("//a[.='Discharge Summary']");
	By saveButton = By.xpath("(//input[@value='Save'])[2]");
	By hospitalCourseTextArea = By.xpath("//textarea[@placeholder='Hospital Course']");
	By treatmentDuringHospitalStayTextArea = By.xpath("//textarea[@placeholder='Treatment during hospital stay']");
	By conditionOnDischargeTextArea = By.xpath("//textarea[@placeholder='Condition']");
	By yesRadioButton = By.id("IsReportWithResultYes");
	By noRadioButton = By.id("IsReportWithResultNo");
	By xButton = By.xpath("//a[.='X']");
	By pendingReportsTextArea = By.xpath("//textarea[@placeholder='Pending Reports']");
	By popupErrorMessage = By.xpath("//p[.='Enter Manditory fields']");

	//l2 scenarios of Doctor module

	//file upload elements
	By scannedImageSubModule = By.xpath("//a[contains(text(), 'Scanned Images')]");
	By chooseFileButton = By.xpath("//input[@type='file']");
	By uploadButton = By.xpath("//input[@value='Upload']");

	// take a screenshot
	By homeIconByElement = By.xpath("//a[contains(text(), 'Home')]");
	By outPatientMenuByElement = By.xpath("//a[contains(text(),'Out Patient')]");

	// keyboard
	By vaccinationModuleByElement = By.xpath("//a[@href='#/Vaccination']");
	By vaccinationModulesToggleIconByElement = By.xpath("//span[@data-target='#Vaccination']");
	By patientListSubModuleByElement = By.xpath("//a[@href='#/Vaccination/PatientList']//span[contains(text(), 'Patient List')]");
	By titleNameOfVaccinationPatientRegisterFormByElement = By.xpath("//span[contains(text(), 'Vaccination Patient Register')]");

	// tool tip
	By appointmentModule = By.xpath("(//span[.='Appointment'])[1]");
	By newOneSelectCounterElement = By.xpath("//div[@class='counter-item']//h5[contains(text(), 'New-1 ')]");
	By keyboardButtonElement = By.xpath("//div[@title='Shortcut Keys']");
	By altPlusNtooltipMessageElement = By.xpath("//li[contains(text(),'+')]");
	By newOneCounterLinkByElement = By.xpath("//h5[contains(text(), 'New-1')]//span");

	By membershipDropdownByElement = By.xpath("//select[@id='Scheme']");
	By newPatientButtonLinkByElement = By.xpath("//button[@id='btnNewPatient']");
	By patientInformationTextByElement = By.xpath("//h4[contains(text(), 'Patient Information')]");

	By procurementModule = By.xpath("//span[.='Procurement']");
	By settingsTab = By.xpath("//a[.=' Settings ']");
	By reportsSubButton = By.xpath("//a[.=' Reports ']");
	By currentStockLevelButton = By.xpath("//i[.='Current Stock Level']");
	By selectedItemDropdown = By.xpath("//div[@class='selected-list']");
	By selectItemSearchBar = By.xpath("//input[@placeholder='Search']");
	By accountsItemCheckBox = By.xpath("//label[.='Accounts']");
	By generalInventoryOption = By.xpath("//span[@class='fa fa-remove']");
	By accountOption = By.xpath("//span[.='Accounts']");








	String pageName = this.getClass().getSimpleName();
	public doctor_Pages(WebDriver driver) {
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
			WebElement usernametextFieldWebElement = commonEvents.findElement(usernameTextbox);
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(usernameTextbox,expectedData.get("username"));

			WebElement passwordtextFieldWebElement = commonEvents.findElement(passwordTextbox);
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));

			WebElement signinButtonWebElement = commonEvents.findElement(signInButton);
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.click(signInButton);

			if(commonEvents.isDisplayed(doctorTab))
			{   
				WebElement doctorTabWebElement = commonEvents.findElement(doctorTab);
				commonEvents.highlightElement(doctorTabWebElement);
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
	 * about this method verifyAllSubModulesArePresentAndClickOnDispensary() 
	 * @param : null
	 * @description : Verify that Doctor module is present or not ,If Present then expand the Doctor module and verify all presence of sub mudules under the Doctor module
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyAllSubModulesArePresentAndClickOnDispensary() throws Exception {
		boolean allSubModulesAreDisplayed = false;
		try {
			if(commonEvents.isDisplayed(doctorTab)){
				commonEvents.jsClick(doctorToggle);
				commonEvents.isDisplayed(outPatientSubModule);				
				commonEvents.isDisplayed(inPatientDepartmentSubModule);
				commonEvents.isDisplayed(patientRecordSubModule);
				allSubModulesAreDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return allSubModulesAreDisplayed;
	}


	/**@Test3
	 * about this method tickOnCheckBoxValidateTheCheckBoxThenUntick() 
	 * @param : null
	 * @description : On the Doctor Module's "Out Patient" Sub module, select the "Show Doctor Wise Patient List" check box and verify that is "Show Doctor Wise Patient List" check box is selected or not?
                      After validation, uncheck the "Show Doctor Wise Patient List" check box.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean tickOnCheckBoxValidateTheCheckBoxThenUntick() throws Exception {
		boolean checkBoxIsDisplayed = false;
		try {
			if(commonEvents.isDisplayed(showDoctorWisePatientListCheckBox)) {
				commonEvents.click(showDoctorWisePatientListCheckBox);
				Thread.sleep(3000);
				commonEvents.isSelected(showDoctorWisePatientListCheckBox);
				commonEvents.click(showDoctorWisePatientListCheckBox);
				checkBoxIsDisplayed=true;
			}

		}catch(Exception e) {
			throw e;
		}	
		return checkBoxIsDisplayed;
	}

	/**@Test4
	 * about this method selectNEUROSURGERYFromDepartmentDropdownAndVerifySelection() 
	 * @param : get the data from JSON file as type Map<String, String> expectedData
	 * @description : it will select the country as per JSON expected data
	 * @return : String
	 * @author : YAKSHA
	 */
	public String selectNEUROSURGERYFromDepartmentDropdownAndVerifySelection(Map<String, String> expectedData) throws Exception {

		String selectedOption = "" ;

		try {
			commonEvents.click(inPatientDepartmentSubModule);
			commonEvents.selectByVisibleText(departmentFilterDropdown, expectedData.get("departmentName"));
			selectedOption = commonEvents.getFirstSelectedOptionFromDropdown(departmentFilterDropdown, "elementName", "pageName");
			System.out.println("first selected option from dropdown : " + selectedOption );
			return selectedOption;
		}catch(Exception e) {
			throw e;
		}	
	}


	/**@Test5
	 * about this method verifyMyFavoritesAndPendingListButtonsArePresent() 
	 * @param : null
	 * @description : On the Doctor Module's "In Patient Department" Sub-Module, verify that "My Favorites" and "Pending List" buttons are present inside the 
                     "In Patient Department" Page
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyMyFavoritesAndPendingListButtonsArePresent() throws Exception {
		boolean buttonsAreDisplayed = false;
		try {
			if(commonEvents.isDisplayed(myFavoritesButton) &&
					commonEvents.isDisplayed(pendingListButton)) {
				buttonsAreDisplayed=true;
			}

		}catch(Exception e) {
			throw e;
		}	
		return buttonsAreDisplayed;
	}


	/**@Test6
	 * about this method validateTheTitleNameOfTheFreeTextTemplateForm() 
	 * @param : null
	 * @description : On the Doctor Module's "In Patient Department" Sub-Module, clicking on "Pending List" buttons and it opens pending table record.
                      Then click on "Show Details" from the first table record and it open the "Free Text Template" form. Then validate the title name of the  "Free Text Template" form
	 * @return : String
	 * @author : Yaksha
	 */
	public String validateTheTitleNameOfTheFreeTextTemplateForm() throws Exception {
		String pageName = "";
		try {
			commonEvents.click(pendingListButton);
			commonEvents.click(showDetailsButton);
			Thread.sleep(3000);
			pageName=commonEvents.getText(freeTextTemplatePageTitle);
			System.out.println("Free Text Template PageTitle is :" + pageName);
			Thread.sleep(3000);
		}catch(Exception e) {
			throw e;
		}	
		return pageName;
	}


	/**@Test7
	 * about this method validateTheDoctorName() 
	 * @param : null
	 * @description : On the Doctor Module's "In Patient Department" Sub-Module, a table record pre display which is filter by department as  "NEUROSURGERY".
                      Then get the "Doctor Name" where the "Hospital Number" is "2312000010".
                      Then Validate the Doctor Name is Dr. Amit Shah
	 * @return : String
	 * @author : Yaksha
	 */
	public String validateTheDoctorName() throws Exception {
		String doctorName = "";
		try {
			commonEvents.click(XbuttonInFreeTextTemplate);
			commonEvents.click(pendingListButton);
			Thread.sleep(3000);
			doctorName=commonEvents.getText(doctorNameWhereHospitalNumberIs2312000010);
			System.out.println("Doctor Name Where Hospital Number Is 2312000010 :" + doctorName);
		}catch(Exception e) {
			throw e;
		}	
		return doctorName;
	}


	/**@Test8
	 * about this method verifyTheErrorMessageInSearchProblemField() 
	 * @param : null
	 * @description : On the "Surgical History" Menu Tab of Problem module of the Profile "Sonia Gandhi", clicking on the "+Add New" button from Surgical History List and it will open a "Add Surgical History" form.
                      Then click on "Add" button of "Add Surgical History" form directly without filling any information, it will throw an error message in "Search Problem*" field. 
                      Then Validate that Error Message : Select ICD-11 Code
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyTheErrorMessageInSearchProblemField() throws Exception {
		String errorMessage = "";
		try {
			Thread.sleep(5000);
			commonEvents.jsClick(previewIcon);
			commonEvents.jsClick(problemsModule);
			commonEvents.jsClick(surgicalHistoryTab);
			commonEvents.jsClick(addNewButton);
			commonEvents.jsClick(addButton);
			Thread.sleep(3000);
			errorMessage=commonEvents.getText(searchProblemFieldErrorMessage);
			System.out.println("Search Problem Field Error Message is :" + errorMessage);
		}catch(Exception e) {
			throw e;
		}	
		return errorMessage;
	}


	/**@Test9
	 * about this method performScrollingOpertaionAndVerifyTheSaveButtonIsPresent() 
	 * @param : null
	 * @description : On the Profile "Sonia Gandhi", Scroll to the "Discharge Summary" Module which is present in the left navigation.
                      Click on "Discharge Summary" and it will navigate to the "DischargeSummary" page.
                      Then scroll to the buttom of the page and verify that the "Save" button is present or not.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean performScrollingOpertaionAndVerifyTheSaveButtonIsPresent() throws Exception {
		boolean buttonIsDisplayed = false;
		try {
			WebElement dischargeSummaryModuleWebElement=commonEvents.findElement(dischargeSummaryModule);
			commonEvents.scrollIntoView(dischargeSummaryModuleWebElement);
			commonEvents.click(dischargeSummaryModule);
			Thread.sleep(3000);
			commonEvents.jsScrollToBottomOfThePage();
			Thread.sleep(3000);
			if(commonEvents.isDisplayed(saveButton)) {
				buttonIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return buttonIsDisplayed;
	}


	/**@Test10
	 * about this method highlightElementInYellowColour() 
	 * @param : null
	 * @description : On the buttom of the "Discharge Summary" page of Profile "Sonia Gandhi", verify that the "Hospital Course" text area is present or not?
                      If Present, then highlight the "Hospital Course" text area as color yellow 
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean highlightElementInYellowColour() throws Exception {
		boolean buttonIsDisplayed = false;
		try {
			if(commonEvents.isDisplayed(hospitalCourseTextArea)) {
				WebElement hospitalCourseTextAreaWebElement=commonEvents.findElement(hospitalCourseTextArea);
				commonEvents.highlightElementInYellow(hospitalCourseTextAreaWebElement);
				buttonIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return buttonIsDisplayed;
	}


	/**@Test11
	 * about this method verifyThePlaceHolderNameOfTreatmentDuringHospitalStayTextarea() 
	 * @param : null
	 * @description : On the "Discharge Summary" page of Profile "Sonia Gandhi", verify that, "Treatment During Hospital Stay" textarea is present or not?
                      If Present, then get the placeholdername of "Treatment During Hospital Stay" textarea and Validate that placeholdername.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyThePlaceHolderNameOfTreatmentDuringHospitalStayTextarea() throws Exception {
		String placeHolderValue = "";
		try {
			WebElement treatmentDuringHospitalStayTextAreaWebElement=commonEvents.findElement(treatmentDuringHospitalStayTextArea);
			commonEvents.scrollIntoView(treatmentDuringHospitalStayTextAreaWebElement);
			commonEvents.isDisplayed(treatmentDuringHospitalStayTextArea);
			placeHolderValue = commonEvents.getAttribute(treatmentDuringHospitalStayTextArea,"placeholder");
			System.out.println("Place holder value of Address field : " + placeHolderValue);

		}catch(Exception e) {
			throw e;
		}	
		return placeHolderValue;
	}



	/**@Test12
	 * about this method validateTheEnteredValueInConditionOnDischargeTextarea() 
	 * @param : Map<String, String>
	 * @description : On the "Discharge Summary" page of Profile "Sonia Gandhi", verify that, "Condition On Discharge" textarea is present or not?
                      If present, then send the value to the "Condition On Discharge" textarea. 
                      Then validate the entered value.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String validateTheEnteredValueInConditionOnDischargeTextarea(Map<String, String> expectedData) throws Exception {
		String ConditionOnDischargeTextareaValue= "";
		try {
			if(commonEvents.isDisplayed(conditionOnDischargeTextArea))
			{
				commonEvents.jsClick(conditionOnDischargeTextArea);
				Thread.sleep(3000);
				commonEvents.sendKeys(conditionOnDischargeTextArea,expectedData.get("conditionOnDischargeFieldData"));
				Thread.sleep(3000);
				ConditionOnDischargeTextareaValue = commonEvents.getAttribute(conditionOnDischargeTextArea, "value");
				System.out.println("Condition On Discharge TextArea value is : " + ConditionOnDischargeTextareaValue);
				Thread.sleep(3000);
			}
		}catch(Exception e) {
			throw e;
		}
		return ConditionOnDischargeTextareaValue;
	}

	/**@Test13
	 * about this method verifyThatTheYesRadioButtonIsSelectedAndDeselect() 
	 * @param : null
	 * @description : On the "Discharge Summary" page of Profile "Sonia Gandhi", select "Yes" radio button from the "Show Result on Report" label and then verify that the "Yes" radio button is selected or not.
                      After validation, then deselect the "Yes" radio button from the "Show Result on Report" label 
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyThatTheYesRadioButtonIsSelectedAndDeselect() throws Exception {
		boolean radioButtonIsDisplayed = false;
		try {
			if(commonEvents.isDisplayed(yesRadioButton)) {
				commonEvents.jsClick(yesRadioButton);
				commonEvents.jsClick(xButton);
				commonEvents.isSelected(yesRadioButton);
				commonEvents.jsClick(noRadioButton);
				radioButtonIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return radioButtonIsDisplayed;
	}

	/**@Test14
	 * about this method clickAndSendValueToThePendingReportsTextAreaUsingJavaScript() 
	 * @param : Map<String, String>
	 * @description : On the "Discharge Summary" page of Profile "Sonia Gandhi", verify that the "Pending Reports" text area is present or not?
                      If Present, then click & send value to the "Pending Reports" text area using the JavaScript
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean clickAndSendValueToThePendingReportsTextAreaUsingJavaScript(Map<String, String> expectedData) throws Exception {
		boolean pendingReportsTextAreaIsDisplayed = false;
		try {
			if(commonEvents.isDisplayed(pendingReportsTextArea)) {
				commonEvents.jsClick(pendingReportsTextArea);
				commonEvents.jsSendKeys(pendingReportsTextArea, expectedData.get("pendingReportsTextFieldData"));
				pendingReportsTextAreaIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return pendingReportsTextAreaIsDisplayed;
	}

	/**@Test15
	 * about this method verifyTheNotificationPopupErrorMessageAfterClickOnSaveButton() 
	 * @param : null
	 * @description : On the "Discharge Summary" page of Profile "Sonia Gandhi", verify that the "Save" button is present or not?
                      If present, then click on the save button directly without fill any information and it will throw a notification popup error message.
                      Then validate that  notification popup error message 
                      Failed
                      Enter Manditory fields
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyTheNotificationPopupErrorMessageAfterClickOnSaveButton() throws Exception {
		String popupErrorMessageText = "";
		try {
			commonEvents.click(saveButton);
			Thread.sleep(3000);
			popupErrorMessageText=commonEvents.getText(popupErrorMessage);
			System.out.println("Search Problem Field Error Message is :" + popupErrorMessageText);
		}catch(Exception e) {
			throw e;
		}	
		return popupErrorMessageText;
	}

	/**@Test16
	 * about this method handleFileUpload() 
	 * @param : Map<String, String>
	 * @description : Upload a image in Scanned Images section.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean handleFileUpload(String pathOfTheFile) throws Exception {
		boolean isUploaded = false;
		try {
			commonEvents.waitTillElementLocated(scannedImageSubModule, 10);
			commonEvents.jsClick(scannedImageSubModule);

			commonEvents.waitTillElementLocated(chooseFileButton, 10);
			commonEvents.jsClick(chooseFileButton);
			System.out.println("path of the file" + pathOfTheFile );
			Thread.sleep(5000);
			commonEvents.fileUpload(pathOfTheFile);
			Thread.sleep(3000);
			commonEvents.jsClick(uploadButton);
			Thread.sleep(5000);
			isUploaded = true;
		}catch(Exception e) {
			throw e;
		}
		return isUploaded;
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
		try {
			commonEvents.jsClick(homeIconByElement);
			commonEvents.waitTillElementLocated(outPatientMenuByElement, 10);
			if(commonEvents.isDisplayed(outPatientMenuByElement)) {
				commonEvents.takeScreenshot("Out patient page");
				isDisplayed = true;
			}
		}catch(Exception e) {
			throw e;
		}
		return isDisplayed;
	}

	/**@Test18
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

	/**@Test19
	 * about this method verifyToolTipOfAnElement()
	 * @param : null
	 * @description :go to appointmentTab and verify the TOOLTIP value/text
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyToolTipOfAnElement() throws Exception {
		String tooltipText = "";
		try {
			commonEvents.jsScrollPageTillElementVisible(appointmentModule, "appointmentModule", "appointmentModule");
			commonEvents.jsClick(appointmentModule);
			Thread.sleep(2000);
			commonEvents.jsClick(newOneCounterLinkByElement);
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

	/**@Test21
	 * about this method handleAutoSuggesstion() 
	 * @param : Map<String, String>
	 * @description : Search for a Select Item as Accounts and select Accounts  and validate Accounts is selected.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean handleAutoSuggesstion(Map<String, String> expectedData) throws Exception {
		boolean accountOptionisDisplayed = false;
		try {
			commonEvents.waitTillElementLocated(procurementModule, 10);
			commonEvents.jsClick(procurementModule);

			commonEvents.waitTillElementLocated(reportsSubButton, 10);
			commonEvents.jsClick(reportsSubButton);

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
}
