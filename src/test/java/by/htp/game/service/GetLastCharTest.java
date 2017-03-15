package by.htp.game.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetLastCharTest {

	@DataProvider(name = "LastCharData")
	public Object[][] createSomeData() {
		return new Object[][] { { "Гомель", 'л' }, { "Гусь-Хрустальный", 'н' }, { "Зеленоградск", 'к' },
				{ "Ивдель", 'л' }, { "Ленинск- Кузнецкий", 'и' } };
	}

	@Test(dataProvider = "LastCharData")
	public void GetLastCharTest(String city, char lastChar) {
		char testChar;
		testChar = GameLogic.getNormalLastChar(city);
		Assert.assertEquals(testChar, lastChar);
	}
}
