package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class yakshaHealthApp_L1_Pages extends StartupPage {

	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");
	By billingNavigationMenuElement = By.xpath("(//span[contains(text(), 'Billing')])[1]");
	By selectCounterPopupElement = By.xpath("//h3//span[contains(text(), 'Select Counter')]");
	By new1TextElement = By.xpath("//h5[contains(text(), 'New-1')]");
	By new2TextElement = By.xpath("//h5[contains(text(), 'New-2')]");
	By new3TextElement = By.xpath("//h5[contains(text(), 'New-3')]");
	By old1TextElement = By.xpath("//h5[contains(text(), 'Old-1')]");
	By opdCounterTextElement = By.xpath("//h5[contains(text(), 'OPD-Counter')]");



	String pageName = this.getClass().getSimpleName();
	public yakshaHealthApp_L1_Pages(WebDriver driver) 
	{
		super(driver);
	}

	/**@Test1
	 * about this method loginTohealthAppByGivenValidCredetial() 
	 * @param : Map<String, String>
	 * @description : fill usernameTextbox & passwordTextbox and click on sign in button
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			WebElement usernametextFieldWebElement = commonEvents.findElement(usernameTextbox);
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(usernameTextbox,expectedData.get("username"));

			WebElement passwordtextFieldWebElement = commonEvents.findElement(passwordTextbox);
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));

			WebElement signinButtonWebElement = commonEvents.findElement(signInButton);
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.click(signInButton);

			if(commonEvents.isDisplayed(registeredPatientTextElement))
			{   
				WebElement registeredPatientTextWebElement = commonEvents.findElement(registeredPatientTextElement);
				commonEvents.highlightElement(registeredPatientTextWebElement);
				textIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return textIsDisplayed;
	}

	/**@Test1.2
	 * about this method verifyTitleOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the title of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyTitleOfThePage() throws Exception {
		String pageTitle = "";
		try {
			pageTitle = commonEvents.getTitle();
			System.out.println("title of the page is  :" + pageTitle );
		}catch(Exception e) {
			throw e;
		}	
		return pageTitle;
	}

	/**@Test1.3
	 * about this method verifyURLOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyURLOfThePage() throws Exception {
		String urlofThepage = "";
		try {
			urlofThepage = commonEvents.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage );
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}

	/**@test2
	 * about this method verifySelectCounterPopupIsPresentAndNavigateToNextpage() 
	 * @param : null
	 * @description : it is verify all fields is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifySelectCounterPopupIsPresentAndNavigateToNextpage() throws Exception {
		Boolean selectCounterPopUpIsPresent = false;

		WebElement billingNavigationMenuWebElement = commonEvents.findElement(billingNavigationMenuElement);
		commonEvents.highlightElement(billingNavigationMenuWebElement);
		commonEvents.click(billingNavigationMenuElement);
		try {
			if(commonEvents.isDisplayed(selectCounterPopupElement)&&
					commonEvents.isDisplayed(new1TextElement)&&
					commonEvents.isDisplayed(new2TextElement)&&
					commonEvents.isDisplayed(new3TextElement)&&
					commonEvents.isDisplayed(old1TextElement)&&
					commonEvents.isDisplayed(opdCounterTextElement)) {

				WebElement selectCounterPopupWebElement = commonEvents.findElement(selectCounterPopupElement);
				commonEvents.highlightElement(selectCounterPopupWebElement);

				WebElement new1TextWebElement = commonEvents.findElement(new1TextElement);
				commonEvents.highlightElement(new1TextWebElement);

				WebElement new2TextWebElement = commonEvents.findElement(new2TextElement);
				commonEvents.highlightElement(new2TextWebElement);

				WebElement new3TextWebElement = commonEvents.findElement(new3TextElement);
				commonEvents.highlightElement(new3TextWebElement);

				WebElement old1TextWebElement = commonEvents.findElement(old1TextElement);
				commonEvents.highlightElement(old1TextWebElement);

				WebElement opdCounterTextWebElement = commonEvents.findElement(opdCounterTextElement);
				commonEvents.highlightElement(opdCounterTextWebElement);

				selectCounterPopUpIsPresent = true;
			}
			commonEvents.click(new1TextElement);
			Thread.sleep(5000);
		}catch(Exception e) {
			throw e;	
		}
		return selectCounterPopUpIsPresent;
	}

}
