package safetrip.tests;


import org.testng.annotations.Test;


public class EnterTravelerAndPurchaserInfoTest extends BaseTest {

	
//*---------------------------------Test Cases--------------------------------------------*//
	
	@Test(enabled = true)
	public void validateTripCancelationField()
	{
		//seleniumHelper.waitForAobjectToBeVisible(homePage.stateOne_txtBox, currentDriver);
		seleniumHelper.clickElement(homePage.noOfTravelers_txtBox);
		seleniumHelper.clickElement(seleniumHelper.findElementByXpath(currentDriver, homePage.noOfTravellers_li_xpath.replace("XXX", "3")));
		seleniumHelper.clickElement(homePage.residenceCountry_txtBox);
		seleniumHelper.clickElement(seleniumHelper.findElementByXpath(currentDriver, homePage.countryList_xpath.replace("XXX", "United States")));
		seleniumHelper.clickElement(homePage.primaryDestination_txtBox);
		seleniumHelper.clickElement(seleniumHelper.findElementByXpath(currentDriver, homePage.countryList_xpath.replace("XXX", "India")));
		
	}
	
	
//	@Test(dataProvider = "tripInfoDetails", enabled = true	)
//	public void validateHomePageModalWindow_test(String noOfTravelleres,String destinationCounry, String residentCountryName, String tripStartDate, String tripReturnDate, String agesSaparatedbyComma, String verifyText)
//	{		
//		
//		
//		
//		
//	}
//	
//	
	
	
	@Test(dataProvider = "tripInfoDetails", enabled = true)//stable
	public void enterInboundTripInfo_test(String noOfTravelleres,String destinationCounry, String residentCountryName, String tripStartDate, String tripReturnDate, String agesSaparatedbyComma, String verifyText)
	{		
		
		safetripComparisonPage = homePage.setinBoundTravel(noOfTravelleres, destinationCounry, residentCountryName, tripStartDate, tripReturnDate, agesSaparatedbyComma);
		safetripComparisonPage.verifySafetripComparisonScreen(verifyText);
		
	}
	@Test(dataProvider = "tripInfoDetails",enabled = true)//stable
	public void verifyDatePickedFromCalender_test(String noOfTravelers,String destinationCountryName, String residenceCountryName, String startDate, String returnDate, String agePageLabel)
	{
		homePage.validateAgeErrorMessages(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, "", "", "", "", "");
		homePage.selectAgeFromCalender(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agePageLabel);
	}
	
	@Test(dataProvider = "tripInfoDetails",enabled = true)//stable
	public void verifyTheStepCountIsInCreasingForInBound_test(String noOfTravelers,String destinationCountryName, String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma)
	{
		homePage.verifyInboundStepCounter(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma);
		
	}
	
	@Test(dataProvider = "tripInfoDetails",enabled = true)//stable
	public void verifyErrorMessagesIfFieldsAreMissed_test(String noOfTravelers,String destinationCountryName, String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String textToBeValidated)
	{
		homePage.verifyErrorMessages(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, textToBeValidated);
	}

	@Test(dataProvider = "tripInfoDetails",enabled = true)//stable
	public void verifyInboundTripToolTips_test(String noOfTravelers,String destinationCountryName,String residenceCountryName,
													String primaryDestinationTooltip, String residentCountryTooltip, 
													String startDate, String returnDate, String ageTooltipText, String agesSaperatedByComma)
	{
		homePage.verifyHomePageTooltipsForInboundTrip(noOfTravelers, destinationCountryName, residenceCountryName, primaryDestinationTooltip, residentCountryTooltip, startDate, returnDate, ageTooltipText, agesSaperatedByComma);
	}

	//*=================================OutBound Test Cases==========================================*//
	@Test(dataProvider = "tripInfoDetails", enabled = true)
	public void setOutboundTravel_test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount) 
	{
		safetripComparisonPage = homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
		safetripComparisonPage.verifySafetripComparisonScreen(verifyText);
	}
	
	
	//*====================================Entering Traveler Details==============================*//
//	@Test(dataProvider = "tripInfoDetails", enabled = true)
//	public void enterTravelerDetails_test(String noOfTravelers,String destinationCountryName, 
//			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount)
//	{
//		
//		safetripComparisonPage = homePage.setOutBoundTravel(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
//		travelerInfoPage = safetripComparisonPage.clickOnBuyNowButton(agesSaperatedByComma);
//		travelerInfoPage.enterTravellerDetailsWithSameAsAllTravelersCheckboxSelected(noOfTravelers, agesSaperatedByComma);
//	}
//	
		
		
	}
	
	

