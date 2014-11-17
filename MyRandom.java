import java.util.Random;

/**
 * @author luke
 * Zawiera funkcję do generacji losowego znaku.
 */
public class MyRandom {

	public static char lastChar;

	public static int random(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	public static float getRandomSign() {
		Random random = new Random();
		if (random.nextFloat() > 0.5f) {
			return 1.0f;
		} else {
			return -1.0f;
		}
	}

	public static char[] getRandomChar() {
		char c[] = new char[1];
		c[0] = (char) random(97, 122); // od a do z
		lastChar = c[0];
		return c;
	}
}
