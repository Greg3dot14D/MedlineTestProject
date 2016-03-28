package ru.greg3d.factory.elements.html;

import org.openqa.selenium.support.FindBy;

import ru.greg3d.yandex.corrected.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Button;
//import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class ShadowPagerRight extends HtmlElement{

	@FindBy(css=".ui-icon-seek-end")
	private Button last;
	
	@FindBy(css=".ui-icon-seek-next")
	private Button next;
	
	public void clickLast(){
		this.last.click();
	}
	
	public void clickNext(){
		this.next.click();
	}
}
