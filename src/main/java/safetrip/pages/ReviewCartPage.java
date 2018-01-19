package safetrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import java.text.NumberFormat;
public class ReviewCartPage extends BasePage {

private WebDriver reviewCartPageDriver;
	
	public ReviewCartPage(WebDriver driver)
	{		
		this.reviewCartPageDriver = driver;
		PageFactory.initElements(driver, this);
		pageName = "<b style='color:#00008B;'>"+this.getClass().getSimpleName()+"</b>";
		bp = this;	
		
	}
	
	HomePage homePage = new HomePage(reviewCartPageDriver);
	
	
	//-----------WebElements for Review Cart Page---------------//
	
	String 	trvDOB_txt = "//div[contains(@class,'panel-collapse')and contains(@aria-labelledby,'DYNAMIC_CONTENT')]//div//p[contains(.,'f birth')]/strong";
	public WebElement trvDOB_Wbel=null;
	
	String 	trvDepartureDate_txt = "//div[contains(@class,'panel-collapse')and contains(@aria-labelledby,'DYNAMIC_CONTENT')]//div//p[contains(.,'Departure date')]/strong";
	public WebElement trvDepartureDate_Wbel=null;
	
	String 	trvMedicalLimit_txt = "//div[contains(@class,'panel-collapse')and contains(@aria-labelledby,'DYNAMIC_CONTENT')]//p[contains(.,'Options purchased')]/strong";
	public WebElement trvMedicalLimit_Wbel=null;
	
	String 	trvDeductable_txt = "//div[contains(@class,'panel-collapse')and contains(@aria-labelledby,'DYNAMIC_CONTENT')]//div//p[contains(.,'Options purchased')]/span[contains(@data-ng-show,'deductible')]";
	public WebElement trvDeductable_Wbel=null;
	
	String 	trvSportsRider_txt = "//div[contains(@class,'panel-collapse')and contains(@aria-labelledby,'DYNAMIC_CONTENT')]//div//p[contains(.,'Options purchased')]/span[contains(@data-ng-show,'sportsCoverage')]";
	public WebElement trvSportsRider_Wbel=null;
	
	String 	trvTripCancellation_txt = "//div[contains(@class,'panel-collapse')and contains(@aria-labelledby,'DYNAMIC_CONTENT')]//div//p[contains(.,'Options purchased')]/span[contains(@data-ng-show,'cancellation')]";
	public WebElement trvTripCancellation_Wbel=null;
	
	String 	trvDestinationCountries_txt = "//div[contains(@class,'panel-collapse')and contains(@aria-labelledby,'DYNAMIC_CONTENT')]//div//p[contains(.,'Destination')]/strong";
	public WebElement trvDestinationCountries_Wbel=null;
	
	String 	trvEmailAddress_txt = "//div[contains(@class,'panel-collapse')and contains(@aria-labelledby,'DYNAMIC_CONTENT')]//div//p[contains(.,'Email address')]/strong";
	public WebElement trvEmailAddress_Wbel=null;
	
	String 	trvReturnDate_txt = "//div[contains(@class,'panel-collapse')and contains(@aria-labelledby,'DYNAMIC_CONTENT')]//div//p[contains(.,' Return date')]/strong";
	public WebElement trvReturnDate_Wbel=null;
	
	@FindBy(xpath = "//input[@name = 'termsAndCondition']")
	public WebElement termsAndCondition_chkBox;
	
	@FindBy(xpath = "//a[text()='Pay Now']")
	public WebElement payNow_btn;
	
	@FindBy(xpath="//a[text()='Previous']")
	public WebElement previous_btn;
	
	@FindBy(xpath="//p[contains(.,'Primary')]")
	public WebElement purchaser_information;
	
	@FindBy(xpath="//p[contains(.,'Mailing')]")
	public WebElement mailing_address;

	@FindBy(xpath="//p[contains(.,'Billing')]")
	public WebElement billing_address;
	
	@FindBy(xpath="//span[contains(@class,'modify purchaserView')]")
	public WebElement purchaserview_modify;
	
