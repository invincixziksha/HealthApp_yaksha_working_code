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
import pages.dispensary_Pages;
import pages.socialService_Pages;
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class dispensary_testcase extends AppTestBase
{
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath + "expected_data.json";
	String loginFilePath = loginDataFilePath + "Login.json";
	StartupPage startupPage;
	dispensary_Pages dispensary_PagesInstance;
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

	@Test(priority = 1, groups = {"sanity"}, description="Verify the title and url of  the current page")
	public void verifyTitleOfTheHomePage() throws Exception {

		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> loginData = new FileOperations().readJson(loginFilePath, "credentials");
		Assert.assertTrue(dispensary_PagesInstance.loginToHealthAppByGivenValidCredetial(loginData),"Login failed, Invalid credentials ! Please check manually");

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthApp");
		Assert.assertEquals(dispensary_PagesInstance.verifyTitleOfThePage(),expectedData.get("dasboardTitle")) ;
		Assert.assertEquals(dispensary_PagesInstance.verifyURLOfThePage(),expectedData.get("pageUrl")) ;
		Assert.assertTrue(locatorsFactoryInstance.totalDoctorTextIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 2, groups = {"sanity"}, description="verify the Dispensary module is present or not?")
	public void verifyDispensaryModuleIsPresentOrNot() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.verifyDispensaryModuleIsPresentOrNot(), "Dispensary Module is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.registeredPatientTextElementIsPresent(driver).isDisplayed(), "Registered Patient Text Element is not present in the current page, Please check manually");
	}
	
	@Test(priority = 3, groups = {"sanity"}, description="verify all sub-modules are displayed correctly after clicking on the expand icon of Dispensary Module")
	public void verifyAllSubModulesArePresent() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.verifyAllSubModulesArePresentAndClickOnDispensary(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.morningCounterIsPresent(driver).isDisplayed(), "Morning Counter is not present in the current page, Please check manually");
	}
	
	
	@Test(priority = 4, groups = {"sanity"}, description="scroll to the bottom of the Sale page and verify that Print Invoice button,Discard button,Invoice History and Credit Limitis and Balance text are peresent or not?")
	public void scrollToButtomAndVerifyTheFields() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.scrollToButtomAndVerifytheFields(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.printInvoiceButtonElementIsPresent(driver).isDisplayed(), "Print Invoice Button Element is not present in the current page, Please check manually");
	}
	
	
	@Test(priority = 5, groups = {"sanity"}, description="Perform the keyboard operation to open the Add New Patient popup Page  and verify that the popup is displayed or not")
	public void performTheKeyboardOperationToOpenThePopup() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "PageTitle");
		Assert.assertEquals(dispensary_PagesInstance.performTheKeyboardOperationToOpenthePopup(),expectedData.get("AddNewPatientPageTitle"),"Not able to do the keyboard operation, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.firstNameFieldIsPresent(driver).isDisplayed(), "firstName field is not present in the current page, Please check manually");
	}
	
	@Test(priority = 6, groups = {"sanity"}, description="Validate the error message in Add New Patient form's firstname textfield after clicking on Ok Button without filling any information in the form")
	public void validateTheErrorMessageInFirstnameTextfield() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthAppErrorMessages");
		Assert.assertEquals(dispensary_PagesInstance.validateErrorMessageInFirstnameTextfield(),expectedData.get("FirstNameFieldErrorMessage"),"Error message is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.verifyErrorMessageIsPresentInLastNameTextField(driver).isDisplayed(), "Error message is not present in the current page, Please check manually");
	}
	
	@Test(priority = 7, groups = {"sanity"}, description="Fill all the text fields which are present inside the Add New Patient form and Validate entered values")
	public void fillAllTheTextfields() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "addNewPatientPopup");
		Assert.assertEquals(dispensary_PagesInstance.fillfirstNameTextFieldVerifyTheFirstName(expectedData), expectedData.get("firstName"),"firstName Text is not present in the current page, Please check manually");
		Assert.assertEquals(dispensary_PagesInstance.fillmiddelNameTextFieldVerifyThemiddleName(expectedData), expectedData.get("middleName"),"Middle name Text is not present in the current page, Please check manually");
		Assert.assertEquals(dispensary_PagesInstance.filllastNameTextfieldVerifylastName(expectedData), expectedData.get("lastName"),"lastName Text is not present in the current page, Please check manually");
		Assert.assertEquals(dispensary_PagesInstance.fillAgeTextFieldVerifyTheAge(expectedData), expectedData.get("age"),"Age Text is not present in the current page, Please check manually");
		Assert.assertEquals(dispensary_PagesInstance.fillContactNumberTextFieldVerifyContactNumber(expectedData), expectedData.get("contact"),"Contact Number Text is not present in the current page, Please check manually");
		Assert.assertEquals(locatorsFactoryInstance.ageTextFieldIsPresent(),expectedData.get("age"),"Age field Text is not present in the current page, Please check manually");
	}
	
	
	@Test(priority = 8, groups = {"sanity"}, description="On the New Consumption Entry's page, validate the confirm! Message that is Are you sure you want to Proceed ?")
	public void  validateTheConfirmMessage() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthAppErrorMessages");
		Assert.assertEquals(dispensary_PagesInstance.validateTheConfirmMessageOnTheNewConsumptionEntryPage(),expectedData.get("ConfirmationMessage"),"Confirmation message is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.confirmMessageIsPresent(driver).isDisplayed(), "Confirmation message is not present in the current page, Please check manually");
	}
	
	@Test(priority = 9, groups = {"sanity"}, description="on the Stock page,select Main store from Filter by store dropdown and verify that Main store is selected and stock value are filtered by the selected store name ")
	public void  selectFilterverifyFilterIsSelectedOrNot() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.selectMainStoreFromFilterSelectMainStoreFromFilter(),"Confirmation message is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.mainStoreDropDownIsPresent(driver).isSelected(), "Main Store DropDown is selected in the current page, Please check manually");
	}
	
	@Test(priority = 10, groups = {"sanity"}, description="on the stock page , please validate clicking Create Requisition button navigate to Add Requisitions page and validate the page Name")
	public void  validateTheButtonIsPresentAndNavigateToThisPage() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "PageTitle");
		Assert.assertEquals(dispensary_PagesInstance.validateCreateRequisitionButtonIsPresentGoToThisPageThenValidateThePageName(),expectedData.get("AddRequisitionPageName"),"Confirmation message is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.addRequisitionsPageNameIsPresent(driver).isDisplayed(), "Add Requisitions Page Name is not present in the current page, Please check manually");
	}
	
	@Test(priority = 11, groups = {"sanity"}, description="on the Add Requisition page, clicking the + icon button on right hand side of Remarks text box add a  the New set of elements to add a new records and validate New Item text field, Quantity Text field and Remark text box are present or not 2nd rows?")
	public void  verifyTheFieldsAreDisplayed() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.byClickingOnThatButtonSomeTextFieldsAreDisplyed(),"One of the field is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.remarkTextFieldIsPresent(driver).isDisplayed(), "Remarks TextField is not displayed in the current page, Please check manually");
	}
	
	@Test(priority = 12, groups = {"sanity"}, description="On the Requisition page, verify that view button under action navigate to the Requisition Details Print page and validate the page name is Requisition Details Print and validate print and Requisitions List button are present.")
	public void  verifyThePageNameAndButtons() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "PageTitle");
		Assert.assertEquals(dispensary_PagesInstance.verifyPageNameOfRequisitionDetailsPage(),expectedData.get("pageNameAfterClickingOnView"),"Page name is not matching, Please check manually") ;
		Assert.assertTrue(dispensary_PagesInstance.validateTheButtonsArePresentOrNot(),"One of the field is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.requisitionsListButtonIsPresent(driver).isDisplayed(), "Requisitions List Button is not displayed in the current page, Please check manually");
	}
		
	@Test(priority = 13, groups = {"sanity"}, description="On the Requisition Details Print page, Get the medicine name from the Requisition Details Print table and  validate the medicine name is not blank.")
	public void  fetchTheDataFromTheTable () throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.getTheMedicineNameFromTable(),"Medicine name is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.medicineQuantityIsPresent(driver).isDisplayed(), "Medicine quantity is not displayed in the current page, Please check manually");
	}
	
	@Test(priority = 14, groups = {"sanity"}, description="On the New SSU Patient Registration under social service module, get the place holder name of Address textfiled of New SSU Patient Registration page and verify  the place holder name.")
	public void validatePlaceholderName() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "NewSSUPatientRegistrationPopup");
		Assert.assertEquals(dispensary_PagesInstance.inAddressFieldValidateThePlaceHolderNameAndPrintOnConsole(),expectedData.get("AddressFieldPlaceHolder"),"Confirmation message is not present in the current page, Please check manually") ;
		Assert.assertEquals(locatorsFactoryInstance.raceTextFieldPlaceHolderIsPresent(),expectedData.get("RaceFieldPlaceHolder"),"race Textfield is not present in the current page, Please check manually");
	}
	
	@Test(priority = 15, groups = {"sanity"}, description="On the New SSU Patient Registration page, Close this New SSU Patient Registration popup page by using javaScript.")
	public void performJavaScriptExecutorOperation() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.closeNewSSUPatientRegistrationPopupByUsingJsExecutor(), "Unable to perform the js Executor operation, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.listByPatientStatusRadioButtonIsPresent(driver).isSelected(), "RadioButton is not present in the current page, Please check manually");
	}
	
	@Test(priority = 16, groups = {"sanity"}, description="On the Appointment module, under the\"New visit\" tab, verify tooltips which is present on keyboard icon.")
	public void  verifyTooltipOfAnElement() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "KeyBoardTooltip");
		Assert.assertEquals(dispensary_PagesInstance.verifyToolTipOfAnElement(), expectedData.get("newPatientTooltipValue"),"Verification failed, please check manually");
	    Assert.assertTrue(locatorsFactoryInstance.tooltipTextIsPresent(driver).isDisplayed(), "Tooltip is not present in the current page, Please check manually");
	}
	
	@Test(priority = 17, groups = {"sanity"}, description="Simply select India  from the country dropdown menu and validate India is selected or not.")
	public void verifyIndiaIsSelectedFromCountryDropdown() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "addNewPatientPopup");
		Assert.assertEquals(dispensary_PagesInstance.verifyIndiaIsSelectedFromCountryDropdown(expectedData), expectedData.get("selectedCountryName"), "selected country is not matching with expected, please check manually!");
		Assert.assertEquals(locatorsFactoryInstance.verifyIndiaIsPresent(), expectedData.get("selectedCountryName"), "selected country is not matching with expected, please check manually!");
	}
	
	@Test(priority = 18, groups = {"sanity"}, description="On the Dispensary module's \"Sale\" page, Taking screenshot of the current page after closing the \"Add New Patient\" form.")
	public void takingScreenshotOfCurrentPage() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.takingScreenshotOfTheCurrentPage(),"Not able to take the screenshot, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.printInvoiceButtonIsPresent(driver).isDisplayed(),"Race TextField is not present in the current page, Please check manually");
	}
	
	@Test(priority = 19, groups = {"sanity"}, description="Upload a image in Scanned Images section")
	public void uploadImageInScannedImagesSection() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.uploadImageInScannedImagesSection(System.getProperty("user.dir") + "\\testImage\\uploadImage.png"),"Not able to upload the image, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.saveButtonIsPresent(driver).isDisplayed(),"Save button is not present in the current page, Please check manually");
	}
	
	@Test(priority = 20, groups = {"sanity"}, description="On Operation Theatre module, Verify clicking \"New OT Booking\" button popup \"Booking OT Schedule | New Patient\" form. \r\n"
			+ "As well as try to book a New OT Booking without patient Name popup the alert message \"Patient not Selected! Please Select the patient first!\".")
	public void  handleAlertPopup() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.handleAlertPopup(), "Unable to handle the alert popup, please check manually");	
	    Assert.assertTrue(locatorsFactoryInstance.addNewOTButtonIsPresent(driver).isDisplayed(), "Manage Role Tab is not present in the current page, Please check manually");
	}
	
	@Test(priority = 21, groups = {"sanity"}, description="On Procurement module's \"Add Other Charges\" page, First, tick all check boxes and validate that the all selected checkboxes are selected or not and validate the VAT (IN %) text field is present or after click on VAT is applicable checkbox. ")
	public void handleCheckBox() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "percentageValue");
		Assert.assertTrue(dispensary_PagesInstance.handleCheckBox(expectedData),"Any of the checkbox is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.vatInPercentageTextboxIsPresent(),"vat in percentage textbox is not present in the current page, Please check manually");
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
