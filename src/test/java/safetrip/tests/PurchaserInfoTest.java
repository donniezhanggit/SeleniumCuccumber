package safetrip.tests;

import org.testng.annotations.Test;

public class PurchaserInfoTest extends BaseTest {

	
	
//	@Test()
//	public void enterPurchaserDetails_Test55(String noOfTravelers,String destinationCountryName, 
//			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String salutation, String purFirstName, String purMiddleName,String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode)
//	{
//			safetripComparisonPage =  homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
//			travelerInfoPage = safetripComparisonPage.clickOnBuyNowButton(agesSaperatedByComma);
//			purchaserInfoPage = travelerInfoPage.enterTravellerDetailsWithSameAsAllTravelersCheckboxSelected(noOfTravelers, agesSaperatedByComma);
//			purchaserInfoPage.enterPurchaserDetailsIfPurchaserIsNotTraveler(salutation, purFirstName,purMiddleName, purLastName, suffix, primaryPhone, alternatePhone, purEmail, mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode);
//	}
	
	@Test(dataProvider = "tripInfoDetails",enabled = true)
	public void enterPurchaserDetails_Test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String salutation, String purFirstName,String purMiddleName, String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode)
	{
			safetripComparisonPage =  homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
			travelerInfoPage = safetripComparisonPage.clickOnBuyNowButton(agesSaperatedByComma);
			purchaserInfoPage = travelerInfoPage.enterTravellerDetailsWithSameAsAllTravelersCheckboxSelected(noOfTravelers, agesSaperatedByComma);
			purchaserInfoPage.enterPurchaserDetailsIfPurchaserIsNotTraveler(salutation, purFirstName, purMiddleName, purLastName, suffix, primaryPhone, alternatePhone, purEmail, mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode);
	}
		
	

	
}
