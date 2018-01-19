package safetrip.pages;


import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


public class SafetripComparisonPage extends BasePage {

	private WebDriver comparisonPageDriver;
	
	public SafetripComparisonPage(WebDriver driver)
	{
		this.comparisonPageDriver = driver;
		PageFactory.initElements(driver, this);
		pageName = "<b style='color:#00008B;'>"+this.getClass().getSimpleName()+"</b>";
			bp = this;
	}
	
	@FindBy(xpath = "//a[span[text()='Home']]/i")
	public WebElement homePageIcon_link;
	
	public WebElement ageElement = null;
	WebElement perTravelerTierOneCost_wbel = null;
	WebElement perTravelerTierTwoCost_wbel = null;
	WebElement perTravelerTierThreeCost_wbel = null;
	
	@FindBy(xpath = "//h1[contains(text(),'SafeTrip - Comparison')]")
	public WebElement safetripComparison_text;
	
	//*----------------------Trip Info objects Under TripInfo section of Comparison Screen--------------*//
	@FindBy(xpath = "//li[contains(text(),'Primary Destination')]/strong")
	public WebElement primaryDestination_field;
	
	@FindBy(xpath = "//li[contains(text(),'Home Country')]/strong")
	public WebElement homeCountry_field;
	
	@FindBy(xpath = "//li[contains(text(),'Start Date')]/strong")
	public WebElement startDate_field;
	
	@FindBy(xpath = "//li[contains(text(),'Return Date')]/strong")
	public WebElement returnDate_field;
	
	@FindBy(xpath = "//li[contains(text(),'Return Date')]/following-sibling::li[1]/strong")
	public WebElement age1_txtBox;
	
	//*--------------------------------------------Edit Trip Info-------------------------------------*//
	@FindBy(xpath = "//a[text() = 'Edit trip info']")
	public WebElement editTripInfo_btn;
	
	@FindBy(xpath = "//p[label[contains(text(),'ny people are traveling?')]]/following-sibling::span//span[@role = 'combobox']")
	public WebElement noOfTraveler_txtbox;
	
	@FindBy(xpath = "//p[label[contains(text(),'t’s your primary destination?')]]/following-sibling::span//span[@role = 'combobox']")
	public WebElement primaryDestination_txtbox;
	
	
	@FindBy(xpath = "//p[label[contains(text(),'Where are you from?')]]/following-sibling::span//span[@role = 'combobox']")
	public WebElement residentCountry_txtbox;
	
	@FindBy(xpath = "(//a[text()='Buy now'])[1]")
	public WebElement tierOneBuyNow_btn;
	
	@FindBy(xpath = "(//a[text()='Buy now'])[2]")
	public WebElement tierTwoBuyNow_btn;
	
	@FindBy(xpath = "(//a[text()='Buy now'])[3]")
	public WebElement tierThreeBuyNow_btn;
	
	
	//*---------------------------------------Offered Packages to a Trip-------------------------------------*//
	@FindBy(xpath = "//table[starts-with(@class,'table comparisonTable')]//h4[contains(text(),'Coverage a')]")
	public WebElement coverageAmount_txtEle;
	
	@FindBy(xpath = "//table[starts-with(@class,'table comparisonTable')]//h4[contains(text(),'Deductible a')]")
	public WebElement deductibleAmount_txtEle;
	
	@FindBy(xpath = "//table[starts-with(@class,'table comparisonTable')]//h4[contains(text(),'Extreme sports c')]")
	public WebElement extremeSportsCoverage_txtEle;
	
	@FindBy(xpath = "//table[starts-with(@class,'table comparisonTable')]//h4[contains(text(),'Trip cancellation c')]")
	public WebElement tripCancellation_txtEle;
	
	@FindBy(xpath = "//div[@class = 'modal-content']//a[text() = 'Continue']")
	public WebElement continueButtonOnModal_btn;
	
