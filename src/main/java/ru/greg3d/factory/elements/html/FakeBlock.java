package ru.greg3d.factory.elements.html;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class FakeBlock extends HtmlElement{

	@FindBy(id="id")
	private JspTrack track;
	
	public JspTrack getTrack(){
		return this.track;
	}
}
