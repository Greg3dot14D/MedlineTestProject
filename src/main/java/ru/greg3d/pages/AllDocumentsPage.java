package ru.greg3d.pages;

import org.openqa.selenium.support.FindBy;

import ru.greg3d.factory.elements.html.ButtonsBlock;
import ru.greg3d.factory.elements.html.CalendarPanel;
import ru.greg3d.factory.elements.html.DatePicker;
import ru.greg3d.factory.elements.html.FiltersByStatesContainer;
import ru.greg3d.factory.elements.html.GridPager;
import ru.greg3d.factory.elements.html.JspTrack;
import ru.greg3d.factory.fielddecorator.model.Corrector;

public class AllDocumentsPage extends AnyPage {

	@Corrector(than="Docs")
	@FindBy(css=".many-buttons.block-content")
	private ButtonsBlock buttons;
	
	@FindBy(id="DocsGridPager")
	private GridPager gridPager;
	
	
	@FindBy(id="ui-accordion-filters-panel-0")
	private JspTrack track;
	
	@FindBy(id="ui-accordion-filters-panel-0")
	private FiltersByStatesContainer filtersByStatesContainer;
	
	
	@FindBy(css=".calendar")
	private CalendarPanel calendar;
	
	@FindBy(id="ui-datepicker-div")
	private DatePicker datePicker;
	
	public AllDocumentsPage(PageManager pages) {
		super(pages);
	}

	public CalendarPanel getCalendarPanel(){
		return this.calendar;
	}
	
	public DatePicker getdatePicker(){
		return this.datePicker;
	}
	
	public ButtonsBlock getButtons(){
		return this.buttons;
	}
	
	public GridPager getGridPager(){
		return this.gridPager;
	}
	
	public FiltersByStatesContainer getFiltersByStatesContainer(){
		return this.filtersByStatesContainer;
	}
	
	public JspTrack getTrack(){
		return track;
	}
}
