package by.htp.game.dao;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadCitiesTest {
	
	private static final String PATH = "src/test/resources\\CityListTest.txt";
	
	@Test
	public void testReadCollection() throws DaoException {
		GameDaoImpl gameDao = new GameDaoImpl();
		Assert.assertFalse(gameDao.readCityList(PATH).isEmpty());
	}
}
