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

	@Test(priority = 2, groups = {"sanity"}, description="Verify that OperationTheatre module is present and Go to OperationTheatre Tab")
	public void verifyOperationTheatreModuleIsPresent() throws Exception {
		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(operationTheatre_PagesInstance.verifyOperationTheatreModuleIsPresentAndGoToOperationTheatreTab(), "OperationTheatre Module is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.printButtonWebElementIsPresent(driver).isDisplayed(), "Print button is not present in the current page, Please check manually");
	}
	
	@Test(priority = 3, groups = {"sanity"}, description="Verify that New OT Booking button is present inside the OperationTheatre Tab.")
	public void verifyNewOTButtonIsPresent() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModuleStringValue");
		
		Assert.assertEquals(operationTheatre_PagesInstance.verifyNewOTButtonIsPresent(),expectedData.get("newOTButtonValue")) ;
//		Assert.assertTrue(locatorsFactoryInstance.totalDoctorTextIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 4, groups = {"sanity"}, description="Verify that Search Bar is present inside the OperationTheatre Tab.")
	public void verifySearchTextboxIsPresent() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModuleStringValue");
		
		Assert.assertEquals(operationTheatre_PagesInstance.verifySearchTextboxIsPresent(expectedData),expectedData.get("searchBarData")) ;
//		Assert.assertTrue(locatorsFactoryInstance.totalDoctorTextIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 5, groups = {"sanity"}, description="Verify Booking OT Schedule popup is displayed after clicking on the New OT Booking button.")
	public void verifyBookingOTSchedulePopupPageIsPresent() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModuleStringValue");
		
		Assert.assertEquals(operationTheatre_PagesInstance.verifyBookingOTSchedulePopupPageIsPresent(),expectedData.get("bookingOTSchedulePageName")) ;
//		Assert.assertTrue(locatorsFactoryInstance.totalDoctorTextIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 6, groups = {"sanity"}, description="Fill all the textfields which are present inside the Booking OT Schedule popup and Check the data which we are entered are present in  Type of Surgery Field.")
	public void verifyEnteredDataIsPresentInTextbox() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModuleStringValue");
		
		Assert.assertEquals(operationTheatre_PagesInstance.verifyEnteredDataIsPresentInTextbox(expectedData),expectedData.get("surgeryTypeValue")) ;
//		Assert.assertTrue(locatorsFactoryInstance.totalDoctorTextIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 7, groups = {"sanity"}, description="Verify \"Remarks\" Text area is enable or not and verify the attribute value of \"Remarks\" text area.")
	public void verifyTextboxIsEnableAndValidatePlaceholderName() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModuleStringValue");
		
		Assert.assertEquals(operationTheatre_PagesInstance.verifyTextboxIsEnableAndValidatePlaceholderName(),expectedData.get("remarksPlaceHolderName")) ;
//		Assert.assertTrue(locatorsFactoryInstance.totalDoctorTextIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 8, groups = {"sanity"}, description="type \"Dr. pooja Mishra\" in surgen Name textfield and select \"Dr. Pooja Mishra\" from the suggestion after that validate whether the pooja mishra is present in surgen text field or not")
	public void verifyButtonIsPresentAfterSendValueToSurgenNameTextfield() throws Exception {

		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "operationTheatreModuleStringValue");
		
		Assert.assertEquals(operationTheatre_PagesInstance.verifyButtonIsPresentAfterSendValueToSurgenNameTextfield(expectedData),expectedData.get("surgenNameValue2")) ;
//		Assert.assertTrue(locatorsFactoryInstance.totalDoctorTextIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}
	
	@Test(priority = 9, groups = {"sanity"}, description="Verify that OperationTheatre module is present and Go to OperationTheatre Tab")
	public void verifyPlusButtonIsPresentAfterClickOnExternalCheckbox() throws Exception {
		operationTheatre_PagesInstance = new operationTheatre_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(operationTheatre_PagesInstance.verifyPlusButtonIsPresentAfterClickOnExternalCheckbox(), "OperationTheatre Module is not present, please check manually");
//		Assert.assertTrue(locatorsFactoryInstance.printButtonWebElementIsPresent(driver).isDisplayed(), "Print button is not present in the current page, Please check manually");
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
