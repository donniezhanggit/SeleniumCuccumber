package safetrip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCardInfoPage extends BasePage{

private WebDriver creditCardInfoPageDriver;
	
	public CreditCardInfoPage(WebDriver driver)
	{		
		this.creditCardInfoPageDriver = driver;
		PageFactory.initElements(driver, this);
		pageName = "<b style='color:#00008B;'>"+this.getClass().getSimpleName()+"</b>";
		bp = this;	
		
	}
	
	@FindBy(id = "accountNumber")
	public WebElement creditCardNumber_txtBox;
	
	@FindBy(id = "month")
	public WebElement expDateMonth_Dropdown;
	
	@FindBy(id = "year")
	public WebElement expDateYear_Dropdown;
	
	@FindBy(id = "btnSubmit")
	public WebElement completePurchase_btn;
	
	@FindBy(xpath = "//h2[@id='p_title']")
	public WebElement tierNumAndCostOfTrip_wbel;
	
	@FindBy(xpath = "//p[@id='p_name']/strong")
	public WebElement purchaserNameAndEmailId_wbel;
	
	@FindBy(xpath = "//p[@id='p_name']")
	public WebElement purchaserDetails_wbel;
	
	@FindBy(xpath = "//p[@id='p_mailling']")
	public WebElement purchaserCompleteMailingAdd_wbel;
	
	@FindBy(xpath = "//p[@id='p_billing']")
	public WebElement purchaserCompleteBillingAdd_wbel;
	
	@FindBy(xpath = "//p[@id='p_policy']")
	public WebElement purchasePolicyType_wbel;
	
	@FindBy(xpath = "//p[@id='p_from']")
	public WebElement plicyFromDate_wbel;
	
	@FindBy(xpath = "//p[@id='p_to']")
	public WebElement plicyToDate_wbel;
	@FindBy(xpath = "//p[@id='p_noOfTravlers']")
	public WebElement noOfTravelers_wbel;
	
	@FindBy(xpath = "//p[@id='p_total']")
	public WebElement purchaseTotal_wbel;
	
	public void validatePurchaserInformation(String salutation, String purFirstName,String purMiddleName, String purLastName, String suffix, String primaryPhone, String alternatePhone,  String purEmail)
	{
		try {
			String purchaserNameWithEmailAdd = "";
			String purchaserPhoneDetails = "";
			if(!purMiddleName.equals("")) {
			purchaserNameWithEmailAdd =  salutation.trim()+" "+purFirstName.trim()+" "+purMiddleName.trim()+" "+purLastName.trim()+" - "+purEmail.trim();
			}else
			{
				purchaserNameWithEmailAdd =  salutation.trim()+" "+purFirstName.trim()+" "+purLastName.trim()+" - "+purEmail.trim();
			}
			seleniumHelper.validateElementText(purchaserNameAndEmailId_wbel, purchaserNameWithEmailAdd);
			
		//	System.out.println(purchaserDetails_wbel.getText());
			if(!alternatePhone.equals("")) {
			purchaserPhoneDetails = "Primary Phone. "+primaryPhone.trim()+" - Alternate Phone. "+alternatePhone.trim();
			}else
			{
			purchaserPhoneDetails = "Primary Phone. "+primaryPhone.trim();
			}
			seleniumHelper.validateElementTextContains(purchaserDetails_wbel, purchaserPhoneDetails);
			//System.out.println(purchaserDetails_wbel.getText());
			
		
	
		}catch(Exception e)
		{
			 insertReportLine(e);
		}
	}
	public void validatePurchaserAddressDetails(String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode,String billingCOuntry, String billingAddressone, String billingAddressTwo, String billingState, String billingCity, String billingZipcode)
	{
		String[] purchaserMailingAddArr = { mailingAddressone, mailingAddressTwo, mailingZipcode, mailingCity, mailingState, mailingCOuntry};
		String[] purchaserBillingAddArr = { billingAddressone, billingAddressTwo, billingZipcode, billingCity, billingState, billingCOuntry};
		String purchaserMailingAdd = "";
		String purchaserBillingAdd = "";
		
		try {
			
			for(int i = 0; i <= 5; i++)
			{
				if(!purchaserMailingAddArr[i].equals(""))
				{
					purchaserMailingAdd+=purchaserMailingAddArr[i]+" ";
				}
				if(!purchaserBillingAddArr[i].equals(""))
				{
					purchaserBillingAdd+=purchaserBillingAddArr[i]+" ";
				}
			}
			purchaserMailingAdd = purchaserMailingAdd.trim();
			purchaserBillingAdd = purchaserBillingAdd.trim();
			
			seleniumHelper.validateElementTextContains(purchaserCompleteMailingAdd_wbel, purchaserMailingAdd);
			seleniumHelper.validateElementTextContains(purchaserCompleteBillingAdd_wbel, purchaserBillingAdd);
		
		}catch(Exception e)
		{
			 insertReportLine(e);
		}
	}
	
	public void validatePolicyInfo(String tripCancellationAmount, String noOfTravelers,String startDate, String returnDate)
	{
		try {
			
			String capturedTotalCost = tierNumAndCostOfTrip_wbel.getText().substring(tierNumAndCostOfTrip_wbel.getText().indexOf("$"));
			if(getDateDifff(startDate, returnDate)<360)
			{
				seleniumHelper.validateElementTextContains(purchasePolicyType_wbel, "SafeTrip Travel Medical");
				if(!tripCancellationAmount.equals(""))
				{
					seleniumHelper.validateElementTextContains(purchasePolicyType_wbel, "Trip Cancellation");
				}
			}
			else
			{
				seleniumHelper.validateElementTextContains(purchasePolicyType_wbel, "Annual Frequent Traveler");
			}
			
			seleniumHelper.validateElementTextContains(plicyFromDate_wbel, startDate);
			seleniumHelper.validateElementTextContains(plicyToDate_wbel, returnDate);
			seleniumHelper.validateElementTextContains(noOfTravelers_wbel, noOfTravelers);
			seleniumHelper.validateElementTextContains(purchaseTotal_wbel, capturedTotalCost);
			
		}catch(Exception e)
		{
			 insertReportLine(e);
		}
	}
	

	
	public ConfirmPurchasePage completePurchase(String cardNumber, String cardExpMonth, String cardExpYear)
	{
		try {
			System.out.println("The Card Number for this transaction is "+cardNumber);
		Thread.sleep(2000);
		seleniumHelper.waitForObjectToload(creditCardInfoPageDriver, By.id("accountNumber"), 80);
		 
		JavascriptExecutor jse = (JavascriptExecutor)creditCardInfoPageDriver;
		jse.executeScript("arguments[0].value='"+cardNumber+"';", creditCardNumber_txtBox);
		
		//seleniumHelper.clearTextrField(creditCardNumber_txtBox);
		
	//	jse.executeScript("document.getElementById('accountNumber').value='"+cardNumber+"';");
		
		
		//seleniumHelper.enterValueIntoTextField(creditCardNumber_txtBox, cardNumber );
		//seleniumHelper.clearTextrField(creditCardNumber_txtBox);
		//seleniumHelper.enterValueIntoTextField(creditCardNumber_txtBox, cardNumber );
		seleniumHelper.selectFromDropdownByVisibleText(expDateMonth_Dropdown, cardExpMonth);
		seleniumHelper.selectFromDropdownByVisibleText(expDateYear_Dropdown, cardExpYear);
		
		Thread.sleep(2000);
		seleniumHelper.clickElement(completePurchase_btn);
		//seleniumHelper.setRunTimeImplicitWait(creditCardInfoPageDriver);
		
		return new ConfirmPurchasePage(creditCardInfoPageDriver);
		}catch(Exception e) {
			 insertReportLine(e);
		}
		return null;
	}
	
	
	
	
	
}
