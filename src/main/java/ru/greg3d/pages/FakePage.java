package ru.greg3d.pages;

import org.openqa.selenium.support.FindBy;

import ru.greg3d.factory.elements.html.FakeBlock;
import ru.greg3d.factory.elements.html.JspTrack;

public class FakePage extends AnyPage{

	@FindBy(id="id")
	private JspTrack track;
	
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
