package ru.greg3d.pages;

import org.openqa.selenium.support.FindBy;

import ru.greg3d.factory.htmlelements.ButtonsBlock;
import ru.greg3d.factory.htmlelements.CalendarPanel;
import ru.greg3d.factory.htmlelements.DatePicker;
import ru.greg3d.factory.htmlelements.FiltersByStatesContainer;
import ru.greg3d.factory.htmlelements.Grid;
import ru.greg3d.factory.htmlelements.GridPager;
import ru.greg3d.factory.htmlelements.JspTrack;
import ru.greg3d.factory.dialogs.Colchooser;
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
	
	@FindBy(css=".ui-draggable")
	public Colchooser colchooser;
	
	
	@Corrector(than="Docs")
	@FindBy(css=".grid-wrapper")
	private Grid grid;
	
	
	public Grid getGrid(){
		return grid;
	}
	
	public AllDocumentsPage(PageManager pages) {
		super(pages);
	}

	public CalendarPanel getCalendarPanel(){
		return this.calendar;
	}
	
	public DatePicker getDatePicker(){
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
