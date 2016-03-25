package ru.greg3d.factory.elements.html;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class CalendarPanel extends HtmlElement{

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
