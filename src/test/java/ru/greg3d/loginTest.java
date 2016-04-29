package ru.greg3d;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.greg3d.applogic.implementations.AllDocumentsPageHelper;
import ru.greg3d.asserts.Assert;
import ru.greg3d.util.WaitUtils;

public class loginTest extends doLogin{

	
	@Test
	public void openAllDocumentsDone(){
		app.getDefaultPageHelper().openAllDocuments();
	}
	
	@Test(dependsOnMethods = { "openAllDocumentsDone" }, dataProvider = "allDocumentsColumnHeaderDP")
	public void testSortColumns(String headerTitle){
		app.getAllDocumentsPageHelper().sortColumn(headerTitle);
		
		//WaitUtils.delay(10000);
		
		//System.out.println("Hash :" + screenshotNotStatic.hashCode());
		
		//Assert.assertTrue(false);
		//app.getNavigationHelper().openUrl("http://ya.ru");
		//Assert.assertEquals(app.getYandexHelper().searchFirstValue("QWERTY"), "«Qwerty» — интернет-провайдер", "results not equals");
		//app.getDefaultPageHelper().openAllDocuments();
		
//		AllDocumentsPageHelper h = app.getAllDocumentsPageHelper();
//		
//		app.getAllDocumentsPageHelper().Refresh();
//		app.getAllDocumentsPageHelper().Search();
//		app.getAllDocumentsPageHelper().UnSearch();
		
		//app.getAllDocumentsPageHelper().testColChooser();
		
		//app.getAllDocumentsPageHelper().testPager();
		//Assert.assertTrue(true);
	}
	
	@DataProvider(name="allDocumentsColumnHeaderDP")
	private Object[][] AllDocumentsColumnHeaderDataProvider() {
		return app.getAllDocumentsPageHelper().getHeaderTitleList() ;
	};

}
