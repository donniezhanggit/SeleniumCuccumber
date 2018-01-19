package safetrip.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.util.AreaReference;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import enrollment.pages.EnrollmentMaintenancePage;
import safetrip.core.generic.utilities.AutomationCore;
import safetrip.core.generic.utilities.SeleniumHelper;
import safetrip.pages.AffiliateSignUpPage;
import safetrip.pages.ConfirmPurchasePage;
import safetrip.pages.CreditCardInfoPage;
import safetrip.pages.PurchaserInfoPage;
import safetrip.pages.ReviewCartPage;
import safetrip.pages.SafetripComparisonPage;
import safetrip.pages.TravelerInfoPage;


public class BaseTest extends AutomationCore implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider{

	
	public WebDriver testDriver = null;
	public static safetrip.pages.HomePage homePage=null;
	public SafetripComparisonPage safetripComparisonPage=null;
	public TravelerInfoPage travelerInfoPage = null;
	public PurchaserInfoPage  purchaserInfoPage = null;
	public ReviewCartPage reviewCartPage = null;
	public CreditCardInfoPage creditCardInfoPage = null;
	public ConfirmPurchasePage confirmPurchasePage = null;
	public AffiliateSignUpPage affiliateSignUpPage = null;
	public EnrollmentMaintenancePage enrollmentMaintenancePage = null;

	
	//public String testName=null;
	public boolean status=true;
	public int totalIterations =0;
	public int currentIteration=1;
	public String initialTIme=null;
	int i = 1;
	ExtentReports extent;
	ExtentTest test;
	ExtentTest childTest = null;
	ThreadLocal<ExtentTest> testStatusThread = new ThreadLocal<ExtentTest>();
	
	static String All_testCaseNames = "";
	
	public String seleniumURI = "@ondemand.saucelabs.com:443";
	public String buildTag = System.getenv("BUILD_TAG");
	public String username = "nsahu102";//System.getenv("SAUCE_USERNAME");
	public String accesskey = "5838f151-6eb6-4584-8c8e-d7108a4e0859";//System.getenv("SAUCE_ACCESS_KEY");
	public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(username, accesskey);
	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	private ThreadLocal<String> sessionId = new ThreadLocal<String>();

	
	
	boolean reportAdded = false;
	int st = 0;
	public void getExecutionDetails()
	{
		try {
			
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+Environment("testDataFilePath")+Environment("moduleDriverFile"));
			Workbook workBook = new XSSFWorkbook(fileInputStream);
			int namedCellIdx = workBook.getNameIndex("TestExecution_Details");			
		    org.apache.poi.ss.usermodel.Name aNamedCell = workBook.getNameAt(namedCellIdx);
			AreaReference area = new AreaReference(aNamedCell.getRefersToFormula());
			CellReference[] cellrefs = area.getAllReferencedCells();
			Sheet s = workBook.getSheet(aNamedCell.getSheetName());
			int startRowindex = cellrefs[0].getRow();
			
			appURL = s.getRow(startRowindex).getCell(2).getStringCellValue();
			testDataFileName = s.getRow(startRowindex).getCell(3).getStringCellValue();
			workBook.close();
		}catch(Exception e)
		{
			insertReportLine(e);
		}
	}
	
	public void getExecutableTestCases()
	{
		try {
			
			testDataFileName = Environment("moduleDriverFile");
			
			retriveTestCaseNames(testDataFileName);
			
		}catch(Exception e)
		{
			insertReportLine(e);
		}
	}

//	@BeforeTest()
//	public void beforeTest()
//	{
//		System.out.println("Inside Before Test");
//		//getExecutableTestCases();
///*		getExecutionDetails();
//*/		
////		if(testExecutionPlatform.equalsIgnoreCase("Local Machine")) {
////			StartDriver();
////		}
//		//SeleniumHelper.createTestNGxmlFile("C:\\Users\\nsahu102\\Desktop\\New folder\\Stage\\IssuesFoundDUP.xls", "C:\\Users\\nsahu102\\Desktop\\SafetripAutomation_Local Repo\\SafeTrip_Automation\\testng.xml");
//		//runTestNGxmlFile("C:\\SeleniumAutomation\\SafeTripAutomation\\SafeTripAutomation\\testng.xml");	
//		
//	}

