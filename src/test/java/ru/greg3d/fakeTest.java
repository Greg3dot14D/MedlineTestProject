package ru.greg3d;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.greg3d.asserts.Assert;
import ru.greg3d.factory.fake.FakeSearchIcon;
import ru.greg3d.matchers.SortIconMatcher;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;

public class fakeTest {// extends TestBase{

	@Test
	public void test_searcIcon_isVisible() {
		assertThat(new FakeSearchIcon().getVisibleSearchIcon(), SortIconMatcher.isDisplayed());
	}

	@Test
	public void test_searcIcon_isNotVisible() {
		assertThat(new FakeSearchIcon().getInvisibleSearchIcon(), SortIconMatcher.isDisplayed());
	}

	@Test
	public void test_searcIcon_isSortAsc() {
		assertThat(new FakeSearchIcon().getSortAsc(), SortIconMatcher.sortIsAsc());
	}

	@Test
	public void test_searcIcon_isNotSortAsc() {
		assertThat(new FakeSearchIcon().getSortDesc(), SortIconMatcher.sortIsAsc());
	}

	@Test
	public void test_searcIcon_isSortDesc() {
		assertThat(new FakeSearchIcon().getSortDesc(), SortIconMatcher.sortIsDesc());
	}

	@Test
	public void test_searcIcon_isNotSortDesc() {
		assertThat(new FakeSearchIcon().getSortAsc(), SortIconMatcher.sortIsDesc());
	}

	@Test
	public void aTest_Fake() {
		Object[][] a = data1();
		Object[][] b = getObjectArray();

		System.out.println(a[0][0].toString());
		System.out.println(b[0][0].toString());
		return;
	}

	@Test
	public void Test_Fake() {
		Assert.assertTrue(false);
	}

	// @Test
	// public void TestTrack(){
	// app.getFakePageHelper().testTrack();
	// }

	// @Test
	// public void TestBlockTrack(){
	// app.getFakePageHelper().testBlockTrack();
	// }

	@Test(description = "data1", dataProvider = "dp")
	public void Test_DataProvider(String dataIn, String dataVerify) {
		System.out.println("DataIn :" + dataIn + " DateVerify :" + dataVerify);
		Assert.assertEquals("verify " + dataIn, dataVerify);
	}

	@DataProvider(name = "dp")
	private Object[][] testDataProvider(Method m) {

		String dataName = m.getAnnotation(Test.class).toString().split("description=")[1].split(",")[0];

		// return null;
		switch (dataName) {
		case "data1":
			return data1();
		case "data2":
			return data2();
		default:
			return null;
		}
	};

	private Object[][] data1() {
		return new Object[][] { { "01", "verify 01" }, { "02", "verify 02" }, { "03", "verify 03_" } };
	}

	private Object[][] data2() {
		return new Object[][] { { "data2 input", "data2 verify" } };
	}

	private List<String> getTestList() {
		List<String> list = new ArrayList<String>();

		list.add("01");
		list.add("02");
		list.add("03");

		return list;
	}

	private Object[][] getObjectArray() {
		return getTestList().stream().map(a -> new Object[] { a }).toArray(Object[][]::new);
	}

	@Test
	public void dateConvertTest() {
		List<String> dateList = new ArrayList<String>();

		dateList.add("08.04.2016 11:11:31");
		dateList.add("07.04.2016 12:11:32");
		dateList.add("01.05.2016 13:11:33");

		List<Date> sortedDateByStringList = dateList.stream().sorted((a, b) -> a.compareTo(b))
				.map(a -> convertToDate(a)).collect(toList());

		List<Date> sortedDateList = dateList.stream().map(a -> convertToDate(a)).sorted((a, b) -> a.compareTo(b))
				.collect(toList());

		Assert.assertEquals(sortedDateByStringList, sortedDateList);
	}

	private static Date convertToDate(String dateTimeString) {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		try {
			return format.parse(dateTimeString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
