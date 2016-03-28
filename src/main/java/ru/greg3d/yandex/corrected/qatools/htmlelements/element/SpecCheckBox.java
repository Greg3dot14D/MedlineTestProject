package ru.greg3d.yandex.corrected.qatools.htmlelements.element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.htmlelements.element.TypifiedElement;

/**
 * Represents web page checkbox control.
 *
 * @author Artem Koshelev artkoshelev@yandex-team.ru
 * @author Alexander Tolmachev starlight@yandex-team.ru
 */
public class SpecCheckBox extends TypifiedElement {
    /**
     * Specifies wrapped {@link WebElement}.
     *
     * @param wrappedElement {@code WebElement} to wrap.
     */
    public SpecCheckBox(WebElement wrappedElement) {
        super(wrappedElement);
    }

    /**
     * Finds label corresponding to this checkbox using "following-sibling::label" xpath.
     *
     * @return {@code WebElement} representing label or {@code null} if no label has been found.
     */
    public WebElement getLabel() {
        try {
            return getWrappedElement().findElement(By.xpath("following-sibling::label"));
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * Finds a text of the checkbox label.
     *
     * @return Label text or {@code null} if no label has been found.
     */
    public String getLabelText() {
        WebElement label = getLabel();
        return label == null ? null : label.getText();
    }

    /**
     * The same as {@link #getLabelText()}.
     *
     * @return Text of the checkbox label or {@code null} if no label has been found.
     */
    public String getText() {
        return getLabelText();
    }

    /**
     * Selects checkbox if it is not already selected.
     */
    public void select() {
        if (!isSelected()) {
            //getWrappedElement().click();
        	getWrappedElement().findElement(By.xpath("../span")).click();
        }
    }
    
    /**
     * Deselects checkbox if it is not already deselected.
     */
    public void deselect() {
        if (isSelected()) {
            //getWrappedElement().click();
        	getWrappedElement().findElement(By.xpath("../span")).click();
        }
    }

    public void cheatSelect(){
        if (!isSelected())
            this.cheatClick();
    }
    
    public void cheatDeselect(){
        if (isSelected())
            this.cheatClick();
    }    
    
    private void cheatClick(){
    	((JavascriptExecutor)getWrappedElement()).executeScript("document.getElementById('inout_all').parentNode.getElementsByTagName('span').click();");
    }    
    
    
    /**
     * Selects checkbox if passed value is {@code true} and deselects otherwise.
     */
    public void set(boolean value) {
        if (value) {
            select();
        } else {
            deselect();
        }
    }

    /**
     * Indicates whether checkbox is selected.
     */
    public boolean isSelected() {
        return getWrappedElement().isSelected();
    }
}
