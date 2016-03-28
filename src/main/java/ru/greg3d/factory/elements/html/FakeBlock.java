package ru.greg3d.factory.elements.html;

import org.openqa.selenium.support.FindBy;

import ru.greg3d.yandex.corrected.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
//import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class FakeBlock extends HtmlElement{

	@Timeout(4)
	@FindBy(id="id")
	private JspTrack track;
	
	public JspTrack getTrack(){
		return this.track;
	}
}
