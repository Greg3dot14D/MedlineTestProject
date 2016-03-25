package ru.greg3d.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.*;

public class LoginPage extends AnyPage{
	
	@FindBy(id="UserName")
	TextInput userInput;
	
	@FindBy(id="Password")
	TextInput passwordInput;
	
	@FindBy(id="btn_GO")
	Button okButton;

	@FindBy(id="RememberMe")
	HtmlElement rememberMe;
	
	public void clickRememberMe(){
		//System.out.println("driver = " + rememberMe.getWrappedDriver());
	}
	
    // error_text	
    //string error_text { get { return new WebElement().FindByXpath("//form[@class='form-horizontal']//div[@class='validation-summary-errors error-text']").Text; } }
	@FindBy(css=".validation-summary-errors.error-text")
	TextBlock errorMessage;
	
	public LoginPage(PageManager pages) {
		super(pages);
	}

	public LoginPage setUser(String text){
		this.userInput.clear();
		this.userInput.sendKeys(text);
		return this;
	}
	
	public LoginPage setPassword(String text){
		this.passwordInput.clear();
		this.passwordInput.sendKeys(text);
		return this;
	}	
	
	public LoginPage clickOk(){
		this.okButton.click();
		return this;
	}	
	
	public boolean errorMessageIxExist(){
		return this.errorMessage.exists();
	}		
	
}
