package testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.StartupPage;

public class LocatorsFactory extends StartupPage {
	
	By totalDoctortextElement = By.xpath("//p[contains(text(), 'Total Doctors')]");
	By selectCounterPopupElement = By.xpath("//h3//span[contains(text(), 'Select Counter')]");
	By new1TextElement = By.xpath("//h5[contains(text(), 'New-1')]");
	By new2TextElement = By.xpath("//h5[contains(text(), 'New-2')]");
	By new3TextElement = By.xpath("//h5[contains(text(), 'New-3')]");
	By old1TextElement = By.xpath("//h5[contains(text(), 'Old-1')]");
	By opdCounterTextElement = By.xpath("//h5[contains(text(), 'OPD-Counter')]");
	By addNewButtonElement = By.xpath("//button[contains(text(), 'Add New Patient')]");

	By headerNotificationBar=By.id("header_notification_bar");
	By admittingDocField=By.xpath("//b[.='Admitting Doc:']");
	By newItemButton=By.xpath("//button[.=' New Item ']");
	By myFavoritesButton=By.xpath("//a[.=' My Favorites']");
	By manageRoleTab=By.xpath("//a[.='Manage Role']");
	By tooltip=By.xpath("//li[contains(text(),'+')]");
	

	public LocatorsFactory(WebDriver driver) {
		super(driver);

	}


	public WebElement totalDoctorTextIsPresent(WebDriver driver) {
		WebElement totalDoctorTextWebElement = driver.findElement(totalDoctortextElement);
		commonEvents.highlightElement(totalDoctorTextWebElement);
		return totalDoctorTextWebElement; 
	}
	
	public Boolean verifyAllFieldIsPresent() throws Exception {
		Boolean allFieldIsPresent = false;
		try {
			if(commonEvents.isDisplayed(selectCounterPopupElement)&&
					commonEvents.isDisplayed(new1TextElement)&&
					commonEvents.isDisplayed(new2TextElement)&&
					commonEvents.isDisplayed(new3TextElement)&&
					commonEvents.isDisplayed(old1TextElement)&&
					commonEvents.isDisplayed(opdCounterTextElement)) {
				
				allFieldIsPresent = true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return allFieldIsPresent;
	}
	
	public WebElement addNewButtonIsPresent(WebDriver driver) {
		WebElement addNewButtonIsPresentWebElement = driver.findElement(addNewButtonElement);
		return addNewButtonIsPresentWebElement; 
	}
	
	
	public WebElement headerNotificationBarIsPresent(WebDriver driver) {
		WebElement headerNotificationBarWebElement = driver.findElement(headerNotificationBar);
		return headerNotificationBarWebElement; 
	}

	public WebElement admittingDocFieldIsPresent(WebDriver driver) {
		WebElement admittingDocFieldWebElement = driver.findElement(admittingDocField);
		return admittingDocFieldWebElement; 
	}
	public WebElement newItemButtonPresent(WebDriver driver) {
		WebElement newItemButtonWebElement = driver.findElement(newItemButton);
		return newItemButtonWebElement; 
	}
	
	public WebElement myFavoritesButtonIsPresent(WebDriver driver) {
		WebElement myFavoritesButtonWebElement = driver.findElement(myFavoritesButton);
		return myFavoritesButtonWebElement; 
	}
	
	public WebElement manageRoleTabIsPresent(WebDriver driver) {
		WebElement manageRoleTabWebElement = driver.findElement(manageRoleTab);
		return manageRoleTabWebElement; 
	}
	
	public WebElement tooltipIsPresent(WebDriver driver) {
		WebElement tooltipWebElement = driver.findElement(tooltip);
		return tooltipWebElement; 
	}
}
