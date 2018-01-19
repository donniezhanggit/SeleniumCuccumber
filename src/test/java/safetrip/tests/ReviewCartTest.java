package safetrip.tests;

import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import safetrip.core.generic.utilities.SeleniumHelper;
import safetrip.pages.AffiliateSignUpPage;
import safetrip.pages.HomePage;

public class ReviewCartTest extends BaseTest {

//	@BeforeMethod
//	public void BeforeMethod(Method method)
//	{
//		if(executableTestCases.get(method.getName().trim())==null)
//		{
//			isSkipped = true;
//			throw new SkipException("This is the skip ExceptionMessage");
//		}
//	}
		
//	@Test(dataProvider = "tripInfoDetails",enabled = true)
//	public void verifyReviewCartForOutbound_Test(String noOfTravelers,String destinationCountryName, 
//			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String salutation, String purFirstName, String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode)
//	{
//		safetripComparisonPage =  homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
//		travelerInfoPage = safetripComparisonPage.clickOnBuyNowButton(agesSaperatedByComma);
//		purchaserInfoPage = travelerInfoPage.enterTravellerDetailsWithSameAsAllTravelersCheckboxSelected(noOfTravelers, agesSaperatedByComma);
//		reviewCartPage = purchaserInfoPage.enterPurchaserDetailsIfPurchaserIsNotTraveler(salutation, purFirstName,"", purLastName, suffix, primaryPhone, alternatePhone, purEmail, mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode);
//	}
	
	@Test(dataProvider = "tripInfoDetails",enabled = true)
	public void verifyPurchaserDetails_Test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String salutation, String purFirstName, String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode,  String billingCOuntry, String billingAddressone, String billingAddressTwo, String billingState, String billingCity, String billingZipcode)
	{
		safetripComparisonPage =  homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
		travelerInfoPage = safetripComparisonPage.clickOnBuyNowButton(agesSaperatedByComma);
		purchaserInfoPage = travelerInfoPage.enterTravellerDetailsWithSameAsAllTravelersCheckboxSelected(noOfTravelers, agesSaperatedByComma);
		reviewCartPage = purchaserInfoPage.enterPurchaserDetailsIfPurchaserIsNotTraveler(salutation, purFirstName,"", purLastName, suffix, primaryPhone, alternatePhone, purEmail, mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode);
		reviewCartPage.verifyPurchaserInfo(salutation, purFirstName, purLastName, suffix, primaryPhone, alternatePhone, purEmail, mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode, billingCOuntry, billingAddressone, billingAddressTwo, billingState, billingCity, billingZipcode);
	}

	@Test(dataProvider = "tripInfoDetails",enabled = false)
	public void veriFyTravelerDetails_Test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, 
			String medicalLimit, String deductible, String sportsRider, String salutation, String purFirstName, String purLastName, 
			String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, 
			String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode,String sportsRiderText,String tripCancellationText,String medicalLimitAbv70,String medicalLimitAbv80 )
	{
		safetripComparisonPage =  homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
		travelerInfoPage = safetripComparisonPage.setCoveragePackages(noOfTravelers, startDate, agesSaperatedByComma, residenceCountryName,  tripCancellationAmount, medicalLimit, deductible, sportsRider);
		purchaserInfoPage = travelerInfoPage.enterTravellerDetailsWithSameAsAllTravelersCheckboxSelected(noOfTravelers, agesSaperatedByComma);
		reviewCartPage = purchaserInfoPage.enterPurchaserDetailsIfPurchaserIsNotTraveler(salutation, purFirstName,"", purLastName, suffix, primaryPhone, alternatePhone, purEmail, mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode);
		reviewCartPage.verifyTravellersDetails(noOfTravelers, destinationCountryName, startDate, returnDate, agesSaperatedByComma, tripCancellationAmount,medicalLimit,deductible,sportsRider,sportsRiderText,tripCancellationText,medicalLimitAbv70,medicalLimitAbv80);

	}
	
	@Test(dataProvider = "tripInfoDetails",dependsOnMethods= {"veriFyTravelerDetails_Test"},enabled = false)
	public void modifyPurchaserDetails_Test( String salutation, String purFirstName, String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode)
	{
		purchaserInfoPage = reviewCartPage.modifyPurchaserInfo();
		reviewCartPage = purchaserInfoPage.enterPurchaserDetailsIfPurchaserIsNotTraveler(salutation, purFirstName,"", purLastName, suffix, primaryPhone, alternatePhone, purEmail, mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode);
		
	}
	
	
	
@Test(dataProvider = "tripInfoDetails",dependsOnMethods= {"veriFyTravelerDetails_Test"},enabled = false)
public void modifyTravellersDetails_Test( String noOfTravelers,String destinationCountryName, 
		String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma,String state, String tripCancellationAmount)
{
		homePage = reviewCartPage.modifyTravellersDetails();
safetripComparisonPage =  homePage.modifyTripDetailsForReviewCartPage(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
		
}
	
}                                                                       
