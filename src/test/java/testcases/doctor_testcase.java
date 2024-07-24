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
import pages.doctor_Pages;
import pages.operationTheatre_Pages;
import pages.socialService_Pages;
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class doctor_testcase extends AppTestBase
{
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath + "expected_data.json";
	String loginFilePath = loginDataFilePath + "Login.json";
	StartupPage startupPage;
	doctor_Pages doctor_PagesInstance;
	LocatorsFactory locatorsFactoryInstance;


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

	@Test(priority = 1, groups = {"sanity"}, description="Verify Title & URL: Check if the title  & URL matches the expected title")
	public void verifyTitleOfTheHomePage() throws Exception {

		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> loginData = new FileOperations().readJson(loginFilePath, "credentials");
		Assert.assertTrue(doctor_PagesInstance.loginToHealthAppByGivenValidCredetial(loginData),"Login failed, Invalid credentials ! Please check manually");

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthApp");
		Assert.assertEquals(doctor_PagesInstance.verifyTitleOfThePage(),expectedData.get("dasboardTitle")) ;
		Assert.assertEquals(doctor_PagesInstance.verifyURLOfThePage(),expectedData.get("homePageUrl")) ;
		Assert.assertTrue(locatorsFactoryInstance.verifyDoctorModuleIsPresent(driver).isDisplayed(), "doctors text is not present in the current page, Please check manually");
	}

	@Test(priority = 2, groups = {"sanity"}, description="Verify that Doctor module is present or not ,If Present then expand the Doctor module and verify all presence of sub mudules under the Doctor module")
	public void verifyAllSubModulesArePresent() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(doctor_PagesInstance.verifyAllSubModulesArePresentAndClickOnDispensary(), "Any of the module is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.outPatientTabIsPresent(driver).isDisplayed(), "Out Patient Tab is not present in the current page, Please check manually");
	}

	@Test(priority = 3, groups = {"sanity"}, description="On the Doctor Module's \"Out Patient\" Sub module, select the \"Show Doctor Wise Patient List\" check box and verify that is \"Show Doctor Wise Patient List\" check box is selected or not? After validation, uncheck the \"Show Doctor Wise Patient List\" check box")
	public void validateTheCheckBox() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(doctor_PagesInstance.tickOnCheckBoxValidateTheCheckBoxThenUntick(), "Show Doctor Wise Patient List CheckBox is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.showDoctorWisePatientListCheckBoxIsPresent(driver).isDisplayed(), "Show Doctor Wise Patient List CheckBox is not selected in the current page, Please check manually");
	}

	@Test(priority = 4, groups = {"sanity"}, description="On the Doctor Module's \"In Patient Department\" Sub-Module,\r\n"
			+ "verify that \"Department filter\" dropdown is Present.\r\n"
			+ "If present, then select the \"NEUROSURGERY\"\r\n"
			+ "from the \"Department filter\" dropdown and \r\n"
			+ "validate  \"NEUROSURGERY\" is selected or not?")
	public void selectNEUROSURGERYFromDepartmentDropdownAndVerifySelection() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "DoctotModule");
		Assert.assertEquals(doctor_PagesInstance.selectNEUROSURGERYFromDepartmentDropdownAndVerifySelection(expectedData), expectedData.get("departmentName"), "selected option is not matching with expected in page class, please check manually!");
		Assert.assertEquals(locatorsFactoryInstance.verifyNEUROSURGERYIsSelected(), expectedData.get("departmentName"), "selected country is not matching with expected in locator class, please check manually!");
	}


	@Test(priority = 5, groups = {"sanity"}, description="On the Doctor Module's \"In Patient Department\" Sub-Module, verify that \"My Favorites\" and \"Pending List\" buttons are present inside the \r\n"
			+ "\"In Patient Department\" Page")
	public void verifyTheButtonsArePresentOrNot() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(doctor_PagesInstance.verifyMyFavoritesAndPendingListButtonsArePresent(), "Any of the module is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.myFavoritesButtonIsPresent(driver).isDisplayed(), "My Favorites Button is not displayed in this currentpage, Please check manually");
	}


	@Test(priority = 6, groups = {"sanity"}, description="On the Doctor Module's \"In Patient Department\" Sub-Module, clicking on \"Pending List\" buttons and it opens pending table record.\r\n"
			+ "Then click on \"Show Details\" from the first table record and it open the \"Free Text Template\" form. Then validate the title name of the  \"Free Text Template\" form")
	public void verifyTitleOfTheForm() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "PageTitle");
		Assert.assertEquals(doctor_PagesInstance.validateTheTitleNameOfTheFreeTextTemplateForm(),expectedData.get("freeTextTemplatePageTitle")) ;
		Assert.assertTrue(locatorsFactoryInstance.patientNameFieldIsPresent(driver).isDisplayed(), "Patient Name Field is not present in the current page, Please check manually");
	}


	@Test(priority = 7, groups = {"sanity"}, description="On the Doctor Module's \"In Patient Department\" Sub-Module, a table record pre display which is filter by department as  \"NEUROSURGERY\".\r\n"
			+ "Then get the \"Doctor Name\" where the \"Hospital Number\" is \"2312000010\".\r\n"
			+ "Then Validate the Doctor Name is Dr. Amit Shah")
	public void verifyTheName() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "DoctorName");
		Assert.assertEquals(doctor_PagesInstance.validateTheDoctorName(),expectedData.get("doctorNameWhereHospitalNumberIs2312000010"),"Doctor name is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.doctorNameIsPresent(driver).isDisplayed(), "Doctor name is not present in the current page, Please check manually");
	}

	@Test(priority = 8, groups = {"sanity"}, description="On the \"Surgical History\" Menu Tab of Problem module of the Profile \"Sonia Gandhi\", clicking on the \"+Add New\" button from Surgical History List and it will open a \"Add Surgical History\" form.\r\n"
			+ "Then click on \"Add\" button of \"Add Surgical History\" form directly without filling any information, it will throw an error message in \"Search Problem*\" field. \r\n"
			+ "Then Validate that Error Message : Select ICD-11 Code")
	public void verifyTheErrorMessage() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthAppErrorMessages");
		Assert.assertEquals(doctor_PagesInstance.verifyTheErrorMessageInSearchProblemField(),expectedData.get("searchProblemFieldErrorMessage"),"Error message is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.searchProblemFieldErrorMessageIsPresent(driver).isDisplayed(), "Error message is not present in the current page, Please check manually");
	}


	@Test(priority = 9, groups = {"sanity"}, description="On the Profile \"Sonia Gandhi\", Scroll to the \"Discharge Summary\" Module which is present in the left navigation.\r\n"
			+ "Click on \"Discharge Summary\" and it will navigate to the \"DischargeSummary\" page.\r\n"
			+ "Then scroll to the buttom of the page and verify that the \"Save\" button is present or not.")
	public void performScrollingOpertaionAndVerifyThePresenceOfButton() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(doctor_PagesInstance.performScrollingOpertaionAndVerifyTheSaveButtonIsPresent(), "Save button is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.saveButtonInsideIpdPageIsPresent(driver).isDisplayed(), "Save button is not present, please check manually");
	}

	@Test(priority = 10, groups = {"sanity"}, description="On the buttom of the \"Discharge Summary\" page of Profile \"Sonia Gandhi\", verify that the \"Hospital Course\" text area is present or not?\r\n"
			+ "If Present, then highlight the \"Hospital Course\" text area as color yellow ")
	public void highlightElement() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(doctor_PagesInstance.highlightElementInYellowColour(), "Element is not present is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.saveButtonInsideIpdPageIsPresent(driver).isDisplayed(), "Element is not present is not present, please check manually");
	}

	@Test(priority = 11, groups = {"sanity"}, description="On the \"Discharge Summary\" page of Profile \"Sonia Gandhi\", verify that, \"Treatment During Hospital Stay\" textarea is present or not?\r\n"
			+ "If Present, then get the placeholdername of \"Treatment During Hospital Stay\" textarea and Validate that placeholdername.")
	public void verifyThePlaceHolderName() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "percentageValue");
		Assert.assertEquals(doctor_PagesInstance.verifyThePlaceHolderNameOfTreatmentDuringHospitalStayTextarea(),expectedData.get("TreatmentDuringHospitalStayPlaceHolderValue"),"Place Holder value is not present in the current page, Please check manually") ;
		Assert.assertEquals(locatorsFactoryInstance.treatmentDuringHospitalStayTextAreaPlaceHolderIsPresent(),expectedData.get("TreatmentDuringHospitalStayPlaceHolderValue"),"Place Holder value is not present in the current page, Please check manually");
	}

	@Test(priority = 12, groups = {"sanity"}, description="On the \"Discharge Summary\" page of Profile \"Sonia Gandhi\", verify that, \"Condition On Discharge\" textarea is present or not?\r\n"
			+ "If present, then send the value to the \"Condition On Discharge\" textarea. \r\n"
			+ "Then validate the entered value.")
	public void  validateTheEnteredValue() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "TextFieldDatas");
		Assert.assertEquals(doctor_PagesInstance.validateTheEnteredValueInConditionOnDischargeTextarea(expectedData),expectedData.get("conditionOnDischargeFieldData"),"Unable to validate the field value, Please check manually") ;
		Assert.assertEquals(locatorsFactoryInstance.conditionOnDischargeTextAreaValueIsPresent(),expectedData.get("conditionOnDischargeFieldData"),"field value is not present in the current page, Please check manually");
	}

	@Test(priority = 13, groups = {"sanity"}, description="On the \"Discharge Summary\" page of Profile \"Sonia Gandhi\", select \"Yes\" radio button from the \"Show Result on Report\" label and then verify that the \"Yes\" radio button is selected or not.\r\n"
			+ "After valodation, then deselect the \"Yes\" radio button from the \"Show Result on Report\" label")
	public void verifyTheRadioButton() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(doctor_PagesInstance.verifyThatTheYesRadioButtonIsSelectedAndDeselect(), "yes Radio Button is not selected, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.noRadioButtonIsPresent(driver).isSelected(), "No Radio Button is not selected, please check manually");
	}

	@Test(priority = 14, groups = {"sanity"}, description="On the \"Discharge Summary\" page of Profile \"Sonia Gandhi\", verify that the \"Pending Reports\" text area is present or not?\r\n"
			+ "If Present, then click & send value to the \"Pending Reports\" text area using the JavaScript")
	public void performJavaScriptOperations() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "TextFieldDatas");
		Assert.assertTrue(doctor_PagesInstance.clickAndSendValueToThePendingReportsTextAreaUsingJavaScript(expectedData), "Unable to perform javascript operations, please check manually");
		Assert.assertEquals(locatorsFactoryInstance.pendingReportsTextAreaValueIsPresent(),expectedData.get("pendingReportsTextFieldData"),"Validation failed, Please check manually");
	}

	@Test(priority = 15, groups = {"sanity"}, description="On the \"Discharge Summary\" page of Profile \"Sonia Gandhi\", verify that the \"Save\" button is present or not?\r\n"
			+ "If present, then click on the save button directly without fill any information and it will throw a notification popup error message.\r\n"
			+ "Then validate that  notification popup error message \r\n"
			+ "Failed\r\n"
			+ "Enter Manditory fields")
	public void verifyTheNotificationPopupErrorMessage() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthAppErrorMessages");
		Assert.assertEquals(doctor_PagesInstance.verifyTheNotificationPopupErrorMessageAfterClickOnSaveButton(),expectedData.get("PopupErrorMessage"),"Error message is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.popupErrorMessageIsPresent(driver).isDisplayed(), "Error message is not present in the current page, Please check manually");
	}

	@Test(priority = 16, groups = {"sanity"}, description="On the  \"Scanned Images\" Module of Profile \"Sonia Gandhi's\",\r\n"
			+ "Upload a image in Scanned Images module.")
	public void uploadImageInScannedImagesSection() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(doctor_PagesInstance.handleFileUpload(System.getProperty("user.dir") + "\\testImage\\uploadImage.png"),"Not able to upload the image, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyUploadButtonIsPresent(driver).isDisplayed(),"upload button is not present in the current page, Please check manually");
	}

	@Test(priority = 17, groups = {"sanity"}, description="On the Doctor Module's \"Out Patient\" Sub module,\r\n"
			+ "Taking screenshot of the \"Out Patient\" page.")
	public void takingScreenshotOfCurrentPage() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(doctor_PagesInstance.takingScreenshotOfTheCurrentPage(),"Not able to take the screenshot, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyOutPatientMenuIsPresent(driver).isDisplayed(),"OutPatient Menu is not present in the current page, Please check manually");
	}

	@Test(priority = 18, groups = {"sanity"}, description="Scroll to the Vaccination Module's and Expand it.\r\n"
			+ "Click on \"Patient List\" page and perform the keyboard operation (\"Alt + N\")\r\n"
			+ "to open the \"Vaccination Patient Register\" form.\r\n"
			+ "Then Validate the \"Vaccination Patient Register\" page Name.")
	public void performKeyboardOperation() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "DoctotModule");
		Assert.assertEquals(doctor_PagesInstance.performKeyboardOperation(), expectedData.get("titleNameOfVaccinationPatientRegisterForm"),"Error in Page class something went wroung, please check manually");
		Assert.assertEquals(locatorsFactoryInstance.verifyTitleNameOfVaccinationPatientRegisterFormIsPresent(),expectedData.get("titleNameOfVaccinationPatientRegisterForm"),"title Name Of Vaccination Patient Register Form is not matching in current page(locators factory), Please check manually");
	}

	@Test(priority = 19, groups = {"sanity"}, description="On the Appointment module,\r\n"
			+ "under the\"New visit\" tab,\r\n"
			+ "verify tooltips which is present on keyboard icon.")
	public void  verifyTooltipOfAnElement() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "KeyBoardTooltip");
		Assert.assertEquals(doctor_PagesInstance.verifyToolTipOfAnElement(), expectedData.get("newPatientTooltipValue"),"Verification failed, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.tooltipTextIsPresent(driver).isDisplayed(), "Tooltip is not present in the current page, Please check manually");
	}

	@Test(priority = 20, groups = {"sanity"}, description="On the Appointment module \"New Visit\" page,\r\n"
			+ "clicking on the \"New Patient\" button it will navigate to \"New Visit\" page.\r\n"
			+ "When user try to select \"NHIF CAPTION\" option from the Membership dropdown\r\n"
			+ "it should popup the alert message :This will change Price Category as well.\r\n"
			+ "Handle the alert popup and validate the popup message.\r\n"
			+ "After handle the popup, \r\n"
			+ "validate that the \"NHIF CAPTION\" is selected from  Membership dropdown or not?")
	public void  handleAlertPopup() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "DoctotModule");
		Assert.assertEquals(doctor_PagesInstance.handleAlertPopup(expectedData), expectedData.get("membershipDropdownOption"),"Verification failed, please check manually");
		Assert.assertEquals(locatorsFactoryInstance.verifyNhifCapitationIsSelected(), expectedData.get("membershipDropdownOption"), "selected option is not matching with expected, please check manually!");
	}

	@Test(priority = 21, groups = {"sanity"}, description="On the Procurement module's Reports Tab,\r\n"
			+ "Search for a Select a Item as Accounts \r\n"
			+ "and select Accounts  and validate Accounts is selected or not ?")
	public void handleAutoSuggesstion() throws Exception {
		doctor_PagesInstance = new doctor_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "ProcurementModule");
		Assert.assertTrue(doctor_PagesInstance.handleAutoSuggesstion(expectedData),"User is not abale to handle the search bar, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.accountOptionIsSelected(driver).isDisplayed(),"Account option is not selected, Please check manually");
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
