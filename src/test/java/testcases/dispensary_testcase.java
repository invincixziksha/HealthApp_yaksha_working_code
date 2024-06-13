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
		Assert.assertTrue(dispensary_PagesInstance.verifyAllSubModulesArePresent(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.morningCounterIsPresent(driver).isDisplayed(), "Morning Counter is not present in the current page, Please check manually");
	}
	
	@Test(priority = 4, groups = {"sanity"}, description="verify all sub-modules are displayed correctly after clicking on the Dispensary Module")
	public void verifyUrlAlsoVerifyTheAllFields() throws Exception {
	dispensary_PagesInstance = new dispensary_Pages(driver);
	locatorsFactoryInstance = new LocatorsFactory(driver);
	Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthApp");
	Assert.assertEquals(dispensary_PagesInstance.verifyUrlOfCounterPage(), expectedData.get("CounterPageUrl"), "Url is not matching with expected, please check manually!");
	Assert.assertTrue(dispensary_PagesInstance.verifyAllFieldsInsideTheCounterPage(), "Any of the elememt is not present, please check manually");
	Assert.assertTrue(locatorsFactoryInstance.activeDispensaryFieldIsPresent(driver).isDisplayed(),"Active Dispensary Field Is not Present, please check manually!");
	}
	
	@Test(priority = 5, groups = {"sanity"}, description="verify the url of Sale new Page afetr click on Morning Counter Button and also verify the presence off all fields inside the Sale New Page")
	public void verifyTheUrlOfSalePageAlsoVerifyThePresenceOfAllFields() throws Exception {
	dispensary_PagesInstance = new dispensary_Pages(driver);
	locatorsFactoryInstance = new LocatorsFactory(driver);
	Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthApp");
	Assert.assertEquals(dispensary_PagesInstance.verifyUrlOfSalePage(), expectedData.get("SalePageUrl"), "Url is not matching with expected, please check manually!");
	Assert.assertTrue(dispensary_PagesInstance.verifyAllFieldsInsideTheSalePage(), "Any of the elememt is not present, please check manually");
	Assert.assertTrue(locatorsFactoryInstance.searchPatientTextFieldIsPresent(driver).isDisplayed(),"Search Patient Text Field Is not Present, please check manually!");
	}
	
	@Test(priority = 6, groups = {"sanity"}, description="Verify that the dispensary arrow is expanding")
	public void scrollToButtomOfTheSalePageAndVerifyPresenceOfFields() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);	
		Assert.assertTrue(dispensary_PagesInstance.scrollToButtomOfTheSalePageAndVerifyPresenceOfFields(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.creditLimitsAndBalancesTextElementIsPresent(driver).isDisplayed(), "Credit LimitsAndBalances Text Element is not present, please check manually");
	}
	
	@Test(priority = 7, groups = {"sanity"}, description="Perform the keyboard operation to open the  popup and verify that the popup is displayed or not.")
	public void performTheKeyboardOperationToOpenThePopup() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.performTheKeyboardOperationToOpenthePopup(), "Not able to do the keyboard operation, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.firstNameFieldIsPresent(driver).isDisplayed(), "firstName field is not present in the current page, Please check manually");
	}
	
	@Test(priority = 8, groups = {"sanity"}, description="validate the error message in firstname textfield after click on Ok button")
	public void validateTheErrorMessageInFirstnameTextfield() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthAppErrorMessages");
		Assert.assertEquals(dispensary_PagesInstance.validateErrorMessageInFirstnameTextfield(),expectedData.get("FirstNameFieldErrorMessage"),"Error message is not present in the current page, Please check manually") ;
		Assert.assertTrue(locatorsFactoryInstance.errorMeesageInLastNameTextFieldErrorMessageIsPresent(driver).isDisplayed(), "Error message is not present in the current page, Please check manually");
	}
	
	@Test(priority = 9, groups = {"sanity"}, description="Fill all the textfields which are present inside the Add New Patient popup.")
	public void fillAllTheTextfields() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "addNewPatientPopup");
		Assert.assertEquals(dispensary_PagesInstance.fillAllTheTextfieldsInsideTheAddNewPatient(expectedData), expectedData.get("firstName"),"firstName Text is not present in the current page, Please check manually");
		Assert.assertEquals(locatorsFactoryInstance.ContactNumberTextFieldIsPresent(),expectedData.get("contact"),"Contact field Text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 10, groups = {"sanity"}, description="Check the data which we are entered are present in First Name Field")
	public void checkTheDataArePresentInFirstNameField() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "addNewPatientPopup");
		Assert.assertEquals(dispensary_PagesInstance.checktheDataArePresentInFirstNameField(), expectedData.get("firstName"));
		Assert.assertEquals(locatorsFactoryInstance.firstNameTextFieldInAddNewPatientIsPresent(),expectedData.get("firstName"),"firstName Text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 11, groups = {"sanity"}, description="Navigate to the Last page of the stock details list pagenation and fetch the total stock value")
	public void navigateToLastPageOfTheStockDetails() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.navigateToLastPageOfTheStockDetailsAndFetchTotalStockValue(), "user is not able to navigate to the LastPageOfTheStockDetails, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.totalStockValueTextIsPresent(driver).isDisplayed(), "Total Stock Value Text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 12, groups = {"sanity"}, description="select \"All\" from the filter by store dropdown field and the get Total stock value")
	public void selectAllFromFilterDropdownAndGetTotalStockValue() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.selectAllFromFilterDropdownAndGetTotalStockValue(), "user not able to select the value stock dropdown, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.totalStockValueTextIsPresent(driver).isDisplayed(), "Total Stock Value Text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 13, groups = {"sanity"}, description="select \"Main Dispensary\" from the filter by store dropdown field and the get Total stock value")
	public void selectMainDispensaryFromFilterDropdownAndGetTotalStockValue() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.selectMainDispensaryFromFilterDropdownAndGetTotalStockValue(), "user not able to select the value stock dropdown, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.totalStockValueTextIsPresent(driver).isDisplayed(), "Total Stock Value Text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 14, groups = {"sanity"}, description="select \"Main Store\" from the filter by store dropdown field and the get Total stock value")
	public void selectMainStoreFromFilterDropdownAndGetTotalStockValue() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(dispensary_PagesInstance.selectMainStoreFromFilterDropdownAndGetTotalStockValue(), "user not able to select the value stock dropdown, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.totalStockValueTextIsPresent(driver).isDisplayed(), "Total Stock Value Text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 15, groups = {"sanity"}, description="validate \"create requisition\" button is present or not")
	public void clickOnRequisitionsTabAndValidateCreateRequisitionsButtonIsPresent() throws Exception {
		dispensary_PagesInstance = new dispensary_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "commonStringvalue");
		Assert.assertEquals(dispensary_PagesInstance.clickOnRequisitionsTabAndValidateCreateRequisitionsButtonIsPresent(), expectedData.get("createRequisitionsButtonValue"), "Create requisitions value is not matching, please check manually");
		Assert.assertEquals(locatorsFactoryInstance.createRequisitionsButtonIsPresent(),expectedData.get("createRequisitionsButtonValue"),"firstName Text is not present in the current page, Please check manually");
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
