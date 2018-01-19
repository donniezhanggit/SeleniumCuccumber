package enrollment.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import safetrip.pages.BasePage;

public class EnrollmentMaintenancePage extends BasePage {

private  WebDriver enrollmentMaintenancePageDriver;

	
	public EnrollmentMaintenancePage(WebDriver driver)
	{		
		this.enrollmentMaintenancePageDriver = driver;
		PageFactory.initElements(enrollmentMaintenancePageDriver, this);
		pageName = "<b style='color:#00008B;'>"+this.getClass().getSimpleName()+"</b>";
		setBP(this);
	}
	
	
	
	//-----------------ENROLLMENT INFORMATION----------------------//
	@FindBy(xpath = "//form[@id = 'frmEnrollmentDetail']//li[label[contains(text(),'Effective Date')]]")
	public WebElement enrollmentEffectiveDate_txt;
	
	@FindBy(xpath = "//form[@id = 'frmEnrollmentDetail']//li[label[contains(text(),'Expiration Date')]]")
	public WebElement enrollmentExpirationDate_txt;
	
	@FindBy(xpath = "//form[@id = 'frmEnrollmentDetail']//li[label[contains(text(),'Source')]]")
	public WebElement enrollmentSource_txt;
	
	@FindBy(xpath = "//form[@id = 'frmEnrollmentDetail']//li[label[contains(text(),'Enrollment Description')]]")
	public WebElement enrollmentDescription_txt;
	
	@FindBy(xpath = "//form[@id = 'frmEnrollmentDetail']//li[label[contains(text(),'CRM')]]")
	public WebElement enrollment_CRM_txt;
	
	@FindBy(xpath = "//form[@id = 'frmEnrollmentDetail']//li[label[contains(text(),'Created By')]]")
	public WebElement enrollmentCreatedBy_txt;
	
	@FindBy(xpath = "//form[@id = 'frmEnrollmentDetail']//li[label[contains(text(),'ID Card Layout')]]")
	public WebElement enrollmentID_Card_Layout_txt;
	
	@FindBy(xpath = "//form[@id = 'frmEnrollmentDetail']//li[label[contains(text(),'Beneficiary Person')]]")
	public WebElement enrollmentBeneficiaryPerson_txt;
	
	@FindBy(xpath = "//form[@id = 'frmEnrollmentDetail']//li[label[contains(text(),'Dependent Coverage')]]")
	public WebElement enrollmentDependentCoverage_txt;
	
	@FindBy(xpath = "//form[@id = 'frmEnrollmentDetail']//li[label[contains(text(),'Who is Covered?')]]")
	public WebElement enrollmentWho_Is_Covered_txt;
	//-----------------ENROLLMENT INFORMATION----------------------//
	
	//----------------------TABS--------------------------//
	
	@FindBy(xpath = "//div[@id = 'enrollmentTabs']//a[contains(text(),'Benefit Variation')]")
	public WebElement benefitVariation_tab;
	
	@FindBy(xpath = "//div[@id = 'enrollmentTabs']//a[contains(text(),'Product Items')]")
	public WebElement productItems_tabs;
	
	@FindBy(xpath = "//div[@id = 'enrollmentTabs']//a[contains(text(),'Transactions')]")
	public WebElement transactions_tabs;
	
	@FindBy(xpath = "//div[@id = 'enrollmentTabs']//a[contains(text(),'Accounting')]")
	public WebElement accounting_tabs;
	
	
	@FindBy(xpath = "//div[@id = 'enrollmentTabs']//a[contains(text(),'Renewal')]")
	public WebElement renewal_tabs;
	
	@FindBy(xpath = "//div[@id = 'enrollmentTabs']//a[contains(text(),'Cancellation')]")
	public WebElement cancellation_tabs;
	
	@FindBy(xpath = "//div[@id = 'enrollmentTabs']//a[contains(text(),'Destinations')]")
	public WebElement destinations_tabs;
	
	@FindBy(xpath = "//div[@id = 'enrollmentTabs']//a[contains(text(),'Alerts')]")
	public WebElement alerts_tabs;
	
	@FindBy(xpath = "//div[@id = 'enrollmentTabs']//a[contains(text(),'Global Int. Center')]")
	public WebElement global_Int_Center_tabs;
	
	@FindBy(xpath = "//div[@id = 'enrollmentTabs']//a[contains(text(),'Attachments')]")
	public WebElement attachments_tabs;
	
	@FindBy(xpath = "//div[@id = 'enrollmentTabs']//a[contains(text(),'Revision History')]")
	public WebElement revisionHistory_tabs;
	
