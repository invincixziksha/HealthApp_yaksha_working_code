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

	@Test(priority = 1, groups = {"sanity"}, description="Verify the title and url of  the current page.")
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
	@Test(priority = 2, groups = {"sanity"}, description="verify the Dispensary module is present or not")
	public void verifyDispensaryModuleIsPresentOrNot() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.verifyDispensaryModuleIsPresentOrNot(), "Dispensary Module is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.registeredPatientTextElementIsPresent(driver).isDisplayed(), "Registered Patient Text Element is not present in the current page, Please check manually");
	}
	
	@Test(priority = 3, groups = {"sanity"}, description="verify all sub-modules are displayed correctly after clicking on the Dispensary Module")
	public void verifyAllSubModulesArePresent() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.verifyAllSubModulesArePresentAndClickOnDispensary(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.morningCounterIsPresent(driver).isDisplayed(), "Morning Counter is not present in the current page, Please check manually");
	}
	
	
	@Test(priority = 4, groups = {"sanity"}, description="scroll to the bottom of the Sale page and verify that Print Invoice button  , Discard button  ,Invoice History and  Credit Limitis and Balance text are peresent or not.")
	public void scrollToButtomAndVerifyTheFields() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.scrollToButtomAndVerifytheFields(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.printInvoiceButtonElementIsPresent(driver).isDisplayed(), "Print Invoice Button Element is not present in the current page, Please check manually");
	}
	
	
	@Test(priority = 5, groups = {"sanity"}, description="Perform the keyboard operation to open the  popup and verify that the popup is displayed or not.")
	public void performTheKeyboardOperationToOpenThePopup() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.performTheKeyboardOperationToOpenthePopup(), "Not able to do the keyboard operation, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.firstNameFieldIsPresent(driver).isDisplayed(), "firstName field is not present in the current page, Please check manually");
	}
	
	@Test(priority = 6, groups = {"sanity"}, description="validate the error message in firstname textfield after click on Ok button")
	public void validateTheErrorMessageInFirstnameTextfield() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthAppErrorMessages");
		Assert.assertEquals(dispensary_PagesInstance.validateErrorMessageInFirstnameTextfield(),expectedData.get("FirstNameFieldErrorMessage"),"Error message is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.errorMeesageInLastNameTextFieldErrorMessageIsPresent(driver).isDisplayed(), "Error message is not present in the current page, Please check manually");
	}
	
	@Test(priority = 7, groups = {"sanity"}, description="Fill all the textfields which are present inside the Add New Patient popup and verify that value is present after enter the values")
	public void fillAllTheTextfields() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "addNewPatientPopup");
		Assert.assertEquals(dispensary_PagesInstance.fillAllTheTextfieldsInsideTheAddNewPatientVerifyTheFirstName(expectedData), expectedData.get("firstName"),"firstName Text is not present in the current page, Please check manually");
		Assert.assertEquals(locatorsFactoryInstance.ContactNumberTextFieldIsPresent(),expectedData.get("contact"),"Contact field Text is not present in the current page, Please check manually");
	}
	
	
	@Test(priority = 8, groups = {"sanity"}, description="Navigate to the Last page of the stock details list pagenation and fetch the total stock value")
	public void navigateToLastPageOfTheStockDetails() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.navigateToLastPageOfTheStockDetailsAndFetchTotalStockValue(), "user is not able to navigate to the LastPageOfTheStockDetails, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.totalStockValueTextIsPresent(driver).isDisplayed(), "Total Stock Value Text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 9, groups = {"sanity"}, description="check Main Dispensary is selected from filter stock dropdown or not")
	public void checkMainDispensaryIsSelected() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.checkMainDispensaryIsSelectedFromFilterStockDropdown(), "Main Dispensary option is not selected in that dropdown, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.mainStoreOptionIsSelected(driver).isSelected(), "Main Store Option is not selected in the current page, Please check manually");
	}
	
	@Test(priority = 10, groups = {"sanity"}, description="validate create requisition button is present")
	public void validateCreateRequisitionButton() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.validateCreateRequisitionButtonIsPresent(), "Create Requisition Button is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.createRequisitionButtonIsPresent(driver).isDisplayed(), "Requisition Button is not present in the current page, Please check manually");
	}
		
	@Test(priority = 11, groups = {"sanity"}, description="verify New Item text field is present in Add Requisition page")
	public void verifyTheFieldIsPresent() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.verifyNewItemTextFieldIsPresent(), "NewItem TextField is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.remarksTextFieldIsPresent(driver).isDisplayed(), "Remarks TextField is not present in the current page, Please check manually");
	}
	@Test(priority = 12, groups = {"sanity"}, description="Verify Requisition Details Print page")
	public void verifyThePageShouldCome() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.verifyRequisitionDetailsPrintPageIsDisplayed(), "Requisition Details Print Page is not displayed, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.denphehLogoIsPresent(driver).isDisplayed(), "Denpheh Logo is not present in the current page, Please check manually");
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
