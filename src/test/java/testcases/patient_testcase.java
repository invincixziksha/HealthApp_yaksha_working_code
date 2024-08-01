package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import pages.StartupPage;
import pages.appointment_Pages;
import pages.dispensary_Pages;
import pages.operationTheatre_Pages;
import pages.patient_Pages;
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class patient_testcase extends AppTestBase
{
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath + "expected_data.json";
	String loginFilePath = loginDataFilePath + "Login.json";
	StartupPage startupPage;
	LocatorsFactory locatorsFactoryInstance;
	patient_Pages patient_PagesInstance;


	@Parameters({"browser", "environment"})
	@BeforeClass(alwaysRun = true)
	public void initBrowser(String browser, String environment) throws Exception {
		configData = new FileOperations().readJson(config_filePath, environment);
		configData.put("url", configData.get("url").replaceAll("[\\\\]", ""));
		configData.put("browser", browser);

		boolean isValidUrl = new ApiHelper().isValidUrl(configData.get("url"));
		Assert.assertTrue(isValidUrl, configData.get("url")+" might be Server down at this moment. Please try after sometime.");
		initialize(configData);
		startupPage = new StartupPage(driver);
	}

	@Test(priority = 1, groups = {"sanity"}, description="* Navigate to the URL.\r\n"
			+ "* Retrieve Title and URL of the current page.\r\n"
			+ "* Verify Title & URL: Check if the title  & URL matches the expected title.")
	public void verifyTitleOfTheHomePage() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> loginData = new FileOperations().readJson(loginFilePath, "credentials");
		Assert.assertTrue(patient_PagesInstance.loginToHealthAppByGivenValidCredetial(loginData),"Login failed, Invalid credentials ! Please check manually");

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthApp");
		Assert.assertEquals(patient_PagesInstance.verifyTitleOfThePage(),expectedData.get("dasboardTitle")) ;
		Assert.assertEquals(patient_PagesInstance.verifyURLOfThePage(),expectedData.get("homePageUrl")) ;
		Assert.assertTrue(locatorsFactoryInstance.verifyPatientModuleIsPresent(driver).isDisplayed(), "Patient Module is not present in the current page, Please check manually");
	}

	@Test(priority = 2, groups = {"sanity"}, description="Verify that Patient module is present or not ?\r\n"
			+ "If Present, then expand the Patient module\r\n"
			+ "and verify all presence of sub mudules under the patient module.")
	public void verifyAllPresenceOfFieldIfPatientModuleIsPresent() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Assert.assertTrue(patient_PagesInstance.verifyAllPresenceOfFieldIfPatientModuleIsPresent(), "Any of the elememt is not present in pages class, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyPrintIsPresent(driver).isDisplayed(), "Print Button is not present in the Current(Locators) page, Please check manually");
	}

	@Test(priority = 3, groups = {"sanity"}, description="On the \"Patient\" Module's \"Search Patient\" page,\r\n"
			+ "verify & clicking on the \"Search (Minimum 3 Character)\" textbox\r\n"
			+ "and get the Placeholder name of \"Search (Minimum 3 Character)\" textbox.\r\n"
			+ "Then verify the Placeholder name is \"Search (Minimum 3 Character)\".")
	public void verifyPlaceholderNameOfTexbox() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "patientModule");
		Assert.assertEquals(patient_PagesInstance.verifyPlaceholderNameOfTexbox(),expectedData.get("placeholderNameOfSearchTextbox"), "" 
				+ "placeholder is not matching with expected result, Error in Pages Classes, Please check manualy!");
		Assert.assertTrue(locatorsFactoryInstance.verifySearchPatientTextboxIsPresent(driver).isDisplayed(), "" +
				"Search patient" + "Textbox is not present in the current page , Error in locators Classes Please check manually");
	}

	@Test(priority = 4, groups = {"sanity"}, description="On the \"Patient\" Module's,\r\n"
			+ "clicking on \"Register Patient\" sub module\r\n"
			+ "and verify that the \"+ New Photo\" button is present or not ?\r\n"
			+ "After validation of \"+ New Photo\" button,\r\n"
			+ "then click on it.\r\n"
			+ "Then verify \"Take A Snapshot\" button is present or not?")
	public void verifyButtonIsPresent() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Assert.assertTrue(patient_PagesInstance.verifyButtonIsPresent(), "button is not present in current page," + 
				"Error in Pages Classes, Please check manualy!");
		Assert.assertTrue(locatorsFactoryInstance.verifyNewPhotoButtonIsPresent(driver).isDisplayed(), "New Photo Button is not present in the Current page, " + 
				"Error in locators Classes Please check manually");
	}

	@Test(priority = 5, groups = {"sanity"}, description="On the \"Patient\" Module's \"Register Patient\" sub module,\r\n"
			+ "directly clicking the \"Register Patient\" button\r\n"
			+ "from the \"Basic Information\" form\r\n"
			+ "without filling any information\r\n"
			+ "and validate the error message\r\n"
			+ "from \"Phone Number\" textbox from the Besic information form.\r\n"
			+ "Error Message : Primary Phone is required")
	public void verifyErrorMessage() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "patientModule");
		Assert.assertEquals(patient_PagesInstance.verifyErrorMessage(), expectedData.get("errorMessageOfPhonoNumberTextbox"), "" + 
				"Error Message is not present in current page" + "Error in Pages Classes, Please check manualy!") ;
		Assert.assertTrue(locatorsFactoryInstance.verifyErrorMessageOfPhoneNumberTextbox(driver).isDisplayed(), "" + 
				"Error Message is not present in the current page, Error in locators Classes Please check manually");
	}

	@Test(priority = 6, groups = {"sanity"}, description="On the \"Basic Information\" form of  \"Register Patient\" sub module,\r\n"
			+ "Fill the following textbox which are present inside the  \"Basic Information\" form.\r\n"
			+ "Validate the entered values.\r\n"
			+ "Following textboxes are :\r\n"
			+ "-> First Name  Textbox\r\n"
			+ "-> Middle Name Textbox\r\n"
			+ "-> Last Name Textbox\r\n"
			+ "-> Age Textbox\r\n"
			+ "-> Phone Number Textbox\r\n"
			+ "Note : read & write the data from the JSON ")
	public void verifyEnteredDataIsPresentInTextbox() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "patientModule");

		Assert.assertEquals(patient_PagesInstance.verifyTexboxIsPresentAndValidateEnteredValue(expectedData),expectedData.get("firstNameValue"), "" +
				"Element is not present in current page" + "Error in Pages Classes, Please check manualy!") ;
		Assert.assertEquals(locatorsFactoryInstance.verifyValueIsPresentInFirstNameTextbox(),expectedData.get("firstNameValue"), "" +
				"Element is not present in the current page, Error in locators Classes Please check manually") ;
	}

	@Test(priority = 7, groups = {"sanity"}, description="On the \"Basic Information\" form of \"Register Patient\" sub module,\r\n"
			+ "scroll to the buttom of the \"Basic Information\" form.\r\n"
			+ "Then verify the \"Blood Group\" Dropdown is present or not?")
	public void scrollToBottomVerifyFieldAndHighlight() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Assert.assertTrue(patient_PagesInstance.scrollToBottomAndVerifyFieldIsPresent(), "" +
				"blood group dropdown is not present" + "Error in Pages Classes, Please check manualy!");
		Assert.assertTrue(locatorsFactoryInstance.verifyEmailTextboxIsPresent(driver).isDisplayed(), "" +
				"email textbox is not present" + "Error in locators Classes Please check manually");
	}

	@Test(priority = 8, groups = {"sanity"}, description="On the buttom of the \"Basic Information\" form \r\n"
			+ "of \"Register Patient\" sub module,\r\n"
			+ "If \"Blood Group\" Dropdown is present\r\n"
			+ "then highlight the \"Blood Group\" Dropdown")
	public void highlightTheElement() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Assert.assertTrue(patient_PagesInstance.highlightTheElement(), "" +
				"blood group dropdown is not present" + "Error in Pages Classes, Please check manualy!");
		Assert.assertTrue(locatorsFactoryInstance.verifyEmailTextboxIsPresent(driver).isDisplayed(), "" +
				"email textbox is not present" + "Error in locators Classes Please check manually");
	}


	@Test(priority = 9, groups = {"sanity"}, description="On the New Visit\" page's \"Patient Information\" form,\r\n"
			+ "scroll to the  \"Relation With Patient\" dropdown\r\n"
			+ "and then select \"Son\" from the \"Relation With Patient\" dropdown.\r\n"
			+ "validate \"Son\" is  properly selected or not.")
	public void verifyOptionIsSelectedFromDropdown() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "patientModule");

		Assert.assertEquals(patient_PagesInstance.verifyOptionIsSelectedFromDropdown(expectedData), expectedData.get("bloodGroup"), "" +
				"selected option is not matching with expected, Error in Pages Classes, Please check manualy!");
		Assert.assertEquals(locatorsFactoryInstance.verifyBNegetiveBloodGroupOptionIsSelected(), expectedData.get("bloodGroup"), "" +
				"selected option is not matching with expected, Error in locators Classes Please check manually!");
		//		Assert.assertTrue(locatorsFactoryInstance.verifyEmailTextboxIsPresent(driver).isDisplayed(), "" +
		//				"email text box is not present" + "Error in locators Classes Please check manually");
	}

	@Test(priority = 10, groups = {"sanity"}, description="Go to \"Guarantor\" form of \"Register Patient\" sub module,\r\n"
			+ "select the \"Male\" Radio button form the Gender section\r\n"
			+ "Then verify the \"Male\" radio button is selected or not.\r\n"
			+ "After validation, then deselect the \"Male\" radio button")
	public void verifyRadioButton() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Assert.assertTrue(patient_PagesInstance.verifyRadioButton(), "" + 
				"radio button is not present" + "Error in Pages Classes, Please check manualy!");
		Assert.assertTrue(locatorsFactoryInstance.verifyFemaleRadioButtonIsSelected(), "" +
				"female radio button is not selected" + "Error in locators Classes Please check manually");
	}

	@Test(priority = 11, groups = {"sanity"}, description="On the \"Guarantor\" form of \"Register Patient\" sub module,\r\n"
			+ "select the \"Self\" check box \r\n"
			+ "and verify that, the \"Self\" check box is selected or not.\r\n"
			+ "After selected the \"Self\" check box\r\n"
			+ "a \"Notification\" popup message will display on the button of the page\r\n"
			+ "and then validate that Notification Popup Message \r\n"
			+ "(Notice-Message\r\n"
			+ "To fill the data by self checkbox, first you have to fill your address )")
	public void verifyNotificationPopupMessageIfCheckboxIsSelected() throws Exception {

		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "patientModule");

		Assert.assertEquals(patient_PagesInstance.verifyNotificationPopupMessageIfCheckboxIsSelected(),expectedData.get("NotificationPopupMessage")) ;
		//		Assert.assertEquals(locatorsFactoryInstance.verifyErrorNotificationPopupMessageIsPresent(),expectedData.get("NotificationPopupMessage")) ;
	}

	@Test(priority = 12, groups = {"sanity"}, description="On the \"Guarantor\" form of \"Register Patient\" sub module,\r\n"
			+ "Click on \"Kin/Emergency Contact\" link\r\n"
			+ "by using javascript\r\n"
			+ "and it will navigate to the \"Kin/Emergency Contact\" form.\r\n"
			+ "Then send the value by using javascript to the \"Commnets\" textbox\r\n"
			+ "of \"Kin/Emergency Contact\" form.")
	public void performJavaScriptOperation() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "patientModule");

		Assert.assertEquals(patient_PagesInstance.performJavaScriptOperation(expectedData),expectedData.get("comments"), "" +
				"value is not present" + "Error in Pages Classes, Please check manualy!") ;
		Assert.assertEquals(locatorsFactoryInstance.verifyCommentsTextboxValueIsPresent(),expectedData.get("comments"), "" +
				"value is not present in comments box" + "Error in locators Classes Please check manually") ;
	}

	@Test(priority = 13, groups = {"sanity"}, description="On the \"Kin/Emergency Contact\" form of \"Register Patient\" sub module,\r\n"
			+ "clicking and verify the \"Kin/Emergency Contact\" link\r\n"
			+ "text is present or not using Hard Assert?")
	public void verifyTextIsPresentUsingHardAssert() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "patientModule");

		Assert.assertEquals(patient_PagesInstance.verifyTextIsPresentUsingHardAssert(expectedData),expectedData.get("kinEmergencyContactLinkTextValue"), "" +
				"text is not present" + "Error in Pages Classes, Please check manualy!") ;
		Assert.assertEquals(locatorsFactoryInstance.verifyTextIsPresent(),expectedData.get("kinEmergencyContactLinkTextValue"), "" +
				"text is not present" + "Error in locators Classes Please check manually") ;
	}

	@Test(priority = 14, groups = {"sanity"}, description="On the Patient Module's \"Search Patient\" sub module,\r\n"
			+ "scroll to the buttom of the \"Search Patient\" page.\r\n"
			+ "Then clicking on \"Last\" button of \"Search Patient\" table,\r\n"
			+ "it will take to you the last pegination\r\n"
			+ "and then retrive the first Patient Name for given \"Hospital Number : 2311000001 \".\r\n"
			+ "Then verify the Patient Name is : Alexa Alexa")
	public void getDataFromTable() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "patientModule");
		Assert.assertEquals(patient_PagesInstance.getDataFromTable(), expectedData.get("patientName"), "" + 
				"unable to handle the table data" + "Error in Pages Classes, Please check manualy!");
		Assert.assertEquals(locatorsFactoryInstance.veryfyFirstPatientName(),expectedData.get("patientName"), "" + 
				"unable to handle the table data" + "Error in Locators Classes, Please check manualy!");
	}

	@Test(priority = 15, groups = {"sanity"}, description="Scroll to the Vaccination Module's and Expand it.\r\n"
			+ "Click on \"Patient List\" page and\r\n"
			+ "perform the keyboard operation (\"Alt + N\") to open the \"Vaccination Patient Register\" form.\r\n"
			+ "Then Validate the \"Vaccination Patient Register\" page Name.")
	public void performKeyboardOperation() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "patientModule");
		Assert.assertEquals(patient_PagesInstance.performKeyboardOperation(), expectedData.get("titleNameOfVaccinationPatientRegisterForm"), "" +
				"Vaccination Patient Register Form is not present" + "Error in Pages Classes, Please check manualy!");
		Assert.assertEquals(locatorsFactoryInstance.verifyTitleNameOfVaccinationPatientRegisterFormIsPresent(),expectedData.get("titleNameOfVaccinationPatientRegisterForm"), "" + 
				"Vaccination Patient Register Form is not present" + "Error in Locators Classes, Please check manualy!");
	}

	@Test(priority = 16, groups = {"sanity"}, description="On the \"Patient\" module's \"Register Patient\" Sub module,\r\n"
			+ "Upload the Profile Picture in \"Camera/Profile Picture\" form.")
	public void uploadImageInScannedImagesSection() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		Assert.assertTrue(patient_PagesInstance.fileUploadOperation(System.getProperty("user.dir") + "\\testImage\\uploadImage.png"), "" +
				"Not able to upload the image" + "Error in Pages Classes, Please check manualy!");
		Assert.assertTrue(locatorsFactoryInstance.verifyUploadDoneButtonIsPresent(driver).isDisplayed(), "" + 
				"Done button is not present" + "Error in Locators Classes, Please check manualy!");
	}

	@Test(priority = 17, groups = {"sanity"}, description="On the Camera/Profile Picture\" form's of \"Register Patient\" Sub module,\r\n"
			+ "Taking screenshot of the current page.")
	public void takingScreenshotOfCurrentPage() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		Assert.assertTrue(patient_PagesInstance.takingScreenshotOfTheCurrentPage(), "" + 
				"Not able to take the screenshot" + "Error in Pages Classes, Please check manualy!");
		Assert.assertTrue(locatorsFactoryInstance.verifyCropButtonIsPresent(driver).isDisplayed(),"" + 
				"Crop button is not present" + "Error in Locators Classes, Please check manualy!");
	}

	@Test(priority = 18, groups = {"sanity"}, description="On the \"Camera/Profile Picture\" form's of \"Register Patient\" Sub module,\r\n"
			+ "select \"Emergency Contact\" checkbox from the  \"Kin/Emergency Contact\" form.\r\n"
			+ "When user trying to clicking on  \"Insurance\" Link then an alert will popups. \r\n"
			+ "Then handle alert popup and verify alert Message :\r\n"
			+ "This page contains unsaved changes.\r\n"
			+ "Do you want to continue ? Changes will be discarded.\r\n"
			+ "Then verify that the \"Add Insurance\" button is present or not")
	public void  handleAlertPopup() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		Assert.assertTrue(patient_PagesInstance.handleAlertPopup(), "" + 
				"Not able to handle alert popup" + "Error in Pages Classes, Please check manualy!");
		Assert.assertTrue(locatorsFactoryInstance.verifyAddInsuranceButtonIsPresent(driver).isDisplayed(),"" + 
				"Add Insurance Button is not present" + "Error in Locators Classes, Please check manualy!");
	}

	@Test(priority = 19, groups = {"sanity"}, description="On the Appointment module, under the\"New visit\" tab,\r\n"
			+ "verify tooltips which is present on keyboard icon.")
	public void  verifyTooltipOfAnElement() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "KeyBoardTooltip");
		Assert.assertEquals(patient_PagesInstance.verifyToolTipOfAnElement(), expectedData.get("newPatientTooltipValue"), "" +
				"Not able to handle tooltips" + "Error in Pages Classes, Please check manualy!");
		Assert.assertTrue(locatorsFactoryInstance.tooltipTextIsPresent(driver).isDisplayed(), "" + 
				"tooltips message is not present" + "Error in Locators Classes, Please check manualy!");
	}

	@Test(priority = 20, groups = {"sanity"}, description="On the Procurement module's Reports Tab,\r\n"
			+ "Search for a Select a Item as Accounts \r\n"
			+ "and select Accounts  and validate Accounts is selected or not ?")
	public void handleAutoSuggesstion() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "ProcurementModule");
		Assert.assertTrue(patient_PagesInstance.handleAutoSuggesstion(expectedData), "" +
				"unable to handle Auto Suggesstion" + "Error in Pages Classes, Please check manualy!");
		Assert.assertTrue(locatorsFactoryInstance.accountOptionIsSelected(driver).isDisplayed(), "" +
				"option Account is not selected" + "Error in Locators Classes, Please check manualy!");
	}

	@Test(priority = 21, groups = {"sanity"}, description="Expand the Procurement module\r\n"
			+ "and click on \"Purchase Order\" submodule.\r\n"
			+ "Then click on \"Create Purchase order\" button \r\n"
			+ "and validate the \"Add Purchase Order\" page name.\r\n"
			+ "On the \"Add Purchase Order\" page,\r\n"
			+ "Scroll to the button of the page\r\n"
			+ "then send the value ( using javascript ) to the \"Select Terms & Conditions:\" Frame\r\n"
			+ "by handling frames.")
	public void handleIframe() throws Exception {
		patient_PagesInstance = new patient_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "patientModule");
		Assert.assertEquals(patient_PagesInstance.handleIframe(expectedData), expectedData.get("iframeTextValue"),"" +
				"unable to handle iframe" + "Error in Pages Classes, Please check manualy!");
		Assert.assertTrue(locatorsFactoryInstance.verifyDiscardButtonIsPresent(driver).isDisplayed(),"" + 
				"discard button is not present" + "Error in Locators Classes, Please check manualy!");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("before closing the browser");
		browserTearDown();
	}

	@AfterMethod
	public void retryIfTestFails() throws Exception {
		startupPage.navigateToUrl(configData.get("url"));
	}
}
