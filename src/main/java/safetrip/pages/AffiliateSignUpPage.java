package safetrip.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AffiliateSignUpPage extends BasePage
{
	private WebDriver affiliateSignUpPageDriver;
	
	public AffiliateSignUpPage(WebDriver driver)
	{
		this.affiliateSignUpPageDriver = driver;
		PageFactory.initElements(driver, this);
			bp = this;
	}
	
	
	@FindBy(xpath = "//label[contains(text(),'Type of entity')]/../select")
	public WebElement typeofEntity_Select;
	
	@FindBy(xpath = "//label[contains(text(),'Full Legal Business Name')]/../input")
	public WebElement fullLegalBusinessName_txtbox;
	
	@FindBy(xpath = "//label[contains(text(),'First Name')]/../input")
	public WebElement firstName_txtbox;
	
	@FindBy(xpath = "//label[contains(text(),'Middle Name')]/../input")
	public WebElement middleName_txtbox;
	
	@FindBy(xpath = "//label[contains(text(),'Last Name')]/../input")
	public WebElement lastName_txtbox;
	
	@FindBy(xpath = "//label[contains(text(),'License number')]/../input")
	public WebElement licenseNumber_txtbox;
	
	@FindBy(xpath = "//label[contains(text(),'State licensed')]/../span/span/span")
	public WebElement stateLicensed_Select;
	
	@FindBy(xpath = "//label[contains(text(),'Website')]/../input")
	public WebElement website_txtbox;

	public WebElement getWebsite_txtbox() {
		return website_txtbox;
	}


	@FindBy(xpath = "//label[contains(text(),'Tax ID')]/../input")
	public WebElement taxID_txtbox;
	
	@FindBy(xpath = "//div[starts-with(@class,'contourField copyoflicense file')]//span[@class = 'bluebtn btn-sm']")
	public WebElement CopyOfLicense_ChooseButton;
	
	@FindBy(xpath = "//div[starts-with(@class,'contourField copyofw9 file')]//span[@class = 'bluebtn btn-sm']")
	public WebElement CopyOfW9_ChooseButton;
	
	@FindBy(xpath = "//label[contains(text(),'Contact person')]//..//input")
	public WebElement contactPerson_txtbox;
	
	@FindBy(xpath = "//label[contains(text(),'Email address')]//..//input")
	public WebElement emailaddress_txtbox;
	
	@FindBy(xpath = "//label[contains(text(),'Phone Number')]//..//input")
	public WebElement phoneNumber_txtbox;
	
	@FindBy(xpath = "//label[contains(text(),'Fax number')]//..//input")
	public WebElement faxnumber_txtbox;
	
	@FindBy(xpath = "//label[contains(text(),'Address 1')]//..//input")
	public WebElement Address1_txtbox;
	
	@FindBy(xpath = "//label[contains(text(),'Address 2')]//..//input")
	public WebElement Address2_txtbox;
	
	@FindBy(xpath = "//label[contains(text(),'City')]//..//input")
	public WebElement City_txtbox;
	
	@FindBy(xpath = "//div[starts-with(@class,'contourField country dro')]//span[@role = 'combobox']")
	public WebElement Country_Select;
	
	@FindBy(xpath = "//div[starts-with(@class,'contourField state dro')]//span[@role = 'combobox']")
	public WebElement State_Select;
	
	@FindBy(xpath = "//label[contains(text(),'Zip Code')]//..//input")
	public WebElement zipCode_txtbox;
	
	@FindBy(xpath = "//div[@class='contour affiliatesignupform']//input[@value='Submit']")
	public WebElement submit_button;
	
	public WebElement typeofEntity_Value;
	public WebElement stateLicense_Value;
	public WebElement Country_Value;
	public WebElement state_Value;
	
	public WebElement element;

	
	public void setAffiliateDetails(String entityValue,String Name,String firstName,String middleName,String lastName,String LicenseNumber,String stateLicensed, 
			String website,String taxID,String contactPerson,String emailAddress,String phoneNumber,String faxnumber,String Address1, String Address2,String city,String country,String state,String zipCode)
	{
		
		seleniumHelper.clickElement(Country_Select);
		Country_Value = seleniumHelper.findElementByXpath(affiliateSignUpPageDriver,"//li[@role = 'treeitem' and  contains(text(),'"+country+"')]" );
		seleniumHelper.clickElement(Country_Value);
		
		if(country.equalsIgnoreCase("United States") ||country.equalsIgnoreCase("Canada"))
		{
			seleniumHelper.clickElement(State_Select);
			state_Value = seleniumHelper.findElementByXpath(affiliateSignUpPageDriver,"//li[@role = 'treeitem' and text()='"+state+"']" );
			seleniumHelper.clickElement(state_Value);
		}
		
		//seleniumHelper.clickElement(typeofEntity_Select);
		
		seleniumHelper.selectFromDropdownByVisibleText(typeofEntity_Select, entityValue);
//		
//		typeofEntity_Value = seleniumHelper.findElementByXpath(affiliateSignUpPageDriver,"//label[contains(text(),'Type of entity')]/../select/option[contains(text(),'"+entityValue+"')]" );
//		seleniumHelper.clickElement(typeofEntity_Value);
	
		if(entityValue.equals("Individual Producer"))
		{
			seleniumHelper.enterValueIntoTextField(firstName_txtbox, firstName);
			seleniumHelper.enterValueIntoTextField(middleName_txtbox, middleName);
			seleniumHelper.enterValueIntoTextField(lastName_txtbox, lastName);
		}
		else
		{
			seleniumHelper.enterValueIntoTextField(fullLegalBusinessName_txtbox, Name);
		}
		
		seleniumHelper.enterValueIntoTextField(licenseNumber_txtbox, LicenseNumber);
		
		seleniumHelper.clickElement(stateLicensed_Select);
		stateLicense_Value = seleniumHelper.findElementByXpath(affiliateSignUpPageDriver,"//li[@role = 'treeitem' and text()='"+stateLicensed+"']" );
		seleniumHelper.clickElement(stateLicense_Value);
		
		seleniumHelper.enterValueIntoTextField(website_txtbox,website);
		
		seleniumHelper.enterValueIntoTextField(taxID_txtbox,taxID);

		File uploadFile = new File(".\\src\\test\\resources\\TestData\\AttachmentInputFile\\pdf.pdf");
		seleniumHelper.uploadFileUsingRobotClass(CopyOfLicense_ChooseButton, uploadFile.getAbsolutePath());
		//seleniumHelper.setRunTimeImplicitWait(affiliateSignUpPageDriver, 20);
		
		seleniumHelper.enterValueIntoTextField(contactPerson_txtbox,contactPerson);
		seleniumHelper.enterValueIntoTextField(emailaddress_txtbox,emailAddress);
		seleniumHelper.enterValueIntoTextField(phoneNumber_txtbox,phoneNumber);
		seleniumHelper.enterValueIntoTextField(faxnumber_txtbox,faxnumber);
		
		seleniumHelper.uploadFileUsingRobotClass(CopyOfW9_ChooseButton, uploadFile.getAbsolutePath());
		
		//seleniumHelper.setRunTimeImplicitWait(affiliateSignUpPageDriver, 20);
		
		
		seleniumHelper.enterValueIntoTextField(Address1_txtbox,Address1);
		seleniumHelper.enterValueIntoTextField(Address2_txtbox,Address2);
		seleniumHelper.enterValueIntoTextField(City_txtbox,city);
		
		seleniumHelper.enterValueIntoTextField(zipCode_txtbox, zipCode);
	
		seleniumHelper.clickElement(submit_button);
		
	}
	
	
	public void validateAffiliateDetails(String entityValue,String Name,String firstName,String middleName,String lastName,String LicenseNumber,String stateLicensed, 
			String website,String taxID,String contactPerson,String emailAddress,String phoneNumber,String faxnumber,String Address1, String Address2,String city,String country,String state,String zipCode)
	{
		File uploadFile = new File(".\\src\\test\\resources\\TestData\\AttachmentInputFile\\pdf.pdf");
		seleniumHelper.clickElement(Country_Select);
		Country_Value = seleniumHelper.findElementByXpath(affiliateSignUpPageDriver,"//li[@role = 'treeitem' and  contains(text(),'"+country+"')]" );
		seleniumHelper.clickElement(Country_Value);
		
		if(Country_Value.equals("United States") ||Country_Value.equals("Canada"))
		{
			seleniumHelper.clickElement(State_Select);
			state_Value = seleniumHelper.findElementByXpath(affiliateSignUpPageDriver,"//li[@role = 'treeitem' and text()='"+state+"']" );
			seleniumHelper.clickElement(state_Value);
		}
		
        seleniumHelper.clickElement(typeofEntity_Select);
		
		typeofEntity_Value = seleniumHelper.findElementByXpath(affiliateSignUpPageDriver,"//label[contains(text(),'Type of entity')]/../select/option[contains(text(),'"+entityValue+"')]" );
		seleniumHelper.clickElement(typeofEntity_Value);
	
		if(entityValue.equals("Individual Producer"))
		{
			seleniumHelper.enterValueIntoTextField(firstName_txtbox, firstName);
			seleniumHelper.enterValueIntoTextField(middleName_txtbox, middleName);
			seleniumHelper.enterValueIntoTextField(lastName_txtbox, lastName);
		}
		else
		{
			seleniumHelper.enterValueIntoTextField(fullLegalBusinessName_txtbox, Name);
		}
		
		seleniumHelper.enterValueIntoTextField(licenseNumber_txtbox, "");
		
		seleniumHelper.clickElement(stateLicensed_Select);
		stateLicense_Value = seleniumHelper.findElementByXpath(affiliateSignUpPageDriver,"//li[@role = 'treeitem' and text()='"+stateLicensed+"']" );
		seleniumHelper.clickElement(stateLicense_Value);
		
		seleniumHelper.enterValueIntoTextField(website_txtbox,"");
		
		seleniumHelper.enterValueIntoTextField(taxID_txtbox,taxID);

		seleniumHelper.uploadFileUsingRobotClass(CopyOfLicense_ChooseButton, uploadFile.getAbsolutePath());
	//	seleniumHelper.setRunTimeImplicitWait(affiliateSignUpPageDriver, 20);
		
		seleniumHelper.enterValueIntoTextField(contactPerson_txtbox,contactPerson);
		seleniumHelper.enterValueIntoTextField(emailaddress_txtbox,emailAddress);
		seleniumHelper.enterValueIntoTextField(phoneNumber_txtbox,phoneNumber);
		seleniumHelper.enterValueIntoTextField(faxnumber_txtbox,faxnumber);
		
		seleniumHelper.uploadFileUsingRobotClass(CopyOfW9_ChooseButton, uploadFile.getAbsolutePath());
		
		//seleniumHelper.setRunTimeImplicitWait(affiliateSignUpPageDriver, 20);
		
		
		seleniumHelper.enterValueIntoTextField(Address1_txtbox,Address1);
		seleniumHelper.enterValueIntoTextField(Address2_txtbox,Address2);
		seleniumHelper.enterValueIntoTextField(City_txtbox,city);
		
		seleniumHelper.enterValueIntoTextField(zipCode_txtbox, zipCode);
		
		
		
		
		seleniumHelper.clickElement(submit_button);
		
		
	}
	
	public void verifyElementHighlightedInRedColor(String Element)
	{
		element = seleniumHelper.findElementByXpath(affiliateSignUpPageDriver,"//label[contains(text(),'"+ Element +"')]//..//input[contains(@class,'input-validation-error')]" );
		seleniumHelper.isElementExist(element);
	}
}



	

