package ru.greg3d.yandex.correcred.qatools.htmlelements.loader;

import static ru.yandex.qatools.htmlelements.utils.HtmlElementUtils.newInstance;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;
//import ru.greg3d.yandex.corrected.qatools.htmlelements.element.HtmlElement;
import ru.greg3d.yandex.corrected.qatools.htmlelements.loader.decorator.CorrectedHtmlElementDecorator;
import ru.greg3d.yandex.corrected.qatools.htmlelements.loader.decorator.CorrectedHtmlElementLocatorFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.pagefactory.CustomElementLocatorFactory;

public class CorrectedHtmlElementLoader extends HtmlElementLoader {

	public static void populatePageObject(Object page, CustomElementLocatorFactory locatorFactory) {
		PageFactory.initElements(
				new CorrectedHtmlElementDecorator(locatorFactory, ((HtmlElement) page).getWrappedDriver()), page);
	}

	public static void populatePageObject(Object page, SearchContext searchContext, LocatorCorrector corrector) {
		populatePageObject(page, new CorrectedHtmlElementLocatorFactory(searchContext, corrector));
	}
	
	public static <T extends HtmlElement> T createHtmlElement(Class<T> elementClass, WebDriver driverToWrap,
			WebElement elementToWrap, String name, LocatorCorrector corrector) {
		try {
			T instance = newInstance(elementClass);
			instance.setWrappedElement(elementToWrap);
			instance.setName(name);
			instance.setWrappedDriver(driverToWrap);
			// Recursively initialize elements of the block
			populatePageObject(instance, elementToWrap, corrector);
			return instance;
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException
				| InvocationTargetException e) {
			throw new HtmlElementsException(e);
		}
	}	
}
