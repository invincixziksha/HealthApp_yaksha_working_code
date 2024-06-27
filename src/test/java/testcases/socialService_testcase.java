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

	@Test(priority = 2, groups = {"sanity"}, description="Verify that SocialService module is present and Go to SocialService Tab")
	public void verifySocialServiceModuleIsPresentAndGoToSocialServiceTab() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.verifySocialServiceModuleisPresentAndGoToSocialServiceTab(), "SocialService Module is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.editInformationOfTextFieldIsPresent(driver).isDisplayed(), "Edit Information Of TextField is not present in the current page, Please check manually");
	}

	@Test(priority = 3, groups = {"sanity"}, description="Verify that Register New SSU Patient button is present inside the SocialService Tab.")
	public void registerNewSSUPatientButtonIsPresent() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.registerNewSSUPatientButtonisPresent(), "Register NewSSUPatient Button is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.SSUPatientListButtonIsPresent(driver).isDisplayed(), "SSUPatientList Button is not present in the current page, Please check manually");
	}

	@Test(priority = 4, groups = {"sanity"}, description="Verify that Search Bar is present inside the SocialService Tab.")
	public void searchBarIsPresentInsideTheSocialServiceTab() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.searchbarIsPresentInsideTheSocialServiceTab(), "Search bar is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.registerNewSSUPatientButtonIsPresent(driver).isDisplayed(), "Register NewSSUPatient Button is not present, please check manually");
	}

	@Test(priority = 5, groups = {"sanity"}, description="Verify New SSU Patient Registration popup is displayed after clicking on the Register New SSU Patient button")
	public void verifyNewSSUPatientRegistrationPopupIsDisplayed() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.verifyNewSSUpatientRegistrationPopupIsDisplayed(), "NewSSUpatientRegistration Popup is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.firstNameTextFieldIsPresent(driver).isDisplayed(), "firstName TextField is not present in the current page, Please check manually");
	}

	@Test(priority = 6, groups = {"sanity"}, description="Fill all the textfields which are present inside the New SSU Patient Registration popup  and Check the data which we are entered are present in First Name Field.")
	public void fillAllTheTextfields() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "NewSSUPatientRegistrationPopup");
		Assert.assertEquals(socialService_PagesInstance.fillAllTheTextfieldsinsideTheNewSSUPatientRegistration(expectedData), expectedData.get("firstName"),"Any of the field is not present in the current page, Please check manually");
		Assert.assertEquals(locatorsFactoryInstance.phoneNumberTextFieldIsPresent(),expectedData.get("phoneNo."),"phoneNumber field Text is not present in the current page, Please check manually");
	}

	@Test(priority = 7, groups = {"sanity"}, description="Enter invalid data in phone number field and validate the error message")
	public void validateTheErrorMessage() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "NewSSUPatientRegistrationPopup");
		Assert.assertEquals(socialService_PagesInstance.enterInvalidDataValidateTheErrorMessage(expectedData), expectedData.get("invalidPhoneNoError"));
		Assert.assertTrue(locatorsFactoryInstance.phoneNumberTextFieldErrorMessageIsPresent(driver).isDisplayed(),"phoneNumber field Text is not present in the current page, Please check manually");
	}

	@Test(priority = 8, groups = {"sanity"}, description="Simply select India  from the Country dropdown menu and validate India is selected or not.")
	public void selectIndiaFromTheCountryDropdownMenuAndValidate() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.selectIndiaFromCountryDropdownMenuAndValidate(), "India is not present in this dropdown is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.countryDropdownIsPresent(driver).isDisplayed(), "country Dropdown is not present in the current page, Please check manually");
	}
	
	@Test(priority = 9, groups = {"sanity"}, description="Validate the warnning message for the membership dropdown.")
	public void validateWarnningMessageForMembershipDropdown() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "NewSSUPatientRegistrationPopup");
		Assert.assertEquals(socialService_PagesInstance.validateWarnningMessageForMembershipDropDown(expectedData), expectedData.get("warnningMessage"),"Warning message is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.warningMessageIsPresent(driver).isDisplayed(), "Warning message is not present in the current page, Please check manually");
	}
	
	@Test(priority = 10, groups = {"sanity"}, description="select Yes from the Has target group certificate? dropdown and verify that Target group certificate type and certificate no textfield is present or not ")
	public void selectYesFromHasTargetGroupCertificateAndValidate() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.selectYesFromHasTargetGroupCertificateandValidate(), " Yes option is not present in that dropdown, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.hasTG_certificateDropdownIsPresent(driver).isDisplayed(), "hasTG_certificate Dropdown is not present in the current page, Please check manually");
	}
	
	@Test(priority = 11, groups = {"sanity"}, description="get the place holder name of address textfiled and verify  the place holder name.")
	public void getPlaceHolderNameVerifyPlaceHolderName() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "NewSSUPatientRegistrationPopup");
		Assert.assertEquals(socialService_PagesInstance.getPlaceHolderNameVerifyPlaceHolderNameOfAddress(expectedData), expectedData.get("AddressFieldPlaceHolder"),"Not able to verify the placeholder name, please check manually");
		Assert.assertEquals(locatorsFactoryInstance.raceTextFieldPlaceHolderIsPresent(),expectedData.get("RaceFieldPlaceHolder"),"race Textfield is not present in the current page, Please check manually");
	}
	
	@Test(priority = 12, groups = {"sanity"}, description="verify the presence of field in New SSU Patient Registration page and verify Patient Information text is present")
	public void verifypresencefield() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.verifypresencefieldInNewSSUPatientRegistrationPage(), "Any of the field is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.newSsuPatientRegistrationTextFieldIsPresent(driver).isDisplayed(), "new ssu Patient Registration text field is not present in the current page, Please check manually");
	}
	
	@Test(priority = 13, groups = {"sanity"}, description="Close this New SSU Patient Registration popup by using javaScript")
	public void performJavaScriptExecutorOperation() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.closeNewSSUPatientRegistrationPopupByUsingJsExecutor(), "Unable to perform the js Executor operation, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.listByPatientStatusRadioButtonIsPresent(driver).isSelected(), "RadioButton is not present in the current page, Please check manually");
	}
	
	
	@Test(priority = 14, groups = {"sanity"}, description="scroll to the bottom of the Sale page and verify that Print Invoice button  , Discard button  ,Invoice History and  Credit Limitis and Balance text are peresent or not.")
	public void scrollToButtomAndVerifyTheFields() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.scrollToButtomAndVerifytheFields(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.printInvoiceButtonElementIsPresent(driver).isDisplayed(), "Print Invoice Button Element is not present in the current page, Please check manually");
	}
	
	@Test(priority = 15, groups = {"sanity"}, description="Perform the keyboard operation to open the  popup and verify that the popup is displayed or not.")
	public void performTheKeyboardOperationToOpenThePopup() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(socialService_PagesInstance.performTheKeyboardOperationToOpenthePopup(), "Not able to do the keyboard operation, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.firstNameFieldIsPresent(driver).isDisplayed(), "firstName field is not present in the current page, Please check manually");
	}
	
