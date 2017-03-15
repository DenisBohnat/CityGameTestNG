package by.htp.game.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlayerMoveValideTest {

	private static Set<String> cityPlayList;

	@BeforeClass
	public static void initCitiesList() {
		cityPlayList = new LinkedHashSet<String>();
		cityPlayList.add("анапа");
		cityPlayList.add("пинск");
		cityPlayList.add("минск");
		cityPlayList.add("гомель");
		cityPlayList.add("вологда");
	}

	@Test
	public void testPlayerMoveValide() {
		boolean insFlag = GameLogic.inspectionWord("Молодечно", cityPlayList, 'м');
		Assert.assertTrue(insFlag);
	}

	@Test
	public void testCitiesChainMove() {
		int sizeList = cityPlayList.size();
		Assert.assertTrue(GameLogic.inspectionWord("брест", cityPlayList, 'б'));
		Assert.assertEquals(cityPlayList.size(), sizeList + 1);
	}

}
