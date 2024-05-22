package testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.StartupPage;

public class LocatorsFactory extends StartupPage {
	//please write all the locators for Money Control page only 
	
	By fixedDepositCalculatorHeader = By.xpath("//h2[contains(text(), 'Fixed Deposit Calculator')]");
	By investmentAmountTextfield = By.xpath("//input[@class='valueinput']");
	By investmentPeriodTextfield = By.xpath("//input[@id='edulonvalue_2']");
	By rateOfReturnTextfield = By.xpath("//input[@id='edulonvalue_3']");
	By interestFrequencyYearlyButton = By.xpath("(//span[contains(text(), 'Yearly')])[2]");
	By taxRateTextfield = By.xpath("//input[@id='edulonvalue_4']");
	By submitButton = By.xpath("//a[contains(text(), 'Submit')]");
	By resetButton = By.xpath("//a[@id='reset_btn']");
	By totalInterestResultButton = By.xpath("//div[contains(text(), 'Total Interest')]");
	By totalPaymentResultButton = By.xpath("//div[contains(text(), 'Total Payment')]");
	By totalCorpusResultButton = By.xpath("//div[contains(text(), 'Total Corpus')]");
	By totalTaxAmountResultButton = By.xpath("//div[contains(text(), 'Post Tax Amount')]");
	By providentFundCalculatorHeader = By.xpath("//strong[contains(text(), 'PF - Provident Fund Calculator')]"); 

	By personalFinanceNavigationMenu = By.xpath("//nav[@class='navbg']//li[@cid='8']//a[contains(text(), 'Personal Finance')]");
	By providentFundCalculatorLink = By.xpath("//a[contains(text(), 'Provident Fund Calculator')]");
	By basicMonthlySalaryTextfield = By.xpath("//input[@name='basic_salary_monthly']");
	By contributionToEPFTextfield = By.xpath("//input[@name='your_contribution']");
	By employersContributionToEPFTextfield = By.xpath("//input[@name='employers_contribuion']");
	By avgIncreaseInSalaryYouExpectTextfield = By.xpath("//input[@name='annual_increase_in_salary']");
	By ageWhenYouIntendToRetireTextfield = By.xpath("//input[@name='intend_to_retire']");
	By currentEpfBalanceIfAnyTextfield = By.xpath("//input[@name='current_epf_balance']");
	By currentInterestRateTextfield = By.xpath("//input[@name='current_interest_rate']");
	By calculateButton = By.xpath("//img[contains(@src, 'calculate')]");
	By totalAmountByTheTimeYouRetireElement = By.xpath("//div[@id='result_epf']//span[@style='color:#ff6600;']");
	By youWillHaveAccumulatedText = By.xpath("//span[contains(text(), 'You will have accumulated')]");
	
	By commodities = By.xpath("(//a[@title='Commodities'])[1]"); 
	By medicalDentalCostsTextField=By.xpath("//input[@name='medical_dental_costs']");
	By vehicleRepaircostTextField=By.xpath("//input[@name='vehicle_repairs']");
	By lifeInsurancePremiumTextField=By.xpath("//input[@name='life_insurance_premium']");
	By homeLoanAndOtherImportantEMIsTextField=By.xpath("//input[@name='home_auto_insurance_premium']");
	By monthlyLivingExpensesTextField=By.xpath("//input[@name='monthly_living_expenses']");
	By monthUnemployedTextField=By.xpath("//input[@name='month_unemployed']");
	By toolsTitle=By.xpath("//h2[.='Tools']");
	By loanAmountTextField=By.xpath("//input[@id='carhome_loan']");
	By loanPeriodTextField=By.xpath("//input[@id='loan_period']");
    By interestRateTextField=By.id("interest_rate"); 
    By emiReadOnlyField=By.id("emi");
    By OutstandingPrincipalAtEndOfYear=By.xpath("//div[@class='table_container table-responsive']//tr[5]//td[2]");
    By emiPaymentInTheYear=By.xpath("//div[@class='table_container table-responsive']//tr[7]//td[3]");
    By loginButton=By.xpath("//a[@title='Log In']");
    By loginWithOtpButton=By.xpath("(//li[.='Login with OTP'])[2]");
    By emailIdField=By.xpath("(//input[@name='email'])[2]");
    By logInButton=By.xpath("(//button[@type=\"submit\"])[2]");
    By errorMessage=By.xpath("//div[.='Invalid User Id/EmailID or Password. Please try again.']");
    By forgotPassword=By.xpath("//a[.='Forgot Password']");
    By logInButtonAtRightTopCorner=By.xpath("//span[.='Hi  Abhisek  ...']");
    
