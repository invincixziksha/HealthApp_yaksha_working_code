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
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class appointment_testcase extends AppTestBase
{
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath + "expected_data.json";
	String loginFilePath = loginDataFilePath + "Login.json";
	StartupPage startupPage;


	appointment_Pages appointment_PagesInstance;
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


	@Test(priority = 1, groups = {"sanity"}, description="* Navigate to the URL.\r\n"
			+ "* Retrieve Title and URL of the current page.\r\n"
			+ "* Verify Title & URL: Check if the title  & URL matches the expected title.")
	public void verifyTitleOfTheHomePage() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> loginData = new FileOperations().readJson(loginFilePath, "credentials");
		Assert.assertTrue(appointment_PagesInstance.loginToHealthAppByGivenValidCredetial(loginData),"Login failed, Invalid credentials ! Please check manually");
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthApp");
		Assert.assertEquals(appointment_PagesInstance.verifyTitleOfThePage(),expectedData.get("dasboardTitle")) ;
		Assert.assertEquals(appointment_PagesInstance.verifyURLOfThePage(),expectedData.get("homePageUrl")) ;
		Assert.assertTrue(locatorsFactoryInstance.verifyAppointmentModuleIsPresent(driver).isDisplayed(), "Appointment Module is not present in the current page, Please check manually");
//		Assert.assertTrue(locatorsFactoryInstance.totalDoctorTextIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}

	@Test(priority = 2, groups = {"sanity"}, description="* Verify that Appointment module is present or not ?\r\n"
			+ "* While trying to navigate to the Appointment Module,\r\n"
			+ "it popups the \"Select Counter\" Page \r\n"
			+ "* Verify the \"Select Counter\" Page Name")
	public void verifyAppointmentModuleIsPresent() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "appointmentModule");

		Assert.assertEquals(appointment_PagesInstance.verifyAppointmentModuleIsPresent(),expectedData.get("selectCounterTitle"),  "select Counter Title is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifySelectCounterPopupsIsPresent(driver).isDisplayed(), "select counter popups is not present in the current page, Please check manually");
	}

	@Test(priority = 3, groups = {"sanity"}, description="On the Appointment module's \"New Visit\" Page,\r\n"
			+ "Verify the  \"New Patient\" Button is present or not ?\r\n"
			+ "If \"New Patient\" button is present, \r\n"
			+ "then click on it.\r\n"
			+ "If it clicking on \"New Patient\" button,\r\n"
			+ "then verify the \"Patient Information\" text is present or not ?")
	public void verifyButtonAndTextIsPresent() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "appointmentModule");

		Assert.assertEquals(appointment_PagesInstance.verifyButtonAndTextIsPresent(),expectedData.get("patientInformationTitle"),  "patient Information Title is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyPatientInformationTextIsPresent(driver).isDisplayed(), "Patient Information Text is not present in the current page, Please check manually");
	}

	@Test(priority = 4, groups = {"sanity"}, description="On the Appointment module's New Visit Page,\r\n"
			+ "scroll to the buttom of the page.\r\n"
			+ "Then highlight the \"Care of Person Contact\" textbox as Blue color")
	public void scrollToBottomVerifyFieldAndHighlight() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Assert.assertTrue(appointment_PagesInstance.scrollToBottomVerifyFieldAndHighlight(), "care of person contact textbox is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyPrintInvoiceButtonIsPresent(driver).isDisplayed(), "print invoice button is not present in the current page, Please check manually");
	}

	@Test(priority = 5, groups = {"sanity"}, description="On the Appointment module's New Visit Page,\r\n"
			+ "user must be on buttom of the page.\r\n"
			+ "Then click on  \"Care of Person\" textbox and\r\n"
			+ "get the placeholder name of the \"Care of Person\" textbox.\r\n"
			+ "Then Verify the placeholder name is \"Care Taker Person\"")
	public void verifyPlaceholderNameOfTexboxIfTextboxIsEnabled() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "appointmentModule");
		Assert.assertEquals(appointment_PagesInstance.verifyPlaceholderNameOfTexbox(),expectedData.get("careOfPersonTextboxPlaceHolderName")) ;
		Assert.assertTrue(locatorsFactoryInstance.verifyCareOfPersonTextboxIsPresent(driver).isDisplayed(), "Care Of Person" + "Textbox is not present in the current page, Please check manually");
	}

	@Test(priority = 6, groups = {"sanity"}, description="On the Appointment module's \"New Visit\" page,\r\n"
			+ "validate the error message in \"Patient Information\" form's  lastname textfield\r\n"
			+ "after clicking on \"Print Invoice\" Button\r\n"
			+ "without filling any information in the form.")
	public void verifyErrorMessage() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "appointmentModule");
		Assert.assertEquals(appointment_PagesInstance.verifyErrorMessage(), expectedData.get("errorMessageOfLastNameTextbox")) ;
		Assert.assertTrue(locatorsFactoryInstance.verifyErrorMessageOfLastNameTextbox(driver).isDisplayed(), "Error Message is not present in the current page, Please check manually");
	}

	@Test(priority = 7, groups = {"sanity"}, description="On the Appointment module's \"New Visit\" page,\r\n"
			+ "Fill all given textfields which are present inside the Patient Information form.\r\n"
			+ "Validate the entered values.\r\n"
			+ "Following textboxes are :\r\n"
			+ "First Name textbox\r\n"
			+ "Middle Name textbox\r\n"
			+ "Last Name textbox.\r\n"
			+ "Age textbox.\r\n"
			+ "Phone No. textbox.")
	public void verifyEnteredDataIsPresentInTextbox() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "appointmentModule");

		Assert.assertEquals(appointment_PagesInstance.verifyTexboxIsPresentAndValidateEnteredValue(expectedData),expectedData.get("phoneNumberValue"), "something wroung in page class, please check manually") ;
		Assert.assertEquals(locatorsFactoryInstance.verifyValueIsPresentInPhoneNumberTextbox(),expectedData.get("phoneNumberValue"), "something wroung in locators class, please check manually") ;
	}

	@Test(priority = 8, groups = {"sanity"}, description="On the New Visit\" page's \"Patient Information\" form,\r\n"
			+ "click on \"Have DOB ?\" checkbox\r\n"
			+ "and verify that the  \"Have DOB ?\" is selected or not.\r\n"
			+ "After validation verify that the \"Datepicker\" field  is coming\r\n"
			+ "after click on \"  \"Have DOB ?\" checkbox")
	public void verifyCheckboxIsSelectedAndDatePickerIsPresent() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		Assert.assertTrue(appointment_PagesInstance.verifyCheckboxIsSelectedAndDatePickerIsPresent(), "check box didn't click in page class, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyDatePickerElementIsPresent(driver).isDisplayed(), "datePicker is not present in the Locators page, Please check manually");
	}

	@Test(priority = 9, groups = {"sanity"}, description="On  the \"Booking OT Schedule | New Patient\" form's, \r\n"
			+ "External? Checkbox must be selected.\r\n"
			+ "Click on \"+\" icon to popup the Add External Referral form\r\n"
			+ "then fill all the details (get the data from json),\r\n"
			+ "click on all checkbox and then click on \"Add\" button\r\n"
			+ "then verify the success notifications message.")
	public void verifySuccessNotificationPopupMessage() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "addExternalReferralPageInfo");

		Assert.assertEquals(appointment_PagesInstance.verifySuccessNotificationPopupMessage(expectedData),expectedData.get("successNotificationPopupMessage")) ;
		Assert.assertEquals(locatorsFactoryInstance.verifySuccessNotificationPopupMessageIsPresent(),expectedData.get("successNotificationPopupMessage")) ;
	}

	@Test(priority = 10, groups = {"sanity"}, description="On the New Visit\" page's \"Patient Information\" form,\r\n"
			+ "scroll to the  \"Relation With Patient\" dropdown\r\n"
			+ "and then select \"Son\" from the \"Relation With Patient\" dropdown.\r\n"
			+ "validate \"Son\" is  properly selected or not.")
	public void verifyOptionIsSelectedFromDropdown() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "appointmentModule");

		Assert.assertEquals(appointment_PagesInstance.verifyOptionIsSelectedFromDropdown(expectedData), expectedData.get("relationWithPatientDropdownOption"), "selected option is not matching with expected in page class, please check manually!");
		Assert.assertEquals(locatorsFactoryInstance.verifyRelationWithPatientOptionIsSelected(), expectedData.get("relationWithPatientDropdownOption"), "selected option is not matching with expected(Locators Factory), please check manually!");
	}

	@Test(priority = 11, groups = {"sanity"}, description="On the \"Appointment\" module's,\r\n"
			+ "click on \"Book Appointment\" Sub module.\r\n"
			+ "(Expand Appointment module, if not)\r\n"
			+ "On the \"Book Appointment\" page,\r\n"
			+ "select the \"Month\" radio button\r\n"
			+ "and verify that the \"Month\" radio button is selected or not.\r\n"
			+ "After the validation deselect the \"Month\" radio button.")
	public void verifyRadioButton() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	

		Assert.assertTrue(appointment_PagesInstance.verifyRadioButton(),"something went wroung in pages class, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyDaysRadioButtonIsSelected(), "element not present in the current page ((Locators Factory), Please check manually");
	}

	@Test(priority = 12, groups = {"sanity"}, description="On the \"Appointment\" module's \"Book Appointment\" page,\r\n"
			+ "send the value to the below  textbox using javascript.\r\n"
			+ "Following Textbox are:\r\n"
			+ "1. FirstName Text box\r\n"
			+ "2. Middle Name Text Box\r\n"
			+ "3. Last Name Text box\r\n"
			+ "and then click on \"Male\" radio button using java script")
	public void performJavaScriptOperation() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "appointmentModule");

		Assert.assertEquals(appointment_PagesInstance.performJavaScriptOperation(expectedData),expectedData.get("lastNameValue"), "something wroung in page class, please check manually") ;
		Assert.assertEquals(locatorsFactoryInstance.verifyLastnameTextboxValueIsPresent(),expectedData.get("lastNameValue"), "something wroung in locators class, please check manually") ;
	}

	@Test(priority = 13, groups = {"sanity"}, description="On the \"Appointment\" module's \"Book Appointment\" page,\r\n"
			+ "locate the \"Add Appointment\" button by using Name locators\r\n"
			+ "and then get the attribute of Name locators.\r\n"
			+ "Verify that the  \"Add Appointment\" button is present or not\r\n"
			+ "and then highlight it.")
	public void verifyLocators() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "appointmentModule");

		Assert.assertEquals(appointment_PagesInstance.verifyLocatorsValueOfELementAndHighLight(), expectedData.get("idLocatorsValueOfAddPatientButton"),"something went wroung, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyAddAppointmentButtonIsPresent(driver).isDisplayed(), "Add Patient Button is not present in the Locators page, Please check manually");
	}

	@Test(priority = 14, groups = {"sanity"}, description="On the Book Appointment submodules of appointment module,\r\n"
			+ "clicking on the \"Add Appointment\" button\r\n"
			+ "it will throw an Error Notification popup. \r\n"
			+ "Then Assert that Error Message using hard assert")
	public void verifyErrorNotificationPopupMessage() throws Exception {

		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "appointmentModule");

		Assert.assertEquals(appointment_PagesInstance.verifyErrorNotificationPopupMessage(expectedData),expectedData.get("errorNotificationPopupMessage")) ;
		Assert.assertEquals(locatorsFactoryInstance.verifyErrorNotificationPopupMessageIsPresent(),expectedData.get("errorNotificationPopupMessage")) ;
	}
	
	@Test(priority = 15, groups = {"sanity"}, description="On Procurements Module's Setting page,\r\n"
			+ "select the Sub Category Tab and  fetch the Sub-Category Name for the given code (Code - 0003)\r\n"
			+ "and validate that Sub Category name.")
	public void getDataFromTable() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "socialServiceModuleStringValue");
		Assert.assertEquals(appointment_PagesInstance.getDataFromTable(), expectedData.get("cottonSubCategoryName"),"something went wroung page class, please check manually");
//		Assert.assertEquals(locatorsFactoryInstance.veryfyTableData(),expectedData.get("cottonSubCategoryName"),"something went wroung locators class, Please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyAddSubCategoryButtonIsPresent(driver).isDisplayed(), "Add Sub Category Button is not present in the Locators page, Please check manually");
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
