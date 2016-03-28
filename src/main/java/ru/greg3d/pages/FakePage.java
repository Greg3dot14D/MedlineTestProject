package ru.greg3d.pages;

import org.openqa.selenium.support.FindBy;

import ru.greg3d.factory.elements.html.FakeBlock;
import ru.greg3d.factory.elements.html.JspTrack;
import ru.yandex.qatools.htmlelements.annotations.Timeout;

public class FakePage extends AnyPage{

	@Timeout(4)
	@FindBy(id="id")
	private JspTrack track;
	
	@Timeout(4)
	@FindBy(id="id")
	private FakeBlock block;
	
	public FakePage(PageManager pages) {
		super(pages);
	}

	public JspTrack getTrack(){
		return this.track;
	}
	
	public FakeBlock getBlock(){
		return this.block;
	}
}