	@FindBy(xpath = "//table[@id='BenefitVariation']")
	public WebElement benefitVariation_table;
	
	@FindBy(xpath = "//table[@id='EnrollmentProductItem']/tbody")
	public WebElement productItem_table;
	
	@FindBy(xpath = "//table[@id = 'TransactionGrid']")
	public WebElement transactionGrid_table;
	
	@FindBy(xpath = "//table[@id = 'TravelDestinationGrid']")
	public WebElement travelDestination_table;
	
	
	@FindBy(xpath = "//form[@id = 'frmAccountingDetail']//li[label[contains(text(),'ExternalProducer')]]")
	public WebElement externalProducerName_txt;
	
	@FindBy(xpath = "//form[@id = 'frmAccountingDetail']//li[label[contains(text(),'Currency')]]")
	public WebElement currency_txt;
	
	@FindBy(xpath = "//form[@id = 'frmAccountingDetail']//li[label[contains(text(),'Spl. Billing Instructions')]]")
	public WebElement Spl_Billing_Instructions_txt;
	
	
	
	public void verifyEnrollmentDetails(String effectiveDate, String expirationDate, String source, String enrollmentDescription,
			String CRM, String createdBy, String iDCardLayout, String beneficiaryPerson, String dependentCoverage, String whoisCovered)
	{
		String actualDate = "";
		String actualText = "";
		try {
			actualDate = enrollmentEffectiveDate_txt.getText();
			//actualDate = actualDate.substring(14).trim();
			actualDate = actualDate.replace("Effective Date", " ").trim();
			seleniumHelper.validateDate(actualDate, effectiveDate);
			
			actualDate = enrollmentExpirationDate_txt.getText();
			actualDate = actualDate.replace("Expiration Date", " ").trim();
			seleniumHelper.validateDate(actualDate, expirationDate);
			
			actualText = enrollmentSource_txt.getText();
			actualText = actualText.replace("Source", " ").trim();
			seleniumHelper.validateText(actualText, source);
			//seleniumHelper.validateElementText(enrollmentSource_txt, source);
			
			actualText = enrollmentDescription_txt.getText();
			actualText = actualText.replace("Enrollment Description", " ").trim();
			seleniumHelper.validateText(actualText, enrollmentDescription);
			//seleniumHelper.validateElementText(enrollmentDescription_txt, enrollmentDescription);
			
			actualText = enrollment_CRM_txt.getText();
			actualText = actualText.replace("CRM", " ").trim();
			seleniumHelper.validateText(actualText, CRM);
			//seleniumHelper.validateElementText(enrollment_CRM_txt, CRM);
			
			actualText = enrollmentCreatedBy_txt.getText();
			actualText = actualText.replace("Created By", " ").trim();
			seleniumHelper.validateText(actualText, createdBy);
			//seleniumHelper.validateElementText(enrollmentCreatedBy_txt, CRM);
			
			actualText = enrollmentID_Card_Layout_txt.getText();
			actualText = actualText.replace("ID Card Layout", " ").trim();
			seleniumHelper.validateText(actualText, iDCardLayout );
			//seleniumHelper.validateElementText(enrollmentCreatedBy_txt, CRM);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			insertReportLine(e);
		}
	}
	
	public void verifyInboundProductItem(String productItem, String productItemAttribute, String effectiveDate, String expirationDate, String totalPrice, String residentState, String bvDescription, String totalCoveredlives)
	{
		String cellData;
		try {
			productItems_tabs.click();

			cellData = seleniumHelper.getCellData(productItem_table, "tr", "td", 0, 0);
			seleniumHelper.validateText(cellData, productItem);
			
			cellData = seleniumHelper.getCellData(productItem_table, "tr", "td", 0, 1);
			seleniumHelper.validateText(cellData, productItemAttribute);
			
			cellData = seleniumHelper.getCellData(productItem_table, "tr", "td", 0, 2);
			seleniumHelper.validateDate(cellData, effectiveDate);
			
			cellData = seleniumHelper.getCellData(productItem_table, "tr", "td", 0, 3);
			seleniumHelper.validateDate(cellData, expirationDate);
			
			cellData = seleniumHelper.getCellData(productItem_table, "tr", "td", 0, 4);
			seleniumHelper.validateText(cellData, totalPrice);
			
			cellData = seleniumHelper.getCellData(productItem_table, "tr", "td", 0, 5);
			seleniumHelper.validateText(cellData, residentState);
			
			cellData = seleniumHelper.getCellData(productItem_table, "tr", "td", 0, 7);
			seleniumHelper.validateText(cellData, totalCoveredlives);
		
			
			 	System.out.println(cellData);
			
		}catch(Exception e)
		{
		insertReportLine(e);	
		}
		
	}
	
