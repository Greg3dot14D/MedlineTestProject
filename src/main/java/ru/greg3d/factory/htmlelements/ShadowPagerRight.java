package ru.greg3d.factory.htmlelements;

import org.openqa.selenium.support.FindBy;

//import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.greg3d.yandex.corrected.qatools.htmlelements.element.MyHtmlElement;
import ru.yandex.qatools.htmlelements.element.Button;


public class ShadowPagerRight extends MyHtmlElement{

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
