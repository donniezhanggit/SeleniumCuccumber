package safetrip.pages;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends BasePage {

	private  WebDriver homePageDriver;
	
	public HomePage(WebDriver driver)
	{		
		this.homePageDriver = driver;
		PageFactory.initElements(homePageDriver, this);
		pageName = "<b style='color:#00008B;'>"+this.getClass().getSimpleName()+"</b>";
		setBP(this);
	}
	@FindBy(xpath = "//li[@role = 'treeitem'][6]")
	public WebElement noOfTravellers_list;
	
	@FindBy(xpath = "//p[label[contains(text(),'ple are traveling?')]]/following-sibling::span/span/span/span[1]")
	public WebElement noOfTravelers_txtBox;
	
	@FindBy(xpath = "//p[label[contains(text(),'ur primary destination?')]]/following-sibling::span/span/span/span[1]")
	public WebElement primaryDestination_txtBox;
	
	@FindBy(xpath = "//input[@class = 'select2-search__field']")
	public WebElement searchDestinationCountry_txtBox;
	
	@FindBy(xpath = "//li[@role = 'treeitem' and text()='United States']")
	public WebElement destinationCountryUnitedStates_li;
	
	@FindBy(xpath = "//p[label[contains(text(),' Where are you from?')]]/following-sibling::span/span/span/span[1]")
	public WebElement residenceCountry_txtBox;
	
	@FindBy(xpath = "//input[@class = 'select2-search__field']")
	public WebElement searchResidentCountry_txtBox;
	
	@FindBy(xpath = "//li[@role = 'treeitem' and text()='United Kingdom']")
	public WebElement residnetCountry_li;
	
	@FindBy(xpath = "//ng-form[@id='profileForm']//a[text()='Next']")
	public WebElement next_Btn;
	
	@FindBy(xpath = "//ng-form[@id='profileForm']//a[text()='Previous']")
	public WebElement previous_Btn;
	
	@FindBy(xpath = "(//span[@class = 'select2-selection__clear'])[1]")
	public WebElement noOfTravelersClear_btn;
	
	@FindBy(xpath = "(//span[@class = 'select2-selection__clear'])[2]")
	public WebElement primaryDestinationClear_btn;
	
	@FindBy(xpath = "(//span[@class = 'select2-selection__clear'])[3]")
	public WebElement residenceCountryClear_btn;
	
	@FindBy(xpath = "//a[contains(@class,'btn-success')]")
	public WebElement seeYourQuote_btn;
	
//*--------------------Collect Trip Start Data and Trip Return Date-----------------*//
	
	@FindBy(name = "leaveDate")
	public WebElement tripStartDate_txtBox;
	
	@FindBy(name = "returnDate")
	public WebElement tripReturnDate_txtBox;
	
	
	
//*------------------Collecting age and State Of the Travelers--------------------*//
	
	@FindBy(xpath = "//div[@data-ng-form = 'travelersForm[1]']//input[@name = 'age']")
	public WebElement ageOne_TextBox;
	
	@FindBy(xpath = "//div[@data-ng-form = 'travelersForm[2]']//input[@name = 'age']")
	public WebElement ageTwo_TextBox;
	
	@FindBy(xpath = "//div[@data-ng-form = 'travelersForm[3]']//input[@name = 'age']")
	public WebElement ageThre_TextBox;
	
	@FindBy(xpath = "(//input[@name = 'state'])[1]")
	public WebElement stateOne_txtBox;
	
	@FindBy(xpath = "(//input[@name = 'costOfTrip'])[1]")
	public WebElement tripCancellation_txtBox;
	
	@FindBy(xpath = "//a[text() ='Finish']")
	public WebElement finish_Btn;
	
	@FindBy(xpath = "//h3[contains(text(),'dical insurance?' )]")
	public  WebElement randomPageElement;
	
	@FindBy(xpath = "//span[contains(text(),'ur travelers at departure?')]")
	public WebElement agePage_label;
	
	@FindBy(xpath = "//div[@class = 'steps-no ng-scope']/span[1]")
	public WebElement stepCounter_txt;
	
	@FindBy(xpath = "//a[contains(@class,'btn btn-success')]")
	public WebElement internalSeeYourQuote_btn;
//*-------------------Tool Tips----------------------------------------------*//
	
	@FindBy(xpath = "//label[contains(text(),'re are you from?')]//img")
	public WebElement residentCountry_tooltip;
	
	@FindBy(xpath = "//label[contains(text(),'ur primary destination?')]//img")
	public WebElement primaryDestination_tooltip;
	
	@FindBy(xpath = "//label[contains(text(),'re are you from?')]//span")
	public WebElement residentCountryTooltip_txt;
	
	@FindBy(xpath = "//label[contains(text(),'ur primary destination?')]//span")
	public WebElement primaryDestinationTooltip_txt;
	
	@FindBy(xpath = "//span[contains(text(),'es of your travelers at departure?')]/following-sibling::span/img")
	public WebElement ageInfo_tooltip;
	
	@FindBy(xpath = "//span[contains(text(),'es of your travelers at departure?')]")
	public WebElement ageInfor_txt;
	
	@FindBy(xpath = "//div[@class = 'modal-content']//a[text() = 'Continue']")
	public WebElement continueButtonOnModal_btn;
	
	@FindBy(xpath = "//div[@class = 'modal-content']//p[contains(text(),'Coverage for travelers over 70')]")
	public WebElement modalMessageForageMorethan69_txt;
	
	@FindBy(xpath = "//div[@class = 'modal-content']//p[contains(text(),'coverage for 80-85')]")
	public WebElement modalMessageForageMorethan79_txt;
	
	@FindBy(xpath = "//a[contains(@href,'producer-program')]")
	public WebElement producer_program_Link;
	//*------------------------------------Error Elements----------------------------*//
	@FindBy(xpath = "//div[@class = 'process-note']/span")
	public WebElement errorIfFieldIsMissed_txt;
	
	@FindBy(xpath = "//div[@class = 'process-note']/span[@class = 'ng-binding']" )
	public WebElement dateErrorMessage_txt;
	
	@FindBy(xpath = ".//*[contains(@data-ng-click,'submitForm')]")
	public WebElement updateButtonOnModal_btn;
	
	public WebElement noOfTravellers_li;
	
	public WebElement countryList_wbel;//destinationCountry;
	//public WebElement residentCountry;
	public WebElement agetextbox;
	
	//countryList_xpath
			//-------------------DYNAMIC XPATH----------------------//
	public String noOfTravellers_li_xpath = "//li[@role = 'treeitem'][XXX]";
	public String countryList_xpath =  	"//li[@role = 'treeitem' and text()='XXX']";
	public String ageTextBox_xpath = 	"//div[@data-ng-form = 'travelersForm[XXX]']//input[@name = 'age']";
			//-------------------DYNAMIC XPATH END----------------------//
	
	public AffiliateSignUpPage navigateToAffiliateSignUpPage()
	{
		seleniumHelper.jsClickElement(producer_program_Link); 
		//seleniumHelper.setRunTimeImplicitWait(homePageDriver, 20);
		return new AffiliateSignUpPage(homePageDriver);
	}
	
	public synchronized void validateModalWindow(String noOfTravelers, String agesSaperatedByComma, String modalMessageForAgeMoreThan69, String modalMessageForAgeMoreThan79)
	{
		String ages[]; 
		int ageInInteger = 0;
		boolean seventyFlag = false;
		boolean eightyFlag = false;
		try {
			
			if(Integer.parseInt(noOfTravelers)>1)
			{
				 ages = agesSaperatedByComma.split(",");
			}else
			{
				ages = new String[Integer.parseInt(noOfTravelers)];
				ages[0] = agesSaperatedByComma;
			}
			
			for(String age:ages)
			{
				ageInInteger = Integer.parseInt(age);
				if(ageInInteger>70 && ageInInteger<80)
				{
					seventyFlag = true;
				}
				else if(ageInInteger>79 && ageInInteger<86)
				{
					eightyFlag = true;
				}
			}
			
			if(seventyFlag && eightyFlag)
			{
				seleniumHelper.validateElementText(modalMessageForageMorethan69_txt, modalMessageForAgeMoreThan69);
				seleniumHelper.validateElementText(modalMessageForageMorethan79_txt, modalMessageForAgeMoreThan79);
			}
			if(seventyFlag && !eightyFlag)
			{
				seleniumHelper.validateElementText(modalMessageForageMorethan69_txt, modalMessageForAgeMoreThan69);
			}
			if(seventyFlag && !eightyFlag)
			{
				seleniumHelper.validateElementText(modalMessageForageMorethan79_txt, modalMessageForAgeMoreThan79);
			}
			
		}catch(Exception e)
		{
			insertReportLine(e);
		}
	}
	
	
	public synchronized void validateAgeErrorMessages(String noOfTravelers,String destinationCountryName, String residenceCountryName, String startDate, String returnDate, String errorReturnDateInPast, String errorRetDatePriorToDepDate, String errordepartureDateEqualToCurrentDate, String depDateGreaterThan365Days, String depDateGreaterThan90Days)
	{
		try {
			
			seleniumHelper.clickElement(noOfTravelers_txtBox);
			noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
			seleniumHelper.clickElement(noOfTravellers_li);
			seleniumHelper.clickElement(primaryDestination_txtBox);
			countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
			seleniumHelper.clickElement(countryList_wbel);
			seleniumHelper.clickElement(residenceCountry_txtBox);
			countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",residenceCountryName ) );
			seleniumHelper.clickElement(countryList_wbel);
			
			seleniumHelper.clickElement(next_Btn);
			String pastDate =getBirthDate(0);
			seleniumHelper.clickElement(tripStartDate_txtBox);
			tripStartDate_txtBox.clear();
			//tripStartDate_txtBox.sendKeys(pastDate);
			JavascriptExecutor jse = (JavascriptExecutor)currentDriver;
			jse.executeScript("arguments[0].value='"+pastDate+"';", tripStartDate_txtBox);
			tripStartDate_txtBox.sendKeys("2");
			tripStartDate_txtBox.sendKeys(Keys.BACK_SPACE);
			//seleniumHelper.enterValueIntoTextField(tripStartDate_txtBox, pastDate);
			//tripStartDate_txtBox.sendKeys(Keys.RETURN);
			
			seleniumHelper.clickElement(tripReturnDate_txtBox);
			selectDateFromCalender(returnDate, homePageDriver);
			System.out.println(dateErrorMessage_txt.getText());//-----"Hey there, time traveler. Your departure date is in the past. Please let us know about your future plans!"
			
			seleniumHelper.clickElement(tripStartDate_txtBox);
			selectDateFromCalender(returnDate, homePageDriver);
			
			tripReturnDate_txtBox.clear();
			tripReturnDate_txtBox.sendKeys(Keys.TAB);
			//seleniumHelper.clickElement(tripReturnDate_txtBox);
			
			System.out.println("sf");
			//tripReturnDate_txtBox.sendKeys(startDate);
			//JavascriptExecutor jse1 = (JavascriptExecutor)currentDriver;
			jse.executeScript("arguments[0].value='"+startDate+"';", tripReturnDate_txtBox);
			tripReturnDate_txtBox.sendKeys("2");
			//Thread.sleep(2000);
			tripReturnDate_txtBox.sendKeys(Keys.BACK_SPACE);
			//Thread.sleep(2000);
			tripReturnDate_txtBox.sendKeys(Keys.TAB);
			//selectDateFromCalender(startDate, homePageDriver);
			System.out.println(" "+dateErrorMessage_txt.getText());//We love your creativity but we need month first, then date. Thanks!
			
			
			seleniumHelper.clickElement(tripStartDate_txtBox);
			selectDateFromCalender(startDate, homePageDriver);
			
			seleniumHelper.clickElement(tripReturnDate_txtBox);
			selectDateFromCalender(startDate, homePageDriver);
			tripReturnDate_txtBox.sendKeys(Keys.TAB);
			//System.out.println(dateErrorMessage_txt.getText());
			
			//********************Validation Of the Error message for OutBound and tripDuration>365 days**************//
			
			seleniumHelper.clickElement(previous_Btn);
			
			seleniumHelper.clickElement(primaryDestination_txtBox);
			countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX","India"));
			seleniumHelper.clickElement(countryList_wbel);
			
			seleniumHelper.clickElement(residenceCountry_txtBox);
			countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX","United States" ) );
			seleniumHelper.clickElement(countryList_wbel);
			
			
			seleniumHelper.clickElement(next_Btn);
			
			returnDate = addDaysToADate(startDate,  "MM/dd/yyyy", 365);
			
			seleniumHelper.clickElement(tripStartDate_txtBox);
			selectDateFromCalender(startDate, homePageDriver);
			
			seleniumHelper.clickElement(tripReturnDate_txtBox);
			selectDateFromCalender(returnDate, homePageDriver);
			 
			System.out.println(dateErrorMessage_txt.getText());//Unfortunately, we don’t provide coverage for more than 364 days. Please review your date, thanks.
			
			
			//********************Validation Of the Error message for InBound and tripDuration>90 days**************//
			seleniumHelper.clickElement(previous_Btn);
			
			seleniumHelper.clickElement(residenceCountry_txtBox);
			countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX","United Kingdom" ));
			seleniumHelper.clickElement(countryList_wbel);
			
		
			seleniumHelper.clickElement(primaryDestination_txtBox);
			countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX","United States"));
			seleniumHelper.clickElement(countryList_wbel);
			
			seleniumHelper.clickElement(next_Btn);
//			seleniumHelper.clickElement(residenceCountryClear_btn);
			//residenceCountry_txtBox.sendKeys(Keys.TAB);
			
			
			returnDate = addDaysToADate(startDate,  "MM/dd/yyyy", 90);
			
			seleniumHelper.clickElement(tripStartDate_txtBox);
			selectDateFromCalender(startDate, homePageDriver);
			
			seleniumHelper.clickElement(tripReturnDate_txtBox);
			selectDateFromCalender(returnDate, homePageDriver);
			
			 
			System.out.println(dateErrorMessage_txt.getText());//Unfortunately, we don't provide coverage for more than 90 days if you're departing from outside the US. Please rethink your dates, thanks.
			seleniumHelper.clickElement(previous_Btn);
			
			//selectDateFromCalender(startDate, homePageDriver);
			
//			seleniumHelper.clickElement(tripReturnDate_txtBox);
//			selectDateFromCalender(returnDate, homePageDriver);
//			
//			
//			if(new Date(startDate).compareTo(new Date())<=0)
//			{
//				insertReportLine(LogStatus.FAIL, "Start Date Provided in the sheet  is either a current date or a past date, which is not acceptable ");
//				Assert.assertTrue(false, "Start Date Provided in the sheet  is either a current date or a past date, which is not acceptable ");
//			}
//			else if(residenceCountryName.equalsIgnoreCase("United States") && getDateDifff(startDate, returnDate)>364)
//			{
//					insertReportLine(LogStatus.FAIL, "The tripduration(StartDate - EndDate) is more than 364 days in the sheet, For OutBound Trip the maximum trip duration is 364 days");
//					Assert.assertTrue(false, "(StartDate - EndDate)>364 days in the test data sheet ");
//				
//			}else if(!residenceCountryName.equalsIgnoreCase("United States") && getDateDifff(startDate, returnDate)>90)
//			{
//				
//					insertReportLine(LogStatus.FAIL, "The tripduration(StartDate - EndDate) is more than 90 days in the sheet, For Inbound/Transnational Trip the maximum trip duration is 90 days");
//					Assert.assertTrue(false, "(StartDate - EndDate)>90 days in the test data sheet ");
//				
//			}
//			
			
			
			
			
		}catch(Exception e)
		{
			insertReportLine(e);
		}
	}
	
	public synchronized SafetripComparisonPage setQuoteDetailsInOnePage(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String state, String tripCancellationAmount)
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
				//String ages[]  = agesSaperatedByComma.split(",");
				System.out.println(ages.length);
				
				if(ages.length == Integer.parseInt(noOfTravelers))
				{
					try {
						seleniumHelper.clickElement(noOfTravelers_txtBox);
						
						//Thread.sleep(4000);
						
						noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
						seleniumHelper.clickElement(noOfTravellers_li);
						seleniumHelper.clickElement(primaryDestination_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
						seleniumHelper.clickElement(countryList_wbel);
						seleniumHelper.clickElement(residenceCountry_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",residenceCountryName ) );
						seleniumHelper.clickElement(countryList_wbel);
						
						
						if(new Date(startDate).compareTo(new Date())<=0)
						{
							insertReportLine(LogStatus.FAIL, "Start Date Provided in the sheet  is either a current date or a past date, which is not acceptable ");
							Assert.assertTrue(false, "Start Date Provided in the sheet  is either a current date or a past date, which is not acceptable ");
						}
						else if(residenceCountryName.equalsIgnoreCase("United States") && getDateDifff(startDate, returnDate)>364)
						{
								insertReportLine(LogStatus.FAIL, "The tripduration(StartDate - EndDate) is more than 364 days in the sheet, For OutBound Trip the maximum trip duration is 364 days");
								Assert.assertTrue(false, "(StartDate - EndDate)>364 days in the test data sheet ");
							
						}else if(!residenceCountryName.equalsIgnoreCase("United States") && getDateDifff(startDate, returnDate)>90)
						{
							
								insertReportLine(LogStatus.FAIL, "The tripduration(StartDate - EndDate) is more than 90 days in the sheet, For Inbound/Transnational Trip the maximum trip duration is 90 days");
								Assert.assertTrue(false, "(StartDate - EndDate)>90 days in the test data sheet ");
							
						}
						
						seleniumHelper.clickElement(tripStartDate_txtBox);
						selectDateFromCalender(startDate, homePageDriver);
						
						seleniumHelper.clickElement(tripReturnDate_txtBox);
						selectDateFromCalender(returnDate, homePageDriver);
						
						
						
						if(residenceCountryName.trim().equals("United States"))
						{
							for(int i =0; i<=ages.length-1; i++)
							{
								
								agetextbox = seleniumHelper.findElementByXpath(homePageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
								seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
								if(i==0)
									seleniumHelper.enterValueIntoTextField(stateOne_txtBox, state);
							}
						}else
						{
							for(int i =0; i<=ages.length-1; i++)
							{
								agetextbox = seleniumHelper.findElementByXpath(homePageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
								seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
							}
						}
						
						if(getDaysDifffromCurrentdate(startDate)>=10 && residenceCountryName.equals("United States"))
						{
							
							seleniumHelper.enterValueIntoTextField(tripCancellation_txtBox, tripCancellationAmount);
							
							seleniumHelper.clickElement(seeYourQuote_btn);
							//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						}
						
						
						for(String s:ages) 
						{
							if(Integer.parseInt(s.trim())>69) 
							{
							seleniumHelper.clickElement(continueButtonOnModal_btn);
							break;
							}
						}
						
						//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						return new SafetripComparisonPage(homePageDriver);
					}
					catch(Exception e)
					{
						insertReportLine(e);
						e.printStackTrace();
						insertReportLine(LogStatus.FAIL, e.getClass().getName()+" Exception Occured while Setting a details of a trip on setTripDetails Method");
						return null;
					}
				}else 
				{
					insertReportLine(LogStatus.ERROR, "The no of travellers entered on the screen is not same as the the number of ages provided on the Excel sheet, separated by comma");
				
				}
				
				return null;
	}
	public SafetripComparisonPage modifyTripDetailsForReviewCartPage(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String state, String tripCancellationAmount )
	{
				String ages[]  = agesSaperatedByComma.split(",");
				
				
				if(ages.length == Integer.parseInt(noOfTravelers))
				{
					try {
						seleniumHelper.clickElement(noOfTravelers_txtBox);
						
						Thread.sleep(4000);
						noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver, "//li[@role = 'treeitem']["+noOfTravelers+"]");
						
						
						seleniumHelper.clickElement(noOfTravellers_li);
						
						seleniumHelper.clickElement(primaryDestination_txtBox);
						 countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver, "//li[@role = 'treeitem' and text()='"+destinationCountryName+"']");
						seleniumHelper.clickElement(countryList_wbel);
						
						seleniumHelper.clickElement(residenceCountry_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver, "//li[@role = 'treeitem' and text()='"+residenceCountryName+"']");
						seleniumHelper.clickElement(countryList_wbel);					
						
						seleniumHelper.clickElement(tripStartDate_txtBox);
						selectDateFromCalender(startDate, homePageDriver);
						
						seleniumHelper.clickElement(tripReturnDate_txtBox);
						selectDateFromCalender(returnDate, homePageDriver);
						
						
						
						if(residenceCountryName.trim().equals("United States"))
						{
							for(int i =0; i<=ages.length-1; i++)
							{
								agetextbox = seleniumHelper.findElementByXpath(homePageDriver, "//div[@data-ng-form = 'travelersForm["+Integer.toString(i+1)+"]']//input[@name = 'age']");
								seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
								if(i==0)
									seleniumHelper.enterValueIntoTextField(stateOne_txtBox, state);
							}
						}else
						{
							for(int i =0; i<=ages.length-1; i++)
							{
								agetextbox = seleniumHelper.findElementByXpath(homePageDriver, "//div[@data-ng-form = 'travelersForm["+Integer.toString(i+1)+"]']//input[@name = 'age']");
								seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
							}
						}
						
						if(getDaysDifffromCurrentdate(startDate)>=10 && residenceCountryName.equals("United States"))
						{
							
							seleniumHelper.enterValueIntoTextField(tripCancellation_txtBox, tripCancellationAmount);
								
						}
						
						seleniumHelper.clickElement(updateButtonOnModal_btn);
											
						for(String s:ages) 
						{
							if(Integer.parseInt(s.trim())>69) 
							{
							seleniumHelper.clickElement(continueButtonOnModal_btn);
							break;
							}
						}
										
						
						return new SafetripComparisonPage(homePageDriver);
					}catch(Exception e)
					{
						insertReportLine(LogStatus.FAIL, e.getClass().getName()+" Exception Occured while Setting a details of a trip on setTripDetails Method");
						return null;
					}
				}else 
				{
					insertReportLine(LogStatus.ERROR, "The no of travellers entered on the screen is not same as the the number of ages provided on the Excel sheet, separated by comma");
				
				}
				
				return null;
	}
	public synchronized SafetripComparisonPage setTripDetails(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String state, String tripCancellationAmount )
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
				//String ages[]  = agesSaperatedByComma.split(",");
				//System.out.println(ages.length);
				
				if(ages.length == Integer.parseInt(noOfTravelers))
				{
					try {
						
//						for(int i = 0; i<3; i++)
//						{
//							
//							try {
//								if(i==0){
//									noOfTravelersClear_btn.click();
//								}
//								else if(i==1)
//								{
//									primaryDestinationClear_btn.click();
//								}else if(i==2)
//								{
//									residenceCountryClear_btn.click();
//								}
//							
//							}catch(Exception ne)
//								{
//									//System.out.println(ne.getClass().getName());
//								}
//						}
						
						
						
						//Thread.sleep(4000);
						seleniumHelper.clickElement(noOfTravelers_txtBox);
						
						noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
						seleniumHelper.clickElement(noOfTravellers_li);
						seleniumHelper.clickElement(primaryDestination_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
						seleniumHelper.clickElement(countryList_wbel);
						seleniumHelper.clickElement(residenceCountry_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",residenceCountryName ) );
						seleniumHelper.clickElement(countryList_wbel);
					
						if(!appURL.toString().contains("uhcsafetrip.uhc.com"))
						{
						seleniumHelper.clickElement(next_Btn);
						//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						}
						System.out.println(new Date());
						System.out.println(new Date(startDate));
					System.out.println(new Date(startDate).compareTo(new Date()));	
						
					if(new Date(startDate).compareTo(new Date())<=0)
						{
							insertReportLine(LogStatus.FAIL, "Start Date Provided in the sheet  is either a current date or a past date, which is not acceptable ");
							Assert.assertTrue(false, "Start Date Provided in the sheet  is either a current date or a past date, which is not acceptable ");
						}
						else if(residenceCountryName.equalsIgnoreCase("United States") && getDateDifff(startDate, returnDate)>364)
						{
								insertReportLine(LogStatus.FAIL, "The tripduration(StartDate - EndDate) is more than 364 days in the sheet, For OutBound Trip the maximum trip duration is 364 days");
								Assert.assertTrue(false, "(StartDate - EndDate)>364 days in the test data sheet ");
							
						}else if(!residenceCountryName.equalsIgnoreCase("United States") && getDateDifff(startDate, returnDate)>90)
						{
							
								insertReportLine(LogStatus.FAIL, "The tripduration(StartDate - EndDate) is more than 90 days in the sheet, For Inbound/Transnational Trip the maximum trip duration is 90 days");
								Assert.assertTrue(false, "(StartDate - EndDate)>90 days in the test data sheet ");
							
						}
						
						seleniumHelper.clickElement(tripStartDate_txtBox);
						selectDateFromCalender(startDate, homePageDriver);
						
						seleniumHelper.clickElement(tripReturnDate_txtBox);
						selectDateFromCalender(returnDate, homePageDriver);
						
						if(!appURL.toString().contains("uhcsafetrip.uhc.com"))
						{
						seleniumHelper.waitForAobjectToBeVisible(next_Btn,homePageDriver);
						seleniumHelper.clickElement(next_Btn);
						//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						}
						
						if(residenceCountryName.trim().equals("United States"))
						{
							for(int i =0; i<=ages.length-1; i++)
							{
								
								agetextbox = seleniumHelper.findElementByXpath(homePageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
								seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
								if(i==0)
									seleniumHelper.enterValueIntoTextField(stateOne_txtBox, state);
							}
						}else
						{
							for(int i =0; i<=ages.length-1; i++)
							{
								agetextbox = seleniumHelper.findElementByXpath(homePageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
								seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
							}
						}
						
						if(getDaysDifffromCurrentdate(startDate)>=10 && residenceCountryName.equals("United States"))
						{
							if(!appURL.toString().contains("uhcsafetrip.uhc.com"))
							{
							seleniumHelper.clickElement(next_Btn);
							//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
							}
							seleniumHelper.enterValueIntoTextField(tripCancellation_txtBox, tripCancellationAmount);
							
							if(!appURL.toString().contains("uhcsafetrip.uhc.com"))
							{
								
							seleniumHelper.clickElement(finish_Btn);
							}else
							{
								seleniumHelper.clickElement(internalSeeYourQuote_btn);
							}
							//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						}
						else
						{
							if(!appURL.toString().contains("uhcsafetrip.uhc.com"))
							{
								
								////a[text() = 'See your quote']
							seleniumHelper.clickElement(finish_Btn);
							}else
							{
								seleniumHelper.clickElement(internalSeeYourQuote_btn);
							}
							
							//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						}
						
						for(String s:ages) 
						{
							if(Integer.parseInt(s.trim())>69) 
							{
							seleniumHelper.clickElement(continueButtonOnModal_btn);
							break;
							}
						}
						
						//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						return new SafetripComparisonPage(homePageDriver);
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
	

	
	
	public synchronized SafetripComparisonPage setinBoundTravel(String noOfTravelers,String destinationCountryName, String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma)
	
	{	
		String ages[]  = agesSaperatedByComma.split(",");
		if(ages.length == Integer.parseInt(noOfTravelers))
		{
			try {
					
				seleniumHelper.clickElement(noOfTravelers_txtBox);
				noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
				seleniumHelper.clickElement(noOfTravellers_li);
				
				seleniumHelper.clickElement(primaryDestination_txtBox);
				countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
				seleniumHelper.clickElement(countryList_wbel);
				
				seleniumHelper.clickElement(residenceCountry_txtBox);
				countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",residenceCountryName ) );
				seleniumHelper.clickElement(countryList_wbel);
				
				seleniumHelper.clickElement(next_Btn);
				//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
				
				seleniumHelper.clickElement(tripStartDate_txtBox);
				selectDateFromCalender(startDate, homePageDriver);

				seleniumHelper.clickElement(tripReturnDate_txtBox);
				selectDateFromCalender(returnDate, homePageDriver);
				
				seleniumHelper.clickElement(next_Btn);
				
				
				for(int i =0; i<=ages.length-1; i++)
				{
					agetextbox = seleniumHelper.findElementByXpath(homePageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
					seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
				}
				
				seleniumHelper.clickElement(finish_Btn);
				
			//	//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
				
				return new SafetripComparisonPage(homePageDriver);
			}catch(Exception E)
			{
				//setExceptionLog(E);
				insertReportLine(E);
				System.out.println("Exception Occured"+E.getMessage());
				return null;
			}
		}else 
		{
			System.out.println("The no of travellers entered on the screen is not same as the the number of ages provided on the Excel sheet, separated by comma");
		}
		
		return null;
		
		
	}
	
	public void verifyHomePageTooltipsForInboundTrip(String noOfTravelers,String destinationCountryName,String residenceCountryName,
													String primaryDestinationTooltip, String residentCountryTooltip, 
													String startDate, String returnDate, String ageTooltipText, String agesSaperatedByComma)
	{
		String ages[]  = agesSaperatedByComma.split(",");
//		System.out.println(ages.length);
//		for(String a:ages) {System.out.println(a);}
		if(ages.length == Integer.parseInt(noOfTravelers))
		{
			try {
				
				Thread.sleep(5000);
				seleniumHelper.scrollDown(homePageDriver, 100);
				seleniumHelper.clickElement(noOfTravelers_txtBox);
				noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
				seleniumHelper.clickElement(noOfTravellers_li);
				
				seleniumHelper.clickElement(primaryDestination_txtBox);
				countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
				seleniumHelper.clickElement(countryList_wbel);
				
				seleniumHelper.clickElement(residenceCountry_txtBox);
				countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",residenceCountryName ) );
				seleniumHelper.clickElement(countryList_wbel);
				//*--------------Tool tip verification for destination country and Home country------------------------*//
				
				seleniumHelper.mouseOver(residentCountry_tooltip);
				seleniumHelper.validateElementAttribute(residentCountryTooltip_txt, "data-original-title", residentCountryTooltip);
				
				seleniumHelper.mouseOver(primaryDestination_tooltip);
				seleniumHelper.validateElementAttribute(primaryDestinationTooltip_txt, "data-original-title", primaryDestinationTooltip);
				
				
				seleniumHelper.clickElement(next_Btn);
				//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
				
				tripStartDate_txtBox.click();
				selectDateFromCalender(startDate, homePageDriver);
				
				tripReturnDate_txtBox.click();
				selectDateFromCalender(returnDate, homePageDriver);
				
				//seleniumHelper.enterValueIntoTextField(tripStartDate_txtBox, startDate);
				
				//seleniumHelper.enterValueIntoTextField(tripReturnDate_txtBox, returnDate);
				seleniumHelper.clickElement(next_Btn);
				//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
				//*--------------------- tool tip verification of age -------------------------*//
				//seleniumHelper.mouseOver(ageInfo_tooltip);
				seleniumHelper.validateElementText(ageInfor_txt, ageTooltipText);
				
				
				for(int i =0; i<=ages.length-1; i++)
				{
					agetextbox = seleniumHelper.findElementByXpath(homePageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
					seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
				}
				
				//seleniumHelper.clickElement(finish_Btn);
				
				//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
				
				
			}catch(Exception E)
			{
				insertReportLine(E);
				System.out.println("Exception Occured"+E.getMessage());
				
			}
		}else 
		{
			System.out.println("The no of travellers entered on the screen is not same as the the number of ages provided on the Excel sheet, separated by comma");
		}
		
		
	}
	
	public void selectAgeFromCalender(String noOfTravelers,String destinationCountryName, String residenceCountryName, String startDate, String returnDate, String agePageLabeltext) 
	{
				
			try {
				
				Thread.sleep(5000);
				seleniumHelper.scrollDown(homePageDriver, 100);
				seleniumHelper.clickElement(noOfTravelers_txtBox);
				noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
				seleniumHelper.clickElement(noOfTravellers_li);
				
				seleniumHelper.clickElement(primaryDestination_txtBox);
				countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
				seleniumHelper.clickElement(countryList_wbel);
				
				seleniumHelper.clickElement(residenceCountry_txtBox);
				countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",residenceCountryName ) );
				seleniumHelper.clickElement(countryList_wbel);
				seleniumHelper.clickElement(next_Btn);
				//*-------------------------------date picked from calender-------------------------*//
				
				seleniumHelper.clickElement(tripStartDate_txtBox);
				selectDateFromCalender(startDate, homePageDriver);
				insertReportLine(LogStatus.PASS, "The startDate should be picked from calender", "The startDate is picked from the calende");
				
				seleniumHelper.clickElement(tripReturnDate_txtBox);
				selectDateFromCalender(returnDate, homePageDriver);
				insertReportLine(LogStatus.PASS, "The returnDate should be picked from calender", "The returnDate is picked from the calende");
				
				seleniumHelper.clickElement(next_Btn);
				//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
				
				seleniumHelper.validateElementText(agePage_label, agePageLabeltext);
				
			} catch(Exception e)
			{
				insertReportLine(e);
			}
			}
	
	public void verifyInboundStepCounter(String noOfTravelers,String destinationCountryName, String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma)
	{
		String ages[]  = agesSaperatedByComma.split(",");
		System.out.println(ages.length);
		//for(String a:ages) {System.out.println(a);}
		int counter = 0;
		if(ages.length == Integer.parseInt(noOfTravelers))
		{
			try {
				
				Thread.sleep(5000);
				seleniumHelper.scrollDown(homePageDriver, 100);
				seleniumHelper.validateElementText(stepCounter_txt, Integer.toString(++counter));
				
				seleniumHelper.clickElement(noOfTravelers_txtBox);
				noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
				seleniumHelper.clickElement(noOfTravellers_li);
				
				seleniumHelper.clickElement(primaryDestination_txtBox);
				countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
				seleniumHelper.clickElement(countryList_wbel);
				
				seleniumHelper.clickElement(residenceCountry_txtBox);
				countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",residenceCountryName ) );
				seleniumHelper.clickElement(countryList_wbel);
				
				seleniumHelper.clickElement(next_Btn);
				//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
				seleniumHelper.validateElementText(stepCounter_txt, Integer.toString(++counter));
				
				tripStartDate_txtBox.click();
				selectDateFromCalender(startDate, homePageDriver);
				
				tripReturnDate_txtBox.click();
				selectDateFromCalender(returnDate, homePageDriver);
				
//				seleniumHelper.enterValueIntoTextField(tripStartDate_txtBox, startDate);
//				tripStartDate_txtBox.clear();
//				tripStartDate_txtBox.sendKeys(startDate);
//				seleniumHelper.enterValueIntoTextField(tripReturnDate_txtBox, returnDate);
//				tripReturnDate_txtBox.clear();
//				tripReturnDate_txtBox.sendKeys(returnDate);
				////seleniumHelper.clickElement(randomPageElement);
				seleniumHelper.clickElement(next_Btn);
				//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
				seleniumHelper.validateElementText(stepCounter_txt, Integer.toString(++counter));
				
				for(int i =0; i<=ages.length-1; i++)
				{
					agetextbox = seleniumHelper.findElementByXpath(homePageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
					seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
				}
				
			}catch(Exception e)
			{
				insertReportLine(e);	
			}
			}
	}
	
	public void verifyErrorMessages(String noOfTravelers,String destinationCountryName, String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String textToBeValidated)
	{
		String ages[]  = agesSaperatedByComma.split(",");
		System.out.println(ages.length);
		if(ages.length == Integer.parseInt(noOfTravelers))
		{
			try {
				
				Thread.sleep(5000);
				seleniumHelper.scrollDown(homePageDriver, 100);
				
				for(int i = 1; i<=4; i++)
				{
					if(i!=1) {
					for(int j =1;j<=2;j++) {
						
						try {
						WebElement ele = homePageDriver.findElement(By.xpath("(//span[@class = 'select2-selection__clear'])[1]"));
						
						
						ele.click();
						
						
						Thread.sleep(1000);
						}catch(Exception e) {
							insertReportLine(e);
							System.out.println("Exception Occured"+e.getClass().getName());
							break;
						}
					}
					}
					
					switch(i)
					{
					case 1:
					{
						seleniumHelper.clickElement(primaryDestination_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
						seleniumHelper.clickElement(countryList_wbel);
						
						seleniumHelper.clickElement(residenceCountry_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",residenceCountryName ) );
						seleniumHelper.clickElement(countryList_wbel);
						
						seleniumHelper.clickElement(next_Btn);
						
						if(errorIfFieldIsMissed_txt.isDisplayed() && errorIfFieldIsMissed_txt.isEnabled() )
						{
							insertReportLine(LogStatus.PASS, "The Error Message should be displayed if <No of Travellers> field is blank"," Error Message is displayed when <No Of travellers> is blank");
							seleniumHelper.validateElementText(errorIfFieldIsMissed_txt, textToBeValidated);
						}else
						{
							insertReportLine(LogStatus.FAIL, "The Error Message should be displayed if <No of Travellers> field is blank","No Error Message is displayed when <No Of travellers> is blank");
						}
						
						break;
					}
					
					case 2:
					{
						seleniumHelper.clickElement(noOfTravelers_txtBox);
						noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
						seleniumHelper.clickElement(noOfTravellers_li);
						
						seleniumHelper.clickElement(seleniumHelper.findElementByXpath(homePageDriver, "(//span[contains(@class,'selection__clear')])[1]"));
						seleniumHelper.clickElement(primaryDestination_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
						seleniumHelper.clickElement(countryList_wbel);
						
						seleniumHelper.clickElement(residenceCountry_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",residenceCountryName ) );
						seleniumHelper.clickElement(countryList_wbel);
						
						seleniumHelper.clickElement(next_Btn);
						
						if(errorIfFieldIsMissed_txt.isDisplayed() && errorIfFieldIsMissed_txt.isEnabled() )
						{
							
							insertReportLine(LogStatus.PASS, "The Error Message should be displayed if <Primary Destination> field is blank"," Error Message is displayed when <Primary Destination> is blank");
							seleniumHelper.validateElementText(errorIfFieldIsMissed_txt, textToBeValidated);
						}else
						{
							insertReportLine(LogStatus.FAIL, "The Error Message should be displayed if <Primary Destination> field is blank","No Error Message is displayed when <Primary Destination> is blank");
						}
						
						break;

					}
					case 3:
					{
						seleniumHelper.clickElement(noOfTravelers_txtBox);
						noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
						seleniumHelper.clickElement(noOfTravellers_li);
						
						seleniumHelper.clickElement(primaryDestination_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
						seleniumHelper.clickElement(countryList_wbel);

						seleniumHelper.clickElement(next_Btn);
						
						if(errorIfFieldIsMissed_txt.isDisplayed() && errorIfFieldIsMissed_txt.isEnabled() )
						{
							
							insertReportLine(LogStatus.PASS, "The Error Message should be displayed if <Where Are You From?> field is blank"," Error Message is displayed when <Where Are You From?> is blank");
							seleniumHelper.validateElementText(errorIfFieldIsMissed_txt, textToBeValidated);
						}else
						{
							insertReportLine(LogStatus.FAIL, "The Error Message should be displayed if <Where Are You From?> field is blank","No Error Message is displayed when <Where Are You From?> is blank");
						}
						
						break;

					}
					case 4:
					{
						seleniumHelper.clickElement(noOfTravelers_txtBox);
						seleniumHelper.clickElement(noOfTravelers_txtBox);
						noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
						seleniumHelper.clickElement(noOfTravellers_li);
						
						seleniumHelper.clickElement(primaryDestination_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
						seleniumHelper.clickElement(countryList_wbel);
						
						seleniumHelper.clickElement(residenceCountry_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",residenceCountryName ) );
						seleniumHelper.clickElement(countryList_wbel);
						
						seleniumHelper.clickElement(next_Btn);
									
						break;

					}
				}
				}
								
				//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
				
				for(int i = 1; i<=3;i++) 
				{
					tripStartDate_txtBox.clear();
					tripReturnDate_txtBox.clear();
					switch(i)
					{
						case 1:
						{
							tripStartDate_txtBox.click();
							selectDateFromCalender(startDate, homePageDriver);
							seleniumHelper.clickElement(next_Btn);

							if(errorIfFieldIsMissed_txt.isDisplayed() && errorIfFieldIsMissed_txt.isEnabled() )
							{
								
								insertReportLine(LogStatus.PASS, "The Error Message should be displayed if <Start Date?> field is blank"," Error Message is displayed when <Start Date> is blank");
								seleniumHelper.validateElementText(errorIfFieldIsMissed_txt, textToBeValidated);
							}else
							{
								insertReportLine(LogStatus.FAIL, "The Error Message should be displayed if <Start Date> field is blank","No Error Message is displayed when <Start Date> is blank");
							}
							break;
							
						}
						case 2:
						{
							tripReturnDate_txtBox.click();
							selectDateFromCalender(returnDate, homePageDriver);
							seleniumHelper.clickElement(next_Btn);
							
							if(errorIfFieldIsMissed_txt.isDisplayed() && errorIfFieldIsMissed_txt.isEnabled() )
							{
								
								insertReportLine(LogStatus.PASS, "The Error Message should be displayed if <Return Date?> field is blank"," Error Message is displayed when <Return Date> is blank");
								seleniumHelper.validateElementText(errorIfFieldIsMissed_txt, textToBeValidated);
							}else
							{
								insertReportLine(LogStatus.FAIL, "The Error Message should be displayed if <Return Date> field is blank","No Error Message is displayed when <Return Date> is blank");
							}
							break;
						}
						case 3:
						{
							tripStartDate_txtBox.click();
							selectDateFromCalender(startDate, homePageDriver);
							
							tripReturnDate_txtBox.click();
							selectDateFromCalender(returnDate, homePageDriver);
							seleniumHelper.clickElement(next_Btn);
							break;
						}
					}
					
				}

				//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
				
				for(int i =0; i<=ages.length-1; i++)
				{
					agetextbox = seleniumHelper.findElementByXpath(homePageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
					seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
				}
				
			}catch(Exception e)
			{
				insertReportLine(e);
			e.getMessage();	
			}
			}
	}
	
	
	public SafetripComparisonPage setOutBoundTravel(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String state, String tripCancellationAmount )
	{
		//bp = this;
				String ages[]  = agesSaperatedByComma.split(",");
				System.out.println(ages.length);
				//for(String a:ages) {System.out.println(a);}
				if(ages.length == Integer.parseInt(noOfTravelers))
				{
					try {
//						seleniumHelper.scrollDown(homePageDriver, 100);
						//Thread.sleep(5000);
						
//						seleniumHelper.getObjectName(homePageDriver);
						
						seleniumHelper.clickElement(noOfTravelers_txtBox);
						noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
						seleniumHelper.clickElement(noOfTravellers_li);
						
						seleniumHelper.clickElement(primaryDestination_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
						seleniumHelper.clickElement(countryList_wbel);
						
						seleniumHelper.clickElement(residenceCountry_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",residenceCountryName ) );
						seleniumHelper.clickElement(countryList_wbel);
						
						seleniumHelper.clickElement(next_Btn);
						//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						
						seleniumHelper.clickElement(tripStartDate_txtBox);
						selectDateFromCalender(startDate, homePageDriver);
						
						seleniumHelper.clickElement(tripReturnDate_txtBox);
						selectDateFromCalender(returnDate, homePageDriver);
						
//						seleniumHelper.enterValueIntoTextField(tripStartDate_txtBox, startDate);
//						tripStartDate_txtBox.clear();
//						tripStartDate_txtBox.sendKeys(startDate);
//						seleniumHelper.enterValueIntoTextField(tripReturnDate_txtBox, returnDate);
//						tripReturnDate_txtBox.clear();
//						tripReturnDate_txtBox.sendKeys(returnDate);
						////seleniumHelper.clickElement(randomPageElement);
						seleniumHelper.waitForAobjectToBeVisible( next_Btn,homePageDriver);
						
						seleniumHelper.clickElement(next_Btn);
						//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						
						for(int i =0; i<=ages.length-1; i++)
						{
							agetextbox = seleniumHelper.findElementByXpath(homePageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
							seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
							if(i==0)
								seleniumHelper.enterValueIntoTextField(stateOne_txtBox, state);
						}
						
						seleniumHelper.clickElement(next_Btn);
						//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						seleniumHelper.enterValueIntoTextField(tripCancellation_txtBox, tripCancellationAmount);
						
						seleniumHelper.clickElement(finish_Btn);
						
						//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						
						return new SafetripComparisonPage(homePageDriver);
					}catch(Exception E)
					{
						insertReportLine(E);
						System.out.println("Exception Occured"+E.getMessage());
						return null;
					}
				}else 
				{
					insertReportLine(LogStatus.ERROR, "The no of travellers entered on the screen is not same as the the number of ages provided on the Excel sheet, separated by comma");
					System.out.println("The no of travellers entered on the screen is not same as the the number of ages provided on the Excel sheet, separated by comma");
				}
				
				return null;
	}
	
	
	
	
	
	
	public synchronized SafetripComparisonPage setInternalTripDetails(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String state, String tripCancellationAmount )
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
				//String ages[]  = agesSaperatedByComma.split(",");
				//System.out.println(ages.length);
				
				if(ages.length == Integer.parseInt(noOfTravelers))
				{
					try {
						
//						for(int i = 0; i<3; i++)
//						{
//							
//							try {
//								if(i==0){
//									noOfTravelersClear_btn.click();
//								}
//								else if(i==1)
//								{
//									primaryDestinationClear_btn.click();
//								}else if(i==2)
//								{
//									residenceCountryClear_btn.click();
//								}
//							
//							}catch(Exception ne)
//								{
//									//System.out.println(ne.getClass().getName());
//								}
//						}
						
						
						
						//Thread.sleep(4000);
						seleniumHelper.clickElement(noOfTravelers_txtBox);
						
						noOfTravellers_li = seleniumHelper.findElementByXpath(homePageDriver,noOfTravellers_li_xpath.replace("XXX",noOfTravelers ));
						seleniumHelper.clickElement(noOfTravellers_li);
						seleniumHelper.clickElement(primaryDestination_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",destinationCountryName));
						seleniumHelper.clickElement(countryList_wbel);
						seleniumHelper.clickElement(residenceCountry_txtBox);
						countryList_wbel = seleniumHelper.findElementByXpath(homePageDriver,countryList_xpath.replace("XXX",residenceCountryName ) );
						seleniumHelper.clickElement(countryList_wbel);
					
						System.out.println(new Date());
						System.out.println(new Date(startDate));
					System.out.println(new Date(startDate).compareTo(new Date()));	
						
					if(new Date(startDate).compareTo(new Date())<=0)
						{
							insertReportLine(LogStatus.FAIL, "Start Date Provided in the sheet  is either a current date or a past date, which is not acceptable ");
							Assert.assertTrue(false, "Start Date Provided in the sheet  is either a current date or a past date, which is not acceptable ");
						}
						else if(residenceCountryName.equalsIgnoreCase("United States") && getDateDifff(startDate, returnDate)>364)
						{
								insertReportLine(LogStatus.FAIL, "The tripduration(StartDate - EndDate) is more than 364 days in the sheet, For OutBound Trip the maximum trip duration is 364 days");
								Assert.assertTrue(false, "(StartDate - EndDate)>364 days in the test data sheet ");
							
						}else if(!residenceCountryName.equalsIgnoreCase("United States") && getDateDifff(startDate, returnDate)>90)
						{
							
								insertReportLine(LogStatus.FAIL, "The tripduration(StartDate - EndDate) is more than 90 days in the sheet, For Inbound/Transnational Trip the maximum trip duration is 90 days");
								Assert.assertTrue(false, "(StartDate - EndDate)>90 days in the test data sheet ");
							
						}
						
						seleniumHelper.clickElement(tripStartDate_txtBox);
						selectDateFromCalender(startDate, homePageDriver);
						
						seleniumHelper.clickElement(tripReturnDate_txtBox);
						selectDateFromCalender(returnDate, homePageDriver);
						
						
						
						if(residenceCountryName.trim().equals("United States"))
						{
							for(int i =0; i<=ages.length-1; i++)
							{
								
								agetextbox = seleniumHelper.findElementByXpath(homePageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
								seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
								if(i==0)
									seleniumHelper.enterValueIntoTextField(stateOne_txtBox, state);
							}
						}else
						{
							for(int i =0; i<=ages.length-1; i++)
							{
								agetextbox = seleniumHelper.findElementByXpath(homePageDriver,ageTextBox_xpath.replace("XXX", Integer.toString(i+1)) );
								seleniumHelper.enterValueIntoTextField(agetextbox, ages[i]);
							}
						}
						
						if(getDaysDifffromCurrentdate(startDate)>=10 && residenceCountryName.equals("United States"))
						{
							
							seleniumHelper.enterValueIntoTextField(tripCancellation_txtBox, tripCancellationAmount);
							
							
								seleniumHelper.clickElement(internalSeeYourQuote_btn);
							
							//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						}
						else
						{
							
								seleniumHelper.clickElement(internalSeeYourQuote_btn);
							
							
							//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						}
						
						for(String s:ages) 
						{
							if(Integer.parseInt(s.trim())>69) 
							{
							seleniumHelper.clickElement(continueButtonOnModal_btn);
							break;
							}
						}
						
						//seleniumHelper.setRunTimeImplicitWait(homePageDriver);
						return new SafetripComparisonPage(homePageDriver);
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
	
	
	
	
	
	

	
	
	

