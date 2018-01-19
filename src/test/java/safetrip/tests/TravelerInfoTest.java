package safetrip.tests;

import org.testng.annotations.Test;

public class TravelerInfoTest extends BaseTest{

	
	@Test(dataProvider = "tripInfoDetails",enabled = true)
	public void verifyModalWindowForAgeDiff(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount,String travelerFirstName, String travelerLastName, String trvDateOfBirth)
	{
			safetripComparisonPage =  homePage.setTripDetails("2", destinationCountryName, residenceCountryName, startDate, returnDate, "20,30", state, tripCancellationAmount);
			travelerInfoPage = safetripComparisonPage.clickOnBuyNowButton(agesSaperatedByComma);
			travelerInfoPage.openAgeModalWindow(travelerFirstName, travelerLastName, trvDateOfBirth, "70");
			travelerInfoPage.validateAgeModalWindow("20", "70", "2", destinationCountryName, residenceCountryName, startDate, returnDate, "70,30", verifyText, state, "0", "100000", "100", "No");
			travelerInfoPage.closeAgeModalWindow();
			travelerInfoPage.openAgeModalWindow(travelerFirstName, travelerLastName, trvDateOfBirth, "80");
			travelerInfoPage.validateAgeModalWindow("20", "80", "2", destinationCountryName, residenceCountryName, startDate, returnDate, "80,30", verifyText, state, "0", "100000", "100", "No");
			travelerInfoPage.closeAgeModalWindow();
			travelerInfoPage.openAgeModalWindow(travelerFirstName, travelerLastName, trvDateOfBirth, "40");
			travelerInfoPage.validateAgeModalWindow("20", "40", "2", destinationCountryName, residenceCountryName, startDate, returnDate, "40,30", verifyText, state, "0", "100000", "100", "No");
			
			travelerInfoPage.closeAgeModalWindow();
			travelerInfoPage.openAgeModalWindow(travelerFirstName, travelerLastName, trvDateOfBirth, "87");
			travelerInfoPage.validateAgeModalWindow("20", "87", "2", destinationCountryName, residenceCountryName, startDate, returnDate, "87,30", verifyText, state, "0", "100000", "100", "No");
			sfAssert.assertAll();
	}
	
	@Test(dataProvider = "tripInfoDetails",enabled = true)
	public void updateQuoteInfoFromTravelerInfoPage(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount)
	{
		safetripComparisonPage =  homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
		travelerInfoPage = safetripComparisonPage.clickOnBuyNowButton(agesSaperatedByComma);
		homePage = travelerInfoPage.clickOnModifyLink();
		safetripComparisonPage = homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
		safetripComparisonPage.verifyTripInfoPageSection(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma);
		sfAssert.assertAll();
	}
	
}
