package ru.greg3d.factory.htmlelements;

import org.openqa.selenium.support.FindBy;

//import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.greg3d.yandex.corrected.qatools.htmlelements.element.MyHtmlElement;


import ru.yandex.qatools.htmlelements.element.Button;

public class ShadowPagerLeft extends MyHtmlElement{

	@FindBy(css=".ui-icon-seek-first")
	private Button first;
	
	@FindBy(css=".ui-icon-seek-prev")
	private Button prev;
	
	public void clickFirst(){
		this.first.click();
	}
	
	public void clickPrev(){
		this.prev.click();
	}
}