	@FindBy(xpath="//section[@class='body current']//h1//a")
	public WebElement reviewCart_modify;
	
	
	
	
//	for(int i =1; i<=2; i++)
//	{
//		trvDOB_Wbel = seleniumHelper.findElementByXpath(reviewCartPageDriver, trvDOB_txt.replace("DYNAMIC_CONTENT",Integer.toString(i) ));
//	}
	
	
	public CreditCardInfoPage acceptingTermsNavigatingToCreditCardPage()
	{
		
		
		seleniumHelper.clickElement(termsAndCondition_chkBox);
		seleniumHelper.clickElement(payNow_btn);
		
		//seleniumHelper.setRunTimeImplicitWait(reviewCartPageDriver, 30);
		
		return new CreditCardInfoPage(reviewCartPageDriver);
	}
	
	public void verifyPurchaserInfo(String salutation, String purFirstName, String purLastName, String suffix, 	String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, 
			String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode, String billingCOuntry, String billingAddressone, 
			String billingAddressTwo, String billingState, String billingCity, String billingZipcode)
	{
		try {
			
			
			
			
			seleniumHelper.validateElementTextContains(purchaser_information, purFirstName);
			seleniumHelper.validateElementTextContains(purchaser_information, purLastName);
			seleniumHelper.validateElementTextContains(purchaser_information, purEmail);
			seleniumHelper.validateElementTextContains(purchaser_information, primaryPhone);
			seleniumHelper.validateElementTextContains(mailing_address,mailingCOuntry);
			seleniumHelper.validateElementTextContains(mailing_address,mailingAddressone);
			seleniumHelper.validateElementTextContains(mailing_address,mailingAddressTwo);
			seleniumHelper.validateElementTextContains(mailing_address,mailingState);
			seleniumHelper.validateElementTextContains(mailing_address,mailingCity);
			seleniumHelper.validateElementTextContains(mailing_address,mailingZipcode);
			seleniumHelper.validateElementTextContains(billing_address,billingCOuntry);
			seleniumHelper.validateElementTextContains(billing_address,billingAddressone);
			seleniumHelper.validateElementTextContains(billing_address,billingAddressTwo);
			seleniumHelper.validateElementTextContains(billing_address,billingState);
			seleniumHelper.validateElementTextContains(billing_address,billingCity);
			seleniumHelper.validateElementTextContains(billing_address,billingZipcode);
			
		}catch(Exception e)
		{
			 insertReportLine(e);
		}
	}
	
	public void verifyTravellersDetails(String noOfTravelers,String destinationCountryName,  String startDate, String returnDate, String agesSaperatedByComma,  
			String tripCancellationAmount,String medicalLimit,String deductible,String sportsRider,String sportsRiderText,String tripCancellationText,String medicalLimitAbv70,String medicalLimitAbv80 )
	
