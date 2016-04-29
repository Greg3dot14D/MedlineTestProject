package ru.greg3d.factory.htmlelements;

import org.openqa.selenium.support.FindBy;

//import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.greg3d.yandex.corrected.qatools.htmlelements.element.MyHtmlElement;
import ru.greg3d.yandex.corrected.qatools.htmlelements.element.SpecCheckBox;
import ru.yandex.qatools.htmlelements.annotations.Name;


public class FiltersByStatesContainer extends MyHtmlElement{

	@Name("Активен")
	@FindBy(id="sts_2")
	private SpecCheckBox active;
	
	@Name("Удален")
	@FindBy(id="sts_11")
	private SpecCheckBox deleted;	
	
	@FindBy(css=".jspVerticalBar")
	private JspTrack track;
	
	// возвращает true, если чекбокс выбран
	// document.getElementById('inout_all').checked;
	// 
	// выбираем чекбокс
	// document.getElementById('inout_all').parentNode.click();
	// или
	// document.getElementById('inout_all').parentNode.getElementsByTagName('span')[0].click();
	
	public void selectActive(){
		//this.active.cheatSelect();
		//this.active.select();
		//this.deleted.select();
	}
	
	public void deselectActive(){
		//this.active.deselect();
		//this.active.cheatDeselect();
	}
	
	public JspTrack getTrack(){
		return track;
	}
}
