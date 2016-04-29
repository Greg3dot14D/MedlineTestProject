package ru.greg3d.factory.dialogs;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class Export extends AbstractDialog{

	@FindBy(id="low")
	private TextInput low;
	
	@FindBy(id="up")
	private TextInput up;
	
	@FindBy(id="ch")
	private Select choise;
	
	@FindBy(xpath="//button[text()='Отмена']")
	private Button bCancel;

	@FindBy(xpath="//button[text()='Продолжить']")
	private Button bContinue;	
	
	public void clickContinue(){
		this.bContinue.click();
	}
	
	public void clickCancel(){
		this.bCancel.click();
	}
	
	public Export setFrom(String keys){
		this.low.clear();
		this.low.sendKeys(keys);
		return this;
	}
	
	public Export setTo(String keys){
		this.up.clear();
		this.up.sendKeys(keys);
		return this;
	}
	
	public Export setFormat(String value){
		this.choise.selectByValue(value);
		return this;
	}
}
