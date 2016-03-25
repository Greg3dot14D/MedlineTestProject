package ru.greg3d.applogic.interfaces;

import ru.greg3d.model.User;

public interface ILoginHelper {

	void loginAs(User user);
	void logout();
	boolean isLoggedIn();
//	boolean isLoggedInAs(User user);
//	boolean isNotLoggedIn();
}
