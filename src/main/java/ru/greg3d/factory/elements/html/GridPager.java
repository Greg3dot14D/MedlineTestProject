package ru.greg3d.factory.elements.html;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

//@Corrector(what="FAKE")
public class GridPager extends HtmlElement{

	@FindBy(css=".ui-pg-selbox")
	private Select recordsPerPage;
	
	@FindBy(css=".ui-pg-input")
	private TextInput currentPageNum;
	
	@FindBy(css=".shadow-pager-left")
	private ShadowPagerLeft shadowPagerLeft;
	
	@FindBy(css=".shadow-pager-right")
	private ShadowPagerRight shadowPagerRight;
	
	public void selectRecordsPerPage(int value){
		this.recordsPerPage.selectByValue(String.valueOf(value));
	}
	
	public void getLastPage(){
		this.shadowPagerRight.clickLast();
	}
	
	public void getNextPage(){
		this.shadowPagerRight.clickNext();
	}
	
	public void getFirstPage(){
		this.shadowPagerLeft.clickFirst();
	}
	
	public void getPrevPage(){
		this.shadowPagerLeft.clickPrev();
	}
}
