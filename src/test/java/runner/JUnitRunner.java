package runner;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import safetrip.tests.BaseTest;


public class JUnitRunner extends BaseTest{
	
//	@Test
//	public void t() {}
	@CucumberOptions(features= {"src/test/java/features"}, format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},glue = "stepDefination")
	public class TestRunner extends AbstractTestNGCucumberTests {
		
		
		@BeforeTest()
		public void beforeTest()
		{
			System.out.println("Inside Before Test");
			getExecutionDetails();
		}
		@BeforeSuite
		public void beforeSuite() throws IOException
		{
			System.out.println("inside Before suite");
			sfAssert = new SoftAssert();
			currentBrowser = Environment("browser");
			reportGenerator();
		}

		
		@BeforeClass()
		public void beforClass() 
		{
			System.out.println("Inside Before class");
			
		}		
		@AfterSuite
		public void aftersuite() 
		{
			System.out.println("Inside aftersuite");
			try {
			
			//System.out.println(	testDriver.getWindowHandle());
			exceptionLogContent.flush();
			exceptionLogContent.close();
			reportGenerator.close();
			System.out.print("Open the following file to get the Current execution report>>: ");
			System.out.println(getReportFileName());
			//testDriver.get(getReportFileName());
			
			
			//WebElement summaryView = testDriver.findElement(By.xpath("//a[@id='enableDashboard']/i"));
			//summaryView.click();
		
			
			//Thread.sleep(2000);
//			testDriver.get(getReportFileName());
//			
//			if(summaryView.isEnabled())
//			{
//				summaryView.click();
//			}
		} catch (Exception e) {
			insertReportLine(e);
		}
		}
		
		

	}
	

}