    By uninsuredOrUnexpectedEmergenciesField=By.xpath("//div[@id='uninsured']");
	By annualAmountOfFixedPaymentsField=By.xpath("//div[@id='insurance']");
	By buildReserveToPayForJobLossField=By.id("unemploy");
	By resultField=By.xpath("//span[.='Rs 13,50,000']");
	By otherCostTextField=By.xpath("//input[@name='others']");
	By homeAndAutoInsurancePremiumTextField=By.xpath("//input[@name='medical_insurance_premium']");
    By passwordField=By.xpath("(//input[@name='pwd'])[2]");
    By upfrontChargesTextField=By.id("upfront_charges");
    By emiPaymentInTheYearField=By.xpath("//th[.='EMI Payment in the year']");
    By interestPaymentInTheYearField=By.xpath("//th[.='Interest Payment in the year']");

	public LocatorsFactory(WebDriver driver) {
		super(driver);

	}





	//Expected data will be fetch from config.json file,path of the json file is:FaceBook_Automation_Dummy/src/main/resources/config.json
	
	public WebElement fixedDepositCalculatorHeader(WebDriver driver) {
		WebElement fixedDepositCalculatorHeaderWebElement = driver.findElement(fixedDepositCalculatorHeader);
		return fixedDepositCalculatorHeaderWebElement; 
	}
	
	public WebElement investmentAmountTextfield(WebDriver driver) {
		WebElement investmentAmountTextfieldWebElement = driver.findElement(investmentAmountTextfield);
		return investmentAmountTextfieldWebElement; 
	}
	
	public WebElement investmentPeriodTextfield(WebDriver driver) {
		WebElement investmentPeriodTextfieldWebElement = driver.findElement(investmentPeriodTextfield);
		return investmentPeriodTextfieldWebElement; 
	}
	
	public WebElement rateOfReturnTextfield(WebDriver driver) {
		WebElement rateOfReturnTextfieldWebElement = driver.findElement(rateOfReturnTextfield);
		return rateOfReturnTextfieldWebElement; 
	}
	
	public WebElement interestFrequencyYearlyButton(WebDriver driver) {
		WebElement interestFrequencyYearlyButtonWebElement = driver.findElement(interestFrequencyYearlyButton);
		return interestFrequencyYearlyButtonWebElement; 
	}
	
	public WebElement taxRateTextfield(WebDriver driver) {
		WebElement taxRateTextfieldWebElement = driver.findElement(taxRateTextfield);
		return taxRateTextfieldWebElement; 
	}
	
	public WebElement submitButton(WebDriver driver) {
		WebElement submitButtonWebElement = driver.findElement(submitButton);
		return submitButtonWebElement; 
	}
	
	public WebElement resetButton(WebDriver driver) {
		WebElement resetButtonWebElement = driver.findElement(resetButton);
		return resetButtonWebElement; 
	}
	
	public WebElement totalInterestResultButton(WebDriver driver) {
		WebElement totalInterestResultButtonWebElement = driver.findElement(totalInterestResultButton);
		return totalInterestResultButtonWebElement; 
	}
	
	public WebElement totalPaymentResultButton(WebDriver driver) {
		WebElement totalPaymentResultButtonWebElement = driver.findElement(totalPaymentResultButton);
		return totalPaymentResultButtonWebElement; 
	}
	
	public WebElement totalCorpusResultButton(WebDriver driver) {
		WebElement totalCorpusResultButtonWebElement = driver.findElement(totalCorpusResultButton);
		return totalCorpusResultButtonWebElement;
	}
	
	public WebElement totalTaxAmountResultButton(WebDriver driver) {
		WebElement totalTaxAmountResultButtonWebElement = driver.findElement(totalTaxAmountResultButton);
		return totalTaxAmountResultButtonWebElement;
	}
	
	public WebElement providentFundCalculatorHeader(WebDriver driver) {
		WebElement providentFundCalculatorHeaderWebElement = driver.findElement(providentFundCalculatorHeader);
		return providentFundCalculatorHeaderWebElement; 
	}
	
