package by.htp.game.service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpponentMoveTest {

	private static Set<String> cityList;
	private static Set<String> cityPlayList;

	@DataProvider(name = "OpponentMove")
	public Object[][] createSomeData() {
		return new Object[][] { { "ясная поляна" }, { "Вологда" }, { "Зеленоградск" }, { "ивдель" }, { "Полоцк" } };
	}

	@BeforeClass
	public static void initCitiesList() {
		cityList = new HashSet<String>();
		cityList.add("Анапа");
		cityList.add("Ангарск");
		cityList.add("Арзамас");
		cityList.add("Канск");
		cityList.add("Лепель");
		cityList.add("Клецк");
		cityPlayList = new LinkedHashSet<String>();
		cityPlayList.add("анапа");
		cityPlayList.add("пинск");
		cityPlayList.add("минск");
		cityPlayList.add("гомель");
		cityPlayList.add("вологда");
	}

	@Test(dataProvider="OpponentMove")
	public void testOpponentMoveValide(String city) {
		Assert.assertTrue(GameLogic.opponentMove(city, cityList, cityPlayList));
	}
}
