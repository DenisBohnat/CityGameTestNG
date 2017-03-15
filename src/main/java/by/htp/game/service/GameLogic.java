package by.htp.game.service;

import java.util.Iterator;
import java.util.Set;

public class GameLogic {

	public static char getNormalLastChar(String word) {
		int poss = word.length() - 1;
		boolean possState = false;
		while (!possState) {
			if ((word.toLowerCase().charAt(poss) == 'ь') || (word.toLowerCase().charAt(poss) == 'й')
					|| (word.toLowerCase().charAt(poss) == 'ы') || (word.toLowerCase().charAt(poss) == 'ъ')) {
				poss--;
			} else {
				possState = true;
			}
		}
		return word.toLowerCase().charAt(poss);
	}

	public static boolean inspectionWord(String word, Set<String> cityPlayList, char lastChar) {
		boolean inspWord = false;
		if (cityPlayList.size() > 0) {
			if (cityPlayList.contains(word.toLowerCase())) {
				inspWord = false;
				System.out.println("This word was entered earlier");
			} else {
				if (lastChar != word.toLowerCase().charAt(0)) {
					inspWord = false;
					System.out.println("The word must stert with the letter " + lastChar);
				} else {
					cityPlayList.add(word.toLowerCase());
					inspWord = true;
				}
			}
		} else {
			if (cityPlayList.size() == 0) {
				cityPlayList.add(word.toLowerCase());
				inspWord = true;
			}
		}
		return inspWord;
	}

	public static boolean opponentMove(String word, Set<String> cityList, Set<String> cityPlayList) {
		char lastChar = GameLogic.getNormalLastChar(word);
		boolean oppMove = false;
		Iterator<String> it = cityList.iterator();
		while (it.hasNext()) {
			String currentString = it.next();
			if ((currentString.toLowerCase().charAt(0) == lastChar)
					&& (!(cityPlayList.contains(currentString.toLowerCase())))) {
				cityPlayList.add(currentString.toLowerCase());
				System.out.println("Opponent city: --> " + currentString);
				lastChar = GameLogic.getNormalLastChar(currentString);
				oppMove = true;
				break;
			}
		}
		return oppMove;
	}
	
}
