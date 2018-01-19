package safetrip.tests;

import org.testng.annotations.Test;

public class AffiliateSignUpTest extends BaseTest
{

	@Test(dataProvider = "tripInfoDetails",enabled= true)
	public void Affiliatesignup_Test(String entityValue,String Name,String firstName,String middleName,String lastName,String LicenseNumber,String stateLicensed, 
			String website,String taxID,String contactPerson,String emailAddress,String phoneNumber,String faxnumber,String Address1, String Address2,String city,String country,String state,String zipCode)
	{
		affiliateSignUpPage = homePage.navigateToAffiliateSignUpPage();
		affiliateSignUpPage.setAffiliateDetails(entityValue, Name, firstName, middleName, lastName, LicenseNumber, stateLicensed, website, taxID, contactPerson, emailAddress, phoneNumber, faxnumber, Address1, Address2, city, country, state, zipCode);
		
	}
	
	
	@Test(dataProvider = "tripInfoDetails",enabled= true)
	public void ValidateAffiliatesignupDetails_Test(String entityValue,String Name,String firstName,String middleName,String lastName,String LicenseNumber,String stateLicensed, 
			String website,String taxID,String contactPerson,String emailAddress,String phoneNumber,String faxnumber,String Address1, String Address2,String city,String country,String state,String zipCode)
	{
		affiliateSignUpPage = homePage.navigateToAffiliateSignUpPage();
		affiliateSignUpPage.validateAffiliateDetails(entityValue, Name, firstName, middleName, lastName, LicenseNumber, stateLicensed, website, taxID, contactPerson, emailAddress, phoneNumber, faxnumber, Address1, Address2, city, country, state, zipCode);
		affiliateSignUpPage.verifyElementHighlightedInRedColor("License number");
		affiliateSignUpPage.verifyElementHighlightedInRedColor("Website");
		
		//seleniumHelper.enterValueIntoTextField(affiliateSignUpPage.website_txtbox, "skdfhskd");
		//seleniumHelper.validateElementText(affiliateSignUpPage.website_txtbox, "skdfhskd");
		
		seleniumHelper.enterValueIntoTextField(affiliateSignUpPage.website_txtbox, "uhg.com");
		
		seleniumHelper.enterValueIntoTextField(affiliateSignUpPage.emailaddress_txtbox, "uhggmail");
		
		seleniumHelper.clickElement(affiliateSignUpPage.submit_button);
		
		affiliateSignUpPage.verifyElementHighlightedInRedColor("Website");
		affiliateSignUpPage.verifyElementHighlightedInRedColor("Email address");
		
		
	}
	
	
}
