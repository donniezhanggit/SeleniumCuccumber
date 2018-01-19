package safetrip.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class PurchaserInfoPage extends BasePage {
	
private WebDriver purchaserInfoPageDriver;
	
	public PurchaserInfoPage(WebDriver driver)
	{
		this.purchaserInfoPageDriver = driver;
		PageFactory.initElements(driver, this);
		pageName = "<b style='color:#00008B;'>"+this.getClass().getSimpleName()+"</b>";
			bp = this;
	}
	
	@FindBy(xpath = "(//div[starts-with(@class,'col-md-4 f')]//input)[1]")
	public WebElement purchaserAsNONE_radioBtn;
	
	@FindBy(xpath = "(//div[starts-with(@class,'col-md-4 f')]//input)[2]")
	public WebElement purchaserAsFirstTraveler_radioBtn;
	
	@FindBy(xpath = "//label[text() = 'Salutation']/following-sibling::select[contains(@data-ng-model,'purchaser')]")
	public WebElement purchaserSalutation_dropdown;
	
	@FindBy(name = "p_firstname")
	public WebElement purchaserFirstName_txtbox;

	@FindBy(name = "p_middleInitial")
	public WebElement purchaserMiddletName_txtbox;
	
	@FindBy(name = "p_lastname")
	public WebElement purchaserlastName_txtbox;
	
	@FindBy(name = "p_suffix[]")
	public WebElement purchaserSuffix_dropDown;
	
	@FindBy(name = "p_primaryPhone")
	public WebElement purchaserPrimaryPhone_txtbox;
	
	@FindBy(name = "p_secondaryPhone")
	public WebElement purchaserAlternatePhone_txtbox;
	
	@FindBy(name = "p_emailAddress")
	public WebElement purchaserEmailAddress_txtbox;
	
	@FindBy(name = "country_mailling")
	public WebElement purMailingAddCountry_txtbox;
	
	@FindBy(name = "address1_mailling")
	public WebElement purMailingAddressOne_txtbox;
	
	@FindBy(name = "address2_mailling")
	public WebElement purMailingAddressTwo_txtbox;
	
	@FindBy(name = "state_mailling")
	public WebElement purMailingAddState_txtbox;
	
	@FindBy(name = "city_mailling")
	public WebElement purMailingAddCity_txtbox;
	
	@FindBy(name = "zipPostalCode_mailling")
	public WebElement purMailingAddZipCode_txtbox;
	
	@FindBy(name = "country_billing")
	public WebElement purBillingAddCountry_txtbox;
	
	@FindBy(name = "address1_billing")
	public WebElement purBillingAddressOne_txtbox;
	
	@FindBy(name = "address2_billing")
	public WebElement purBillingAddressTwo_txtbox;
	
	@FindBy(name = "state_billing")
	public WebElement purBillingAddState_txtbox;

	@FindBy(name = "city_billing")
	public WebElement purBillingAddCity_txtbox;
	
	@FindBy(name = "zipPostalCode_billing")
	public WebElement purBillingAddZipCode_txtbox;
	
	@FindBy(xpath = "//label[text() = 'Reasons For Travel']/following-sibling::select")
	public WebElement ReasonForTravel_dropDown;
	
	@FindBy(xpath = "//label[text() = 'What brought you here']/following-sibling::select")
	public WebElement whatBroughtUhere_dropDown;
	
	@FindBys(@FindBy(xpath = "//input[@name = 'country_mailling']/following-sibling::div//li/a"))
	List<WebElement> populatedMailingCountry_List;
	
	@FindBys(@FindBy(xpath = "//input[@name = 'state_mailling']/following-sibling::div//li/a"))
	List<WebElement> populatedMailingState_List;
	
	@FindBys(@FindBy(xpath = "//input[@name = 'city_mailling']/following-sibling::div//li/a"))
	List<WebElement> populatedMailingCity_List;
	
	@FindBys(@FindBy(xpath = "//input[@name = 'country_billing']/following-sibling::div//li/a"))
	List<WebElement> populatedBillingCountry_List;
	
	@FindBys(@FindBy(xpath = "//input[@name = 'state_billing']/following-sibling::div//li/a"))
	List<WebElement> populatedBillingState_List;
	
	@FindBys(@FindBy(xpath = "//input[@name = 'city_billing']/following-sibling::div//li/a"))
	List<WebElement> populatedBillingCity_List;
		
	
	@FindBy(xpath = "//input[contains(@data-ng-change,'.copyMailingAddress()')]")
	public WebElement sameAsMailingAddress_chkBox;
	
	@FindBy(xpath = "//a[text()='Next']")
	public WebElement next_btn;
	public ReviewCartPage enterPurchaserDetailsIfPurchaserIsNotTraveler(String salutation, String purFirstName, String purMiddleName, String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode)
	{
		if(!salutation.equals(""))
		seleniumHelper.selectFromDropdownByVisibleText(purchaserSalutation_dropdown, salutation);
		seleniumHelper.enterValueIntoTextField(purchaserFirstName_txtbox, purFirstName);
		if(!purMiddleName.equals(""))
		seleniumHelper.enterValueIntoTextField(purchaserMiddletName_txtbox, purMiddleName);
		seleniumHelper.enterValueIntoTextField(purchaserlastName_txtbox, purLastName);
		seleniumHelper.selectFromDropdownByVisibleText(purchaserSuffix_dropDown, suffix);
		
		
		seleniumHelper.enterValueIntoTextField(purchaserPrimaryPhone_txtbox, primaryPhone);
		seleniumHelper.enterValueIntoTextField(purchaserAlternatePhone_txtbox, alternatePhone);
		
		System.out.println(purchaserEmailAddress_txtbox.toString());
		seleniumHelper.enterValueIntoTextField(purchaserEmailAddress_txtbox, purEmail);
		
		seleniumHelper.selectFromAutoCompleteBox(purMailingAddCountry_txtbox, populatedMailingCountry_List, mailingCOuntry);
		
		seleniumHelper.enterValueIntoTextField(purMailingAddressOne_txtbox, mailingAddressone);
		seleniumHelper.enterValueIntoTextField(purMailingAddressTwo_txtbox, mailingAddressTwo);
		
		seleniumHelper.selectFromAutoCompleteBox(purMailingAddState_txtbox, populatedMailingState_List, mailingState);
		seleniumHelper.selectFromAutoCompleteBox(purMailingAddCity_txtbox, populatedMailingCity_List, mailingCity);
		
		seleniumHelper.enterValueIntoTextField(purMailingAddZipCode_txtbox, mailingZipcode);
		
		seleniumHelper.clickElement(sameAsMailingAddress_chkBox);
		seleniumHelper.clickElement(next_btn);
		
		//seleniumHelper.setRunTimeImplicitWait(purchaserInfoPageDriver);
		
		return new ReviewCartPage(purchaserInfoPageDriver);
		
	}
	
	public ReviewCartPage enterPurchaserDetailsWhereMailingNotSameAsBillingAddress(String salutation, String purFirstName, String purMiddleName, String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode,String billingCOuntry, String billingAddressone, String billingAddressTwo, String billingState, String billingCity, String billingZipcode)
	{
		try {
			
			//seleniumHelper.clickElement(purchaserAsFirstTraveler_radioBtn);
			
			
			if(!salutation.equals(""))
				seleniumHelper.selectFromDropdownByVisibleText(purchaserSalutation_dropdown, salutation);
				seleniumHelper.enterValueIntoTextField(purchaserFirstName_txtbox, purFirstName);
				if(!purMiddleName.equals(""))
				seleniumHelper.enterValueIntoTextField(purchaserMiddletName_txtbox, purMiddleName);
				seleniumHelper.enterValueIntoTextField(purchaserlastName_txtbox, purLastName);
				seleniumHelper.selectFromDropdownByVisibleText(purchaserSuffix_dropDown, suffix);			
				
				seleniumHelper.enterValueIntoTextField(purchaserPrimaryPhone_txtbox, primaryPhone);
				seleniumHelper.enterValueIntoTextField(purchaserAlternatePhone_txtbox, alternatePhone);
				seleniumHelper.enterValueIntoTextField(purchaserEmailAddress_txtbox, purEmail);
				
				seleniumHelper.selectFromAutoCompleteBox(purMailingAddCountry_txtbox, populatedMailingCountry_List, mailingCOuntry);
				
				seleniumHelper.enterValueIntoTextField(purMailingAddressOne_txtbox, mailingAddressone);
				seleniumHelper.enterValueIntoTextField(purMailingAddressTwo_txtbox, mailingAddressTwo);
				
				seleniumHelper.selectFromAutoCompleteBox(purMailingAddState_txtbox, populatedMailingState_List, mailingState);
				seleniumHelper.selectFromAutoCompleteBox(purMailingAddCity_txtbox, populatedMailingCity_List, mailingCity);
				
				seleniumHelper.enterValueIntoTextField(purMailingAddZipCode_txtbox, mailingZipcode);
			
				seleniumHelper.selectFromAutoCompleteBox(purBillingAddCountry_txtbox, populatedBillingCountry_List, billingCOuntry);
				
				seleniumHelper.enterValueIntoTextField(purBillingAddressOne_txtbox, billingAddressone);
				seleniumHelper.enterValueIntoTextField(purBillingAddressTwo_txtbox, billingAddressTwo);
				
				seleniumHelper.selectFromAutoCompleteBox(purBillingAddState_txtbox, populatedBillingState_List, billingState);
				seleniumHelper.selectFromAutoCompleteBox(purBillingAddCity_txtbox, populatedBillingCity_List, billingCity);
				
				seleniumHelper.enterValueIntoTextField(purBillingAddZipCode_txtbox, billingZipcode);
				seleniumHelper.clickElement(next_btn);
				
				return new ReviewCartPage(purchaserInfoPageDriver);
			
		}catch(Exception e)
		{
			 insertReportLine(e);
		}
		return null;
	}
	
}
