package ru.greg3d.yandex.corrected.qatools.htmlelements.element;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.internal.WrapsElement;

import ru.yandex.qatools.htmlelements.element.Named;

public class HtmlElement implements WebElement, WrapsElement, Named, WrapsDriver {
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

    /**
     * Determines whether or not this element exists on page.
     *
     * @return True if the element exists on page, false otherwise.
     */
    @SuppressWarnings("squid:S1166")  // Sonar "Exception handlers should preserve the original exception" rule
    public boolean exists() {
        try {
            getWrappedElement().isDisplayed();
        } catch (NoSuchElementException ignored) {
            return false;
        }
        return true;
    }

    /**
     * Clicks this element. See {@link org.openqa.selenium.WebElement#click()} for more details.
     */
    @Override
    public void click() {
        wrappedElement.click();
    }

    /**
     * If this element is a form, or an element within a form, then this will submit this form to
     * the remote server. See {@link org.openqa.selenium.WebElement#submit()} for more details.
     */
    @Override
    public void submit() {
        wrappedElement.submit();
    }

    /**
     * Simulates typing into an element. See {@link WebElement#sendKeys(CharSequence...)} for more details.
     *
     * @param charSequences Symbols to be typed into an element.
     */
    @Override
    public void sendKeys(CharSequence... charSequences) {
        wrappedElement.sendKeys(charSequences);
    }

    /**
     * If this element is a text entry element, this will clear the value.
     * See {@link org.openqa.selenium.WebElement#clear()} for more details.
     */
    @Override
    public void clear() {
        wrappedElement.clear();
    }

    /**
     * Gets the tag name of this element. See {@link org.openqa.selenium.WebElement#getTagName()} for more details.
     *
     * @return The tag name of this element.
     */
    @Override
    public String getTagName() {
        return wrappedElement.getTagName();
    }

    /**
     * Gets the value of a the given attribute of the element. See {@link WebElement#getAttribute(String)}
     * for more details.
     *
     * @param name The name of the attribute.
     * @return Current value of the attribute or null if the value is not set.
     */
    @Override
    public String getAttribute(String name) {
        return wrappedElement.getAttribute(name);
    }

    /**
     * Indicates whether this element is selected or not. See {@link org.openqa.selenium.WebElement#isSelected()}
     * for more details.
     *
     * @return True if the element is currently selected or checked, false otherwise.
     */
    @Override
    public boolean isSelected() {
        return wrappedElement.isSelected();
    }

    /**
     * Indicates if the element is currently enabled or not. See {@link org.openqa.selenium.WebElement#isEnabled()}
     * for more details.
     *
     * @return True if the element is enabled, false otherwise.
     */
    @Override
    public boolean isEnabled() {
        return wrappedElement.isEnabled();
    }

    /**
     * Gets the visible inner text of this element. See {@link org.openqa.selenium.WebElement#getText()}
     * for more details.
     *
     * @return The inner text of this element.
     */
    @Override
    public String getText() {
        return wrappedElement.getText();
    }

    /**
     * Finds all elements within the current context using the given mechanism. See
     * {@link WebElement#findElements(org.openqa.selenium.By)} for more details.
     *
     * @param by The locating mechanism to use.
     * @return A list of all {@link WebElement}s, or an empty list if nothing matches.
     */
    @Override
    public List<WebElement> findElements(By by) {
        return wrappedElement.findElements(by);
    }

    /**
     * Find the first {@link WebElement} using the given mechanism. See
     * {@link WebElement#findElement(org.openqa.selenium.By)} for more details.
     *
     * @param by The locating mechanism.
     * @return The first matching element on the current context.
     * @throws org.openqa.selenium.NoSuchElementException If no matching elements are found.
     */
    @Override
    public WebElement findElement(By by) {
        return wrappedElement.findElement(by);
    }

    /**
     * Indicates if this element is displayed or not. See {@link org.openqa.selenium.WebElement#isDisplayed()}
     * for more details.
     *
     * @return True if the element is displayed, false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }

    /**
     * Gets position of the top left-hand corner of the rendered element on page.
     * See {@link org.openqa.selenium.WebElement#getLocation()} for more details.
     *
     * @return A point, containing the location of the top left-hand corner of the element
     */
    @Override
    public Point getLocation() {
        return wrappedElement.getLocation();
    }

    /**
     * Gets width and height of the rendered element. See {@link org.openqa.selenium.WebElement#getSize()}
     * for more details.
     *
     * @return The size of the element on the page.
     */
    @Override
    public Dimension getSize() {
        return wrappedElement.getSize();
    }

    /**
     * Gets the value of a given CSS property. See {@link WebElement#getCssValue(String)} for more details.
     *
     * @param name Name of the property.
     * @return The current, computed value of the property.
     */
    @Override
    public String getCssValue(String name) {
        return wrappedElement.getCssValue(name);
    }

    /**
     * Returns specified name, actually the same as {@link #getName()} method.
     *
     * @return {@code String} representing name.
     */
    @Override
    public String toString() {
        return name;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return wrappedElement.getScreenshotAs(outputType);
    }

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

}
