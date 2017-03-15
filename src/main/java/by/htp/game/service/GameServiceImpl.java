package by.htp.game.service;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import by.htp.game.dao.DaoException;
import by.htp.game.dao.GameDaoImpl;

public class GameServiceImpl implements IGameService{

	private static final String PATH = "src/main/resources\\CityList.txt";
	
	private Set<String> cityList;
	private Set<String> cityPlayList;
	private char lastChar;
	private String currentCity;

	@Override
	public void playGame() {
		GameDaoImpl gameDao = new GameDaoImpl();
		try {
			cityList = gameDao.readCityList(PATH);
		} catch (DaoException e) {
			System.err.println("something wrong with file" + e);
		}
		cityPlayList = new LinkedHashSet<String>();
		boolean endGame = false;
		boolean inspWord = false;
		boolean opponentMove = false;
		System.out.println("---GAME <<Cities>>---");
		System.out.println("---You go first---");
		System.out.println("---Enter <<выход>> to complete the game---");
		Scanner sc = new Scanner(System.in);
		while (!endGame) {
			while (!inspWord) {
				System.out.println("Enter the name of a city: ");
				currentCity = sc.nextLine();
				if (currentCity.toLowerCase().equals("выход")) {
					System.out.println("You lose!");
					System.out.println("cities chain" + "\n" + cityPlayList);
					this.rememberCity(cityPlayList);
					break;
				} else {
					inspWord = GameLogic.inspectionWord(currentCity, cityPlayList, lastChar);
					if (inspWord == true) {
						System.out.println("Your city: --> " + currentCity);
					}
				}
			}
			if (currentCity.toLowerCase().equals("выход")) {
				endGame = true;
			} else {
				opponentMove = GameLogic.opponentMove(currentCity, cityList, cityPlayList);
				lastChar = GameLogic.getNormalLastChar((String) cityPlayList.toArray()[cityPlayList.size() - 1]);
				if (opponentMove == false) {
					System.out.println("You won!");
					System.out.println("cities chain" + "\n" + cityPlayList);
					this.rememberCity(cityPlayList);
					endGame = true;
				}
				inspWord = false;
				opponentMove = false;
			}
		}
	}

	private void rememberCity(Set<String> cityPlay) {
		if (cityPlay.size() > 0) {
			GameDaoImpl gameDao = new GameDaoImpl();
			Iterator<String> it = cityPlay.iterator();
			while (it.hasNext()) {
				String currentString = it.next();
				currentString = currentString.substring(0, 1).toUpperCase() + currentString.substring(1);
				if (!(cityList.contains(currentString))) {
					try {
						gameDao.addToFileCity(currentString,PATH);
					} catch (DaoException e) {
						System.err.println("something wrong with file" + e);
					}
				}
			}
		} else {
			System.out.println("no cities");
		}
	}
	
}
