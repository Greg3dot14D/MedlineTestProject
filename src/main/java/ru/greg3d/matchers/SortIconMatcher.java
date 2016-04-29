package ru.greg3d.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SortIconMatcher extends TypeSafeMatcher<WebElement> {

	private String description;
	private String but;
	//private String expected;
	private int expectedValue = 0;

	public SortIconMatcher() {
		// TODO Auto-generated constructor stub
		this.description = "SortIcon is Visible";
		this.but = "SortIcon Visibility is ";
		//this.expected = " expected true";
		this.expectedValue = 0;
	}

	public SortIconMatcher(boolean isAsc) {
		// TODO Auto-generated constructor stub
		if(isAsc){
			this.description = "Sort by Asc";
			this.expectedValue = 1;
		}else{
			this.description = "Sort by Desc";
			this.expectedValue = 2;
		}
		//this.expectedValue = (isAsc ? 1 : 2);
	}

	public void describeTo(Description description) {
		// TODO Auto-generated method stub
		description.appendText(this.description);
	}

	@Override
	protected boolean matchesSafely(WebElement sortIcon) {
		// TODO Auto-generated method stub
		if(!sortIcon.isDisplayed()){
			this.but = "SortIcon is not visible";
			return false;
		}
		
		switch (expectedValue) {
		case 0:
			return sortIcon.isDisplayed();
		case 1:
				this.but = "найден значек сортировки по убыванию";
				return sortIcon.findElements(By.cssSelector(".ui-icon-desc.ui-state-disabled")).size() == 1;
		default:
				this.but = "найден значек сортировки по возрастанию";
				return sortIcon.findElements(By.cssSelector(".ui-icon-asc.ui-state-disabled")).size() == 1;
		}
	}

	@Override
	public void describeMismatchSafely(WebElement sortIcon, Description mismatchDescription) {
		switch (expectedValue) {
		case 0:
			mismatchDescription.appendText(this.but).appendValue(sortIcon.isDisplayed());
			break;
		default:
			mismatchDescription.appendText(this.but);
			break;
		}
	}

	@Factory
	public static Matcher<WebElement> isDisplayed() {
		return new SortIconMatcher();
	}

	@Factory
	public static Matcher<WebElement> sortIsAsc() {
		return new SortIconMatcher(true);
	}

	@Factory
	public static Matcher<WebElement> sortIsDesc() {
		return new SortIconMatcher(false);
	}

}
