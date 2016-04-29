package ru.greg3d.factory.dialogs;

import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import ru.greg3d.yandex.corrected.qatools.htmlelements.element.MyHtmlElement;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class Colchooser extends AbstractDialog{

	@FindBy(xpath="//button[text()='Сохранить']")
	private Button bSave;
	
	@FindBy(xpath="//button[text()='Отмена']")
	private Button bCancel;

	@FindBy(xpath="//button[text()='По умолчанию']")
	private Button bDefault;	
	
	@FindBy(css=".ui-state-default.ui-element")
	private List<HtmlElement> elementList;
	
	public void clickSave(){
		this.bSave.click();
	}
	
	public void clickCancel(){
		this.bCancel.click();
	}
	
	public void clickDefault(){
		this.bDefault.click();
	}
	
	public List<HtmlElement> getColList(){
		return this.elementList;
	}
	
	public String getColNameByIndex(int index){
		return this.elementList.get(index).getText();
	}
	
	private HtmlElement getHtmlElementByText(String text){
		for(HtmlElement htmlElemet: this.elementList){
			if (htmlElemet.getText().equals(text))
				return htmlElemet;
		}
		return null;
	}
	
	private HtmlElement getHtmlElementByIndex(int index){
		if(this.elementList.size() == 0)
			return null;
		return this.elementList.get(index);
	}
	
	public void moveOverByIndex(int indexSource, int indexTarget){
		System.out.println("dragAndDrop : " + getHtmlElementByIndex(indexSource).getText() + " on " + getHtmlElementByIndex(indexTarget).getText());
		new Actions(this.getWrappedDriver())
			.dragAndDrop(getHtmlElementByIndex(indexSource).getWrappedElement(), getHtmlElementByIndex(indexTarget).getWrappedElement())
			.perform();
//			.clickAndHold(getHtmlElementByIndex(indexSource).getWrappedElement())
//			.moveByOffset(0, (Hover.getSize().getHeight()))
//			.release()
//			.perform();
	}
}
