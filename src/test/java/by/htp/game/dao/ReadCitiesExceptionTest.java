package by.htp.game.dao;

import org.testng.annotations.Test;

public class ReadCitiesExceptionTest {
	
	private String path = "src/test/resources\\CityNotExist.txt";
	
	
	@Test(expectedExceptions=DaoException.class)
	public void testReadException() throws DaoException {
		GameDaoImpl gameDao = new GameDaoImpl();
		gameDao.readCityList(path);
 	}
}
