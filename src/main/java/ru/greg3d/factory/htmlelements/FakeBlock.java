package ru.greg3d.factory.htmlelements;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.*;
//import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.greg3d.yandex.corrected.qatools.htmlelements.element.MyHtmlElement;
import ru.yandex.qatools.htmlelements.annotations.Timeout;



public class FakeBlock extends MyHtmlElement{

	@Timeout(4)
	@FindBy(id="id")
	private JspTrack track;
	
	public JspTrack getTrack(){
		return this.track;
	}
}
