import java.awt.Color;

/**
 * @author luke
 * Metody "tęczowe"
 */
public class Colors {
	public static Color mixColors2(Color c0, Color c1, float p) {
		while (p > 1.0f) {
			p -= 1.0f;
		}
		int red, green, blue;
		if (p < 0.5f) {
			red = (int) (c0.getRed() + c1.getRed() * p * 2);
			green = (int) (c0.getGreen() + c1.getGreen() * p * 2);
			blue = (int) (c0.getBlue() + c1.getBlue() * p * 2);
		} else {
			red = (int) (c0.getRed() * (1 - 2 * (p - 0.5f)) + c1.getRed());
			green = (int) (c0.getGreen() * (1 - 2 * (p - 0.5f)) + c1.getGreen());
			blue = (int) (c0.getBlue() * (1 - 2 * (p - 0.5f)) + c1.getBlue());
		}
		return new Color(red, green, blue);
	}

	public static Color getColor2(float x) {
		float p = x * 3.0f;
		if (x < 0.0f) {
			System.out.println("getColor2 error out of range _");
			return Color.black;
		} else if (x <= 1.0f / 3.0f) {
			return mixColors2(Color.red, Color.green, p);
		} else if (x <= 2.0f / 3.0f) {
			return mixColors2(Color.green, Color.blue, p);
		} else if (x < 1.0f) {
			return mixColors2(Color.blue, Color.red, p);
		} else {
			System.out.println("getColor2 error out of range ^");
			return Color.white;
		}
	}
}