//	@BeforeSuite
//	public void beforeSuite() throws IOException
//	{
//		System.out.println("inside Before suite");
//		/*sfAssert = new SoftAssert();
//		currentBrowser = Environment("browser");
//		reportGenerator();*/
//	}

	
//	@BeforeClass()
//	public void beforClass() 
//	{
//		System.out.println("Inside Before class");
//		//System.out.println(method.getName());
///*
//		if(testExecutionPlatform.equalsIgnoreCase("Local Machine")) {
//		StartDriver();
//		getHomePage();
//		testDriver.manage().deleteAllCookies();
//		testDriver.manage().window().maximize();
//		}*/
//	}
//	boolean isDependant;
//	boolean browserLaunched = false;
	//@Parameters({"browser","browserversion","os"})
//	@BeforeMethod
//	//public void beforMethod(@Optional("internet explorer") String browser, @Optional("11.0") String browserversion, @Optional("Windows 7") String os, Method method)
//	public void start()
//	{
//		System.out.println("Inside Before Method");	
//		/*currentTestName = method.getName();
//		isDependant = false;
//		
//	try {		
//		
//			 Test testClass = method.getAnnotation(Test.class);
//			 if(testClass.dependsOnMethods().length>0) {
//				 isDependant = true;
//			 } 
//			 
//			currentTestName = method.getName();
//			System.out.println("<*****>Started Execution of script "+currentTestName+"<*****>");
//			//StartDriver();
//			startTestForReport(browser, browserversion, os, method.getName() );
//			if(!testExecutionPlatform.equalsIgnoreCase("Local Machine")) {
//				this.createDriver(browser,browserversion, os, method.getName());
//				testDriver = this.getWebDriver();
//				currentDriver = testDriver;
//				}else
//				{
//					if(!isDependant) {
//						//clearBrowserCache(browser);
//					}
//				}
//			if(!isDependant) {
//			testDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//			testDriver.manage().deleteAllCookies();
//			testDriver.get(appURL);
//			}
////		}else
////		{
////			
////		}
//		
//		}catch(Exception e)
//		{
////			if(!e.getClass().getSimpleName().equalsIgnoreCase("SkipException"))
//			insertReportLine(e);
//		//	System.out.println(e.getClass().getSimpleName());
//		}*/
//	}
	
	
	
