package ru.greg3d.factory.elements.html;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.SpecCheckBox;

public class FiltersByStatesContainer extends HtmlElement{

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
		this.active.cheatSelect();
		//this.active.select();
		//this.deleted.select();
	}
	
	public void deselectActive(){
		//this.active.deselect();
		this.active.cheatDeselect();
	}
	
	public JspTrack getTrack(){
		return track;
	}
}