	public WebElement commoditiesIsPresent(WebDriver driver) {
		WebElement commoditiesWebElement = driver.findElement(commodities);
		return commoditiesWebElement; 
	}
	
	
	public WebElement monthUnemployedTextFieldIsPresent(WebDriver driver) {
		WebElement monthUnemployedTextFielddWebElement = driver.findElement(monthUnemployedTextField);
		return monthUnemployedTextFielddWebElement; 
	}
	public WebElement toolsTitleIsPresent(WebDriver driver) {
		WebElement toolsTitleWebElement = driver.findElement(toolsTitle);
		return toolsTitleWebElement; 
	}
	public WebElement loanAmountTextFieldIsPresent(WebDriver driver) {
		WebElement loanAmountTextFieldWebelement = driver.findElement(loanAmountTextField);
		return loanAmountTextFieldWebelement; 
	}
	
	public WebElement resetButtonIsPresent(WebDriver driver) {
		WebElement resetButtonWebElement = driver.findElement(resetButton);
		return resetButtonWebElement; 
	}
	
	public WebElement emiReadOnlyFieldIsPresent(WebDriver driver) {
		WebElement emiReadOnlyFieldWebElement = driver.findElement(emiReadOnlyField);
		return emiReadOnlyFieldWebElement; 
	}
	public WebElement emiPaymentInTheYearFieldIsPresent(WebDriver driver) {
		WebElement emiPaymentInTheYearFieldWebElement = driver.findElement(emiPaymentInTheYearField);
		return emiPaymentInTheYearFieldWebElement; 
	}
	public WebElement interestPaymentInTheYearFieldIsPresent(WebDriver driver) {
		WebElement interestPaymentInTheYearFieldWebElement = driver.findElement(interestPaymentInTheYearField);
		return interestPaymentInTheYearFieldWebElement; 
	}
	public WebElement loginButtonIsPresent(WebDriver driver) {
		WebElement loginButtonWebElement = driver.findElement(loginButton);
		return loginButtonWebElement; 
	}
	public WebElement loginWithOtpButtonIsPresent(WebDriver driver) {
		WebElement loginWithOtpButtonWebElement = driver.findElement(loginWithOtpButton);
		return loginWithOtpButtonWebElement; 
	}
	public WebElement emailIdFieldIsPresent(WebDriver driver) {
		WebElement emailIdFieldWebElement = driver.findElement(emailIdField);
		return emailIdFieldWebElement; 
	}
	public WebElement logInButtonIsPresent(WebDriver driver) {
		WebElement logInButtonWebElement = driver.findElement(logInButton);
		return logInButtonWebElement; 
	}
	
	public WebElement errorMessageIsPresent(WebDriver driver) {
		WebElement errorMessageWebElement = driver.findElement(errorMessage);
		return errorMessageWebElement; 
	}
	
	public WebElement forgotPasswordIsPresent(WebDriver driver) {
		WebElement forgotPasswordWebElement = driver.findElement(forgotPassword);
		return forgotPasswordWebElement; 
	}
	
	public WebElement userNameAtRightTopCornerIsPresent(WebDriver driver) {
		WebElement logInButtonAtRightTopCornerWebElement = driver.findElement(logInButtonAtRightTopCorner);
		return logInButtonAtRightTopCornerWebElement; 
	}
	
	public WebElement uninsuredOrUnexpectedEmergenciesFieldIsPresent(WebDriver driver) {
		WebElement uninsuredOrUnexpectedEmergenciesFieldWebElement = driver.findElement(uninsuredOrUnexpectedEmergenciesField);
		return uninsuredOrUnexpectedEmergenciesFieldWebElement; 
	}
	
	public WebElement annualAmountOfFixedPaymentsFieldIsPresent(WebDriver driver) {
		WebElement annualAmountOfFixedPaymentsFieldWebElement = driver.findElement(annualAmountOfFixedPaymentsField);
		return annualAmountOfFixedPaymentsFieldWebElement; 
	}
	
	public WebElement buildReserveToPayForJobLossFieldIsPresent(WebDriver driver) {
		WebElement buildReserveToPayForJobLossFieldWebElement = driver.findElement(buildReserveToPayForJobLossField);
		return buildReserveToPayForJobLossFieldWebElement; 
	}
	
