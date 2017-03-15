package by.htp.game.dao;

import java.util.Set;

public interface IGameDao {

	Set<String> readCityList(String path) throws DaoException;

	void addToFileCity(String word,String path) throws DaoException;
}
