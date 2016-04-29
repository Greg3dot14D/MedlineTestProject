package ru.greg3d.yandex.corrected.qatools.htmlelements.loader.decorator;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class CorrectedHtmlElementLocatorFactory extends HtmlElementLocatorFactory{
	private LocatorCorrector corrector;
	private SearchContext searchContext;
	
	public CorrectedHtmlElementLocatorFactory(SearchContext searchContext) {
		super(searchContext);
		this.corrector = new LocatorCorrector();
		this.searchContext = searchContext;
	}	
	
	public CorrectedHtmlElementLocatorFactory(SearchContext searchContext, LocatorCorrector corrector) {
		super(searchContext);
		this.corrector = corrector;
		this.searchContext = searchContext;
	}
	
	public ElementLocator createLocator(Field field) {
		return new AjaxElementLocator(searchContext, getTimeOut(field), new CorrectedHtmlElementFieldAnnotationsHandler(field, corrector));
	}

}
