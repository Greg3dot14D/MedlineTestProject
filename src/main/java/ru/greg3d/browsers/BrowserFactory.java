package ru.greg3d.browsers;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import ru.greg3d.util.CapabilitiesLoader;
import ru.greg3d.util.PropertyLoader;
import ru.greg3d.util.WaitUtils;
import ru.stqa.selenium.factory.WebDriverFactory;

//import io.appium.java_client.*;
//import io.appium.java_client.android.AndroidDriver;

public class BrowserFactory {

	public static WebDriver getBrowser() {
		return getBrowser(null);
	}

	public static WebDriver getBrowser(String capabilitiesName) {
		WebDriver driver;

		String capabilitiesJsonFile = PropertyLoader.loadProperty("capabilities.json");

		DesiredCapabilities cap = null;
		try {
			cap = CapabilitiesLoader.loadCapabilities(
					BrowserFactory.class.getResource("/" + capabilitiesJsonFile).getFile(), capabilitiesName);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		/* Под Linux Firefox не умеет корректно обрабатывать нативные события 
		cap.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
		*/

		cap.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
		
		switch (cap.getBrowserName()) {
		// вставляем костыли, если они требуются в проекте
		case "internet explorer":
			driver = init(cap);
			Keyboard Kb = ((HasInputDevices)driver).getKeyboard();
	        Kb.sendKeys(Keys.F12);
	        WaitUtils.delay(5000);				
			break;
		default:
			driver = init(cap);
			break;

		}
		afterCreateBrowserSetup(driver, cap);
		return driver;
	}

	private static void afterCreateBrowserSetup(WebDriver driver, DesiredCapabilities cap) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		try {
			if (cap.getCapability("platformName").toString().toLowerCase().equals("android"))
				return;
		} catch (NullPointerException e) {
		}

		String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
		if (!("".equals(gridHubUrl) || gridHubUrl.equals(null))) {
			driver.manage().window().setPosition(new Point(0, 0));
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
			driver.manage().window().setSize(dim);
		} else
			driver.manage().window().maximize();
	}

	// Слизано у Баранцева, настроки считываются из файла
	// "application.properties" или из POM
	public static WebDriver init(DesiredCapabilities capabilities){
		WebDriver driver = null;

		
		//String gridHubUrl = "";
		String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
		
		//String browserVersion = PropertyLoader.loadProperty("browser.version");
		//String platform = PropertyLoader.loadProperty("browser.platform");
		//String browserName = PropertyLoader.loadProperty("browser.name");

//		if (("".equals(capabilities.getBrowserName()) || capabilities.getBrowserName() == null)
//				&& !"".equals(browserName))
//			capabilities.setBrowserName(browserName);
//		if (!"".equals(browserVersion))
//			capabilities.setVersion(browserVersion);
//		if (!(null == platform || "".equals(platform)))
//			capabilities.setPlatform(Platform.valueOf(platform));
	
		if (!(null == gridHubUrl || "".equals(gridHubUrl))) {
			driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
		} else {
			driver = WebDriverFactory.getDriver(capabilities);
		}
		
		return driver;
	}

	private static boolean isAndroid(DesiredCapabilities cap){
		try{
			//if(cap.getPlatform().equals(cap.getPlatform().ANDROID))
			if(cap.getCapability("platformName").toString().toUpperCase().equals("ANDROID"))
				return true;
		}catch(NullPointerException e){}
		return false;
	}
	
}
