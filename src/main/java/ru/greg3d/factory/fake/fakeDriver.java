package ru.greg3d.factory.fake;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fakeDriver {
	private WebDriver driver = mock(WebDriver.class);
	private WebElement element = mock(WebElement.class);
	@SuppressWarnings("unchecked")
	private List<WebElement> elements = mock(ArrayList.class);
	
	private static final By byId = By.id("fake");
	private static final String url = "http://fake.ru";
	
	private fakeDriver(){
		when(driver.findElement(byId)).thenReturn(element);
		when(driver.findElements(byId)).thenReturn(elements);
		when(driver.getCurrentUrl()).thenReturn(url);
		driver = new TracingFakeWebDriver(driver);
	}
	
	public static WebDriver getDriver(){
		return new fakeDriver().driver;
	}
	
	public static By getById(){
		return byId;
	}
	
	public static String getUrl(){
		return url;
	}
	
}
