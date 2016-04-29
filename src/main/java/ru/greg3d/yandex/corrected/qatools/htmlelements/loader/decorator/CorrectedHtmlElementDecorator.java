package ru.greg3d.yandex.corrected.qatools.htmlelements.loader.decorator;

import static ru.greg3d.yandex.correcred.qatools.htmlelements.loader.CorrectedHtmlElementLoader.createHtmlElement;
import static ru.yandex.qatools.htmlelements.utils.HtmlElementUtils.getElementName;
//import static ru.yandex.qatools.htmlelements.utils.HtmlElementUtils.isHtmlElement;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;
import ru.greg3d.yandex.corrected.qatools.htmlelements.element.MyHtmlElement;
//import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.pagefactory.CustomElementLocatorFactory;

public class CorrectedHtmlElementDecorator extends HtmlElementDecorator {

	private WebDriver driverToWrap;
	private LocatorCorrector corrector;
	
	public CorrectedHtmlElementDecorator(CustomElementLocatorFactory factory, WebDriver driver) {
		super(factory);
		this.factory = factory;
		this.driverToWrap = driver;
	}

	public CorrectedHtmlElementDecorator(CustomElementLocatorFactory factory, WebDriver driver,
			LocatorCorrector corrector) {
		super(factory);
		this.corrector = corrector;
		this.driverToWrap = driver;
	}

	@Override
	public Object decorate(ClassLoader loader, Field field) {
		if (isMyHtmlElement(field)) {
			return correceteDecorateHtmlElement(loader, field);
		}
		else
			return super.decorate(loader,field);
	}	

    public static boolean isMyHtmlElement(Field field) {
        return isMyHtmlElement(field.getType());
    }

    public static boolean isMyHtmlElement(Class<?> clazz) {
        return MyHtmlElement.class.isAssignableFrom(clazz);
    }

    public static <T> boolean isMyHtmlElement(T instance) {
        return MyHtmlElement.class.isInstance(instance);
    }	
	
	
	protected <T extends MyHtmlElement> T correceteDecorateHtmlElement(ClassLoader loader, Field field) {
		WebElement elementToWrap = decorateWebElement(loader, field);

		final LocatorCorrector corrector = new LocatorCorrector().setWhat(field.getType()).setThan(field);
		return createHtmlElement((Class<T>) field.getType(), driverToWrap, elementToWrap, getElementName(field),
				corrector);
	}
}