	//*---------------------Objects For Tiers-----------------------------*//
							
					//--------------------------DYNAMIC XPATH--------------------//
	String perTravelerTierOneCost_txt = 	"//div[@id = 'mCSB_2_container']//li[starts-with(@class,'ng-binding')][XXX]//span[@class = 'ng-binding ng-scope'][1]";
	String perTravelerTierTwoCost_txt = 	"//div[@id = 'mCSB_2_container']//li[starts-with(@class,'ng-binding')][XXX]//span[@class = 'ng-binding ng-scope'][2]";
	String perTravelerTierThreeCost_txt = 	"//div[@id = 'mCSB_2_container']//li[starts-with(@class,'ng-binding')][XXX]//span[@class = 'ng-binding ng-scope'][3]";
	String ageElement_txt = 				"//li[contains(text(),'Return Date')]/following-sibling::li[XXX]/strong";
					//--------------------------DYNAMIC XPATH END--------------------//

	@FindBys({ @FindBy(xpath = "//table[starts-with(@class,'table comparisonTable')]//td[starts-with(@class,'planinfo')]/h2") })
	public List<WebElement> numberOfTiers;
	
	@FindBy(xpath = "((//table[starts-with(@class,'table comparisonTabl')]//tr[3]//div[contains(@data-ng-show, 'ENVARTYP_Deductible')])[1]//input)[1]")
	public WebElement zeroDeductibleFirstTier_wbel;
	
	@FindBy(xpath = "((//table[starts-with(@class,'table comparisonTabl')]//tr[3]//div[contains(@data-ng-show, 'ENVARTYP_Deductible')])[1]//input)[2]")
	public WebElement hundredDeductibleFirstTier_wbel;
	
	@FindBy(xpath = "((//table[starts-with(@class,'table comparisonTabl')]//tr[3]//div[contains(@data-ng-show, 'ENVARTYP_Deductible')])[1]//input)[3]")
	public WebElement twoFiftyDeductibleFirstTier_wbel;
	
	@FindBy(xpath = "(//div[@class = 'options']//input[@type = 'checkbox' and contains(@data-in,'mit.cancellation')])[1]")
	public WebElement tripCanCheckboxFirstTier_chkbox;
	
	@FindBy(xpath = "(//div[@class = 'options']//input[@type = 'checkbox' and contains(@data-ng-model,'it.vehicle')])[1]")
	public WebElement sportsRiderChkboxFirstTier_chkbox;
	
	@FindBy(xpath = "((//table[starts-with(@class,'table comparisonTabl')]//tr[3]//div[contains(@data-ng-show, 'ENVARTYP_Deductible')])[2]//input)[1]")
	public WebElement zeroDeductibleSecondTier_wbel;
	
	@FindBy(xpath = "((//table[starts-with(@class,'table comparisonTabl')]//tr[3]//div[contains(@data-ng-show, 'ENVARTYP_Deductible')])[2]//input)[2]")
	public WebElement hundredDeductibleSecondTier_wbel;
	
	@FindBy(xpath = "((//table[starts-with(@class,'table comparisonTabl')]//tr[3]//div[contains(@data-ng-show, 'ENVARTYP_Deductible')])[2]//input)[3]")
	public WebElement twoFiftyDeductibleSecondTier_wbel;
	
	@FindBy(xpath = "(//div[@class = 'options']//input[@type = 'checkbox' and contains(@data-in,'mit.cancellation')])[2]")
	public WebElement tripCanCheckboxSecondTier_chkbox;
	
	@FindBy(xpath = "(//div[@class = 'options']//input[@type = 'checkbox' and contains(@data-ng-model,'it.vehicle')])[2]")
	public WebElement sportsRiderChkboxSecondTier_chkbox;
	
	
	
	@FindBy(xpath = "((//table[starts-with(@class,'table comparisonTabl')]//tr[3]//div[contains(@data-ng-show, 'ENVARTYP_Deductible')])[3]//input)[1]")
	public WebElement zeroDeductibleThirdTier_wbel;
	
