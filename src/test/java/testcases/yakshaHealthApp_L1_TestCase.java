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
import pages.yakshaHealthApp_L1_Pages;
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class yakshaHealthApp_L1_TestCase extends AppTestBase
{
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath + "expected_data.json";
	String loginFilePath = loginDataFilePath + "Login.json";
	StartupPage startupPage;
	yakshaHealthApp_L1_Pages yakshaHealthAppL1Instance;
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

		yakshaHealthAppL1Instance = new yakshaHealthApp_L1_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> loginData = new FileOperations().readJson(loginFilePath, "credentials");
		Assert.assertTrue(yakshaHealthAppL1Instance.loginToHealthAppByGivenValidCredetial(loginData),"Login failed, Invalid credentials ! Please check manually");

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthApp");
		Assert.assertEquals(yakshaHealthAppL1Instance.verifyTitleOfThePage(),expectedData.get("dasboardTitle")) ;
		Assert.assertEquals(yakshaHealthAppL1Instance.verifyURLOfThePage(),expectedData.get("pageUrl")) ;
		Assert.assertTrue(locatorsFactoryInstance.totalDoctorTextIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}

	@Test(priority = 2, groups = {"sanity"}, description="Verify all fields and select counter pop up is present or not and proceed to the next page from the new 1 counter page.")
	public void verifySelectCounterPopupIsPresentAndNavigateToNextpage() throws Exception {
		yakshaHealthAppL1Instance = new yakshaHealthApp_L1_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Assert.assertTrue(yakshaHealthAppL1Instance.verifySelectCounterPopupIsPresentAndNavigateToNextpage(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.addNewButtonIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}

	@Test(priority = 3, groups = {"sanity"}, description="Perform the keyboard operation to open the  popup and verify that the popup is displayed or not.")
	public void performKeyBoardOperationToOpenAddNewPatientPopup() throws Exception {
		yakshaHealthAppL1Instance = new yakshaHealthApp_L1_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "healthApp");
		Assert.assertEquals(yakshaHealthAppL1Instance.performKeyBoardOperationToOpenAddNewPatientPopup(),expectedData.get("addNewpatientPopupTextValue"), "add New patient is not present, please check manually!") ;
		Assert.assertTrue(locatorsFactoryInstance.registerAndBillingButtonIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
	}

	@Test(priority = 4, groups = {"sanity"}, description="Fill all the textfields which are present inside the Add New Patient popup and verify")
	public void fillTheTextFieldInAddNewPatientPopup() throws Exception {
		yakshaHealthAppL1Instance = new yakshaHealthApp_L1_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "addNewPatientPopup");
		Assert.assertEquals(yakshaHealthAppL1Instance.fillTheTextFieldInAddNewPatientPopup(expectedData), expectedData.get("firstName"));
		Assert.assertEquals(locatorsFactoryInstance.verifyFirstNameTextValueIsPresent(), expectedData.get("firstName"));
	}

	@Test(priority = 5, groups = {"sanity"}, description="Check the data which we are entered are present in all the textfields.")
	public void verifyEnteredValueIsPresent() throws Exception {
		yakshaHealthAppL1Instance = new yakshaHealthApp_L1_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "addNewPatientPopup");

		Assert.assertEquals(yakshaHealthAppL1Instance.verifyFirstNameIsPresent(), expectedData.get("firstName"));
		Assert.assertEquals(yakshaHealthAppL1Instance.verifyMiddleNameIsPresent(), expectedData.get("middleName"));
		Assert.assertEquals(yakshaHealthAppL1Instance.verifyLastNameIsPresent(), expectedData.get("lastName"));
		Assert.assertEquals(yakshaHealthAppL1Instance.verifyAgeValueIsPresent(), expectedData.get("age"));
		Assert.assertEquals(yakshaHealthAppL1Instance.verifyContactNumberIsPresent(), expectedData.get("contact"));

		Assert.assertEquals(locatorsFactoryInstance.verifyRegisterOnlyButtonIsPresent(), expectedData.get("registerOnlyButtonValue"));
	}
	
	@Test(priority = 6, groups = {"sanity"}, description="Simply select India  from the country dropdown menu and validate India is selected or not.")
	public void verifyIndiaIsSelectedFromCountryDropdown() throws Exception {
		yakshaHealthAppL1Instance = new yakshaHealthApp_L1_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver); 

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "addNewPatientPopup");
		Assert.assertEquals(yakshaHealthAppL1Instance.verifyIndiaIsSelectedFromCountryDropdown(expectedData), expectedData.get("selectedCountryName"), "selected country is not matching with expected, please check manually!");
		Assert.assertEquals(locatorsFactoryInstance.verifyIndiaIsPresent(), expectedData.get("selectedCountryName"), "selected country is not matching with expected, please check manually!");
	}
	
	@Test(priority = 7, groups = {"sanity"}, description="Verify the error message, when I click on register and billing button without fill any data.")
	public void validateErrorMessageWhenClickOnRegisterBillingButton() throws Exception {
		yakshaHealthAppL1Instance = new yakshaHealthApp_L1_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "addNewPatientPopup");
		Assert.assertEquals(yakshaHealthAppL1Instance.validateErrorMessageWhenClickOnRegisterBillingButton(), expectedData.get("errorMessageOfRegisterBilling"), "Error Message is not matching with expected, please check manually!");
		Assert.assertEquals(locatorsFactoryInstance.verifyErrorMessageIsPresent(), expectedData.get("errorMessageOfRegisterBilling"), "Error Message is not matching with expected, please check manually!");
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
