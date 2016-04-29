package ru.greg3d.factory.htmlelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

//import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.greg3d.yandex.corrected.qatools.htmlelements.element.MyHtmlElement;

public class JspTrack extends MyHtmlElement{
	
	@FindBy(css=".jspTrack")
	private WebElement Track;
	
	@FindBy(css=".jspDrag")
	private WebElement Hover;
	
	private int getTop(){
		String [] split = Hover.getAttribute("style").split("top: ");
		if(split.length < 2)
			return 0;
		else
			return Integer.parseInt(split[1].replace("px;", ""));	
	}
	
	public boolean HoverIsOnTop(){
		return getTop() == 0;  
	}
	
	public boolean HoverIsOnBottom(){
		return (Track.getSize().getHeight() - Hover.getSize().getHeight()) == getTop(); 
	}
	
	public void moveDown(){
		new Actions(this.getWrappedDriver())
			.clickAndHold(Hover)
			.moveByOffset(0, (Hover.getSize().getHeight()))
			.release()
			.perform();
	}
	
	public void moveUp(){
		new Actions(this.getWrappedDriver())
			.clickAndHold(Hover)
			.moveByOffset(0, -(Hover.getSize().getHeight()))
			.release()
			.perform();
	}	
}