//Social service module(L2)
	
	@Test(priority = 16, groups = {"sanity"}, description="Verify tooltip of an element which is present inside the Appointment page.")
	public void  verifyTooltipOfAnElement() throws Exception {
		socialService_PagesInstance = new socialService_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "KeyBoardTooltip");
		Assert.assertEquals(socialService_PagesInstance.verifyToolTipOfAnElement(), expectedData.get("TooltipValue"),"Verification failed, please check manually");
	    Assert.assertTrue(locatorsFactoryInstance.tooltipTextIsPresent(driver).isDisplayed(), "Tooltip is not present in the current page, Please check manually");
	}
	
//	@Test(priority = 17, groups = {"sanity"}, description="Upload a image in Scanned Images section")
//	public void uploadImageInScannedImagesSection() throws Exception {
//		socialService_PagesInstance = new socialService_Pages(driver);
//		locatorsFactoryInstance = new LocatorsFactory(driver);
//		Assert.assertTrue(socialService_PagesInstance.uploadImageInScannedImagesSection(System.getProperty("user.dir") + "\\testImage\\uploadImage.png"),"Not able to upload the image, please check manually");
//		Assert.assertTrue(locatorsFactoryInstance.saveButtonIsPresent(driver).isDisplayed(),"Save button is not present in the current page, Please check manually");
//	}
//	
//	@Test(priority = 18, groups = {"sanity"}, description="First, tick all check boxes and validate that the all selected checkboxes are selected or not then untick them then close Add Other Charges.")
//	public void tickAllCheckboxesValidateThenUntick() throws Exception {
//		socialService_PagesInstance = new socialService_Pages(driver);
//		locatorsFactoryInstance = new LocatorsFactory(driver);
//		Assert.assertTrue(socialService_PagesInstance.tickAllCheckboxesThenValidateThenUntick(),"Any of the checkbox is not present, please check manually");
//		Assert.assertTrue(locatorsFactoryInstance.submitButtonIsPresent(driver).isDisplayed(),"Submit button is not present in the current page, Please check manually");
//	}
//	
//	@Test(priority = 19, groups = {"sanity"}, description="Taking screenshot of the current page")
//	public void takingScreenshotOfCurrentPage() throws Exception {
//		socialService_PagesInstance = new socialService_Pages(driver);
//		locatorsFactoryInstance = new LocatorsFactory(driver);
//		Assert.assertTrue(socialService_PagesInstance.takingScreenshotOfTheCurrentPage(),"Not able to take the screenshot, please check manually");
////		Assert.assertTrue(locatorsFactoryInstance.submitButtonIsPresent(driver).isDisplayed(),"Race TextField is not present in the current page, Please check manually");
//	}
//	
//	@Test(priority = 20, groups = {"sanity"}, description="Search for a Select Item as Accounts and select Accounts  and validate Accounts is selected.")
//	public void searchSelectItemAsAccountsAndValidate() throws Exception {
//		socialService_PagesInstance = new socialService_Pages(driver);
//		locatorsFactoryInstance = new LocatorsFactory(driver);
//		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "ProcurementModule");
//		Assert.assertTrue(socialService_PagesInstance.searchSelectItemAsAccountsAndValidateAccountsIsSelected(expectedData),"User is not abale to handle the search bar, please check manually");
//		Assert.assertTrue(locatorsFactoryInstance.accountOptionIsSelected(driver).isDisplayed(),"Account option is not selectde, Please check manually");
//	}

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