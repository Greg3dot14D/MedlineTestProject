package ru.greg3d.factory.elements.html;

import org.openqa.selenium.support.FindBy;

import ru.greg3d.factory.fielddecorator.model.Corrector;
import ru.greg3d.yandex.corrected.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Button;
//import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Corrector(what="FAKE")
public class ButtonsBlock extends HtmlElement{

	@FindBy(id="btn_forGrid_refreshFAKEGrid")
	//@FindBy(xpath=".//button[@title='Обновить']")
	private Button refresh;

	//@FindBy(xpath=".//button[@title='Поиск']")
	@FindBy(id="btn_forGrid_searchFAKEGrid")
	private Button search;
	
	public void clickRefrash(){
		this.refresh.click();
	}	
	
	public void clickSearch(){
		this.search.click();
	}
}