	public void verifyBenefitVariation(String medicalLimit, String deductible, String sportsRider, String productItem, String productItemAttribute, String coveredAmountReqd)
	{
		String bvTableData;
		try {
			
			benefitVariation_tab.click();
			//seleniumHelper.clickElement(benefitVariation_tab);
			
			bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 1,1 );
			seleniumHelper.validateText(bvTableData, "MedicalLimit");
			
			bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 1,2 );
			seleniumHelper.validateText(bvTableData, medicalLimit);
			
			bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 1,3 );
			seleniumHelper.validateText(bvTableData, productItem);
			
			bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 1,4 );
			seleniumHelper.validateText(bvTableData, productItemAttribute);
			
			bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 1,5 );
			seleniumHelper.validateText(bvTableData, coveredAmountReqd);
			
			bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 2,1 );
			seleniumHelper.validateText(bvTableData, "Deductible");
			
			bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 2,2 );
			seleniumHelper.validateText(bvTableData, deductible);
			
			bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 2,3 );
			seleniumHelper.validateText(bvTableData, productItem);
			
			bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 2,4 );
			seleniumHelper.validateText(bvTableData, productItemAttribute);
			
			bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 2,5 );
			seleniumHelper.validateText(bvTableData, coveredAmountReqd);
			
			
			if(sportsRider.equalsIgnoreCase("Yes"))
			{
				bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 3,1 );
				seleniumHelper.validateText(bvTableData, "Sports Rider");
				
				bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 3,2 );
				seleniumHelper.validateText(bvTableData, "Sports Rider");
				
				bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 3,3 );
				seleniumHelper.validateText(bvTableData, productItem);
				
				bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 3,4 );
				seleniumHelper.validateText(bvTableData, productItemAttribute);
				
				bvTableData = seleniumHelper.getCellData(benefitVariation_table, "tr", "td", 3,5 );
				seleniumHelper.validateText(bvTableData, coveredAmountReqd);
			}
			
			
			
		}catch(Exception e)
		{
			System.out.println("inside");
		}
	}
	
	public void verifyInboundEnrollmentTransaction(String transactionType, String transactionDate, String systemDate, String totalPrice, String effectiveDate, String expirationDate, String paymentMethod, String status)
	{
		String transactionTableData = "";
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todayDate = format.format(date);
		try {
			transactions_tabs.click();
			transactionTableData = seleniumHelper.getCellData(transactionGrid_table, "tr", "td", 1, 2);
			seleniumHelper.validateText(transactionTableData, transactionType);
						
			transactionTableData = seleniumHelper.getCellData(transactionGrid_table, "tr", "td", 1, 3);
			seleniumHelper.validateDate(transactionTableData, todayDate);

			transactionTableData = seleniumHelper.getCellData(transactionGrid_table, "tr", "td", 1, 4);
			seleniumHelper.validateDate(transactionTableData, todayDate);
			
			transactionTableData = seleniumHelper.getCellData(transactionGrid_table, "tr", "td", 1, 5);
			seleniumHelper.validateText(transactionTableData, totalPrice);
			
			transactionTableData = seleniumHelper.getCellData(transactionGrid_table, "tr", "td", 1, 6);
			seleniumHelper.validateText(transactionTableData, effectiveDate);
			
			transactionTableData = seleniumHelper.getCellData(transactionGrid_table, "tr", "td", 1, 7);
			seleniumHelper.validateText(transactionTableData, expirationDate);
			
			transactionTableData = seleniumHelper.getCellData(transactionGrid_table, "tr", "td", 1, 8);
			seleniumHelper.validateText(transactionTableData, paymentMethod);
			
			transactionTableData = seleniumHelper.getCellData(transactionGrid_table, "tr", "td", 1, 9);
			seleniumHelper.validateText(transactionTableData, status);
	
			
		}catch(Exception e)
		{
			insertReportLine(e);
		}
	
	}
	
	public void verifyEnrollmentAccountingDetails(String externalProducer, String currency, String splBillingInstruction)
	{
		try {
			
			
			//seleniumHelper.validateElementTextContains(externalProducerName_txt, externalProducer);
			seleniumHelper.validateElementTextContains(currency_txt, currency);
			seleniumHelper.validateElementTextContains(Spl_Billing_Instructions_txt, splBillingInstruction);
			
		}catch(Exception e)
		{
			insertReportLine(e);
		}
	}
	
}