	public WebElement resultFieldIsPresent(WebDriver driver) {
		WebElement resultFieldWebElement = driver.findElement(resultField);
		return resultFieldWebElement; 
	}
	
	public String verifyEnteredInvestmentAmountIsPresent() throws Exception {
		String investmentAmountTextfieldValue = "";
		try {
			if(commonEvents.isDisplayed(investmentAmountTextfield))
			{
			investmentAmountTextfieldValue = commonEvents.getAttribute(investmentAmountTextfield, "value");
			System.out.println("investment value in locators factory : " + investmentAmountTextfieldValue);
			Thread.sleep(2000);	
			}
		}catch(Exception e) {
			throw e;
		}
		return investmentAmountTextfieldValue;
	}
	
	public String verifyEnteredInvestmentPeriodIsPresent() throws Exception {
		String investmentPeriodTextfieldValue = "";
		try {
			if(commonEvents.isDisplayed(investmentPeriodTextfield))
			{
			investmentPeriodTextfieldValue = commonEvents.getAttribute(investmentPeriodTextfield, "value");
			System.out.println("investment period value : " + investmentPeriodTextfieldValue);
			Thread.sleep(2000);
			}
		}catch(Exception e) {
			throw e;
		}
		return investmentPeriodTextfieldValue;
	}
	
	public String verifyEnteredRateOfReturnIsPresent() throws Exception {
		String rateOfReturnTextfieldValue = "";
		try {
			if(commonEvents.isDisplayed(rateOfReturnTextfield))
			{
			rateOfReturnTextfieldValue = commonEvents.getAttribute(rateOfReturnTextfield, "value");
			System.out.println("rate of return value : " + rateOfReturnTextfieldValue);
			Thread.sleep(2000);
			}
		}catch(Exception e) {
			throw e;
		}
		return rateOfReturnTextfieldValue;
	}
	
	public String verifyTaxRateEnteredValueIsPresent() throws Exception {
		String taxRateTextfieldValue = "";
		try {
			if(commonEvents.isDisplayed(taxRateTextfield))
			{
			taxRateTextfieldValue = commonEvents.getAttribute(taxRateTextfield, "value");
			System.out.println("tax rate value : " + taxRateTextfieldValue);
			Thread.sleep(2000);
			}
		}catch(Exception e) {
			throw e;
		}
		return taxRateTextfieldValue;
	}
	
	public String verifyEnteredBasicMonthlySalaryIsPresent() throws Exception {
		String basicMonthlySalaryTextfieldValue = "";
		try {
			if(commonEvents.isDisplayed(basicMonthlySalaryTextfield))
			{
			basicMonthlySalaryTextfieldValue = commonEvents.getAttribute(basicMonthlySalaryTextfield, "value");
			System.out.println("basic monthly salary : " + basicMonthlySalaryTextfieldValue);
			Thread.sleep(2000);
			}
		}catch(Exception e) {
			throw e;
		}
		return basicMonthlySalaryTextfieldValue;
	}
	
	public String verifyEnteredValueInYourContributionToEPFIsPresent() throws Exception {
		String contributionToEPFValue = "";
		try {
			if(commonEvents.isDisplayed(contributionToEPFTextfield))
			{
			contributionToEPFValue = commonEvents.getAttribute(contributionToEPFTextfield, "value");
			System.out.println("contribution to EPF : " + contributionToEPFValue);
			Thread.sleep(2000);
			}
		}catch(Exception e) {
			throw e;
		}
		return contributionToEPFValue;
	}
	
	public String verifyEnteredYourEmployersContributionToEPFIsPresent() throws Exception {
		String employersContributionToEPFValue = "";
		try {
			if(commonEvents.isDisplayed(employersContributionToEPFTextfield))
			{
			employersContributionToEPFValue = commonEvents.getAttribute(employersContributionToEPFTextfield, "value");
			System.out.println(" Employers contribution to EPF : " + employersContributionToEPFValue);
			Thread.sleep(2000);
			}
		}catch(Exception e) {
			throw e;
		}
		return employersContributionToEPFValue;
	}
	
