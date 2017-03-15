package by.htp.game.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstMoveTest {

	private static char lastChar;
	private static Set<String> cityPlayList;

	@BeforeMethod
	public static void initCitiesList() {
		lastChar = ' ';
		cityPlayList = new LinkedHashSet<String>();
	}

	@Test
	public void testPlayerFirstMove() {
		Assert.assertTrue(GameLogic.inspectionWord("Новополоцк", cityPlayList, lastChar));
		Assert.assertEquals(cityPlayList.size(), 1);
	}
}
