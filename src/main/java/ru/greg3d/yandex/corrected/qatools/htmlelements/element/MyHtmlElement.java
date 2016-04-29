package ru.greg3d.yandex.corrected.qatools.htmlelements.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.internal.WrapsElement;

import ru.yandex.qatools.htmlelements.element.Named;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class MyHtmlElement extends  HtmlElement implements WebElement, WrapsElement, Named, WrapsDriver {
    private WebElement wrappedElement;
    private String name;
    private WebDriver wrappedDriver;

    public void setWrappedDriver(WebDriver wrappedDriver) {
        this.wrappedDriver = wrappedDriver;
    }    
    
	@Override
	public WebDriver getWrappedDriver() {
		return wrappedDriver;
	}
    
    @Override
    public WebElement getWrappedElement() {
        return wrappedElement;
    }

    /**
     * Sets the wrapped {@code WebElement}. This method is used by initialization mechanism and is not intended
     * to be used directly.
     *
     * @param wrappedElement {@code WebElement} to wrap.
     */
    public void setWrappedElement(WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets a name of a block. This method is used by initialization mechanism and is not intended
     * to be used directly.
     *
     * @param name Name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
