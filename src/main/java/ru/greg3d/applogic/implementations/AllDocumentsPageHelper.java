package ru.greg3d.applogic.implementations;

import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.Assert;

//import junit.framework.Assert;
import ru.greg3d.applogic.interfaces.IAllDocumentsPageHelper;
import ru.greg3d.factory.htmlelements.CalendarPanel;
import ru.greg3d.factory.htmlelements.DatePicker;
import ru.greg3d.factory.htmlelements.GridPager;
import ru.greg3d.matchers.SortIconMatcher;
import ru.greg3d.util.WaitUtils;

public class AllDocumentsPageHelper extends DriverBasedHelper implements IAllDocumentsPageHelper {

	private ApplicationManager manager;

	public AllDocumentsPageHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
		this.manager = manager;
	}

	public void Refresh() {
		pages.allDocumentsPage.getButtons().clickRefrash();
	}

	public void Search() {
		pages.allDocumentsPage.getButtons().clickSearch();
	}

	public void UnSearch() {
		pages.allDocumentsPage.getButtons().clickSearch();
	}

	public void testColChooser() {

		pages.allDocumentsPage.getButtons().clickEditCols();

		for (int i = 0; i < 3; i++)
			System.out.println("Col :" + pages.allDocumentsPage.colchooser.getColNameByIndex(i));

		for (int i = 5; i > 5; i--)
			pages.allDocumentsPage.colchooser.moveOverByIndex(i, i + 2);
	}

	public void testPager() {
		GridPager g = pages.allDocumentsPage.getGridPager();

		// g.selectRecordsPerPage(100);
		// g.selectRecordsPerPage(20);
		// g.selectRecordsPerPage(40);
		// g.selectRecordsPerPage(10);
		//
		// g.getFirstPage();
		// g.getLastPage();
		// g.getPrevPage();
		// g.getNextPage();

		CalendarPanel cp = pages.allDocumentsPage.getCalendarPanel();

		cp.clickStart();

		DatePicker dp = pages.allDocumentsPage.getDatePicker();

		dp.clickDay("1");

		for (int i = 1; i < 10; i++) {
			cp.clickStart();
			dp.clickDay(String.valueOf(i));
		}

		while (!pages.allDocumentsPage.getTrack().HoverIsOnBottom()) {
			pages.allDocumentsPage.getTrack().moveDown();
			System.out.println("move Down");
		}

		while (!pages.allDocumentsPage.getTrack().HoverIsOnTop()) {
			pages.allDocumentsPage.getTrack().moveUp();
			System.out.println("move Up");
		}

		// pages.allDocumentsPage.getFiltersByStatesContainer().getTrack().moveDown();

		pages.allDocumentsPage.getFiltersByStatesContainer().selectActive();
		pages.allDocumentsPage.getFiltersByStatesContainer().deselectActive();

		// pages.allDocumentsPage.getFiltersByStatesContainer().selectActive();
	}

	
	//
	// Возвращает массив с названиями заголовков Грида, в формате Object[][] (используется как DataProvider для тестов)
	//
	public Object[][] getHeaderTitleList() {
		return pages.allDocumentsPage.getGrid().getHeaderTitleList()
				.stream()
				.map(a -> new Object[] { a.toString() })
				.toArray(Object[][]::new);

	}

		//
		// Процедура :
		// 		- кликает по колонке с названием headerTitle,
		//		- проверяет появление значка сортировки,
		//		- проверяет сортировку по возрастанию,
		// 		- кликает повторно по колонке,
		//		- проверяет сортировку по убыванию
		//
	public void sortColumn(String headerTitle) {
		// TODO Auto-generated method stub
		if (!"".equals(headerTitle.trim())) {
			// если колонка НЕ отсортирована по возрастанию
			if (!pages.allDocumentsPage.getGrid().sortIsAsc(headerTitle)) {
				pages.allDocumentsPage.getGrid().clickHeader(headerTitle);
				//assertThat(pages.allDocumentsPage.getGrid().getHeaderSortIcon(headerTitle),  SortIconMatcher.isDisplayed());
				assertThat(pages.allDocumentsPage.getGrid().getHeaderSortIcon(headerTitle), SortIconMatcher.sortIsAsc());
				Assert.assertTrue(pages.allDocumentsPage.getGrid().verifySortAsc(headerTitle));
			}
			// если колонка НЕ отсортирована по убыванию
			if (!pages.allDocumentsPage.getGrid().sortIsDesc(headerTitle)){
				pages.allDocumentsPage.getGrid().clickHeader(headerTitle);
				
				assertThat(pages.allDocumentsPage.getGrid().getHeaderSortIcon(headerTitle), SortIconMatcher.sortIsDesc());
				Assert.assertTrue(pages.allDocumentsPage.getGrid().verifySortDesc(headerTitle));				
			}
		}
	}
	
	public void testGarbage(){
		// String headerTitle =
		// pages.allDocumentsPage.getGrid().getHeaderTitleList().get(3);
		//
		// System.out.println(headerTitle);
		//
		// System.out.println( "is asc " +
		// pages.allDocumentsPage.getGrid().isAsc(headerTitle));
		//
		// pages.allDocumentsPage.getGrid().clickHeader(headerTitle);
		//
		// System.out.println( "is asc " +
		// pages.allDocumentsPage.getGrid().isAsc(headerTitle));
		//
		// pages.allDocumentsPage.getGrid().clickHeader(headerTitle);

		// pages.allDocumentsPage.getGrid(). .getHeaderTitleList().get(3)
	}
}
