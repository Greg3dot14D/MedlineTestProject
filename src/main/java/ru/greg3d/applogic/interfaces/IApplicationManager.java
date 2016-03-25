package ru.greg3d.applogic.interfaces;

import ru.greg3d.applogic.implementations.AllDocumentsPageHelper;
import ru.greg3d.applogic.implementations.DefaultPageHelper;
import ru.greg3d.applogic.implementations.FakePageHelper;
import ru.greg3d.applogic.implementations.LoginHelper;
import ru.greg3d.applogic.implementations.NavigationHelper;

public interface IApplicationManager {

	NavigationHelper getNavigationHelper();

	void stop();

	LoginHelper getLoginHelper();
	DefaultPageHelper getDefaultPageHelper();
	AllDocumentsPageHelper getAllDocumentsPageHelper();

	FakePageHelper getFakePageHelper();
}
