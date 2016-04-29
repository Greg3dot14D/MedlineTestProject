package ru.greg3d.factory.htmlelements;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.greg3d.factory.fielddecorator.model.Corrector;
import ru.greg3d.yandex.corrected.qatools.htmlelements.element.MyHtmlElement;
import ru.yandex.qatools.htmlelements.element.Table;

@Corrector(what = "XXX")
public class Grid extends MyHtmlElement {

	@FindBy(xpath = "//table[@class='ui-jqgrid-htable' and @aria-labelledby='gbox_XXXGrid']/thead/tr[1]")
	private Table headerList;

	@FindBy(xpath = "//table[@class='ui-jqgrid-htable' and @aria-labelledby='gbox_XXXGrid']/thead/tr[2]")
	private Table searchList;

	@FindBy(xpath = "//table[@id='XXXGrid']/tbody")
	private Table table;

	public boolean searchIsActive() {
		return searchList.isDisplayed();
	}

	public String getCellAt(int rowIndex, String headerTitle) {
		return table.getCellAt(rowIndex, getHeaderIndex(headerTitle)).getText();
	}

	//
	// возвращает WebElement - иконку сортировки в колонке
	//
	public WebElement getHeaderSortIcon(String headerTitle) {
		return headerList.getHeadings().get(getHeaderIndex(headerTitle)).findElement(By.cssSelector(".s-ico"));
	}

	//
	// Возвращает список значений таблицы (в текстовом виде) для колонки с
	// заголовком headerTitle
	//
	public List<String> getColumnByHeader(String headerTitle) {
		int index = getHeaderIndex(headerTitle) + 1;
		// table.getColumnByIndex(index).stream().skip(1).forEach(e->
		// System.out.println("e :" + e.getText()));
		return table.getColumnByIndex(index).stream().skip(1).map(WebElement::getText).collect(toList());
	}

	//
	// Возвращает список значений таблицы (в текстовом виде) для колонки с
	// индексом index
	//
	public List<String> getColumnByIndex(int index) {
		return table.getColumnByIndex(index).stream().skip(1).map(WebElement::getText).collect(toList());
	}

	//
	// функция проверяет, что listToTest отсортирован по возрастанию (если
	// sortIsAsc = true) и по убыванию (если sortIsAsc = false)
	//
	private boolean verifySort(List<String> listToTest, boolean sortIsAsc) {
		List<String> etalonList = (sortIsAsc ? listToTest.stream().sorted((a, b) -> a.compareTo(b)).collect(toList())
				: listToTest.stream().sorted((b, a) -> a.compareTo(b)).collect(toList()));

		if (!listToTest.equals(etalonList)) {
			System.out.println("lists are not equals");

			for (int index = 0; index < listToTest.size(); index++) {
				System.out.println("testValue :" + listToTest.get(index) + " etalonValue :" + etalonList.get(index));
				Assert.assertEquals(listToTest.get(index), etalonList.get(index));
				if (!listToTest.get(index).equals(etalonList.get(index)))
					return false;
			}
		}
		return true;
	}

	//
	// Проверка сортировки колонки по возрастанию
	//
	public boolean verifySortAsc(String headerTitle) {
		return verifySort(this.getColumnByHeader(headerTitle), true);
	}

	//
	// Проверка сортировки колонки по убыванию
	//
	public boolean verifySortDesc(String headerTitle) {
		return verifySort(this.getColumnByHeader(headerTitle), false);
	}

	//
	// Получаем Index колонки
	//
	public int getHeaderIndex(String headerTitle) {
		for (int index = 0; index < headerList.getHeadings().size(); index++) {
			if (headerList.getHeadings().get(index).getText().equals(headerTitle))
				return index;
		}
		return -1;
	}

	//
	// Получаем список видимых колонок
	//
	public List<String> getHeaderTitleList() {
		return headerList.getHeadings().stream()
				.filter(a -> a.isDisplayed())
				.map(WebElement::getText)
				.collect(toList());
	}

	public void clickHeader(int index) {
		headerList.getHeadings().get(index).click();
	}

	public void clickHeader(String headerTitle) {
		headerList.getHeadings()
				.get(getHeaderIndex(headerTitle))
				.click();
	}

	//
	// Значек сортировки для колонки headerTitle видимый (сортировка применена)
	//
	public boolean sortIconIsDisplayed(String headerTitle) {
		return headerList.getHeadings().stream()
				.filter(a -> a.getText().equals(headerTitle)
						&& a.findElement(By.cssSelector(".s-ico")).isDisplayed())
				.count() == 1;
	}

	//
	// Колонка headerTitle отсортирована по возрастанию
	//
	public boolean sortIsAsc(String headerTitle) {
		return headerList.getHeadings().stream()
				.filter(a -> a.getText().equals(headerTitle)
						&& a.findElement(By.cssSelector(".s-ico")).isDisplayed()
						&& a.findElements(By.cssSelector(".ui-icon-desc.ui-state-disabled")).size() == 1)
				.count() == 1;
	}

	//
	// Колонка headerTitle отсортирована по убыванию
	//
	public boolean sortIsDesc(String headerTitle) {
		return headerList.getHeadings().stream()
				.filter(a -> a.getText().equals(headerTitle)
						&& a.findElement(By.cssSelector(".s-ico")).isDisplayed()
						&& a.findElements(By.cssSelector(".ui-icon-asc.ui-state-disabled")).size() == 1)
				.count() == 1;
	}

}
