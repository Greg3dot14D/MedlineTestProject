/**
 * 
 */
/**
 * @author greg3d
 *
 */
package ru.greg3d.factory.dialogs;

import org.openqa.selenium.support.FindBy;

import ru.greg3d.yandex.corrected.qatools.htmlelements.element.MyHtmlElement;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class AbstractDialog extends MyHtmlElement{
	
	@FindBy(css=".ui-dialog-title")
	private TextBlock title;
	
	@FindBy(css=".ui-dialog-titlebar-close")
	private Button close;
	
	public String getTitle(){
		return this.title.getText();
	}
	
	public void close(){
		this.close.click();
	}
}