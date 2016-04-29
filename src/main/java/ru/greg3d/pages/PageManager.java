package ru.greg3d.pages;

//import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import ru.greg3d.yandex.corrected.qatools.htmlelements.loader.decorator.CorrectedHtmlElementDecorator;
import ru.greg3d.yandex.corrected.qatools.htmlelements.loader.decorator.CorrectedHtmlElementLocatorFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
//import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
//import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class PageManager {

	private WebDriver driver;

	public LoginPage loginPage;
	public DefaultPage defaultPage;
	public AllDocumentsPage allDocumentsPage;
	public FakePage fakePage;

	public PageManager(WebDriver driver) {
		this.driver = driver;
		loginPage = initHTMLElements(new LoginPage(this));
		//loginPage = initElements(new LoginPage(this));
		defaultPage = initHTMLElements(new DefaultPage(this));
		allDocumentsPage = initHTMLElements(new AllDocumentsPage(this));
		
		fakePage = initHTMLElements(new FakePage(this));
	}

//	private <T extends Page> T initElements(T page) {
//		//PageFactory.initElements(driver, page);
//		// PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), page);
//		PageFactory.initElements(new CorrectedFieldDecorator(driver), page);
//		return page;
//	}

	private <T extends Page> T initHTMLElements(T page) {
		
//		PageFactory.initElements(
    		  //new HtmlElementLocatorFactory(driver)), page);
                        //(SearchContext) new HtmlElementLocatorFactory(driver)), page);
                        //new HtmlElementLocatorFactory(driver), driver), page);
		PageFactory.initElements(
                new CorrectedHtmlElementDecorator(
                        new CorrectedHtmlElementLocatorFactory(driver), driver), page);
		return page;
	}	
	
	public WebDriver getWebDriver() {
		return driver;
	}

}