	@FindBy(xpath = "((//table[starts-with(@class,'table comparisonTabl')]//tr[3]//div[contains(@data-ng-show, 'ENVARTYP_Deductible')])[3]//input)[2]")
	public WebElement hundredDeductibleThirdTier_wbel;
	
	@FindBy(xpath = "((//table[starts-with(@class,'table comparisonTabl')]//tr[3]//div[contains(@data-ng-show, 'ENVARTYP_Deductible')])[3]//input)[3]")
	public WebElement twoFiftyDeductibleThirdTier_wbel;
	
	@FindBy(xpath = "(//div[@class = 'options']//input[@type = 'checkbox' and contains(@data-in,'mit.cancellation')])[3]")
	public WebElement tripCanCheckboxThirdTier_chkbox;
	
	@FindBy(xpath = "(//div[@class = 'options']//input[@type = 'checkbox' and contains(@data-ng-model,'it.vehicle')])[3]")
	public WebElement sportsRiderChkboxThirdTier_chkbox;
	
	
	
	@FindBy(xpath = "(//td[contains(@data-ng-repeat,'te.medeicalLimits')]//strong[@class = 'ng-binding'])[1]")
	public WebElement totalCostAmountFirstTierMedicalLimit;
	
	@FindBy(xpath = "(//td[contains(@data-ng-repeat,'te.medeicalLimits')]//strong[@class = 'ng-binding'])[2]")
	public WebElement totalCostAmountSecondTierMedicalLimit;

	@FindBy(xpath = "(//td[contains(@data-ng-repeat,'te.medeicalLimits')]//strong[@class = 'ng-binding'])[3]")
	public WebElement totalCostAmountThirdTierMedicalLimit;
	
	
	
