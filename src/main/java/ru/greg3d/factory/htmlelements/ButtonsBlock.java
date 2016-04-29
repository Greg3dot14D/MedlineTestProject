package ru.greg3d.factory.htmlelements;

import org.openqa.selenium.support.FindBy;

import ru.greg3d.factory.fielddecorator.model.Corrector;
//import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.greg3d.yandex.corrected.qatools.htmlelements.element.MyHtmlElement;
import ru.yandex.qatools.htmlelements.element.Button;


@Corrector(what="FAKE")
public class ButtonsBlock extends MyHtmlElement{

	@FindBy(id="btn_forGrid_EditColsFAKEGrid")
	private Button editCols;
	
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
	
	public void clickEditCols(){
		this.editCols.click();
	}
}
