package safetrip.tests;

import org.testng.annotations.Test;

public class SafetripToEnrollmentTest extends BaseTest {

	CompletePurchaseTest completePurchaseTest = new CompletePurchaseTest();
	//completePurchaseTest.completePurchase_Test
	
	@Test(dataProvider = "tripInfoDetails",enabled = true)
	public void verifyInboundEnrollments_test(String noOfTravelers,String destinationCountryName, 
			String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String verifyText, String state, String tripCancellationAmount, String salutation, String purFirstName, String purMiddleName,String purLastName, String suffix, String primaryPhone, String alternatePhone, String purEmail, String mailingCOuntry, String mailingAddressone, String mailingAddressTwo, String mailingState, String mailingCity, String mailingZipcode,String cardNumber, String cardExpMonth, String cardExpYear,
			String source, String enrollmentDescription,
			String CRM, String createdBy, String iDCardLayout, String beneficiaryPerson, String dependentCoverage, String whoisCovered)
	{
		enrollmentMaintenancePage = completePurchaseTest.completePurchase_Test(noOfTravelers, destinationCountryName, residenceCountryName, startDate, returnDate, agesSaperatedByComma, verifyText, state, tripCancellationAmount, salutation, purFirstName, purMiddleName, purLastName, suffix, primaryPhone, alternatePhone, purEmail, mailingCOuntry, mailingAddressone, mailingAddressTwo, mailingState, mailingCity, mailingZipcode, cardNumber, cardExpMonth, cardExpYear);
		//enrollmentMaintenancePage  = new EnrollmentMaintenancePage(testDriver);
		enrollmentMaintenancePage.verifyEnrollmentDetails(startDate, returnDate, source, enrollmentDescription, CRM, createdBy, iDCardLayout, beneficiaryPerson, dependentCoverage, whoisCovered);
	}
	
}