	public TravelerInfoPage clickOnBuyNowButton(String agesSaperatedByComma )
	{
		try {
			 tierOneTotalCost = totalCostAmountFirstTierMedicalLimit.getText();
		String ages[]  = agesSaperatedByComma.split(",");
		WebDriverWait wait = new WebDriverWait(comparisonPageDriver, 60);
		
		//seleniumHelper.clickElement(sportsRiderChkboxFirstTier_chkbox);
		//seleniumHelper.clickElement(tripCanCheckboxFirstTier_chkbox);
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(tierOneBuyNow_btn));
		seleniumHelper.clickElement(tierOneBuyNow_btn);
		
		for(String s:ages) {if(Integer.parseInt(s.trim())>69) {seleniumHelper.clickElement(continueButtonOnModal_btn);break;}}
		
		safetripOrderId = runQuerytoGetSingleColumnValue(Environment("R&ATableName"),"Select top 1 * from ProcessingContext..SafetripOrder order by 1 desc", "id");
		
		//seleniumHelper.setRunTimeImplicitWait(comparisonPageDriver);
		return new TravelerInfoPage(comparisonPageDriver);
		}catch(Exception e)
		{
			 insertReportLine(e);
		}
		return null;
	}

	public void verifySafetripComparisonScreen(String text) {
		seleniumHelper.validateElementText(safetripComparison_text, text);
	}
	
	public void verifyTripInfoPageSection(String noOfTravelers,String destinationCountryName, String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma)
	{
		//bp = this;
		String ages[]  = agesSaperatedByComma.split(",");
		
		if(ages.length == Integer.parseInt(noOfTravelers)) {
			
		try {
		
		seleniumHelper.validateElementText(primaryDestination_field, destinationCountryName);
		seleniumHelper.validateElementText(homeCountry_field, residenceCountryName);
		seleniumHelper.validateDate(startDate_field.getText(), startDate);
		seleniumHelper.validateDate(returnDate_field.getText(), returnDate);
//		seleniumHelper.validateElementText(startDate_field, startDate.substring(1));
//		seleniumHelper.validateElementText(returnDate_field, returnDate.substring(1));
		
		for(int i = 0; i<=ages.length-1;i++)
		{
			ageElement = seleniumHelper.findElementByXpath(comparisonPageDriver,ageElement_txt.replace("XXX", Integer.toString(i+1)));
			seleniumHelper.validateElementText(ageElement, ages[i]);
			
		}
//		comparisonPageDriver.manage().deleteAllCookies();
//		//comparisonPageDriver.manage().timeouts().
//		seleniumHelper.clickElement(homePageIcon_link);
//		return new HomePage(comparisonPageDriver);
		
		}catch(Exception e)
		{
			 insertReportLine(e);
		}
		}
		//return null;
		
	}

	public void verifyOfferedPackages(String homeCountry, String startDate, String textCoverage, String textDeductible, String textExtremeSportsCoverage,String textTripCancellation )
	{
		try {
		//String coverageText = coverageAmount_txtEle.getText();
			
		if(!homeCountry.equals("United States"))// condition for Outbound and Transnational
		{
		seleniumHelper.validateElementText(coverageAmount_txtEle, textCoverage);
		seleniumHelper.validateElementText(deductibleAmount_txtEle, textDeductible);
		seleniumHelper.validateElementText(extremeSportsCoverage_txtEle, textExtremeSportsCoverage);
		}
		else
		{
			seleniumHelper.validateElementText(coverageAmount_txtEle, textCoverage);
			seleniumHelper.validateElementText(deductibleAmount_txtEle, textDeductible);
			seleniumHelper.validateElementText(extremeSportsCoverage_txtEle, textExtremeSportsCoverage);
			
			if(getDaysDifffromCurrentdate(startDate)>=10 && homeCountry.equalsIgnoreCase("United States"))
			seleniumHelper.validateElementText(tripCancellation_txtEle, textTripCancellation);
		}
		
		}catch(Exception e)
		{
			insertReportLine(LogStatus.FAIL, "Test Case Failed due to "+e.getClass().getName()+" Exception");
			 insertReportLine(e);
		}
		
}

	public void verifyNumberOfTiers(String homeCountry)
	{
		try {
			
			System.out.println("The tier Count "+numberOfTiers.size());
		
			if(!homeCountry.equals("United States"))// condition for Outbound and Transnational
			{
				if(numberOfTiers.size()!=2)
				{
					insertReportLine(LogStatus.FAIL, "The Tier count should be 2", "The Tier count is "+numberOfTiers.size());
					Assert.assertTrue(false);
				}
				seleniumHelper.validateElementTextContains(numberOfTiers.get(0), "SafeTrip 1");
				seleniumHelper.validateElementTextContains(numberOfTiers.get(1), "SafeTrip 2");
			}
			else
			{
				if(numberOfTiers.size()!=3)
				{
					insertReportLine(LogStatus.FAIL, "The Tier count should be 2", "The Tier count is "+numberOfTiers.size()+" Please verify the object locator first, before looking into anything else");
					Assert.assertTrue(false);
				}
				seleniumHelper.validateElementTextContains(numberOfTiers.get(0), "SafeTrip 1");
				seleniumHelper.validateElementTextContains(numberOfTiers.get(1), "SafeTrip 2");
				seleniumHelper.validateElementTextContains(numberOfTiers.get(2), "SafeTrip 3");
			}
			
			
		}catch(Exception e)
		{
			 insertReportLine(e);
		}
	}

	public TravelerInfoPage setCoveragePackages (String noOfTravelers, String tripStartDate, String agesSaperatedByComma, String residenceCountryName, String tripCancellationAmount, String medicalLimit, String deductible, String sportsRider)
	{
		String ages[]; 
		if(Integer.parseInt(noOfTravelers)>1)
		{
			 ages = agesSaperatedByComma.split(",");
		}else
		{
			ages = new String[Integer.parseInt(noOfTravelers)];
			ages[0] = agesSaperatedByComma;
		}
		try {
			switch(medicalLimit)
			{
			case "100000":
			switch(deductible)
			{
			case "0":
				seleniumHelper.clickElement(zeroDeductibleFirstTier_wbel);
				//zeroDeductible_100000MedicalLimit_wbel.click();
				break;
			case "100":
				seleniumHelper.clickElement(hundredDeductibleFirstTier_wbel);
				break;
				//hundredDeductible_100000MedicalLimit_wbel.click();
			case "250":
				seleniumHelper.clickElement(twoFiftyDeductibleFirstTier_wbel);
				break;
			default:
				insertReportLine(LogStatus.FAIL, "Invalid deductible amount is entered on excel sheet", "please Enter deductible amount as either 0,100 or 250");
				Assert.assertTrue(false);
			}
			
			//getDaysDifffromCurrentdate(startDate)>=10 && residenceCountryName.equals("United States")
			
			if(getDaysDifffromCurrentdate(tripStartDate)>=10 && !tripCancellationAmount.equals("0")&& residenceCountryName.toUpperCase().trim().equals("UNITED STATES"))
			{
				seleniumHelper.clickElement(tripCanCheckboxFirstTier_chkbox);
				//tripCanCheckbox100000MedicalLimit_chkbox.click();
			}
			
			if(sportsRider.equals("Yes"))
			{
				seleniumHelper.clickElement(sportsRiderChkboxFirstTier_chkbox);
			}
			seleniumHelper.clickElement(tierOneBuyNow_btn);
			break;
			case "500000":
			
				switch(deductible)
				{
				case "0":
					seleniumHelper.clickElement(zeroDeductibleSecondTier_wbel);
					//zeroDeductible_100000MedicalLimit_wbel.click();
					break;
				case "100":
					seleniumHelper.clickElement(hundredDeductibleSecondTier_wbel);
					break;
					//hundredDeductible_100000MedicalLimit_wbel.click();
				case "250":
					seleniumHelper.clickElement(twoFiftyDeductibleSecondTier_wbel);
					break;
				default:
					insertReportLine(LogStatus.FAIL, "Invalid deductible amount is entered on excel sheet", "please Enter deductible amount as either 0,100 or 250");
					Assert.assertTrue(false);
				}
				if(getDaysDifffromCurrentdate(tripStartDate)>=10 && !tripCancellationAmount.equals("0")&& residenceCountryName.toUpperCase().trim().equals("UNITED STATES"))
				{
					seleniumHelper.clickElement(tripCanCheckboxSecondTier_chkbox);
					//tripCanCheckbox100000MedicalLimit_chkbox.click();
				}
				
				if(sportsRider.equals("Yes"))
				{
					seleniumHelper.clickElement(sportsRiderChkboxSecondTier_chkbox);
				}
				seleniumHelper.clickElement(tierTwoBuyNow_btn);
				break;
			case "1000000":
				
				switch(deductible)
				{
				case "0":
					seleniumHelper.clickElement(zeroDeductibleThirdTier_wbel);
					//zeroDeductible_100000MedicalLimit_wbel.click();
					break;
				case "100":
					seleniumHelper.clickElement(hundredDeductibleThirdTier_wbel);
					break;
					//hundredDeductible_100000MedicalLimit_wbel.click();
				case "250":
					seleniumHelper.clickElement(twoFiftyDeductibleThirdTier_wbel);
					break;
				default:
					insertReportLine(LogStatus.FAIL, "Invalid deductible amount is entered on excel sheet", "please Enter deductible amount as either 0,100 or 250");
					Assert.assertTrue(false);
				}
				if(getDaysDifffromCurrentdate(tripStartDate)>=10 && !tripCancellationAmount.equals("0")&& residenceCountryName.toUpperCase().trim().equals("UNITED STATES"))
				{
					seleniumHelper.clickElement(tripCanCheckboxThirdTier_chkbox);
					//tripCanCheckbox100000MedicalLimit_chkbox.click();
				}
				
				if(sportsRider.equals("Yes"))
				{
					seleniumHelper.clickElement(sportsRiderChkboxThirdTier_chkbox);
				}
				seleniumHelper.clickElement(tierThreeBuyNow_btn);
				break;
				
			case "250000":
				switch(deductible)
				{
				case "0":
					seleniumHelper.clickElement(zeroDeductibleSecondTier_wbel);
					//zeroDeductible_100000MedicalLimit_wbel.click();
					break;
				case "100":
					seleniumHelper.clickElement(hundredDeductibleSecondTier_wbel);
					break;
					//hundredDeductible_100000MedicalLimit_wbel.click();
				case "250":
					seleniumHelper.clickElement(twoFiftyDeductibleSecondTier_wbel);
					break;
				default:
					insertReportLine(LogStatus.FAIL, "Invalid deductible amount is entered on excel sheet", "please Enter deductible amount as either 0,100 or 250");
					Assert.assertTrue(false);
				}
				if(sportsRider.equals("Yes"))
				{
					seleniumHelper.clickElement(sportsRiderChkboxSecondTier_chkbox);
				}
				
				if(getDaysDifffromCurrentdate(tripStartDate)>=10 && !tripCancellationAmount.equals("0")&& residenceCountryName.toUpperCase().trim().equals("UNITED STATES"))
				{
//					for(int i = 0; i<=Integer.parseInt("3");i++) //Code to be added to verify the cost details on Enrollment application for each traveler before and after selecting tripcanellation 
//					{
//						
//					}
//					perTravelerTierTwoCost_wbel = seleniumHelper.findElementByXpath(comparisonPageDriver, perTravelerTierTwoCost_txt.replace("XXX", Integer.toString(i+1)));
//					String amount = 
//					costDetails_with_and_without_tripcan.put
					seleniumHelper.clickElement(tripCanCheckboxSecondTier_chkbox);
					//tripCanCheckbox100000MedicalLimit_chkbox.click();
				}
				
				
				seleniumHelper.clickElement(tierTwoBuyNow_btn);
				break;
			}
			
			for(String s:ages) 
			{
				if(Integer.parseInt(s.trim())>69) 
				{
				seleniumHelper.clickElement(continueButtonOnModal_btn);
				break;
				}
			}
			
			
			if(currentTestName.equalsIgnoreCase("veriFyOrderDeclined_Test")) {
			safetripOrderId = runQuerytoGetSingleColumnValue(Environment("R&ATableName"),"Select top 1 * from ProcessingContext..SafetripOrder order by 1 desc", "id");
			
			
			}
			
			return new TravelerInfoPage(comparisonPageDriver);
			
		}catch(Exception e)
		{
			System.out.println("Exception Occured in setCoveragePackage method "+e.getClass().getSimpleName()+"reason: "+e.getCause()+" Message: "+e.getMessage());
			 insertReportLine(e);
		}
		return null;
		
		
	}

	String perTravelerCost = "";
	public void verifyQuoteCalculations(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String medicalLimit, String deductible, String sportsRider)
	{
		switch(medicalLimit)
		{
		case "100000":
		switch(deductible)
		{
		case "0":
			seleniumHelper.clickElement(zeroDeductibleFirstTier_wbel);
			//zeroDeductible_100000MedicalLimit_wbel.click();
			break;
		case "100":
			seleniumHelper.clickElement(hundredDeductibleFirstTier_wbel);
			break;
			//hundredDeductible_100000MedicalLimit_wbel.click();
		case "250":
			seleniumHelper.clickElement(twoFiftyDeductibleFirstTier_wbel);
			break;
		default:
			insertReportLine(LogStatus.FAIL, "Invalid deductible amount is entered on excel sheet", "please Enter deductible amount as either 0,100 or 250");
			Assert.assertTrue(false);
		}
		if(getDaysDifffromCurrentdate(startDate)>=10 && !tripCancellationAmount.equals("0")&& residenceCountryName.toUpperCase().trim().equals("UNITED STATES"))
		{
			seleniumHelper.clickElement(tripCanCheckboxFirstTier_chkbox);
			//tripCanCheckbox100000MedicalLimit_chkbox.click();
		}
		
		if(sportsRider.equals("Yes"))
		{
			seleniumHelper.clickElement(sportsRiderChkboxFirstTier_chkbox);
		}
		break;
		case "500000":
		
			switch(deductible)
			{
			case "0":
				seleniumHelper.clickElement(zeroDeductibleSecondTier_wbel);
				//zeroDeductible_100000MedicalLimit_wbel.click();
				break;
			case "100":
				seleniumHelper.clickElement(hundredDeductibleSecondTier_wbel);
				break;
				//hundredDeductible_100000MedicalLimit_wbel.click();
			case "250":
				seleniumHelper.clickElement(twoFiftyDeductibleSecondTier_wbel);
				break;
			default:
				insertReportLine(LogStatus.FAIL, "Invalid deductible amount is entered on excel sheet", "please Enter deductible amount as either 0,100 or 250");
				Assert.assertTrue(false);
			}
			if(getDaysDifffromCurrentdate(startDate)>=10 && !tripCancellationAmount.equals("0")&& residenceCountryName.toUpperCase().trim().equals("UNITED STATES"))
			{
				seleniumHelper.clickElement(tripCanCheckboxSecondTier_chkbox);
				//tripCanCheckbox100000MedicalLimit_chkbox.click();
			}
			
			if(sportsRider.equals("Yes"))
			{
				seleniumHelper.clickElement(sportsRiderChkboxSecondTier_chkbox);
			}
			break;
		case "1000000":
			
			switch(deductible)
			{
			case "0":
				seleniumHelper.clickElement(zeroDeductibleThirdTier_wbel);
				//zeroDeductible_100000MedicalLimit_wbel.click();
				break;
			case "100":
				seleniumHelper.clickElement(hundredDeductibleThirdTier_wbel);
				break;
				//hundredDeductible_100000MedicalLimit_wbel.click();
			case "250":
				seleniumHelper.clickElement(twoFiftyDeductibleThirdTier_wbel);
				break;
			default:
				insertReportLine(LogStatus.FAIL, "Invalid deductible amount is entered on excel sheet", "please Enter deductible amount as either 0,100 or 250");
				Assert.assertTrue(false);
			}
			if(getDaysDifffromCurrentdate(startDate)>=10 && !tripCancellationAmount.equals("0")&& residenceCountryName.toUpperCase().trim().equals("UNITED STATES"))
			{
				seleniumHelper.clickElement(tripCanCheckboxThirdTier_chkbox);
				//tripCanCheckbox100000MedicalLimit_chkbox.click();
			}
			
			if(sportsRider.equals("Yes"))
			{
				seleniumHelper.clickElement(sportsRiderChkboxThirdTier_chkbox);
			}
			break;
			
		case "250000":
			switch(deductible)
			{
			case "0":
				seleniumHelper.clickElement(zeroDeductibleSecondTier_wbel);
				//zeroDeductible_100000MedicalLimit_wbel.click();
				break;
			case "100":
				seleniumHelper.clickElement(hundredDeductibleSecondTier_wbel);
				break;
				//hundredDeductible_100000MedicalLimit_wbel.click();
			case "250":
				seleniumHelper.clickElement(twoFiftyDeductibleSecondTier_wbel);
				break;
			default:
				insertReportLine(LogStatus.FAIL, "Invalid deductible amount is entered on excel sheet", "please Enter deductible amount as either 0,100 or 250");
				Assert.assertTrue(false);
			}
			if(!tripCancellationAmount.equals("0") && residenceCountryName.toUpperCase().trim().equals("UNITED STATES"))
			{
				seleniumHelper.clickElement(tripCanCheckboxSecondTier_chkbox);
				//tripCanCheckbox100000MedicalLimit_chkbox.click();
			}
			
			if(sportsRider.equals("Yes"))
			{
				seleniumHelper.clickElement(sportsRiderChkboxSecondTier_chkbox);
			}
			break;
		}
		Map<String, String> tripCostDetails = quoteCalculation.quoteCalculation(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, tripCancellationAmount, medicalLimit, deductible, sportsRider);
//		Set<String> keys = tripCostDetails.keySet();
		
		//Iterator<String> it = keys.iterator();
		System.out.println("asdj");
		
		
		for(int i = 0; i<=Integer.parseInt(noOfTravelers)-1; i++)
		{
			String actual = "";
			String expected = "";
			switch(medicalLimit)
			{
			case "100000":
			perTravelerTierOneCost_wbel = seleniumHelper.findElementByXpath(comparisonPageDriver, perTravelerTierOneCost_txt.replace("XXX", Integer.toString(i+1)));
			perTravelerCost = (perTravelerTierOneCost_wbel.getText().substring(1).split(","))[0].trim();
			actual = perTravelerCost.replace(",", "");
			expected = tripCostDetails.get("Traveler "+(i+1));
			
			validateCalculations(i+1, actual, expected, totalCostAmountFirstTierMedicalLimit.getText().substring(1).replace(",", ""), tripCostDetails.get("Total Cost"));
				
			break;
			
			case "500000":
				perTravelerTierTwoCost_wbel = seleniumHelper.findElementByXpath(comparisonPageDriver, perTravelerTierTwoCost_txt.replace("XXX", Integer.toString(i+1)));
				perTravelerCost = (perTravelerTierTwoCost_wbel.getText().substring(1).split(","))[0].trim();
				actual = perTravelerCost.replace(",", "");
				expected = tripCostDetails.get("Traveler "+(i+1));
				
				validateCalculations(i+1, actual, expected, totalCostAmountSecondTierMedicalLimit.getText().substring(1).replace(",", ""), tripCostDetails.get("Total Cost"));
				
				
				break;
				
			case "1000000":
				perTravelerTierThreeCost_wbel = seleniumHelper.findElementByXpath(comparisonPageDriver, perTravelerTierThreeCost_txt.replace("XXX", Integer.toString(i+1)));
				perTravelerCost = (perTravelerTierThreeCost_wbel.getText().substring(1).split(","))[0].trim();
				actual = perTravelerCost.replace(",", "");
				expected = tripCostDetails.get("Traveler "+(i+1));
				
				validateCalculations(i+1, actual, expected, totalCostAmountThirdTierMedicalLimit.getText().substring(1).replace(",", ""), tripCostDetails.get("Total Cost"));
				
				break;
				
			case "250000":
				perTravelerTierTwoCost_wbel = seleniumHelper.findElementByXpath(comparisonPageDriver, perTravelerTierTwoCost_txt.replace("XXX", Integer.toString(i+1)));
				perTravelerCost = (perTravelerTierTwoCost_wbel.getText().substring(1).split(","))[0].trim();
				actual = perTravelerCost.replace(",", "");
				expected = tripCostDetails.get("Traveler "+(i+1));
				
				validateCalculations(i+1, actual, expected, totalCostAmountSecondTierMedicalLimit.getText().substring(1).replace(",", ""), tripCostDetails.get("Total Cost"));
				
				break;
			
			}
			
		}
		isTotalCostValidated = false;
		
		//seleniumHelper.validateElementTextContains(totalCostAmountFirstTierMedicalLimit, tripCostDetails.get("Total Cost"));
		
	}
	

}
