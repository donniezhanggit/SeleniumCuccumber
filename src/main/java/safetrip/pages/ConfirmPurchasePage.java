package safetrip.pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import enrollment.pages.EnrollmentMaintenancePage;

public class ConfirmPurchasePage extends BasePage {
private WebDriver confirmPurchasePageDriver;
	
String URL = "http://test-concourse.uhc.com/Enrollment/Enrollment/EnrollmentDetail?enrollmentId=903398411&isSearch=True";
	public ConfirmPurchasePage(WebDriver driver)
	{
		this.confirmPurchasePageDriver = driver;
		PageFactory.initElements(driver, this);
		pageName = "<b style='color:#00008B;'>"+this.getClass().getSimpleName()+"</b>";
			bp = this;
	}
	
	
	@FindBy(xpath = "//p[contains(text(),'Order')]/b")//"//p[strong[text() = 'Order']]")
	public WebElement orderId_txt;
	
	@FindBy(xpath = "//b[contains(text(), 'Get another quote')]")//"//a[text() = 'Get another quote']")
	public WebElement getAnotherQuote_btn;
	
	@FindBy(xpath = "//p[contains(text(),'Fulfillment to be sent to')]/b")//p[strong[text() = 'Fulfillment to be sent to']]")
	public WebElement fulfillemtEmailsList_txt;
	
	@FindBy(xpath = "//a[span[text()='Home']]/i")
	public WebElement homePageIcon_link;
	
	@FindBy(xpath = "//a[contains(text(),'here')]")//a[@title = 'Home']/u[text()='clicking here']")
	public WebElement clickingHere_link;
	
	public HomePage getPurchaseDetailsFromConfirmationPage()
	{
		System.out.println("Order Id----------------------------------------> "+orderId_txt.getText().substring(6));
		//System.out.println(fulfillemtEmailsList_txt.getText());
		homePageIcon_link.click();
		
		//seleniumHelper.setRunTimeImplicitWait(confirmPurchasePageDriver);
		
		return new HomePage(confirmPurchasePageDriver);
	}
	
	public void verifyOrderSucess(String qwery)
	{
		System.out.println(orderId_txt.getText());
//		Statement statement = null;
//		try {
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		String orderId = orderId_txt.getText().substring(6);
//		//System.out.println(orderId);
//		String qweryToCheckInDb = qwery.replace("XXXX", orderId);
//		
//		//System.out.println(qweryToCheckInDb);
//		
//		
//		statement = dbConnectForSalesCompletedVerification();
//		ResultSet rs = null;
//		String publishedValue = null;
//		 String salesCompletedValue = null;
//		 for(int i = 1; i<=180; i++)
//		 {
//			
//			 rs = statement.executeQuery(qweryToCheckInDb);
//			 
//			 
//		 while (rs.next()) {
//    	
//   		  for(int k = 1; k<=rs.getMetaData().getColumnCount();k++)
//   		  {
//   			 
//   			  String columnNames = rs.getMetaData().getColumnName(k);
//   			  
//   			  if(columnNames.equals("SalesCompleted"))
//   				salesCompletedValue = rs.getString(columnNames);
//   			  if(columnNames.equals("Published"))
//   				publishedValue = rs.getString(columnNames);
//   			  
//   		  }
//        	 
//   		  } 
//			 if(salesCompletedValue.equals("1") && publishedValue.equals("1"))
//			 {
//				 insertReportLine(LogStatus.PASS	, "The Sales is completed and the order is published");
//				 Assert.assertTrue(true);
//				 break;
//			 }
//			 else
//			 {
//				 try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					statement.getConnection().close();
//					statement.close();
//				}
//			 }	 
//		 }
//		 statement.getConnection().close();
//		 statement.close();
//		 if(salesCompletedValue.equals("1") && publishedValue.equals("0"))
//		 {
//			 insertReportLine(LogStatus.FAIL	, "The Sales is completed But the order is not published");
//			 Assert.assertTrue(false);
//			
//		 } else if(salesCompletedValue.equals("0") && publishedValue.equals("0"))
//		 {
//			 insertReportLine(LogStatus.FAIL	, "The Sales is not completed and the order is not published");
//			 Assert.assertTrue(false);
//			
//			 
//		 }
//		 
//		
//		} catch (SQLException e) {
//			 insertReportLine(LogStatus.FAIL	, e.getClass().getSimpleName()+" Exception Occured while verying the sales completed process");
//			 //statement.getConnection().close();
//			//statement.close();
//			Assert.assertTrue(false);
//				
//			 
//			 System.out.println(e.getStackTrace());
//		}
	}
	
