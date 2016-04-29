package ru.greg3d.factory.htmlelements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import ru.greg3d.util.Fields;
//import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.greg3d.yandex.corrected.qatools.htmlelements.element.MyHtmlElement;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

import ru.yandex.qatools.htmlelements.element.Select;

public class DatePicker extends MyHtmlElement{

	// это xpath кнопки с датой a[.="1"]

	@FindBy(css=".ui-datepicker-prev")
	private Button prevButton;
	
	@FindBy(css=".ui-datepicker-next")
	private Button nextButton;
	
	@FindBy(css=".ui-datepicker-current")
	private Button currentDay;
	
	@FindBy(css=".ui-datepicker-close")
	private Button close;
	
	@FindBy(css=".ui-datepicker-month")
	private Select selectMonth;
	
	@FindBy(css=".ui-datepicker-year")
	private Select selectYear;
	
	@Name("1")
	@FindBy(xpath="//a[.='1']")
	private Button day1;
	
	@Name("2")
	@FindBy(xpath="//a[.='2']")
	private Button day2;	
	
	@Name("3")
	@FindBy(xpath="//a[.='3']")
	private Button day3;	

	@Name("4")
	@FindBy(xpath="//a[.='4']")
	private Button day4;	

	@Name("5")
	@FindBy(xpath="//a[.='5']")
	private Button day5;	
	
	@Name("6")
	@FindBy(xpath="//a[.='6']")
	private Button day6;		
	
	@Name("7")
	@FindBy(xpath="//a[.='7']")
	private Button day7;		

	@Name("8")
	@FindBy(xpath="//a[.='8']")
	private Button day8;		

	@Name("9")
	@FindBy(xpath="//a[.='9']")
	private Button day9;		
	
	@Name("10")
	@FindBy(xpath="//a[.='10']")
	private Button day10;		

	
	public DatePicker clickPrevButton(){
		this.prevButton.click();
		return this;
	}
	
	public DatePicker clickNextButton(){
		this.nextButton.click();
		return this;
	}	
	
	public void clickCloseButton(){
		this.close.click();
	}
	
	public void clickCurrentDayButton(){
		this.currentDay.click();
	}
	public Select getSelectMonth(){
		return this.selectMonth;
	}
	
	public Select getSelectYear(){
		return this.selectYear;
	}	
	
	public void clickDay(String annotationName){
//		((Button) Fields.getFieldByAnnotationName(
//				this, annotationName)).click();
		this.getWrappedDriver().findElement(By.xpath("//a[.='" + annotationName + "']")).click();
	}
	
	public void clickDayByAnnotation(String annotationName){
		((Button) Fields.getFieldByAnnotationName(
				this, annotationName)).click();
	}	
}