	public String verifyEnteredAvgIncreaseInSalaryYouExpectIsPresent() throws Exception {
		String avgIncreaseInSalaryYouExpectValue = "";
		try {
			if(commonEvents.isDisplayed(avgIncreaseInSalaryYouExpectTextfield))
			{
			avgIncreaseInSalaryYouExpectValue = commonEvents.getAttribute(avgIncreaseInSalaryYouExpectTextfield, "value");
			System.out.println("Average Increase in salary you expect : " + avgIncreaseInSalaryYouExpectValue);
			Thread.sleep(2000);
			}
		}catch(Exception e) {
			throw e;
		}
		return avgIncreaseInSalaryYouExpectValue;
	}
	
	public String verifyEnterAgeWhenYouIntendToRetireIsPresent() throws Exception {
		String ageWhenYouIntendToRetireValue = "";
		try {
			if(commonEvents.isDisplayed(ageWhenYouIntendToRetireTextfield))
			{
			ageWhenYouIntendToRetireValue = commonEvents.getAttribute(ageWhenYouIntendToRetireTextfield, "value");
			System.out.println("age When You Intend To Retire Value : " + ageWhenYouIntendToRetireValue);
			Thread.sleep(2000);
			}
		}catch(Exception e) {
			throw e;
		}
		return ageWhenYouIntendToRetireValue;
	}
	
	public String verifyEnteredCurrentEpfBalanceIfAnyIsPresent() throws Exception {
		String currentEpfBalanceIfAnyValue = "";
		try {
			if(commonEvents.isDisplayed(currentEpfBalanceIfAnyTextfield))
			{
			currentEpfBalanceIfAnyValue = commonEvents.getAttribute(currentEpfBalanceIfAnyTextfield, "value");
			System.out.println("current Epf Balance If Any Value : " + currentEpfBalanceIfAnyValue);
			Thread.sleep(2000);
			}
		}catch(Exception e) {
			throw e;
		}
		return currentEpfBalanceIfAnyValue;
	}
	
	public String verifyEnteredCurrentInterestRateIsPresent() throws Exception {
		String currentInterestRateValue = "";
		try {
			if(commonEvents.isDisplayed(currentInterestRateTextfield))
			{
			currentInterestRateValue = commonEvents.getAttribute(currentInterestRateTextfield, "value");
			System.out.println("current Interest Rate Value : " + currentInterestRateValue);
			Thread.sleep(2000);
			}
		}catch(Exception e) {
			throw e;
		}
		return currentInterestRateValue;
	}
	
	public WebElement totalAmountByTheTimeYouRetireElementIsPresent(WebDriver driver) {
		WebElement totalAmountByTheTimeYouRetireWebelement = driver.findElement(totalAmountByTheTimeYouRetireElement);
		return totalAmountByTheTimeYouRetireWebelement; 
	}
	
	public WebElement youWillHaveAccumulatedTextIsPresent(WebDriver driver) {
		WebElement youWillHaveAccumulatedTextWebelement = driver.findElement(youWillHaveAccumulatedText);
		return youWillHaveAccumulatedTextWebelement;
	}

