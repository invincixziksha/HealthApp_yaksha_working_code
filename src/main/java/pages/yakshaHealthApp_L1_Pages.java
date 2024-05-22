package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class yakshaHealthApp_L1_Pages extends StartupPage {

	By personalFinancepage=By.xpath("(//a[@title='Personal Finance'])[2]");
	
	
	String pageName = this.getClass().getSimpleName();
	public yakshaHealthApp_L1_Pages(WebDriver driver) 
	{
		super(driver);
	}
	
	/**@Test1
	 * about this method demo() 
	 * @param : null
	 * @description : go to the personal finance page and click on the emergency Fund Calculator
	 * @return : String
	 * @author : Yaksha
	 */
	public String demo() throws Exception {
		String emergencyFundCalculatorPageTitle="";
		try {
			
		}catch(Exception e) {
			throw e;
		}	
		return emergencyFundCalculatorPageTitle;
	}
}
