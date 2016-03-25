package ru.greg3d.applogic.implementations;

import ru.greg3d.applogic.interfaces.IDefaultPageHelper;

public class DefaultPageHelper extends DriverBasedHelper implements IDefaultPageHelper {

	private ApplicationManager manager;

	public DefaultPageHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
		this.manager = manager;
	}	
	
	public void openAllDocuments(){
		pages.defaultPage.clickHrefAllDocuments();
	}
	
}
