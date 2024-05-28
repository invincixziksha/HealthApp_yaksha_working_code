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
import pages.yakshaHealthApp_L2_Pages;
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class yakshaHealthApp_L2_TestCase extends AppTestBase
{
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath+"expected_data.json";
	StartupPage startupPage;
	yakshaHealthApp_L2_Pages yakshaHealthAppL2Instance ;
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
	
	@Test(priority = 1, groups = {"sanity"}, description="Login to the yakshaHealth App")
	public void loginToTheYakshaHealthApp() throws Exception {
		yakshaHealthAppL2Instance = new yakshaHealthApp_L2_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		String expectedDataFilePath = testDataFilePath+"Login.json";
		Map<String, String> loginData = new FileOperations().readJson(expectedDataFilePath, "credentials");
		Assert.assertTrue(yakshaHealthAppL2Instance.loginToTheYakshahealthApp(loginData), "Login failed,, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.headerNotificationBarIsPresent(driver).isDisplayed(), "Header Notification Bar is not present in the current page, Please check manually");
	}
	
	@Test(priority = 2, groups = {"sanity"}, description="Search for a patient name and view the details of the selected patient")
	public void searchForApatientAndViewDetailsOfSelectedPatient() throws Exception {
		yakshaHealthAppL2Instance = new yakshaHealthApp_L2_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "YakshaHealthApp");
		Assert.assertTrue(yakshaHealthAppL2Instance.searchForPatientAndViewDetailsOfSelectedPatient(expectedData), "User is not able to view the details of the patient, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.admittingDocFieldIsPresent(driver).isDisplayed(), "AdmittingDoc field is not present in the current page, Please check manually");
	}
	
	@Test(priority = 3, groups = {"sanity"}, description="Tick all check boxes then untick them then close that popup")
	public void  tickAllCheckBoxesThenUntickthemThenCloseThatPopup() throws Exception {
		yakshaHealthAppL2Instance = new yakshaHealthApp_L2_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(yakshaHealthAppL2Instance.tickallCheckBoxesThenUntickthemThenCloseThatPopup(), "Unable to handle the checkBoxes, please check manually");	
		Assert.assertTrue(locatorsFactoryInstance.newItemButtonPresent(driver).isDisplayed(), "CheckBox is not present in the current page, Please check manually");
	}
	
	@Test(priority = 4, groups = {"sanity"}, description="Take screenshot of Doctor page")
	public void  takeScreenshotOfDoctorPage() throws Exception {
		yakshaHealthAppL2Instance = new yakshaHealthApp_L2_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(yakshaHealthAppL2Instance.takeScreenshotOfTheDoctorPage(), "Unable to take the Screenshot , please check manually");	
	    Assert.assertTrue(locatorsFactoryInstance.myFavoritesButtonIsPresent(driver).isDisplayed(), "My Favorites Button is not present in the current page, Please check manually");
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
