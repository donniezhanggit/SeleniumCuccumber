package safetrip.tests;

import org.testng.annotations.Test;

import enrollment.pages.EnrollmentMaintenancePage;
import safetrip.pages.HomePage;



public class CompletePurchaseTest extends BaseTest {

	
		
	@Test(dataProvider = "tripInfoDetails",enabled = false)
	public EnrollmentMaintenancePage completePurchase_Test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String salutation, String purFirstName, String purMiddleName,String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode,String cardNumber, String cardExpMonth, String cardExpYear)
	{
			safetripComparisonPage =  homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
			travelerInfoPage = safetripComparisonPage.clickOnBuyNowButton(agesSaperatedByComma);
			purchaserInfoPage = travelerInfoPage.enterTravellerDetailsWithSameAsAllTravelersCheckboxSelected(noOfTravelers, agesSaperatedByComma);
			reviewCartPage = purchaserInfoPage.enterPurchaserDetailsIfPurchaserIsNotTraveler(salutation, purFirstName,purMiddleName, purLastName, suffix, primaryPhone, alternatePhone, purEmail, mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode);
			creditCardInfoPage = reviewCartPage.acceptingTermsNavigatingToCreditCardPage();
			confirmPurchasePage = creditCardInfoPage.completePurchase(cardNumber, cardExpMonth, cardExpYear);
			return enrollmentMaintenancePage = confirmPurchasePage.navigateToHomePage();
	}
		
	@Test(dataProvider = "tripInfoDetails",enabled = true)
	public void veriFyOrderSucessful_Test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String salutation, String purFirstName,String purMiddleName, String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode,String cardNumber, String cardExpMonth, String cardExpYear, String qweryToCheckInDb) throws InterruptedException
	{
			safetripComparisonPage =  homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
			travelerInfoPage = safetripComparisonPage.clickOnBuyNowButton(agesSaperatedByComma);
			//purchaserInfoPage = travelerInfoPage.enterAllTravelerDetails(noOfTravelers, agesSaperatedByComma);
			purchaserInfoPage = travelerInfoPage.enterTravellerDetailsWithSameAsAllTravelersCheckboxSelected(noOfTravelers, agesSaperatedByComma);
			reviewCartPage = purchaserInfoPage.enterPurchaserDetailsIfPurchaserIsNotTraveler(salutation, purFirstName,purMiddleName, purLastName, suffix, primaryPhone, alternatePhone, purEmail, mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode);
			creditCardInfoPage = reviewCartPage.acceptingTermsNavigatingToCreditCardPage();
			confirmPurchasePage = creditCardInfoPage.completePurchase(cardNumber, cardExpMonth, cardExpYear);
			
			
//			confirmPurchasePage.verifyDeclinedOrder(qweryToCheckInDb);
			//enrollmentMaintenancePage = confirmPurchasePage.navigateToHomePage();
			
	}
	
	@Test(dataProvider = "tripInfoDetails",enabled = false)
	public void veriFyOrderDeclined_Test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount,String medicalLimit, String deductible, String sportsRider, String salutation, String purFirstName,String purMiddleName, String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode,String cardNumber, String cardExpMonth, String cardExpYear, String qweryToCheckInDb) throws InterruptedException
	{
		//System.out.println(startDate+" "+returnDate);
		
		
		//	confirmPurchasePage.verifyDeclinedOrder(qweryToCheckInDb);
			//homePage = confirmPurchasePage.navigateToHomePage();
			
	}
	
	
		
		


	
}
