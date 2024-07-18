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
import pages.operationTheatre_Pages;
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class operationTheatre_testcase extends AppTestBase
{
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath + "expected_data.json";
	String loginFilePath = loginDataFilePath + "Login.json";
	StartupPage startupPage;
	operationTheatre_Pages operationTheatre_PagesInstance;
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

	@Test(priority = 1, groups = {"sanity"}, description="Verify the title and url of  the current page.")
	public void verifyTitleOfTheHomePage() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> loginData = new FileOperations().readJson(loginFilePath, "credentials");
		Assert.assertTrue(operationTheatre_PagesInstance.loginToHealthAppByGivenValidCredetial(loginData),"Login failed, Invalid credentials ! Please check manually");

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthApp");
		Assert.assertEquals(operationTheatre_PagesInstance.verifyTitleOfThePage(),expectedData.get("dasboardTitle")) ;
		Assert.assertEquals(operationTheatre_PagesInstance.verifyURLOfThePage(),expectedData.get("pageUrl")) ;
		Assert.assertTrue(locatorsFactoryInstance.totalDoctorTextIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}

	@Test(priority = 2, groups = {"sanity"}, description="Verify that OperationTheatre module is present or not ?\r\n"
			+ "If OperationTheatre Module is present, \r\n"
			+ "then go to OperationTheatre Page and \r\n"
			+ "check whether the \"Hospital Number\" \r\n"
			+ "header text is present or not in the given table")
	public void goToOperationTheatreModuleVerifyTableHeaderName() throws Exception {
		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModule");

		Assert.assertEquals(operationTheatre_PagesInstance.goToOperationTheatreModuleVerifyTableHeaderName(),expectedData.get("hospitalNumber"),  "OperationTheatre Module is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyNewOTBookingButtonIsPresent(driver).isDisplayed(), "New OT Button is not present in the current page, Please check manually");
	}

	@Test(priority = 3, groups = {"sanity"}, description="• On the operation theatre modules, verify that\r\n"
			+ "New OT Booking button is present?\r\n"
			+ "• If New OT Booking button is presenrt then\r\n"
			+ "clicking it popups \"Booking OT Schedule | New Patient\" form.")
	public void verifyBookingOTScheduleFormByClickingOnNewOTBookingButton() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModuleStringValue");

		Assert.assertEquals(operationTheatre_PagesInstance.verifyBookingOTScheduleFormByClickingOnNewOTBookingButton(),expectedData.get("bookingOTSchedulePageName")) ;
		Assert.assertTrue(locatorsFactoryInstance.verifyAddNewOTButtonIsPresent(driver).isDisplayed(), "Add New OT" + "Button is not present in the current page, Please check manually");
	}

	@Test(priority = 4, groups = {"sanity"}, description="On the \"Booking OT Schedule | New Patient\" form's\r\n"
			+ "validate that\r\n"
			+ "Select Patient textbox\r\n"
			+ "Diagnosis textbox &  \r\n"
			+ "Type of Surgery Textbox are present or not ?\r\n"
			+ "If present then fill the below textboxes :\r\n"
			+ "Select Patient textbox\r\n"
			+ "Diagnosis textbox\r\n"
			+ "Type of Surgery textbox\r\n"
			+ "Check the data which we are entered are present\r\n"
			+ "in Select Patient textbox or not ?")
	public void verifyEnteredDataIsPresentInTextbox() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModuleStringValue");

		Assert.assertEquals(operationTheatre_PagesInstance.verifyTexboxIsPresentAndValidateEnteredValue(expectedData),expectedData.get("patientName")) ;
		Assert.assertEquals(locatorsFactoryInstance.verifyValueIsPresentInTypeOfSurgeryTextbox(),expectedData.get("surgeryTypeValue")) ;
	}

	@Test(priority = 5, groups = {"sanity"}, description="On the \"Booking OT Schedule | New Patient\" form's\r\n"
			+ "validate that Remarks field is present or not ?\r\n"
			+ "Verify \"Remarks\" Text area is enable and\r\n"
			+ "verify the placeholder name  of \"Remarks\" text area.")
	public void verifyPlaceholderNameOfTexboxIfTextboxIsEnabled() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModuleStringValue");

		Assert.assertEquals(operationTheatre_PagesInstance.verifyPlaceholderNameOfTexboxIfTextboxIsEnabled(),expectedData.get("remarksPlaceHolderName")) ;
		Assert.assertTrue(locatorsFactoryInstance.verifyAddNewOTButtonIsPresent(driver).isDisplayed(), "Add New OT" + "Button is not present in the current page, Please check manually");
	}

	@Test(priority = 6, groups = {"sanity"}, description="On  the \"Booking OT Schedule | New Patient\" form's,\r\n"
			+ "type \"Dr. Pooja Mishra \" in surgen Name textfield and  verify the Dr. pooja mishra button  is present or not ?")
	public void verifyButtonIsPresentAfterSendValueToSurgenNameTextfield() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModuleStringValue");

		Assert.assertEquals(operationTheatre_PagesInstance.verifyButtonIsPresentAfterSendValueToSurgenNameTextfield(expectedData),expectedData.get("surgenNameValue2")) ;
		Assert.assertTrue(locatorsFactoryInstance.verifySurgenNameFirstButtonElementIsPresent(driver).isDisplayed(), "Surgen Name First Button is not present in the current page, Please check manually");
	}

	@Test(priority = 7, groups = {"sanity"}, description="On  the \"Booking OT Schedule | New Patient\" form's,\r\n"
			+ "click on the \"External?\" checkbox and \r\n"
			+ "verify the check box is selected or not ?")
	public void verifyPlusButtonIsPresentAfterClickOnExternalCheckbox() throws Exception {
		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(operationTheatre_PagesInstance.verifyPlusButtonIsPresentAfterClickOnExternalCheckbox(), "check box didn't click and Plus icon is not showing, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyPlusIconElementIsPresent(driver).isDisplayed(), "plus icon is not present in the current page, Please check manually");
	}

	@Test(priority = 8, groups = {"sanity"}, description="On the \"Add External Refferal\" form's, \r\n"
			+ "when we click on add button without filling any information, \r\n"
			+ "Verify the error message (Referrer Name is required)")
	public void verifyErrorMessageInAddExternalReferralForms() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModule");

		Assert.assertEquals(operationTheatre_PagesInstance.verifyErrorMessageInAddExternalReferralForms(),expectedData.get("errorMessageOfAddExternalReferralForms")) ;
		Assert.assertTrue(locatorsFactoryInstance.verifyErrorMessageOfAddExternalReferralForms(driver).isDisplayed(), "Error Message Of AddExternal Referral Forms is not present in the current page, Please check manually");
	}

	@Test(priority = 9, groups = {"sanity"}, description="On  the \"Booking OT Schedule | New Patient\" form's, \r\n"
			+ "External? Checkbox must be selected.\r\n"
			+ "Click on \"+\" icon to popup the Add External Referral form\r\n"
			+ "then fill all the details (get the data from json),\r\n"
			+ "click on all checkbox and then click on \"Add\" button\r\n"
			+ "then verify the success notifications message.")
	public void verifySuccessNotificationPopupMessage() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "addExternalReferralPageInfo");

		Assert.assertEquals(operationTheatre_PagesInstance.verifySuccessNotificationPopupMessage(expectedData),expectedData.get("successNotificationPopupMessage")) ;
		Assert.assertEquals(locatorsFactoryInstance.verifySuccessNotificationPopupMessageIsPresent(),expectedData.get("successNotificationPopupMessage")) ;
	}

	@Test(priority = 10, groups = {"sanity"}, description="On  the \"Booking OT Schedule | New Patient\" form's,\r\n"
			+ "Close the \"Booking OT Schedule | New Patient\" form's\r\n"
			+ "by using javaScript.")
	public void performJavaScriptExecutorOperation() throws Exception {
		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(operationTheatre_PagesInstance.closeBookingOTScheduleNewPatientFormsByUsingJsExecutor(), "Unable to perform the js Executor operation, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyNewOTBookingButtonIsPresent(driver).isDisplayed(), "New OT Booking is not present in the current page, Please check manually");
	}

	@Test(priority = 11, groups = {"sanity"}, description="Expand Billing Module,\r\n"
			+ "Scroll to the \"Handover\" Sub module's and \r\n"
			+ "then click on \"Handover\" Sub module\r\n"
			+ "again Scroll to the buttom of the handover page\r\n"
			+ "and validate the \"Remarks\" text field and\r\n"
			+ "\"Handover To User\" button is present")
	public void performScrollOperation() throws Exception {
		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModule");


		Assert.assertTrue(operationTheatre_PagesInstance.performScrollOperation(expectedData), "Unable to perform the scroll operation, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyHandoverToUserButtonIsPresent(driver).isDisplayed(), "HandoverToUser Button is not present in the current page(locators factory), Please check manually");
	}

	@Test(priority = 12, groups = {"sanity"}, description="On the Billing module's , buttom of the \"Handover\" page,\r\n"
			+ "locate the \"Remarks\" textbox and \"HandOver To User\" button by using \"ID\"  locator\r\n"
			+ "and verify that,  \r\n"
			+ "the \"Remarks\" textbox and \"HandOver To User\" button is present or not ?\r\n"
			+ "If the \"Remarks\" textbox and \"\"HandOver To User\" button is present,\r\n"
			+ "then highlight those element.")
	public void verifyLocators() throws Exception {
		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModule");
		Assert.assertEquals(operationTheatre_PagesInstance.verifyLocatorsValueOfELement(expectedData), expectedData.get("idLocatorsValueOfremarkTextbox"),"something went wroung, please check manually");
		Assert.assertEquals(locatorsFactoryInstance.verifyValueIsPresentInTextbox(),expectedData.get("remarksValue"),"value is not present in the remark text box (Locators factory),  Please check manually");
	}

	@Test(priority = 13, groups = {"sanity"}, description="Expand the Vaccination Module's\r\n"
			+ "and click on \"Patient List\" page \r\n"
			+ "and perform the keyboard operation\r\n"
			+ "(\"Alt + N\") to open the \"Vaccination Patient Register\" form.\r\n"
			+ "Then Validate the \"Vaccination Patient Register\" page Name.")
	public void performKeyboardOperation() throws Exception {
		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModule");
		Assert.assertEquals(operationTheatre_PagesInstance.performKeyboardOperation(), expectedData.get("titleNameOfVaccinationPatientRegisterForm"),"Error in Page class something went wroung, please check manually");
		Assert.assertEquals(locatorsFactoryInstance.verifyTitleNameOfVaccinationPatientRegisterFormIsPresent(),expectedData.get("titleNameOfVaccinationPatientRegisterForm"),"title Name Of Vaccination Patient Register Form is not matching in current page(locators factory), Please check manually");
	}

	@Test(priority = 14, groups = {"sanity"}, description="Expand the \"Appointment\" module\r\n"
			+ "and click on \"Book Appointment\" Sub module.\r\n"
			+ "On the \"Book Appointment\" page,\r\n"
			+ "select the \"Month\" radio button\r\n"
			+ "and verify that the \"Month\" radio button is selected or not.\r\n"
			+ "After the validation deselect the \"Month\" radio button.\r\n"
			+ "Then select the \"Follow-up Patient\" from the \"Select Visit type\" dropdown\r\n"
			+ "and verify that \"Follow-up Patient\" is selected or not.")
	public void verifyRadioButton() throws Exception {
		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModule");
		Assert.assertTrue(operationTheatre_PagesInstance.verifyRadioButton(),"something went wroung in pages class, please check manually");
		Assert.assertEquals(operationTheatre_PagesInstance.verifyOptionIsSelectedFromDropdown(expectedData), expectedData.get("visitTypeOptionValue"), "selected option is not matching with expected in page class, please check manually!");
		Assert.assertTrue(locatorsFactoryInstance.verifyDaysRadioButtonIsSelected(), "element not present in the current page ((Locators Factory), Please check manually");
		Assert.assertEquals(locatorsFactoryInstance.verifyFollowUpPatientIsSelected(), expectedData.get("visitTypeOptionValue"), "selected option is not matching with expected(Locators Factory), please check manually!");
	}

	@Test(priority = 15, groups = {"sanity"}, description="On the Book Appointment submodules of appointment module,\r\n"
			+ "clicking on the \"Add Appointment\" button\r\n"
			+ "it will throw an Error Notification popup. \r\n"
			+ "Then Assert that Error Message using hard assert")
	public void verifyErrorNotificationPopupMessage() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModule");

		Assert.assertEquals(operationTheatre_PagesInstance.verifyErrorNotificationPopupMessage(),expectedData.get("errorNotificationPopupMessage")) ;
		Assert.assertEquals(locatorsFactoryInstance.verifyErrorNotificationPopupMessageIsPresent(),expectedData.get("errorNotificationPopupMessage")) ;
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
