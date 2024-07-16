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
import pages.socialService_Pages;
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class socialService_testcase extends AppTestBase
{
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath + "expected_data.json";
	String loginFilePath = loginDataFilePath + "Login.json";
	StartupPage startupPage;
	socialService_Pages socialService_PagesInstance;
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

		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> loginData = new FileOperations().readJson(loginFilePath, "credentials");
		Assert.assertTrue(socialService_PagesInstance.loginToHealthAppByGivenValidCredetial(loginData),"Login failed, Invalid credentials ! Please check manually");

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthApp");
		Assert.assertEquals(socialService_PagesInstance.verifyTitleOfThePage(),expectedData.get("dasboardTitle")) ;
		Assert.assertEquals(socialService_PagesInstance.verifyURLOfThePage(),expectedData.get("pageUrl")) ;
		Assert.assertTrue(locatorsFactoryInstance.totalDoctorTextIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 2, groups = {"sanity"}, description="Verify that SocialService module is present or not ?                                                      \r\n"
			+ "If Social Service Module is present then Then go to SocialService Page.")
	public void verifySocialServiceModuleIsPresentAndGoToSocialServiceTab() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.verifySocialServiceModuleisPresentAndGoToSocialServiceTab(), "SocialService Module is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.editInformationOfTextFieldIsPresent(driver).isDisplayed(), "Edit Information Of TextField is not present in the current page, Please check manually");
	}
	
	@Test(priority = 3, groups = {"sanity"}, description="Verify that Register New SSU Patient button is present inside the SocialService page\r\n"
			+ "and when we click on \"Register New SSU Patient\" button, it popup \"New SSU Patient Registration\" form.")
	public void registerNewSSUPatientButtonIsPresent() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "socialServiceModuleStringValue");
		Assert.assertEquals(socialService_PagesInstance.verifyRegisterNewSSUPatientButtonisPresentAndValidateFormName(),expectedData.get("newSSUPatientRegistration"), "New SSU Patient Registration Form is not present, please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.verifyPatientInformationTabIsPresent(driver).isDisplayed(), "Patient Information Tab is not present in the current page, Please check manually");
	}
	
	@Test(priority = 4, groups = {"sanity"}, description="On the \"New SSU Patient Registration\" form,\r\n"
			+ "Validate the error message in Last Name textfield\r\n"
			+ "without filling any data and clicking on \"Register\" Button")
	public void validateTheErrorMessageInFirstnameTextfield() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthAppErrorMessages");
		Assert.assertEquals(socialService_PagesInstance.validateErrorMessageInLastNameTextfield(),expectedData.get("LastNameFieldErrorMessage"),"Error message is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.verifyErrorMessageIsPresentInGenderDropdown(driver).isDisplayed(), "Error message is not present in the current page, Please check manually");
	}
	
	@Test(priority = 5, groups = {"sanity"}, description="On the \"New SSU Patient Registration\" form's validate that First Name,\r\n"
			+ "Middle Name & Last Name textbox are present or not ?\r\n"
			+ "If present then fill the below textbox :\r\n"
			+ "First Name textbox\r\n"
			+ "Middle Name textbox\r\n"
			+ "Last Name textbox \r\n"
			+ "Check the data which we are entered are present in \"First Name\"First Name textbox or not ?")
	public void fillDataInTextfieldsAndVerifyEnteredData() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "NewSSUPatientRegistrationForm");
		Assert.assertEquals(socialService_PagesInstance.fillDataInTextfieldsAndVerifyEnteredData(expectedData), expectedData.get("firstName"),"Any of the field is not present in the current page, Please check manually");
		Assert.assertEquals(locatorsFactoryInstance.verifyValueIsPresentInLastNameTextbox(),expectedData.get("lastName"),"lastName field Text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 6, groups = {"sanity"}, description="On the Social Service module's, \r\n"
			+ "\"New SSU Patient Registration\" form, \r\n"
			+ "select India  from the country dropdown and\r\n"
			+ "validate India is  properly selected or not.")
	public void verifyIndiaIsSelectedFromCountryDropdown() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "NewSSUPatientRegistrationForm");
		Assert.assertEquals(socialService_PagesInstance.selectIndiaFromCountryDropdownAndVerifySelection(expectedData), expectedData.get("selectedCountryName"), "selected country is not matching with expected, please check manually!");
		Assert.assertEquals(locatorsFactoryInstance.verifyIndiaIsPresent(), expectedData.get("selectedCountryName"), "selected country is not matching with expected, please check manually!");
	}
	
	@Test(priority = 7, groups = {"sanity"}, description="scroll to the bottom of the \"New SSU Patient Registration\" form\r\n"
			+ "and verify that \"Register\" button  and \"Close\" button are peresent or not?")
	public void scrollToButtomOfThePageAndVerifyCloseButtonIsPresent() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.scrollToButtomOfThePageAndVerifyCloseButtonIsPresent(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyRegisterButtonIsPresent(driver).isDisplayed(), "Print Invoice Button Element is not present in the current page, Please check manually");
	}
	
	@Test(priority = 8, groups = {"sanity"}, description="Validate the warnning message for the membership dropdown.")
	public void validateWarnningMessageForMembershipDropdown() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "NewSSUPatientRegistrationPopup");
		Assert.assertEquals(socialService_PagesInstance.validateWarnningMessageOfNewSSUPatientRegistrationForms(expectedData), expectedData.get("warnningMessage"),"Warning message is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.warningMessageIsPresent(driver).isDisplayed(), "Warning message is not present in the current page, Please check manually");
	}
	
	@Test(priority = 9, groups = {"sanity"}, description="select Yes from the Has target group certificate? dropdown and verify that Target group certificate type and certificate no textfield is present or not ")
	public void verifyYesIsSelectedFromHasTargetGroupCertificateDropdownAndValidateTextbox() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "NewSSUPatientRegistrationForm");
		Assert.assertEquals(socialService_PagesInstance.verifyTextboxIsPresentBySelectingYesFromHasTargetGroupCertificateDropdown(expectedData), expectedData.get("HasTargetGroupCertificate?Yes"), " Yes option is not present in that dropdown, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyCertificateNoTextFieldIsPresent(driver).isDisplayed(), "hasTG_certificate Dropdown is not present in the current page, Please check manually");
	}
	
	@Test(priority = 10, groups = {"sanity"}, description="On the \"New SSU Patient Registration\" form's,\r\n"
			+ "get the place holder name of \"Address\" textfiled of  \"New SSU Patient Registration\" page\r\n"
			+ "and verify  the place holder name.")
	public void getPlaceHolderNameVerifyPlaceHolderName() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "NewSSUPatientRegistrationPopup");
		Assert.assertEquals(socialService_PagesInstance.getPlaceHolderNameVerifyPlaceHolderNameOfAddress(expectedData), expectedData.get("AddressFieldPlaceHolder"),"Not able to verify the placeholder name, please check manually");
		Assert.assertEquals(locatorsFactoryInstance.raceTextFieldPlaceHolderIsPresent(),expectedData.get("RaceFieldPlaceHolder"),"race Textfield is not present in the current page, Please check manually");
	}
	
	@Test(priority = 11, groups = {"sanity"}, description="Close this New SSU Patient Registration popup by using javaScript")
	public void performJavaScriptExecutorOperation() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.closeNewSSUPatientRegistrationPopupByUsingJsExecutor(), "Unable to perform the js Executor operation, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.listByPatientStatusRadioButtonIsPresent(driver).isSelected(), "RadioButton is not present in the current page, Please check manually");
	}
	
	@Test(priority = 12, groups = {"sanity"}, description="Close this New SSU Patient Registration popup by using javaScript")
	public void performNavigateBackNavigateRefreshNavigateForwordAction() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.performNavigateBackNavigateRefreshNavigateForwordAction(), "elements are not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifySSUPatientListButtonIsPresent(driver).isDisplayed(), "elements are not present, Please check manually");
	}
	
	@Test(priority = 13, groups = {"sanity"}, description="On the Social service module's, in the \"SSU Patient List\" page,\r\n"
			+ "locate the \"Edit Information Of\" patient  textbox using \"ID\" locator \r\n"
			+ "and verify the locator name is \"id\" or not ?")
	public void verifyLocators() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "socialServiceModuleStringValue");
		Assert.assertEquals(socialService_PagesInstance.verifyLocatorsName(expectedData), expectedData.get("idNameOfeditInformationtexbox"),"something went wroung, please check manually");
		Assert.assertEquals(locatorsFactoryInstance.verifyAttributesValueOfEditInformationTexbox(),expectedData.get("editInformationOfExistingPatientName"),"race Textfield is not present in the current page, Please check manually");
	}
	
	@Test(priority = 14, groups = {"sanity"}, description="On Procurements Module's Setting page,\r\n"
			+ "select the Sub Category Tab and  fetch the Sub-Category Name for the given code (Code - 0003)\r\n"
			+ "and validate that Sub Category name.")
	public void getDataFromTable() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "socialServiceModuleStringValue");
		Assert.assertEquals(socialService_PagesInstance.getDataFromTable(), expectedData.get("cottonSubCategoryName"),"something went wroung, please check manually");
		Assert.assertEquals(locatorsFactoryInstance.veryfyTableData(),expectedData.get("cottonSubCategoryName"),"something went wroung, Please check manually");
