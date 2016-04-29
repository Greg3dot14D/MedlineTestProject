package ru.greg3d;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import ru.greg3d.applogic.implementations.*;
import ru.greg3d.util.LogUtils;

//import com.microsoft.sqlserver.jdbc.*;

@Listeners({TestBase.LogListener.class})
public class TestBase {
	
	protected static LogUtils screenshot;
	
	protected ApplicationManager app;

	protected static Logger LOG = LoggerFactory.getLogger(TestBase.class);

	

	//@BeforeSuite
	//@BeforeTest
	@Parameters({"capabilities"})
	public void SuiteSetup(String capabilities) {
		
		
		LogListener l = new LogListener();
		
		app = new ApplicationManager(capabilities);
		screenshot = new LogUtils(app.getWebDriver());
		screenshot.setCapabilityName(capabilities);
		screenshot.setFolderName("./Screenshots/");
	}
	
	@BeforeTest
	public void SuiteSetup() {
		String capabilityName = "chrome"; 
		
		//app = new ApplicationManager("JIAYU G4S");
		//app = new ApplicationManager("android_browser");
		//app = new ApplicationManager("android_chrome");
		//app = new ApplicationManager("firefox");
		//app = new ApplicationManager("internetExplorer");
		//app = new ApplicationManager("chrome");
		//app = new ApplicationManager("fake");
		//Assert.ignore("Skip");
		
		app = new ApplicationManager(capabilityName);
		screenshot = new LogUtils(app.getWebDriver());
		screenshot.setCapabilityName(capabilityName);
		screenshot.setFolderName("./Screenshots/");
	}	
	
	//@AfterSuite(alwaysRun = true)
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		app.stop();
	}
	
	public static class LogListener implements IInvokedMethodListener{
		@Override
		public void afterInvocation(IInvokedMethod m, ITestResult res) {
			//			LOG.info("<<< @Test " + m.getTestMethod().getMethodName());
			String logResult = String.format("<<< @Test [%2s] delay: %2d ms",m.getTestMethod().getMethodName(),(m.getTestResult().getEndMillis() - m.getTestResult().getStartMillis()));
			
			switch(m.getTestResult().getStatus()){
			case 2:
				LOG.error(logResult + " <<< failed <<< {}",screenshot.getScreenshot(m.getTestMethod().getMethodName()));
				break;
			case 3:
				LOG.warn(logResult + " <<< skipped");
				break;
			default:
				LOG.info(logResult + " <<< passed");
				break;
			}
		}

		@Override
		public void beforeInvocation(IInvokedMethod m, ITestResult res) {
			LOG.info(">>> @Test " + m.getTestMethod().getMethodName());
		}
	}
}
