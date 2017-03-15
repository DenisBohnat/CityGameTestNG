package by.htp.game.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlayerMoveNotValideTest {

	private static Set<String> cityPlayList;

	@DataProvider(name = "PlayerMove")
	public Object[][] createSomeData() {
		return new Object[][] { { "гомель", 'г' }, { "Вологда", 'в' }, { "Зеленоградск", 'к' }, { "ивдель", 'л' },
				{ "Минск", 'и' } };
	}

	@BeforeClass
	public static void initCitiesList() {
		cityPlayList = new LinkedHashSet<String>();
		cityPlayList.add("анапа");
		cityPlayList.add("пинск");
		cityPlayList.add("минск");
		cityPlayList.add("гомель");
		cityPlayList.add("вологда");
	}

	@Test(dataProvider="PlayerMove")
	public void testPlayerMoveNotValide(String city, char firstChar) {
		Assert.assertFalse(GameLogic.inspectionWord(city, cityPlayList, firstChar));

	}
}
