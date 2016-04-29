package ru.greg3d.factory.fake;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FakeSearchIcon{

	private WebElement element;
	
	public FakeSearchIcon(){
		element = mock(WebElement.class);
	}
	
	public WebElement getVisibleSearchIcon(){
		when(element.isDisplayed()).thenReturn(true);
		return element;
	}
	
	public WebElement getInvisibleSearchIcon(){
		when(element.isDisplayed()).thenReturn(false);
		return element;
	}
	
	public WebElement getSortAsc(){
		List<WebElement> l = new ArrayList<WebElement>();
		l.add(null);
		//when(element.isDisplayed()).thenReturn(true);
		when(element.findElements(By.cssSelector(".ui-icon-desc.ui-state-disabled"))).thenReturn(l);
		return element;
	}
	
	public WebElement getSortDesc(){
		List<WebElement> l = new ArrayList<WebElement>();
		l.add(null);
		when(element.isDisplayed()).thenReturn(true);
		when(element.findElements(By.cssSelector(".ui-icon-asc.ui-state-disabled"))).thenReturn(l);
		return element;
	}	
}
