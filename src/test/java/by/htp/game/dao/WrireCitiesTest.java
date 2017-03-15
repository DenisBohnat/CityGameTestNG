package by.htp.game.dao;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WrireCitiesTest {
	
	private static final String PATH = "src/test/resources\\CityListTest.txt";
	private String testWord="лос-анджелес";
	private int cityListSizeBefore;
	
	@BeforeMethod
	public void initCitiesList() throws DaoException {
		Set<String> cityList;
		GameDaoImpl gameDao = new GameDaoImpl();
		cityList = gameDao.readCityList(PATH);
		cityList.remove(testWord);
		cityListSizeBefore = cityList.size();
	}
	
	@Test
	public void testWriteWord() throws DaoException {
		GameDaoImpl gameDaoTest = new GameDaoImpl();
		gameDaoTest.addToFileCity(testWord,PATH);
		Set<String> cityListTest = gameDaoTest.readCityList(PATH);
		Assert.assertEquals(cityListTest.size(), cityListSizeBefore + 1);
	}
}
