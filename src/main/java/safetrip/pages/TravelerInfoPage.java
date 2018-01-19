package safetrip.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class TravelerInfoPage extends BasePage {
	
	private WebDriver travelerInfoDriver;
	public TravelerInfoPage(WebDriver driver)
	{
		
		//System.out.println("before init element s  "+this);
		this.travelerInfoDriver = driver;
		PageFactory.initElements(driver, this);	
		pageName = "<b style='color:#00008B;'>"+this.getClass().getSimpleName()+"</b>";
		bp = this;		
	}
	
	/*---- Age Modal Window Objects----*/
	
	@FindBy(xpath = "//div[@class = 'modal-body']//p//strong[1]")
	public WebElement ageAfterDOBSelected_txt;
	
	@FindBy(xpath = "//div[@class = 'modal-body']//p//strong[2]")
	public WebElement ageEnteredWhileQuoting_txt;
	
	@FindBy(xpath = "//div[@class = 'modal-body']/div/div[contains(@class,'col')]/p[1]")
	public WebElement dobMismatchMsg_txt;
	
	@FindBy(xpath = "//div[@class = 'modal-body']/div/div[contains(@class,'col')]/p[2]")
	public WebElement updatedCoverageMsg_txt;
	
	@FindBy(xpath = "//div[@class = 'modal-body']/div/div/div[contains(@data-ng-show,'sTraveller')]/p[1]")
	public WebElement updatedTripCostMsg_txt;

	@FindBy(xpath = "//div[@class = 'modal-body']/div/div/div[contains(@data-ng-show,'sTraveller')]/p[2]")
	public WebElement continueToPurchaseWithNewAmtMsg_txt;
	
	@FindBy(xpath = "//div[@class = 'modal-body']//div[@class = 'links']//button")
	public WebElement continueWithPurchase_btn;
	
	@FindBy(xpath = "//div[@class = 'modal-body']//div[@class = 'links']//a")
	public WebElement returnToComparison_btn;
	
	@FindBy(xpath = "//div[@class = 'modal-header']//button[@class = 'close']")
	public WebElement ageModalWindowClose_btn;
	
	
	/*---- End Of Age Modal Window Objects----*/
	
	@FindBy(xpath = "//div[contains(@class,'modal-body')]//p")
	public WebElement noCoverageModalWindowMsg_txt;
	
	@FindBy(xpath = "//section[@class = 'body current']//h1[@class = 'ng-binding']/a")
	public WebElement modify_link;
	

	@FindBy(xpath = "(//a[text() = 'Next'])[1]")
	public WebElement nextButton;
	
	@FindBys(@FindBy(xpath = "//input[@name = 'country_mailling']/following-sibling::div//li/a"))
	List<WebElement> populatedListFromAutocompleteBox_li;
	@FindBy(name = "country_mailling")
	public WebElement purMailingAddCountry_txtbox;
	
	@FindBy(name = "state_mailling")
	public WebElement purMailingAddState_txtbox;
	
	//Objects For warning Modal Window 
	@FindBy(xpath = "//div[starts-with(@class,'warning-modal')]//div[starts-with(@class,'col-md')]/p[1]")
	public WebElement warningModalwinTextWithDOBcomparison_text;
	
	@FindBy(xpath = "//div[starts-with(@class,'warning-modal')]//div[starts-with(@class,'col-md')]/p[1]")
	public WebElement warningModalwinTextWithSorryForInconvinience_text;

	@FindBy(xpath = "(//div[@id='1']//input[@type= 'checkbox'])[1]")
	public WebElement sameAsAllTrvEmailAdd_chkbox;
	
	@FindBy(xpath = "(//div[@id='1']//input[@type= 'checkbox'])[2]")
	public WebElement sameAsAllTrvPrimaryInsurance_chkbox;
	
	@FindBy(xpath = "(//div[@id='1']//input[@type= 'checkbox'])[3]")
	public WebElement sameAsAllTrvContactDetails_chkbox;
	
	@FindBy(xpath = "(//div[@id='1']//input[@type= 'checkbox'])[4]")
	public WebElement sameAsAllTrvBenfNameAdd_chkbox;
	
	//-------------------DYNAMIC XPATH----------------------//
	String trvSalutation_xpath = "//div[@id='XXX']//label[text()='Salutation']/following-sibling::select";
	String trvFirstNam_xpath = "//div[@id='XXX']//input[@name = 'firstname']";
	String trvMiddleName_xpath = "//div[@id='XXX']//input[@name = 'middleInitial']";
	String trvLastName_xpath = "//div[@id='XXX']//input[@name = 'lastname']";
	String trvSuffix_xpath = "//div[@id='XXX']//label[text()='Suffix']/following-sibling::select";
	String trvDOB_xpath = "//div[@id='XXX']//input[@name = 'dob']";
	String trvEmailId_xpath = "//div[@id='XXX']//input[@name = 'email']";
	String trvPrimaryInsurance_xpath = "//div[@id='XXX']//input[@name = 'p_insurance']";
	String trvContactName_xpath = "//div[@id='XXX']//input[@name = 'contactName']";
	String trvContactPhone_xpath =  "//div[@id='XXX']//input[@name = 'contactPhone']";
	String trvContactSecondaryPhone_xpath = "//div[@id='XXX']//input[@name = 'secondaryPhone']";
	String trvBeneficiaryName_xpath =  "//div[@id='XXX']//input[@name = 'b_name']";
	String accordionHeader_xpath =  "//div[@id = 'XXX']/preceding-sibling::div//a";
	//-------------------DYNAMIC XPATH END----------------------//
	
	public WebElement trvLastName;
	public WebElement trvFirstName;
	public WebElement trvMiddleName;
	public WebElement trvSuffix;
	public WebElement trvSalutatione;
	public WebElement trvDOB;
	public WebElement trvEmailAdd;
	public WebElement trvPrimaryInsurance;
	public WebElement trvContactName;
	public WebElement trvContactPhone;
	public WebElement trvContactSecondaryPhone;
	public WebElement trvBeneficiaryName;
	public WebElement trvSalutation;
	public WebElement accordionHeader;
	
	public HomePage clickOnModifyLink()
	{
		modify_link.click();
		return new HomePage(travelerInfoDriver);
	}
	
	public PurchaserInfoPage enterAllTravelerDetails(String noOfTravelers,String travelerAges)
	{
		Object[][] data = null;
		data = getTravelerDetailsFromExcel("TravelerDetails",Integer.parseInt(noOfTravelers));
		int trvCount=0;
		
		String[] trvDetails = new String[12];
		
		String[] trvAgesArr = new String[Integer.parseInt(noOfTravelers)];
		
		if(Integer.parseInt(noOfTravelers)>1)
		{
		trvAgesArr = travelerAges.split(",");
		}else
		{
			trvAgesArr[0] = travelerAges;
		}
//		String[] trvDetails = new String[12];
//		
//		String[] trvAgesArr = new String[Integer.parseInt(noOfTravelers)];
//		
//		trvAgesArr = travelerAges.split(",");
		String trvdob = "";
		
		int accordionNum = 0;
		
		for(int i=0;i<=data.length-1;i++)
		{
			trvCount = i+1;
			for(int j = 0;j<=data[i].length-1;j++)
			{
				
				trvDetails[j] = (String) data[i][j];
			
			}
			trvSalutation = seleniumHelper.findElementByXpath(travelerInfoDriver,trvSalutation_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.selectFromDropdownByVisibleText(trvSalutation, trvDetails[0]);
			
			trvFirstName = seleniumHelper.findElementByXpath(travelerInfoDriver,trvFirstNam_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.enterValueIntoTextField(trvFirstName, trvDetails[1]);
			
			trvMiddleName = seleniumHelper.findElementByXpath(travelerInfoDriver, trvMiddleName_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.enterValueIntoTextField(trvMiddleName, trvDetails[2]);
			
			trvLastName = seleniumHelper.findElementByXpath(travelerInfoDriver, trvLastName_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.enterValueIntoTextField(trvLastName, trvDetails[3]);
			
			trvSuffix = seleniumHelper.findElementByXpath(travelerInfoDriver, trvSuffix_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.selectFromDropdownByVisibleText(trvSuffix, trvDetails[4]);
			
			if(!trvDetails[5].equals("Let the Selenium Code Choose the Correct DOB"))
			{
				trvdob = trvDetails[5];
			}else
			{
				trvdob =getBirthDate(Integer.parseInt(trvAgesArr[i])) ;
			}
			
			trvDOB = seleniumHelper.findElementByXpath(travelerInfoDriver, trvDOB_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.clickElement(trvDOB);
			selectDateFromCalender(trvdob,travelerInfoDriver);
			
			trvEmailAdd = seleniumHelper.findElementByXpath(travelerInfoDriver, trvEmailId_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.enterValueIntoTextField(trvEmailAdd, trvDetails[6]);
			
			trvPrimaryInsurance = seleniumHelper.findElementByXpath(travelerInfoDriver,trvPrimaryInsurance_xpath.replace("XXX", Integer.toString(trvCount)) );
			seleniumHelper.enterValueIntoTextField(trvPrimaryInsurance, trvDetails[7]);
			
			trvContactName = seleniumHelper.findElementByXpath(travelerInfoDriver, trvContactName_xpath.replace("XXX", Integer.toString(trvCount)) );
			seleniumHelper.enterValueIntoTextField(trvContactName, trvDetails[8]);
			
			trvContactPhone = seleniumHelper.findElementByXpath(travelerInfoDriver,trvContactPhone_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.enterValueIntoTextField(trvContactPhone, trvDetails[9]);
			
			trvContactSecondaryPhone = seleniumHelper.findElementByXpath(travelerInfoDriver, trvContactSecondaryPhone_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.enterValueIntoTextField(trvContactSecondaryPhone, trvDetails[10]);
			
			trvBeneficiaryName = seleniumHelper.findElementByXpath(travelerInfoDriver,trvBeneficiaryName_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.enterValueIntoTextField(trvBeneficiaryName, trvDetails[11]);
			
			if(trvCount != Integer.parseInt(noOfTravelers))
			{
				accordionNum = trvCount+1;
			accordionHeader = seleniumHelper.findElementByXpath(travelerInfoDriver, accordionHeader_xpath.replace("XXX", Integer.toString(accordionNum)));
			seleniumHelper.clickElement(accordionHeader);
			}
			
		}
		seleniumHelper.clickElement(nextButton);
		return new PurchaserInfoPage(travelerInfoDriver);
	}
	
	public PurchaserInfoPage enterTravellerDetailsWithSameAsAllTravelersCheckboxSelected(String noOfTravelers,String travelerAges)
	{
		Object[][] data = null;
		data = getTravelerDetailsFromExcel("TravelerDetails",Integer.parseInt(noOfTravelers));
		int trvCount=0;
		String[] trvDetails = new String[12];
		
		String[] trvAgesArr = new String[Integer.parseInt(noOfTravelers)];
		
		if(Integer.parseInt(noOfTravelers)>1)
		{
		trvAgesArr = travelerAges.split(",");
		}else
		{
			trvAgesArr[0] = travelerAges;
		}
			
		String trvdob = "";
		
		int accordionNum = 0;
		
		for(int i=0;i<=data.length-1;i++)
		{
			trvCount = i+1;
			for(int j = 0;j<=data[i].length-1;j++)
			{
				
				trvDetails[j] = (String) data[i][j];
				
				//System.out.print(data[i][j]+" ");
			}
			if(!trvDetails[0].equals("")) {
			trvSalutation = seleniumHelper.findElementByXpath(travelerInfoDriver,trvSalutation_xpath.replace("XXX", Integer.toString(trvCount)));
			
			//System.out.println(trvSalutation.toString());
			seleniumHelper.selectFromDropdownByVisibleText(trvSalutation, trvDetails[0]);
			}
			
			trvFirstName = seleniumHelper.findElementByXpath(travelerInfoDriver,trvFirstNam_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.enterValueIntoTextField(trvFirstName, trvDetails[1]);
			
		
			trvMiddleName = seleniumHelper.findElementByXpath(travelerInfoDriver, trvMiddleName_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.enterValueIntoTextField(trvMiddleName, trvDetails[2]);
			
			
			trvLastName = seleniumHelper.findElementByXpath(travelerInfoDriver, trvLastName_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.enterValueIntoTextField(trvLastName, trvDetails[3]);
			
			if(!trvDetails[4].equals("")) {
			trvSuffix = seleniumHelper.findElementByXpath(travelerInfoDriver, trvSuffix_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.selectFromDropdownByVisibleText(trvSuffix, trvDetails[4]);
			}
			
			if(!trvDetails[5].equals("Let the Selenium Code Choose the Correct DOB"))
			{
				trvdob = trvDetails[5];
			}else
			{
				trvdob =getBirthDate(Integer.parseInt(trvAgesArr[i])) ;
			}
			trvDOB = seleniumHelper.findElementByXpath(travelerInfoDriver, trvDOB_xpath.replace("XXX", Integer.toString(trvCount)));
			seleniumHelper.clickElement(trvDOB);
			selectDateFromCalender(trvdob,travelerInfoDriver);
			
			
			//System.out.println(warningModalwinTextWithDOBcomparison_text.getText());
		
			if(i==0) {

				trvEmailAdd = seleniumHelper.findElementByXpath(travelerInfoDriver, trvEmailId_xpath.replace("XXX", Integer.toString(trvCount)));
				seleniumHelper.enterValueIntoTextField(trvEmailAdd, trvDetails[6]);
				
				trvPrimaryInsurance = seleniumHelper.findElementByXpath(travelerInfoDriver,trvPrimaryInsurance_xpath.replace("XXX", Integer.toString(trvCount)) );
				seleniumHelper.enterValueIntoTextField(trvPrimaryInsurance, trvDetails[7]);
				
				trvContactName = seleniumHelper.findElementByXpath(travelerInfoDriver, trvContactName_xpath.replace("XXX", Integer.toString(trvCount)) );
				seleniumHelper.enterValueIntoTextField(trvContactName, trvDetails[8]);
				
				trvContactPhone = seleniumHelper.findElementByXpath(travelerInfoDriver,trvContactPhone_xpath.replace("XXX", Integer.toString(trvCount)));
				seleniumHelper.enterValueIntoTextField(trvContactPhone, trvDetails[9]);
				
				trvContactSecondaryPhone = seleniumHelper.findElementByXpath(travelerInfoDriver, trvContactSecondaryPhone_xpath.replace("XXX", Integer.toString(trvCount)));
				seleniumHelper.enterValueIntoTextField(trvContactSecondaryPhone, trvDetails[10]);
				
				trvBeneficiaryName = seleniumHelper.findElementByXpath(travelerInfoDriver,trvBeneficiaryName_xpath.replace("XXX", Integer.toString(trvCount)));
				seleniumHelper.enterValueIntoTextField(trvBeneficiaryName, trvDetails[11]);
			
				if(Integer.parseInt(noOfTravelers)>1)
				{
				seleniumHelper.clickElement(sameAsAllTrvEmailAdd_chkbox);
				seleniumHelper.clickElement(sameAsAllTrvPrimaryInsurance_chkbox);
				seleniumHelper.clickElement(sameAsAllTrvContactDetails_chkbox);
				seleniumHelper.clickElement(sameAsAllTrvBenfNameAdd_chkbox);
				}
			}
			
			if(trvCount != Integer.parseInt(noOfTravelers))
			{
				accordionNum = trvCount+1;
				accordionHeader = seleniumHelper.findElementByXpath(travelerInfoDriver, accordionHeader_xpath.replace("XXX", Integer.toString(accordionNum)));
				seleniumHelper.clickElement(accordionHeader);
			}
			
		}
		seleniumHelper.clickElement(nextButton);
		
		return new PurchaserInfoPage(travelerInfoDriver);
	}
	
	public void openAgeModalWindow(String travelerFirstName, String travelerLastName, String trvDateOfBirth, String age)
	{	
			trvFirstName = seleniumHelper.findElementByXpath(travelerInfoDriver,trvFirstNam_xpath.replace("XXX", Integer.toString(1)));
			seleniumHelper.enterValueIntoTextField(trvFirstName, travelerFirstName);
			
			trvLastName = seleniumHelper.findElementByXpath(travelerInfoDriver, trvLastName_xpath.replace("XXX", Integer.toString(1)));
			seleniumHelper.enterValueIntoTextField(trvLastName, travelerLastName);
			
			if(trvDateOfBirth.equals("Let the Selenium Code Choose the Correct DOB"))
			{
				trvDateOfBirth =getBirthDate(Integer.parseInt(age)) ;
			}
			trvDOB = seleniumHelper.findElementByXpath(travelerInfoDriver, trvDOB_xpath.replace("XXX", Integer.toString(1)));
			seleniumHelper.clickElement(trvDOB);
			selectDateFromCalender(trvDateOfBirth,travelerInfoDriver);
	}
	
	public void validateAgeModalWindow(String enteredAge, String selectedAgeFromDOBentered,String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String medicalLimit, String deductible, String sportsRider)
	{
		String expectedText = "";
				
		if(Integer.parseInt(selectedAgeFromDOBentered)>86)
		{
			expectedText = "Unfortunately you are not eligible for the policy that you selected. Please return to the Comparison page to view alternative coverage options.";
			seleniumHelper.validateElementText(noCoverageModalWindowMsg_txt, expectedText);
					
		}
		else
		{
				Map<String, String> calculatedCost = quoteCalculation.quoteCalculation(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, tripCancellationAmount, medicalLimit, deductible, sportsRider);
				String modifiedCost = calculatedCost.get("Total Cost");
				System.out.println(modifiedCost);
				expectedText  = "It looks like you have a birthday before you travel. This means the price will change from " +tierOneTotalCost+" to $"+modifiedCost.trim();
				
				seleniumHelper.validateElementText(updatedTripCostMsg_txt, expectedText);
				
				if(Integer.parseInt(selectedAgeFromDOBentered)>69)
				{
					if(isBetween(70, Integer.parseInt(selectedAgeFromDOBentered), 79)) {
						
						expectedText = "Because you will be over "+selectedAgeFromDOBentered+" when you travel we want to let you know that coverage is now $50,000 ";
					
					}else if(isBetween(80, Integer.parseInt(selectedAgeFromDOBentered), 85))
					{
						expectedText = " Oops! You entered your age as less than "+selectedAgeFromDOBentered+" but your calculated age before your date of departure is over "+selectedAgeFromDOBentered+". We want to let you know that coverage is now $10,000";
					}
					
					seleniumHelper.validateElementText(updatedCoverageMsg_txt, expectedText);
				}
				
				expectedText = "The Date of Birth entered for this traveler will make them "+selectedAgeFromDOBentered+" at the time of departure and not "+enteredAge+" as entered in the initial quote. ";
				seleniumHelper.validateElementText(dobMismatchMsg_txt, expectedText);
				
				
				
				
		}	
				
	}
	public void closeAgeModalWindow()
	{
		ageModalWindowClose_btn.click();
	}
	
 public void validateModalContentOndateMismatch()
 {
	 System.out.println(warningModalwinTextWithDOBcomparison_text.getText());
 }
	
}
