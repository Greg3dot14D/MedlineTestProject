package ru.greg3d.factory.htmlelements;

import org.openqa.selenium.support.FindBy;

//import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.greg3d.yandex.corrected.qatools.htmlelements.element.MyHtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class CalendarPanel extends MyHtmlElement{

	@FindBy(id="start")
	private TextInput start;
	
	@FindBy(id="finish")
	private TextInput finish;
	
	public CalendarPanel clickStart(){
		start.getWrappedElement().click();
		return this;
	}
	
	public CalendarPanel clickFinish(){
		finish.getWrappedElement().click();
		return this;
	}
}
