package ru.greg3d.applogic.implementations;

import ru.greg3d.applogic.interfaces.INavigationHelper;
import ru.greg3d.util.WaitUtils;

public class NavigationHelper extends DriverBasedHelper implements INavigationHelper {

	private String baseUrl;

	public NavigationHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
		this.baseUrl = manager.getBaseUrl();
	}

	@Override
	public void openMainPage() {
		driver.get(baseUrl);
	}
	
	@Override
	public void openUrl(String url){
		driver.get(url);
	}
	
	@Override
	public void openRelativeUrl(String url) {
		driver.get(baseUrl + url);
	}

}
