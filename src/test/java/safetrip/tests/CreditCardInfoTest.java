package safetrip.tests;

import org.testng.annotations.Test;

public class CreditCardInfoTest extends BaseTest {
	
	@Test(dataProvider = "tripInfoDetails",enabled = true)
	public void validatePurchaserInfoOnCreditCardPage_Test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String salutation, String purFirstName,String purMiddleName, String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode)
	{
		safetripComparisonPage =  homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
		travelerInfoPage = safetripComparisonPage.clickOnBuyNowButton(agesSaperatedByComma);
		purchaserInfoPage = travelerInfoPage.enterTravellerDetailsWithSameAsAllTravelersCheckboxSelected(noOfTravelers, agesSaperatedByComma);
		reviewCartPage = purchaserInfoPage.enterPurchaserDetailsIfPurchaserIsNotTraveler(salutation, purFirstName,purMiddleName, purLastName, suffix, primaryPhone, alternatePhone, purEmail, mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode);
		creditCardInfoPage = reviewCartPage.acceptingTermsNavigatingToCreditCardPage();
		creditCardInfoPage.validatePurchaserInformation(salutation, purFirstName, purMiddleName, purLastName, suffix, primaryPhone, alternatePhone, purEmail);
	}

	@Test(dataProvider = "tripInfoDetails",enabled = true)
	public void validateCreditCardInfoPage_Test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String salutation, String purFirstName,String purMiddleName, String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode, 
			String billingCOuntry, String billingAddressone, String billingAddressTwo, String billingState, String billingCity, String billingZipcode)
	{
		safetripComparisonPage =  homePage.setTripDetails(noOfTravelers,  destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
		//travelerInfoPage = safetripComparisonPage.clickOnBuyNowButton(agesSaperatedByComma);
		travelerInfoPage = safetripComparisonPage.setCoveragePackages(noOfTravelers, startDate, agesSaperatedByComma, residenceCountryName, tripCancellationAmount, "500000", "250", "No");
		
		purchaserInfoPage = travelerInfoPage.enterTravellerDetailsWithSameAsAllTravelersCheckboxSelected(noOfTravelers, agesSaperatedByComma);
		reviewCartPage = purchaserInfoPage.enterPurchaserDetailsWhereMailingNotSameAsBillingAddress(salutation, purFirstName, purMiddleName, purLastName, suffix, primaryPhone, alternatePhone, purEmail, mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode, billingCOuntry, billingAddressone, billingAddressTwo, billingState, billingCity, billingZipcode);
		creditCardInfoPage = reviewCartPage.acceptingTermsNavigatingToCreditCardPage();
		creditCardInfoPage.validatePurchaserInformation(salutation, purFirstName, purMiddleName, purLastName, suffix, primaryPhone, alternatePhone, purEmail);
		creditCardInfoPage.validatePolicyInfo(tripCancellationAmount, noOfTravelers, startDate, returnDate);
		creditCardInfoPage.validatePurchaserAddressDetails(mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode, billingCOuntry, billingAddressone, billingAddressTwo, billingState, billingCity, billingZipcode);
	
	}
	
}
