package ru.greg3d.applogic.implementations;

import ru.greg3d.applogic.interfaces.IAllDocumentsPageHelper;
import ru.greg3d.factory.elements.html.CalendarPanel;
import ru.greg3d.factory.elements.html.DatePicker;
import ru.greg3d.factory.elements.html.GridPager;
import ru.greg3d.util.WaitUtils;

public class AllDocumentsPageHelper extends DriverBasedHelper implements IAllDocumentsPageHelper{

	private ApplicationManager manager;

	public AllDocumentsPageHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
		this.manager = manager;
	}

	public void Refresh(){
		pages.allDocumentsPage.getButtons().clickRefrash();
	}
	
	public void Search(){
		pages.allDocumentsPage.getButtons().clickSearch();
	}
	
	public void UnSearch(){
		pages.allDocumentsPage.getButtons().clickSearch();
	}	
	
	public void testPager(){
		GridPager g = pages.allDocumentsPage.getGridPager();
		
//		g.selectRecordsPerPage(100);
//		g.selectRecordsPerPage(20);
//		g.selectRecordsPerPage(40);
//		g.selectRecordsPerPage(10);		
//		
//		g.getFirstPage();
//		g.getLastPage();
//		g.getPrevPage();
//		g.getNextPage();
		
		CalendarPanel cp = pages.allDocumentsPage.getCalendarPanel();
		
		cp.clickStart();
		
		DatePicker dp = pages.allDocumentsPage.getdatePicker();
		
		dp.clickDay("1");
		
		for(int i = 1; i < 10; i ++){
			cp.clickStart();
			dp.clickDay(String.valueOf(i));
		}
		
		
		while(!pages.allDocumentsPage.getTrack().HoverIsOnBottom()){
			pages.allDocumentsPage.getTrack().moveDown();
			System.out.println("move Down");
		}
		
		while(!pages.allDocumentsPage.getTrack().HoverIsOnTop()){
			pages.allDocumentsPage.getTrack().moveUp();
			System.out.println("move Up");
		}		
		
		//pages.allDocumentsPage.getFiltersByStatesContainer().getTrack().moveDown();
		
		pages.allDocumentsPage.getFiltersByStatesContainer().selectActive();
		pages.allDocumentsPage.getFiltersByStatesContainer().deselectActive();
		
		//pages.allDocumentsPage.getFiltersByStatesContainer().selectActive();
	}
}