	{
		Object[][] data = null;
		data = getTravelerDetailsFromExcel("TravelerDetails",Integer.parseInt(noOfTravelers));
		int trvCount=0;
		String[] trvDetails = new String[12];
		
		String[] trvAgesArr = new String[Integer.parseInt(noOfTravelers)];
		
		trvAgesArr = agesSaperatedByComma.split(",");
		String trvdob = "";
		
		int accordionNum = 0;
		try {
			
			
			for(int i=0;i<=data.length-1;i++)
			{
				trvCount = i+1;
				for(int j = 0;j<=data[i].length-1;j++)
				{
					trvDetails[j] = (String) data[i][j];
				}
				String trvFirstName = trvDetails[1];
				String middleName = trvDetails[2];
				String lastName = trvDetails[3];
				
				if(!trvDetails[5].equals("Let the Selenium Code Choose the Correct DOB"))
				{
					trvdob = trvDetails[5];
				}else
				{
					trvdob =getBirthDate(Integer.parseInt(trvAgesArr[i])) ;
				}
				String trvEmail = trvDetails[6];
				
				trvDOB_Wbel = seleniumHelper.findElementByXpath(reviewCartPageDriver, trvDOB_txt.replace("DYNAMIC_CONTENT", Integer.toString(trvCount)));
				trvDepartureDate_Wbel = seleniumHelper.findElementByXpath(reviewCartPageDriver, trvDepartureDate_txt.replace("DYNAMIC_CONTENT", Integer.toString(trvCount)));
				trvReturnDate_Wbel = seleniumHelper.findElementByXpath(reviewCartPageDriver, trvReturnDate_txt.replace("DYNAMIC_CONTENT", Integer.toString(trvCount)));
				trvEmailAddress_Wbel = seleniumHelper.findElementByXpath(reviewCartPageDriver, trvEmailAddress_txt.replace("DYNAMIC_CONTENT", Integer.toString(trvCount)));
				trvMedicalLimit_Wbel = seleniumHelper.findElementByXpath(reviewCartPageDriver, trvMedicalLimit_txt.replace("DYNAMIC_CONTENT", Integer.toString(trvCount)));
				trvDeductable_Wbel = seleniumHelper.findElementByXpath(reviewCartPageDriver, trvDeductable_txt.replace("DYNAMIC_CONTENT", Integer.toString(trvCount)));
				trvSportsRider_Wbel = seleniumHelper.findElementByXpath(reviewCartPageDriver, trvSportsRider_txt.replace("DYNAMIC_CONTENT", Integer.toString(trvCount)));
				trvTripCancellation_Wbel = seleniumHelper.findElementByXpath(reviewCartPageDriver, trvTripCancellation_txt.replace("DYNAMIC_CONTENT", Integer.toString(trvCount)));
				trvDestinationCountries_Wbel = seleniumHelper.findElementByXpath(reviewCartPageDriver, trvDestinationCountries_txt.replace("DYNAMIC_CONTENT", Integer.toString(trvCount)));
				
				insertReportLine(LogStatus.INFO, "Validation begins for Traveler-"+trvCount);
				
				seleniumHelper.validateElementTextContains(trvDOB_Wbel, trvdob);
				seleniumHelper.validateElementTextContains(trvEmailAddress_Wbel, trvEmail);
				seleniumHelper.validateElementTextContains(trvDepartureDate_Wbel, startDate);
				seleniumHelper.validateElementTextContains(trvReturnDate_Wbel, returnDate);
				
				if(Integer.parseInt(trvAgesArr[i])>=80)
				{
//					int  m= Integer.parseInt(medicalLimitAbv80);
//					 String medicallimit = NumberFormat.getIntegerInstance().format(m);
					    seleniumHelper.validateElementTextContains(trvMedicalLimit_Wbel,medicalLimitAbv80);
				}else if (Integer.parseInt(trvAgesArr[i])>=70)
				{
//					int  m= Integer.parseInt(medicalLimitAbv70);
//					 String medicallimit = NumberFormat.getIntegerInstance().format(m);
					    seleniumHelper.validateElementTextContains(trvMedicalLimit_Wbel,medicalLimitAbv70);	
				}
				else
				{
					int  m= Integer.parseInt(medicalLimit);
				    String medicallimit = NumberFormat.getIntegerInstance().format(m);
				    seleniumHelper.validateElementTextContains(trvMedicalLimit_Wbel,medicallimit);
				    if(sportsRider.equalsIgnoreCase("yes"))
					{
					seleniumHelper.validateElementTextContains(trvSportsRider_Wbel,sportsRiderText);
					}
				}
				
				seleniumHelper.validateElementTextContains(trvDeductable_Wbel,deductible);
				
				
				if(!tripCancellationAmount.equalsIgnoreCase(Integer.toString(0)))
				{
					seleniumHelper.validateElementTextContains(trvTripCancellation_Wbel,tripCancellationText);
				}
				
				seleniumHelper.validateElementTextContains(trvDestinationCountries_Wbel,destinationCountryName);
				
				insertReportLine(LogStatus.INFO, "Validation Completed for Traveler-"+trvCount);
			}
			
		}catch(Exception e)
		{
			 insertReportLine(e);
		}
	}
	
	public PurchaserInfoPage modifyPurchaserInfo()
	{
		seleniumHelper.clickElement(purchaserview_modify);
		
		return new PurchaserInfoPage(reviewCartPageDriver);
	}
	
	
	public HomePage modifyTravellersDetails()
	{
		seleniumHelper.clickElement(reviewCart_modify);
		
		return new HomePage(reviewCartPageDriver);
	}
	
	
}
