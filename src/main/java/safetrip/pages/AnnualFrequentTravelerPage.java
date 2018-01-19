package safetrip.pages;

import java.util.Date;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


public class AnnualFrequentTravelerPage extends BasePage{

	private WebDriver annualFrequentTravelerPageDriver;
	public AnnualFrequentTravelerPage(WebDriver driver)
	{
		this.annualFrequentTravelerPageDriver = driver;
		PageFactory.initElements(driver, this);
		bp = this;
	}
	
	@FindBy(xpath = "//p[label[contains(text(),'ple are traveling?')]]/following-sibling::span/span/span/span[1]")
	public WebElement noOfTravelers_txtBox;
	
	@FindBy(xpath = "//p[label[contains(text(),'ur primary destination?')]]/following-sibling::span/span/span/span[1]")
	public WebElement primaryDestination_txtBox;
	
	@FindBy(xpath = "//p[label[contains(text(),' Where are you from?')]]/following-sibling::span/span/span/span[1]")
	public WebElement residenceCountry_txtBox;
	
	@FindBy(name = "leaveDate")
	public WebElement tripStartDate_txtBox;
	
	@FindBy(name = "returnDate")
	public WebElement tripReturnDate_txtBox;
	
	@FindBy(xpath = "(//input[@name = 'state'])[1]")
	public WebElement stateOne_txtBox;
	
	@FindBy(xpath = "(//input[@name = 'costOfTrip'])[1]")
	public WebElement tripCancellation_txtBox;
	
	@FindBy(xpath = "//div[@class = 'modal-content']//a[text() = 'Continue']")
	public WebElement continueButtonOnModal_btn;
	
	public WebElement noOfTravellers_li;
	public WebElement countryList_wbel;
	public WebElement agetextbox;
	
	//-------------------DYNAMIC XPATH----------------------//
public String noOfTravellers_li_xpath =  	"//li[@role = 'treeitem'][XXX]";
public String countryList_xpath =  	"//li[@role = 'treeitem' and text()='XXX']";
public String ageTextBox_xpath = 			"//div[@data-ng-form = 'travelersForm[XXX]']//input[@name = 'age']";
	//-------------------DYNAMIC XPATH END----------------------//

	
public synchronized SafetripComparisonPage setAnnualFrequentTravelDetails(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String agesSaperatedByComma, String state, String tripCancellationAmount )
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
				if(ages.length == Integer.parseInt(noOfTravelers))
				{
					try {
						
						seleniumHelper.clickElement(noOfTravelers_txtBox);
						noOfTravellers_li = seleniumHelper.findElementByXpath(annualFrequentTravelerPageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
						seleniumHelper.clickElement(noOfTravellers_li);
						seleniumHelper.clickElement(primaryDestination_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(annualFrequentTravelerPageDriver,countryList_xpath.replace("XXX",destinationCountryName));
						seleniumHelper.clickElement(countryList_wbel);

					if(new Date(startDate).compareTo(new Date())<=0)
						{
							insertReportLine(LogStatus.FAIL, "Start Date Provided in the sheet  is either a current date or a past date, which is not acceptable ");
							Assert.assertTrue(false, "Start Date Provided in the sheet  is either a current date or a past date, which is not acceptable ");
						}
						
						seleniumHelper.clickElement(tripStartDate_txtBox);
						selectDateFromCalender(startDate, annualFrequentTravelerPageDriver);					
						if(residenceCountryName.trim().equals("United States"))
						{
							for(int i =0; i<=ages.length-1; i++)
							{
								agetextbox = seleniumHelper.findElementByXpath(annualFrequentTravelerPageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
								seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
								if(i==0)
									seleniumHelper.enterValueIntoTextField(stateOne_txtBox, state);
							}
						}else
						{
							for(int i =0; i<=ages.length-1; i++)
							{
								agetextbox = seleniumHelper.findElementByXpath(annualFrequentTravelerPageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
								seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
							}
						}
					
						
						for(String s:ages) 
						{
							if(Integer.parseInt(s.trim())>69) 
							{
							seleniumHelper.clickElement(continueButtonOnModal_btn);
							break;
							}
						}
						
						return new SafetripComparisonPage(annualFrequentTravelerPageDriver);
					}catch(NoSuchElementException ne)
					{
						insertReportLine(ne);
					}
					catch(Exception e)
					{
						insertReportLine(e);
						insertReportLine(LogStatus.FAIL, e.getClass().getName()+" Exception Occured while Setting a details of a trip on setTripDetails Method");
						return null;
					}
				}else 
				{
					insertReportLine(LogStatus.ERROR, "The no of travellers entered on the screen is not same as the the number of ages provided on the Excel sheet, separated by comma");
				
				}
				
				return null;
	}
	
	
}