//		Assert.assertTrue(locatorsFactoryInstance.verifyAddSubCategoryIsPresent(driver).isDisplayed(), "elements are not present, Please check manually");
	}
	
	@Test(priority = 15, groups = {"sanity"}, description="On Procurements Module's Setting page, \r\n"
			+ "select the Items Tab, \r\n"
			+ "then click on \"Add Item\" Button which popups \"Add Item\" form.\r\n"
			+ "Then select the \"GENERAL-INVENTORY\" radio button\r\n"
			+ "and check whether is the radio button is selected or not. \r\n"
			+ "After the validation deselect the \"GENERAL-INVENTORY\" radio button.")
	public void verifyRadioButton() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.verifyRadioButton(),"something went wroung, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyProcurementModuleRadioButton(), "element not present in the current page, Please check manually");
	}
	
	@Test(priority = 16, groups = {"sanity"}, description="On the Add Item form's\r\n"
			+ "Select/check the below check boxes :\r\n"
			+ "1. Is Cssd Applicable check box\r\n"
			+ "2. Is Cold Storage Applicable check box\r\n"
			+ "3. Is Patient Consumption Applicable check box\r\n"
			+ "verify that the above check boxes are selected or not ?\r\n"
			+ "after the validation, Uncheck the above check box.")
	public void verifyCheckbox() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.verifyCheckbox(),"something went wroung, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifySaveItemIsPresent(driver).isDisplayed(),"element is not present in the current page, Please check manually");
	}
	
	//L2 Scenarios of Social Service Page
	
	@Test(priority = 17, groups = {"sanity"}, description="On the Appointment module, under the\"New visit\" tab, verify tooltips which is present on keyboard icon.")
	public void  verifyTooltipOfAnElement() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "KeyBoardTooltip");
		Assert.assertEquals(socialService_PagesInstance.verifyToolTipOfAnElement(), expectedData.get("newPatientTooltipValue"),"Verification failed, please check manually");
	    Assert.assertTrue(locatorsFactoryInstance.tooltipTextIsPresent(driver).isDisplayed(), "Tooltip is not present in the current page, Please check manually");
	}
	
	@Test(priority = 18, groups = {"sanity"}, description="On \"Procurement\" module's , \r\n"
			+ "Upload the image in \"Add Invoice Header\" page.")
	public void uploadImageInScannedImagesSection() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.uploadImageInScannedImagesSection(System.getProperty("user.dir") + "\\testImage\\uploadImage.png"),"Not able to upload the image, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.saveButtonIsPresent(driver).isDisplayed(),"Save button is not present in the current page, Please check manually");
	}
	
	@Test(priority = 19, groups = {"sanity"}, description="Perform the keyboard operation to open the \"Add New Patient\" popup Page\r\n"
			+ "and verify that the popup is displayed or not.")
	public void performTheKeyboardOperationToOpenThePopup() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "PageTitle");
		Assert.assertEquals(socialService_PagesInstance.performTheKeyboardOperationToOpenthePopup(),expectedData.get("AddNewPatientPageTitle"),"Not able to do the keyboard operation, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.firstNameFieldIsPresent(driver).isDisplayed(), "firstName field is not present in the current page, Please check manually");
	}
	
	@Test(priority = 20, groups = {"sanity"}, description="On the Dispensary module's \"Sale\" page,\r\n"
			+ "Taking screenshot of the current page after closing the \"Add New Patient\" form.")
	public void takingScreenshotOfCurrentPage() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.takingScreenshotOfTheCurrentPage(),"Not able to take the screenshot, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.printInvoiceButtonIsPresent(driver).isDisplayed(),"Race TextField is not present in the current page, Please check manually");
	}
	
	@Test(priority = 21, groups = {"sanity"}, description="On the Procurement module's Reports Tab,\r\n"
			+ "Search for a Select a Item as Accounts \r\n"
			+ "and select Accounts  and validate Accounts is selected or not ?")
	public void handleAutoSuggesstion() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "ProcurementModule");
		Assert.assertTrue(socialService_PagesInstance.handleAutoSuggesstion(expectedData),"User is not abale to handle the search bar, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.accountOptionIsSelected(driver).isDisplayed(),"Account option is not selectde, Please check manually");
	}
	
	@Test(priority = 22, groups = {"sanity"}, description="On Operation Theatre module, \r\n"
			+ "clicking \"New OT Booking\" button will popup\r\n"
			+ "\"Booking OT Schedule | New Patient\" form. Try to book a New OT Booking without patient\r\n"
			+ "Name should  popup the alert message \"Patient not Selected! Please Select the patient first!\".\r\n"
			+ "Handle the alert popup and validate the popup message.")
	public void  handleAlertPopup() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.handleAlertPopup(), "Unable to handle the alert popup, please check manually");	
	    Assert.assertTrue(locatorsFactoryInstance.addNewOTButtonIsPresent(driver).isDisplayed(), "Manage Role Tab is not present in the current page, Please check manually");
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