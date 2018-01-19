package safetrip.tests;

import org.testng.annotations.Test;

import safetrip.pages.BasePage;



public class ComparisonScreenTest extends BaseTest{

	@Test(dataProvider = "tripInfoDetails", enabled = true)
	public void verifyTripInfoDetails_test(String noOfTravelleres,String destinationCounry, String residentCountryName, String tripStartDate, String tripReturnDate, String agesSaparatedbyComma, String verifyText)
	{
		
		safetripComparisonPage = homePage.setinBoundTravel(noOfTravelleres,destinationCounry, residentCountryName, tripStartDate, tripReturnDate, agesSaparatedbyComma);
		 safetripComparisonPage.verifyTripInfoPageSection(noOfTravelleres,destinationCounry, residentCountryName, tripStartDate, tripReturnDate, agesSaparatedbyComma);
		//safetripComparisonPage = homePage.setinBoundTravel(noOfTravelleres,destinationCounry, residentCountryName, tripStartDate, tripReturnDate, agesSaparatedbyComma);
		
	}
	
	@Test(dataProvider = "tripInfoDetails", enabled = true )
	public void inboundOfferedPackages_test(String noOfTravelleres,String destinationCounry, String residentCountryName, String tripStartDate, String tripReturnDate, String agesSaparatedbyComma, String verifyText, String coverageAmountText,String deductibleText,String extremeSportsCoverageText, String tripCancellationText)
	{
		safetripComparisonPage = homePage.setinBoundTravel(noOfTravelleres,destinationCounry, residentCountryName, tripStartDate, tripReturnDate, agesSaparatedbyComma);
		safetripComparisonPage.verifyOfferedPackages(residentCountryName,tripStartDate, coverageAmountText, deductibleText, extremeSportsCoverageText, tripCancellationText);
		safetripComparisonPage.verifyNumberOfTiers(residentCountryName);
	}
	
	@Test(dataProvider = "tripInfoDetails", enabled = true )
	public void outBoundOfferedPackages_test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount,  String coverageAmountText,String deductibleText,String extremeSportsCoverageText, String tripCancellationText) 
	{
		safetripComparisonPage = homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
		safetripComparisonPage.verifyOfferedPackages(residenceCountryName, startDate, coverageAmountText, deductibleText, extremeSportsCoverageText, tripCancellationText);
		safetripComparisonPage.verifyNumberOfTiers(residenceCountryName);
	}
	
	@Test(dataProvider = "tripInfoDetails", enabled = true )
	public void transNationalOfferedPackages_test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount,  String coverageAmountText,String deductibleText,String extremeSportsCoverageText, String tripCancellationText) 
	{
		safetripComparisonPage = homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
		safetripComparisonPage.verifyOfferedPackages(residenceCountryName, startDate, coverageAmountText, deductibleText, extremeSportsCoverageText, tripCancellationText);
		safetripComparisonPage.verifyNumberOfTiers(residenceCountryName);
	}

	@Test(dataProvider = "tripInfoDetails",groups = {"Independent"},enabled = true)
	public void veriFyTripCalculations_Test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String medicalLimit, String deductible, String sportsRider)
	{
		safetripComparisonPage =  homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
		safetripComparisonPage.verifyQuoteCalculations(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, verifyText, state, tripCancellationAmount, medicalLimit, deductible, sportsRider);
	}
	
	@Test(dataProvider = "tripInfoDetails",enabled = true)
	public void setCoveragePackage_Test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String medicalLimit, String deductible, String sportsRider)
	{
		safetripComparisonPage =  homePage.setTripDetails(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, state, tripCancellationAmount);
		safetripComparisonPage.setCoveragePackages(noOfTravelers, startDate, agesSaperatedByComma, residenceCountryName, tripCancellationAmount, medicalLimit, deductible, sportsRider);
	}
	
	
			
		
	
}
