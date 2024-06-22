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