package ru.greg3d.yandex.corrected.qatools.htmlelements.loader.decorator;

import static ru.yandex.qatools.htmlelements.utils.HtmlElementUtils.getGenericParameterClass;
import static ru.yandex.qatools.htmlelements.utils.HtmlElementUtils.isHtmlElement;
import static ru.yandex.qatools.htmlelements.utils.HtmlElementUtils.isHtmlElementList;
import static ru.yandex.qatools.htmlelements.utils.HtmlElementUtils.isTypifiedElement;
import static ru.yandex.qatools.htmlelements.utils.HtmlElementUtils.isTypifiedElementList;

import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import ru.greg3d.factory.fielddecorator.CorrectedAnnotations;
import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;

public class CorrectedHtmlElementFieldAnnotationsHandler extends CorrectedAnnotations{
    public CorrectedHtmlElementFieldAnnotationsHandler(Field field, LocatorCorrector corrector) {
        super(field, corrector);
    }

    @Override
    public By buildBy() {
        if (isHtmlElement(getField()) || isTypifiedElement(getField())) {
            return buildByFromHtmlElementAnnotations();
        }
        if (isHtmlElementList(getField()) || isTypifiedElementList(getField())) {
            return buildByFromHtmlElementListAnnotations();
        }
        return super.buildBy();
    }

    private By buildByFromFindAnnotations() {
        if (getField().isAnnotationPresent(FindBys.class)) {
            FindBys findBys = getField().getAnnotation(FindBys.class);
            return buildByFromFindBys(findBys);
        }

        if (getField().isAnnotationPresent(FindAll.class)) {
            FindAll findBys = getField().getAnnotation(FindAll.class);
            return buildBysFromFindByOneOf(findBys);
        }

        if (getField().isAnnotationPresent(FindBy.class)) {
            FindBy findBy = getField().getAnnotation(FindBy.class);
            return buildByFromFindBy(findBy);
        }
        return null;
    }

    private By buildByFromHtmlElementAnnotations() {
        assertValidAnnotations();

        By result = buildByFromFindAnnotations();
        if (result != null) {
            return result;
        }

        Class<?> fieldClass = getField().getType();
        while (fieldClass != Object.class) {
            if (fieldClass.isAnnotationPresent(FindBy.class)) {
                return buildByFromFindBy(fieldClass.getAnnotation(FindBy.class));
            }
            fieldClass = fieldClass.getSuperclass();
        }

        return buildByFromDefault();
    }

    private By buildByFromHtmlElementListAnnotations() {
        assertValidAnnotations();

        By result = buildByFromFindAnnotations();
        if (result != null) {
            return result;
        }

        Class<?> listParameterClass = getGenericParameterClass(getField());
        while (listParameterClass != Object.class) {
            if (listParameterClass.isAnnotationPresent(FindBy.class)) {
                return buildByFromFindBy(listParameterClass.getAnnotation(FindBy.class));
            }
            listParameterClass = listParameterClass.getSuperclass();
        }

        throw new HtmlElementsException(String.format("Cannot determine how to locate element %s", getField()));
    }
}
