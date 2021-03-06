package ru.greg3d.yandex.corrected.qatools.htmlelements.loader.decorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.internal.WrapsElement;

import ru.greg3d.yandex.corrected.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Contains factory methods for creating proxy of blocks, typified elements, page objects
 */
@SuppressWarnings("unchecked")
public class CorrectedProxyFactory {
    public static <T extends WebElement> T createWebElementProxy(ClassLoader loader, InvocationHandler handler) {
    	Class<?>[] interfaces = new Class[]{WebElement.class, WrapsElement.class, Locatable.class, WrapsDriver.class};
        return (T) Proxy.newProxyInstance(loader, interfaces, handler);
    }

    public static <T extends WebElement> List<T> createWebElementListProxy(ClassLoader loader,
                                                                           InvocationHandler handler) {
        return (List<T>) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
    }

    public static <T extends TypifiedElement> List<T> createTypifiedElementListProxy(ClassLoader loader,
                                                                                     InvocationHandler handler) {
        return (List<T>) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
    }

    public static <T extends MyHtmlElement> List<T> createHtmlElementListProxy(ClassLoader loader,
                                                                             InvocationHandler handler) {
        return (List<T>) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
    }
}
