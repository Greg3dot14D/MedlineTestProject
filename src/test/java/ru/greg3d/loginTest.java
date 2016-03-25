package ru.greg3d;

import org.testng.annotations.Test;

import ru.greg3d.applogic.implementations.AllDocumentsPageHelper;
import ru.greg3d.asserts.Assert;

public class loginTest extends doLogin{

	@Test
	public void loginTest(){
		//app.getNavigationHelper().openUrl("http://ya.ru");
		//Assert.assertEquals(app.getYandexHelper().searchFirstValue("QWERTY"), "«Qwerty» — интернет-провайдер", "results not equals");
		app.getDefaultPageHelper().openAllDocuments();
		
//		AllDocumentsPageHelper h = app.getAllDocumentsPageHelper();
//		
//		app.getAllDocumentsPageHelper().Refresh();
//		app.getAllDocumentsPageHelper().Search();
//		app.getAllDocumentsPageHelper().UnSearch();
		
		app.getAllDocumentsPageHelper().testPager();
		Assert.assertTrue(true);
	}
	
}
