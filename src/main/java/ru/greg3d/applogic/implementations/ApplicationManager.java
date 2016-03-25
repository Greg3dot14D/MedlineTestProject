package ru.greg3d.applogic.implementations;

import org.openqa.selenium.WebDriver;

import ru.greg3d.applogic.interfaces.IApplicationManager;
import ru.greg3d.applogic.interfaces.INavigationHelper;
import ru.greg3d.browsers.BrowserDriver;
import ru.greg3d.browsers.TracingWebDriver;
import ru.greg3d.factory.fake.fakeDriver;
import ru.greg3d.util.*;

public class ApplicationManager implements IApplicationManager {

	private NavigationHelper navHelper;
	private LoginHelper loginHelper;
	private DefaultPageHelper defaultPageHelper;
	private AllDocumentsPageHelper allDocumentsPageHelper;

	private FakePageHelper fakePageHelper;
	
	private WebDriver driver;
	private String baseUrl;

	public ApplicationManager(){
		this(null);
	}
	
	public ApplicationManager(String capabilitiesName) {
		this.baseUrl = PropertyLoader.loadProperty("site.url");
		
		if(capabilitiesName.toLowerCase().equals("fake"))
			driver = fakeDriver.getDriver();
		else
			driver = new TracingWebDriver(BrowserDriver.getEventFiringWebDriver(BrowserDriver.newDriver(capabilitiesName)));		
		//driver = new TracingWebDriver(BrowserDriver.newDriver(capabilitiesName));
		
		loginHelper = new LoginHelper(this);
		navHelper = new NavigationHelper(this);
		defaultPageHelper = new DefaultPageHelper(this);
		allDocumentsPageHelper = new AllDocumentsPageHelper(this);

		fakePageHelper = new FakePageHelper(this);
		
		getNavigationHelper().openMainPage();
	}

	@Override
	public FakePageHelper getFakePageHelper() {
		return fakePageHelper;
	}
	
	@Override
	public LoginHelper getLoginHelper() {
		return loginHelper;
	}

	@Override
	public DefaultPageHelper getDefaultPageHelper() {
		return defaultPageHelper;
	}	
	
	@Override
	public NavigationHelper getNavigationHelper() {
		return navHelper;
	}

	@Override
	public AllDocumentsPageHelper getAllDocumentsPageHelper() {
		// TODO Auto-generated method stub
		return allDocumentsPageHelper;
	}

	protected WebDriver getWebDriver() {
		return driver;
	}

	protected String getBaseUrl() {
		return baseUrl;
	}

	@Override
	public void stop() {
		if (driver != null) {
			driver.quit();
		}
	}


}