//	@AfterMethod
//	public void afterMethod(ITestResult result)
//	{
//		System.out.println("Inside After Method");
////		try {
////			sfAssert.assertAll();
////		}catch(Throwable t)
////		{
////			if(t.getClass().getName().contains("AssertionError"))
////			{
////				System.out.println(result.getMethod().getMethodName()+" Test case Failed");
////			}
////			Assert.fail("Assertion Error", t);
////		}
//		
//		/*System.out.println("Test Case "+result.getStatus());
//		System.out.println("<*****>Ended Execution of script "+result.getMethod().getMethodName()+"<*****>");
//		System.out.println("************************************************************************************************");
//		try {
//			//testDriver.quit();
//		attachScreenShotInHTMLreport(testDriver, result);
//		
//		finalizeReport();
//		
//	
//		if(conn!=null)
//		conn.close();
//		} catch (SQLException e) {
//			insertReportLine(e);
//		}
//		*/
//	}
//	@AfterSuite
//	public void aftersuite() 
//	{
//		System.out.println("Inside After SUite");
//		/*try {
//			
//			//System.out.println(	testDriver.getWindowHandle());
//			exceptionLogContent.flush();
//			exceptionLogContent.close();
//			reportGenerator.close();
//			System.out.print("Open the following file to get the Current execution report>>: ");
//			System.out.println(getReportFileName());
//			testDriver.get(getReportFileName());
//			
//			
//			WebElement summaryView = testDriver.findElement(By.xpath("//a[@id='enableDashboard']/i"));
//			summaryView.click();
//		
//			
//			//Thread.sleep(2000);
////			testDriver.get(getReportFileName());
////			
////			if(summaryView.isEnabled())
////			{
////				summaryView.click();
////			}
//		} catch (Exception e) {
//			insertReportLine(e);
//		}*/
//	}
	
	@DataProvider
	public Object[][] tripInfoDetails(Method method)
	{
		 testName = method.getName();
		  reportTestData = ReadDataFromExcel(testName);
		  totalIterations=reportTestData.length;	 
		  initialTIme=testStartTime();
		  return reportTestData;
	}

	public void startTestForReport(String browser, String browserVersion, String os, String testName)
	{
		if(testExecutionPlatform.equalsIgnoreCase("Local Machine"))
		{
			if(reportTestData == null)
			{
				testStatus = reportGenerator.startTest(testName);
			}
			else if(reportTestData.length>1)
			{

				if(!reportAdded) {
					testStatus = reportGenerator.startTest(testName);
					dataProviderTest = testStatus;
					reportAdded = true;
				}
					if(st!=reportTestData.length) {
						for(int j = 0; j<=reportTestData[st].length-1; j++)
						{	
							testParaMeters  +="'"+reportTestData[st][j]+"'"+", ";
						}
						st++;
						testParaMeters = testParaMeters.substring(0, testParaMeters.length()-2);
						testStatus = reportGenerator.startTest(testName+"_"+st+"("+testParaMeters+")");
						testParaMeters = "";
						dataProviderTest.appendChild(testStatus);
					}
				}else
				{
				testStatus = reportGenerator.startTest(testName);
				}
		}
		else
		{
			 SeleniumHelper.startTest(testName+"_"+os+"_"+browser+"_"+browserVersion, "THIS TEST IS PART OF CROSS_BROWSER TESTING OF "+testName+" test case");
			
		}
			
	}
	
	public void finalizeReport()
	{
		
		if(testExecutionPlatform.equalsIgnoreCase("Local Machine"))
		{
		
		//reportGenerator.endTest(this.testStatusThread.get());
			if(reportTestData == null)
			{
				reportGenerator.flush();
				reportGenerator.endTest(testStatus);
				
			}
			else if(reportTestData.length>1)
			{
				reportGenerator.flush();
				if(st==reportTestData.length)
				{
					
					reportGenerator.endTest(dataProviderTest);
					
				}
			}
			else if(reportTestData.length ==1 ){
			reportGenerator.endTest(testStatus);
			reportGenerator.flush();
			}
			
		}
		else
			{
			
				reportGenerator.flush();
				SeleniumHelper.endTest();
			}
	
		
		}
	

	public WebDriver getWebDriver() {
	        return webDriver.get();
	    }

	    public String getSessionId() {
	        return sessionId.get();
	    }
	    
	    @Override
	    public SauceOnDemandAuthentication getAuthentication() {
	        return authentication;
	    }
	    
	    protected void createDriver(String browser, String version, String os, String methodName) throws MalformedURLException, UnexpectedException {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
	        capabilities.setCapability(CapabilityType.VERSION, version);
	        capabilities.setCapability(CapabilityType.PLATFORM, os);
	        capabilities.setCapability("name", methodName+"_"+browser+"_"+version);

	        if (buildTag != null) {
	            capabilities.setCapability("build", buildTag);
	        }

	        webDriver.set(new RemoteWebDriver(new URL("https://" + authentication.getUsername() + ":" + authentication.getAccessKey() + seleniumURI +"/wd/hub"), capabilities));
	        
	        String id = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
	        sessionId.set(id);
	        
	        System.out.println("===================== Execution Started on Sauce Lab using "+browser.toUpperCase()+" browser on version "+version+" having session ID "+this.getSessionId()+" =====================");
	    }
	
		public synchronized void StartDriver()
		{	
			
			//if(testExecutionPlatform.equalsIgnoreCase("Local Machine")) {
			
				currentBrowser = "chrome";
				
				//closeDriverServers();
				//closeAllOpenedBrowsers();
				//killExcel();
				
				if(currentBrowser.equalsIgnoreCase("Firefox"))
				{
					testDriver=SeleniumHelper.launchDriver(currentBrowser,System.getProperty("user.dir")+Environment("ffDriverPath")
							,Long.parseLong(Environment("ffDefaultTestSyncTimePeriod")));	
				}
				else if(currentBrowser.equalsIgnoreCase("InternetExplorer"))
				{
					testDriver=SeleniumHelper.launchDriver(currentBrowser,System.getProperty("user.dir")+Environment("ieDriverPath")
							,Long.parseLong(Environment("ieDefaultTestSyncTimePeriod")));	
				}
				else if(currentBrowser.equals("chrome"))
				{
					testDriver=SeleniumHelper.launchDriver(currentBrowser,Environment("chromeDriverPath")
							,Long.parseLong(Environment("chromeDefaultTestSyncTimePeriod")));
				}
			
			}
	
	public synchronized void StartDriver(String browser,String browserversion, String os)
	{	
		
			currentBrowser = "InternetExplorer";
			
			closeDriverServers();
			
			closeAllOpenedBrowsers();
			
			killExcel();
			
			if(currentBrowser.equalsIgnoreCase("Firefox"))
			{
				testDriver=SeleniumHelper.launchDriver(currentBrowser,""
						,Long.parseLong(Environment("ffDefaultTestSyncTimePeriod")));	
			}
			else if(currentBrowser.equalsIgnoreCase("InternetExplorer"))
			{
				//System.out.println(Environment("ieDriverPath"));
				testDriver=SeleniumHelper.launchDriver(currentBrowser,System.getProperty("user.dir")+Environment("ieDriverPath")
						,Long.parseLong(Environment("ieDefaultTestSyncTimePeriod")));	
			}
			else if(currentBrowser.equals("chrome"))
			{
				testDriver=SeleniumHelper.launchDriver(currentBrowser,Environment("chromeDriverPath")
						,Long.parseLong(Environment("chromeDefaultTestSyncTimePeriod")));
			}
		
		}
		
			 
			
			//System.out.println(" window id of "+browser+" browser is "+this.getWebDriver().getWindowHandle());
		
	
	
	public void startReport()
	{
		  extent = new ExtentReports(System.getProperty("user.dir")+"/ExtentReport-OutPut/myreport.html", true);
		  extent.addSystemInfo("Host Name", "Sample Host")
		  .addSystemInfo("EnvironMent","Test")
		  .addSystemInfo("User", "Sample User");
		  extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
	}

	public void getHomePage()
	{
		homePage = new safetrip.pages.HomePage(testDriver); 
		
	}
	public void safetripComparisonPage()
	{
		safetripComparisonPage = new SafetripComparisonPage(testDriver);
		
	}
	
	public void getTravelerInfoPage()
	{
	
		travelerInfoPage = new TravelerInfoPage(testDriver);
	}
	
	public void getPurchaserInfoPage()
	{
	
		purchaserInfoPage = new PurchaserInfoPage(testDriver);
	}
	public void getReviewCartPage()
	{
	
		reviewCartPage = new ReviewCartPage(testDriver);
	}
	public void getCreditCardInfoPage()
	{
	
		creditCardInfoPage = new CreditCardInfoPage(testDriver);
	}
	public void getConfirmPurchasePage()
	{
		confirmPurchasePage = new ConfirmPurchasePage(testDriver);
	}
	
	

	
	
	public String testStartTime()
	{
		String startTIme=formatDateAndTime(getCurrentDateAndTime(),Environment("testTimeFormat"));
		return startTIme;
	}
	
	public String testEndTime()
	{
		String endTime=formatDateAndTime(getCurrentDateAndTime(),Environment("testTimeFormat"));
		return endTime;
	}
	
	public void updateStatus(boolean statusVal)
	{
		if(statusVal==false)
		{
			status = statusVal;
		}		 
		 currentIteration=currentIteration+1;
	}
	
	
	
	public static void runTestNGxmlFile(String testngXMLfilePath)
	{
		TestNG runner=new TestNG();
		 
		// Create a list of String 
		List<String> suitefiles=new ArrayList<String>();
		 
		// Add xml file which you have to execute
		suitefiles.add(testngXMLfilePath);
		 
		// now set xml file for execution
		runner.setTestSuites(suitefiles);
		 
		// finally execute the runner using run method
		runner.run();

	}


	
	
	
	
	
	
}