	public String medicalDentalCostsValueIsPresent()throws Exception {
		String medicalDentalCostsTextFieldValue="";
		try
		{
		medicalDentalCostsTextFieldValue=commonEvents.getAttribute(medicalDentalCostsTextField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return medicalDentalCostsTextFieldValue;
	}
	
	public String vehicleRepaircostValueIsPresent()throws Exception {
		String vehicleRepaircostValueIsPresentTextFieldValue="";
		try
		{
			vehicleRepaircostValueIsPresentTextFieldValue=commonEvents.getAttribute(vehicleRepaircostTextField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return vehicleRepaircostValueIsPresentTextFieldValue;
	}
	
	public String otherCostTextFieldValueIsPresent()throws Exception {
		String otherCostTextFieldValue="";
		try
		{
			otherCostTextFieldValue=commonEvents.getAttribute(otherCostTextField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return otherCostTextFieldValue;
	}
	
	public String lifeInsurancePremiumTextFieldValueIsPresent()throws Exception {
		String lifeInsurancePremiumTextFieldValue="";
		try
		{
			lifeInsurancePremiumTextFieldValue=commonEvents.getAttribute(lifeInsurancePremiumTextField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return lifeInsurancePremiumTextFieldValue;
	}
	
	public String homeAndAutoInsurancePremiumextFieldValueIsPresent()throws Exception {
		String homeAndAutoInsurancePremiumextFieldValue="";
		try
		{
			homeAndAutoInsurancePremiumextFieldValue=commonEvents.getAttribute(homeAndAutoInsurancePremiumTextField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return homeAndAutoInsurancePremiumextFieldValue;
	}
	
	public String homeLoanAndOtherImportantEMIsTextFieldValueIsPresent()throws Exception {
		String homeLoanAndOtherImportantEMIsTextFieldValue="";
		try
		{
			homeLoanAndOtherImportantEMIsTextFieldValue=commonEvents.getAttribute(homeLoanAndOtherImportantEMIsTextField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return homeLoanAndOtherImportantEMIsTextFieldValue;
	}
	
	public String monthlyLivingExpensesTextFieldValueIsPresent()throws Exception {
		String monthlyLivingExpensesTextFieldValue="";
		try
		{
			monthlyLivingExpensesTextFieldValue=commonEvents.getAttribute(monthlyLivingExpensesTextField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return monthlyLivingExpensesTextFieldValue;
	}
	
	public String monthUnemployedTextFieldValueIsPresent()throws Exception {
		String monthUnemployedTextFieldValue="";
		try
		{
			monthUnemployedTextFieldValue=commonEvents.getAttribute(monthUnemployedTextField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return monthUnemployedTextFieldValue;
	}
	
	public String uninsuredOrUnexpectedEmergenciesFieldValueIsPresent()throws Exception {
		String uninsuredOrUnexpectedEmergenciesFieldValue="";
		try
		{
			uninsuredOrUnexpectedEmergenciesFieldValue=commonEvents.getText(uninsuredOrUnexpectedEmergenciesField);
		}
		catch(Exception e) {
			throw e;
		}	
		return uninsuredOrUnexpectedEmergenciesFieldValue;
	}
	
	public String annualAmountOfFixedPaymentsFieldValueIsPresent()throws Exception {
		String annualAmountOfFixedPaymentsFieldValue="";
		try
		{
			annualAmountOfFixedPaymentsFieldValue=commonEvents.getText(annualAmountOfFixedPaymentsField);
		}
		catch(Exception e) {
			throw e;
		}	
		return annualAmountOfFixedPaymentsFieldValue;
	}
	
	public String buildReserveToPayForJobLossFieldValueIsPresent()throws Exception {
		String buildReserveToPayForJobLossFieldValue="";
		try
		{
			buildReserveToPayForJobLossFieldValue=commonEvents.getText(buildReserveToPayForJobLossField);
		}
		catch(Exception e) {
			throw e;
		}	
		return buildReserveToPayForJobLossFieldValue;
	}
	
	public String resultValueIsPresent()throws Exception {
		String resultValue="";
		try
		{
			resultValue=commonEvents.getText(resultField);
		}
		catch(Exception e) {
			throw e;
		}	
		return resultValue;
	}
	
	public String forgotPasswordValueIsPresent()throws Exception {
		String  forgotPasswordValue="";
		try
		{
			 forgotPasswordValue=commonEvents.getAttribute(passwordField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return forgotPasswordValue;
	}
	
	public String loanAmountTextFieldValueIsPresent()throws Exception {
		String  loanAmountTextFieldValue="";
		try
		{
			loanAmountTextFieldValue=commonEvents.getAttribute(loanAmountTextField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return loanAmountTextFieldValue;
	}
	
	public String loanPeriodTextFieldValueIsPresent()throws Exception {
		String  loanPeriodTextFieldValue="";
		try
		{
			loanPeriodTextFieldValue=commonEvents.getAttribute(loanPeriodTextField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return loanPeriodTextFieldValue;
	}
	
	public String interestRateTextFieldValueIsPresent()throws Exception {
		String  interestRateTextFieldValue="";
		try
		{
			interestRateTextFieldValue=commonEvents.getAttribute(interestRateTextField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return interestRateTextFieldValue;
	}
	
	public String upfrontChargesTextFieldValueIsPresent()throws Exception {
		String  upfrontChargesTextFieldValue="";
		try
		{
			upfrontChargesTextFieldValue=commonEvents.getAttribute(upfrontChargesTextField, "value");
		}
		catch(Exception e) {
			throw e;
		}	
		return upfrontChargesTextFieldValue;
	}
}
