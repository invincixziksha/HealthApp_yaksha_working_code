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
	
	@Test(priority = 1, groups = {"sanity"}, description="Verify the title and url of the current page.")
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
	
	@Test(priority = 2, groups = {"sanity"}, description="verify Presence Of All Fields in The Login Page")
	public void verifySelectCounterPopupIsPresentAndNavigateToNextpage() throws Exception {
		yakshaHealthAppL1Instance = new yakshaHealthApp_L1_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		
		Assert.assertTrue(yakshaHealthAppL1Instance.verifySelectCounterPopupIsPresentAndNavigateToNextpage(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.addNewButtonIsPresent(driver).isDisplayed(), "total doctors text is not present in the current page, Please check manually");
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
