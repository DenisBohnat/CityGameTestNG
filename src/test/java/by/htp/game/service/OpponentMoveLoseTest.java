package by.htp.game.service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpponentMoveLoseTest {

	private static Set<String> cityList;
	private static Set<String> cityPlayList;

	@DataProvider(name = "OpponentMove")
	public Object[][] createSomeData() {
		return new Object[][] { { "ясная поляна" }, { "Вологда" }, { "гомель" }, { "вологда" } };
	}

	@BeforeClass
	public static void initCitiesList() {
		cityList = new HashSet<String>();
		cityList.add("Анапа");
		cityList.add("Канск");
		cityList.add("Клецк");
		cityPlayList = new LinkedHashSet<String>();
		cityPlayList.add("анапа");
		cityPlayList.add("пинск");
		cityPlayList.add("минск");
		cityPlayList.add("гомель");
		cityPlayList.add("вологда");
	}

	@Test(dataProvider = "OpponentMove")
	public void testOpponentMoveLose(String city) {
		Assert.assertFalse(GameLogic.opponentMove(city, cityList, cityPlayList));
	}
}
