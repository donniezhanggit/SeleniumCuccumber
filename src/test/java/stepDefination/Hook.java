package stepDefination;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
//import gherkin.formatter.model.Feature;
import safetrip.tests.BaseTest;

public class Hook extends BaseTest{

	boolean isDependant;
	boolean browserLaunched = false;
	public static int scenarioCount = 1;
	@Parameters({"browser","browserversion","os"})
	@Before
	public void beforMethod(Scenario method) {

		System.out.println(method.getName());
		System.out.println("Inside Before");
		currentTestName = method.getName();
		isDependant = false;

		try {
			currentTestName = method.getName();
			System.out.println("<*****>Started Execution of script " + currentTestName + "<*****>");
			if (scenarioCount == 1 || scenarioCount == 10) {
				if(testDriver!=null)
				{
					testDriver.quit();
				}
				StartDriver();
				scenarioCount = 2;
			} else {
				scenarioCount++;
			}
			startTestForReport(Environment("browser"), Environment("browserVersion"), Environment("OperatingSystem"),
					method.getName());
			if (!testExecutionPlatform.equalsIgnoreCase("Local Machine")) {
				this.createDriver(Environment("browser"), Environment("browserVersion"), Environment("OperatingSystem"),
						method.getName());
				testDriver = this.getWebDriver();
				currentDriver = testDriver;
			}
			testDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			testDriver.manage().deleteAllCookies();
			//testDriver.get(appURL);

		} catch (Exception e) {
			insertReportLine(e);
		}
	}

	@After
	public void after(Scenario result)
	{
		//testDriver.quit();
		System.out.println("Inside After");
		System.out.println("Test Case "+result.getStatus());
		System.out.println("<*****>Ended Execution of script "+result.getName()+"<*****>");
		System.out.println("************************************************************************************************");
		try {
			//testDriver.quit();
		attachScreenShotInHTMLreport(testDriver, result);
		
		finalizeReport();
		
	
		if(conn!=null)
		conn.close();
		} catch (SQLException e) {
			insertReportLine(e);
		}
//		
	}
	
	
	
}