	public void verifyDeclinedOrder(String qwery)
	{
		Statement statement = null;
		try {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				 insertReportLine(e1);
				e1.printStackTrace();
			}
		String orderId = safetripOrderId;
		System.out.println(orderId);
		String qweryToCheckInDb = qwery.replace("XXXX", orderId);
		
		System.out.println(qweryToCheckInDb);
		
		
		statement = dbConnectForSalesCompletedVerification();
		ResultSet rs = null;
		
		 String statusColumnValue  = "";
		 String voidTransactionColumnValue = "";
		 String messageColumnValue = "";
		 String OrderIdInDB = "";
//		 for(int i = 1; i<=180; i++)
//		 {
			
			 rs = statement.executeQuery(qweryToCheckInDb);
			 
			 
		 while (rs.next()) {
    	
   		  for(int k = 1; k<=rs.getMetaData().getColumnCount();k++)
   		  {
   			 
   			  String columnNames = rs.getMetaData().getColumnName(k);
   			  
   			  if(columnNames.equalsIgnoreCase("status"))
   				statusColumnValue = rs.getString(columnNames);
   			  if(columnNames.equalsIgnoreCase("Message"))
   				messageColumnValue = rs.getString(columnNames);
   			if(columnNames.equalsIgnoreCase("OrderId"))
   				OrderIdInDB = rs.getString(columnNames); 
   		  }
        	 
   		  } 
		 statement.getConnection().close();
		 statement.close();
		 System.out.println();
		 voidTransactionColumnValue =  runQuerytoGetSingleColumnValue(Environment("R&ATableName"),"Select * from ProcessingContext..SafetripOrder where id = "+orderId, "VoidTransaction");
		 
			 if(statusColumnValue.equals("4") && voidTransactionColumnValue.equals("1") && !messageColumnValue.contains("A01") )
			 {
				 insertReportLine(LogStatus.PASS, "The Transaction Got Declined as expected, The Details from SafetripOrderItem table of Order "+OrderIdInDB+" are are: Status = "+statusColumnValue+" VoidTransction= "+voidTransactionColumnValue+" Message= "+messageColumnValue);
				 Assert.assertTrue(true,"The Transaction Got Declined as expected, The Details from SafetripOrderItem table of order "+OrderIdInDB+" are are: Status- "+statusColumnValue+" VoidTransction- "+voidTransactionColumnValue+" Message- "+messageColumnValue);
				// break;
			 }
			 else
			 {
				 insertReportLine(LogStatus.FAIL, "The Transaction  is not Declined, The Details from SafetripOrderItem table of order "+OrderIdInDB+" are are: Status- "+statusColumnValue+" VoidTransction- "+voidTransactionColumnValue+" Message- "+messageColumnValue);
				 Assert.assertTrue(false,"The Transaction  is not Declined, The Details from SafetripOrderItem table of order "+OrderIdInDB+" are are: Status- "+statusColumnValue+" VoidTransction- "+voidTransactionColumnValue+" Message- "+messageColumnValue);
				// break;
			 }	 
		// }
		
		
		 
		
		} catch (SQLException e) {
			 insertReportLine(LogStatus.FAIL	, e.getClass().getSimpleName()+" Exception Occured while verying the sales completed process");
			 insertReportLine(e);
			 try {
				statement.getConnection().close();
				statement.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				 insertReportLine(e1);
			}
			
			Assert.assertTrue(false);
				
			 
			 System.out.println(e.getStackTrace());
		}
	}
	
	public EnrollmentMaintenancePage navigateToHomePage()
	{
		
		try {
//			System.out.println("Order Id------------> "+orderId_txt.getText());
//			insertReportLine(LogStatus.PASS, "Order Generated Order Id is--->>"+orderId_txt.getText());
//			System.out.println(fulfillemtEmailsList_txt.getText());
//		Thread.sleep(10000);	
			String enrollmentId = runQuerytoGetSingleColumnValue(Environment("ConcourseTableName"), "Select * from Enrollment_DB..NextOrderNum where OrderId = '"+safetripOrderId+"'", "Enrollments");
			
			confirmPurchasePageDriver.get(URL.replace("XXXX", enrollmentId));
			
			//seleniumHelper.clickElement(homePageIcon_link);
			//seleniumHelper.setRunTimeImplicitWait(confirmPurchasePageDriver);
			
			return new EnrollmentMaintenancePage(confirmPurchasePageDriver);
			
		}catch(Exception e) {
			 insertReportLine(e);
		}
	
		return new EnrollmentMaintenancePage(confirmPurchasePageDriver);
		
	}

}
